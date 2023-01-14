package org.example.minispring.beans.factory.factory;

import org.example.minispring.beans.factory.bean.BeanDefinition;
import org.example.minispring.beans.factory.singleton.DefaultSingletonBeanRegistry;

/**
 * @author lks
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements IBeanFactory {

    protected abstract BeanDefinition getBeanDefinition(String beanName);

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args);

    @Override
    public Object getBean(String beanName) {
        return doGetBean(beanName,null);
    }

    @Override
    public Object getBean(String beanName, Object... args) {
        return doGetBean(beanName,args);
    }

    protected <T> T doGetBean(final String name, final Object[] args){
        Object singleton = getSingleton(name);
        if (singleton != null) {
            return (T) singleton;
        }
        BeanDefinition beanDefinition = getBeanDefinition(name);
        return (T) createBean(name,beanDefinition,args);
    }
}
