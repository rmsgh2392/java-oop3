package com.bitcamp.domain2;

public class MemberBean {
	private String name,id,pw,ssn,blood;
	private double height,weight;
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getId() {
		return this.id;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getPw() {
		return this.pw;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getSsn() {
		return this.ssn;
	}
	public void setBlood(String blood) {
		this.blood = blood;
	}
	public String getBlood() {
		return this.blood;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getHeight() {
		return this.height;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public double getWeight() {
		return this.weight;
	}
	
	@Override
	public String toString() {
		return String.format("회원가입 \n"
				+ "1.이름 :%s\n"
				+ "2.아이디 :%s\n"
				+ "3.비번 :%s\n"
				+ "4.주민번호 :%s\n"
				+ "5.혈액형 :%s\n"
				+ "6.키 :%s\n"
				+ "7.몸무게 :%s\n",name,id,pw,ssn,blood,height,weight);
	}
}