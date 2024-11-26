package com.gaotianchi.auth.aspect;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gaotianchi.auth.enums.RestCode;
import com.gaotianchi.auth.vo.RestVO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author gaotianchi
 * @since 2024/11/26 13:14
 **/
@Component
@Slf4j
public class AccessDeniedHandlerImpl implements AccessDeniedHandler {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        log.warn("Access denied");
        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        response.getWriter().write(objectMapper.writeValueAsString(RestVO.response(RestCode.ACCESS_DENIED, accessDeniedException.getMessage())));
        response.getWriter().flush();
    }
}
