package com.wanpp.test.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Copyright (C), 2020-2020, public
 * FileName: DataMainDTO
 *
 * @Author: wanpp
 * @Date: 2020-03-13
 * Description: data_main dto实体
 * Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataMainDTO {

    /**
     * 
     */
    private Integer id;

    private Integer mixId;

    private Integer maxId;

    private String des;

    /**
     * 排序字段 + 升序， -降序
     * 比如 +updateTime 根据 修改时间升序排序，-updateTime 根据 修改时间降序排序
     */
    private String orderBy;

}
