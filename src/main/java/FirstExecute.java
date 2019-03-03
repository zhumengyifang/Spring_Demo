import dao.*;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.InvocationTargetException;

public class FirstExecute {

    public ApplicationContext getApplicationContext(String smlPath) {
        return new ClassPathXmlApplicationContext(smlPath);
    }

    /**
     * 测试单例多例
     */
    @Test
    public void demo1() {
        ApplicationContext applicationContext = getApplicationContext("ApplicationContext.xml");
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
        ApplicationContext applicationContext = getApplicationContext("ApplicationContext.xml");
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
        ApplicationContext applicationContext = getApplicationContext("ApplicationContext.xml");
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
        ApplicationContext applicationContext = getApplicationContext("ApplicationContext.xml");
        UserService userService = applicationContext.getBean("userServiceStaticeFactoryId", UserService.class);
        System.out.println("静态工厂");
        userService.addUser();
    }

    /**
     * 切面
     */
    @Test
    public void demo5() {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = (ClassPathXmlApplicationContext) getApplicationContext("ApplicationContext.xml");
        UserService userService = classPathXmlApplicationContext.getBean("userServiceDestroyId", UserService.class);
        userService.addUser();

        // * 此方法接口中没有定义，实现类提供
        classPathXmlApplicationContext.close();
    }

    /**
     * BeanPostProcessor接口的类会实现postProcessBeforeInitialization和postProcessAfterInitialization方法，这两种方法会在Spring配置文件中的init-method方法调用前和调用后去执行。
     * 在代码中执行完postProcessAfterInitialization方法后，得到的实际是代理对象，最后调用addUser是用代理对象调用的。
     *
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    @Test
    public void demo6() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = (ClassPathXmlApplicationContext) getApplicationContext("ApplicationContext1.xml");
        UserService userService = (UserService) classPathXmlApplicationContext.getBean("userServiceDestroyId");
        userService.addUser();
        //要求：1.容器必须close，销毁方法执行; 2.必须是单例的
        classPathXmlApplicationContext.getClass().getMethod("close").invoke(classPathXmlApplicationContext);
        classPathXmlApplicationContext.close();
    }

    /**
     * 构造方法注入
     */
    @Test
    public void demo7() {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = (ClassPathXmlApplicationContext) getApplicationContext("ApplicationContext.xml");
        User user = classPathXmlApplicationContext.getBean("userId", User.class);
        System.out.println(user.toString());
    }

    /**
     * Set方法注入
     */
    @Test
    public void demo8() {
        ApplicationContext applicationContext = getApplicationContext("ApplicationContext2.xml");
        Person person = applicationContext.getBean("personId", Person.class);
        System.out.println(person.toString());
    }

    /**
     * 集合注入
     */
    @Test
    public void demo9() {
        ApplicationContext applicationContext = getApplicationContext("ApplicationContext3.xml");
        CollData collData = applicationContext.getBean("collDataId", CollData.class);
        System.out.println(collData.toString());
    }

}
