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

    // 4xx 客户端错误
    INVALID_INPUT(460, "Invalid User Input"),
    PERMISSION_DENIED(461, "Permission Denied"),
    RESOURCE_EXPIRED(462, "Resource Expired"),
    RATE_LIMIT_EXCEEDED(463, "Rate Limit Exceeded"),

    // 5xx 服务器错误
    SERVER_ERROR(500, "Internal Server Error"),
    THIRD_PARTY_FAILURE(550, "Third-Party Service Failure"),
    DATABASE_UNAVAILABLE(551, "Database Unavailable"),
    DATA_CONFLICT(552, "Data Conflict");

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
