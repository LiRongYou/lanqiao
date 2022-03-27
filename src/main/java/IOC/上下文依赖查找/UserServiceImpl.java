package IOC.上下文依赖查找;

import IOC.接口注入.UserMapper;

import javax.activation.DataSource;
import javax.naming.Context;
import javax.naming.InitialContext;

public class UserServiceImpl {

    private DataSource dataSource;

    private UserMapper userMapper;

    public UserServiceImpl(){
        Context context = null;
        try{
            context = new InitialContext();
            dataSource = (DataSource) context.lookup("java:com/jourwon/dataSourceName");
            userMapper = (UserMapper) context.lookup("java:com/jourwon/UserMapperName");
        } catch (Exception e) {

        }
    }

}

