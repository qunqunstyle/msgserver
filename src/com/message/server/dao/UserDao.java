package com.message.server.dao;

/**
 * Created by SX10100563 on 2016/10/9.
 */

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import org.hibernate.Session;
import org.hibernate.Transaction;

import com.message.server.dao.daoImpl.UserDaoInterface;
import com.message.server.model.User;
import com.message.server.utils.*;
import org.springframework.stereotype.Repository;

/**
 * Session操作数据库的相关方法：
 * get （）从数据库获取数据对象，不存在时返回null
 * load （）从数据库获取数据对象，不存在时抛出异常
 * createQuery （）根据条件查询数据对象
 * save （）将对象保存到数据库
 * update() 更新对象到数据库
 * delete （） 根据对象删除数据库数据
 */
@Repository("userDao")
public class UserDao extends MyHibernateDaoSupport implements UserDaoInterface {

    public void addUser(User user) {
        Session session = this.getSession(true);
        Transaction tc = session.beginTransaction();
        session.save(user);
        try {
            tc.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        session.close();
    }

    public void delUser(int userId) {
        Session session = this.getSession(true);
        Transaction tc = session.beginTransaction();
        User u = new User(userId);
        session.delete(u);
        try {
            tc.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        session.close();
    }

    public void updateUser(User user) {
        Session session = this.getSession(true);
        Transaction tc = session.beginTransaction();
        session.update(user);
        try {
            tc.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        session.close();

    }

    public List<String> selectAllUserName() {
        List<String> usernameList = new ArrayList<>();
        Session session = this.getSession(true);
        Transaction tc = session.beginTransaction();
        List list = session.createQuery("From User").list();
        for (Iterator iterator = list.iterator(); iterator.hasNext(); ) {
            User u = (User) iterator.next();
            usernameList.add(u.getUserName());
        }
        try {
            tc.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        session.close();
        return usernameList;
    }

    public List<User> selectUser() {
        List<User> users = new ArrayList<>();
        Session session = this.getSession(true);
        Transaction tc = session.beginTransaction();
        List list = session.createQuery("From User").list();
        for (Iterator iterator = list.iterator(); iterator.hasNext(); ) {
            User u = (User) iterator.next();
            users.add(u);
        }
        try {
            tc.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        session.close();
        return users;
    }

    public User getUserByUserId(int userId) {
        Session session = this.getSession(true);
        Transaction tc = session.beginTransaction();
        //load 是说明数据库中一定存在这条记录，没有则报出：ObjectNotFoundException
        //get 如果查不到记录，返回的是一个null
        User user = (User) session.load(User.class, userId);
        try {
            tc.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        session.close();
        return user;
    }

    public boolean isExitByName(String userName) {
        Session session = this.getSession(true);
        Transaction tc = session.beginTransaction();
        List user = session.createQuery("From User u where u.userName=:userName").setString("userName", userName).list();
        if (user.size() > 0) {
            try {
                tc.commit();
            } catch (Exception e) {
                e.printStackTrace();
            }
            session.close();
            return true;
        }
        try {
            tc.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        session.close();
        return false;
    }

    public boolean isExitByNameAndPass(User user) {
        Session session = this.getSession(true);
        Transaction tc = session.beginTransaction();
        List users = null;
        users = session.createQuery("From User u where u.userName=:userName and u.userPassword=:userPassword").setString("userName", user.getUserName()).setString("userPassword", user.getUserPassword()).list();
        if (users.size() > 0) {
            try {
                tc.commit();
            } catch (Exception e) {
                e.printStackTrace();
            }
            session.close();
            return true;
        }
        try {
            tc.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        session.close();
        return false;
    }

}