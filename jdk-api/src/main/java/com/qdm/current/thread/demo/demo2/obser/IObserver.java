package com.qdm.current.thread.demo.demo2.obser;

/**
 * @author qiudm
 * @date 2018/11/20 17:02
 * @desc
 */
public interface IObserver {

     void update(Result result);

     String getId();

     Result getResult();

     boolean outTime();

}
