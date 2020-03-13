package com.wanpp.test.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wanpp.test.service.IDataMainService;
import com.wanpp.test.dto.DataMainDTO;
import com.wanpp.utils.ReturnCodeData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;

import javax.annotation.Resource;
import java.util.List;

/**
 * Copyright (C), 2020-2020, public
 * FileName: DataMainController
 *
 * @Author: wanpp
 * @Date: 2020-03-13
 * Description: data_main controller
 * Version: 1.0
 */
@Api(description = " DataMain 控制层")
@RestController
@RequestMapping(value = "/dataMain",produces = "application/json;charset=utf-8")
public class DataMainController {

    private final static Logger logger = LoggerFactory.getLogger(DataMainController.class);

    @Resource
    private IDataMainService dataMainService;

    /**
     * @title: describeFuzzyList
     * @description: 列表分页模糊查询
     * @params: [ paramsDTO, currentPage, pageSize ]
     * @return: org.springframework.http.ResponseEntity
     * @createTime: 2020-03-13
     * @version: 1.0
     * @author: wanpp
     */
    @ApiOperation(value = "列表分页查询", notes = "列表分页查询")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "paramsDTO", value = "实体参数信息", required = true, dataType = "DataMainDTO", paramType = "query"),
        @ApiImplicitParam(name = "currentPage", value = "当前页", required = true, dataType = "Integer", paramType = "query"),
        @ApiImplicitParam(name = "pageSize", value = "一页数据条数", required = true, dataType = "Integer", paramType = "query")
    })
    @RequestMapping(value = "/describe_fuzzy_list", method = RequestMethod.GET)
    public ResponseEntity<JSONObject> describeFuzzyList(@ModelAttribute DataMainDTO paramsDTO,
    @RequestParam(name = "currentPage", required = true) Integer currentPage,
    @RequestParam(name = "pageSize", required = true) Integer pageSize) {
        logger.info("准备执行  列表分页模糊查询，传入的参数为：" + JSON.toJSONString(paramsDTO));
        JSONObject data = new JSONObject();
        try {
            //分页
            Page page = PageHelper.startPage(currentPage, pageSize);
            //执行
            List<DataMainDTO> resultDTOList = dataMainService.selectFuzzyByDto(paramsDTO);
            PageInfo<DataMainDTO> pageInfo = page.toPageInfo();
            pageInfo.setList(resultDTOList);
            data.put("data",pageInfo);
            data.put("msg", "列表分页模糊查询成功");
            data.put("code", ReturnCodeData.SUCCESS);
        } catch (Exception e) {
            logger.error("执行列表分页模糊查询异常，异常信息为：" + JSON.toJSONString(e));
            data.put("msg", e.toString());
            data.put("code", ReturnCodeData.FAIL);
        }
        logger.info("执行列表分页模糊查询完成，准备返回的结果为：" + JSON.toJSONString(data));
        return new ResponseEntity<>(data, HttpStatus.ACCEPTED);
    }

    /**
     * @title: describeList
     * @description: 列表分页精确查询
     * @params: [ paramsDTO, currentPage, pageSize ]
     * @return: org.springframework.http.ResponseEntity
     * @createTime: 2020-03-13
     * @version: 1.0
     * @author: wanpp
     */
    @ApiOperation(value = "列表分页查询", notes = "列表分页查询")
    @ApiImplicitParams({
    @ApiImplicitParam(name = "paramsDTO", value = "实体参数信息", required = true, dataType = "DataMainDTO", paramType = "query"),
    @ApiImplicitParam(name = "currentPage", value = "当前页", required = true, dataType = "Integer", paramType = "query"),
    @ApiImplicitParam(name = "pageSize", value = "一页数据条数", required = true, dataType = "Integer", paramType = "query")
    })
    @RequestMapping(value = "/describe_list", method = RequestMethod.GET)
    public ResponseEntity<JSONObject> describeList(@ModelAttribute DataMainDTO paramsDTO,
        @RequestParam(name = "currentPage", required = true) Integer currentPage,
        @RequestParam(name = "pageSize", required = true) Integer pageSize) {
        logger.info("准备执行  列表分页查询，传入的参数为：" + JSON.toJSONString(paramsDTO));
        JSONObject data = new JSONObject();
        try {
            //分页
            Page page = PageHelper.startPage(currentPage, pageSize);
            //执行
            List<DataMainDTO> resultDTOList = dataMainService.selectFuzzyByDto(paramsDTO);
            PageInfo<DataMainDTO> pageInfo = page.toPageInfo();
            pageInfo.setList(resultDTOList);
            data.put("data",pageInfo);
            data.put("msg", "列表分页查询成功");
            data.put("code", ReturnCodeData.SUCCESS);
        } catch (Exception e) {
            logger.error("执行列表分页查询异常，异常信息为：" + JSON.toJSONString(e));
            data.put("msg", e.toString());
            data.put("code", ReturnCodeData.FAIL);
        }
        logger.info("执行列表分页查询完成，准备返回的结果为：" + JSON.toJSONString(data));
        return new ResponseEntity<>(data, HttpStatus.ACCEPTED);
    }


    /**
     * @title: save
     * @description: 数据插入
     * @params: [ paramsDTO ]
     * @return: org.springframework.http.ResponseEntity
     * @createTime: 2020-03-13
     * @version: 1.0
     * @author: wanpp
     */
    @ApiOperation(value = "数据插入", notes = "数据插入")
    @ApiImplicitParams({@ApiImplicitParam(name = "paramsDTO", value = "实体参数信息", required = true, dataType = "DataMain", paramType = "body")})
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<JSONObject> save(@RequestBody DataMainDTO paramsDTO) {
        logger.info("准备执行 数据插入，传入的参数为：" + JSON.toJSONString(paramsDTO));
        JSONObject data = new JSONObject();
        try {
            //执行
            Integer result = dataMainService.insertDto(paramsDTO);
            data.put("data",result);
            data.put("msg", "数据插入成功");
            data.put("code", ReturnCodeData.SUCCESS);
        } catch (Exception e) {
            logger.error("执行 数据插入 异常，异常信息为：" + JSON.toJSONString(e));
            data.put("msg", e.toString());
            data.put("code", ReturnCodeData.FAIL);
        }
        logger.info("执行 数据插入完成，准备返回的结果为：" + JSON.toJSONString(data));
        return new ResponseEntity<>(data, HttpStatus.ACCEPTED);
    }

    /**
     * @title: update
     * @description: 数据修改
     * @params: [ paramsDTO ]
     * @return: org.springframework.http.ResponseEntity
     * @createTime: 2020-03-13
     * @version: 1.0
     * @author: wanpp
     */
    @ApiOperation(value = "数据修改", notes = "数据修改")
    @ApiImplicitParams({@ApiImplicitParam(name = "paramsDTO", value = "实体参数信息", required = true, dataType = "DataMain", paramType = "body")})
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseEntity<JSONObject> update(@RequestBody DataMainDTO paramsDTO) {
        logger.info("准备执行 数据修改，传入的参数为：" + JSON.toJSONString(paramsDTO));
        JSONObject data = new JSONObject();
        try {
            //执行
            Integer result = dataMainService.updateDto(paramsDTO);
            data.put("data",result);
            data.put("msg", "数据修改成功");
            data.put("code", ReturnCodeData.SUCCESS);
        } catch (Exception e) {
            logger.error("执行 数据修改 异常，异常信息为：" + JSON.toJSONString(e));
            data.put("msg", e.toString());
            data.put("code", ReturnCodeData.FAIL);
        }
        logger.info("执行 数据修改完成，准备返回的结果为：" + JSON.toJSONString(data));
        return new ResponseEntity<>(data, HttpStatus.ACCEPTED);
    }

    /**
     * @title: delete
     * @description: 数据删除
     * @params: [ id ]
     * @return: org.springframework.http.ResponseEntity
     * @createTime: 2020-03-13
     * @version: 1.0
     * @author: wanpp
     */
    @ApiOperation(value = "数据删除", notes = "数据删除")
    @ApiImplicitParams({@ApiImplicitParam(name = "paramsDTO", value = "实体参数信息", required = true, dataType = "DataMain", paramType = "body")})
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ResponseEntity<JSONObject> delete(@RequestBody DataMainDTO paramsDTO) {
        logger.info("准备执行 数据删除，传入的参数为：" + JSON.toJSONString(paramsDTO));
        JSONObject data = new JSONObject();
        try {
            //执行
            Integer result = dataMainService.deleteDto(paramsDTO);
            data.put("data",result);
            data.put("msg", "数据删除成功");
            data.put("code", ReturnCodeData.SUCCESS);
        } catch (Exception e) {
            logger.error("执行 数据删除 异常，异常信息为：" + JSON.toJSONString(e));
            data.put("msg", "数据删除失败");
            data.put("code", ReturnCodeData.FAIL);
        }
        logger.info("执行 数据删除 完成，准备返回的结果为：" + JSON.toJSONString(data));
        return new ResponseEntity<>(data, HttpStatus.ACCEPTED);
    }

}
