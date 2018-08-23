package com.message.server.dao;

import com.message.server.model.Suggestion;
import com.message.server.utils.MyHibernateDaoSupport;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

/**
 * Created by SX10100563 on 2016/10/26.
 */
@Repository("suggestionDao")
public class SuggestionDao extends MyHibernateDaoSupport{
    public void addSuggestion(Suggestion suggestion){
        Session session=this.getSession(true);
        Transaction tc=session.beginTransaction();
        session.save(suggestion);
        tc.commit();
        session.close();
    }
}
