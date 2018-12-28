package com.billyang.cache;


import com.billyang.util.JedisUtil;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.springframework.stereotype.Component;
import org.springframework.util.SerializationUtils;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.Set;

/**
 * @author yangcan14944
 * @version V1.0
 * @Project myshiro
 * @Package com.billyang.cache
 * @Description: ${todo}
 * @date 2018.12.28
 * @time 15:55
 */
@Component
public class RedisCache<K,V> implements Cache<K,V> {
    @Resource
    private JedisUtil jedisUtil;
    private final String CACHE_PREFIX="billyang-chache";
    private byte[] getKey(K k){
        System.out.println("key1:"+k);
        if(k instanceof  String){
            System.out.println("key2："+(CACHE_PREFIX+k).getBytes());
            return (CACHE_PREFIX+k).getBytes();
        }
        return SerializationUtils.serialize(k);
    }

    public V get(K k) throws CacheException {
        System.out.println("从redis中获取权限数据");
        System.out.println(k);
        byte[] value = jedisUtil.get(getKey(k));
        if(value!=null){
            System.out.println((V) SerializationUtils.deserialize(value));
            return (V) SerializationUtils.deserialize(value);
        }
        return null;
    }

    public V put(K k, V v) throws CacheException {
        byte[] key = getKey(k);
        byte[] value = SerializationUtils.serialize(v);
        jedisUtil.set(key,value);
        jedisUtil.expire(key,600);
        return v;
    }

    public V remove(K k) throws CacheException {
        byte[] key = getKey(k);
        byte[] value = jedisUtil.get(key);
        jedisUtil.del(key);
        if(value!=null){
            return (V) SerializationUtils.deserialize(value);
        }
        return null;
    }

    public void clear() throws CacheException {
        // 不重写  redis数据缓存很多
    }

    public int size() {
        return 0;
    }

    public Set<K> keys() {
        return null;
    }

    public Collection<V> values() {
        return null;
    }
}
