package org.example.minispring.beans.factory.support;

import org.example.minispring.beans.factory.bean.BeanDefinition;
import org.example.minispring.beans.factory.registry.IBeanDefinitionRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lks
 */
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements IBeanDefinitionRegistry {

    private final Map<String,BeanDefinition> stringBeanDefinitionMap = new HashMap<>();
    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        stringBeanDefinitionMap.put(beanName,beanDefinition);
    }

    @Override
    protected BeanDefinition getBeanDefinition(String beanName) {
        BeanDefinition beanDefinition = stringBeanDefinitionMap.get(beanName);
        if (beanDefinition == null) {
            throw new RuntimeException("这个bean"+beanName+"没有被定义");
        }
        return beanDefinition;

    }
}
