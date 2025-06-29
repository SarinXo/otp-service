package sarinxo.otpservice.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import lombok.RequiredArgsConstructor;
import org.slf4j.MDC;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import sarinxo.otpservice.validation.UuidString;

import java.io.IOException;
import java.util.Set;
import java.util.UUID;

@Component
@RequiredArgsConstructor
@Order(Ordered.HIGHEST_PRECEDENCE)
public class RequestIdFilter extends HttpFilter {

    private final Validator validator;

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
            MDC.put("requestId", requestUuid);

            super.doFilter(request, response, chain);
        } finally {
            MDC.clear();
        }
    }

    /**
     * Возвращает requestId из запроса. При невалидном requestId или его отсутствии создает новый requestId.
     * @param request Запрос к сервису
     * @return UUID строка. Гарантируется правильный формат.
     */
    private String getRequestId(HttpServletRequest request) {
        String requestId = request.getHeader("X-REQUEST-ID");

        Set<ConstraintViolation<String>> validationResult = validator.validate(requestId, UuidString.class);
        if (!validationResult.isEmpty()) {
            requestId = UUID.randomUUID().toString();
        }

        return requestId;
    }

}
