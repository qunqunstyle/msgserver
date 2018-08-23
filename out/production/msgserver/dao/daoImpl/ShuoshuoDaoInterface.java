package com.message.server.dao.daoImpl;

import com.message.server.model.Shuoshuo;

import java.util.List;

/**
 * Created by SX10100563 on 2016/10/12.
 */
public interface ShuoshuoDaoInterface {
    /**
     * 添加一个说说
     * @param shuo
     */
    public void addShuoshuo(Shuoshuo shuo);

    /**
     * 通过说说的ID删除一个说说
     * @param shuoId
     */
    public void delShuoshuo(int shuoId);

    /**
     * 查找出所有的说说保存在list中
     */
    public List<Shuoshuo> selectAllshuo();
}
