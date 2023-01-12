package org.example.minispring.beans.factory.support;

import org.example.minispring.beans.factory.bean.BeanDefinition;
import org.example.minispring.beans.factory.bean.IBeanFactory;
import org.example.minispring.beans.factory.exception.BeansException;
import org.example.minispring.beans.factory.registry.DefaultSingletonBeanRegistry;

/**
 * @author lks
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements IBeanFactory {

    protected abstract BeanDefinition getBeanDefinition(String beanName);

    protected abstract Object createBean( String beanName,BeanDefinition beanDefinition);



    /** 需要获取bean的话，先得到这个bean的定义，再进行创建这个bean，通过newInstance的方式，创建完成后并缓存在单例模式工厂中
     * @param name
     * @return
     * @throws BeansException
     */
    @Override
    public Object getBean(String name) throws BeansException {
        // 1 先从缓存中拿
        Object bean = getSingleton(name);
        if (bean != null) {
            return bean;
        }
        // 2 初始没有的话，就直接拿取其定义并进行创建
        BeanDefinition beanDefinition = getBeanDefinition(name);
        return createBean(name, beanDefinition);
    }
}
