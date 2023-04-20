package com.springboot.mapper;

import com.springboot.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    /**
     * 1.映射文件的namespace要与mapper接口的全类名一致
     * 2.映射文件中的SQL语句的id要与mapper接口中的方法名一致
     */

    //@Select("insert into t_user values(null, 'admin', '123456', true, 23, '2091921193@qq.com')")
    int AddUser(User user);

    /**
     * 查询所有用户
     */
    List<User> SelectAllUser();

    /**
     * 根据用户名查询用户信息
     */
    User SelectUserByUserName(String username);

    User Login(String username, String password);
}
