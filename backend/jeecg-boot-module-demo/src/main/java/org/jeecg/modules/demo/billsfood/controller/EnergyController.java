package org.jeecg.modules.demo.billsfood.controller;

import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.jeecg.common.aspect.annotation.AutoLog;
import org.jeecg.modules.demo.billsfood.utils.FileToJson;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "energy")
@RestController
@RequestMapping("/billsfood")
@Slf4j
public class EnergyController {

    @AutoLog(value = "voltage-分页列表查询")
    @ApiOperation(value = "voltage-分页列表查询", notes = "voltage-分页列表查询")
    @GetMapping(value = "/energy/voltage")
    public JSONObject queryVoltage() {
        String URI = "billsfood/json/voltage.json";
        JSONObject json = FileToJson.fileToJson(URI);
        return json;
    }

    @AutoLog(value = "ecodaily-分页列表查询")
    @ApiOperation(value = "ecodaily-分页列表查询", notes = "ecodaily-分页列表查询")
    @GetMapping(value = "/energy/ecodaily")
    public JSONObject queryEcodaily() {
        String URI = "billsfood/json/store_daily.json";
        JSONObject json = FileToJson.fileToJson(URI);
        return json;
    }

    @AutoLog(value = "powerfactor-分页列表查询")
    @ApiOperation(value = "powerfactor-分页列表查询", notes = "powerfactor-分页列表查询")
    @GetMapping(value = "/energy/powerfactor")
    public JSONObject queryFactor() {
        String URI = "billsfood/json/powerfactor.json";
        JSONObject json = FileToJson.fileToJson(URI);
        return json;
    }

    @AutoLog(value = "order-分页列表查询")
    @ApiOperation(value = "order-分页列表查询", notes = "order-分页列表查询")
    @GetMapping(value = "erp/order")
    public JSONObject queryPageList() {
        String URI = "billsfood/json/order.json";
        JSONObject json = FileToJson.fileToJson(URI);
        return json;
    }

    @AutoLog(value = "inspection-分页列表查询")
    @ApiOperation(value = "inspection-分页列表查询", notes = "inspection-分页列表查询")
    @GetMapping(value = "inspection")
    public JSONObject queryInspection() {
        String URI = "billsfood/json/inspection.json";
        JSONObject json = FileToJson.fileToJson(URI);
        return json;
    }
}
