package test2;

import org.springframework.stereotype.Service;

@Service("userServiceId")
public class UserServiceImpl implements UserService {
    @Override
    public void addUser() {
        System.out.println("d_aspect.a_xml addUser");
    }

    @Override
    public String updateUser() {
        System.out.println("d_aspect.a_xml updateUser");
        return "updateUser";
    }

    @Override
    public void deleteUser() {
        System.out.println("d_aspect.a_xml deleteUser");
    }
}
