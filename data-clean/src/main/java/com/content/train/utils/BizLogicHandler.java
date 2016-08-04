package com.content.train.utils;

import java.util.List;
/**
 * Created by shawxy on 8/4/16
 */

public interface BizLogicHandler<V, T, E> {
	
	public List<E> handle(V maxCompareEle, int pageSize, T conditions);

    public V getMaxCompareEle(V maxCompareEle, List<E> subResult);
}
