package com.chinasoft.test;

import com.chinasoft.dao.UserDao;
import com.chinasoft.pojo.User;
import org.junit.Test;

/**
 * @Description TODO
 * @ClassName UserTest
 * @Author Dudu
 * @Date 2020/2/21 10:28
 * @Version V1.0
 */
public class UserTest {


    @Test
    public void findUserTest(){
        User user = new User(1,"jack","12345");
        UserDao  userDao = new UserDao();
        int result = userDao.findUserByNameAndPassword(user);
        System.out.println(result);
    }
}
