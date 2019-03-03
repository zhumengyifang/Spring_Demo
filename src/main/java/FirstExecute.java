import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FirstExecute {
    @Test
    public void demo1() {
        String smlPath = "ApplicationContext.xml";
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(smlPath);
        UserService userService=(UserService) applicationContext.getBean("userServiceId");
        userService.addUser();
    }
}
