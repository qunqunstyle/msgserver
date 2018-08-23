package com.message.server.action;

/**
 * Created by SX10100563 on 2016/10/14.
 */

import com.message.server.dao.UserDao;
import com.message.server.model.User;
import com.message.server.utils.ActionSupportUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.struts2.convention.annotation.Action;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * 与user有关的Action
 */
@Controller
public class UserAction extends ActionSupportUtil {
    @Resource
    private UserDao userDao;
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    /**
     * 用户的登录功能。
     * 通过UserDao中的isExitByNameAndPass（user）方法可以知道数据库中用户名和密码是否正确
     * http://localhost:8080/login.action?user.userName=cjs&user.userPassword=123
     *
     * @return
     */
    @Action(value = "login")
    public void login() throws UnsupportedEncodingException {
        user.setUserName(new String(user.getUserName().getBytes("ISO-8859-1"), "UTF-8"));
        boolean flag = userDao.isExitByNameAndPass(user);
        if (flag) {
            renderText("Success");
            return;
        }
        renderText("Fail");
    }

    /**
     * 用户的注册功能。
     * 使用UserDao的addUser方法可以向数据库中插入用户信息（用户名、密码）、用户ID是自增
     * http://localhost:8080/addUser?user.userName=&user.userPassword=1234
     *
     * @return
     */
    @Action(value = "addUser")
    public void addUser() throws UnsupportedEncodingException {
        user.setUserName(new String(user.getUserName().getBytes("ISO-8859-1"), "UTF-8"));
        userDao.addUser(user);
        renderText("success");
    }

    /**
     * 获得所有的用户名及密码
     * http://localhost:8080/getAllUsers
     */
    @Action("getAllUsers")
    public void getAllUsers() {
        List<User> users = userDao.selectUser();
        if (users == null) {
            renderText("user null");
        } else {
            JSONArray json = new JSONArray();
            for (User user : users) {
                json.add(user.UserToJSON());
            }
            renderJson(json.toString());
        }
    }

    /**
     * 获取所有的用户名
     * http://localhost:8080/getAllUserName
     */
    @Action("getAllUserName")
    public void getAllUserName(){
        List<String> usernameList=userDao.selectAllUserName();
        if(usernameList==null){
            renderText("null");
        }else{
            JSONArray jsonArray=new JSONArray();
            JSONObject jsonObject=new JSONObject();
            for (String name : usernameList){
                jsonObject.put("userName",name);
                jsonArray.add(jsonObject);
            }
            renderJson(jsonArray.toString());
        }
    }

}
