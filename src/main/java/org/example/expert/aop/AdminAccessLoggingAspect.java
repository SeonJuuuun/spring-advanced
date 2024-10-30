package org.example.expert.aop;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j(topic = "adminAop")
@Aspect
@Component
@RequiredArgsConstructor
public class AdminAccessLoggingAspect {

    private final HttpServletRequest request;

    @Pointcut("execution(* org.example.expert.domain.comment.controller.CommentAdminController.deleteComment(..)) || " +
            "execution(* org.example.expert.domain.user.controller.UserAdminController.changeUserRole(..))")
    public void adminEndpoints() {
    }

    @AfterReturning(pointcut = "adminEndpoints()", returning = "returnValue")
    public void logAdminAccess(JoinPoint joinPoint, Object returnValue) {
        final Long userId = (Long) request.getAttribute("userId");
        final String requestUrl = request.getRequestURI();
        final LocalDateTime requestTime = LocalDateTime.now();

        log.info("Admin access log - userID: {}, RequestTime: {}, URL: {}", userId, requestTime, requestUrl);

        ObjectMapper mapper = new ObjectMapper();
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            try {
                final String request = mapper.writeValueAsString(arg);
                log.info("RequestBody: {}", request);
            } catch (Exception e) {
                log.warn("로그 작성에 실패하였습니다.", e);
            }
        }

        try {
            final String response = mapper.writeValueAsString(returnValue);
            log.info("ResponseBody: {}", response);
        } catch (Exception e) {
            log.warn("로그 작성에 실패하였습니다.", e);
        }
    }
}
