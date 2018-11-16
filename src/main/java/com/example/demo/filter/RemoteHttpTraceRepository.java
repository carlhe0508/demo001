package com.example.demo.filter;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.actuate.trace.http.HttpTrace;
import org.springframework.boot.actuate.trace.http.HttpTraceRepository;

import java.util.Collections;
import java.util.List;


public class RemoteHttpTraceRepository implements HttpTraceRepository {

    private final Logger logger = LoggerFactory.getLogger(getClass().getSimpleName());


    @Override
    public List<HttpTrace> findAll() {
        return Collections.emptyList();
    }

    @Override
    public void add(final HttpTrace trace) {
        final String path = trace.getRequest().getUri().getPath();
        final String queryPara = trace.getRequest().getUri().getQuery();
        final String queryParaRaw = trace.getRequest().getUri().getRawQuery();
        final String method = trace.getRequest().getMethod();
        final long timeTaken = trace.getTimeTaken();
        final String time = trace.getTimestamp().toString();
        final int status = trace.getResponse().getStatus();
        logger.info("path: {}, queryPara: {}, queryParaRaw: {}, timeTaken: {}, time: {}, method: {},status{}", path, queryPara, queryParaRaw,
                timeTaken, time, method, status);

    }
}
