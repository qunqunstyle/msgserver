package com.message.server.utils;

/**
 * Created by SX10100563 on 2016/10/10.
 */
import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
public class MyHibernateDaoSupport extends HibernateDaoSupport {
    @Resource(name="sessionFactory")    //为父类HibernateDaoSupport注入sessionFactory的值
    public void setSuperSessionFactory(SessionFactory sessionFactory){
        super.setSessionFactory(sessionFactory);
    }
}

