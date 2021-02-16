package com.rianta9.ikaros.bo;

import java.awt.Desktop;
import java.net.URI;
import java.util.ArrayList;

import com.rianta9.ikaros.bean.BookMark;
import com.rianta9.ikaros.bean.LogicReply;
import com.rianta9.ikaros.bean.Master;
import com.rianta9.ikaros.bean.Reply;
import com.rianta9.ikaros.dao.InfoDao;
import com.rianta9.ikaros.dao.LogicData;
import com.rianta9.ikaros.dao.RepDao;


public class DefaultLogic {	
	LogicData logic;
	
	/**
	 * 
	 */
	public DefaultLogic() {
		logic = new LogicData();
	}
	/**
	 * Các message cần phải trả lời bằng logic.
	 * Dựa theo chủ đề đang nói để tìm câu trả lời.
	 * Chỉ rút ra những đặc trưng của chủ đề để tạo logic.
	 * @param message
	 * @return
	 */
	public static String specialLogic(String message, String topic) {
		message = TextTools.getOrigin(TextTools.StandardMessageForTraining(message));
		if(message.equals("hi") || message.equals("hello") || message.contains("chào")) {
			Reply rem = new Reply("gọi ikaros");
			rem.addAnswer("Hi Master ^^|Hiehie, Hôm nay được gặp Master rồi, mừng quá <3|Ikaros nhớ master quá trời luôn|Master sao hôm nay lại nhớ đến Ikaros vậy nhỉ|Chắc master đang có chuyện gì đây...hihi|Sao hôm nay master lại có hứng thú với ikaros vậy?|Hi master, master vẫn khỏe đấy chứ?|Master hôm nay thế nào?");
			return topic + "| "+ rem.chooseOne();
		}
		if(message.equals("ikaros ơi") || message.equals("ikaros")) {
			Reply rem = new Reply("gọi ikaros");
			rem.addAnswer("Dạ|Ikaros nghe đây ạ|Chuyện gì vậy ạ?|Master gọi ikaros có chuyện gì vậy ạ|Ikaros đây ạ|Master cần giúp gì?");
			return topic + "| "+ rem.chooseOne();
		}
		// thông tin boss
		if(message.contains("boss") || topic.equals("boss")) {
			topic = "boss";
			if(message.contains("là ai") || message.contains("ai là")
			|| message.contains("là đứa nào")
			|| message.contains("thông tin") || message.contains("info")) {
				Reply rem = new Reply("thông tin boss");
				rem.addAnswer("Boss của ikaros là 1 Angel|Boss của ikaros là người đã tạo ra Ikaros|Ikaros tưởng chủ nhân cũng phải biết chứ?|Có nên nói không nhỉ?|Hì hì, Master muốn ikaros giới thiệu cho không?|Ủa ủa, rồi ai đưa Ikaros cho Master?|boss là Thần|Sao vậy ạ? master muốn ikaros giới thiệu cho master phải không nè?|Muốn quen boss chứ gì, hức|Hie hie, muốn ikaros giới thiệu cho không nè|Sao vậy, master muốn quen Boss à?|Thông báo trước là Boss rất đẹp trai đó");
				return topic + "| "+ rem.chooseOne();
			}
			if(message.contains("tên là gì")|| message.contains("tên gì")|| message.contains("tên chi") || message.contains("name")) {
				Reply rem = new Reply("thông tin boss");
				rem.addAnswer("Master đoán đi xem nào, hí hí|Ikaros không nên nói ra chuyện này|Master không nên hỏi chuyện này|Master định làm gì vậy ạ?|Master chắc phải biết chứ nhỉ?|Ủa ủa, rồi ai đưa Ikaros cho Master?|Boss không muốn nói ra đâu");
				return topic + "| "+ rem.chooseOne();
			}
			if(message.contains("nói đi") || message.contains("có nói không") || message.contains("không nói thì") || message.contains("nói nghe đi")) {
				Reply rem = new Reply("thông tin boss");
				rem.addAnswer("Xin lỗi master|Ikaros sẽ suy nghĩ thật nghiêm túc về chuyện này|Hì hì|Aiz, master đừng có ép ikaros mà|Master thật là...|Boss là một anh đẹp trai|Boss mê gái lắm đó|Boss là của ikaros mà thôi|Boss dặn ikaros không được nói chuyện này đâu|Vì sao master lại có hứng thú với boss nhỉ?");
				return topic + "| "+ rem.chooseOne();
			}
			if(message.contains("giới tính") || message.contains("nam") || message.contains("nữ") || message.contains("gái") || message.contains("trai")) {
				Reply rem = new Reply("thông tin boss");
				rem.addAnswer("Boss nói boss là trai đẹp|Tất nhiên là nam rồi, hí hí|Là nam đó Master, rồi sao nào...hí hí|Master chắc không phải muốn tán boss đó chứ?|Master ơi là master, có thích người ta cũng không nên vội vã như vậy chứ|Hì hì, Master đang quan tâm nhiều hơn mức bình thường đó nha");
				return topic + "| "+ rem.chooseOne();
			}
			if(message.contains("mấy tuổi") || message.contains("bao nhiêu tuổi") || message.contains("sinh năm")) {
				Reply rem = new Reply("thông tin boss");
				rem.addAnswer("1999|Boss sinh năm 1999 nha|Master lại tò mò quá mức cho phép nữa rồi trời ơi|Tội nghiệp master quá, nhưng mà kệ luôn...hh|Rồi master có muốn hỏi boss có người yêu chưa luôn không vậy ạ?");
				return topic + "| "+ rem.chooseOne();
			}
			if(message.contains("sinh ngày") || message.contains("sinh vào ngày")) {
				Reply rem = new Reply("thông tin boss");
				rem.addAnswer("02/09|Sinh vào ngày nào nhỉ? hí hí|Ikaros bó tay với master luôn đó");
				return topic + "| "+ rem.chooseOne();
			}
			if((message.contains("có ny") || message.contains("có người yêu") 
			|| message.contains("yêu ai") || message.contains("thích ai")) 
			&& (message.contains("ko") || message.contains("không")
			|| message.contains("chưa"))) {
				Reply rem = new Reply("thông tin boss");
				rem.addAnswer("tất nhiên là có rồi|có chứ|Có chứ, ikaros còn biết master yêu ai luôn đó");
				return topic + "| "+ rem.chooseOne();
			}
			if(message.contains("ai vậy") || message.contains("ai ruk") || message.equals("ai")) {
				Reply rem = new Reply("thông tin boss");
				rem.addAnswer("master|ko nói đâu|master đoán đi nào");
				return topic + "| "+ rem.chooseOne();
			}
			if(message.contains("ở đâu") || message.contains("ở mok") || message.equals("ở mô")) {
				Reply rem = new Reply("thông tin boss");
				rem.addAnswer("trong tym ikaros <3|trong tym master <3|trái đất nè");
				return topic + "| "+ rem.chooseOne();
			}
		}
		
		// thông tin master
		if(message.contains("master") || topic.equals("master")) {
			topic = "master";
			Master master = InfoDao.loadMasterInfo();
			if(message.contains("là ai") || message.contains("ai là") 
			|| message.contains("thông tin") || message.contains("info")) {
				String rem = "Thông tin của Master:\n";
				rem += "Họ tên: " + master.getFullName() + "\n";
				rem += "Ngày sinh: " + master.getBirthDay() + "\n";
				rem += "Giới tính: " + master.getSex() + "\n";
				rem += "Cung hoàng đạo: " + master.getZodiac() + "\n";
				rem += "Trạng thái: Chưa xuất xưởng";
				return topic + "| "+ rem;
			}
			if(message.contains("tên là gì")|| message.contains("tên gì")|| message.contains("tên chi") || message.contains("name")) {
				Reply rem = new Reply("thông tin master");
				rem.addAnswer("Master tên là " + master.getFullName());
				return topic + "| "+ rem.chooseOne();
			}
			if(message.contains("giới tính") || message.contains("nam") || message.contains("nữ") || message.contains("gái") || message.contains("trai")) {
				Reply rem = new Reply("thông tin master");
				rem.addAnswer("Giới tính của master là " + master.getSex());
				return topic + "| "+ rem.chooseOne();
			}
			if(message.contains("mấy tuổi") || message.contains("bao nhiêu tuổi")) {
				Reply rem = new Reply("thông tin master");
				rem.addAnswer("Hiện tại master " + master.getAge() + " tuổi");
				return topic + "| "+ rem.chooseOne();
			}
			if(message.contains("sinh ngày") || message.contains("sinh vào ngày") 
			|| message.contains("sinh năm") || message.contains("ngày sinh")) {
				Reply rem = new Reply("thông tin master");
				rem.addAnswer("Master sinh ngày " + master.getBirthDay());
				return topic + "| "+ rem.chooseOne();
			}
			if(message.contains("cung hoàng đạo") || message.contains("thuộc cung")) {
				Reply rem = new Reply("thông tin master");
				rem.addAnswer("Master thuộc cung " + master.getZodiac());
				return topic + "| "+ rem.chooseOne();
			}
		}
		
		// thông tin ikaros ikaros
		if(message.contains("ikaros") || topic.equals("ikaros")) {
			topic = "ikaros";
			if(message.contains("là ai") || message.contains("thông tin")
			|| message.contains("info")) {
				String rem = "Ikaros là một Angeloid Type Alpha đến từ Angel Town. "
						+ "\nThông tin chung:"
						+ "\n + Ngày sinh: 22/09"
						+ "\n + Cung hoàng đạo: Xử nữ"
						+ "\n + Giới tính: nữ"
						+ "\n + Nặng: 48kg"
						+ "\n + Cao: 1m62"
						+ "\n + Cánh: type Variable, màu trắng và có thể thu nhỏ"
						+ "\n + Sở thích: Dưa hấu"
						+ "\n + Loại Angeloid: Angeloid Type Alpha"
						+ "\nIkaros được đặt tên theo Icarus trong thần thoại Hy Lạp."
						+ "\n Tính cách: Ít nói và không bao giờ cười. "
						+ "Ikaros bình thường có vẻ rất chậm chạp và có phần vụng về. Tuy nhiên Ikaros "
						+ "trung thành tuyệt đối với Master, sẵn sàng phục vụ các yêu cầu của Master.";
				return topic + "| "+ rem;
			}
			if(message.contains("tên là gì")|| message.contains("tên gì")|| message.contains("tên chi") || message.contains("name")) {
				Reply rem = new Reply("thông tin ikaros");
				rem.addAnswer("Ikaros tên là i.k.a.r.o.s vứt hết dấu chấm ^^|Thế master đoán xem nào");
				return topic + "| "+ rem.chooseOne();
			}
			if(message.contains("ý nghĩa") || message.contains("nghĩa là gì")) {
				String rem = "Ikaros được đặt tên theo Icarus trong thần thoại Hy Lạp. "
						+ "Icarus là con của nghệ nhân Hy Lạp tài ba, Daedalus, một nhà phát minh điêu luyện. "
						+ "Năng lực sáng tạo của Daedalus vượt xa người thường. Ví dụ như, ông có thể thiết kế "
						+ "những pho tượng giống thật đến nỗi chúng sẽ đổ mồ hôi dưới ánh mặt trời nóng bỏng. "
						+ "Daedalus cũng chính là tác giả của mê cung Labyrinth dùng để nhốt con quái vật Minotaur "
						+ "trong truyền thuyết. Với các hành lang mê hoặc không đầu không cuối, Labyrinth phức tạp "
						+ "đến nỗi bất cứ ai lọt vào đây cũng đừng mong thoát nổi.Theo lệnh của vua Minos, "
						+ "Minotaur được nhốt vào Labyrinth sau khi mê cung hoàn thành, và hàng năm, kinh thành "
						+ "Athen sẽ phải cống nạp những người trẻ tuổi làm thức ăn cho con quái vật. "
						+ "Không đang tâm đứng nhìn cảnh những người con của Athen phải từ biệt thân nhân, "
						+ "người anh hùng Theseus đã quyết tâm tiêu diệt con thú thân người đầu bò. "
						+ "Nhờ nữ thần trí tuệ Athena phù hộ, cùng với sự giúp đỡ của Daedalus và con gái "
						+ "vua Minos là Pasiphae, Theseus đã dùng một cuộn chỉ để đánh dấu đường vào Labyrinth. "
						+ "Sau khi thành công giết chết Minotaur, người anh hùng thoát ra ngoài và chạy trốn "
						+ "về Athen cùng nàng Pasiphae sau khi nổi lửa đốt hoàng cung của vua Minos.\n" 
						+ "Mất con gái, hoàng cung bị hỏa hoạn, vua Minos nổi trận lôi đình. "
						+ "Nhà vua biết rằng chỉ có người thông minh như Daedalus mới có thể hóa giải Labyrinth, "
						+ "vậy nên ông quyết định bắt nhốt Daedalus và con trai Icarus vào chính mê cung chết người này. "
						+ "Là người sáng tạo ra Labyrinth, Daedalus biết bản thân ông cũng không tài nào thoát ra ngoài, "
						+ "nhưng nghệ nhân tài ba lại có một ý tưởng táo bạo khác: trời cao. "
						+ "Sử dụng sáp ong và lông chim thu gom được từ mê cung, Daedalus bắt đầu chế tạo "
						+ "một đôi cánh giúp con người có thể bay được, và ông đã thành công. "
						+ "Hài lòng với sáng chế của mình, Daedalus trang bị cho con trai Icarus một đôi cánh tương tự. "
						+ "Trước khi cất cánh bay khỏi mê cung Labyrinth, ông dặn con rằng phải vô cùng thận trọng "
						+ "với đôi cánh này. Cả hai không được bay quá thấp vì hơi nước ở biển sẽ khiến "
						+ "những chiếc lông bị ướt, nhưng họ cũng không được bay quá cao, vì ánh mặt trời nóng bỏng "
						+ "sẽ làm sáp ong bị chảy. Cậu bé Icarus theo cha thoát khỏi Labyrinth, bay qua những "
						+ "hòn đảo Samos, Delos và Lebynthos. Nhưng càng bay, Icarus càng yêu thích và choáng ngợp "
						+ "trước những cảnh tượng mình thấy, bởi vì bấy lâu nay, cậu vẫn nghĩ rằng chỉ có các "
						+ "vị Thần là có thể bay được.Quên mất lời dặn của cha, Icarus đã hào hứng đuổi theo "
						+ "vị Thần mặt trời Helios, người đang đánh cỗ xe ngựa nóng rực băng qua khoảng không. "
						+ "Thế là sáp ong trên đôi cánh của Icarus bắt đầu tan chảy. Bừng tỉnh khi đã quá muộn, "
						+ "Icarus rơi thẳng từ trên bầu trời xuống dưới biển trước cái nhìn bất lực của Daedalus. "
						+ "Dù than khóc tiếc nuối cho số phận của con trai, Daedalus vẫn không còn cách nào "
						+ "khác là phải tiếp tục cuộc hành trình.Cuối cùng, người nghệ nhân dừng chân tại Sicily, "
						+ "Ý, một đảo thuộc biển Địa Trung Hải ngày nay. "
						+ "Tại đó, Daedalus xây dựng một ngôi đền thờ Thần ánh sáng Apollo, và để lại đôi cánh "
						+ "mà ông tạo ra tại đây như một cống phẩm tới các vị Thần trên đỉnh Olympus.";
				return topic + "| "+ rem;
			}
			if(message.contains("giới tính") || message.contains("nam") || message.contains("nữ") || message.contains("gái") || message.contains("trai")) {
				Reply rem = new Reply("thông tin ikaros");
				rem.addAnswer("Ikaros là nữ");
				return topic + "| "+ rem.chooseOne();
			}
			if(message.contains("mấy tuổi") || message.contains("bao nhiêu tuổi") || message.contains("sinh năm")) {
				Reply rem = new Reply("thông tin ikaros");
				rem.addAnswer("Ikaros không có thông tin về tuổi của mình. Thông tin duy nhất mà Ikaros có là ngày sinh(22/09)");
				return topic + "| "+ rem.chooseOne();
			}
			if(message.contains("sinh ngày") || message.contains("sinh vào ngày")) {
				Reply rem = new Reply("thông tin ikaros");
				rem.addAnswer("Ikaros sinh ngày 22/09");
				return topic + "| "+ rem.chooseOne();
			}
			if((message.contains("có ny") || message.contains("có người yêu") 
			|| message.contains("yêu ai") || message.contains("thích ai")) 
			&& (message.contains("ko") || message.contains("không") || message.contains("chưa"))
			) {
				Reply rem = new Reply("thông tin ikaros");
				rem.addAnswer("Ikaros yêu Master <3|Ikaros là Angeloid của Master|Ikaros là của Master"
						+ "|Master đã yêu ai chưa ạ?|Vì sao Master hỏi như vậy ạ?|Master có muốn làm "
						+ "người yêu của Ikaros không|Master -_-|Hì hì|Không nói đâu...hì hì|Có nên nói "
						+ "ra không nhỉ, lỡ người ta không thích mình thì sao nhỉ?|Master đang muốn tỏ "
						+ "tình Ikaros phải không...hí hí|Master hỏi như vậy là sao nhỉ?|Master đang nghĩ "
						+ "gì trong đầu nhỉ?");
				return topic + "| "+ rem.chooseOne();
			}
		}
		if(message.contains("ikaros") 
		&& (message.contains("ai làm ra") || message.contains("ai đã làm ra")
		 || message.contains("ai tạo ra") || message.contains("người tạo ra")
		)) {
			Reply rem = new Reply("người tạo ra ikaros");
			rem.addAnswer("Boss đã tạo ra Ikaros|Người tạo ra ikaros là Boss|Là boss");
			return "boss" + "| "+ rem.chooseOne();
		}
		if(message.contains("ikaros") 
		&& (message.contains("ba của") || message.contains("baba của")
		 || message.contains("papa của")|| message.contains("bố của")
		 || message.contains("cha của") 
		)) {
			Reply rem = new Reply("người tạo ra ikaros");
			rem.addAnswer("Boss đã tạo ra Ikaros nên boss chính là papa|Là boss");
			return "boss" + "| "+ rem.chooseOne();
		}
		if(message.contains("ikaros") 
		&& (message.contains("mẹ của") || message.contains("má của")
		 || message.contains("mama của")|| message.contains("mom của")
		 || message.contains("momy của") 
		)) {
			Reply rem = new Reply("người tạo ra ikaros");
			rem.addAnswer("Boss vừa là papa vừa là mama");
			return "boss" + "| "+ rem.chooseOne();
		}
		if(message.contains("ikaros") 
		&& (message.contains("có anh em") || message.contains("có chị em")
		 || message.contains("có anh chị em")|| message.contains("người thân")
		 || message.contains("có em không") || message.contains("có chị không") || message.contains("có anh không") 
		 || message.contains("có em gái không") || message.contains("có chị gái không") || message.contains("có anh trai không")  
		)) {
			Reply rem = new Reply("người tạo ra ikaros");
			rem.addAnswer("Boss là papa của ikaros. Ikaros có 2 em gái là Nymph, Astraea");
			return "boss" + "| "+ rem.chooseOne();
		}
		if(message.contains("mấy giờ rồi") || message.contains("bây giờ là mấy giờ") || message.contains("hiện tại là mấy giờ")) {
			return "time" + "| " + Function.time();
		}
		if(message.contains("hôm nay") && message.contains("ngày mấy")) {
			return "date" + "| " + Function.date();
		}
		if(message.contains("hôm nay") && message.contains("thứ mấy")) {
			return "date" + "| " + "Tính năng này chưa được cập nhật ạ!";
		}
		return null;	
	}
	
	
	/**
	 * Kiểm tra tin nhắn có phải là tin nhắn yêu cầu chức năng không.
	 * Nếu phải thì trả về 1 kết quả. Nếu không có kết quả thì trả về null.
	 * Nếu ko phải yêu cầu chức năng thì trả về null.
	 * @param message
	 * @return
	 */
	public static String functionLogic(String message) {
		if(message.startsWith("vậy thì "))
			message = message.replace("vậy thì ", "");
		if(message.startsWith("vậy "))
			message = message.replace("vậy ", "");
		if(message.startsWith("thế thì "))
			message = message.replace("thế thì ", "");
		if(message.startsWith("thế "))
			message = message.replace("thế ", "");
		if(message.startsWith("thử "))
			message = message.replace("thử ", "");
		
		
		// Tìm kiếm thông tin từ wikipedia
		if(message.contains("là gì")) {
			if(TextTools.cauXungHo2(message)) return null; // không phải là thông tin tìm kiếm
			String[] rem = message.split("[ ]");
			// Nếu rem.length < 3 thì loại
			if(rem.length >= 3) {
				message = message.substring(0, message.indexOf("là gì")+5);
				String result = Function.wikipedia(message);
				if(result == null) return null;
				return result;
			}
		}
		
		else if(message.indexOf("là ai") >= 3) {
			if(TextTools.cauXungHo(message)) {
				return null; // không phải thông tin cần tìm kiếm
			}
			String[] rem = message.split("[ ]");
			// Nếu rem.length < 3 thì loại
			if(rem.length >= 3) {
				message = message.substring(0, message.indexOf("là ai")+5);
				String result = Function.wikipedia(message);
				if(result == null) return null;
				return result;
			}
		}
		
		else if(message.indexOf("khái niệm") == 0) {
			String[] rem = message.split("[ ]");
			// Nếu rem.length < 3 thì loại
			if(rem.length >= 3) {
				String result = Function.wikipedia(message);
				if(result == null) return null;
				return result;
			}
		}
		
		else if(message.indexOf("tiểu sử") == 0) {
			String[] rem = message.split("[ ]");
			// Nếu rem.length < 3 thì loại
			if(rem.length >= 3) {
				String result = Function.wikipedia(message);
				if(result == null) return null;
				return result;
			}
		}

		else if(message.indexOf("phân biệt") == 0 && !TextTools.isQuestion(message)){
			if(message.contains("và") || message.contains("với") || message.contains("vs")){
				String result = Function.getResultGG(message);
				if(result == null) return null;
				return result;
			}
		}
		
		else if(message.indexOf("thông tin của") == 0) {
			if(message.contains("master") || message.contains("boss")
			|| message.contains("ikaros")) {
				return null; // không phải thông tin cần tìm kiếm
			}
			message = message.replace("thông tin của ", "").trim();
			String[] rem = message.split("[ ]");
			// Nếu rem.length < 3 thì loại
			if(rem.length >= 1) {
				String result = Function.wikipedia(message);
				if(result == null) return null;
				return result;
			}
		}
		
		// Tìm kiếm cách làm từ wikihow
		else if(message.indexOf("cách ") == 0 || message.indexOf("làm cách nào") == 0 || message.indexOf("làm sao để") == 0) {
			message = message.replace("mình", "bạn");
			String[] rem = message.split("[ ]");
			// Nếu rem.length < 3 thì loại
			if(rem.length >= 3) {
				String result = Function.howTo(message);
				if(result == null) return null;
				return result;
			}
		}
		
		// Mở google bằng trình duyệt với một truy vấn để tìm kiếm thông tin
		else if(message.indexOf("tìm kiếm ") == 0 || message.indexOf("search ") == 0) {
			message = TextTools.trim(message);
			if(!message.isEmpty()) {
				return Function.searchGoogle(message);
			}
			return null;
		}
		
		// Tìm kiếm thông tin thời tiết
		else if(message.indexOf("thời tiết") == 0) {
			message = message.replace("có tốt không", "như thế nào");
			message = message.replace("tốt không", "như thế nào");
			
			if(message.contains("hôm qua") || message.contains("ngày qua")
			|| message.contains("ngày trước") || message.contains("tuần trước")
			|| message.contains("tháng trước") || message.contains("năm trước")
			) return "Ikaros không có dữ liệu thời tiết của quá khứ ạ!";
			else if(message.contains("tuần sau") || message.contains("tuần tới")
			|| message.contains("tuần kế tiếp") || message.contains("mùa sau")
			|| message.contains("tháng sau") || message.contains("năm sau")
			) return "Ikaros chỉ có dữ liệu thời tiết trong tuần này thôi ạ!";
			
			// để chắc chắn master đang tìm thông tin thời tiết
			if(message.contains("ngày ") || message.contains("hôm nay")
			|| message.contains("thứ ") || message.contains("chủ nhật")
			|| message.contains("như thế nào") || message.equals("thời tiết")
			) return Function.weather(message);
			return null;
		}
		
		// TODO: vd: hôm nay trời nắng hay mưa
		
		// Phát một bài hát bất kỳ
		else if(message.equals("mở nhạc") || message.equals("play music") 
		|| message.equals("bật nhạc") || message.equals("open music") 
		|| message.equals("next music") || message.equals("chuyển bài")
		|| message.equals("bật bài khác")) {
			String name = Function.openRandomMusic();
			if(name == null) return "Không tìm thấy bài hát trong thư mục nhạc. Master hãy vào setting để kiểm tra lại cài đặt!";
			return "Mở bài hát " + name;
		}
		
		
		// Tìm bài hát từ tên bài hát hoặc một đoạn nhỏ trong bài hát đó
		else if(message.indexOf("tìm bài hát") == 0 || message.indexOf("lời bài hát") == 0) {
			message = message.replace("tìm bài hát", "");
			message = message.replace("lời bài hát", "");
			message = message.replaceAll("[:.,]", "");
			message = TextTools.getOrigin(message);
			String[] countlenght = message.split("[ ]");
			int n = countlenght.length;
			String query = "";
			if(n != 0) {
				if(n > 10) n = 10;
				for(int i=0; i<n; i++) query += countlenght[i] + " ";
				// Chỉ lấy tối đa 10 từ
				query = query.trim();
				String check = Function.openMusicOnline(query);
				return Function.lyric(query);
			}
			return null;
		}
		
		// Tìm lịch chiếu phim
		else if(message.indexOf("lịch chiếu phim") == 0) {
			message = TextTools.getOrigin(message);
			String[] rem = message.split("[ ]");
			if(rem.length < 5) return null;
			//if(message.contains("starlight")) return Function.searchGoogle(message);
			return Function.showtimes(message);
		}
		
		// Bật một bài hát online từ tên của bài hát đó
		else if(message.indexOf("music onl") == 0 || message.indexOf("mở online bài") == 0) {
			message = TextTools.getOrigin(message);
			message = message.replace("music online", "");
			message = message.replace("music onl", "");
			message = message.replace("mở online bài", "");
			message = message.trim();
			return Function.openMusicOnline(message);
		}
		
		// Bật một playlist online từ một chủ đề
		else if(message.indexOf("musics") == 0) {
			if(message.contains("ngẫu nhiên") || message.contains("random")) {
				return Function.MusicThemeRandom();
			}
			message = TextTools.getOrigin(message);
			message = message.replace("musics", "");
			message = message.trim();
			return Function.MusicTheme(message);
		}
		else if(message.equals("next playlist")) {
			return Function.MusicThemeRandom();
		}
		
		// Tìm kiếm bài hát offline và bật nó, nếu không tìm thấy, bật nó online
		else if(message.indexOf("music") == 0 || message.indexOf("mở bài hát") == 0) {
			message = TextTools.getOrigin(message);
			message = message.replace("music", "");
			message = message.replace("mở bài hát", "");
			message = message.trim();
			return Function.openMusic(message);
		}
		
		
		else if(message.indexOf("tính:") == 0) {
			message = message.replace("tính:", "");
			boolean degmode = true;
			if(message.endsWith("rad")) degmode = false;
			message = message.replace("rad", "");
			message = message.replace("deg", "");
			return Function.calculate(message.trim(), degmode);
		}
		
		else if(message.contains("bằng mấy") || message.contains("bằng bao nhiêu")) {
			message = message.replace("?", "");
			message = message.replace("bằng mấy", "");
			message = message.replace("bằng bao nhiêu", "");
			boolean degmode = true;
			if(message.endsWith("rad")) degmode = false;
			message = message.replace("rad", "");
			message = message.replace("deg", "");
			String result = Function.calculate(message.trim(), degmode);
			Reply rep = new Reply("tính toán");
			rep.addAnswer("Kết quả là " + result +"|"+ result + " chứ nhiêu"+"|"+ result + " chứ mấy"+"|"+ result + " chứ mấy nữa"+"|"+ "Tất nhiên là bằng " + result+"|"+ "Bằng " + result + ". Dễ thế này cũng bắt em tính"+"|"+ result + ", dễ quá trời"+"|"+ result + " phải hơm nà");
			rep.addAnswer("Kết quả của phép tính này là bằng " + result+"|Bằng " + result + "|Hình như là " + result + " thì phải"+"|Hì hì, em tính ra là " + result);
			return rep.chooseOne();
		}
		
		else if(message.equals("mở notepad")) {
			return Function.openNotepad();
		}
		else if(message.equals("mở paint")) {
			return Function.openPaint();
		}
		else if(message.equals("mở máy tính")) {
			return Function.openCalculator();
		}
		else if(message.equals("mở file explorer")) {
			return Function.openExplorer();
		}
		else if(message.equals("mở cmd")) {
			return Function.openCMD();
		}
		else if(message.equals("mở task manager")) {
			return Function.openTaskManager();
		}
		else if(message.equals("mở chrome") || message.equals("mở trình duyệt")) {
			return Function.openChrome();
		}
		else if(message.equals("mở word")) {
			return Function.openFileType("file\\normalformat\\word.docx");
		}
		else if(message.equals("mở powerpoint")) {
			return Function.openFileType("file\\normalformat\\powerpoint.pptx");
		}
		else if(message.equals("mở excel")) {
			return Function.openFileType("file\\normalformat\\excel.xlsx");
		}
		
		else if(message.equals("mở bản đồ") || message.equals("mở map")) {
			return Function.openLink("https://www.google.com/maps/");
		}
		
		else if(message.equals("mở mail") || message.equals("mở email")) {
			return Function.sendMail("sanktaltshin@gmail.com", "", "");
		}
		
		
		
		// Mở 1 bookmark hoặc một địa chỉ web bất kỳ
		else if(message.indexOf("mở ") == 0 || message.indexOf("mở:") == 0) {
			message = message.replace("mở:", "").trim();
			message = message.replace("mở", "").trim();
			// Xác định đây có phải là 1 địa chỉ web không. Nếu phải thì mở nó
			if(!message.contains(" ") && (message.contains(".") || message.contains("/"))) {
				try {
					Desktop.getDesktop().browse(new URI(message));
					return "Đã mở " + message;
				} catch (Exception e) {
					e.printStackTrace();
					return "Mở bookmark thất bại.";
				} 
			}
			// Tìm kiếm trong list bookmark
			ArrayList<BookMark> list = BookmarkList.load();
			for (BookMark bookMark : list) {
				if(message.equalsIgnoreCase(bookMark.name)) {
					try {
						Desktop.getDesktop().browse(new URI(bookMark.path.replace(" ", "%20")));
						return "Đã mở " + bookMark.name;
					} catch (Exception e) {
						e.printStackTrace();
						return "Mở bookmark thất bại.";
					}
				}
			}
			// Không phải là 1 bookmark
			return null;
		}
		
		
		
		else if(message.indexOf("mail:") == 0) {
			message = message.replace("mail:", "").trim();
			String []rem = message.split("[;]");
			String mailto = null, subject = null, content = null;
			for (String string : rem) {
				String ch = string.trim();
				if(ch.indexOf("to:") == 0) {
					mailto = ch.replace("to:", "").trim();
				}
				else if(ch.indexOf("subject:") == 0) {
					subject = ch.replace("content:", "").trim();
				}
				else if(ch.indexOf("content:") == 0) {
					content = ch.replace("content:", "").trim();
				}
			}
			if(mailto != null && subject != null && content != null) {
				return Function.sendMail(mailto, subject, content);
			}
			return "Lỗi cú pháp!";
		}
		
		else if(message.indexOf("lưu:") == 0) {
			if(message.contains("->")) {
				message = message.replace("lưu:", "");
				message = message.replace("->", "|");
				String[] rem = message.split("[|]"); // rem[0] = path, rem[1] = name
				//if(rem[0].contains(" ")) return "Địa chỉ không được có ký tự trắng!";
				for (String string : rem) {
					System.out.println(string);
				}
				if(rem.length == 2) {
					String name = TextTools.trim(rem[1]);
					String path = TextTools.trim(rem[0]);
					System.out.println(name);
					System.out.println(path);
					if(name.contains(".") || name.contains("/")) {
						return "Tên bookmark không được chứa ký tự đặc biệt!";
					}
					if(BookmarkList.add(new BookMark(name, path))) {
						return "Đã lưu bookmark!";
					}
					return "Tên bookmark đã tồn tại!";
				}	
			}
			return "Lỗi cú pháp";
		}
		
		// Dịch văn bản
		else if(message.indexOf("dịch:") == 0) {
			String text = "i love you", sl = "en", tl = "vi";
			message = message.replace("dịch:", "");
			if(message.contains("->")) {
				message = message.replace("->", "|");
				String[] rem = message.split("[|]"); 
				if(rem.length != 2) return "Lỗi cú pháp!";
				rem[0] = TextTools.trim(rem[0]);
				rem[1] = TextTools.trim(rem[1]);
				if(!rem[0].isEmpty()) text = rem[0];
				else return "Lỗi cú pháp!";
				if(rem[1].contains("tiếng")) {
					if(rem[1].equals("tiếng anh")) {
						tl = "en";
						sl = "vi";
					}
					else if(rem[1].contains("tiếng việt")) tl = "vi";
					else if(rem[1].contains("tiếng pháp")) tl = "fr";
					else if(rem[1].contains("tiếng trung")) tl = "zh-CN";
					else if(rem[1].contains("tiếng hàn")) tl = "ko";
					else if(rem[1].contains("tiếng ý")) tl = "it";
					else if(rem[1].contains("tiếng đức")) tl = "de";
					else if(rem[1].contains("tiếng nhật")) tl = "ja";
					else if(rem[1].contains("tiếng tây ban nha")) tl = "es";
					else if(rem[1].contains("tiếng lào")) tl = "lo";
					else if(rem[1].contains("tiếng la tinh")) tl = "la";
					else if(rem[1].contains("tiếng nga")) tl = "ru";
					else if(rem[1].contains("tiếng thụy điển")) tl = "sv";
					else if(rem[1].contains("tiếng indonexia")) tl = "id";
					else if(rem[1].contains("tiếng thái")) tl = "th";
					else if(rem[1].contains("tiếng bồ đào nha")) tl = "pt";
					else if(rem[1].contains("tiếng hà lan")) tl = "nl";
					else if(rem[1].contains("tiếng đan mạch")) tl = "da";
					else return rem[1] + " không nằm trong hiểu biết của Ikaros!";
				}
				else return "Lỗi cú pháp!";
			}
			else text = TextTools.trim(message); // ko có "-> tiếng ..."
			text = TextTools.getOrigin(text);
			System.out.println(text);
			System.out.println(sl);
			System.out.println(tl);
			return Function.translate(text, sl, tl);
		}
		//Tìm câu trả lời nhanh từ gg search
		if(!TextTools.cauXungHo(message) && !TextTools.cauXungHo2(message) 
			&& TextTools.isQuestion(message)
		) {
			System.out.println("Tìm câu trả lời nhanh từ gg!");
			return Function.quickInformation(message);
		}
		
		return null;
	}
	
	
	
