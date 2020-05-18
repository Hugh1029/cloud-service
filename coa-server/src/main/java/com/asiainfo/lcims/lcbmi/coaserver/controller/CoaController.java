package com.asiainfo.lcims.lcbmi.coaserver.controller;

import com.asiainfo.lcims.lcbmi.coaserver.model.*;
import com.asiainfo.lcims.lcbmi.coaserver.service.OnlineService;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangjp
 * @date 2020-05-09 16:39
 *
 */

@RestController
@RequestMapping("/coaserver/aitest/1.0")
public class CoaController {

    private static final Logger logger = LoggerFactory.getLogger("controller");

    @Autowired
    private OnlineService onlineService;

    @Value("${server.port}")
    private String port;

    private static InetAddress address;


    @PostMapping("/online/delete")
    public String deleteOnline(@RequestBody String json) {
        Gson gson = new Gson();
        try {
            logger.info("request:{}", json);
            CoaRequest coaRequest = gson.fromJson(json, CoaRequest.class);
            String onlineRequest = gson.toJson(new OnlineRequest(coaRequest));
            String response = onlineService.queryOnline(onlineRequest);
            logger.info("query response:{}", response);
            if (response.indexOf("error") == -1) {
                // 不存在的在线记录
                List<OnlineInfo> list = gson.fromJson(response, ArrayList.class);
                if (list != null && !list.isEmpty()) {
                    // 踢下线操作
                    String operResp = onlineService.deleteOnline(json);
                    logger.info("delete online response:{}", operResp);
                    return operResp;
                }
            }
            address = InetAddress.getLocalHost();
            return gson.toJson(new CoaResponse("不在线的记录", "java," + address.getHostAddress() + ":" + port));
        }catch (Exception e) {
            logger.error("error:", e);
            return gson.toJson(new CoaResponse("出错了", "java," + port));
        }
    }
}
