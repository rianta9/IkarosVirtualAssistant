/**
 * 
 */
package com.rianta9.ikaros.bean;

import java.util.ArrayList;

import com.rianta9.ikaros.bo.Function;
import com.rianta9.ikaros.bo.TextTools;
import com.rianta9.ikaros.dao.InfoDao;
import com.rianta9.ikaros.dao.WordDao;

/**
 * @author rianta9
 * Datecreate: 3 thg 9, 2020 17:35:50
 * Dùng để lưu dữ liệu logic theo keyword
 * Dữ liệu logic được lấy từ database bằng class LogicData. gồm 2 thông tin: keywords và replies
 * Sử dụng trong IkarosSystem Class
 */
public class LogicReply {

	private ArrayList<String> keywords;
	private ArrayList<String> replyMessages;
	
	/**
	 * Chỉ dành cho lấy dữ liệu vào từ file
	 * @param keywords
	 * @param replyMessages
	 */
	public LogicReply(ArrayList<String> keywords, ArrayList<String> replyMessages) {
		super();
		this.keywords = keywords;
		this.replyMessages = replyMessages;
	}
	
	public LogicReply(String keywords, String replyMessages) {
		super();
		this.keywords = divideText(keywords);
		this.replyMessages = divideText(replyMessages);
	}
	
	
	public ArrayList<String> getkeywords() {
		return keywords;
	}
	
	public ArrayList<String> getRep() {
		return replyMessages;
	}
	
	/**
	 * Kiểm tra Logic này có khớp với message hay không
	 * @param mess
	 */
	public boolean checkLogic(String mess) {
		for(String i:keywords) {
			String[] list = i.split("[&]");
			boolean flag = true;
			for(String key: list) {
				if(!mess.contains(key)) flag = false;
			}
			if(flag) {
				System.out.println("Bộ từ khóa: [" + i + "] phù hợp!");
				return true;
			}
		}
		return false;
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
		for(String i:list) {
			String data = TextTools.StandardReplyForTraining(i);
			if(data != null && !data.trim().isEmpty()) {
				if(replyMessages.contains(data) == false)
					replyMessages.add(data);
				System.out.println(data);
			}
		}
	}
	
	public ArrayList<String> divideText(String text){
		ArrayList<String> result = new ArrayList<String>();
		String[] list = text.split("[|]");
		for(String i:list) {
			if(i != null) result.add(i);
		}
		return result;
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
		if(reply.split("[ ]").length <= 15) {
			// Tạo các reply tương đồng và chọn 1 trong số đó để gán cho reply
			ArrayList<String> similarReply = WordDao.similarMessages(reply);
			System.out.println("Các câu trả lời được chọn:");
			for (String string : similarReply) {
				System.out.println(string);
			}
			rand = Function.rand(similarReply.size()); // chọn 1 index
			reply = similarReply.get(rand);
		}
		// Tạo các cách xưng hô khác nhau
		ArrayList<String> choose = TextTools.similarAddressForData(reply, InfoDao.loadMasterInfo().getSex());
		rand = Function.rand(choose.size());// chọn 1 để phản hồi
		reply = choose.get(rand); 
		return TextTools.parseAddress(reply);
	}
}
