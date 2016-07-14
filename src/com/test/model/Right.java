package com.test.model;

import java.util.ArrayList;
import java.util.List;

public class Right {
	private int id;
	private String right_name;
	private String right_url;
	private String right_farherId;
	private List<Right> listRight=new ArrayList<Right>();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRight_name() {
		return right_name;
	}
	public void setRight_name(String right_name) {
		this.right_name = right_name;
	}
	public String getRight_url() {
		return right_url;
	}
	public void setRight_url(String right_url) {
		this.right_url = right_url;
	}
	public String getRight_farherId() {
		return right_farherId;
	}
	public void setRight_farherId(String right_farherId) {
		this.right_farherId = right_farherId;
	}
	public List<Right> getListRight() {
		return listRight;
	}
	public void setListRight(List<Right> listRight) {
		this.listRight = listRight;
	}
	

}
