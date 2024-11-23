package com.gaotianchi.auth.vo;

import com.gaotianchi.auth.enums.RestCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author gaotianchi
 * @since 2024/11/23 18:44
 **/
@Setter
@Getter
public class RestResponse<T> implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private int code;
    private String message;
    private T data;
    private Long timestamp;

    /**
     *
     * @author gaotianchi
     * @since 2024/11/23 19:14
     * @param code ...
     * @param message ...
     * @param data ...
     **/
    public RestResponse(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.timestamp = System.currentTimeMillis();
    }

    /**
     * success
     * @author gaotianchi
     * @since 2024/11/23 19:13
     * @return com.gaotianchi.auth.vo.RestResponse<T>
     **/
    public static <T> RestResponse<T> success() {
        return new RestResponse<T>(RestCode.SUCCESS.getCode(), RestCode.SUCCESS.getMessage(), null);
    }

    /**
     * fail
     * @author gaotianchi
     * @since 2024/11/23 19:13
     * @return com.gaotianchi.auth.vo.RestResponse<T>
     **/
    public static <T> RestResponse<T> fail() {
        return new RestResponse<T>(RestCode.FAIL.getCode(), RestCode.FAIL.getMessage(), null);
    }

    /**
     * common restful response
     * @author gaotianchi
     * @since 2024/11/23 19:18
     * @param code response code
     * @param data response data
     * @return com.gaotianchi.auth.vo.RestResponse<T>
     **/
    public static <T> RestResponse<T> response(int code, T data) {
        return new RestResponse<T>(code, RestCode.fromCode(code).getMessage(), data);
    }

}
