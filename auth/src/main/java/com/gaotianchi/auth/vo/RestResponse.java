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
     * @param code    ...
     * @param message ...
     * @param data    ...
     * @author gaotianchi
     * @since 2024/11/23 19:14
     **/
    public RestResponse(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.timestamp = System.currentTimeMillis();
    }

    /**
     * common restful response
     *
     * @param code response code
     * @param data response data
     * @return com.gaotianchi.auth.vo.RestResponse<T>
     * @author gaotianchi
     * @since 2024/11/23 19:18
     **/
    public static <T> RestResponse<T> response(int code, T data) {
        return new RestResponse<>(code, RestCode.fromCode(code).getMessage(), data);
    }

}
