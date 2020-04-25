package com.rianta9.ikaros.dao;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

import com.rianta9.ikaros.bean.Settings;

public class SettingDao {
	public static Settings LoadSettingInfo() {
		File file = new File("file\\info\\setting.txt");
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (Exception e1) {
				System.out.println("Co loi khi mo file setting.txt!");
				return null;
			}
		}
		try {
			// Load data unicode
			BufferedReader reader = 
				new BufferedReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8));
			String urlSaveNote = reader.readLine();
			String musicFolder = reader.readLine();
			String backgroundUrl = reader.readLine();
			int countNumberOfTimes = Integer.parseInt(reader.readLine());
			String[] color = reader.readLine().split("[,]");
			Color textStoryColor = new Color(Integer.parseInt(color[0]), Integer.parseInt(color[1]), Integer.parseInt(color[2]));
			int textSize = Integer.parseInt(reader.readLine());
			Settings setting = new Settings(urlSaveNote, musicFolder, backgroundUrl, countNumberOfTimes, textStoryColor, textSize);
			reader.close();
			return setting;
		} catch (Exception e) {
			System.out.println("Co loi khi mo file setting.txt!");
			return null;
		}
	}
	
	public static void SaveSettingInfo(Settings setting) {
		File file = new File("file\\info\\setting.txt");
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (Exception e1) {
				System.out.println("Co loi khi mo file setting.txt!");
				return;
			}
		}
		try {
			// Save data unicode
			OutputStreamWriter writer =
	             new OutputStreamWriter(new FileOutputStream(file, false), StandardCharsets.UTF_8);
			writer.write(setting.getUrlSaveNote() + "\n");
			writer.write(setting.getMusicFolder() + "\n");
			writer.write(setting.getBackgroundUrl() + "\n");
			writer.write(String.valueOf(setting.getCountNumberOfTimes()) + "\n");
			Color rem = setting.getTextStoryColor();
			String color = String.valueOf(rem.getRed())+","+String.valueOf(rem.getGreen())+","+String.valueOf(rem.getBlue());
			writer.write(color + "\n");
			writer.write(String.valueOf(setting.getTextSize()) + "\n");
			writer.close();
		} catch (Exception e1) {
			System.out.println("Co loi khi luu file setting.txt!");
			e1.printStackTrace();
			return;
		}
	}
}
