package com.message.server.action;

import com.message.server.dao.SuggestionDao;
import com.message.server.model.Suggestion;
import com.message.server.utils.ActionSupportUtil;
import org.apache.struts2.convention.annotation.Action;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;

/**
 * Created by SX10100563 on 2016/10/26.
 */
@Controller
public class SuggestionAction extends ActionSupportUtil {
    @Resource
    private SuggestionDao suggestionDao;
    private Suggestion suggestion;

    public Suggestion getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(Suggestion suggestion) {
        this.suggestion = suggestion;
    }

    /**
     * 添加建议
     *http://localhost:8080/addSuggestion?suggestion.suggestDate=2014-10-12&suggestion.suggestUser=test&suggestion.suggestPhoneModel=meizu&suggestion.suggestContent=bugalot
     * @throws UnsupportedEncodingException
     */
    @Action(value = "addSuggestion")
    public void addSuggestion() throws UnsupportedEncodingException {
        suggestion.setSuggestUser(new String(suggestion.getSuggestUser().getBytes("ISO-8859-1"), "UTF-8"));
        suggestion.setSuggestContent(new String(suggestion.getSuggestContent().getBytes("ISO-8859-1"), "UTF-8"));
        suggestion.setSuggestPhoneModel(new String(suggestion.getSuggestPhoneModel().getBytes("ISO-8859-1"), "UTF-8"));
        suggestionDao.addSuggestion(suggestion);
        renderText("success");
    }
}
