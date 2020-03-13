package com.wanpp.test.entity;

import javax.persistence.*;

/**
 * Copyright (C), 2020-2020, public
 * FileName: DataMain
 *
 * @Author: wanpp
 * @Date: 2020-03-13
 * Description: data_main 实体
 * Version: 1.0
 */
@Table(name = "data_main")
public class DataMain {

    /**
     * 
     */
    @Id
    private Integer id;

    @Column(name = "mix_id")
    private Integer mixId;

    @Column(name = "max_id")
    private Integer maxId;

    @Column(name = "des")
    private String des;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMixId() {
        return mixId;
    }

    public void setMixId(Integer mixId) {
        this.mixId = mixId;
    }

    public Integer getMaxId() {
        return maxId;
    }

    public void setMaxId(Integer maxId) {
        this.maxId = maxId;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    @Override
    public String toString() {
        return "DataMain{" +
                "mixId=" + mixId +
                ", maxId=" + maxId +
                ", des=" + des +
                "}";
    }
}
