package com.message.server.action;

import com.message.server.dao.ShuoshuoDao;
import com.message.server.model.Shuoshuo;
import com.message.server.utils.ActionSupportUtil;
import net.sf.json.JSONArray;
import org.apache.struts2.convention.annotation.Action;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by SX10100563 on 2016/10/14.
 */
@Controller
public class ShuoshuoAction extends ActionSupportUtil {
    @Resource
    private ShuoshuoDao shuoshuoDao;
    private Shuoshuo shuoshuo;

    public Shuoshuo getShuoshuo() {
        return shuoshuo;
    }

    public void setShuoshuo(Shuoshuo shuoshuo) {
        this.shuoshuo = shuoshuo;
    }

    /**
     * http://localhost:8080/addShuoshuo?shuoshuo.shuoCommentNum=1&shuoshuo.shuoContent=今天天气不错，出去玩玩。&shuoshuo.shuoDate=2016-09-08&shuoshuo.shuoPhoneModel=HUAWEI&shuoshuo.shuoPhraseNum=5&shuoshuo.userName=小华
     *
     * @throws UnsupportedEncodingException
     */
    @Action("addShuoshuo")
    public void addShuo() throws UnsupportedEncodingException {
        shuoshuo.setUserName(new String(shuoshuo.getUserName().getBytes("ISO-8859-1"), "UTF-8"));
        shuoshuo.setShuoContent(new String(shuoshuo.getShuoContent().getBytes("ISO-8859-1"), "UTF-8"));
        shuoshuo.setShuoPhoneModel(new String(shuoshuo.getShuoPhoneModel().getBytes("ISO-8859-1"), "UTF-8"));
        shuoshuoDao.addShuoshuo(shuoshuo);
        renderText("success");
    }

    /**
     * http://localhost:8080/getAllShuoShuo
     */
    @Action("getAllShuoShuo")
    public void getAllShuoShuo() {
        List<Shuoshuo> shuoshuos = shuoshuoDao.selectAllshuo();
        if (shuoshuos == null) {
            renderText("shuoshuo null");
        } else {
            JSONArray json = new JSONArray();
            for (Shuoshuo shuoshuo : shuoshuos) {
                json.add(shuoshuo.ShuoshuoToJSON());
            }
            renderJson(json.toString());
        }
    }
    /**
     * 将说说的点赞数目加一
     * http://localhost:8080/addShuoPhraseNum?shuoshuo.shuoId=1
     */
    @Action("addShuoPhraseNum")
    public void addShuoPhraseNum(){
        shuoshuoDao.addShuoPhraseNum(shuoshuo.getShuoId());
        renderText("success");
    }

    /**
     * 将说说的评论数目加一
     * http://localhost:8080/addShuoCommentNum?shuoshuo.shuoId=1
     */
    @Action("addShuoCommentNum")
    public void addShuoCommentNum(){
        shuoshuoDao.addShuoCommentNum(shuoshuo.getShuoId());
        renderText("success");
    }

    /**
     * 将说说的点赞数目减1
     * http://localhost:8080/subShuoPhraseNum?shuoshuo.shuoId=1
     */
    @Action("subShuoPhraseNum")
    public void subShuoPhraseNum(){
        shuoshuoDao.subShuoPhraseNum(shuoshuo.getShuoId());
        renderText("success");
    }
}
