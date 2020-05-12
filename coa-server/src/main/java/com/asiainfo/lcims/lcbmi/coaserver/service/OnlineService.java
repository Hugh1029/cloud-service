package com.asiainfo.lcims.lcbmi.coaserver.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
    @GetMapping("/online/query")
    String queryOnline(String onlineRequest);

    /**
     *
     * @param operateReq
     * @return
     */
    @PostMapping("/online/operate")
    String operateOnline(String operateReq);

}
