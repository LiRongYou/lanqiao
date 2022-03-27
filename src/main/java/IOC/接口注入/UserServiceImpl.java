package IOC.接口注入;

/**
 * Description:service实现类
 */
public class UserServiceImpl implements UserMapper, UserService {
    private UserMapper userMapper;

    @Override
    public void createUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public void test() {
        userMapper.test();
    }
}
