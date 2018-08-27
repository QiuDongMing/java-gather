package com.qdm.cache.core;

/**
 * @author qiudm
 * @date 2018/8/27 14:13
 * @desc
 */
public interface ICache<K,V> {

    /**
     * 从缓存中获取数据
     * @param key
     * @return value
     */
    V get(K key);

    /**
     * 保存key对应的值
     * @param key
     * @return value
     */
    void save(K key,V value);

    /**
     * 保存key的值，并设置key的过期时间。seconds为0表示不过期
     * @param key
     * @param value
     * @param seconds（针对redis缓存）
     */
    void save(K key,V value,int seconds);

    /**
     * 移除key
     * @param key
     */
    void remove(K key);

    /**
     * 设置key的有效时间（针对redis缓存）
     */
    void expire(K key,int seconds);

}
