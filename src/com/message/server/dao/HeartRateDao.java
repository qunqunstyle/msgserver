package dao;

import com.message.server.dao.daoImpl.HeartRateDaoInterface;
import com.message.server.utils.MyHibernateDaoSupport;
import model.HeartRate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;



@Repository("heartratedao")
public class HeartRateDao extends MyHibernateDaoSupport implements HeartRateDaoInterface {
    /**
     * 添加一个心率数据
     * @param  heartrate
     */
    @Override
    public void addHeartrate(HeartRate heartrate) {
        Session session=this.getSession(true);
        Transaction transaction=session.beginTransaction();
        session.save(heartrate);
        transaction.commit();
        session.close();
    }

    /**
     * 通过一个心率的Id删除一个心率
     * @param heartId
     */
    @Override
    public void delHeartRate(int heartId) {
        Session session=this.getSession(true);
        Transaction transaction=session.beginTransaction();
        HeartRate heartrate=new HeartRate(heartId);
        session.delete(heartrate);
        transaction.commit();
        session.close();
    }

    /**
     * 查找所有的心率值
     * @return
     */
    @Override
    public List<HeartRate> selectAllheart(String userName) {
        List<HeartRate> heartrates = new ArrayList<>();
        Session session = this.getSession(true);
        Transaction tc = session.beginTransaction();
        List list = session.createQuery("From Heart where userName = "+userName"order by heartId desc").list();
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
