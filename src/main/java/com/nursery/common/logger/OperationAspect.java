package com.nursery.common.logger;



import com.nursery.common.annotations.OperationAnnotation;
import com.nursery.common.util.IdGen;
import com.nursery.mapper.OperationMapper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Arrays;

@Order
@Aspect
@Component
public class OperationAspect {


    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private OperationMapper operationMapper;

    @AfterReturning("@annotation(com.nursery.common.annotations.OperationAnnotation)")
    public void afterMethod(JoinPoint joinPoint){
        logger.info("开始操作日志=======");
        MethodSignature methodSignature = (MethodSignature)joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        OperationAnnotation annotation = method.getAnnotation(OperationAnnotation.class);
        long beginTime = System.currentTimeMillis();//1、开始时间
        logger.debug("开始计时: {}  URI: {}", new SimpleDateFormat("hh:mm:ss.SSS")
                .format(beginTime), "ClassName:"+method.getDeclaringClass().getName()+"method.getName():"+method.getName()+"操作内容："+annotation.context());
        logger.info("结束记录操作日志》》》》》》》》》》》》》");
        Operation operation = new Operation();
        operation.setId(IdGen.uuid());
        operation.setClassName(method.getDeclaringClass().getName());
        operation.setMethodName(method.getName());
        operation.setParams(Arrays.toString(joinPoint.getArgs()));
        operation.setContent(annotation.context());
        operation.setUid(null); // 用户id
        operationMapper.insert(operation);
        logger.debug("开始时间: {} ", new SimpleDateFormat("hh:mm:ss.SSS")
                .format(beginTime));
    }

}
