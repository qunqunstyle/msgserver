package model;

import javafx.application.Application;
import javafx.stage.Stage;
import net.sf.json.JSONObject;

import javax.persistence.*;

@Entity
@Table(name = "heartRate")
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

    //血氧饱和度
    @Column(name = "spo2value")
    private String spo2value;
    //BVP数组
    @Column(name = "BVP")
    private String BVP;

    //测试时间
    @Column(name = "testDate")
    private String testDate;

    //static or sports
    @Column(name = "motion_state")
    private String motion_state;

    //eat or not
    @Column(name = "eating")
    private String eating;

    //speeling or not
    @Column(name = "speeling")
    private String speeling;

    //remarks
    @Column(name = "remark")
    private String remark;




    public HeartRate(){

    }

    public  HeartRate(int heartId){
        this,heartId = heartId;
    }


    public int getHeartId() {
        return heartId;
    }
    public void setHeartId(int heartId) {
        this.heartId = heartId;
    }

    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getHeartvalue() {
        return heartvalue;
    }
    public void setHeartvalue(String heartvalue) {
        this.heartvalue = heartvalue;
    }

    public String getBVP() {
        return BVP;
    }

    public String getSpo2value() {
        return spo2value;
    }

    public void setSpo2value(String spo2value) {
        this.spo2value = spo2value;
    }

    public void setBVP(String BVP) {
        this.BVP = BVP;
    }

    public String getTestDate() {
        return testDate;
    }
    public void setTestDate(String testDate) {
        this.testDate = testDate;
    }

    public String getMotion_state() {
        return motion_state;
    }
    public void setMotion_state(String motion_state) {
        this.motion_state = motion_state;
    }

    public String getEating() {
        return eating;
    }
    public void setEating(String eating) {
        this.eating = eating;
    }

    public String getSpeeling() {
        return speeling;
    }
    public void setSpeeling(String speeling) {
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
        json.put("spo2value", spo2value);
        json.put("BVP", BVP);
        json.put("testDate", testDate);
        json.put("motion_state",motion_state);
        json.put("eating",eating);
        json.put("speeling",speeling);
        json.put("remarks",remark);
        return json;
    }
}
