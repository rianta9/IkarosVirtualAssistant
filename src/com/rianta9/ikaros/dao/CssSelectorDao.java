/**
 * 
 */
package com.rianta9.ikaros.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;


/**
 * @author rianta9
 * Datecreate: 25 thg 3, 2020 15:06:58
 * Css của các trang web có thể thay đổi theo thời gian.
 * Vì vậy nên viết nó ra file để có thể dễ dàng update.
 */
public class CssSelectorDao {
	/**
	 * Lấy css selector từ 1 file.
	 * Cấu trúc: element1|element2|element3|....
	 * Đọc file data để biết thông tin tổng quát.
	 * @param filename
	 * @param amount
	 * @return null nếu gặp lỗi.
	 * @filename: tên file
	 * @amount: số lượng phần tử
	 */
	public static String get(String filename, int amount) {
		File file = new File("file\\cssselector\\"+ filename);
		try {
			if(!file.exists()) file.createNewFile(); // tạo file nếu không tìm thấy
			else {
				// load data unicode
				BufferedReader reader = 
					new BufferedReader(
							new InputStreamReader(
									new FileInputStream(file), StandardCharsets.UTF_8));
				String result = reader.readLine();
				reader.close();
				if(result.split("[|]").length == amount) return result;
				else System.out.println("Dữ liệu "+filename+" không chính xác!");
			}
		} catch(Exception e) {
			System.out.println("Co loi khi mo file " + filename);
		}
		return null; 
	}
}
