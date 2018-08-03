package com.message.server.action;

import com.message.server.dao.PhraseDao;
import com.message.server.model.Phrase;
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
public class PhraseAction extends ActionSupportUtil {
    @Resource
    private PhraseDao phraseDao;
    private Phrase phrase;

    public Phrase getPhrase() {
        return phrase;
    }

    public void setPhrase(Phrase phrase) {
        this.phrase = phrase;
    }

    /**
     * 通过一个说说的id查找该说说所有的点赞信息
     * http://localhost:8080/getShuoPhrase?phrase.shuoId=1
     */
    @Action("getShuoPhrase")
    public void getShuoPhrase() {
        List<Phrase> phraseList = phraseDao.selectByShuoId(phrase.getShuoId());
        if (phraseList == null) {
            renderText("该说说点赞未空");
        } else {
            JSONArray jsonArray = new JSONArray();
            for (Phrase phrase : phraseList) {
                jsonArray.add(phrase.PhraseToJSON());
            }
            renderJson(jsonArray.toString());
        }
    }

    /**
     * 添加说说的点赞信息。
     * http://localhost:8080/addShuoPhrase?phrase.shuoId=12&phrase.phraseName=曹俊胜&phrase.phraseDate=2016-10-12
     */
    @Action("addShuoPhrase")
    public void addShuoPhrase() throws UnsupportedEncodingException {
        phrase.setPhraseName(new String(phrase.getPhraseName().getBytes("ISO-8859-1"), "UTF-8"));
        phraseDao.addPhrase(phrase);
        renderText("success");
    }

    /**
     * http://localhost:8080/delShuoPhrase?phrase.phraseName=曹俊胜&phrase.shuoId=12
     * 删除说说点赞的信息
     */
    @Action("delShuoPhrase")
    public void delShuoPhrase() throws UnsupportedEncodingException {
        phrase.setPhraseName(new String(phrase.getPhraseName().getBytes("ISO-8859-1"), "UTF-8"));
        phraseDao.delPhrase(phrase.getShuoId(), phrase.getPhraseName());
        renderText("success");
    }

    /**
     * http://localhost:8080/isPhraseByCurrentUser?phrase.shuoId=12&phrase.phraseName=曹俊胜
     * @throws UnsupportedEncodingException
     */
    @Action("isPhraseByCurrentUser")
    public void isPhraseByCurrentUser() throws UnsupportedEncodingException {
        phrase.setPhraseName(new String(phrase.getPhraseName().getBytes("ISO-8859-1"), "UTF-8"));
        Boolean result = phraseDao.isPhraseByCurrentUser(phrase);
        if (result) {
            renderText("success");
        } else {
            renderText("fail");
        }
    }
}
