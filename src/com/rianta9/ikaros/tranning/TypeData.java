/**
 * 
 */
package com.rianta9.ikaros.tranning;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import com.rianta9.ikaros.bean.Reply;
import com.rianta9.ikaros.dao.RepDao;

/**
 * @author rianta9
 * Datecreate: 9 thg 3, 2020 00:23:25
 * Dùng để tách Reply theo Alphabet.
 * Chỉ được dùng khi các file alphabet rỗng.
 * Hiện tại các file đều đã được cập nhật.
 */
public class TypeData {

	/**
	 * @param args
	 */
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Reply> list = RepDao.getMess("rep").data;
		if(list == null) {
			System.out.println("List null");
			return;
		}
		String[] vni = {"àáạảãăằắặẳẵâầấậẩẫ", "èéẻẹẽêếềểễệ", "đ", "ìíỉĩị", "òóỏõọôồốổỗộơờớợởỡ", "ùúụủũưừứựửữ", "ỳýỵỷỹ"};
		String[] ascii = {"a", "e", "d", "i", "o", "u", "y"}; // length = 7
		
		for (Reply reply : list) {
			if(reply != null && !reply.getBaseMessage().isEmpty() && !reply.getRep().isEmpty()) {
				char firstChar = reply.getBaseMessage().toLowerCase().charAt(0);
				if(firstChar >= 'a' && firstChar <= 'z') {
					// Mở ra để sử dụng...Phải đảm bảo các file Alphabet đều rỗng
					//saveMess(String.valueOf((char)firstChar), reply.toString());
					continue;
				}
				boolean fl = true;
				for (int i=0; i<7; i++) { //vni.length = 7
					if(vni[i].contains(String.valueOf(firstChar))) {
						// Mở ra để sử dụng...Phải đảm bảo các file Alphabet đều rỗng
						//saveMess(ascii[i], reply.toString());
						fl = false;
						break;
						
					}
				}
				// Mở ra để sử dụng...Phải đảm bảo file khac.txt là rỗng
				//if(fl) saveMess("khac", reply.toString()); // các trường hợp còn lại: 1 2 3 4 5 6 7 8 9 !@#$#%%$^%^$^%&^&*&*(*)(_ v.v
			}
		}
		System.out.println("Đã tách file thành công!");
	}
	
	/**
	 *  Add thêm 1 dòng text vào file filename.
	 * @param filename
	 * @param text
	 */
	public static void saveMess(String filename, String text) {
		File file = new File("file\\mess\\"+filename+".txt");
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e1) {
				System.out.println("Có lỗi khi mở file " + filename);
				return;
			}
		}
		try {
			OutputStreamWriter writer =
	             new OutputStreamWriter(new FileOutputStream(file, true), StandardCharsets.UTF_8);
			writer.write(text + "\n");
			writer.close();
		} catch (Exception e1) {
			System.out.println("Co loi khi luu file " + filename);
			return;
		}
	}

}
