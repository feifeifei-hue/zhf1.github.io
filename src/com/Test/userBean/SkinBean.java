package com.Test.userBean;

public class SkinBean {
	
	private String skinname;
	private String skinbg;
	private String skinprice;
	
	public String getSkinname() {
		return skinname;
	}
	public void setSkinname(String skinname) {
		this.skinname = skinname;
	}
	public String getSkinbg() {
		return skinbg;
	}
	public void setSkinbg(String skinbg) {
		this.skinbg = skinbg;
	}
	public String getSkinprice() {
		return skinprice;
	}
	public void setSkinprice(String skinprice) {
		this.skinprice = skinprice;
	}
	
	
	public SkinBean(String skinname, String skinbg, String skinprice) {
		super();
		this.skinname = skinname;
		this.skinbg = skinbg;
		this.skinprice = skinprice;
	}
	public SkinBean() {
		
	}
	
}
