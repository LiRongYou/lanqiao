package IOC.Setter方法注入;

import IOC.接口注入.UserMapper;
import IOC.接口注入.UserService;

public class UserServiceImpl implements UserService {

    private UserMapper userMapper;

    /**
     * setter方法注入
     */
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public void test() {
        userMapper.test();
    }

}
