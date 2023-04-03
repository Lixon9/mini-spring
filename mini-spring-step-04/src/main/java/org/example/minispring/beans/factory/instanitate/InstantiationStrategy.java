package org.example.minispring.beans.factory.instanitate;

import org.example.minispring.beans.factory.bean.BeanDefinition;
import org.example.minispring.beans.factory.exception.BeansException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author lks
 */
public interface InstantiationStrategy {

    /**
     * 实例化bean
     * @param beanDefinition 定义的bean
     * @param beanName bean名称
     * @param constructor 构造器
     * @param args 对象数组
     * @return 实例
     * @throws BeansException 自定义异常
     */
    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor<?> constructor,Object[] args) throws BeansException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException;
}
