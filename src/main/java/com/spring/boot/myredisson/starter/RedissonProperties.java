package com.spring.boot.myredisson.starter;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * RedissonProperties类
 *
 * @author wangjixue
 * @date 9/5/21 5:10 PM
 */
@ConfigurationProperties(prefix = "my.redission")
public class RedissonProperties {
    private boolean ssl;

    private String host = "localhost";
    private int port = 6379;
    private int timeout;

    public boolean isSsl() {
        return ssl;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }
}
