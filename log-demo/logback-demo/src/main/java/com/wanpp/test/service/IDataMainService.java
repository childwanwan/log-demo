package com.wanpp.test.service;

import com.wanpp.test.dto.DataMainDTO;

import java.util.List;

/**
 * Copyright (C), 2020-2020, public
 * FileName: IDataMainService
 *
 * @Author: wanpp
 * @Date: 2020-03-13
 * Description: data_main service
 * Version: 1.0
 */
public interface IDataMainService {

    /**
     * @title: selectFuzzyByDto
     * @description: 模糊查询操作
     * @params: [ dto ]
     * @return: java.util.List
     * @createTime: 2020-03-13
     * @version: 1.0
     * @author: wanpp
     */
    public List<DataMainDTO> selectFuzzyByDto(DataMainDTO dto);

    /**
     * @title: selectByDto
     * @description: 精确查询操作
     * @params: [ dto ]
     * @return: java.util.List
     * @createTime: 2020-03-13
     * @version: 1.0
     * @author: wanpp
     */
    public List<DataMainDTO> selectByDto(DataMainDTO dto);

    /**
     * @title: insertDto
     * @description: 插入操作
     * @params: [ dto ]
     * @return: Integer
     * @createTime: 2020-03-13
     * @version: 1.0
     * @author: wanpp
     */
    public Integer insertDto(DataMainDTO dto);

    /**
     * @title: updateDto
     * @description: 修改操作
     * @params: [ dto ]
     * @return: Integer
     * @createTime: 2020-03-13
     * @version: 1.0
     * @author: wanpp
     */
    public Integer updateDto(DataMainDTO dto);

    /**
     * @title: deleteDto
     * @description: 删除操作
     * @params: [ dto ]
     * @return: Integer
     * @createTime: 2020-03-13
     * @version: 1.0
     * @author: wanpp
     */
    public Integer deleteDto(DataMainDTO dto);
}
