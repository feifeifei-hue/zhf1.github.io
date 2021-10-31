package com.Test.userBean;

public class HeroBean {
	
	private String heroname;
	private String herohealth;
	private String heromana;
	private String heroas;
	private String heroac;
	private String skinname;
	private String mottoname;

	public String getHeroname() {
		return heroname;
	}
	public void setHeroname(String heroname) {
		this.heroname = heroname;
	}
	public String getHerohealth() {
		return herohealth;
	}
	public void setHerohealth(String herohealth) {
		this.herohealth = herohealth;
	}
	public String getHeromana() {
		return heromana;
	}
	public void setHeromana(String heromana) {
		this.heromana = heromana;
	}
	public String getHeroas() {
		return heroas;
	}
	public void setHeroas(String heroas) {
		this.heroas = heroas;
	}
	public String getHeroac() {
		return heroac;
	}
	public void setHeroac(String heroac) {
		this.heroac = heroac;
	}
	public String getSkinname() {
		return skinname;
	}
	public void setSkinname(String skinname) {
		this.skinname = skinname;
	}
	public String getMottoname() {
		return mottoname;
	}
	public void setMottoname(String mottoname) {
		this.mottoname = mottoname;
	}
	
	public HeroBean(String heroname, String herohealth, String heromana, String heroas, String heroac, String skinname, String mottoname) {
		super();
		this.heroname = heroname;
		this.herohealth = herohealth;
		this.heromana = heromana;
		this.heroas = heroas;
		this.heroac = heroac;
		this.skinname = skinname;
		this.mottoname = mottoname;
	}
	public HeroBean() {
		
	}
	
}
