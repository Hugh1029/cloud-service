package com.asiainfo.lcims.lcbmi.coaserver.model;

import lombok.Data;

/**
 * @author zhangjp
 * @date 2020-05-09 16:41
 * @qq 34948062
 * @github: https://github.com/Hugh1029
 * @web: https://answering.cn
 * @description
 */

@Data
public class OnlineRequest {
    private String mdn;
    private String apn;

    public OnlineRequest() {}

    public OnlineRequest(CoaRequest coaRequest) {
        this.mdn = coaRequest.getMdn();
        this.apn = coaRequest.getApn();
    }
}
