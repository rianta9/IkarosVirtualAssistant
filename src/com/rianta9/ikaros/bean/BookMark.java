/**
 * 
 */
package com.rianta9.ikaros.bean;

/**
 * @author rianta9
 * Datecreate: 26 thg 2, 2020 00:03:08
 */
public class BookMark {
	public String name; // tên
	public String path; // url
	
	public BookMark() {
		this.name = null;
		this.path = null;
	}
	
	public BookMark(String name, String path) {
		name = name.replace("-", " ");
		name = name.replace("_", " ");
		this.name = name;
		this.path = path;
	}
	
	public boolean like(String musicname) {
		//System.out.println(name);
		musicname = musicname.toLowerCase().trim();
		if(this.name.toLowerCase().contains(musicname)) return true;
		return false;
	}
	
	public String toString() {
		return this.name.trim() + "|" + this.path.trim();
	}
}
