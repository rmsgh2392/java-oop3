package com.bitcamp.domain1;

public class MemberBean {
	private String name,id,pw,ssn,blood;
	private int age;
	private double height,weight;
	
//	public	MemberBean() {
//		기본 생성자
//	}
	
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
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
	public void setAge(int age) {
		this.age = age;
	}
	public int getAge() {
		return age;
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
				+ "1.이름 :%s\n"
				+ "2.아이디 :%s\n"
				+ "3.비밀번호 :%s\n"
				+ "4.주민번호 :%s\n"
				+ "5.혈액형 :%s\n"
				+ "6.나이 :%d\n"
				+ "7.키 :%s\n"
				+ "8.몸무게 :%s\n",name,id,pw,ssn,blood,age,height,weight);
	}
	
}