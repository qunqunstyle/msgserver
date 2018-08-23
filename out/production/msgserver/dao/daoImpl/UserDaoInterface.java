package com.message.server.dao.daoImpl;

/**
 * Created by SX10100563 on 2016/10/10.
 */

import com.message.server.model.User;

import java.util.List;



public interface UserDaoInterface {
    /**
     * 添加用户
     * @param user
     */
    public void addUser(User user);

    /**
     * 通过userId删除一个用户
     * @param userId
     */
    public void delUser(int userId);

    /**
     * 更新一个用户信息
     * @param user
     */
    public void updateUser(User user);

    /**
     * 查找所有用户信息返回在list集合中
     * @return
     */
    public List<User> selectUser();

    /**
     * 通过用户的id查找这个用户信息
     * @param userId
     * @return
     */
    public User getUserByUserId(int userId);

    /**
     * 通过用户名判断用户是否存在
     * @param userName
     * @return
     */
    public boolean isExitByName(String userName);

    /**
     * 判断用户名和密码是否正确
     * @param user
     * @return
     */
    public boolean isExitByNameAndPass(User user);
}
