package com.gaotianchi.auth.aspect;

import com.gaotianchi.auth.vo.RestResponse;
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
     * @author gaotianchi
     * @since 2024/11/23 19:32
     * @param e Exception
     * @return java.lang.Object
     **/
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public RestResponse<String> exceptionHandler(Exception e){
        return RestResponse.response(500, e.getLocalizedMessage());
    }
}
