package org.example.minispring.beans.factory.factory;

import org.example.minispring.beans.factory.bean.BeanDefinition;

/**
 * @author lks
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory{
    /**
     * @param beanName
     * @param beanDefinition
     * @param args
     * @return
     */
    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) {
        return null;
    }



}
