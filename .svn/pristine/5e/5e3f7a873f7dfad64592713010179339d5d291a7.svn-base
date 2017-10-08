package com.zzq.bookstore.core.service;

import java.io.Serializable;
import java.util.List;

import com.zzq.bookstore.core.page.PageResult;
import com.zzq.bookstore.core.util.QueryHelper;


public interface BaseService<T> {
	/**
	 * 保存用户
	 * @param entity 用户信息
	 */
	public void save(T entity);
	/**
	 * 删除用户信息
	 * @param entity 用户信息
	 */
	public void delete(T entity);
	/**
	 * 更新用户信息
	 * @param entity  用户信息
	 */
	public void update(T entity);
	/**
	 * 根据id查找用户
	 * @param id 用户编号
	 * @return  返回用户实体
	 */
	public T findObjectById(Serializable id);
	/**
	 * 查询所有用户信息
	 * @return  返回用户集合
	 */
	public List<T> findObject();
	
	PageResult getPageResult(QueryHelper queryHelper, int pageNo, int pageSize);
}
