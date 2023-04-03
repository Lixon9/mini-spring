package org.example.minispring.beans.factory;

import org.example.minispring.beans.factory.bean.BeanDefinition;
import org.example.minispring.beans.factory.instantiate.CglibSubclassingInstantiationStrategy;
import org.example.minispring.beans.factory.instantiate.InstantiationStrategy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author lks
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {



    private  InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();

    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }

    protected Object createBeanInstance(BeanDefinition beanDefinition,String beanName,Object[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        // 1 定义构造器引用、获取beanClass、获取beanClass所有声明的构造器
        Constructor<?> constructorToUse = null;
        Class<?> beanClass = beanDefinition.getBeanClass();
        Constructor<?>[] declaredConstructors = beanClass.getDeclaredConstructors();

        // 2 对所有类型构造器进行遍历，并对参数类型进行判断，并获取所需的参数构造器
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            if (null!= args && declaredConstructor.getParameterTypes().length == args.length) {
                constructorToUse = declaredConstructor;
                break;
            }
        }

        // 3 调用函数并其实例化并返回
        return getInstantiationStrategy().instantiate(beanDefinition,beanName,constructorToUse,args);
    }
    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Object bean;
        bean = createBeanInstance(beanDefinition, beanName, args);
        addSingleton(beanName,bean);
        return bean;
    }



}
