package org.example.minispring.beans.factory.factory;

/**
 * @author lks
 */
public interface IBeanFactory {

    public Object getBean(String beanName);

    Object getBean(String beanName,Object... args);
}
