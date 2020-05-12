package com.asiainfo.lcims.lcbmi.coaserver.service;

import com.asiainfo.lcims.lcbmi.coaserver.model.CoaResponse;
import com.google.gson.Gson;

/**
 * @author zhangjp
 * @date 2020-05-11 18:47
 * @qq 34948062
 * @github: https://github.com/Hugh1029
 * @web: https://answering.cn
 * @description
 */
public class OnlineServiceImpl implements OnlineService {

    @Override
    public String queryOnline(String onlineRequest) {
        return new Gson().toJson(new CoaResponse("-1", "在线服务调用失败"));
    }
}
