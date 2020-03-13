package com.wanpp.test.service;

import com.wanpp.test.dto.UserDTO;

import java.util.List;

/**
 * Copyright (C), 2020-2020, public
 * FileName: IUserService
 *
 * @Author: wanpp
 * @Date: 2020-03-13
 * Description: user service
 * Version: 1.0
 */
public interface IUserService {

    /**
     * @title: selectFuzzyByDto
     * @description: 模糊查询操作
     * @params: [ dto ]
     * @return: java.util.List
     * @createTime: 2020-03-13
     * @version: 1.0
     * @author: wanpp
     */
    public List<UserDTO> selectFuzzyByDto(UserDTO dto);

    /**
     * @title: selectByDto
     * @description: 精确查询操作
     * @params: [ dto ]
     * @return: java.util.List
     * @createTime: 2020-03-13
     * @version: 1.0
     * @author: wanpp
     */
    public List<UserDTO> selectByDto(UserDTO dto);

    /**
     * @title: insertDto
     * @description: 插入操作
     * @params: [ dto ]
     * @return: Integer
     * @createTime: 2020-03-13
     * @version: 1.0
     * @author: wanpp
     */
    public Integer insertDto(UserDTO dto);

    /**
     * @title: updateDto
     * @description: 修改操作
     * @params: [ dto ]
     * @return: Integer
     * @createTime: 2020-03-13
     * @version: 1.0
     * @author: wanpp
     */
    public Integer updateDto(UserDTO dto);

    /**
     * @title: deleteDto
     * @description: 删除操作
     * @params: [ dto ]
     * @return: Integer
     * @createTime: 2020-03-13
     * @version: 1.0
     * @author: wanpp
     */
    public Integer deleteDto(UserDTO dto);
}
