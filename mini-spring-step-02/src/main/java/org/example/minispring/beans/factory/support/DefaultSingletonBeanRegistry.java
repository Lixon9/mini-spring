package org.example.minispring.beans.factory.support;

import org.example.minispring.beans.factory.config.ISingletonBeanMaker;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lks
 */
public class DefaultSingletonBeanRegistry implements ISingletonBeanMaker {

    private final Map<String,Object> singletonObjectsMap = new HashMap<>();

    protected void addSingletonBean(String beanName,Object singletonBean){
        singletonObjectsMap.put(beanName,singletonBean);
    }


    @Override
    public Object getSingleton(String beanName) {
        return singletonObjectsMap.get(beanName);
    }
}
