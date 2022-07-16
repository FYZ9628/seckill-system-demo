package com.example.seckillsystemdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * Redis配置类
 *
 * @Author Administrator
 * @Date 2022/7/13 10:41
 */
@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        //key 序列化
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        //默认使用jdk的序列化，产生的value值是二进制的
        //new JdkSerializationRedisSerializer()，产生的是二进制的数据
        //new GenericJackson2JsonRedisSerializer()，产生的是字符串，是json格式的，且不需要入参
        //new Jackson2JsonRedisSerializer<Object>(Object)，需要传入一个对象参数，产生的是字符串，是json格式的
        //value 序列化
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());

        //hash 类型，key序列化
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        //hash 类型，value序列化
        redisTemplate.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());

        //注入连接工厂
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        return redisTemplate;
    }

    /**
     * 加载 lua 脚本
     *
     * @return
     */
    @Bean
    public DefaultRedisScript<Long> Script() {
        DefaultRedisScript<Long> redisScript = new DefaultRedisScript<>();
        //lock.lua 脚本位置和 application.yml 同级目录
        redisScript.setLocation(new ClassPathResource("stock.lua"));
        redisScript.setResultType(Long.class);
        return redisScript;
    }

}
