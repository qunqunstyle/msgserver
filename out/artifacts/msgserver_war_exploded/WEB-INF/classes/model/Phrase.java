package com.message.server.model;


import net.sf.json.JSONObject;

import javax.persistence.*;

/**
 * Created by SX10100563 on 2016/10/12.
 */
@Entity
@Table(name = "phrase")
public class Phrase {
    //点赞的Id
    @Id
    @Column(name = "phraseId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int phraseId;

    //点赞的说说Id
    @Column(name = "shuoId")
    private int shuoId;

    //点赞的用户名
    @Column(name = "phraseName")
    private String phraseName;

    //点赞的日期
    @Column(name = "phraseDate")
    private String phraseDate;

    public Phrase() {

    }

    public Phrase(int phraseId) {
        this.phraseId = phraseId;
    }

    public Phrase(int shuoId, String name) {
        this.shuoId=shuoId;
        this.phraseName=name;
    }

    public int getPhraseId() {
        return phraseId;
    }

    public void setPhraseId(int phraseId) {
        this.phraseId = phraseId;
    }

    public String getPhraseName() {
        return phraseName;
    }

    public void setPhraseName(String phraseName) {
        this.phraseName = phraseName;
    }

    public int getShuoId() {
        return shuoId;
    }

    public void setShuoId(int shuoId) {
        this.shuoId = shuoId;
    }

    public String getPhraseDate() {
        return phraseDate;
    }

    public void setPhraseDate(String phraseDate) {
        this.phraseDate = phraseDate;
    }

    public JSONObject PhraseToJSON() {
        JSONObject json = new JSONObject();
        json.put("phraseId", phraseId);
        json.put("shuoId", shuoId);
        json.put("phraseDate", phraseDate);
        json.put("phraseName", phraseName);
        return json;
    }
}
