package dao.daoImpl;

import javafx.application.Application;
import javafx.stage.Stage;

import java.util.List;

public class HeartRateDaoInterface extends Application {

    /**
     * 添加一个心率值
     * @param heartrate
     */
    public void addHeartRate(com.message.server.model.HeartRate heartrate);

    /**
     * 通过的ID删除一个心率值
     * @param heartId
     */
    public void delHeartRate(int heartId);

    /**
     * 查找出所有的心率值保存在list中
     */
    public List<com.message.server.model.HeartRate> selectAllheart();
}
