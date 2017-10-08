package com.zzq.bookstore.user.javabean;

/**
 * Customer entity. @author MyEclipse Persistence Tools
 */

public class Customer implements java.io.Serializable {

	// Fields

	private String uid;    //用户编号
	private String uimg;   //用户头像地址
	private String uname;   //用户账号
	private String upassWord;   //用户密码
	private Double ucount;   //用户账户资金
	private String uphone;     //用户联系方式
	private String name;       //用户姓名

	// Constructors

	/** default constructor */
	public Customer() {
	}

	/** full constructor */
	public Customer(String uimg, String uname, String upassWord, Double ucount,
			String uphone, String name) {
		this.uimg = uimg;
		this.uname = uname;
		this.upassWord = upassWord;
		this.ucount = ucount;
		this.uphone = uphone;
		this.name = name;
	}

	// Property accessors

	public String getUid() {
		return this.uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getUimg() {
		return this.uimg;
	}

	public void setUimg(String uimg) {
		this.uimg = uimg;
	}

	public String getUname() {
		return this.uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUpassWord() {
		return this.upassWord;
	}

	public void setUpassWord(String upassWord) {
		this.upassWord = upassWord;
	}


	public Double getUcount() {
		return ucount;
	}

	public void setUcount(Double ucount) {
		this.ucount = ucount;
	}

	public String getUphone() {
		return this.uphone;
	}

	public void setUphone(String uphone) {
		this.uphone = uphone;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}