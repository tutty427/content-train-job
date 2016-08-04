package com.content.train.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shawxy on 8/4/16
 */
public class PaginationHandler<V, T, R> {

    private V maxCompareEle;

	private final int pageSize;

	private final BizLogicHandler<V, T, R> handler;

    private final T conditions;

	public PaginationHandler(V maxCompareEle, int pageSize, T conditions, BizLogicHandler<V, T, R> handler) {
		this.maxCompareEle = maxCompareEle;
		this.pageSize = pageSize > 0 ? pageSize : 100;
		if (handler == null) {
			throw new IllegalArgumentException("handler can't be null.");
		}
		this.handler = handler;

        this.conditions = conditions;
	}

	public List<R> execute() {

        List<R> result = new ArrayList<R>();

        while(true) {
            List<R> subResult = handler.handle(maxCompareEle, pageSize, conditions);

            if(subResult.size() == 0) break;

            maxCompareEle = handler.getMaxCompareEle(maxCompareEle, subResult);

            result.addAll(subResult);
        }

		return result;
	}
}
