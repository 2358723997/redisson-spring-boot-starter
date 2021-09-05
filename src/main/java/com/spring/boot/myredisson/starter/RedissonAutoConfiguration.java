package com.spring.boot.myredisson.starter;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * RedissonAutoConfiguration类
 *
 * @author wangjixue
 * @date 9/5/21 4:57 PM
 */
@ConditionalOnClass(Redisson.class)
@EnableConfigurationProperties(RedissonProperties.class)
@Configuration
public class RedissonAutoConfiguration {

    @Bean
    RedissonClient redissonClient(RedissonProperties redissonProperties) {
        Config config = new Config();
        String prefix = "redis://";
        if (redissonProperties.isSsl()) {
            prefix = "rediss://";
        }
        config.useSingleServer().setAddress(prefix+redissonProperties.getHost() + ":" + redissonProperties.getPort()).setTimeout(redissonProperties.getTimeout());
        return Redisson.create(config);
    }
}
