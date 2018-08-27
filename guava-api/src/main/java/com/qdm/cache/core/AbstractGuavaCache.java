package com.qdm.cache.core;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.CacheStats;
import com.google.common.cache.LoadingCache;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;


/**
 * @author qiudm
 * @date 2018/8/27 14:14
 * @desc
 */
public abstract class AbstractGuavaCache<K,V> implements ICache<K,V> {

//    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    private int maximumSize = DEFAULT_MAXIMUMSIZE; //最大缓存条数，子类在构造方法中调用setMaximumSize(int size)来更改
    private int expireAfterWriteSeconds = DEFAULT_EXPIREAFTERWRITESECONDS; //数据存在时长，单位：秒
    private int concurrencyLevel = DEFAULT_CONCURRENCYLEVEL;

    private LoadingCache<K, V> cache;

    //默认值
    private static int DEFAULT_MAXIMUMSIZE = 1000;
    private static int DEFAULT_EXPIREAFTERWRITESECONDS = 60;
    private static int DEFAULT_CONCURRENCYLEVEL = 8;


    private LoadingCache<K,V> getCache() {
        if (cache == null) {
            synchronized (this) {
                initCacheConfig();
                if(cache == null) {
                    cache = CacheBuilder.newBuilder()
                            .concurrencyLevel(concurrencyLevel)//设置并发级别，并发级别是指可以同时写缓存的线程数
                            .expireAfterWrite(expireAfterWriteSeconds, TimeUnit.SECONDS)//设置写缓存后x秒钟过期
                            .initialCapacity(10)//设置缓存容器的初始容量为10
                            .maximumSize(maximumSize) //设置缓存最大容量，超过之后就会按照LRU最近虽少使用算法来移除缓存项
                            .recordStats()//设置要统计缓存的命中率
                            .build(new CacheLoader<K, V>() {
                                @Override
                                public V load(K k) throws Exception {
                                    //build方法中可以指定CacheLoader，在缓存不存在时通过CacheLoader的实现自动加载缓存
                                    return fetchData(k);
                                }
                            });
                }
            }
        }

        return cache;
    }



    protected void initCacheConfig() {
        this.setConcurrencyLevel(DEFAULT_CONCURRENCYLEVEL);
        this.setExpireAfterWriteSeconds(DEFAULT_EXPIREAFTERWRITESECONDS);
        this.setMaximumSize(DEFAULT_MAXIMUMSIZE);
    }



    /**
     * 根据key从数据库或其他数据源中获取一个value，并被自动保存到缓存中。
     * @param key
     * @return value,连同key一起被加载到缓存中的。
     */
    protected abstract V fetchData(K key);


    @Override
    public V get(K key) {
        V result = null;
        try {
            result = getCache().get(key);
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void save(K key, V value) {
        getCache().put(key, value);
    }


    @Override
    public void remove(K key) {
        getCache().invalidate(key);
    }

    protected void reload(K key){
        getCache().refresh(key);
    }


    /**
     * 设置最大缓存条数
     * @param maximumSize
     */
    public void setMaximumSize(int maximumSize) {
        this.maximumSize = maximumSize;
    }


    /**
     * 设置数据存在时长（秒）
     * @param expireAfterWriteSeconds
     */
    public void setExpireAfterWriteSeconds(int expireAfterWriteSeconds) {
        if(concurrencyLevel >= 0){
            this.expireAfterWriteSeconds = expireAfterWriteSeconds;
        }
    }


    /**
     * 设置并发级别，并发级别是指可以同时写缓存的线程数
     * @param concurrencyLevel
     */
    public void setConcurrencyLevel(int concurrencyLevel) {
        if(concurrencyLevel > 0){
            this.concurrencyLevel = concurrencyLevel;
        }
    }

    public CacheStats stats() {
        return getCache().stats();
    }

    public long cacheSize() {
        return getCache().size();
    }

    public void resetAll(){
        getCache().invalidateAll();
    }
}
