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
public class RestVO<T> implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private int code;
    private String message;
    private T data;
    private Long timestamp;

    /**
     * @param restCode    ...
     * @param message ...
     * @param data    ...
     * @author gaotianchi
     * @since 2024/11/23 19:14
     **/
    public RestVO(RestCode restCode, String message, T data) {
        this.code = restCode.getCode();
        this.message = message;
        this.data = data;
        this.timestamp = System.currentTimeMillis();
    }

    /**
     * common restful response
     *
     * @param restCode response code
     * @param data response data
     * @return com.gaotianchi.auth.vo.RestVO<T>
     * @author gaotianchi
     * @since 2024/11/23 19:18
     **/
    public static <T> RestVO<T> response(RestCode restCode, T data) {
        return new RestVO<>(restCode, restCode.getMessage(), data);
    }

}
