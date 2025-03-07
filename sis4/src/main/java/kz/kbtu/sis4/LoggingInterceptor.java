package kz.kbtu.sis4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.*;

import java.io.IOException;

public class LoggingInterceptor implements ClientHttpRequestInterceptor {

    private static final Logger log = LoggerFactory.getLogger(LoggingInterceptor.class);

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        logRequest(request, body);
        ClientHttpResponse response = execution.execute(request, body);
        logResponse(response);
        return response;
    }

    private void logRequest(HttpRequest request, byte[] body) {
        log.info("Request: {} {}", request.getMethod(), request.getURI());
        log.info("Headers: {}", request.getHeaders());
        log.info("Body: {}", new String(body));
    }

    private void logResponse(ClientHttpResponse response) throws IOException {
        log.info("Response: {} {}", response.getStatusCode(), response.getStatusText());
    }
}
