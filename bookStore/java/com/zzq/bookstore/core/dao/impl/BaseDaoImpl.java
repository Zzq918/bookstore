package com.zzq.bookstore.core.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.zzq.bookstore.core.dao.BaseDao;
import com.zzq.bookstore.core.page.PageResult;
import com.zzq.bookstore.core.util.QueryHelper;

public abstract class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {

	private Class<T> clazz;

	@SuppressWarnings("unchecked")
	public BaseDaoImpl() {
		ParameterizedType pt = (ParameterizedType) getClass().getGenericSuperclass();
		clazz = (Class<T>) pt.getActualTypeArguments()[0];
	}
  
	public void save(T entity) {
		getHibernateTemplate().saveOrUpdate(entity);
	}

	public void delete(T entity) {
		getHibernateTemplate().delete(entity);
	}

	public void update(T entity) {
		getHibernateTemplate().update(entity);
	}

	public T findObjectById(Serializable id) {
		return getHibernateTemplate().get(clazz, id);
	}

	public List<T> findObject() {
		Query<T> query = currentSession().createQuery("FROM " + clazz.getSimpleName());
		return query.list();
	}

	public List<T> findObject(String hql, List<Object> parameters) {
		Query query = currentSession().createQuery(hql);
		if (parameters != null) {
			for (int i = 0; i < parameters.size(); i++) {
				query.setParameter(i, parameters.get(i));
			}
		}
		return query.list();
	}


	public PageResult getPageResult(QueryHelper queryHelper, int pageNo, int pageSize) {
		Query query = currentSession().createQuery(queryHelper.getQueryHQL());
		List<Object> parameters = queryHelper.getParams();
		if (parameters != null) {
			for (int i = 0; i < parameters.size(); i++) {
				query.setParameter(i, parameters.get(i));
			}
		}
		if (pageNo < 1)
			pageNo = 1;

		query.setFirstResult((pageNo - 1) * pageSize);// 设置数据起始索引号
		query.setMaxResults(pageSize);
		List items = query.list();
		// 获取总记录数
		Query queryCount = currentSession().createQuery(queryHelper.getQueryCountHql());
		if (parameters != null) {
			for (int i = 0; i < parameters.size(); i++) {
				queryCount.setParameter(i, parameters.get(i));
			}
		}
		long totalResult = (Long) queryCount.uniqueResult();
		return new PageResult(totalResult, pageNo, pageSize, items);
	}

}
