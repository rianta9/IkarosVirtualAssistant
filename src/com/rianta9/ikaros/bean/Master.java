package com.rianta9.ikaros.bean;

import java.time.LocalDate;
import java.time.Period;

import com.rianta9.ikaros.bo.Function;

public class Master {
	String nickname; 
	String password;
	String fullname;
	String sex;
	String birthday;
	
	public Master() {
		this.nickname = null;
		this.password = null;
		this.fullname = null;
		this.sex = null;
		this.birthday = null;
	}
	
	public Master(String nickname, String password, String fullname, String sex, String birthday) {
		super();
		if(sex.equalsIgnoreCase("nam") || sex.equalsIgnoreCase("boy") 
		|| sex.equalsIgnoreCase("con trai") || sex.equalsIgnoreCase("male")
		|| sex.equalsIgnoreCase(""))
		this.nickname = nickname;
		this.password = password;
		this.fullname = fullname;
		this.sex = sex;
		this.birthday = birthday;
	}
	
	public String getFullName() {
		return this.fullname;
	}
	
	public String getNickname() {
		return this.nickname;
	}
	
	public String getSex() {
		return this.sex;
	}
	
	public String getBirthDay() {
		return this.birthday;
	}
	
	public String getPassword() {
		 return this.password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getAge() {
		int result = 0;
		String[] bd = {"02", "09", "1999"}; 
		if(birthday.indexOf('-') != -1) {
			bd = birthday.split("[-]");
		}
		else if(birthday.indexOf('/') != -1) {
			bd = birthday.split("[/]");
		}
		else return result;
		int bdate = Integer.parseInt(bd[0]);
		int bmonth = Integer.parseInt(bd[1]);
		int byear = Integer.parseInt(bd[2]);
		String currentdate = Function.date();
		String[] cd = currentdate.split("[-]");
		int cdate = Integer.parseInt(cd[0]);
		int cmonth = Integer.parseInt(cd[1]);
		int cyear = Integer.parseInt(cd[2]);
		try {
			result = Period.between(LocalDate.of(byear, bmonth, bdate), LocalDate.of(cyear, cmonth, cdate)).getYears();
		} catch (Exception e) {
			return 0;
		}
		return result;
	}
	
	public String zodiac() {
		String result = "null";
		String[] bd = {"02", "09", "1999"}; 
		if(birthday.indexOf('-') != -1) {
			bd = birthday.split("[-]");
		}
		else if(birthday.indexOf('/') != -1) {
			bd = birthday.split("[/]");
		}
		else return result;
		int dd = Integer.parseInt(bd[0]);
		int mm = Integer.parseInt(bd[1]);
		switch(mm){
			case 1:
				if(dd<=19) result = "maket";
				else if(dd>=20) result = "baobinh";
				break;
			case 2:
				if(dd<=18) result = "baobinh";
				else if(dd>=19&&dd<=29) result = "songngu";
				else result = "null";
				break;
			case 3:
				if(dd<=20) result = "songngu";
				else if(dd>=21) result = "bachduong";
				break;
			case 4:
				if(dd<=20) result = "bachduong";
				else if(dd>=21) result = "kimnguu";
				break;
			case 5:
				if(dd<=20) result = "kimnguu";
				else if(dd>=21) result = "songtu";
				break;
			case 6:
				if(dd<=21) result = "songtu";
				else if(dd>=22) result = "cugiai";
				break;
			case 7:
				if(dd<=22) result = "cugiai";
				else if(dd>=23) result = "sutu";
				break;
			case 8:
				if(dd<=22) result = "sutu";
				else if(dd>=23) result = "xunu";
				break;
			case 9:
				if(dd<=22) result = "xunu";
				else if(dd>=23) result = "thienbinh";
				break;
			case 10:
				if(dd<=23) result = "thienbinh";
				else if(dd>=24) result = "thienyet";
				break;
			case 11:
				if(dd<=22) result = "thienyet";
				else if(dd>=23) result = "nhanma";
				break;
			case 12:
				if(dd<=21) result = "nhanma";
				else if(dd>=22) result = "maket";
				break;
			default:
				return null;
		}
		return result;
	}
	
	public String getZodiac() {
		if(zodiac().equals("maket")) return "Ma Kết";
		else if(zodiac().equals("baobinh")) return "Bảo Bình";
		else if(zodiac().equals("songngu")) return "Song Ngư";
		else if(zodiac().equals("bachduong")) return "Bạch Dương";
		else if(zodiac().equals("kimnguu")) return "Kim Ngưu";
		else if(zodiac().equals("songtu")) return "Song Tử";
		else if(zodiac().equals("cugiai")) return "Cự Giải";
		else if(zodiac().equals("sutu")) return "Sư Tử";
		else if(zodiac().equals("xunu")) return "Xử Nữ";
		else if(zodiac().equals("thienbinh")) return "Thiên Bình";
		else if(zodiac().equals("thienyet")) return "Thiên Yết";
		else return "Nhân Mã";
	}
}
