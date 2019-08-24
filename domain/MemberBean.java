package com.bitcamp.domain;

public class MemberBean {
	private String name,id,pw,ssn,blood;
	private double height,weight;
	
	
	public void setName(String name) {
		this.name = name;//this.name은 클래스안에 있는 멤버변수
	}
	public String getName() {
		return name;//메서드 안에서 name이라는 변수를 찾고 없으면 메서드 밖 클래스 필드를 확인하니 있어서 
					//굳이 this.name이라 쓰지 않아도 된다.
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getId() {
		return id;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getPw() {
		return pw;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getSsn() {
		return ssn;
	}
	public void setBlood(String blood) {
		this.blood = blood;
	}
	public String getBlood() {
		return blood;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getHeight() {
		return height;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public double getWeight() {
		return weight;
	}
	
	@Override
	public String toString() {
		return String.format("회원가입\n"
				+ "이름 : %s\n"
				+ "아이디 :%s\n"
				+ "비번 :%s\n"
				+ "주민번호 :%s\n"
				+ "혈액형 :%s\n"
				+ "키 : %scm\n"
				+ "몸무게 : %skg\n",name,id,pw,ssn,blood,height,weight);
	}
			
}
