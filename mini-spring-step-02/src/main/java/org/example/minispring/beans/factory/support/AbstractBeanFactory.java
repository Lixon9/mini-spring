package org.example.minispring.beans.factory.support;

import org.example.minispring.beans.factory.bean.BeanDefinition;
import org.example.minispring.beans.factory.bean.IBeanFactory;
import org.example.minispring.beans.factory.registry.DefaultSingletonBeanRegistry;

/**
 * @author lks
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements IBeanFactory {

    protected abstract BeanDefinition getBeanDefinition(String beanName);

    protected abstract Object createBean( String beanName,BeanDefinition beanDefinition);
    @Override
    public Object getBean(String beanName) {

        Object singleton = getSingleton(beanName);
        if (singleton != null) {
            return singleton;
        }
        BeanDefinition beanDefinition = getBeanDefinition(beanName);
        return createBean(beanName,beanDefinition);
    }
}
