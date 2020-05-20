package com.asiainfo.lcims.lcbmi.coaserver.model;

import lombok.Data;

/**
 * @author zhangjp
 * @date 2020-05-09 16:50
 * @qq 34948062
 * @github: https://github.com/Hugh1029
 * @web: https://answering.cn
 * @description
 */

@Data
public class OnlineInfo {
    private String mdn;
    private String apn;
    private String userName;
    private String framedIp;
    private String imsi;
    private String nasIp;
    private String sessionId;
    private String timeLen;
    private String appInfo;
}
