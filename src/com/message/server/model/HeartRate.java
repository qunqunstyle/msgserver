package model;

import javafx.application.Application;
import javafx.stage.Stage;
import net.sf.json.JSONObject;

import javax.persistence.*;

@Entity
@Table(name = "heartdb")
public class HeartRate extends Application {

    //心率值的ID
    @Id
    @Column(name = "heartId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int heartId;

    //测试人的人名字
    @Column(name = "userName")
    private String userName;

    //心率值
    @Column(name = "heartvalue")
    private String heartvalue;

    //BVP数组
    @Column(name = "BVP")
    private String BVP;

    //测试时间
    @Column(name = "testDate")
    private String testDate;

    //static or sports
    @Column(name = "motion_state")
    private Boolean motion_state;

    //eat or not
    @Column(name = "eating")
    private Boolean eating;

    //speeling or not
    @Column(name = "speeling")
    private Boolean speeling;

    //remarks
    @Column(name = "remark")
    private String remark;




    public int getHeartId() {
        return heartId;
    }

    public void setHeartId(int heartId) {
        this.heartId = heartId;
    }

    public String getHeartvalue() {
        return heartvalue;
    }

    public void setHeartValue(String heartValue) {
        this.heartValue = heartValue;
    }

    public  String getBVP(){
        return BVP;
    }

    public void setBVP(){
        this.BVP = BVP;
    }

    public String getTestDate(){
        return testDate;
    }

    public void setTestDate(String testDate) {
        this.testDate = testDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Boolean getMotion_state() {
        return motion_state;
    }

    public void setMotion_state(){
        this.motion_state = motion_state;
    }

    public Boolean getEating() {
        return eating;
    }

    public void setEating(Boolean eating) {
        this.eating = eating;
    }

    public Boolean getSpeeling() {
        return speeling;
    }

    public void setSpeeling(Boolean speeling) {
        this.speeling = speeling;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public JSONObject HeartRateToJSON() {
        JSONObject json = new JSONObject();
        json.put("heartId", heartId);
        json.put("userName", userName);
        json.put("heartvalue", heartvalue);
        json.put("BVP", BVP);
        json.put("testDate", testDate);
        json.put("motion_state",motion_state);
        json.put("eating",eating);
        json.put("speeling",speeling);
        json.put("remarks",remark);
        return json;
    }
}
