package org.example.minispring.beans.factory.config;

/**
 * @author Administrator
 */
public interface ISingletonBeanMaker {

    /** 获取单例bean
     * @param beanName beanName
     * @return bean对象
     */
    Object getSingleton (String beanName);
}
