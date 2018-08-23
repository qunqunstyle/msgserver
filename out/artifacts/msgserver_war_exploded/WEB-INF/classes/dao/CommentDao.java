package com.message.server.dao;

import com.message.server.dao.daoImpl.CommentDaoInterface;
import com.message.server.model.Comment;
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
@Repository("commentDao")
public class CommentDao extends MyHibernateDaoSupport implements CommentDaoInterface {

    public void addComment(Comment comment) {
        Session session = this.getSession(true);
        Transaction tc = session.beginTransaction();
        session.save(comment);
        tc.commit();
        session.close();
    }

    public void delComment(int commentId) {
        Session session = this.getSession(true);
        Transaction tc = session.beginTransaction();
        Comment comment = new Comment(commentId);
        session.delete(comment);
        tc.commit();
        session.close();
    }

    public List<Comment> selectCommentByShuoId(int shuoId) {
        List<Comment> comments = new ArrayList<>();
        Session session = this.getSession(true);
        Transaction tc = session.beginTransaction();
//        List list = session.createQuery("from Comment order by commentId where shuoId=" + shuoId).list();
        List list=session.createQuery("from Comment where shuoId="+shuoId+"order by commentId").list();
        for (Iterator iterator = list.iterator(); iterator.hasNext(); ) {
            Comment comment = (Comment) iterator.next();
            comments.add(comment);
        }
        tc.commit();
        session.close();
        return comments;
    }
}
