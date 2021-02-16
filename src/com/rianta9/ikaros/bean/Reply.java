package com.rianta9.ikaros.bean;

import java.util.ArrayList;

import com.rianta9.ikaros.bo.Function;
import com.rianta9.ikaros.bo.TextTools;
import com.rianta9.ikaros.dao.InfoDao;
import com.rianta9.ikaros.dao.WordDao;


public class Reply {
	private String baseMessage;
	private ArrayList<String> replyMessages;
	
	/**
	 * Chỉ dành cho lấy dữ liệu vào từ file
	 * @param baseMessage
	 * @param replyMessages
	 */
	public Reply(String baseMessage, ArrayList<String> replyMessages) {
		super();
		this.baseMessage = baseMessage;
		this.replyMessages = replyMessages;
	}
	
	public Reply(String baseMessage, String replyMessages) {
		super();
		this.baseMessage = TextTools.StandardMessageForTraining(baseMessage);
		this.replyMessages = new ArrayList<String>();
		addAnswer(replyMessages);
	}
	
	public Reply(String baseMessage) {
		super();
		this.baseMessage = TextTools.StandardMessageForTraining(baseMessage);
		replyMessages = new ArrayList<String>();
	}
	
	public String getBaseMessage() {
		return baseMessage;
	}
	
	public ArrayList<String> getRep() {
		return replyMessages;
	}
	
	/**
	 * Dữ liệu vào: 1 chuỗi
	 * Split chuỗi đó ra các chuỗi con.
	 * ChuanHoa4 mỗi chuỗi con.
	 * Kiểm tra mỗi chuỗi con đã tồn tại trong list hay chưa.
	 * Add từng chuỗi con hợp lệ vào replyMessage.
	 * @param ans
	 */
	public void addAnswer(String ans) {
		String[] list = ans.split("[|]");
//		System.out.println("------Training:");
//		System.out.println("Message: "+this.baseMessage);
//		System.out.println("List Reply:");
		for(String i:list) {
			String data = TextTools.StandardReplyForTraining(i);
			if(data != null && !data.trim().isEmpty()) {
				if(replyMessages.contains(data) == false)
					replyMessages.add(data);
//				System.out.println(data);
			}
		}
	}
	
	/**
	 * Chọn một câu trả lời trong list reply
	 * Tạo các similar reply
	 * Chọn một trong số đó để phản hồi.
	 * @return result
	 */
	public String chooseOne() {
		int n = replyMessages.size();
		if(n == 0) return null;
		int rand = Function.rand(n); // chọn 1 index
		String reply = replyMessages.get(rand);
		// Nếu reply có 15 từ trở lên thì không tạo các reply tương đồng
//		if(reply.split("[ ]").length <= 15) {
//			// Tạo các reply tương đồng và chọn 1 trong số đó để gán cho reply
//			ArrayList<String> similarReply = WordDao.similarMessages(reply);
//			System.out.println("Các câu trả lời được chọn:");
//			for (String string : similarReply) {
//				System.out.println(string);
//			}
//			rand = Function.rand(similarReply.size()); // chọn 1 index
//			reply = similarReply.get(rand);
//		}
		// Tạo các cách xưng hô khác nhau
		ArrayList<String> choose = TextTools.similarAddressForData(reply, InfoDao.loadMasterInfo().getSex());
		rand = Function.rand(choose.size());// chọn 1 để phản hồi
		reply = choose.get(rand); 
		return TextTools.parseAddress(reply);
	}
	
	/**
	 * Dùng trong lúc lưu file data.
	 * Add tất cả các chuỗi trong 1 Reply lại thành một. 
	 * baseMessage đứng đầu, các chuỗi cách nhau bằng ký tự '|'
	 * @return result
	 */
	public String toString() {
		String result = TextTools.getOrigin(baseMessage); // Xóa dấu, các ký tự không cần thiết
		for(String i:replyMessages) {
			result = result + "|" + i;
		}
		return result;
	}
	
}
