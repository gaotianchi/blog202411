package com.gaotianchi.auth.aspect;

import com.gaotianchi.auth.enums.Code;
import com.gaotianchi.auth.vo.VO;
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
    public VO<String> exceptionHandler(Exception e) {
        return VO.response(Code.UNKNOWN_ERROR, e.getLocalizedMessage());
    }
}
