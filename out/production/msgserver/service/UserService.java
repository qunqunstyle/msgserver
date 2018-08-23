package com.message.server.service;

import com.message.server.dao.UserDao;
import com.message.server.model.User;
import com.message.server.service.serviceImpl.UserServiceInterface;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by SX10100563 on 2016/10/9.
 */
@Service
public class UserService implements UserServiceInterface {
    @Resource
    private UserDao UserDao;

    public boolean isExitUser(String userName) {
        return UserDao.isExitByName(userName);
    }

    public void save(User user) {
        UserDao.addUser(user);
    }

    public List<User> getUsers() {
        List<User> users = UserDao.selectUser();
        return users;
    }

    public void del(int userId) {
        UserDao.delUser(userId);

    }

    public void update(User user) {
        UserDao.updateUser(user);

    }

    public User getUserById(int userId) {
        return UserDao.getUserByUserId(userId);
    }

    public boolean isExitByNameAndPass(User user) {
        return UserDao.isExitByNameAndPass(user);
    }
}