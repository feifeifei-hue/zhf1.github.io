package com.Test.userBean;

public class MottoBean {
	
	private String mottoname;
	private String mottorank;
	private String mottofc;
	
	public String getMottoname() {
		return mottoname;
	}
	public void setMottoname(String mottoname) {
		this.mottoname = mottoname;
	}
	public String getMottorank() {
		return mottorank;
	}
	public void setMottorank(String mottorank) {
		this.mottorank = mottorank;
	}
	public String getMottofc() {
		return mottofc;
	}
	public void setMottofc(String mottofc) {
		this.mottofc = mottofc;
	}
	
	
	public MottoBean(String mottoname, String mottorank, String mottofc) {
		super();
		this.mottoname = mottoname;
		this.mottorank = mottorank;
		this.mottofc = mottofc;
	}
	public MottoBean() {
		
	}
	
}
