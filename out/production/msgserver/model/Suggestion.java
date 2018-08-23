package com.message.server.model;

import javax.persistence.*;

/**
 * Created by SX10100563 on 2016/10/26.
 */
@Entity
@Table(name = "suggestion")
public class Suggestion {
    @Id
    @Column(name = "suggestId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int suggestId;

    @Column(name = "suggestDate")
    private String suggestDate;

    @Column(name = "suggestUser")
    private String suggestUser;

    @Column(name = "suggestContent")
    private String suggestContent;

    @Column(name = "suggestPhoneModel")
    private String suggestPhoneModel;

    @Column(name = "suggestPhoneNumber")
    private String suggestPhoneNumber;

    public String getSuggestDate() {
        return suggestDate;
    }

    public void setSuggestDate(String suggestDate) {
        this.suggestDate = suggestDate;
    }

    public String getSuggestUser() {
        return suggestUser;
    }

    public void setSuggestUser(String suggestUser) {
        this.suggestUser = suggestUser;
    }

    public String getSuggestContent() {
        return suggestContent;
    }

    public void setSuggestContent(String suggestContent) {
        this.suggestContent = suggestContent;
    }

    public String getSuggestPhoneModel() {
        return suggestPhoneModel;
    }

    public void setSuggestPhoneModel(String suggestPhoneModel) {
        this.suggestPhoneModel = suggestPhoneModel;
    }

    public int getSuggestId() {
        return suggestId;
    }

    public void setSuggestId(int suggestId) {
        this.suggestId = suggestId;
    }

    public String getSuggestPhoneNumber() {
        return suggestPhoneNumber;
    }

    public void setSuggestPhoneNumber(String suggestPhoneNumber) {
        this.suggestPhoneNumber = suggestPhoneNumber;
    }
}
