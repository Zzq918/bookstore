package com.zzq.bookstore.core.service.impl;

import java.io.Serializable;
import java.util.List;

import com.zzq.bookstore.core.dao.BaseDao;
import com.zzq.bookstore.core.page.PageResult;
import com.zzq.bookstore.core.service.BaseService;
import com.zzq.bookstore.core.util.QueryHelper;


public class BaseServiceImpl<T> implements BaseService<T> {
    
	private BaseDao<T> baseDao;
    
	public void setBaseDao(BaseDao<T> baseDao) {
		this.baseDao = baseDao;
	}
	public void save(T entity) {
        baseDao.save(entity);
	}

	public void delete(T entity) {
		baseDao.delete(entity);

	}

	public void update(T entity) {
        baseDao.update(entity);
	}

	public T findObjectById(Serializable id) {
		return baseDao.findObjectById(id);
	}

	public List<T> findObject() {
		return baseDao.findObject();
	}
	public List<T> findObject(String hql, List<Object> parameters) {
		return baseDao.findObject(hql,parameters);
	}
	public PageResult getPageResult(QueryHelper queryHelper, int pageNo, int pageSize) {
		return baseDao.getPageResult(queryHelper,pageNo,pageSize);
	}

}
