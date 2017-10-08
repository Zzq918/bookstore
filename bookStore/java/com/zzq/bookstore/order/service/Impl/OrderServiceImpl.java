package com.zzq.bookstore.order.service.Impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zzq.bookstore.admin.javabean.Userorder;
import com.zzq.bookstore.core.service.impl.BaseServiceImpl;
import com.zzq.bookstore.order.dao.OrderDao;
import com.zzq.bookstore.order.service.OrderService;

@Service("orderService")
public class OrderServiceImpl extends BaseServiceImpl<Userorder> implements OrderService{
    private OrderDao orderDao;
    @Resource
    public void setBaseDao(OrderDao orderDao) {
    	super.setBaseDao(orderDao);
    	this.orderDao=orderDao;
    }
}
