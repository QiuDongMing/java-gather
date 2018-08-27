package com.qdm.cache.test;

import com.qdm.cache.core.AbstractGuavaCache;

/**
 * @author qiudm
 * @date 2018/8/27 14:58
 * @desc
 */
public class GuavaCacheTest extends AbstractGuavaCache {

    @Override
    public void save(Object key, Object value, int seconds) {

    }

    @Override
    public void expire(Object key, int seconds) {

    }

    @Override
    protected Object fetchData(Object key) {
        return null;
    }

    public static void main(String[] args) {
        GuavaCacheTest guavaCacheTest = new GuavaCacheTest();
       // guavaCacheTest.save("k1", "v1");
        System.out.println("k1 = " + guavaCacheTest.get("k1"));

    }

}
