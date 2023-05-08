package com.springboot.controller;

import com.springboot.common.Result;
import com.springboot.entity.User;
import com.springboot.mapper.DeptMapper;
import com.springboot.mapper.EmpMapper;
import com.springboot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController // 里面的ResponseBody注解是用来格式化返回数据为json的
public class TestController {
//    @GetMapping("/testAjaxGet")
//    public String Hello(){
//        return "Ajax Get";
//    }
//
//    @PostMapping("/testAjaxJson")
//    public User testAjaxJson(){
//        return new User("张三", "123456");
//    }
//
//    @GetMapping("/testAjaxTimeOut")
//    public Result<User> testAjaxTimeOut() throws InterruptedException {
//        Thread.sleep(3000);
//        //return new User("张三", "123456");
//        return new Result<User>().Success().Data(new User("张三", "1234456"));
//    }
//
//    @GetMapping("/testjQueryGet")
//    public String testjQueryGet(){
//        return "{\"code\" = 1}";
//    }
//
//    @PostMapping("/testjQueryPost")
//    public Result testjQueryPost(){
//        return new Result().Msg("Hello Post jQuery Ajax");
//    }
//
//
//    @PostMapping("/findall")
//    public Result FindAll(){
//        return new Result();
//    }
    @Autowired
    UserMapper userMapper;

    @Autowired
    EmpMapper empMapper;

    @Autowired
    DeptMapper deptMapper;

    @GetMapping("/addUser")
    public Result<?> AddUser(){
        try{
            var user = new User(0, "彭文登", "123", true, 18, "123@cnmd.com");
            userMapper.AddUser(user);
            return new Result<>().Success();
        }
        catch (Exception ex){
            return new Result<>().Except(ex);
        }
    }

    @GetMapping("/selectAllUser")
    public Result<?> SelectAllUser(){
        try{
            List<User> users = userMapper.SelectAllUser();
            return new Result<>().Data(users);
        }
        catch (Exception ex){
            return new Result<>().Except(ex);
        }
    }

    @GetMapping("/selectUserByUserName")
    public Result<?> SelectUserByUserName(){
        try{
            var user = userMapper.SelectUserByUserName("张三");
            return new Result<>().Data(user);
        }
        catch (Exception ex){
            return new Result<>().Except(ex);
        }
    }

    @GetMapping("/login")
    public Result<?> Login(String username, String password){
        try{
            return new Result<>().Data(userMapper.Login(username, password));
        }
        catch (Exception ex){
            return new Result<>().Except(ex);
        }
    }

    @GetMapping("/getUserById")
    public Result<?> GetUserById(){
        try{
            return new Result<>().Success().Data(userMapper.GetUserById(2));
        }
        catch (Exception ex){
            return new Result<>().Except(ex);
        }
    }

    @GetMapping("/getUserCount")
    public Result<?> GetUserCount(){
        try{
            return new Result<>().Success().Data(userMapper.GetUserCount());
        }
        catch (Exception ex){
            return new Result<>().Except(ex);
        }
    }

    @GetMapping("/getUserByIdToMap")
    public Result<?> GetUserByIdToMap(){
        try{
            return new Result<>().Success().Data(userMapper.GetUserByIdToMap(2));
        }
        catch (Exception ex){
            return new Result<>().Except(ex);
        }
    }

    @GetMapping("/getUserByLike")
    public Result<?> GetUserByLike(){
        try{
            return new Result<>().Success().Data(userMapper.GetUserByLike("ad"));
        }
        catch (Exception ex){
            return new Result<>().Except(ex);
        }
    }

    @GetMapping("/deleteMore")
    public Result<?> DeleteMore(){
        try{
            return new Result<>().Success().Data(userMapper.DeleteMore("2,3"));
        }
        catch (Exception ex){
            return new Result<>().Except(ex);
        }
    }

    @GetMapping("/getUserByTableName")
    public Result<?> GetUserByTableName(){
        try{
            return new Result<>().Success().Data(userMapper.GetUserByTableName("t_user"));
        }
        catch (Exception ex){
            return new Result<>().Except(ex);
        }
    }

    @GetMapping("/getEmpDetail")
    public Result<?> GetEmpDetail(){
        try{
            var emp = empMapper.GetEmpDetailByStepOne(1);
            // 懒加载开启，当只需要某个属性时，则只会加载当前对象的数据
            // var emp = empMapper.GetEmpDetailByStepOne(1).getName();
            return new Result<>().Success().Data(emp);
        }
        catch (Exception ex){
            return new Result<>().Except(ex);
        }
    }

    @GetMapping("/getDeptDetail")
    public Result<?> GetDeptDetail(){
        try{
            var dept = deptMapper.GetDeptDetail(1);
            return new Result<>().Success().Data(dept.getEmps());
        }
        catch (Exception ex){
            return new Result<>().Except(ex);
        }
    }

    @PostMapping("/testParams")
    public Result<?> TestParams(@RequestBody Map<String, Object> params){
        try{
            //int id = (int)params.get("id");
            System.out.println(params);
            return null;
        }
        catch(Exception ex){
            return new Result<>().Except(ex);
        }
    }
}
