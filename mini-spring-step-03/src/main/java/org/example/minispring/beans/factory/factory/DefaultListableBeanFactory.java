package org.example.minispring.beans.factory.factory;

import org.apache.commons.lang3.StringUtils;
import org.example.minispring.beans.factory.bean.BeanDefinition;
import org.example.minispring.beans.factory.exception.BeansException;
import org.example.minispring.beans.factory.singleton.BeanDefinitionRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lks
 */
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry {

    private final Map<String,BeanDefinition> beanDefinitionMap = new HashMap<>();
    /**
     * @param beanName bean名
     * @return bean
     */
    @Override
    protected BeanDefinition getBeanDefinition(String beanName) {
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if (beanDefinition == null) {
            throw new BeansException(beanName+"未被定义");
        }
        return beanDefinition;
    }

    /**
     * @param beanName
     * @param beanDefinition
     */
    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        if (StringUtils.isBlank(beanName)) {
          throw new BeansException("beanName 不符合规范")  ;
        }
        beanDefinitionMap.put(beanName,beanDefinition);
    }
}
