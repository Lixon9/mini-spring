package org.example.minispring.beans.factory.config;

import org.example.minispring.beans.factory.config.BeanDefinition;

/**
 * @author lks
 */
public interface IBeanDefinitionRegistry {

    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
