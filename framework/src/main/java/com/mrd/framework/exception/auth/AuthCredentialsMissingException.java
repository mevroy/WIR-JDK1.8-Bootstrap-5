package com.mrd.framework.exception.auth;

import com.mrd.framework.exception.BaseException;

/**
 * Exception indicating Auth credentials missing.
 *
 * @author: Y Kamesh Rao
 */
public class AuthCredentialsMissingException extends BaseException {
    private static final long serialVersionUID = 672693922566865605L;


    public AuthCredentialsMissingException(String message) {
        super(message);
    }


    public AuthCredentialsMissingException(String message, Object errorCode) {
        super(message, errorCode);
    }
}
