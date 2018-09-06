package com.message.server.dao.daoImpl;


import com.message.server.model.HeartRate;

import java.util.List;

public interface HeartRateDaoInterface  {

    /**
     * 添加一个心率值
     * @param heartrate
     */
    public void addHeartrate(HeartRate heartrate);

    /**
     * 通过的ID删除一个心率值
     * @param heartId
     */
    public void delHeartRate(int heartId);

    /**
     * 查找出所有的心率值保存在list中
     */
    public List<HeartRate> selectAllheart(String userName);
}
