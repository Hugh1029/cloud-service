package com.asiainfo.lcims.lcbmi.coaserver.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author zhangjp
 * @date 2020-05-09 16:38
 */

@FeignClient(value = "onlineserver", fallback = OnlineServiceImpl.class)
public interface OnlineService {

    /**
     * 获取在线信息
     * @param onlineRequest
     * @return
     */
    @GetMapping(value = "/onlineserver/aitest/1.0/online/query")
    String queryOnline(String onlineRequest);

    /**
     *
     * @param operateReq
     * @return
     */
    @PostMapping("/onlineserver/aitest/1.0/online/delete")
    String deleteOnline(String operateReq);

}
