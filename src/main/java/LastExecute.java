import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import test2.UserService;
import test3.AccountService;

public class LastExecute {
    public ApplicationContext getApplicationContext(String smlPath) {
        return new ClassPathXmlApplicationContext(smlPath);
    }

    /**
     * 切面编程
     */
    @Test
    public void demo01() {
        ApplicationContext applicationContext = getApplicationContext("ApplicationContext5.xml");

        //获得目标类
        UserService userService = applicationContext.getBean("userServiceIdxml", UserService.class);
        userService.addUser();
        userService.updateUser();
        userService.deleteUser();
    }

    /**
     * 切面编程注释代替XMl配置
     */
    @Test
    public void demo02(){
        ApplicationContext applicationContext = getApplicationContext("ApplicationContext6.xml");
        //获得目标类
        UserService userService = applicationContext.getBean("userServiceId", UserService.class);
        userService.addUser();
        userService.updateUser();
        userService.deleteUser();
    }

    /**
     * 事物处理
     */
    @Test
    public void demo03(){
        String xmlPath = "ApplicationContext7.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        AccountService accountService =  (AccountService) applicationContext.getBean("accountService");
        accountService.transfer("jack", "rose", 1000);
    }

    @Test
    public void demo04(){
        String xmlPath = "ApplicationContext8.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        AccountService accountService =  (AccountService) applicationContext.getBean("accountService");
        accountService.transfer("jack", "rose", 1000);
    }
}
