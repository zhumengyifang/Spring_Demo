package test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("testuserId")
public class User {

    @Value("注解注入")
    private String name;

    @Override
    public String toString() {
        return "User{" + "name='" + name + '\'' + '}';
    }
}

