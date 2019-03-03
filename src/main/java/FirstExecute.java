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
    public void demo3() {
        //从spring容器获得
        //1 获得容器
        ApplicationContext applicationContext = getApplicationContext();
        UserService userService = applicationContext.getBean("userServiceFactoryId", UserService.class);
        System.out.println("普通工厂");
        userService.addUser();
    }

    /**
     * 静态工厂
     */
    @Test
    public void demo4() {
        //从spring容器获得
        //1 获得容器
        ApplicationContext applicationContext = getApplicationContext();
        UserService userService = applicationContext.getBean("userServiceStaticeFactoryId", UserService.class);
        System.out.println("静态工厂");
        userService.addUser();
    }

    @Test
    public void demo5() {
        String smlPath = "ApplicationContext.xml";
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(smlPath);
        UserService userService = (UserService) classPathXmlApplicationContext.getBean("userServiceDestroyId");
        userService.addUser();
        //要求：1.容器必须close，销毁方法执行;
        //     2.必须是单例的
        //classPathXmlApplicationContext.getClass().getMethod("close").invoke(classPathXmlApplicationContext);
        // * 此方法接口中没有定义，实现类提供
        classPathXmlApplicationContext.close();
    }


}
