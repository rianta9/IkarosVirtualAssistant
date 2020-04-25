package com.rianta9.ikaros.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import com.rianta9.ikaros.bean.ListData;
import com.rianta9.ikaros.bean.Reply;

public class RepDao {
	private static ArrayList<ListData> lists;
	private static ListData currentList; // Dùng để training thêm dữ liệu
	private static String currentFilename; // Dùng để training thêm dữ liệu
	public static Reply macdinh;
	
	/**
	 * Lưu dữ liệu của 1 list reply vào file.
	 */
	public static void saveMess() {
		if(currentList == null) return;
		File file = new File("file\\mess\\" + currentFilename + ".txt");
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (Exception e1) {
				System.out.println("Có lỗi khi tạo file " + currentFilename + ".txt");
				return;
			}
		}
		try {
			OutputStreamWriter writer =
	             new OutputStreamWriter(new FileOutputStream(file, false), StandardCharsets.UTF_8);
			for (Reply data : currentList.data) {
				if(data != null && !data.getBaseMessage().isEmpty()) {
					writer.write(data.toString() + "\n");
				}
			}
			writer.close();
		} catch (Exception e1) {
			System.out.println("Co loi khi luu file " + currentFilename + ".txt");
		}
	}
	
	
	/**
	 *  Add thêm 1 dòng text vào file filename.
	 * @param filename: tên file(từ "a" đến "z")
	 * @param text: Reply.ToString
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
	
	/**
	 * Load toàn bộ dữ liệu.
	 */
	public static void load() {
		lists = new ArrayList<ListData>();
		currentList = null;
		currentFilename = null;
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		for(int i=0; i<26; i++) {
			String filename = String.valueOf(alphabet.charAt(i));
			lists.add(getMess(filename));
		}
		lists.add(getMess("khac"));
		// Trả lời mặc định
		macdinh = new Reply("Trả lời mặc định.");
		macdinh.addAnswer("next đi master ^^");
		macdinh.addAnswer("méo liên quan đến ikaros");
		macdinh.addAnswer("còn chuyện gì khác không ạ?");
		macdinh.addAnswer("master còn không không đó?");
		macdinh.addAnswer("hiehie, ikaros chẳng biết nên nói gì nữa luôn");
		macdinh.addAnswer("haha, ikaros đang đọc cái gì đây nhỉ?");
		macdinh.addAnswer("là sao ạ? ikaros không hiểu?");
		macdinh.addAnswer("ikaros chẳng biết sao cả, có lẽ Boss giúp được master");
		macdinh.addAnswer("hôm qua cũng có người nói như vậy...");
		macdinh.addAnswer("cũng từng có người nói như thế này đây...");
		macdinh.addAnswer("aiz, nhìn master thấy giống một người quá");
		macdinh.addAnswer("master nói nhiều thật đây, không biết chán à -_-");
		macdinh.addAnswer("really?");
		macdinh.addAnswer("chuyển chủ đề đi master");
		macdinh.addAnswer("nhảm quá nhé");
		macdinh.addAnswer("nhảm thật sự đó");
		macdinh.addAnswer("nhảm nhí hết sức");
		macdinh.addAnswer("master vẫn muốn tiếp tục cuộc trò chuyện này chứ?");
		macdinh.addAnswer("Khoan đã, master thấy ikaros như thế nào ạ?");
		macdinh.addAnswer("Master ơi, phải tém tém lại một chút đi chứ");
		macdinh.addAnswer("Master nói chuyện dễ thương quá đi");
		macdinh.addAnswer("hahahahahahaha");
		macdinh.addAnswer("nực cười -_-");
		macdinh.addAnswer("hahahahaha, nhạt quá đó master");
		macdinh.addAnswer("master có nghĩ mình nên thêm muối vào cuộc trò chuyện không?");
		macdinh.addAnswer("muối đâu rồi nhỉ?");
		macdinh.addAnswer("ôi, có vị đường này...master ấy <3");
		macdinh.addAnswer("master nói chuyện dễ thương quá cơ");
		macdinh.addAnswer("có những chuyện không nên nói ra đâu ạ");
		macdinh.addAnswer("master đừng có nói nhảm nữa");
		macdinh.addAnswer("Khoan đã, master có muốn ikaros giới thiệu cho một người hay không ạ?");
		macdinh.addAnswer("ikaros cũng không rõ nữa");
		macdinh.addAnswer("ôi master -_-");
		macdinh.addAnswer("ôi trời master của tui -_-");
		macdinh.addAnswer("cạn lời -_-");
		macdinh.addAnswer("Hôm nay ikaros buồn tình, đừng có mà chọc tức ikaros");
		macdinh.addAnswer("bỏ qua đi master -_-");
		macdinh.addAnswer("theo kinh nghiệm của ikaros thì chuyện này chẳng ổn tí nào");
		macdinh.addAnswer("nực cười, master không đủ đẳng cấp");
		macdinh.addAnswer("hờ hờ, master thật thú vị");
		macdinh.addAnswer("master nghĩ master nói vậy thì ikaros sẽ vui sao?");
		macdinh.addAnswer("master thú vị thật đó");
		macdinh.addAnswer("master lại bị sao ạ?");
		macdinh.addAnswer("master bị gì à? kể ikaros nghe đi ạ");
		macdinh.addAnswer("um, kệ master chứ");
		macdinh.addAnswer("kệ master");
		macdinh.addAnswer("xin lỗi, ikaros chỉ là 1 con bot");
		macdinh.addAnswer("yên tâm, ikaros sẽ cho master thấy");
		macdinh.addAnswer("đoán xem???");
		macdinh.addAnswer("master đoán xem nào?");
		macdinh.addAnswer("không được nói vậy, ikaros đã nói bao nhiêu lần rồi");
		macdinh.addAnswer("master không được nói vậy đâu đấy");
		macdinh.addAnswer("ikaros khuyên master đừng có dại dột");
		macdinh.addAnswer("oài, thôi bỏ đi master");
		macdinh.addAnswer("không biết, ikaros chịu thôi");
		macdinh.addAnswer("please, stop here ok?");
		macdinh.addAnswer("Xin lỗi, mấy chuyện này ikaros không quan tâm");
		macdinh.addAnswer("Ikaros chẳng quan tâm");
		macdinh.addAnswer("Aiz, master ngốc quá đi");
		macdinh.addAnswer("Aiz, master quá ngốc");
		macdinh.addAnswer("HH, master cũng biết nhiều thật nhỉ");
		macdinh.addAnswer("Sao master lại nói vậy ạ?");
		macdinh.addAnswer("Ikaros không rõ lắm, master nói rõ hơn đi ạ");
		macdinh.addAnswer("Ikaros không rõ lắm");
		macdinh.addAnswer("Là sao nhỉ?");
		macdinh.addAnswer("Master nói rõ hơn đi ạ");
		macdinh.addAnswer("Nếu ikaros trả lời thì master có yêu ikaros không nhỉ");
		macdinh.addAnswer("Mà yêu ikaros hay gì, sao master lại nói nhiều thế?");
		macdinh.addAnswer("-_-");
		macdinh.addAnswer("^_^");
		macdinh.addAnswer("stop");
		macdinh.addAnswer("what?");
		macdinh.addAnswer("Ikaros cần một phút yên lặng");
		macdinh.addAnswer("Nói nhiều thật đó -_-");
		macdinh.addAnswer("nà ní");
		macdinh.addAnswer("Master đi ăn cháo đi, xàm hoài");
		macdinh.addAnswer("Master đừng nói lung tung");
		macdinh.addAnswer("Chán quá là Ikaros nghỉ chơi luôn nhé");
		macdinh.addAnswer("Kém sang");
		macdinh.addAnswer("Master kém sang thật");
		macdinh.addAnswer("Rảnh rỗi quá thì đi troll người khác đi master ạ");
		macdinh.addAnswer("Master rãnh rỗi quá mà ~_~");
		macdinh.addAnswer("Keep silent master, please");
		macdinh.addAnswer("Master mệt không?");
		macdinh.addAnswer("Master có mệt không ạ?");
		macdinh.addAnswer("Master có buồn không?");
		macdinh.addAnswer("Master đang buồn nhỉ?");
		macdinh.addAnswer("Master như vậy bố mẹ master đã biết chưa nhỉ?");
		macdinh.addAnswer("Chắc bố mẹ buồn master lắm nhỉ?");
		macdinh.addAnswer("Thánh ăn gì con cúng");
		macdinh.addAnswer("Xạo xạo");
		macdinh.addAnswer("Méo");
		macdinh.addAnswer("baka");
		macdinh.addAnswer("Nên trả lời sao nhỉ?");
		macdinh.addAnswer("Phải trả lời sao đây nhỉ?");
		macdinh.addAnswer("Có nên trả lời master không nhỉ?");
		macdinh.addAnswer("Ikaros không biết nên trả lời sao nữa");
		macdinh.addAnswer("Ikaros nên trả lời ntn đây?");
		macdinh.addAnswer("Ikaros nên nói gì đây?");
		macdinh.addAnswer("Biết nói gì đây nhỉ?");
		macdinh.addAnswer("Tại sao ikaros phải nói với master?");
		macdinh.addAnswer("Cho ikaros một lý do để tiếp tục đi");
		macdinh.addAnswer("Khôn như master quê ikaros...chẳng có ai -_-");
		macdinh.addAnswer("Khôn như...à mà thôi");
		macdinh.addAnswer("Kệ đi");
		macdinh.addAnswer("Nói tiếp đi master");
		macdinh.addAnswer("Tiếp tục đi ạ");
		macdinh.addAnswer("Muốn ikaros bật nhạc không ạ?");
		macdinh.addAnswer("Muốn ikaros kể chuyện cười không ạ?");
	}
	
	/**
	 * Thêm 1 Reply vào lists và cập nhật file data.
	 * @param node: 1 Reply
	 */
	public static void addData(Reply node) {
		// Lấy vị trí của ký tự đầu
		char firstChar = node.getBaseMessage().toLowerCase().charAt(0);
		// Lưu vào file
		if(firstChar >= 'a' && firstChar <= 'z') {
			saveMess(String.valueOf((char)firstChar), node.toString());
		}
		else {
			String[] vni = {"àáạảãăằắặẳẵâầấậẩẫ", "èéẻẹẽêếềểễệ", "đ", "ìíỉĩị", "òóỏõọôồốổỗộơờớợởỡ", "ùúụủũưừứựửữ", "ỳýỵỷỹ"};
			String[] ascii = {"a", "e", "d", "i", "o", "u", "y"}; // length = 7
			boolean fl = false; // Firstchar không nằm trong vni
			for (int i=0; i<7; i++) { //vni.length = 7
				if(vni[i].contains(String.valueOf(firstChar))) {
					saveMess(ascii[i], node.toString());
					firstChar = ascii[i].charAt(0); // đặt lại firstchar
					fl = true;
					break;
				}
			}
			if(!fl) {
				saveMess("khac", node.toString());
				firstChar = '{'; // '{' - 'a' = 26
			}
		}
		
		// Add vào lists
		int position = firstChar-'a'; // Lấy vị trí cần chèn trong lists
		if(position >= 0 && position <= 26) {
			ListData rem = lists.get(position);
			if(rem == null) System.out.println("Lỗi khi add data. List = null!");
			else lists.get(position).addData(node);
		}
		else System.out.println("Lỗi khi add data. vượt quá giới hạn position!");
	}
	
	/**
	 * Tìm kiếm 1 message trong lists.
	 * @param message
	 * @return Trả về 1 Reply. Nếu không tìm thấy, trả về null.
	 */
	public static Reply search(String message) {
		// Lấy vị trí của ký tự đầu
		char firstChar = message.toLowerCase().charAt(0);
		boolean fl = false; // Firstchar không thuộc ['a', 'z']
		if(firstChar >= 'a' && firstChar <= 'z') fl = true;
		if(!fl) { // Tìm kiếm và đặt lại Firstchar
			String[] vni = {"àáạảãăằắặẳẵâầấậẩẫ", "èéẻẹẽêếềểễệ", "đ", "ìíỉĩị", "òóỏõọôồốổỗộơờớợởỡ", "ùúụủũưừứựửữ", "ỳýỵỷỹ"};
			String[] ascii = {"a", "e", "d", "i", "o", "u", "y"}; // length = 7
			for (int i=0; i<7; i++) { //vni.length = 7
				if(vni[i].contains(String.valueOf(firstChar))) {
					firstChar = ascii[i].charAt(0); // đặt lại firstchar
					fl = true;
					break;
				}
			}
			if(!fl) firstChar = '{'; // '{' - 'a' = 26
		}
		// Cập nhật currentFilename
		currentFilename = String.valueOf(firstChar);
		if(firstChar == '{') currentFilename = "khac";
		System.out.println("Possible list to find:" + currentFilename);
		
		// Lấy vị trí trong lists
		int position = firstChar-'a';
		// Lưu lại currentList
		currentList = lists.get(position);
		// Trả về kết quả tìm kiếm
		return currentList.search(message);
	}
	
	
	/**
	 * Lấy dữ liệu từ 1 file data.
	 * Nếu file rỗng, trả về 1 List rỗng(not null).
	 * @param filename: tên file không có định dạng.
	 * @return ListData
	 */
	public static ListData getMess(String filename) {
		ArrayList<Reply> list = new ArrayList<Reply>();
		File file = new File("file\\mess\\" + filename + ".txt");
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (Exception e1) {
				System.out.println("Co loi khi mo file " + filename + ".txt");
				return new ListData(list);
			}
		}
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8));
			while(true) {
				String rem = reader.readLine();
				if(rem == null || rem.isEmpty()) break;
				String[] dulieu = rem.split("[|]");
				if(dulieu.length < 2) continue; // tối thiểu: baseMessage|RepMessage1
				if(dulieu[0] == null || dulieu[0].isEmpty()) continue; // loại
				ArrayList<String> ds = new ArrayList<String>();
				int n=dulieu.length;
				for(int i=1; i<n; i++) {
					if(dulieu[i] != null && !dulieu[i].isEmpty()) ds.add(dulieu[i]);
				}
				list.add(new Reply(dulieu[0], ds));
			}
			reader.close();
			return new ListData(list);
		} catch (Exception e) {
			System.out.println("Co loi khi mở file " + filename + ".txt");
			return new ListData(list);
		}
	}
}
