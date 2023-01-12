package org.example.beans.factory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Administrator
 */
public class BeanFactory {

    private final Map<String,BeanDefinition>  beanDefinitionMap = new ConcurrentHashMap<>();

    public void registerBeanDefinition(String beanName ,BeanDefinition beanDefinition){

        beanDefinitionMap.put(beanName,beanDefinition);
    }

    public Object getBean(String beanName){
        return beanDefinitionMap.get(beanName).getBean();
    }


}
