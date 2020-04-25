package com.rianta9.ikaros.bean;

import java.awt.Color;

public class Settings {
	private String urlSaveNote;
	private String musicFolder;
	private String backgroundUrl;
	private int countNumberOfTimes;
	private Color textStoryColor;
	private int textSize;
	
	public Settings() {
		super();
		this.urlSaveNote = "D:\\Ikaros\\Note";
		this.musicFolder = "E:\\Musics";
		this.backgroundUrl = "D:\\Wallpapers\\Ikaros.png";
		this.countNumberOfTimes = 1;
		this.textStoryColor = new Color(0, 206, 209);
		this.textSize = 16;
	}
	
	public Settings(String addressSaveNote, String musicFolder, String backgroundUrl, int countNumberOfTimes, Color textStoryColor, int textSize) {
		super();
		this.urlSaveNote = addressSaveNote;
		this.musicFolder = musicFolder;
		this.backgroundUrl = backgroundUrl;
		this.countNumberOfTimes = countNumberOfTimes;
		this.textStoryColor = textStoryColor;
		this.textSize = textSize;
	}
	public String getUrlSaveNote() {
		return urlSaveNote;
	}
	public void setUrlSaveNote(String addressSaveNote) {
		this.urlSaveNote = addressSaveNote;
	}
	
	
	public String getMusicFolder() {
		return musicFolder;
	}

	public void setMusicFolder(String musicFolder) {
		this.musicFolder = musicFolder;
	}

	public String getBackgroundUrl() {
		return backgroundUrl;
	}
	public void setBackgroundUrl(String backgroundUrl) {
		this.backgroundUrl = backgroundUrl;
	}
	public int getCountNumberOfTimes() {
		return countNumberOfTimes;
	}
	public void setCountNumberOfTimes(int countNumberOfTimes) {
		this.countNumberOfTimes = countNumberOfTimes;
	}
	public Color getTextStoryColor() {
		return textStoryColor;
	}
	public void setTextStoryColor(Color textStoryColor) {
		this.textStoryColor = textStoryColor;
	}
	public int getTextSize() {
		return textSize;
	}
	public void setTextSize(int textSize) {
		this.textSize = textSize;
	}
	
}
