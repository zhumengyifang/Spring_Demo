package test;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component("app4UserServiceId")
@Scope("prototype")
public class UserServiceImplTest implements UserServiceTest {
    @Override
    public void addUser() {
        System.out.println("注解代替xml配置");
    }

    @PostConstruct
    public void myInit() {
        System.out.println("初始化");
    }

    @PreDestroy
    public void myDestroy() {
        System.out.println("销毁");
    }
}
