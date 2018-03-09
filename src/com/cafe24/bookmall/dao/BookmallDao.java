package com.cafe24.bookmall.dao;

import java.util.List;

public interface BookmallDao<V> {

	public boolean insert(V vo);
	
	public List<V> getList(int page);
	
}
