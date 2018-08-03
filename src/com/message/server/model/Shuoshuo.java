package com.message.server.model;


import net.sf.json.JSONObject;
import org.springframework.stereotype.Repository;

import javax.persistence.*;

/**
 * Created by SX10100563 on 2016/10/12.
 */
@Repository("shuoshuo")
@Entity
@Table(name = "shuoshuo")
public class Shuoshuo {
    //说说ID
    @Id
    @Column(name = "shuoId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int shuoId;

    //发说说的人名字
    @Column(name = "userName")
    private String userName;

    //说说的内容
    @Column(name = "shuoContent")
    private String shuoContent;

    //发说说的时间
    @Column(name = "shuoDate")
    private String shuoDate;

    //说说点赞的个数
    @Column(name = "shuoPhraseNum")
    private int shuoPhraseNum;

    //说说评论的个数
    @Column(name = "shuoCommentNum")
    private int shuoCommentNum;

    //发说说的手机型号
    @Column(name = "shuoPhoneModel")
    private String shuoPhoneModel;

    public Shuoshuo() {
    }

    public Shuoshuo(int shuoId) {
        this.shuoId = shuoId;
    }

    public int getShuoId() {
        return shuoId;
    }

    public void setShuoId(int shuoId) {
        this.shuoId = shuoId;
    }

    public String getShuoContent() {
        return shuoContent;
    }

    public void setShuoContent(String shuoContent) {
        this.shuoContent = shuoContent;
    }

    public String getShuoDate() {
        return shuoDate;
    }

    public void setShuoDate(String shuoDate) {
        this.shuoDate = shuoDate;
    }

    public int getShuoPhraseNum() {
        return shuoPhraseNum;
    }

    public void setShuoPhraseNum(int shuoPhraseNum) {
        this.shuoPhraseNum = shuoPhraseNum;
    }

    public int getShuoCommentNum() {
        return shuoCommentNum;
    }

    public void setShuoCommentNum(int shuoCommentNum) {
        this.shuoCommentNum = shuoCommentNum;
    }

    public String getShuoPhoneModel() {
        return shuoPhoneModel;
    }

    public void setShuoPhoneModel(String shuoPhoneModel) {
        this.shuoPhoneModel = shuoPhoneModel;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public JSONObject ShuoshuoToJSON() {
        JSONObject json = new JSONObject();
        json.put("shuoId", shuoId);
        json.put("userName", userName);
        json.put("shuoContent", shuoContent);
        json.put("shuoDate", shuoDate);
        json.put("shuoPhraseNum", shuoPhraseNum);
        json.put("shuoPhoneModel", shuoPhoneModel);
        json.put("shuoCommentNum", shuoCommentNum);
        return json;
    }
}
