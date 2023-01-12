import org.example.minispring.beans.factory.bean.BeanDefinition;
import org.example.minispring.beans.factory.support.AbstractAutowireCapableBeanFactory;
import org.example.minispring.beans.factory.support.DefaultListableBeanFactory;
import org.junit.Test;

public class ApiTest {

    @Test
    public void test_demo(){

        // 1 初始化一个工厂
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();

        // 2 注册一个bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        defaultListableBeanFactory.registerBeanDefinition("userService",beanDefinition);

        // 3 获取bean
        UserService userService = (UserService) defaultListableBeanFactory.getBean("userService");
        userService.queryUserInfo();



    }

     static class UserService2{
        public void queryUserInfo(){
            System.out.println("查询用户信息");
        }
    }
}
