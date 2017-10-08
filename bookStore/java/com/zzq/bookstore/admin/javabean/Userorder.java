package com.zzq.bookstore.admin.javabean;

import com.zzq.bookstore.book.javabean.Book;

/**
 * Userorder entity. @author MyEclipse Persistence Tools
 */

public class Userorder implements java.io.Serializable {

	// Fields

	private String oid;    //订单编号
	private Book book;      //书本实体
	private String uid;     //用户编号
	private String bname;    //书本名称
	private Double bprice;   //书本价格
	private String state;      //订单状态
	private String address;    //收件地址
	private String relation;    //订单联系人电话

	// Constructors

	/** default constructor */
	public Userorder() {
	}

	/** full constructor */
	public Userorder(Book book, String uid, String bname, Double bprice,
			String state, String address, String relation) {
		this.book = book;
		this.uid = uid;
		this.bname = bname;
		this.bprice = bprice;
		this.state = state;
		this.address = address;
		this.relation = relation;
	}

	// Property accessors

	public String getOid() {
		return this.oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public Book getBook() {
		return this.book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public String getUid() {
		return this.uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getBname() {
		return this.bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public Double getBprice() {
		return this.bprice;
	}

	public void setBprice(Double bprice) {
		this.bprice = bprice;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRelation() {
		return this.relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

}