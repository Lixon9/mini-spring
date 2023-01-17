package org.example.minispring.beans.factory.singleton;

import org.example.minispring.beans.factory.bean.BeanDefinition;

/**
 * @author lks
 */
public interface BeanDefinitionRegistry {

    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
