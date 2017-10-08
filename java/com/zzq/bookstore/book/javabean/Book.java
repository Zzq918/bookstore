package com.zzq.bookstore.book.javabean;

import java.util.HashSet;
import java.util.Set;

import com.zzq.bookstore.admin.javabean.Admin;

/**
 * Book entity. @author Eclipse Persistence Tools
 */

public class Book implements java.io.Serializable {

	// Fields

	private String bid;   //书本编号
	private Admin admin;   //管理员对象
	private String bname;  //书本名称
	private String author;   //书本作者
	private Double bprice;   //书本价格
	private String bimg;      //书本图片
	private Double number;    //库存量
	private Double sale;      //已售数量
	private String introduce;   //书本介绍
	private Set userorders = new HashSet(0);

	// Constructors

	/** default constructor */
	public Book() {
	}

	/** full constructor */
	public Book(Admin admin, String bname, String author, Double bprice,
			String bimg, Double number, Double sale, String introduce,
			Set userorders) {
		this.admin = admin;
		this.bname = bname;
		this.author = author;
		this.bprice = bprice;
		this.bimg = bimg;
		this.number = number;
		this.sale = sale;
		this.introduce = introduce;
		this.userorders = userorders;
	}

	// Property accessors

	public String getBid() {
		return this.bid;
	}

	public void setBid(String bid) {
		this.bid = bid;
	}

	public Admin getAdmin() {
		return this.admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public String getBname() {
		return this.bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Double getBprice() {
		return bprice;
	}

	public void setBprice(Double bprice) {
		this.bprice = bprice;
	}

	public String getBimg() {
		return this.bimg;
	}

	public void setBimg(String bimg) {
		this.bimg = bimg;
	}

	

	public Double getNumber() {
		return number;
	}

	public void setNumber(Double number) {
		this.number = number;
	}

	public Double getSale() {
		return sale;
	}

	public void setSale(Double sale) {
		this.sale = sale;
	}

	public String getIntroduce() {
		return this.introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public Set getUserorders() {
		return this.userorders;
	}

	public void setUserorders(Set userorders) {
		this.userorders = userorders;
	}

	@Override
	public String toString() {
		return "Book [bid=" + bid + ", admin=" + admin + ", bname=" + bname + ", author=" + author + ", bprice="
				+ bprice + ", bimg=" + bimg + ", number=" + number + ", sale=" + sale + ", introduce=" + introduce
				+ ", userorders=" + userorders + "]";
	}

}