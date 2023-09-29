package com.app.microservice.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * API Logger filter is responsible for filtering and logging the request and the response also the execution time.
 */
@Component
public class APILoggerFilter extends OncePerRequestFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(APILoggerFilter.class);

    /**
     * Do the filtering
     *
     * @param request
     * @param response
     * @param filterChain
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        ContentCachingRequestWrapper requestWrapper = new ContentCachingRequestWrapper(request);
        ContentCachingResponseWrapper responseWrapper = new ContentCachingResponseWrapper(response);
        long startTime = System.currentTimeMillis();
        filterChain.doFilter(requestWrapper, responseWrapper);
        long execTime = System.currentTimeMillis() - startTime;

        LOGGER.info(
                " REQUEST :" + request.getMethod() +
                        " REQUESTURI : " + request.getRequestURI() +
                        " REQUEST PAYLOAD= " + decode(requestWrapper.getContentAsByteArray(), request.getCharacterEncoding()) +
                        " RESPONSE CODE : " + response.getStatus() +
                        " RESPONSE : " + decode(responseWrapper.getContentAsByteArray(), response.getCharacterEncoding()) +
                        " EXECUTION TIME : " + execTime

        );

        responseWrapper.copyBodyToResponse();

    }

    /**
     * Decode the array byte to a readable string
     *
     * @param contentAsByteArray
     * @param characterEncoding
     * @return
     */
    private String decode(byte[] contentAsByteArray, String characterEncoding) {
        try {
            return new String(contentAsByteArray, 0, contentAsByteArray.length, characterEncoding);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }


}