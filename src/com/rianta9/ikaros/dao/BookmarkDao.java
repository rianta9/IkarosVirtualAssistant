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
import java.util.ArrayList;

import com.rianta9.ikaros.bean.BookMark;

/**
 * @author rianta9
 * Datecreate: 1 thg 3, 2020 15:36:46
 */
public class BookmarkDao {
	public static ArrayList<BookMark> loadBookmark() {
		File file = new File("file\\address\\bookmark.txt");
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (Exception e1) {
				e1.printStackTrace();
				System.out.println("Có lỗi khi mở file bookmark.txt!");
				return null;
			}
		}
		try {
			ArrayList<BookMark> list = new ArrayList<BookMark>();
			// Load data unicode
			BufferedReader reader = 
				new BufferedReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8));
			while(true) {
				String rem = reader.readLine();
				if(rem == null || rem == "") break;
				String[] dulieu = rem.split("[|]");
				if(dulieu.length == 2) {
					list.add(new BookMark(dulieu[0], dulieu[1]));
				}
			}
			reader.close();
			return list;
		} catch (Exception e) {
			System.out.println("Co loi khi mo file bookmark.txt!");
			return null;
		}
	}
	
	public static void saveBookmark(ArrayList<BookMark> list) {
		File file = new File("file\\address\\bookmark.txt");
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (Exception e1) {
				System.out.println("Co loi khi mo file bookmark.txt!");
				return;
			}
		}
		try {
			// Save data unicode
			OutputStreamWriter writer =
	             new OutputStreamWriter(new FileOutputStream(file, false), StandardCharsets.UTF_8);
			for (BookMark bookmark : list) {
				writer.write(bookmark.toString()+"\n");
			}
			writer.close();
		} catch (Exception e1) {
			System.out.println("Co loi khi luu file bookmark.txt!");
			return;
		}
	}
}
