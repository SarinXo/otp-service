package sarinxo.otpservice.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.slf4j.MDC;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import sarinxo.otpservice.validation.UuidStringValidator;

import java.io.IOException;
import java.util.UUID;

import static sarinxo.otpservice.constant.RequestConstant.REQUEST_ID;

@Component
@RequiredArgsConstructor
@Order(Ordered.HIGHEST_PRECEDENCE)
public class RequestIdFilter extends HttpFilter {

    private final UuidStringValidator validator;

    /**
     * Помещает requestId в ThreadLocal доступный в течение запроса.
     */
    @Override
    protected void doFilter(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain chain
    ) throws IOException, ServletException {
        try {
            String requestUuid = getRequestId(request);
            MDC.put(REQUEST_ID, requestUuid);

            super.doFilter(request, response, chain);
        } finally {
            MDC.clear();
        }
    }

    /**
     * Возвращает requestId из запроса. При невалидном requestId или его отсутствии создает новый requestId.
     *
     * @param request Запрос к сервису
     * @return UUID строка. Гарантируется правильный формат.
     */
    private String getRequestId(HttpServletRequest request) {
        String requestId = request.getHeader("X-REQUEST-ID");

        if (requestId == null || !validator.isValid(requestId)) {
            requestId = UUID.randomUUID().toString();
            return requestId;
        }

        return requestId;
    }

}
