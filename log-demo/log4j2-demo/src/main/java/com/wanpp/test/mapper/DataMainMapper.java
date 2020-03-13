package com.wanpp.test.mapper;

import com.wanpp.test.entity.DataMain;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * Copyright (C), 2020-2020, public
 * FileName: DataMainMapper
 *
 * @Author: wanpp
 * @Date: 2020-03-13
 * Description: data_main mapper
 * Version: 1.0
 */
public interface DataMainMapper extends Mapper<DataMain> {

    /**
     * @title: describeListByFuzzy
     * @description: 模糊列表查询
     * @params: [ DataMain ]
     * @return: java.util.List
     * @createTime: 2020-03-13
     * @version: 1.0
     * @author: wanpp
     */
    public List<DataMain> describeListByFuzzy(DataMain DataMain);

    /**
     * @title: describeListByFuzzy
     * @description: 精确列表查询
     * @params: [ DataMain ]
     * @return: java.util.List
     * @createTime: 2020-03-13
     * @version: 1.0
     * @author: wanpp
     */
    public List<DataMain> describeList(DataMain DataMain);

    /**
     * @title: updateDataMain
     * @description: 更新
     * @params: [ DataMain ]
     * @return: java.lang.Integer
     * @createTime: 2020-03-13
     * @version: 1.0
     * @author: wanpp
     */
    public Integer updateDataMain(DataMain DataMain);

    /**
     * @title: insertDataMain
     * @description: 插入
     * @params: [ DataMain ]
     * @return: java.lang.Integer
     * @createTime: 2020-03-13
     * @version: 1.0
     * @author: wanpp
     */
    public Integer insertDataMain(DataMain DataMain);

    /**
     * @title: deleteDataMain
     * @description: 删除
     * @params: [ DataMain ]
     * @return: java.lang.Integer
     * @createTime: 2020-03-13
     * @version: 1.0
     * @author: wanpp
     */
    public Integer deleteDataMain(DataMain DataMain);
}
