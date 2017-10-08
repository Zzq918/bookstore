package com.zzq.bookstore.admin.javabean;

import java.util.HashSet;
import java.util.Set;

/**
 * Admin entity. @author Eclipse Persistence Tools
 */

public class Admin implements java.io.Serializable {

	// Fields

	private String AId;   //管理员编号
	private String mname;   //管理员昵称
	private String name;    //管理员店名称
	private String phone;   //管理员联系方式
	private String headImg;  //管理员头像地址
	private String uname;    //管理员账号
	private String passWord;   //管理员密码
	private Double balance;    //管理员资金账户
	private Set books = new HashSet(0);  

	// Constructors

	/** default constructor */
	public Admin() {
	}

	/** full constructor */
	public Admin(String mname, String name, String phone, String headImg,
			String uname, String passWord, Double balance, Set books) {
		this.mname = mname;
		this.name = name;
		this.phone = phone;
		this.headImg = headImg;
		this.uname = uname;
		this.passWord = passWord;
		this.balance = balance;
		this.books = books;
	}

	// Property accessors

	public String getAId() {
		return this.AId;
	}

	public void setAId(String AId) {
		this.AId = AId;
	}

	public String getMname() {
		return this.mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getHeadImg() {
		return this.headImg;
	}

	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}

	public String getUname() {
		return this.uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPassWord() {
		return this.passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public Double getBalance() {
		return this.balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Set getBooks() {
		return this.books;
	}

	public void setBooks(Set books) {
		this.books = books;
	}

}