package org.example.minispring.beans.factory.registry;

/**
 * @author Administrator
 *
 * 注册接口 提供复用
 */
public interface ISingletonBeanRegistry {

    /** 获取单例bean
     * @param beanName beanName
     * @return bean对象
     */
    Object getSingleton (String beanName);
}
