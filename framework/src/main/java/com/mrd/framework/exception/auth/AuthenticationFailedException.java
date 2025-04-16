package com.mrd.framework.exception.auth;

import com.mrd.framework.exception.BaseException;

/**
 * Exception indication Authentication failure
 *
 * @author: Y Kamesh Rao
 */
public class AuthenticationFailedException extends BaseException {
    private static final long serialVersionUID = -8799659324455306881L;


    public AuthenticationFailedException(String message) {
        super(message);
    }


    public AuthenticationFailedException(String message, Object errorCode) {
        super(message, errorCode);
    }
}
