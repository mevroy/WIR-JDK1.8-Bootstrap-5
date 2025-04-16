package com.mrd.yourwebproject.common;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import com.mrd.yourwebproject.model.entity.enums.Role;


/**
 * @author Mevan D Souza
 *
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckPermission {
	Role[] allowedRoles();
}
