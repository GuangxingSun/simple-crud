package com.guangxing.aspect;

import com.guangxing.annotation.TestAnnotation;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class  TestAspect {
    final static Logger log = LoggerFactory.getLogger(TestAspect.class);

    ThreadLocal<Long> beginTime = new ThreadLocal<>();

    @Pointcut("@annotation(testAnnotation)")
    public void serviceStatistics(TestAnnotation testAnnotation) {
    }

    @Before("serviceStatistics(testAnnotation)")
    public void doBefore(JoinPoint joinPoint, TestAnnotation testAnnotation) {
        // 记录请求到达时间
        beginTime.set(System.currentTimeMillis());
        log.info("cy666 note:{}", testAnnotation.name());
    }

    @After("serviceStatistics(testAnnotation)")
    public void doAfter(TestAnnotation testAnnotation) {
        log.info("cy666 statistic time:{}, note:{}", System.currentTimeMillis() - beginTime.get(), testAnnotation.name());
    }
}
