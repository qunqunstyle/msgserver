package com.message.server.action;

import com.message.server.dao.CommentDao;
import com.message.server.model.Comment;
import com.message.server.utils.ActionSupportUtil;
import net.sf.json.JSONArray;
import org.apache.struts2.convention.annotation.Action;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SX10100563 on 2016/10/14.
 */
@Controller
public class CommentAction extends ActionSupportUtil {

    @Resource
    private CommentDao commentDao;
    private Comment comment;

    /**
     * 通过说说的Id获取一个说说的所有评论
     * http://localhost:8080/getShuoComments?comment.shuoId=1
     */
    @Action("getShuoComments")
    public void getShuoComments() {
        List<Comment> shuoComments = commentDao.selectCommentByShuoId(comment.getShuoId());
        if (shuoComments == null) {
            renderText("该说说评论为空");
        } else {
            JSONArray jsonArray = new JSONArray();
            for (Comment comment : shuoComments) {
                jsonArray.add(comment.CommentToJSON());
            }
            renderJson(jsonArray.toString());
        }
    }

    /**
     * 添加一个说说评论
     * http://localhost:8080/addShuoComment?comment.shuoId=2&comment.commentDate=2016-12-1&comment.commentA=hahaha&comment.commentB=小华&comment.commentContent=试试看评论行不行
     * @throws UnsupportedEncodingException
     */
    @Action("addShuoComment")
    public void addShuoComment() throws UnsupportedEncodingException {
        comment.setCommentA(new String(comment.getCommentA().getBytes("ISO-8859-1"), "UTF-8"));
        comment.setCommentB(new String(comment.getCommentB().getBytes("ISO-8859-1"), "UTF-8"));
        comment.setCommentContent(new String(comment.getCommentContent().getBytes("ISO-8859-1"), "UTF-8"));
        commentDao.addComment(comment);
        renderText("success");
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }
}
