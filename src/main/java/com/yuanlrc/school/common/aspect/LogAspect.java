package com.yuanlrc.school.common.aspect;

import com.alibaba.fastjson.JSONObject;
import com.yuanlrc.school.common.annotation.SysLog;
import com.yuanlrc.school.common.config.MySysUser;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;

@Aspect
@Component
public class LogAspect {

    private Logger logger = LoggerFactory.getLogger(LogAspect.class);

    private ThreadLocal<Long> startTime = new ThreadLocal<>();

    @Pointcut("@annotation(com.yuanlrc.school.common.annotation.SysLog)")
    public void webLog(){}

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) {
        startTime.set(System.currentTimeMillis());
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        HttpSession session = (HttpSession) attributes.resolveReference(RequestAttributes.REFERENCE_SESSION);
        logger.info("classMethod:======>" + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.info("method:======>" + request.getMethod());
        //获取传入目标方法的参数
        Object[] args = joinPoint.getArgs();
        for (int i = 0; i < args.length; i++) {
            Object o = args[i];
            if(o instanceof ServletRequest || (o instanceof ServletResponse) || o instanceof MultipartFile){
                args[i] = o.toString();
            }
        }

        String str = JSONObject.toJSONString(args);
        str = str.length() > 2000 ? str.substring(2000) : str;
        logger.info("params:======>" + str);

        if(session != null){
            logger.info("session id :======>" + session.getId());
        }

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        SysLog mylog = method.getAnnotation(SysLog.class);
        if(mylog != null){
            //注解上的描述
            logger.info("mylog:======>" + mylog.value());
        }

        if(MySysUser.ShiroUser() != null) {
            String username = StringUtils.isNotBlank(MySysUser.nickName()) ? MySysUser.nickName() : MySysUser.loginName();
            logger.info("user:======>" + username);
        }
    }

    @Around("webLog()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        try {
            Object obj = proceedingJoinPoint.proceed();
            return obj;
        } catch (Exception e) {
            logger.error("exception message :======>" + e.getMessage());
            throw e;
        }
    }

    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) {
        if(MySysUser.ShiroUser() != null) {
            String username = StringUtils.isNotBlank(MySysUser.nickName()) ? MySysUser.nickName() : MySysUser.loginName();
            logger.info("user:======>" + username);
        }
        String retString = JSONObject.toJSONString(ret);
        retString = retString.length() > 2000 ? retString.substring(2000) : retString;
        logger.info("ret:======>" + retString);
        logger.info("useTime:======>" + (System.currentTimeMillis() - startTime.get()) + "");
    }


}
