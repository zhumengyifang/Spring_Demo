package dao;


public class UserServiceImpl implements UserService {
    @Override
    public void addUser() {
        System.out.println("第一个测试用例!");
    }

    public void myInit() {
        System.out.println("初始化");
    }

    public void myDestroy() {
        System.out.println("销毁");
    }
}
