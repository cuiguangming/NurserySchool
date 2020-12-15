package com.nursery.common.logger;

import lombok.Data;

@Data
public class Operation {


    private String id;

    private String params;//参数

    private String methodName;//方法名

    private String className;//类名

    private String content;//操作内容

    private String uid;//用户id
}
