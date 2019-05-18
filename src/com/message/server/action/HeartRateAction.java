package com.message.server.action;


import com.message.server.dao.HeartRateDao;
import com.message.server.model.HeartRate;
import com.opensymphony.xwork2.ModelDriven;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.struts2.convention.annotation.Action;
import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.util.List;
import com.message.server.utils.ActionSupportUtil;
import org.omg.CORBA.Request;
import org.springframework.stereotype.Controller;


@Controller
public class HeartRateAction extends ActionSupportUtil implements ModelDriven<HeartRate>{

    private HeartRate heartRate;
    @Resource
    private HeartRateDao heartRateDao;


    public HeartRate getHeartRate(){
        return heartRate;
    }
    @Override
    public HeartRate getModel(){
        if(heartRate == null){
            heartRate = new HeartRate();
        }
        return heartRate;
    }

    public void setHeartRate(HeartRate heartRate) {
        this.heartRate = heartRate;
    }

    /**
     * http://localhost:8080/addHeartRate
     * @throws UnsupportedEncodingException
     */
    @Action(value ="addHeartRate")
    public void addHeartRate() throws UnsupportedEncodingException {
        //LOG.info("request",heartRate.getUserName());
        //LOG.info("request",heartRate.getEating());
        System.out.println("request 1 getUserName =====> "+heartRate.getUserName());
        System.out.println("request 2 getBvp =====> "+heartRate.getBvp());
        System.out.println("request 2 getBvp.length =====> "+heartRate.getBvp().length());
        heartRate.setUserName(new String(heartRate.getUserName().getBytes("ISO-8859-1"),"UTF-8"));
        heartRate.setHeartvalue(new String(heartRate.getHeartvalue().getBytes("ISO-8859-1"), "UTF-8"));
        heartRate.setSpo2value(new String(heartRate.getSpo2value().getBytes("ISO-8859-1"), "UTF-8"));
        //heartRate.setBVP(new String(heartRate.getBVP().getBytes("ISO-8859-1"), "UTF-8"));
        heartRate.setTestDate(new String(heartRate.getTestDate().getBytes("ISO-8859-1"), "UTF-8"));
        heartRate.setEating(new String(heartRate.getEating().getBytes("ISO-8859-1"), "UTF-8"));
        heartRate.setSleeping(new String(heartRate.getSleeping().getBytes("ISO-8859-1"), "UTF-8"));
        heartRate.setMotion_state(new String(heartRate.getMotion_state().getBytes("ISO-8859-1"), "UTF-8"));
        heartRate.setRemark(new String(heartRate.getRemark().getBytes("ISO-8859-1"), "UTF-8"));
        heartRate.setPhoneModel(new String(heartRate.getPhoneModel().getBytes("ISO-8859-1"), "UTF-8"));

        //LOG.info("request",heartRate.getUserName());
        //LOG.info("request",heartRate.getEating());
        heartRateDao.addHeartrate(heartRate);
        renderText("success");
    }

    /**
     * http://localhost:8080/getAllHeartRate
     */
    @Action(value ="getAllHeartRate")
    public void getAllHeartRate() {
        try{
            //把ISO-8859-1编码的值变成utf-8
            String username = new String(heartRate.getUserName().getBytes("ISO-8859-1"), "utf-8");
            List<HeartRate> heartRates = heartRateDao.selectAllheart(username);
            System.out.println(username);

            if (heartRates == null) {
                renderText("heartrate null");
            } else {
                JSONArray json = new JSONArray();
                for (HeartRate heartRate : heartRates) {
                    json.add(heartRate.HeartRateToJSON());
                }
                renderJson(json.toString());
            }
        }catch (Exception e){
            System.out.println("输入存在问题");
        }

    }
}
