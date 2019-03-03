import dao.BookService;
import dao.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FirstExecute {

    public ApplicationContext getApplicationContext() {
        String smlPath = "ApplicationContext.xml";
        return new ClassPathXmlApplicationContext(smlPath);
    }

    /**
     * 测试单例多例
     */
    @Test
    public void demo1() {
        ApplicationContext applicationContext = getApplicationContext();
        UserService userService = (UserService) applicationContext.getBean("userServiceId");
        UserService userService1 = (UserService) applicationContext.getBean("userServiceId");
        System.out.println(userService.hashCode());
        System.out.println(userService1.hashCode());
    }

    /**
     * DI 依赖注入
     */
    @Test
    public void demo2() {
        ApplicationContext applicationContext = getApplicationContext();
        BookService bookService = (BookService) applicationContext.getBean("bookServiceId");
        bookService.addBook();
    }

    /**
     * 工厂
     */
    @Test
    public void demo03(){
        //从spring容器获得
        //1 获得容器
        ApplicationContext applicationContext = getApplicationContext();
        UserService userService = applicationContext.getBean("userServiceFactoryId" ,UserService.class);
        System.out.println("普通工厂");
        userService.addUser();
    }

    /**
     * 静态工厂
     */
    @Test
    public void demo04(){
        //从spring容器获得
        //1 获得容器
        ApplicationContext applicationContext = getApplicationContext();
        UserService userService = applicationContext.getBean("userServiceStaticeFactoryId" ,UserService.class);
        System.out.println("静态工厂");
        userService.addUser();
    }


}
