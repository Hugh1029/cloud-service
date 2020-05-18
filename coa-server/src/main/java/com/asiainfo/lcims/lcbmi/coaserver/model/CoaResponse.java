package com.asiainfo.lcims.lcbmi.coaserver.model;

import lombok.Data;

/**
 * @author zhangjp
 * @date 2020-05-09 16:35
 *
 */
@Data
public class CoaResponse {
    private String success;
    private String error;
    private String appInfo;

    public CoaResponse(String error, String appInfo) {
        this.error = error;
        this.appInfo = appInfo;
    }
}
