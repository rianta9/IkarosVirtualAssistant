/**
 * 
 */
package com.rianta9.ikaros.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

/**
 * @author rianta9
 * Datecreate: 13 thg 2, 2020 01:56:36
 */
public class CheckSystemDao {
	private static BufferedReader reader;

	public static boolean checkStatus() {
		File file = new File("file\\info\\signin.txt");
		if (!file.exists()) {
			try {
				file.createNewFile();
				updateStatus(0);
				return false;
			} catch (Exception e1) {
				e1.printStackTrace();
				System.out.println("Co loi khi mo file signin.txt!");
				return false;
			}
		}
		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8));
			// lấy statuscode
			int statusCode = Integer.parseInt(reader.readLine());
			if(statusCode != 0) {
				reader.close();
				return true;
			}
		} catch (Exception e) {
			updateStatus(0);
			System.out.println("Co loi khi mo file signin.txt!");
			return false;
		}
		return false;
	}
	
	public static void updateStatus(int value) {
		File file = new File("file\\info\\signin.txt");
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (Exception e1) {
				System.out.println("Co loi khi mo file signin.txt!");
				return;
			}
		}
		try {
			// Save data unicode
			OutputStreamWriter writer =
	             new OutputStreamWriter(new FileOutputStream(file, false), StandardCharsets.UTF_8);
			writer.write(String.valueOf(value) + "\n");
			writer.close();
		} catch (Exception e1) {
			System.out.println("Co loi khi luu file signin.txt!");
			e1.printStackTrace();
			return;
		}
	}
}
