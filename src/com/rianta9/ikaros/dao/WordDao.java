/**
 * 
 */
package com.rianta9.ikaros.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;


/**
 * @author rianta9
 * Datecreate: 10 thg 3, 2020 23:05:34
 */
public class WordDao {
	public static ArrayList<String[]> synonymsList;
	
	/**
	 * Hàm kích hoạt.
	 * Load dữ liệu từ file.
	 * Trước khi sử dụng WordDao phải dùng hàm này để load data.
	 */
	public static void load() {
		synonymsList = new ArrayList<String[]>();
		File file = new File("file\\word\\synonym.txt");
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (Exception e1) {
				System.out.println("Co loi khi mo file synonym.txt");
			}
		}
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8));
			while(true) {
				String rem = reader.readLine();
				if(rem == null) break;
				String[] dulieu = rem.split("[|]");
				if(dulieu.length < 2) continue; // tối thiểu: synonym1|synonym2
				synonymsList.add(dulieu);
			}
			reader.close();
		} catch (Exception e) {
			System.out.println("Co loi khi mo file synonym.txt");
		}
	}
	
	/**
	 * Trả về danh sách các list từ đồng nghĩa.
	 * Dùng để tạo các câu có nghĩa tương tự nhau.
	 * @return Trả về 1 ArrayList rỗng nếu có lỗi xảy ra.
	 */
	public static ArrayList<String[]> getSynonyms(){
		return synonymsList;
	}
	
	
	/**
	 * Kiểm tra khi thay rem1 bằng rem2 có gây ra lỗi trùng lặp từ hay không Ex:như
	 * vậy thì đi chơi thôi rem1: vậy thì rem2: như vậy => loại cách trường hợp: như
	 * như vậy thì, vậy thì thì
	 * 
	 * @param text
	 * @param rem1
	 * @param rem2
	 * @return
	 */
	public static boolean checkRepeatWord(String text, String rem1, String rem2) {
		String giao;
		String[] rem = rem2.split("[ ]");
		giao = rem[0] + " " + rem1;
		if (text.contains(giao))
			return false;
		giao = rem1 + " " + rem[rem.length - 1];
		if (text.contains(giao))
			return false;
		return true;
	}
	
	/**
	 * Tạo ra các câu đồng nghĩa từ 1 đoạn text.
	 * @param result: lưu kết quả trả về
	 * @param text: 1 đoạn text
	 * @param rem: tập các từ đồng nghĩa
	 */
	public static void baseSimilarReply(ArrayList<String> result, String text, String[] rem) {
		text = text.toLowerCase(); // Chuyển sang chữ thường
		int n = rem.length;
		for (int i = 0; i < n; i++) {
			if (text.contains(rem[i])) {
				for (int j = 0; j < n; j++) {
					if (i != j && checkRepeatWord(text, rem[i], rem[j])) {
						String data = text.replace(rem[i], rem[j]).trim();
						if (!result.contains(data)) {
							result.add(data);
						}
					}
				}
			}
		}
	}
	
	
	
	
	/**
	 * Tạo tất cả các câu tương đồng từ một đoạn text.
	 * Dùng để tìm kiếm tin nhắn.
	 * @param result
	 * @param text
	 * @param rem
	 */
	public static void add(ArrayList<String> result, String text, String[] rem) {
		ArrayList<String> base = new ArrayList<String>();
		for (String string : result) {
			baseSimilarReply(base, string, rem);
		}
		result.addAll(base);
		for (String string : base) {
			baseSimilarReply(result, string, rem); // Lựa chọn ra 1 base để tạo câu đồng nghĩa
		}
	}

	/**
	 * Tạo các bản rep tương tự của 1 reply Dùng cho việc training ikaros.
	 * 
	 * @param text
	 * @return
	 */
	public static ArrayList<String> similarMessages(String text) {
		ArrayList<String[]> synonymsList = WordDao.synonymsList; // lấy dữ liệu
		text = text.toLowerCase();
		ArrayList<String> result = new ArrayList<String>();
		result.add(text);
		// Lấy dữ liệu từ file
		for (String[] strings : synonymsList) {
			add(result, text, strings);
		}
		return result;
	}
}
