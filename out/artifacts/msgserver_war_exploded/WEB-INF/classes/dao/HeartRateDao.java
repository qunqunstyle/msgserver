package com.message.server.dao;

import com.message.server.dao.daoImpl.HeartRateDaoInterface;
import com.message.server.utils.*;
import com.message.server.model.HeartRate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository("heartrateDao")
public class HeartRateDao extends MyHibernateDaoSupport implements HeartRateDaoInterface {
    /**
     * 添加一个心率数据
     * @param  heartrate
     */

    public void addHeartrate(HeartRate heartrate) {
        Session session=this.getSession(true);
        Transaction transaction=session.beginTransaction();
        session.save(heartrate);
        try {
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
       session.close();
    }

    /**
     * 通过一个心率的Id删除一个心率
     * @param heartId
     */

    public void delHeartRate(int heartId) {
        Session session=this.getSession(true);
        Transaction transaction=session.beginTransaction();
        HeartRate heartrate=new HeartRate(heartId);
        session.delete(heartrate);
        try {
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
        session.close();
    }

    /**
     * 查找所有的心率值
     * @return
     */

    public List<HeartRate> selectAllheart(String userName) {
        List<HeartRate> heartrates = new ArrayList<>();
        Session session = this.getSession(true);
        Transaction tc = session.beginTransaction();
        List list = session.createQuery("From HeartRate where userName = "+userName+"order by heartId desc").list();
        for (Iterator iterator = list.iterator(); iterator.hasNext(); ) {
            HeartRate heartrate = (HeartRate) iterator.next();
            heartrates.add(heartrate);
        }
        try {
            tc.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        session.close();
        return heartrates;
    }

}
