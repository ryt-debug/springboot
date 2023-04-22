package com.springboot.mapper;

import com.fasterxml.jackson.databind.introspect.AnnotatedParameter;
import com.springboot.entity.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {
    /**
     * 1.映射文件的namespace要与mapper接口的全类名一致
     * 2.映射文件中的SQL语句的id要与mapper接口中的方法名一致
     */

    //@Select("insert into t_user values(null, 'admin', '123456', true, 23, '2091921193@qq.com')")
    void AddUser(User user);

    /**
     * 查询所有用户
     */
    List<User> SelectAllUser();

    /**
     * 根据用户名查询用户信息
     */
    User SelectUserByUserName(@Param("username") String UserName);

    User Login(@Param("username") String UserName, @Param("password") String PassWord);

    User GetUserById(@Param("id") int Id);

    /**
     * 查询用户信息的总记录数
     */
    int GetUserCount();

    /**
     * 根据Id查询用户信息为一个Map
     */
    Map<String, Object> GetUserByIdToMap(@Param("id")int Id);

    @MapKey("Id")
    List<Map<String, Object>> GetAllUserToMap();
}
