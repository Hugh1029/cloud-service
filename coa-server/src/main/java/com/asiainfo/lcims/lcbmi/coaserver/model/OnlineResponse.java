package com.asiainfo.lcims.lcbmi.coaserver.model;

import lombok.Data;

import java.util.List;

/**
 * @author zhangjp
 * @date 2020-05-09 16:49
 *
 */

@Data
public class OnlineResponse {
    private String sid;
    private List<OnlineInfo> onlineList;
    private String appType;
}
