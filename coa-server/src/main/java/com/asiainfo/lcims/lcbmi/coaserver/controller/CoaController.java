package com.asiainfo.lcims.lcbmi.coaserver.controller;

import com.asiainfo.lcims.lcbmi.coaserver.model.CoaRequest;
import com.asiainfo.lcims.lcbmi.coaserver.model.CoaResponse;
import com.asiainfo.lcims.lcbmi.coaserver.model.OnlineRequest;
import com.asiainfo.lcims.lcbmi.coaserver.model.OnlineResponse;
import com.asiainfo.lcims.lcbmi.coaserver.service.OnlineService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangjp
 * @date 2020-05-09 16:39
 *
 */

@RestController
public class CoaController {

    @Autowired
    private OnlineService onlineService;

    @PostMapping("/kickoff")
    public String kickoff(String json) {
        Gson gson = new Gson();
        CoaRequest coaRequest = gson.fromJson(json, CoaRequest.class);
        String onlineRequest = gson.toJson(new OnlineRequest(coaRequest));
        String response = onlineService.queryOnline(onlineRequest);
        OnlineResponse onlineResponse = gson.fromJson(response, OnlineResponse.class);
        if (onlineResponse.getOnlineList() == null || onlineResponse.getOnlineList().isEmpty()) {
            // 不存在的在线记录
            return gson.toJson(new CoaResponse("-1", "非在线用户"));
        }
        // 踢下线操作

        return gson.toJson(new CoaResponse("0", "强制下线成功"));
    }
}