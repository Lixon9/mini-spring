package org.example.minispring.beans.factory.support;

import org.example.minispring.beans.factory.bean.BeanDefinition;
import org.junit.Before;
import org.junit.Test;

public class DefaultListableBeanFactoryTest {

    private DefaultListableBeanFactory defaultListableBeanFactoryUnderTest;

    @Before
    public void setUp() {
        defaultListableBeanFactoryUnderTest = new DefaultListableBeanFactory();
    }

    @Test
    public void testRegisterBeanDefinition() {
        // Setup
        final BeanDefinition beanDefinition = new BeanDefinition(UserService.class);

        // Run the test
        defaultListableBeanFactoryUnderTest.registerBeanDefinition("beanName", beanDefinition);

        // Verify the results
        UserService beanName = (UserService) defaultListableBeanFactoryUnderTest.getBean("beanName");
        beanName.queryUserInfo();
    }

    @Test
    public void testGetBeanDefinition() {
        // Setup
        // Run the test
        final BeanDefinition result = defaultListableBeanFactoryUnderTest.getBeanDefinition("beanName");

        // Verify the results
    }
}
