package com.myorder.model;

public class PackBill {
	
	private String goodsname;
	
	private String username;
	
	private String beginDate;
	
	private String endDate;
	
	private Integer paytype;
	
	private Integer goodstpye;

	public String getGoodsname() {
		return goodsname;
	}

	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public Integer getPaytype() {
		return paytype;
	}

	public void setPaytype(Integer paytype) {
		this.paytype = paytype;
	}

	public Integer getGoodstpye() {
		return goodstpye;
	}

	public void setGoodstpye(Integer goodstpye) {
		this.goodstpye = goodstpye;
	}
	

}
