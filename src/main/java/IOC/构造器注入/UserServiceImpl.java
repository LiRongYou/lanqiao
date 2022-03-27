package IOC.构造器注入;

import IOC.接口注入.UserMapper;
import IOC.接口注入.UserService;

public class UserServiceImpl implements UserService {

    private UserMapper userMapper;

    /**
     * 构造方法注入
     */
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public void test() {
        userMapper.test();
    }

}

