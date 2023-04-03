package org.example.minispring.beans.factory.instantiate;

import org.example.minispring.beans.factory.bean.BeanDefinition;
import org.example.minispring.beans.factory.exception.BeansException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Constructor;

import static org.junit.Assert.assertThrows;

public class SimpleInstantiationStrategyTest {

    private SimpleInstantiationStrategy simpleInstantiationStrategyUnderTest;

    @Before
    public void setUp() {
        simpleInstantiationStrategyUnderTest = new SimpleInstantiationStrategy();
    }

    @Test
    public void testInstantiate() {
        // Setup
        final BeanDefinition beanDefinition = new BeanDefinition(String.class);
        final Constructor<?> constructor = null;

        // Run the test
        final Object result = simpleInstantiationStrategyUnderTest.instantiate(beanDefinition, "beanName", constructor,
                new Object[]{"args"});

        // Verify the results
    }

    @Test
    public void testInstantiate_ThrowsBeansException() {
        // Setup
        final BeanDefinition beanDefinition = new BeanDefinition(String.class);
        final Constructor<?> constructor = null;

        // Run the test
        Assert.assertThrows(BeansException.class,
                () -> simpleInstantiationStrategyUnderTest.instantiate(beanDefinition, "beanName", constructor,
                        new Object[]{"args"}));
    }
}
