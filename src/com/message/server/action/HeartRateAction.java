package action;

import com.sun.org.apache.xpath.internal.operations.String;
import dao.HeartRateDao;
import javafx.application.Application;
import javafx.stage.Stage;
import model.HeartRate;
import net.sf.json.JSONArray;
import org.apache.struts2.convention.annotation.Action;

import java.io.UnsupportedEncodingException;
import java.util.List;

public class HeartRateAction extends Application {

    private HeartRate heartRate;
    private HeartRateDao heartRateDao;

    public HeartRate getHeartRate(){
        return heartRate;
    }

    public void setHeartRate(HeartRate heartRate) {
        this.heartRate = heartRate;
    }

    /**
     * http://localhost:8080/addHeartRate
     * @throws UnsupportedEncodingException
     */
    @Action("addHeartRate")
    public void addHeartRate() throws UnsupportedEncodingException {
        heartRate.setUserName(new String(heartRate.getUserName().getBytes("ISO-8859-1"),"UTF-8"));
        heartRate.setHeartValue(new String(heartRate.getHeartvalue().getBytes("ISO-8859-1"), "UTF-8"));
        heartRate.setSpo2Value(new String(heartRate.getSpo2value().getBytes("ISO-8859-1"), "UTF-8"));
        heartRate.getRemark(new String(heartRate.getRemark().getBytes("ISO-8859-1"), "UTF-8"));
        heartRate.getTestDate(new String(heartRate.getTestDate().getBytes("ISO-8859-1"), "UTF-8"));
        heartRate.getBVP(new String(heartRate.getBVP().getBytes("ISO-8859-1"), "UTF-8"));
        heartRate.getMotion_state(new String(heartRate.getMotion_state().getBytes("ISO-8859-1"), "UTF-8"));
        heartRate.getSpeeling(new String(heartRate.getSpeeling().getBytes("ISO-8859-1"), "UTF-8"));
        heartRate.getEating(new String(heartRate.getEating().getBytes("ISO-8859-1"), "UTF-8"));
        heartRateDao.addHeartrate(heartRate);
        renderText("success");
    }

    /**
     * http://localhost:8080/getAllHeartRate
     */
    @Action("getAllHeartRate")
    public void getAllHeartRate() {
        List<com.message.server.model.HeartRate> heartRates = heartRateDao.selectAllheart();
        if (heartRates == null) {
            renderText("heartrate null");
        } else {
            JSONArray json = new JSONArray();
            for (com.message.server.model.HeartRate heartRate : heartRates) {
                json.add(heartRate.HeartRateToJSON());
            }
            renderJson(json.toString());
        }
    }
}
