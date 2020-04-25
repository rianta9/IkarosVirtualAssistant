package com.rianta9.ikaros.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

import com.rianta9.ikaros.bean.Master;

public class InfoDao {
	
	public static Master loadMasterInfo() {
		File file = new File("file\\info\\master_info.txt");
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (Exception e1) {
				System.out.println("Co loi khi mo file master_info.txt!");
				return null;
			}
		}
		try {
			// Load data unicode
			BufferedReader reader = 
				new BufferedReader(
					new InputStreamReader(
						new FileInputStream(file), StandardCharsets.UTF_8));
			//String rem = reader.readLine();
			String nickname = reader.readLine();
			String password = reader.readLine();
			String fullname = reader.readLine();
			String sex = reader.readLine();
			String birthday = reader.readLine();
			Master master = new Master(nickname, password, fullname, sex, birthday);
			reader.close();
			return master;
		} catch (Exception e) {
			System.out.println("Co loi khi mo file master_info.txt!");
			return null;
		}
	}
	
	public static void saveMasterInfo(Master master) {
		File file = new File("file\\info\\master_info.txt");
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (Exception e1) {
				System.out.println("Co loi khi mo file boss.txt!");
				return;
			}
		}
		try {
			// Save data unicode
			OutputStreamWriter writer =
	             new OutputStreamWriter(new FileOutputStream(file, false), StandardCharsets.UTF_8);
			//writer.write("------MasterInfo------\n");
			writer.write(master.getNickname() + "\n");
			writer.write(master.getPassword() + "\n");
			writer.write(master.getFullName() + "\n");
			writer.write(master.getSex() + "\n");
			writer.write(master.getBirthDay() + "\n");
			writer.close();
		} catch (Exception e1) {
			System.out.println("Co loi khi luu file boss.txt!");
			e1.printStackTrace();
			return;
		}
	}
}
