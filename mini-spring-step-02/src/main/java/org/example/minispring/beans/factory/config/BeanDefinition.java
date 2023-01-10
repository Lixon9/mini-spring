package org.example.minispring.beans.factory.config;

/**
 * @author Administrator
 */
//@SuppressWarnings({"rawtypes"})
public class BeanDefinition {

    private Class<?> beanClass;

    public Class<?> getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class<?> beanClass) {
        this.beanClass = beanClass;
    }

    public BeanDefinition(Class<?> beanClass) {
        this.beanClass = beanClass;
    }
}
