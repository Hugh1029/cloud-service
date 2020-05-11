package com.asiainfo.lcims.lcbmi.coaserver.service;

import com.asiainfo.lcims.lcbmi.coaserver.model.OnlineResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author zhangjp
 * @date 2020-05-09 16:38
 */

@FeignClient("online-server")
public interface OnlineService {

    @GetMapping("/online/query")
    String queryOnline(String onlineRequest);

}
