package com.billyang.cache;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;

import javax.annotation.Resource;

/**
 * @author yangcan14944
 * @version V1.0
 * @Project myshiro
 * @Package com.billyang.cache
 * @Description: ${todo}
 * @date 2018.12.28
 * @time 15:55
 */
public class RedisCacheManager implements CacheManager{
    @Resource
    private RedisCache redisCache;
    public <K, V> Cache<K, V> getCache(String s) throws CacheException {
        return redisCache;
    }
}
