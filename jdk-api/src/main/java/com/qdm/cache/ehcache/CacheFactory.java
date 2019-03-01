package com.qdm.cache.ehcache;


import com.qdm.data.po.Student;
import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ExpiryPolicyBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;

import java.time.Duration;

/**
 * @author qiudm
 * @date 2019/2/28 10:19
 * @desc
 */
public class CacheFactory {

    private static final String STUDENT_CACHE_PRE = "student";


    public static CacheManager getCacheManager() {

        CacheManager cacheManager = CacheManagerBuilder.newCacheManagerBuilder().build();
        cacheManager.init();
        return cacheManager;
    }


    protected static Cache getStudentCache() {
        Cache<Integer, Student> cache = getCacheManager().getCache(STUDENT_CACHE_PRE, Integer.class, Student.class);
        if (cache == null) {
            CacheConfigurationBuilder cacheConfigurationBuilder =
                    CacheConfigurationBuilder.newCacheConfigurationBuilder(
                            Integer.class, Student.class, ResourcePoolsBuilder.heap(10)
                    ).withExpiry(ExpiryPolicyBuilder.timeToLiveExpiration(Duration.ofSeconds(10)));
            synchronized (STUDENT_CACHE_PRE) {
                cache =  getCacheManager().createCache(STUDENT_CACHE_PRE, cacheConfigurationBuilder);
            }
        }
        return cache;
    }





}
