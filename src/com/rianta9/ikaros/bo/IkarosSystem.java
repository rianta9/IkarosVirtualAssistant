package com.rianta9.ikaros.bo;


import java.util.ArrayList;

import com.rianta9.ikaros.bean.Reply;
import com.rianta9.ikaros.dao.RepDao;
import com.rianta9.ikaros.dao.WordDao;

public class IkarosSystem {
	/*Các dữ liệu từ file data nên được tập hợp ở đây để tránh phải gọi lại nhiều lần*/
	public Reply remember; // Ghi nhớ Reply hiện tại để training thêm dữ liệu.
	public Reply newApplyData; // Ghi nhớ Reply mới, nếu được training thì sẽ add vào list data. Nếu không thì không add vào.
	public boolean useFunction; // Đang sử dụng chức năng
	public String topic; // Chủ đề đang nói chuyện
	
	public IkarosSystem() {
		RepDao.load(); // Load toàn bộ dữ liệu reply từ file data.
		WordDao.load(); // Load toàn bộ dữ liệu từ đồng nghĩa từ file data.
		this.remember = null;
		this.topic = "";
		this.useFunction = false;
	}
	
	
	/**
	 * Thêm dữ liệu mới và lưu file.
	 */
	public void addData(Reply node) {
		if(node != null) RepDao.addData(node);
	}
	
	/**
	 * Tìm kiếm Reply trong Replist.
	 * Giới hạn độ dài: 15 khoảng trắng.
	 * @param message
	 * @return Trả về 1 Reply
	 */
	public Reply search(String message) {
		if(message.split("[ ]").length > 15) return null; // Các câu quá dài thì bỏ qua
		message = TextTools.std1(message);
		message = TextTools.getOrigin(TextTools.StandardMessageForTraining(message)); // Xóa bớt các ký tự không cần thiết
		message = TextTools.trim(message);
		// Tạo list message tương đồng
		ArrayList<String> similarMessages = WordDao.similarMessages(message);
		ArrayList<Reply> result = new ArrayList<Reply>();
		Reply rem = null;
		// Tìm kiếm trong list data từng message
		for (String string : similarMessages) {
			System.out.println("->" + string);
			rem = RepDao.search(string);
			if(rem != null) result.add(rem);
		}
		// Trả kết quả
		if(result.isEmpty()) return null;
		int rand = Function.rand(result.size());
		return result.get(rand);
	}
	
	/**
	 * Lưu data training.
	 */
	public void saveData() {
		RepDao.saveMess();
	}
	
	/**
	 * Trả lời tin nhắn từ Master.
	 * Tin nhắn nhận vào đảm bảo đã được lọc null và chỉ toàn khoảng trắng.
	 * Kiểm tra tin nhắn đó có nằm trong special logic không.
	 * Nếu có, trả về câu trả lời phù hợp.
	 * Nếu không, kiểm tra tin nhắn đó có nằm trong data replist không.
	 * Nếu có, sử dụng random để lựa chọn sẽ trả lời hay training thêm data.
	 * Nếu không, sử dụng random để lựa chọn sẽ trả lời theo logic hay là training data mới.
	 * @param message
	 * @return Trả về 1 câu trả lời
	 */
	public String answerMessage(String message) {
		message = TextTools.trim(message.toLowerCase());

		System.out.println("------------------------------------");
		System.out.println("Chuẩn hóa text:[" + message + "]");
		// type 1: require function
		String logicAnswer;
		
		//TODO: lỗi không nhận diện được keyword "tôi là ai"
		// Những tin nhắn bắt buộc phải trả lời bằng logic
		System.out.println("Special logic Check: " + message);
		logicAnswer = DefaultLogic.specialLogic(message, topic);
		if(logicAnswer != null) {
			String[] parse = logicAnswer.split("[|]");
			this.topic = parse[0];
			System.out.println("Type message: Phải trả lời bằng mặc định.");
			return TextTools.std4(parse[1]);
		}
		else {
			System.out.println("Result: null");
			this.topic = ""; // reset topic
		}
		
		// Kiểm tra có phải là tin nhắn yêu cầu chức năng hay không
		System.out.println("Function Check: " + message);
		logicAnswer = DefaultLogic.functionLogic(message);
		if(logicAnswer != null) {
			useFunction = true;
			System.out.println("Type message: Yêu cầu chức năng.");
			return TextTools.std4(logicAnswer);
		}
		else System.out.println("Result: null");
		
		/*-----------------------------------------------------------------------*/
		// type 2: normal message
		// Còn lại: Trả lời bằng data
		System.out.println("Search data...");
		Reply reply = search(message); // Tìm data trong RepList
		if(reply != null) {
			if(Function.random(29) == 22) {
				System.out.println("Lựa chọn training thêm dữ liệu!");
				remember = reply; // Lưu lại địa chỉ reply để training data
				return null;
			}
			else {
				String mess = reply.chooseOne();
				if(mess != null) {
					System.out.println("Type message: Trả lời theo data.");
					return TextTools.std4(mess);
				}
				else{
					remember = reply;
					System.out.println("Result: null");
					return null;
				}
			}
		}
		else { // Nếu không có data trong RepList
			if(Function.random(12) == 9) { // Nếu random đc số 12
				Reply newReply = new Reply(message); // Tạo mới 1 Reply
				//addData(newReply); // Add Reply vào list
				System.out.println("Lựa chọn training dữ liệu mới!");
				newApplyData = newReply; // Lưu lại reply mới. Nếu được training sẽ thêm vào list data.
				return null;
			}
			else {
				//Nếu tồn tại logic có sẵn, trả lời theo logic 
				logicAnswer = DefaultLogic.basicLogic(message);
				if(logicAnswer != null) {
					System.out.println("Type message: Trả lời theo keywords");
					return TextTools.std4(logicAnswer);
				}
				// Nếu không tồn tại logic có sẵn
				Reply newReply = new Reply(message); // Tạo mới 1 Reply
				System.out.println("Lựa chọn training dữ liệu mới!");
				newApplyData = newReply; // Lưu lại reply mới. Nếu được training sẽ thêm vào list data.
				return null;
			}
		}
	}
	
}
