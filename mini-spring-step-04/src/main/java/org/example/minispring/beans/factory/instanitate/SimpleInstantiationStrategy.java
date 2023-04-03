package org.example.minispring.beans.factory.instanitate;

import org.example.minispring.beans.factory.bean.BeanDefinition;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author lks
 */
public class SimpleInstantiationStrategy implements InstantiationStrategy{

    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor<?> constructor, Object[] args) {

        Class<?> beanClass = beanDefinition.getBeanClass();
        try {
            if (constructor != null) {
                return beanClass.getDeclaredConstructor(constructor.getParameterTypes()).newInstance(args);
            }else {
                return beanClass.getDeclaredConstructor().newInstance();
            }
        } catch (InstantiationException | InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
            throw new RuntimeException("实例化失败 ["+beanClass.getName() + "]",e);
        }
    }
}
