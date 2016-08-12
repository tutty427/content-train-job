package com.content.train.compoment;

/**
 * Created by shawxy on 8/11/16.
 */
public interface Algorithm<T,R> {

    R action(T source, T target);
}
