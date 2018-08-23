package com.message.server.dao;

import com.message.server.dao.daoImpl.ShuoshuoDaoInterface;
import com.message.server.model.Shuoshuo;
import com.message.server.utils.MyHibernateDaoSupport;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by SX10100563 on 2016/10/13.
 */
@Repository("shuoshuoDao")
public class ShuoshuoDao extends MyHibernateDaoSupport implements ShuoshuoDaoInterface{
    /**
     * 添加一个说说
     * @param shuo
     */
    @Override
    public void addShuoshuo(Shuoshuo shuo) {
        Session session=this.getSession(true);
        Transaction transaction=session.beginTransaction();
        session.save(shuo);
        transaction.commit();
        session.close();
    }

    /**
     * 通过一个说说的Id删除一个说说
     * @param shuoId
     */
    @Override
    public void delShuoshuo(int shuoId) {
        Session session=this.getSession(true);
        Transaction transaction=session.beginTransaction();
        Shuoshuo shuoshuo=new Shuoshuo(shuoId);
        session.delete(shuoshuo);
        transaction.commit();
        session.close();
    }

    /**
     * 查找所有的说说内容
     * @return
     */
    @Override
    public List<Shuoshuo> selectAllshuo() {
        List<Shuoshuo> shuoshuos = new ArrayList<>();
        Session session = this.getSession(true);
        Transaction tc = session.beginTransaction();
        List list = session.createQuery("From Shuoshuo order by shuoId desc").list();
        for (Iterator iterator = list.iterator(); iterator.hasNext(); ) {
            Shuoshuo shuo = (Shuoshuo) iterator.next();
            shuoshuos.add(shuo);
        }
        try {
            tc.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        session.close();
        return shuoshuos;
    }

    /**
     * 将说说的点赞数目加一
     * @param shuoId
     */
    public void addShuoPhraseNum(int shuoId){
        Session session=this.getSession(true);
        Transaction tc=session.beginTransaction();
        session.createQuery("update Shuoshuo shuo set shuo.shuoPhraseNum=shuo.shuoPhraseNum+1 where shuoId="+shuoId).executeUpdate();
        tc.commit();
        session.close();
    }
    /**
     * 将说说的点赞数目减1
     * @param shuoId
     */
    public void subShuoPhraseNum(int shuoId){
        Session session=this.getSession(true);
        Transaction tc=session.beginTransaction();
        session.createQuery("update Shuoshuo shuo set shuo.shuoPhraseNum=shuo.shuoPhraseNum-1 where shuoId="+shuoId).executeUpdate();
        tc.commit();
        session.close();
    }

    /**
     * 将说说的评论数目加一
     * @param shuoId
     */
    public void addShuoCommentNum(int shuoId){
        Session session=this.getSession(true);
        Transaction tc=session.beginTransaction();
        session.createQuery("update Shuoshuo shuo set shuo.shuoCommentNum=shuo.shuoCommentNum+1 where shuoId="+shuoId).executeUpdate();
        tc.commit();
        session.close();
    }
}
