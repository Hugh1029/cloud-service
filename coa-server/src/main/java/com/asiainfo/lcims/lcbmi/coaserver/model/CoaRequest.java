package com.asiainfo.lcims.lcbmi.coaserver.model;

import lombok.Data;

/**
 * @author zhangjp
 * @date 2020-05-09 16:01
 *
 */

@Data
public class CoaRequest {

    private String sessionid;
    private String mdn;
    private String nasip;
    private String apn;
}
