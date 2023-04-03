package org.example.minispring.beans.factory.factory;

import org.example.minispring.beans.factory.bean.BeanDefinition;
import org.example.minispring.beans.factory.bean.UserService;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class DefaultListableBeanFactoryTest {

    private DefaultListableBeanFactory defaultListableBeanFactoryUnderTest;

    @Before
    public void setUp() {
        defaultListableBeanFactoryUnderTest = new DefaultListableBeanFactory();
    }

    @Test
    public void testGetBeanDefinition() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        // Setup
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        // Run the test
        defaultListableBeanFactoryUnderTest.registerBeanDefinition("userService",beanDefinition);

        final BeanDefinition result = defaultListableBeanFactoryUnderTest.getBeanDefinition("userService");

        UserService userService = (UserService) defaultListableBeanFactoryUnderTest.getBean("userService","aaaaa");
        userService.queryUserInfo();
        System.out.println(userService.getUserName());


        UserService userService1 = new UserService();
        userService1.id = "haha";
        System.out.println(userService1);

        // Verify the results
    }

    @Test
     public void testRegisterBeanDefinition() {
        // Setup
        final BeanDefinition beanDefinition = new BeanDefinition(String.class);

        // Run the test
        defaultListableBeanFactoryUnderTest.registerBeanDefinition("beanName", beanDefinition);

        // Verify the results
    }

    @Test
    public void test_newInstance() throws InstantiationException, IllegalAccessException {

        UserService userService = UserService.class.newInstance();
        System.out.println(userService);

    }

    @Test
    public void testConstructor() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<UserService> userServiceClass = UserService.class;
        Constructor<UserService> declaredConstructor = userServiceClass.getDeclaredConstructor(String.class,String.class);
        Constructor<UserService> ctor = declaredConstructor;
        Constructor<?>[] declaredConstructors = userServiceClass.getDeclaredConstructors();

        System.out.println(Arrays.toString(declaredConstructors));
        UserService userService = declaredConstructor.newInstance("张三","001");

        System.out.println(userService);



    }
}
