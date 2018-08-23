package com.message.server.model;


import net.sf.json.JSONObject;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by SX10100563 on 2016/10/12.
 */
@Entity
@Table(name = "commentdb")
public class Comment {
    //评论Id
    @Id
    @Column(name = "commentId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int commentId;

    //评论的说说Id
    @Column(name = "shuoId")
    private int shuoId;

    //评论的日期
    @Column(name = "commentDate")
    private String commentDate;

    //评论者A
    @Column(name = "commentA")
    private String commentA;

    //评论者B
    @Column(name = "commentB")
    private String commentB;

    //评论的内容
    @Column(name = "commentContent")
    private String commentContent;

    public Comment() {

    }

    public Comment(int commentId) {
        this.commentId = commentId;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public String getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(String commentDate) {
        this.commentDate = commentDate;
    }

    public String getCommentA() {
        return commentA;
    }

    public void setCommentA(String commentA) {
        this.commentA = commentA;
    }

    public String getCommentB() {
        return commentB;
    }

    public void setCommentB(String commentB) {
        this.commentB = commentB;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public int getShuoId() {
        return shuoId;
    }

    public void setShuoId(int shuoId) {
        this.shuoId = shuoId;
    }

    public JSONObject CommentToJSON() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("commentA", commentA);
        jsonObject.put("commentB", commentB);
        jsonObject.put("commentContent", commentContent);
        jsonObject.put("commentDate", commentDate);
        jsonObject.put("commentId", commentId);
        jsonObject.put("shuoId", shuoId);
        return jsonObject;
    }
}