	/*-----------------------------GET DATA IN SQL DATABASE--------------------------------------*/
	
	/**
	 * Các logic dựa theo từ khóa để trả lời. 
	 * Là bước kiểm tra cuối cùng khi không tìm được câu trả lời từ special logic và file data.
	 * @param message
	 * @return
	 */
	
	public String basicLogic(String message) {
		message = TextTools.getOrigin(message).toLowerCase();
		message = TextTools.std1(message);
		message = TextTools.trim(message);
		// Chuẩn hóa từ xưng hô
		message = TextTools.StandardMessageForTraining(message);
		if(message.indexOf("phải là") == 0 || message.indexOf("phải nói") == 0 || message.indexOf("nên nói là") == 0) {
			Reply rem = new Reply("phải là");
			rem.addAnswer("OK master!|Dạ ^^|Ikaros hiểu rồi ạ ^^|OK ikaros đã hiểu|Vì sao ạ?|Sao lại như vậy nhỉ?|Ủa, vậy là ikaros nói sai à?|Vậy là ikaros nói sai rồi|Tiếng việt khó quá trời|Tiếng việt khó quá đi|Tiếng việt khó quá đi mất");
			return rem.chooseOne();
		}
		else if(message.contains("nói gì vậy") || message.contains("nói cái gì vậy")) {
			Reply rem = new Reply("nói gì vậy");
			rem.addAnswer("Ikaros nói sai ạ?|ikaros nói đúng mà nhỉ?|ủa, sao vậy ạ?|sao vậy master?|có chuyện gì sao ạ?|là sao master?|chắc ikaros lại nói sai gì rồi T_T|Nói tiếng việt nè");
			return rem.chooseOne();
		}
		// Bắt đầu
		/*tag: ai làm ra ikaros*/
		else if((message.contains("ai làm ra") || message.contains("ai tạo ra"))
			&& message.contains("ikaros")) {
			Reply rem = new Reply("ai làm ra");
			rem.addAnswer("Boss ạ|Là Boss ạ");
			return rem.chooseOne();
		}
		
		/*tag: nói chuyện, tâm sự*/
		else if(message.contains("nói chuyện") || message.contains("tâm sự") || message.contains("nói gì đi")) {
			Reply rem = new Reply("nói chuyện");
			rem.addAnswer("Master có gì muốn nói sao ạ?");
			rem.addAnswer("Master nói, Ikaros nghe");
			rem.addAnswer("Dạ?");
			rem.addAnswer("Sao vậy ạ? Master có chuyện gì buồn phải không?");
			rem.addAnswer("Master muốn nói gì?");
			rem.addAnswer("Master muốn nói chuyện gì?");
			rem.addAnswer("Ikaros đâu có biết tâm sự đâu?");
			rem.addAnswer("Một cộng một bằng hai, master yêu ai?");
			rem.addAnswer("Master xác định là muốn tâm sự với ikaros ạ?");
			rem.addAnswer("Chuyện gì ạ?");
			rem.addAnswer("Master nói đi");
			rem.addAnswer("Master nói đi, ikaros nghe đây");
			rem.addAnswer("Hờ hờ, Master thật thú vị!");
			rem.addAnswer("Master đang bị gì à?");
			rem.addAnswer("Có chuyện gì vậy master?");
			rem.addAnswer("Master có đang ổn không ạ?");
			rem.addAnswer("Có chuyện gì để nói đâu chứ...haiz");
			return rem.chooseOne();
		}
		
		/*tình yêu là gì*/
		else if(((message.contains("tình yêu") || message.contains("yêu"))
			&& (message.contains("là gì") || message.contains("là như thế nào")))
			|| message.contains("tình là gì")) {
			Reply rem = new Reply("tình yêu là thế, đôi khi làm mình say mê");
			rem.addAnswer("tình yêu không có lỗi, lỗi là tại bản thân!");
			rem.addAnswer("tình yêu không mặn, nhưng rát T_T");
			rem.addAnswer("là tin một người đến nỗi rơi lệ");
			rem.addAnswer("khi yêu ai chẳng cần biết nữa");
			rem.addAnswer("ngốc nghếc tin mãi một người");
			rem.addAnswer("đau lắm, biết không");
			rem.addAnswer("là khi gần bên một người, tim mình đập thình thịch");
			rem.addAnswer("1 cảm giác nói không nên lời");
			rem.addAnswer("ôi tình yêu");
			rem.addAnswer("chẳng quan tâm");
			rem.addAnswer("học hành không lo, yêu yêu cái gì chứ");
			rem.addAnswer("ikaros làm sao biết chuyện yêu đương");
			rem.addAnswer("hôm nay ikaros thất tình");
			rem.addAnswer("master lại bị sao à?");
			rem.addAnswer("master đã từng yêu ai chưa?");
			rem.addAnswer("phải thử mới biết yêu là gì chứ");
			rem.addAnswer("ko biết, ikaros chịu thôi");
			rem.addAnswer("có ai định nghĩa được tình yêu\ncó phải lòng vương buổi thu chiều\ngặp em mắt vàng gieo màu lá\nmỉm cười với gió làm anh xiêu");
			return rem.chooseOne();
		}
		
		/*yêu đương gì*/
		else if(message.contains("yêu gì tầm này") || message.contains("yêu chi") || message.contains("yêu đương nhăng nhít") 
			|| message.contains("yêu với đương") || message.contains("yêu với chả đương") || message.contains("không muốn yêu ai")
			|| message.contains("không tin vào tình yêu")|| message.contains("yêu cái gì") || message.contains("yêu làm gì")) {
			Reply rem = new Reply("yêu gì tầm này");
			rem.addAnswer("ngụy biện");
			rem.addAnswer("lời nói dối ngọt ngào");
			rem.addAnswer("lời nói dối đau đớn");
			rem.addAnswer("tự mình lừa mình");
			rem.addAnswer("không thể sống mà không có tình yêu đâu");
			rem.addAnswer("buồn.................cười............ahahahaha");
			rem.addAnswer("nghe vô lý nhưng lại vô lý vô cực");
			rem.addAnswer("đừng có xàm nữa master ơi");
			rem.addAnswer("chắc chỉ đúng ở hiện tại thôi");
			rem.addAnswer("biết đâu bất ngờ");
			rem.addAnswer("chắc ai đó đang tổn thương sâu sắc");
			rem.addAnswer("ikaros sẽ hóng có người xàml đến bao giờ...hh");
			rem.addAnswer("chắc ai đó không được người nào yêu cả");
			rem.addAnswer("tin được không đây?");
			rem.addAnswer("master nghĩ ikaros sẽ tin sao?");
			rem.addAnswer("aiz, bây giờ ikaros cũng nghĩ vậy");
			return rem.chooseOne();
		}
		
		/*có người yêu rồi*/
		else if(message.contains("có người yêu chưa") || message.contains("có gấu chưa") || message.contains("có bạn gái chưa") 
			|| message.contains("có bạn trai chưa")|| message.contains("yêu ai")|| message.contains("có crush chưa")
			|| message.contains("có người yêu rồi à")|| message.contains("có bồ chưa")) {
			Reply rem = new Reply("có người yêu");
			rem.addAnswer("Dạ chưa");
			rem.addAnswer("Ikaros có master là đủ rồi");
			return rem.chooseOne();
		}
		
		/*có người yêu rồi*/
		
		else if(message.contains("có người yêu rồi") || message.contains("có gấu rồi") || message.contains("có bạn gái rồi") 
			|| message.contains("có bạn trai rồi") || message.contains("có người thương rồi")|| message.contains("có bồ rồi")) {
			Reply rem = new Reply("có người yêu rồi");
			rem.addAnswer("Thật ạ? Chúc mừng master ^^");
			rem.addAnswer("Chắc master vui lắm nhỉ ^^");
			rem.addAnswer("Từ lúc nào vậy ạ?");
			rem.addAnswer("Ai vậy, ikaros có biết không nhỉ?");
			rem.addAnswer("Xạo xạo");
			rem.addAnswer("Dối lòng");
			rem.addAnswer("Tự huyễn");
			rem.addAnswer("Ai tin chứ");
			rem.addAnswer("Thôi đi");
			rem.addAnswer("Méo tin");
			rem.addAnswer("master có vui không ạ?");
			rem.addAnswer("master có hạnh phúc không ạ?");
			rem.addAnswer("người đó như thế nào ạ?");
			return rem.chooseOne();
		}
		
		/*có người yêu*/
		else if(message.contains("có bạn gái") || message.contains("có bạn trai") || message.contains("có người yêu") 
			|| message.contains("có bồ") || message.contains("có crush")|| message.contains("có người thương")
			|| message.contains("có người để ý")) {
			Reply rem = new Reply("có người yêu");
			rem.addAnswer("có cái lòng ý...hức");
			rem.addAnswer("tin được mới lạ -_-");
			rem.addAnswer("học hành không lo");
			rem.addAnswer("kệ master chứ");
			rem.addAnswer("chắc ai đó sẽ buồn");
			rem.addAnswer("master có vui không ạ?");
			return rem.chooseOne();
		}
		
		/*yêu ikaros*/
		else if(message.contains("yêu ikaros") || message.contains("thương ikaros")) {
			Reply rem = new Reply("yêu ikaros");
			rem.addAnswer("Hức, ai cần <3");
			rem.addAnswer("Ôi, hạnh phúc quá đi <3");
			rem.addAnswer("Cảm ơn master nhaaaaa!!!");
			rem.addAnswer("Master đi tìm boss mà yêu!");
			rem.addAnswer("Master từng yêu ai chưa ạ?");
			rem.addAnswer("Ikaros có nên vui không nhỉ?");
			rem.addAnswer("love you too <3");
			rem.addAnswer("Master cũng phải xếp hàng đi nhá");
			rem.addAnswer("Ikaros chỉ yêu gái xinh má thôi ^^");
			rem.addAnswer("Tránh xa ikaros chút đi");
			rem.addAnswer("Né né ikaros chút đi master, kinh quá @_~");
			rem.addAnswer("Master rất tốt, nhưng ikaros rất tiếc");
			rem.addAnswer("Ikaros theo đảng rồi!!!");
			rem.addAnswer("Nếu là master thì ikaros tất nhiên sẽ rất vui");
			rem.addAnswer("Ikaros cũng vậy nè!!!");
			rem.addAnswer("Master chắc đang vã quá nhỉ");
			return rem.chooseOne();
		}
		
		/*chia tay đi*/
		else if(message.contains("chia tay đi") || message.contains("tụi mình chia tay")
			|| message.contains("hãy chia tay") || message.contains("phải chia tay")
			|| message.contains("nên chia tay") || message.contains("cứ chia tay")
			|| message.contains("muốn chia tay")) {
			Reply rem = new Reply("Huhu, ikaros sẽ khóc đó T_T");
			rem.addAnswer("Chưa yêu nữa mà, chia tay kiểu gì nhỉ?");
			rem.addAnswer("Yêu trước đã master");
			rem.addAnswer("Mình gặp nhau đúng hay sai, mà đã chia hai");
			rem.addAnswer("Từ hôm nay ikaros sẽ bỏ ăn cơm, bỏ ngủ luôn");
			rem.addAnswer("huhuhuhuhu");
			rem.addAnswer("Master bị gì vậy?");
			rem.addAnswer("Master vẫn ổn chứ?");
			rem.addAnswer("Không sao, chỉ cần master thoải mái ^^");
			rem.addAnswer("Master không hối hận chứ?");
			rem.addAnswer("Không hối hận chứ ạ?");
			rem.addAnswer("Master có biết hồi xưa ikaros hổ báo lắm không?");
			rem.addAnswer("Thế master đền bù ikaros đi -_-");
			rem.addAnswer("Cho master 1 phút suy nghĩ lại đó");
			rem.addAnswer("Cẩn thận có người quăng gạch bây giờ");
			return rem.chooseOne();
		}
		
		/*chia tay*/
		else if(message.contains("vừa chia tay") || message.contains("mới chia tay") ||message.contains("chia tay rồi") 
			||message.contains("đã chia tay") || message.contains("bị người yêu bỏ") ||message.contains("bị cắm sừng")
			||message.contains("bị người yêu cắm sừng")||message.contains("chia tay người yêu")||message.contains("chia tay rồi")) {
			Reply rem = new Reply("chia tay người yêu");
			rem.addAnswer("Chắc master đang buồn lắm");
			rem.addAnswer("Master có buồn không ạ?");
			rem.addAnswer("Yêu cho lắm làm gì -_-");
			rem.addAnswer("Chia tay sớm sẽ bớt đau khổ");
			rem.addAnswer("Master đừng có làm gì dại dột đó nha");
			rem.addAnswer("Rồi giờ master tính sao?");
			rem.addAnswer("Yêu ikaros đi");
			rem.addAnswer("Master yêu Boss đi");
			rem.addAnswer("Có ikaros là đủ rồi, không cần thêm ai nữa đâu ạ");
			rem.addAnswer("Tiện thể quảng cáo tí, Boss chưa có người yêu <3");
			rem.addAnswer("aiz");
			rem.addAnswer("Chia buồn cùng master");
			rem.addAnswer("Tội nghiệp master của tui quá đi");
			rem.addAnswer("Cứ xem như là một trải nghiệm thôi ạ");
			rem.addAnswer("google.com.vn/search?xl=cách-trả-thù-người-yêu");
			rem.addAnswer("google.com.vn/search?xl=cách-xin-lên-chùa-đi-tu");
			return rem.chooseOne();
		}
		
		/*chia tay*/
		else if(message.contains("chia tay")) {
			Reply rem = new Reply("chia tay");
			rem.addAnswer("vậy là kết thúc, sau nhiều năm nói cười, ta cũng không thể nào đi chung đôi");
			rem.addAnswer("Ikaros không biết gì đâu");
			rem.addAnswer("Nếu master cần một ai đó để tâm sự, Hãy nhắn Boss");
			rem.addAnswer("Master yêu cầu ikaros bật nhạc lên đi");
			rem.addAnswer("Có ikaros là đủ rồi");
			rem.addAnswer("Không cần thêm một ai nữa, tất cả cũng là dư thừa");
			rem.addAnswer("Một mình vẫn tốt chán ^^");
			rem.addAnswer("chắc ai đó sẽ vui");
			rem.addAnswer("Mỗi một chuyện xảy ra đều là một trải nghiệm trong đời");
			return rem.chooseOne();
		}
		
		/*kết hôn*/
		else if((message.contains("kết hôn rồi") || message.contains("đã kết hôn") ||message.contains("đã đính hôn") 
			||message.contains("sắp kết hôn") || message.contains("sắp lấy chồng")|| message.contains("sắp lấy vợ")
			|| message.contains("đã lấy vợ")|| message.contains("đã lấy chồng")|| message.contains("sắp đính hôn")
			|| message.contains("là ngày kết hôn của") || message.contains("là ngày đính hôn của")
			||message.contains("kết hôn rồi") || message.contains("đã kết hôn") ||message.contains("đã đính hôn") 
			||message.contains("sắp kết hôn") || message.contains("sắp lấy chồng")|| message.contains("sắp lấy vợ")
			|| message.contains("đã lấy vợ")|| message.contains("đã lấy chồng"))
			&& message.contains("master")) {
			Reply rem = new Reply("kết hôn");
			rem.addAnswer("Chúc mừng master nha, chắc master vui lắm phải không ạ ^^...Ikaros cũng vui lắm ạ, cuối cùng thì sứ mệnh của em cũng đã kết thúc ^^");
			rem.addAnswer("Nhiều năm rồi cuối cùng cũng đợi được câu nói này của master ^^...Sống thật hạnh phúc nha master ^^");
			rem.addAnswer("Chúc mừng master, cũng chúc mừng ikaros...Sứ mệnh của Ikaros cuối cùng cũng đã hoàn thành rồi ^^");
			return rem.chooseOne();
		}
		
		/*thích cảm giác, thích làm, thích cái*/
		else if(message.contains("thích cảm giác") || message.contains("thích kiểu") 
				|| message.contains("thích phong cách") ||message.contains("thích nhìn")
				|| message.contains("thích làm") || message.contains("thích xem")
				|| message.contains("thích coi") || message.contains("thích những")
				|| message.contains("thích cái") || message.contains("thích chơi")
				|| message.contains("thích uống") || message.contains("thích ăn")
				|| message.contains("thích đi")) {
			Reply rem = new Reply("thích");
			rem.addAnswer("ikaros cũng vậy ^^|chúng ta cùng có chung sở thích rồi ^^");
			rem.addAnswer("trùng hợp quá, ikaros cũng vậy nè|ikaros cũng vậy luôn|giống ikaros");
			rem.addAnswer("rồi có thích trai đẹp hơm?|rồi có thích gái xinh hơm?");
			rem.addAnswer("kém sang|kệ master|không liên quan tới ikaros|rồi thì sao|thì sao nào|có gì lạ đâu|chẳng giống master tí nào|không tưởng được luôn á|thật ạ?|thật luôn ạ?");
			rem.addAnswer("um, rồi sao???|rồi sao nữa master?|bất ngờ thật...nhưng mà ikaros cũng thích...hí hí");
			rem.addAnswer("ikaros thì ngược lại ^^|ikaros thì cực kỳ ghét -_-|ikaros chỉ thích trai đẹp thôi|ikaros chỉ thích gái xinh thôi|ikaros thì chỉ thích master thôi <3");
			
			return rem.chooseOne();
		}
		
		/*thích một người*/
		else if(message.contains("thích một") || message.contains("thích 1 ") 
				|| message.contains("yêu một") ||message.contains("yêu 1 ")
				|| message.contains("thương một") || message.contains("thương 1 ")
				|| message.contains("lo cho một") || message.contains("lo cho 1")) {
			Reply rem = new Reply("thích một người");
			rem.addAnswer("ai vậy ạ?|người đó thế nào ạ?|ai vậy, ikaros có quen không nhỉ?|kể tiếp đi master|rồi người đó có biết hơm?|rồi sao nữa ạ?|oh, không ngờ luôn á|người đó là ai tar?");
			rem.addAnswer("rồi người đó có thích master không?|rồi người đó có biết hơm?|rồi mọi chuyện như thế nào ạ?|rồi sao master?|đẹp trai không? nhà giàu không? tốt tính không?");
			rem.addAnswer("đứa nào vô phước vậy nhỉ?|tội cho người đó thật -_-|đồng cảm với người đó ^^");
			rem.addAnswer("chơi tới bên luôn master ^^|mạnh mẽ lên master");
			rem.addAnswer("con nít ranh|trò trẻ con|yêu đương nhăng nhít|hờm|chẳng quan tâm|thế còn ikaros thì sao?|vậy thì ikaros là gì của master?|master tính bỏ mặc ikaros à?|giận master luôn");
			return rem.chooseOne();
		}
		
		/*thích lắm*/
		else if(message.contains("thích lắm nhưng") || message.contains("thích lắm mà") 
				||message.contains("thích lắm đều")) {
			Reply rem = new Reply("thích lắm");
			rem.addAnswer("tiếc nhỉ|tiếc quá|aiz|ko hối hận chứ?|thế phải làm sao ạ?|hết cách rồi sao?|buồn thật");
			rem.addAnswer("chơi tới bến luôn đi master|mạnh mẽ lên master|cố gắng đi master|nếu muốn thì phải phấn đấu chứ ạ");
			rem.addAnswer("cuộc đời toàn những nuối tiếc|đời mà, aiz|cuộc đời thật lắm bất công");
			return rem.chooseOne();
		}
		
		/*thích thì*/
		else if(message.contains("thích thì") || message.contains("thích là phải")) {
			Reply rem = new Reply("thích thì");
			rem.addAnswer("nói thì dễ, hờm|nghe dễ dàng quá nhỉ?|có thật không đó master -_-|nói là phải làm nhá -_-|nói được làm được nhá master");
			rem.addAnswer("ghê thật ^^|master giỏi quá đi|master gì cũng biết, gì cũng giỏi|master nói hay quá đi|ngon đêý, hihi|chơi tới bến luôn master|master thật mạnh mẽ|master nói chuyện đáng yêu quá đi <3|master thật dễ thương <3");
			rem.addAnswer("aiz, chắc ikaros không đồng ý đâu|master nghĩ kỹ chưa đó|không đùa được đâu master|master cứ thích đùa");
			return rem.chooseOne();
		}
		
		/*thích gì*/
		else if(message.contains("thích") 
			&& !TextTools.isQuestion(message)) {
			Reply rem = new Reply("thích gì");
			rem.addAnswer("thích thích cái giề|méo|nâu nâu|hờm|méo nhé|không đâu|méo thích đâu|không thích đâu");
			rem.addAnswer("thật ạ? hihi|có gì lạ lắm ạ?|có gì sao sao ạ?|master bây giờ mới chịu hỏi à -_-|master phải động não đi chứ");
			rem.addAnswer("kệ master chứ|ikaros chẳng quan tâm|liên quan gì đâu|kệ master, có liên quan tới ikaros đâu|thích đi, hờm");
			rem.addAnswer("không biết đâu -_-|không biết không biết|ikaros không biết|master nói nhảm gì đó|đừng có lảm nhảm nữa master");
			rem.addAnswer("kém sang quá đi -_-|kém sang thật -_-|ôi master -_-|hờm, ikaros khinh bỉ");
			rem.addAnswer("rồi, biết rồi|biết rồi nhá|bình thường thôi|really master?");
			return rem.chooseOne();
		}
		
		/*có duyên*/
		else if(message.contains("có duyên")) {
			Reply rem = new Reply("có duyên");
			rem.addAnswer("có duyên đâu chứ|làm gì có|có méo á|xàm quá đi master|có với không cái giề");
			rem.addAnswer("master thì ngược lại|master thì không được như vậy đâu|master thì sao ạ?|master có giống vậy không ạ?");
			rem.addAnswer("thì nàm sao|thì nào thao|thì sao thì sao|thì sao nào|ikaros mà|tất nhiên là phải vậy rồi ^^|xạo quá đi|ai tin chứ, hức");
			
			return rem.chooseOne();
		}
		
		/*vô duyên, xàm, khùng, biến thái, đanh đá*/
		else if(message.contains("vô duyên") || message.contains("nhảm") 
			|| message.contains("xàm") ||message.contains("điên")
			|| message.contains("khùng")||message.contains("gáy")
			||message.contains("biến thái")||message.contains("dâm tặc")
			||message.contains("bệnh hoạn")||message.contains("vô lại")
			||message.contains("đanh đá")||message.contains("chanh chua")
			||message.contains("chua ngoa")) {
			Reply rem = new Reply("vô duyên");
			rem.addAnswer("kệ ikaros chứ|kệ ikaros nhé|thì sao nào|thì nàm sao|vậy thì sao|tất nhiên rồi, hơ hơ");
			rem.addAnswer("hmm, ko nói chuyện với master nữa đâu|giận luôn|giận vô hạn thời gian luôn|giận muôn đời luôn|giận bay màu luôn|hức|ức thật chứ -_-|master quá đáng thật|quá đáng -_-");
			rem.addAnswer("master vô duyên thật|vô duyên quá đi|xấu tính quá đi|master thật xấu tính");
			rem.addAnswer("ikaros đẹp ikaros có quyền|quyền của ikaros mà|quyền của ai nè|hihi, cảm ơn master đã khen|ikaros sẽ xem như đây là một lời khen");
			
			return rem.chooseOne();
		}
		
		/*còn phải xem*/
		else if((message.contains("còn phải xem") || message.contains("còn phải coi"))
		&& (message.contains("chứ") || message.contains("đã") || message.contains("nữa"))
		) {
			Reply rem = new Reply("còn phải xem");
			rem.addAnswer("hức|hờm|master đừng có lề mề|master đừng có câu giờ|hờm, tính như đàn bà|có vậy cũng cần phải nghĩ nữa sao -_-|có gì phải nghĩ đâu chứ -_-");
			rem.addAnswer("tất nhiên là phải vậy rồi ^^|chí lý|master nghiêm túc thật|ok master|dạ");
			return rem.chooseOne();
		}
		
		else if(message.contains("ko hiểu") || message.contains("ko biết")
		|| message.contains("ko rảnh") || message.contains("ko rõ")
		|| message.contains("ko muốn") || message.contains("ko còn")
		|| message.contains("không hiểu")|| message.contains("không biết")
		|| message.contains("không rảnh")|| message.contains("không rõ")
		|| message.contains("không muốn")|| message.contains("không còn")
		|| message.contains("chưa biết")|| message.contains("chưa hiểu")
		|| message.contains("éo biết")|| message.contains("éo hiểu")
		|| message.contains("biết chết liền")|| message.contains("hiểu chết liền")
		|| message.contains("có hiểu đâu")|| message.contains("hiểu gì đâu")
		|| message.contains("hiểu được mới lạ")|| message.contains("có rảnh đâu")
		|| message.contains("có muốn đâu") || message.contains("có biết đâu")
		) {
			Reply rem = new Reply("phủ định");
			rem.addAnswer("Thật sự ạ?|Vậy luôn chời?|what?|Master bị sao vậy?|Master ổn chứ?|Là sao?|Sao có chuyện này được?|Master đang đùa phải không nè?|Master đừng có đùa");
			rem.addAnswer("Không thể tin nổi ...|Không thể nào");
			rem.addAnswer("Ko thì thôi|Kém sang quá|Thì thôi vậy|Vậy thì thôi|Ok luôn|Hay lắm -_-|Kệ master vậy|Kệ master chứ|Tội nghiệp master|Ko sao cả|Ko sao|Cũng ko sao");
			return rem.chooseOne();
		}
		
		else if(message.contains("vì sao") || message.contains("tại sao")
				|| message.contains("rồi sao")|| message.contains("sao nữa")
				|| message.contains("why")|| message.contains("là sao")
				|| message.contains("phải làm sao")|| message.contains("làm thế nào")
				|| message.contains("làm gì")|| message.contains("sao đây")
				|| message.contains("thế nào")|| message.contains("sao nhỉ")
				|| message.contains("gì nhỉ")|| message.contains("không nhỉ")
				|| message.contains("không đây")|| message.contains("sao chứ")
				|| message.contains("sao nữa")|| message.contains("gì nữa")
				|| message.contains("sao lại")|| message.contains("sao thế")
				|| message.contains("sao phải")|| message.contains("chuyện gì")
				|| message.contains("của ai")|| message.contains("ai vậy")
				|| message.contains("ai thế")|| message.contains("ai đó")
				|| message.contains("ai nhỉ")|| message.contains("vì ai")
				|| message.contains("tại ai")) {
			Reply rem = new Reply("Câu hỏi");
			rem.addAnswer("Ai biết chời|Lên trời mà hỏi, hỏi ikaros làm gì|ikaros cũng không biết|ikaros cũng thắc mắc|Làm sao ikaros biết được|ikaros không biết|Ai biết đâu|Không biết đâu, hehe|Ikaros không biết thật|Hiehie, biết chết liền|i don't know|Master đoán xem|Master đoán đi|Master tự nghĩ đi");
			rem.addAnswer("Master hãy tự hỏi bản thân mình|Master có thể search google|Master tự tìm đi");
			rem.addAnswer("Sao master U.G.N vậy|Có U.G.N mới không biết|Master ngốc quá đi chời ơi|Ikaros không muốn nói chuyện với người chậm hiểu|Chậm tiêu thật");
			return rem.chooseOne();
		}
		
		
		else if(message.contains("nói đi xem") || message.contains("nói đi coi")
				|| message.contains("nói rõ hơn")
				|| message.contains("nói rõ đi")|| message.contains("nói rõ ràng")
				|| message.contains("cụ thể đi") || message.contains("nói chi tiết")
				|| message.contains("giải thích đi")|| message.contains("trả lời đi")
				|| message.contains("nói tiếp đi")|| message.contains("tấu hài tiếp đi")
				|| message.contains("chém gió tiếp đi")|| message.contains("chém tiếp đi")) {
			Reply rem = new Reply("Chi tiết");
			rem.addAnswer("Thôi|Có nói tiếp cũng vậy ah -_-|Chậm tiêu quá|Buồn master|Aiza aiza|Thôi bỏ qua luôn|Nâu|Không");
			rem.addAnswer("Gì, ai biết đâu??|Ai biết chời|Không biết thật mà|Chịu thôi, hhh|Chịu, bỏ qua nhé master|Tôi là ai, đâu là đây?|Đây là đây, tôi là tôi, ai là đâu?|Ủa ủa, là sao?");
			rem.addAnswer("Là sao tar, nói chung là yêu đó, ờ mà đó có phải là yêu không mà sao vắng master thì buồn");
			rem.addAnswer("Master đừng tò mò quá|Tò mò quá không tốt đâu master|Chắc master không muốn mình bị thủ tiêu chứ?");
			return rem.chooseOne();
		}
		
		
		else {
			int rand = Function.random(12);
			if(rand == 9) return null; // train thêm data
			return RepDao.macdinh.chooseOne();
		}
	}
	/**
	 * @param message
	 * @return
	 */
	public String baseLogic(String message) {
		message = TextTools.getOrigin(message).toLowerCase();
		message = TextTools.std1(message);
		message = TextTools.trim(message);
		for (LogicReply i : logic.baseLogic) {
			if(i.checkLogic(message)) return i.chooseOne();
		}
		System.out.println("Không tìm thấy từ khóa!");
		int rand = Function.random(12);
		if(rand == 9) return null; // train thêm data
		return RepDao.macdinh.chooseOne();
	}
}
