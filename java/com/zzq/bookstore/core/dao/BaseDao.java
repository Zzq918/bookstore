package com.zzq.bookstore.core.dao;

import java.io.Serializable;
import java.util.List;

import com.zzq.bookstore.core.page.PageResult;
import com.zzq.bookstore.core.util.QueryHelper;

public interface BaseDao<T> {
	public void save(T entity);
	public void delete(T entity);
	public void update(T entity);
	public T findObjectById(Serializable id);
	public List<T> findObject();
	public List<T> findObject(String hql, List<Object> parameters);
	public PageResult getPageResult(QueryHelper queryHelper, int pageNo, int pageSize);
}
