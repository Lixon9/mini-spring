package org.example.minispring.beans.factory.singleton;

/**
 * @author lks
 */
public interface ISingletonBeanRegistry {

    Object getSingleton(String beanName);
}
