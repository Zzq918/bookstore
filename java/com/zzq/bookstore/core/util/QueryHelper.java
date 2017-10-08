package com.zzq.bookstore.core.util;

import java.util.ArrayList;
import java.util.List;

public class QueryHelper {
    //form子句
	private String fromClause="";
	//where子句
	private String whereClause="";
	//orderby子句
	private String orderClause="";
	
	public static String ORDERBY_DESC="DESC";//降序
	public static String ORDERBY_ASC="ASC";
	
	private List<Object> params;
	/**
	 * 构造From子句
	 * @param clazz  实体类
	 * @param in 表的别名
	 */
	public QueryHelper(Class clazz,String in) {
		fromClause="FROM "+clazz.getSimpleName()+" "+in;
	}
	
	public void addCondition(String condition,Object...param){
		if(whereClause.length()>1){
			whereClause+=" AND "+condition;
		}else{
			whereClause+=" WHERE "+condition+" ";
		}
		//设置条件值到条件值集合
		if(params==null){
			params=new ArrayList<Object>();
		}
		if(param!=null){
			for(Object para:param){
				params.add(para);
			}
		}
		
	}
	/**
	 * 构造order by 子句
	 * @param property 排序的属性
	 * @param order 排序的方式
	 */
	public void addOrderByProperty(String property,String order){
		if(orderClause.length()>1){
			orderClause+=","+property+" "+order;
		}else{
			orderClause=" ORDER BY "+property+" "+order;
		}
	}
	//查询语句HQL语句
	public String getQueryHQL(){
		return fromClause+whereClause+orderClause;
	}
	//获取hql语句中条件值集合
	public List<Object> getParams() {
		return params;
	}

	public String getQueryCountHql() {
		return "SELECT COUNT(*) "+fromClause+whereClause;
	}
}
