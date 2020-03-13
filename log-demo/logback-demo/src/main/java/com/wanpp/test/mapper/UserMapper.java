package com.wanpp.test.mapper;

import com.wanpp.test.entity.User;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * Copyright (C), 2020-2020, public
 * FileName: UserMapper
 *
 * @Author: wanpp
 * @Date: 2020-03-13
 * Description: user mapper
 * Version: 1.0
 */
public interface UserMapper extends Mapper<User> {

    /**
     * @title: describeListByFuzzy
     * @description: 模糊列表查询
     * @params: [ User ]
     * @return: java.util.List
     * @createTime: 2020-03-13
     * @version: 1.0
     * @author: wanpp
     */
    public List<User> describeListByFuzzy(User User);

    /**
     * @title: describeListByFuzzy
     * @description: 精确列表查询
     * @params: [ User ]
     * @return: java.util.List
     * @createTime: 2020-03-13
     * @version: 1.0
     * @author: wanpp
     */
    public List<User> describeList(User User);

    /**
     * @title: updateUser
     * @description: 更新
     * @params: [ User ]
     * @return: java.lang.Integer
     * @createTime: 2020-03-13
     * @version: 1.0
     * @author: wanpp
     */
    public Integer updateUser(User User);

    /**
     * @title: insertUser
     * @description: 插入
     * @params: [ User ]
     * @return: java.lang.Integer
     * @createTime: 2020-03-13
     * @version: 1.0
     * @author: wanpp
     */
    public Integer insertUser(User User);

    /**
     * @title: deleteUser
     * @description: 删除
     * @params: [ User ]
     * @return: java.lang.Integer
     * @createTime: 2020-03-13
     * @version: 1.0
     * @author: wanpp
     */
    public Integer deleteUser(User User);
}
