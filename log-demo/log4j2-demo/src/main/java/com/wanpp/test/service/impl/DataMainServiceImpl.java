package com.wanpp.test.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.wanpp.test.entity.DataMain;
import com.wanpp.test.mapper.DataMainMapper;
import com.wanpp.test.service.IDataMainService;
import com.wanpp.test.dto.DataMainDTO;
import com.wanpp.utils.InitExampleOrderByUtils;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * Copyright (C), 2020-2020, public
 * FileName: DataMainServiceImpl
 *
 * @Author: wanpp
 * @Date: 2020-03-13
 * Description: data_main serviceImpl
 * Version: 1.0
 */
@Service
public class DataMainServiceImpl implements IDataMainService {

    private static final Logger logger = LogManager.getLogger(DataMainServiceImpl.class);

    @Resource
    private DataMainMapper dataMainMapper;

    /**
     * @title: selectFuzzyByDto
     * @description: 模糊查询操作
     * @params: [ dto ]
     * @return: java.util.List
     * @createTime: 2020-03-13
     * @version: 1.0
     * @author: wanpp
     */
    @Override
    public List<DataMainDTO> selectFuzzyByDto(DataMainDTO dto) {
        //List<DataMain> list = dataMainMapper.selectByExample(initFuzzyExample(dto));
        List<DataMain> list = dataMainMapper.describeListByFuzzy(JSONObject.parseObject(JSONObject.toJSONString(dto),DataMain.class));
        return JSONArray.parseArray(JSONArray.toJSONString(list), DataMainDTO.class);
    }

    /**
     * @title: selectByDto
     * @description: 精确查询操作
     * @params: [ dto ]
     * @return: java.util.List
     * @createTime: 2020-03-13
     * @version: 1.0
     * @author: wanpp
     */
    @Override
    public List<DataMainDTO> selectByDto(DataMainDTO dto) {
        //List<DataMain> list = dataMainMapper.selectByExample(initExample(dto));
        List<DataMain> list = dataMainMapper.describeList(JSONObject.parseObject(JSONObject.toJSONString(dto),DataMain.class));
        return JSONArray.parseArray(JSONArray.toJSONString(list), DataMainDTO.class);
    }

    /**
     * @title: insertDto
     * @description: 插入操作
     * @params: [ dto ]
     * @return: Integer
     * @createTime: 2020-03-13
     * @version: 1.0
     * @author: wanpp
     */
    @Override
    public Integer insertDto(DataMainDTO dto) {
        if (null == dto.getId() || "".equals(dto.getId())) {
            dto.setId(0);
        }
        return dataMainMapper.insertDataMain(JSONObject.parseObject(JSON.toJSONString(dto), DataMain.class));
        //return dataMainMapper.insert(JSONObject.parseObject(JSON.toJSONString(dto), DataMain.class));
    }

    /**
     * @title: updateDto
     * @description: 修改操作
     * @params: [ dto ]
     * @return: Integer
     * @createTime: 2020-03-13
     * @version: 1.0
     * @author: wanpp
     */
    @Override
    public Integer updateDto(DataMainDTO dto) {
        if (null != dto && null != dto.getId() && !"".equals(dto.getId())) {
            return dataMainMapper.updateDataMain(JSONObject.parseObject(JSON.toJSONString(dto), DataMain.class));
            //return dataMainMapper.updateByPrimaryKey(JSONObject.parseObject(JSON.toJSONString(dto), DataMain.class));
        } else {
            return 0;
        }
    }

    /**
     * @title: deleteDto
     * @description: 删除操作
     * @params: [ dto ]
     * @return: Integer
     * @createTime: 2020-03-13
     * @version: 1.0
     * @author: wanpp
     */
    @Override
    public Integer deleteDto(DataMainDTO dto) {
        if (null != dto && null != dto.getId() && !"".equals(dto.getId())) {
            return dataMainMapper.deleteDataMain(JSONObject.parseObject(JSON.toJSONString(dto), DataMain.class));
            //return dataMainMapper.deleteByPrimaryKey(dto.getId());
        } else {
            return 0;
        }
    }


    /**
     * @title: initFuzzyExample
     * @description: 初始化 模糊查询 example
     * @params: [ dto ]
     * @return: tk.mybatis.mapper.entity.Example
     * @createTime: 2020-03-13
     * @version: 1.0
     * @author: wanpp
     */
    private Example initFuzzyExample(DataMainDTO dto) {
        Example example = InitExampleOrderByUtils.initExampleOrderBy(DataMain.class, dto.getOrderBy());
        Example.Criteria criteriaName = example.createCriteria();
        if (null != dto) {
            if (null != dto.getMixId() && !"".equals(dto.getMixId())) {
                criteriaName.andLike("MixId", "%" + dto.getMixId() + "%");
            }
            if (null != dto.getMaxId() && !"".equals(dto.getMaxId())) {
                criteriaName.andLike("MaxId", "%" + dto.getMaxId() + "%");
            }
            if (null != dto.getDes() && !"".equals(dto.getDes())) {
                criteriaName.andLike("Des", "%" + dto.getDes() + "%");
            }
        }
        return example;
    }

    /**
     * @title: initExample
     * @description: 初始化 精确查询 example
     * @params: [ dto ]
     * @return: tk.mybatis.mapper.entity.Example
     * @createTime: 2020-03-13
     * @version: 1.0
     * @author: wanpp
     */
    private Example initExample(DataMainDTO dto) {
        Example example = InitExampleOrderByUtils.initExampleOrderBy(DataMain.class, dto.getOrderBy());
        Example.Criteria criteriaName = example.createCriteria();
        if (null != dto) {
            if (null != dto.getMixId() && !"".equals(dto.getMixId())) {
                criteriaName.andEqualTo("MixId", dto.getMixId());
            }
            if (null != dto.getMaxId() && !"".equals(dto.getMaxId())) {
                criteriaName.andEqualTo("MaxId", dto.getMaxId());
            }
            if (null != dto.getDes() && !"".equals(dto.getDes())) {
                criteriaName.andEqualTo("Des", dto.getDes());
            }
        }
        return example;
    }


}
