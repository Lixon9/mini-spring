package org.example.minispring.beans.factory.support;

import org.example.minispring.beans.factory.bean.BeanDefinition;
import org.example.minispring.beans.factory.exception.BeansException;

/**
 * @author lks
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory{
    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) {
        Object newInstance;
        try {
             newInstance = beanDefinition.getBeanClass().newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new BeansException("实例化失败",e);
        }
        // 初始化创建完并缓存
        addSingletonBean(beanName,newInstance);
        return newInstance;
    }
}
