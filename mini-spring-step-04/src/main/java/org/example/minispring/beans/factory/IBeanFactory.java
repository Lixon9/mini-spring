package org.example.minispring.beans.factory;

import java.lang.reflect.InvocationTargetException;

/**
 * @author lks
 */
public interface IBeanFactory {

    Object getBean(String beanName) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException;

    Object getBean(String beanName,Object... args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException;
}
