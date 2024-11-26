package com.gaotianchi.auth.aspect;

import com.gaotianchi.auth.enums.RestCode;
import com.gaotianchi.auth.vo.RestVO;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author gaotianchi
 * @since 2024/11/23 19:23
 **/
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Global Exception handler
     *
     * @param e Exception
     * @return java.lang.Object
     * @author gaotianchi
     * @since 2024/11/23 19:32
     **/
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public RestVO<String> exceptionHandler(Exception e) {
        return RestVO.response(RestCode.BAD_REQUEST, e.getLocalizedMessage());
    }
}
