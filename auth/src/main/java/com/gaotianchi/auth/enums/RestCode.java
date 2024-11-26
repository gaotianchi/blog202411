package com.gaotianchi.auth.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author gaotianchi
 * @since 2024/11/23 18:58
 **/
@Getter
@AllArgsConstructor
public enum RestCode {
    SUCCESS(0, "Success"),
    FAIL(1, "Operation failed."),

    // sql error
    SQL_INSERT_ERROR(1001, "SQL insert operation failed"),
    SQL_UPDATE_ERROR(1002, "SQL update operation failed"),
    SQL_DELETE_ERROR(1003, "SQL delete operation failed"),
    SQL_SELECT_ERROR(1004, "SQL select operation failed"),


    // 4xx 客户端错误
    BAD_REQUEST(400, "Bad request"),
    ACCESS_DENIED(403, "Access denied."),
    INVALID_INPUT(460, "Invalid User Input"),
    PERMISSION_DENIED(461, "Permission Denied"),
    RESOURCE_EXPIRED(462, "Resource Expired"),
    RATE_LIMIT_EXCEEDED(463, "Rate Limit Exceeded"),

    // 5xx 服务器错误
    SERVER_ERROR(500, "Internal Server Error"),
    THIRD_PARTY_FAILURE(550, "Third-Party Service Failure"),
    DATABASE_UNAVAILABLE(551, "Database Unavailable"),
    DATA_CONFLICT(552, "Data Conflict"),

    UNKNOWN_ERROR(9999, "Unknown error");

    private final int code;
    private final String message;

    // 根据状态码获取枚举
    public static RestCode fromCode(int code) {
        for (RestCode status : RestCode.values()) {
            if (status.getCode() == code) {
                return status;
            }
        }
        throw new IllegalArgumentException("No matching status code for: " + code);
    }
}
