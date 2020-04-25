package com.rianta9.ikaros.bean;

public class Bot {
	String name;
	String nickname; // bietdanh
	String sex;
	String dateOfBirth;
	String zodiac; // cung hoang dao
	
	public Bot() {
		this.name = "Ikaros";
		this.nickname = "Ikaros";
		this.sex = "girl";
		this.dateOfBirth = "25/01/2020";
		this.zodiac = "Bảo Bình";
	}
	
	public Bot(String name, String nickname, String sex, String dateOfBirth, String zodiac) {
		super();
		this.name = name;
		this.nickname = nickname;
		this.sex = sex;
		this.dateOfBirth = dateOfBirth;
		this.zodiac = zodiac;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getZodiac() {
		return zodiac;
	}
	public void setZodiac(String zodiac) {
		this.zodiac = zodiac;
	}
}
