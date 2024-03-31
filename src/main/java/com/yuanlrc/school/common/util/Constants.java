package com.yuanlrc.school.common.util;

public class Constants {

    /**
     * shiro采用加密算法
     */
    public static final String HASH_ALGORITHM = "SHA-1";

    /**
     * 生成Hash值的迭代次数
     */
    public static final int HASH_INTERATIONS = 1024;

    /**
     * 生成盐的长度
     */
    public static final int SALT_SIZE = 8;

    /**
     * 验证码
     */
    public static final String VALIDATE_CODE = "validateCode";

    /**
     *系统用户默认密码
     */
    public static final String DEFAULT_PASSWORD = "123456";
}
