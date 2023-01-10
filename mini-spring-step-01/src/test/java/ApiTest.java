import org.example.beans.BeanDefinition;
import org.example.beans.BeanFactory;
import org.junit.Test;

public class ApiTest {

    @Test
    public void test_beanFactory(){
        // 1 初始化
        BeanFactory beanFactory = new BeanFactory();

        // 2 注入bean

        BeanDefinition beanDefinition = new BeanDefinition(new UserService());
        BeanDefinition beanDefinitionTwo = new BeanDefinition(new BeanService());
        beanFactory.registerBeanDefinition("userService",beanDefinition);
        beanFactory.registerBeanDefinition("beanService",beanDefinitionTwo);

        // 3 获取bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();

        BeanService beanService = (BeanService) beanFactory.getBean("beanService");
        beanService.getInfo();
    }
}
