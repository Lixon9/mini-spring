package org.example.minispring.beans.factory;

import org.example.minispring.beans.factory.bean.BeanDefinition;
import org.example.minispring.beans.factory.singleton.DefaultSingletonBeanRegistry;

import java.lang.reflect.InvocationTargetException;

/**
 * @author lks
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements IBeanFactory{

    protected abstract BeanDefinition getBeanDefinition(String beanName);

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException ;

    @Override
    public Object getBean(String beanName) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        return doGetBean(beanName,null);
    }

    @Override
    public Object getBean(String beanName, Object... args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        return doGetBean(beanName,args);
    }

    protected <T> T doGetBean(final String name, final Object[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Object singleton = getSingleton(name);
        if (singleton != null) {
            return (T) singleton;
        }
        BeanDefinition beanDefinition = getBeanDefinition(name);
        return (T) createBean(name,beanDefinition,args);
    }
}
