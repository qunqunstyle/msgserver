package com.message.server.dao;

import com.message.server.dao.daoImpl.PhraseDaoInterface;
import com.message.server.model.Phrase;
import com.message.server.utils.MyHibernateDaoSupport;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by SX10100563 on 2016/10/13.
 */
@Repository("phraseDao")
public class PhraseDao extends MyHibernateDaoSupport implements PhraseDaoInterface {

    @Override
    public void addPhrase(Phrase phrase) {
        Session session = this.getSession(true);
        Transaction tc = session.beginTransaction();
        session.save(phrase);
        tc.commit();
        session.close();
    }

    @Override
    public void delPhrase(int shuoId, String phraseName) {
        Session session = this.getSession(true);
        Transaction tc = session.beginTransaction();
        Query query = session.createQuery("delete from Phrase where shuoId=? and phraseName=?");
        query.setInteger(0, shuoId);
        query.setString(1, phraseName);
        query.executeUpdate();
        tc.commit();
        session.close();
    }


    @Override
    public List<Phrase> selectByShuoId(int shuoId) {
        List<Phrase> phraseList = new ArrayList<>();
        Session session = this.getSession(true);
        Transaction tc = session.beginTransaction();
        List list = session.createQuery("from Phrase where shuoId=" + shuoId).list();
        for (Iterator iterator = list.iterator(); iterator.hasNext(); ) {
            Phrase p = (Phrase) iterator.next();
            phraseList.add(p);
        }
        tc.commit();
        session.close();
        return phraseList;
    }

    public boolean isPhraseByCurrentUser(Phrase phrase) {
        Session session = this.getSession(true);
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from Phrase where phraseName=? and shuoId=?");
        query.setString(0,phrase.getPhraseName());
        query.setInteger(1,phrase.getShuoId());
        List list=query.list();
        if (list.size() > 0) {
            transaction.commit();
            session.close();
            return true;
        }
        transaction.commit();
        session.close();
        return false;
    }
}
