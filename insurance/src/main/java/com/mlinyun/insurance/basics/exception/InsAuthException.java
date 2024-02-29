package com.mlinyun.insurance.basics.exception;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.security.authentication.InternalAuthenticationServiceException;

/**
 * InternalAuthenticationServiceException 异常处理类
 */
public class InsAuthException extends InternalAuthenticationServiceException {

    private static final long serialVersionUID = 1L;

    private static final String DEFAULT_MSG = "系统鉴权失败";

    @ApiModelProperty(value = "异常消息内容")
    private String msg;

    public InsAuthException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public InsAuthException() {
        super(DEFAULT_MSG);
        this.msg = DEFAULT_MSG;
    }

    public InsAuthException(String msg, Throwable t) {
        super(msg, t);
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
