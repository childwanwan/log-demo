package com.wanpp.test.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.wanpp.test.entity.User;
import com.wanpp.test.mapper.UserMapper;
import com.wanpp.test.service.IUserService;
import com.wanpp.test.dto.UserDTO;
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
 * FileName: UserServiceImpl
 *
 * @Author: wanpp
 * @Date: 2020-03-13
 * Description: user serviceImpl
 * Version: 1.0
 */
@Service
public class UserServiceImpl implements IUserService {

    private static final Logger logger = LogManager.getLogger(UserServiceImpl.class);

    @Resource
    private UserMapper userMapper;

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
    public List<UserDTO> selectFuzzyByDto(UserDTO dto) {
        //List<User> list = userMapper.selectByExample(initFuzzyExample(dto));
        List<User> list = userMapper.describeListByFuzzy(JSONObject.parseObject(JSONObject.toJSONString(dto),User.class));
        return JSONArray.parseArray(JSONArray.toJSONString(list), UserDTO.class);
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
    public List<UserDTO> selectByDto(UserDTO dto) {
        //List<User> list = userMapper.selectByExample(initExample(dto));
        List<User> list = userMapper.describeList(JSONObject.parseObject(JSONObject.toJSONString(dto),User.class));
        return JSONArray.parseArray(JSONArray.toJSONString(list), UserDTO.class);
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
    public Integer insertDto(UserDTO dto) {
        if (null == dto.getId() || "".equals(dto.getId())) {
            dto.setId(UUID.randomUUID().toString());
        }
        return userMapper.insertUser(JSONObject.parseObject(JSON.toJSONString(dto), User.class));
        //return userMapper.insert(JSONObject.parseObject(JSON.toJSONString(dto), User.class));
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
    public Integer updateDto(UserDTO dto) {
        if (null != dto && null != dto.getId() && !"".equals(dto.getId())) {
            return userMapper.updateUser(JSONObject.parseObject(JSON.toJSONString(dto), User.class));
            //return userMapper.updateByPrimaryKey(JSONObject.parseObject(JSON.toJSONString(dto), User.class));
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
    public Integer deleteDto(UserDTO dto) {
        if (null != dto && null != dto.getId() && !"".equals(dto.getId())) {
            return userMapper.deleteUser(JSONObject.parseObject(JSON.toJSONString(dto), User.class));
            //return userMapper.deleteByPrimaryKey(dto.getId());
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
    private Example initFuzzyExample(UserDTO dto) {
        Example example = InitExampleOrderByUtils.initExampleOrderBy(User.class, dto.getOrderBy());
        Example.Criteria criteriaName = example.createCriteria();
        if (null != dto) {
            if (null != dto.getUsername() && !"".equals(dto.getUsername())) {
                criteriaName.andLike("Username", "%" + dto.getUsername() + "%");
            }
            if (null != dto.getPassword() && !"".equals(dto.getPassword())) {
                criteriaName.andLike("Password", "%" + dto.getPassword() + "%");
            }
            if (null != dto.getNickname() && !"".equals(dto.getNickname())) {
                criteriaName.andLike("Nickname", "%" + dto.getNickname() + "%");
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
    private Example initExample(UserDTO dto) {
        Example example = InitExampleOrderByUtils.initExampleOrderBy(User.class, dto.getOrderBy());
        Example.Criteria criteriaName = example.createCriteria();
        if (null != dto) {
            if (null != dto.getUsername() && !"".equals(dto.getUsername())) {
                criteriaName.andEqualTo("Username", dto.getUsername());
            }
            if (null != dto.getPassword() && !"".equals(dto.getPassword())) {
                criteriaName.andEqualTo("Password", dto.getPassword());
            }
            if (null != dto.getNickname() && !"".equals(dto.getNickname())) {
                criteriaName.andEqualTo("Nickname", dto.getNickname());
            }
        }
        return example;
    }


}
