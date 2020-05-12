package com.asiainfo.lcims.lcbmi.coaserver.controller;

import com.asiainfo.lcims.lcbmi.coaserver.model.CoaRequest;
import com.asiainfo.lcims.lcbmi.coaserver.model.CoaResponse;
import com.asiainfo.lcims.lcbmi.coaserver.model.OnlineRequest;
import com.asiainfo.lcims.lcbmi.coaserver.model.OnlineResponse;
import com.asiainfo.lcims.lcbmi.coaserver.service.OnlineService;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangjp
 * @date 2020-05-09 16:39
 *
 */

@RestController
public class CoaController {

    private static final Logger logger = LoggerFactory.getLogger(CoaController.class);

    @Autowired
    private OnlineService onlineService;


    @PostMapping("/kickoff")
    public String kickoff(@RequestBody String json) {
        logger.info("request:" + json);
        Gson gson = new Gson();
        CoaRequest coaRequest = gson.fromJson(json, CoaRequest.class);
        String onlineRequest = gson.toJson(new OnlineRequest(coaRequest));
        String response = onlineService.queryOnline(onlineRequest);
        logger.info("response:" + response);
        OnlineResponse onlineResponse = gson.fromJson(response, OnlineResponse.class);
        if (onlineResponse.getOnlineList() == null || onlineResponse.getOnlineList().isEmpty()) {
            // 不存在的在线记录
            return gson.toJson(new CoaResponse("-1", "非在线用户"));
        }
        // 踢下线操作
        Map<String ,String> map = new HashMap<>();
        map.put("302", "2");
        map.put("602", coaRequest.getMdn());
        map.put("3", coaRequest.getNasip());
        map.put("420", coaRequest.getApn());
        map.put("301", coaRequest.getSessionid());
        String operJson = gson.toJson(map);

        String operResp = onlineService.operateOnline(operJson);

        return operResp;
    }
}
