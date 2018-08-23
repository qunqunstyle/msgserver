package com.message.server.dao.daoImpl;

import com.message.server.model.Phrase;

import java.util.List;

/**
 * Created by SX10100563 on 2016/10/12.
 */
public interface PhraseDaoInterface {
    /**
     * 添加一个点赞信息
     * @param phrase
     */
    public void addPhrase(Phrase phrase);

    /**
     *
     */
    public void delPhrase(int shuoId, String phraseName);

    /**
     * 通过一个说说的ID查找出所有的点赞信息。
     * @param shuoId
     * @return
     */
    public List<Phrase> selectByShuoId(int shuoId);
}
