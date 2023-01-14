package org.example.minispring.beans.factory.singleton;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lks
 */
public class DefaultSingletonBeanRegistry implements ISingletonBeanRegistry{

    private final Map<String,Object> map = new HashMap<>();

    protected void addSingleton(String singletonName, Object object) {
        map.put(singletonName,object);

    }

    @Override
    public Object getSingleton(String beanName) {
        return map.get(beanName);
    }
}
