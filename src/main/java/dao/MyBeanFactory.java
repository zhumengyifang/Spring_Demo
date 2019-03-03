package dao;

public class MyBeanFactory {
    public UserService createService() {
        return new UserServiceImpl();
    }

    public static UserService staticCreateService() {
        return new UserServiceImpl();
    }
}
