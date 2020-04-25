/**
 * 
 */
package com.rianta9.ikaros.bean;

import java.util.ArrayList;

import com.rianta9.ikaros.bo.TextTools;
import com.rianta9.ikaros.dao.WordDao;


/**
 * @author rianta9
 * Datecreate: 9 thg 3, 2020 14:32:33
 * Class này dùng để chứa List Reply theo Alphabet
 */
public class ListData {
	public ArrayList<Reply> data; // List Reply
	
	public ListData() {
		this.data = null;
	}
	
	public ListData(ArrayList<Reply> list) {
		this.data = list;
	}
	
	/**
	 * Thêm 1 Reply vào list.
	 * @param node
	 */
	public void addData(Reply node) {
		if(data == null) data = new ArrayList<Reply>();
		if(data != null) data.add(node);
	}
	
	/**
	 * Tìm kiếm 1 message trong list.
	 * @param message
	 * @return Trả về 1 Reply. Nếu không tìm được trả về null.
	 */
	public Reply search(String message) {
		message = TextTools.getOrigin(TextTools.StandardMessageForTraining(message)); // Xóa bớt các ký tự không cần thiết
		message = TextTools.trim(message);
		for (Reply reply : data) {
			if(reply.getBaseMessage().equalsIgnoreCase(message)) return reply;
			ArrayList<String> similarMessage = WordDao.similarMessages(reply.getBaseMessage());
			for (String string : similarMessage) {
				if(string.equalsIgnoreCase(message)) {
					System.out.println("Tìm thấy kết quả!\nShow dữ liệu liên quan:");
					for (String string2 : similarMessage) {
						System.out.println(string2);
					}
					return reply;
				}
			}
		}
		return null;
	}
	

}
