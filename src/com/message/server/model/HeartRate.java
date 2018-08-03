package model;

import javafx.application.Application;
import javafx.stage.Stage;
import net.sf.json.JSONObject;

import javax.persistence.*;

@Entity
@Table(name = "commentdb")
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

    public JSONObject HeartRateToJSON() {
        JSONObject json = new JSONObject();
        json.put("heartId", heartId);
        json.put("userName", userName);
        json.put("heartvalue", heartvalue);
        json.put("BVP", BVP);
        json.put("testDate", testDate);
        return json;
    }
}
