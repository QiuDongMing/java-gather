package com.qdm.cache.ehcache;

import com.qdm.data.po.Student;
import org.ehcache.Cache;

/**
 * @author qiudm
 * @date 2019/2/28 10:21
 * @desc
 */
public class StudentCache<T extends Student> {

    private static StudentCache studentCache = null;

    private Cache<Integer, T> cache;

    private StudentCache() {
        this.cache = CacheFactory.getStudentCache();
    }

    public static StudentCache getInstance() {
        if (studentCache == null) {
            synchronized (StudentCache.class) {
                if (studentCache == null) {
                    studentCache = new StudentCache();
                }
            }
        }
        return studentCache;
    }


    public void put(Integer studentId, T student) {
        cache.put(studentId, student);
    }


    public T get(Integer studentId) {
        return cache.get(studentId);
    }



}
