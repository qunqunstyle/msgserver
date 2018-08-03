package com.message.server.dao.daoImpl;

import com.message.server.model.Comment;

import java.util.List;

/**
 * Created by SX10100563 on 2016/10/12.
 */
public interface CommentDaoInterface {
    /**
     * 添加一个评论
     * @param comment
     */
    public void addComment(Comment comment);

    /**
     * 通过commentid来删除一个comment
     * @param commentId
     */
    public void delComment(int commentId);

    /**
     * 通过一个说说的ID来查找这个说说的所有评论
     * @param shuoId
     * @return
     */
    public List<Comment> selectCommentByShuoId(int shuoId);


}
