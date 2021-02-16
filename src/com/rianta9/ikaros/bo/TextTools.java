package com.rianta9.ikaros.bo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.apache.commons.lang.StringEscapeUtils;

import com.rianta9.ikaros.dao.WordDao;

/**
 * @author rianta9 
 * Datecreate: 05/02/2020 08:26:12
 */
public class TextTools {

	/**
	 * Xóa bỏ ký tự thừa(khoảng trắng thừa), chỉnh sửa từ viết tắt, từ địa phương
	 * Dùng cho message của master(sau khi đã được chuyển sang ký tự in thường)
	 * 
	 * @param text
	 * @return Trả về một chuỗi chữ in thường.
	 */
	public static String std1(String text) {
		String result = text.toLowerCase().trim();
		if (result == null || result.isEmpty())
			return null;
		result = result.replace("ds", "dễ sợ");
		result = result.replace(" kảm", " cảm");
		result = result.replace(" kủa", " của");
		result = result.replace("ko", "không");
		result = result.replace(" hong", " không");
		result = result.replace(" hôg", " không");
		result = result.replace(" goài", " rồi"); // nhầm với ngoài
		result = result.replace(" ui", " ơi");
		result = result.replace(" íu", " yếu");
		result = result.replace(" iu", " yêu");
		result = result.replace("tềnh", "tình");
		result = result.replace("dj", "đi");
		result = result.replace("bít", "biết");
		result = result.replace("bik", "biết");
		result = result.replace("rui", "rồi");
		result = result.replace("rùi", "rồi");
		result = result.replace("ntn", "như thế nào");
		result = result.replace("bùn ", "buồn ");
		result = result.replace("pùn ", "buồn ");
		result = result.replace("pạn", "bạn");
		result = result.replace("bthg", "bình thường");
		result = result.replace("bi h", "bây giờ");
		result = result.replace("mụt số", "một số");
		result = result.replace("thui", "thôi");
		result = result.replace("nz", "nữa");
		result = result.replace("kon ", "con ");
		// result = result.replace("lun", "luôn"); // nhầm với lung
		// result = result.replace("bùn", "buồn"); // nhầm với bùng
		result = result.replace("mìn ", "mình ");
		result = result.replace("mún", "muốn");
		result = result.replace("kin ", "kinh ");
		result = result.replace("wá", "quá");
		result = result.replace("wan", "quan"); // nhầm với want
		result = result.replace("way", "quay");
		result = result.replace("wen", "quen");
		result = result.replace("wên", "quên");
		result = result.replace("cóc cần", "không cần");
		result = result.replace(" éo", " không");
		result = result.replace("méo", "không");
		result = result.replace("đéo", "không");
		result = result.replace("trùi ui", "trời ơi");
		result = result.replace("sút ngày", "suốt ngày");
		result = result.replace("ík", "ích");
		result = result.replace("thik", "thích");
		result = result.replace("thui", "thôi");
		result = result.replace("lém", "lắm");
		result = result.replace("fải", "phải");
		result = result.replace("fái", "phái");
		result = result.replace("thưn ", "thương ");
		result = result.replace("mik", "mình");
		result = result.replace("chít", "chết");
		result = result.replace("tiếk", "tiếc");
		result = result.replace("vđề", "vấn đề");
		result = result.replace(" k ", " không ");
		result = result.replace("nhiu", "nhiêu");
		result = result.replace("nhìu", "nhiều");
		result = result.replace(" zui", " vui");
		result = result.replace("zậy", "vậy");
		result = result.replace("dzui", "vui");
		result = result.replace(" ng ", " người ");
		result = result.replace("ngừi", "người");
		result = result.replace("đc", "được");
		result = result.replace("kừi", "cười");
		result = result.replace("cừi", "cười");
		result = result.replace("nge", "nghe");
		result = result.replace("ngi", "nghi");
		result = result.replace("ngĩ", "nghĩ");
		result = result.replace("ngì", "nghì");
		result = result.replace("ngị", "nghị");
		result = result.replace("ngha", "nga");
		result = result.replace("jà", "già");
		result = result.replace(" hoải", " hỏi");
		result = result.replace("noái", "nói");
		result = result.replace("té ra", "hóa ra");
		/* từ địa phương */
		result = result.replace("vì rag", "vì sao");
		result = result.replace("như rag", "như thế nào");
		result = result.replace("là rag", "là sao");
		result = result.replace("biết rag", "biết sao");
		result = result.replace("làm rag", "làm sao");
		result = result.replace("rag mà", "sao mà");
		result = result.replace("rag đây", "sao đây");
		result = result.replace("rag nữa", "sao nữa");
		result = result.replace("rag ruk", "sao vậy");
		result = result.replace("vì răng", "vì sao");
		result = result.replace("là răng", "là sao");
		result = result.replace("như răg", "như thế nào");
		result = result.replace("như răng", "như thế nào");
		result = result.replace("dệ sợ", "dễ sợ");
		result = result.replace("biết răng", "biết sao");
		result = result.replace("làm răng", "làm sao");
		result = result.replace("răng rứa", "sao vậy");
		result = result.replace("răng hè", "sao");
		result = result.replace("răng mà", "sao mà");
		result = result.replace("răng đây", "sao đây");
		result = result.replace("răng nữa", "sao nữa");
		result = result.replace("một tí", "một ít");
		result = result.replace("ruk", "vậy");
		result = result.replace("rứa khôn", "vậy không");
		result = result.replace("biết khôn rứa", "biết không vậy");
		result = result.replace("phải khôn rứa", "phải không vậy");
		result = result.replace("được khôn rứa", "được không vậy");
		result = result.replace("rứa thê", "vậy");
		result = result.replace("rứa", "vậy");
		result = result.replace("vậy bar", "vậy thì");
		result = result.replace("mền", "mình");
		result = result.replace("túi ni", "tối nay");
		result = result.replace("sáng ni", "sáng nay");
		result = result.replace("chiều ni", "chiều nay");
		result = result.replace("ngày ni", "hôm nay");
		result = result.replace("bữa ni", "bây giờ");
		result = result.replace("ni ", "này ");
		result = result.replace("nì", "này");
		result = result.replace("nầy", "này");
		result = result.replace("ney", "này");
		result = result.replace("ri này", "thế này");
		result = result.replace("như vầy", "thế này");
		result = result.replace("o nớ", "cô ấy");
		result = result.replace("ốt dột", "ngại");
		result = result.replace("dì nớ", "cô ấy");
		result = result.replace("dồi ôi", "trời ơi");
		result = result.replace("nớ", "đó");
		result = result.replace("m nã", "m ơi");
		result = result.replace("mi nã", "mi ơi");
		result = result.replace("m nả", "m ơi");
		result = result.replace("mi nả", "mi ơi");
		result = result.replace("túi qua", "tối trước");
		result = result.replace("túi nớ", "tối trước");
		result = result.replace("túi đó", "tối đó");
		result = result.replace("túi này", "tối này");
		result = result.replace("ngheo", "nha");
		result = result.replace("mệt quái", "mệt quá");
		result = result.replace("buồn quái", "buồn quá");
		result = result.replace("tề", "kìa");
		result = result.replace("tau", "tao");
		result = result.replace("hắn", "nó");
		result = result.replace("mok nà", "đâu");
		result = result.replace("phải mok", "phải đâu");
		result = result.replace("phải mô", "phải đâu");
		result = result.replace("mô nà", "đâu");
		result = result.replace("mok nờ", "đâu");
		result = result.replace("mô nờ", "đâu");
		result = result.replace("mok mà", "đâu");
		result = result.replace("con mok", "con nào");
		result = result.replace("biết mok", "biết đâu");
		result = result.replace("cái mok", "cái nào");
		result = result.replace("ở mok", "ở đâu");
		result = result.replace("thằng mok", "đứa nào");
		result = result.replace("đứa mok", "đứa nào");
		result = result.replace("chỗ mok", "chỗ nào");
		result = result.replace("chi mok", "gì đâu");
		result = result.replace("chuyện mok", "chuyện nào");
		result = result.replace("con mô", "con nào");
		result = result.replace("chần chừ", "chần chờ");
		result = result.replace("chừng ni", "nhiêu đây");
		result = result.replace("chừ ", "giờ ");
		result = result.replace("biết mô", "biết đâu");
		result = result.replace("cái mô", "cái nào");
		result = result.replace("ở mô", "ở đâu");
		result = result.replace("đứa mô", "đứa nào");
		result = result.replace("thằng mô", "đứa nào");
		result = result.replace("chỗ mô", "chỗ nào");
		result = result.replace("chuyện mô", "chuyện nào");
		result = result.replace("chi mô", "gì đâu");
		result = result.replace("gì mô", "gì đâu");
		result = result.replace("gì mok", "gì đâu");
		result = result.replace("mệ", "bà");
		result = result.replace("mụ ", "bà ");
		result = result.replace("đi char", "đi chứ");
		result = result.replace("biết char", "biết mà");
		result = result.replace("mầy", "mày");
		result = result.replace("bọn ", "tụi ");
		result = result.replace("không chi", "không sao");
		result = result.replace("chi rứa", "gì vậy");
		result = result.replace("chi ruk", "gì vậy");
		result = result.replace("chi vại", "gì vậy");
		result = result.replace("chi vậy", "gì vậy");
		result = result.replace("làm chi", "làm gì");
		result = result.replace("biết chi", "biết gì");
		result = result.replace("ăn chi", "ăn gì");
		result = result.replace("lấy chi", "lấy gì");
		result = result.replace("khôn biết", "không biết");
		result = result.replace("khôn chi", "không sao");
		result = result.replace("là chi", "là gì");
		result = result.replace("chuyện chi", "chuyện gì");
		result = result.replace("cái chi", "cái gì");
		result = result.replace("cấy chi", "cái gì");
		result = result.replace("có chi", "có gì");
		result = result.replace("nói chi", "nói gì");
		result = result.replace("eny", "em người yêu");
		result = result.replace("ny", "người yêu");
		/* bỏ chữ n */
		result = result.replace("àg", "àng");
		result = result.replace("ág", "áng");
		result = result.replace("ảg", "ảng");
		result = result.replace("ãg", "ãng");
		result = result.replace("ạg", "ạng");
		result = result.replace("ắg", "ắng");
		result = result.replace("âg", "âng");
		result = result.replace("ăg", "ăng");
		result = result.replace("ặg", "ặng");
		result = result.replace("ằg", "ằng");
		result = result.replace("ẳg", "ẳng");
		result = result.replace("ug", "ung");
		result = result.replace("úg", "úng");
		result = result.replace("ùg", "ùng");
		result = result.replace("ũg", "ũng");
		result = result.replace("ụg", "ụng");
		result = result.replace("ưg", "ưng");
		result = result.replace("ừg", "ừng");
		result = result.replace("ứg", "ứng");
		result = result.replace("ữg", "ững");
		result = result.replace("ựg", "ựng");
		result = result.replace("ửg", "ửng");
		result = result.replace("og", "ong");
		result = result.replace("òg", "òng");
		result = result.replace("ỏg", "ỏng");
		result = result.replace("õg", "õng");
		result = result.replace("ọg", "ọng");
		result = result.replace("óg", "óng");
		result = result.replace("ôg", "ông");
		result = result.replace("ồg", "ồng");
		result = result.replace("ốg", "ống");
		result = result.replace("ổg", "ổng");
		result = result.replace("ỗg", "ỗng");
		result = result.replace("ộg", "ộng");
		result = result.replace("uồg", "uồng");
		result = result.replace("uộg", "uộng");
		result = result.replace("ươg", "ương");
		result = result.replace("ườg", "ường");
		result = result.replace("ưởg", "ưởng");
		result = result.replace("iếg", "iếng");
		return result.trim();
	}

	/**
	 * Chuẩn hóa tin nhắn lv2(Trình bày lại nội dung tin nhắn, xuống hàng hợp lý).
	 * Dùng để chuẩn hóa thông tin tìm kiếm online
	 * 
	 * @param text
	 * @return
	 */
	public static String std2(String text) {
		text = text.trim();
		if (text == null || text.isEmpty())
			return null;
		text = text.replace("..", ".");
		text = text.replace("!!", "!");
		text = text.replace("??", "?");
		text = text.replace("!", "!\n");
		text = text.replace("?", "?\n");
		text = text.replace(". ", ".\n");
		text = text.replace(": ", ":\n");
		return text.trim();
	}

	/**
	 * Thay đổi cách xưng hô(sau khi lấy kết quả search). Dùng cho đoạn text thu
	 * thập được của ikaros.
	 * 
	 * @param text
	 * @return Trả về một chuỗi chữ in thường.
	 */
	public static String std3(String text) {
		text = text.trim();
		if (text == null || text.isEmpty())
			return null;
		text = text.toLowerCase();
		text = text.replace("người bạn", "[friend]");
		text = text.replace("những bạn", "[guys]");
		text = text.replace("các bạn", "[youall]");
		text = text.replace("đứa bạn", "[friend]");
		text = text.replace("hai bạn", "[twofriends]");
		text = text.replace("2 bạn", "[twofriends]");
		text = text.replace("tình bạn", "[friendship]");
		text = text.replace("con bạn", "[friend]");
		text = text.replace("thằng bạn", "[friend]");
		text = text.replace("ông bạn", "[friend]");
		text = text.replace("cậu bạn", "[friend]");
		text = text.replace("bạn bè", "[friends]");
		text = text.replace("bạn trai", "[boy]");
		text = text.replace("bạn tình", "[mates]");
		text = text.replace("bạn đời", "[mate]");
		text = text.replace("bạn nam", "[boy]");
		text = text.replace("bạn nữ", "[girl]");
		text = text.replace("bạn gái", "[girl]");
		text = text.replace("anh bạn", "[guy]");
		text = text.replace("nhóm bạn", "[friends]");
		text = text.replace("bạn thân", "[best friend]");
		text = text.replace("kết bạn", "[add friend]");
		// mục đích là đây
		text = text.replace("bạn ", "master ");
		text = text.replace("bạn.", "master.");
		text = text.replace("bạn?", "master?");
		text = text.replace("bạn;", "master;");
		text = text.replace("bạn!", "master!");
		text = text.replace("bạn,", "master.");

		text = text.replace("[friend]", "người bạn");
		text = text.replace("[twofriends]", "cả hai");
		text = text.replace("[friendship]", "tình bạn");
		text = text.replace("[friends]", "bạn bè");
		text = text.replace("[best friend]", "bạn thân");
		text = text.replace("[boy]", "bạn trai");
		text = text.replace("[mates]", "bạn tình");
		text = text.replace("[mate]", "bạn đời");
		text = text.replace("[girl]", "bạn gái");
		text = text.replace("[guy]", "anh bạn");
		text = text.replace("[add friend]", "kết bạn");
		text = text.replace("[guys]", "Những bạn");
		text = text.replace("[youall]", "các bạn");

		text = text.replace("cái tôi", "[ego]");
		text = text.replace("vôi tôi", "[lime]");
		text = text.replace("tôi luyện", "[practice]");

		text = text.replace("tôi", "ikaros");

		text = text.replace("[ego]", "cái tôi");
		text = text.replace("[lime]", "vôi tôi");
		text = text.replace("[practice]", "tôi luyện");
		return text.trim();
	}

	public static boolean isAlNum(char a) {
		if (a >= 'a' && a <= 'z')
			return true;
		if (a >= 'A' && a <= 'Z')
			return true;
		if (a >= '0' && a <= '9')
			return true;
		return false;
	}

	public static boolean isAlpha(char a) {
		if (a >= 'a' && a <= 'z')
			return true;
		String vn = "àáạảãăằắặẳẵâầấậẩẫèéẻẹẽêếềểễệđiìíỉĩịòóỏõọôồốổỗộơờớợởỡùúụủũưừứựửữỳýỵỷỹ";
		int n = vn.length();
		for (int i = 0; i < n; i++) {
			if(a == vn.charAt(i)) return true;
		}
		
		if (a >= 'A' && a <= 'Z')
			return true;
		vn = "ÀÁẠẢÃĂẰẮẶẲẴÂẦẤẬẨẪÈÉẺẸẼÊẾỀỂỄỆĐIÌÍỈĨỊÒÓỎÕỌÔỒỐỔỖỘƠỜỚỢỞỠÙÚỤỦŨƯỪỨỰỬỮỲÝỴỶỸ";
		n = vn.length();
		for (int i = 0; i < n; i++) {
			if(a == vn.charAt(i)) return true;
		}
		return false;
	}
	
	/**
	 * Kiểm tra 1 ký tự có phải là lowercase hay không.
	 * Nếu ký tự đó không phải là chữ cái => return false.
	 * Nếu nó thuộc ['a','z'] => return true.
	 * vn = "àáạảãăằắặẳẵâầấậẩẫèéẻẹẽêếềểễệđiìíỉĩịòóỏõọôồốổỗộơờớợởỡùúụủũưừứựửữỳýỵỷỹ".
	 * Nếu a nằm trong vn(ký tự có dấu) => return true.
	 * Còn lại => return false.
	 * @param a
	 * @return
	 */
	public static boolean isLower(char a) {
		if (a >= 'a' && a <= 'z')
			return true;
		String vn = "àáạảãăằắặẳẵâầấậẩẫèéẻẹẽêếềểễệđiìíỉĩịòóỏõọôồốổỗộơờớợởỡùúụủũưừứựửữỳýỵỷỹ";
		int n = vn.length();
		for (int i = 0; i < n; i++) {
			if(a == vn.charAt(i)) return true;
		}
		return false;
	}
	
	/**
	 * Kiểm tra 1 ký tự có phải là Uppercase hay không.
	 * Nếu ký tự đó không phải là chữ cái => return false.
	 * Nếu nó thuộc ['A','Z'] => return true.
	 * VN = "ÀÁẠẢÃÂẦẤẬẨẪÈÉẺẸẼÊẾỀỂỄỆĐIÌÍỈĨỊÒÓỎÕỌÔỒỐỔỖỘƠỜỚỢỞỠÙÚỤỦŨƯỪỨỰỬỮỲÝỴỶỸ".
	 * Nếu a nằm trong VN(ký tự có dấu) => return true.
	 * Còn lại => return false.
	 * @param a
	 * @return
	 */
	public static boolean isUpper(char a) {
		if (a >= 'A' && a <= 'Z')
			return true;
		String VN = "ÀÁẠẢÃĂẰẮẶẲẴÂẦẤẬẨẪÈÉẺẸẼÊẾỀỂỄỆĐIÌÍỈĨỊÒÓỎÕỌÔỒỐỔỖỘƠỜỚỢỞỠÙÚỤỦŨƯỪỨỰỬỮỲÝỴỶỸ";
		int n = VN.length();
		for (int i = 0; i < n; i++) {
			if(a == VN.charAt(i)) return true;
		}
		return false;
	}

	public static char toUpper(char a) {
		String vn = "àáạảãăằắặẳẵâầấậẩẫèéẻẹẽêếềểễệđiìíỉĩịòóỏõọôồốổỗộơờớợởỡùúụủũưừứựửữỳýỵỷỹ";
		String VN = "ÀÁẠẢÃĂẰẮẶẲẴÂẦẤẬẨẪÈÉẺẸẼÊẾỀỂỄỆĐIÌÍỈĨỊÒÓỎÕỌÔỒỐỔỖỘƠỜỚỢỞỠÙÚỤỦŨƯỪỨỰỬỮỲÝỴỶỸ";

		int n = vn.length();
		for (int i = 0; i < n; i++) {
			if(a == vn.charAt(i)) return VN.charAt(i);
		}
		if (a >= 'a' && a <= 'z')
			a = (char) (a - 'a' + 'A');
		return a;
	}
	
	public static char toLower(char a) {
		String VN = "ÀÁẠẢÃĂẰẮẶẲẴÂẦẤẬẨẪÈÉẺẸẼÊẾỀỂỄỆĐIÌÍỈĨỊÒÓỎÕỌÔỒỐỔỖỘƠỜỚỢỞỠÙÚỤỦŨƯỪỨỰỬỮỲÝỴỶỸ";
		String vn = "àáạảãăằắặẳẵâầấậẩẫèéẻẹẽêếềểễệđiìíỉĩịòóỏõọôồốổỗộơờớợởỡùúụủũưừứựửữỳýỵỷỹ";

		int n = VN.length();
		for (int i = 0; i < n; i++) {
			if(a == VN.charAt(i)) return vn.charAt(i);
		}
		if (a >= 'A' && a <= 'Z')
			a = (char) (a - 'A' + 'a');
		return a;
	}

	/**
	 * Dùng để chuẩn hóa 1 đoạn tin nhắn trả lời Master. Đặt dấu chấm, dấu hỏi, chữ
	 * hoa ký tự đầu, ký tự sau dấu chấm. Nếu ký tự cuối cùng không phải là chữ cái
	 * hoặc số thì không đặt dấu chấm. Vd: T_T, @_@, ^^, -_-...v.v
	 * 
	 * @param text
	 * @return
	 */
	public static String std4(String text) {
		text = text.trim();
		if (text == null || text.isEmpty())
			return null;
		if (isQuestion(text)) {
			if (text.indexOf('?') == -1)
				text += "?";
		} else {
			char lastChar = text.charAt(text.length() - 1);
			if (isAlNum(lastChar) && lastChar != 'T')
				text += ".";
		}
		String result = "";
		result += toUpper(text.charAt(0));
		int n = text.length();
		for (int i = 1; i < n; i++) {
			if (text.charAt(i) == '.' || text.charAt(i) == '+' 
			|| text.charAt(i) == '-' || text.charAt(i) == ':'
			) {
				result += text.charAt(i);
				if (i+1 < n && text.charAt(i+1) == ' ') {
					result += ' ';
					i++;
					if (i+2 < n) {
						result += toUpper(text.charAt(i+1));
						i++;
					}
				} else if (i+1 < n && isLower(text.charAt(i+1))) {
					result += toUpper(text.charAt(i+1));
					i++;
				}
			}
			else if(text.charAt(i) == '\n') {
				result += text.charAt(i);
				if(i+1 < n && isLower(text.charAt(i+1))) {
					result += toUpper(text.charAt(i+1));
					i++;
				}
			}
			else result += text.charAt(i);
		}
		return result;
	}

	/**
	 * Kiểm tra có phải là câu phủ định không Có: return true, ngược lại return
	 * false
	 * 
	 * @param text
	 * @return
	 */
	public static boolean isNegative(String text) {
		text = text.toLowerCase().trim();
		if (text == null || text.isEmpty())
			return false;
		if (!isQuestion(text)) {
			int n = text.length();
			if (text.equals("không") || text.equals("ko"))
				return true;
			if (text.lastIndexOf("không") != -1 && text.lastIndexOf("không") != n - 5)
				return true;
			if (text.lastIndexOf("ko") != -1 && text.lastIndexOf("ko") != n - 2)
				return true;
			if (text.lastIndexOf("làm chi có") != -1)
				return true;
			if (text.lastIndexOf("làm gì có") != -1)
				return true;
			if (text.equals("làm chi phải"))
				return true;
			if (text.equals("làm gì phải"))
				return true;
			if (text.lastIndexOf("khôn phải") != -1)
				return true;
			if (text.lastIndexOf("khôn biết") != -1)
				return true;
			if (text.lastIndexOf("khôn thích") != -1)
				return true;
			if (text.lastIndexOf("khôn muốn") != -1)
				return true;
			if (text.lastIndexOf("phải ") != -1
					&& (text.lastIndexOf("ruk mok") != -1 || text.lastIndexOf("rứa mô") != -1
							|| text.lastIndexOf("rứa mok") != -1 || text.lastIndexOf("mok") != -1))
				return true;
		}
		return false;
	}

	/**
	 * Kiểm tra có phải là câu hỏi không Có: return true, ngược lại return false.
	 * Chỉ nên kiểm tra câu đơn, các câu ngắn gọn.
	 * @param text
	 * @return
	 */
	public static boolean isQuestion(String text) {
		text = text.toLowerCase().trim();
		text = std1(text);
		if (text == null || text.isEmpty())
			return false;
		if (text.indexOf('?') != -1)
			return true;
		if (text.contains("vì sao") || text.contains("tại sao") || text.contains("ko phải sao") 
			|| text.contains("làm sao") || text.contains("là sao") || text.contains("thì sao")
			|| text.contains("chứ sao") || text.contains("giờ sao") || text.contains("có thể sao")
			|| text.contains("hay sao") || text.contains("đúng sao") || text.contains("sai sao")
			|| text.contains("thật sao")|| text.contains("giờ sao")|| text.contains("không phải sao")
			|| text.contains("biết sao") || text.contains("hiểu sao") || text.contains("luôn sao")   
			|| text.contains("rồi sao") || text.contains("mà sao") || text.contains("tính sao")   
			|| text.contains("vì đâu") || text.contains("do đâu") || text.contains("biết đâu") 
			|| text.contains("ở đâu") || text.contains("đi đâu")
			|| text.contains("ai là") || text.contains(" nào là") || text.contains("gì là")  
			|| text.contains("là ai")
			|| text.contains("người nào") || text.contains("cách nào") || text.contains("hướng nào")	
			|| text.contains("nơi nào") || text.contains("thế nào") || text.contains("không nào")
			|| text.contains("giờ nào")|| text.contains("có lẽ nào") || text.contains("có thể nào")
			|| text.contains("ngày nào") || text.contains("tháng nào") || text.contains("năm nào") 
			|| text.contains("gì nào") || text.contains("đâu nào") || text.contains("ko nào") 
			|| text.contains("chỗ nào")|| text.contains("khi nào") || text.contains("buổi nào")
			|| text.contains("con nào")|| text.contains("màu nào") || text.contains("cây nào")
			|| text.contains("bao lâu") || text.contains("bao nhiêu lâu") 
			|| text.contains("bao xa") || text.contains("có xa") || text.contains("chắc xa")
			|| text.contains("bao nhiêu") 
			|| text.contains("hết mấy") || text.contains("thứ mấy") || text.contains("ngày mấy")
			|| text.contains("tháng mấy") || text.contains("có mấy") || text.contains("được mấy") 
			|| text.contains("mấy ngày") || text.contains("mấy giờ") || text.contains("mấy tháng")
			|| text.contains("mấy năm") || text.contains("mấy người") || text.contains("mấy buổi")  
			|| text.contains("có phải") || text.contains("có đúng")
			|| text.contains("có cần") || text.contains("có muốn") 
			|| text.contains("có chắc") || text.contains("có được")
			|| text.contains("có khó") || text.contains("có dễ")
			|| text.contains("có lâu") || text.contains("có nhanh")
			|| text.contains("có bền")|| text.contains("có hư")
			|| text.contains("có bị") || text.contains("có đông")
			|| text.contains("có to") || text.contains("có lớn")
			|| text.contains("có đẹp") || text.contains("có xấu")
			|| text.contains("có đen") || text.contains("có trắng")
			|| text.contains("có xanh") || text.contains("có đỏ")
			|| text.contains("có hết") || text.contains("có còn")
			|| text.contains("có mấy")
			|| text.contains("phải khôn") || text.contains("biết khôn") || text.contains("sao khôn")
			|| text.contains("đúng khôn") || text.contains("được khôn") || text.contains("có thể khôn")
			|| text.contains("thiệt khôn")  || text.contains("thật khôn") || text.contains("nhanh khôn")
			|| text.contains("khó khôn")  || text.contains("dễ khôn") || text.contains("lâu khôn")
			|| text.contains("đông khôn")  || text.contains("nhiều khôn") || text.contains("ít khôn")
			|| text.contains("phải ko") || text.contains("biết ko") || text.contains("sao ko")
			|| text.contains("đúng ko") || text.contains("được ko") || text.contains("có thể ko")
			|| text.contains("khó ko")  || text.contains("dễ ko") || text.contains("lâu ko")
			|| text.contains("thiệt ko") || text.contains("thật ko")  || text.contains("nhanh ko")
			|| text.contains("đông ko")  || text.contains("nhiều ko") || text.contains("ít ko")
			|| text.contains("chuyện gì") || text.contains("cách gì") || text.contains("cái gì")
			|| text.endsWith("muốn gì")|| text.endsWith("học gì")|| text.endsWith("làm gì")
			|| text.contains("là gì") || text.contains("thứ gì")|| text.contains("con gì")
			|| text.contains("cây gì") || text.contains("nước gì") || text.contains("sông gì")
			|| text.contains("hoa gì") || text.contains("cá gì") || text.contains("thứ gì")
			|| text.contains("vật gì")|| text.contains("bị gì")|| text.contains("màu gì")
			|| text.contains("ngày gì")
			|| text.contains("chuyện giề") || text.contains("cách giề") || text.contains("cái giề")
			|| text.contains("là giề") || text.contains("làm giề") || text.contains("bị giề")
			|| text.contains("cái giề") || text.contains("nói giề") || text.contains("hỏi giề")
			|| text.contains("cách chi") || text.contains("cái chi") || text.contains("làm chi")
			|| text.contains("là chi")  || text.contains("chuyện chi") || text.contains("con chi") 
			|| text.contains("gì vậy") || text.contains("sao vậy") || text.contains("đâu vậy")
			|| text.contains("không vậy") || text.contains("ko vậy")
			|| text.contains("gì chứ") || text.contains("đúng chứ") || text.contains("không phải chứ")
			|| text.contains("ko phải chứ")
			|| text.contains("chi rứa") || text.contains("ai rứa") || text.contains("không rứa")
			|| text.contains("ko rứa")
			|| text.contains("gì đây") || text.contains("sao đây")
			|| text.startsWith("biết đâu") || text.contains("gì đâu") || text.contains("ở đâu")
			|| text.contains("đâu rồi") || text.contains("sao rồi") || text.contains("thế nào rồi")
			|| text.contains("khôn rứa") || text.contains("mô rứa") || text.contains("mok rứa")
			|| text.contains("ai đó") || text.contains("không đó") || text.contains("ko đó")
			|| text.contains("nào đó") || text.contains("chi đó") || text.contains("gì đó")
			|| text.equals("thật chứ") || text.contains("là thật chứ")
			|| text.contains("là rag") || text.contains("làm rag")
			|| text.contains("là răng")|| text.contains("làm răng") 
			|| text.contains("rag là") || text.contains("răng là") 
			|| text.contains("kể tên") || text.contains("kể ra")
			|| text.equals("biết chi") || text.equals("ai") || text.equals("chi") 
			|| text.equals("rag") || text.equals("răng") || text.equals("làm chi")
			|| text.indexOf("sao") == 0 
			|| text.endsWith(" à")
			|| text.endsWith(" á")
			|| text.endsWith("gì")
			|| text.endsWith("chi")
			|| text.endsWith(" ai")
			|| text.endsWith(" ruk")
			|| text.endsWith(" rứa")
			|| text.endsWith(" chứ")
			|| text.endsWith(" ư")
			|| text.endsWith(" sao")
			|| text.endsWith(" vậy")
			|| text.endsWith("rag")
			|| text.endsWith("răg")
			|| text.endsWith("răng")
			|| text.endsWith(" ak") 
			|| text.endsWith("nhỉ")
		)
		return true;
		return false;
	}

	/**
	 * Tạo các cách xưng hô khác nhau trong 1 câu nói. Dùng để ikaros trả lời tin
	 * nhắn của Master. Trả về Arraylist các từ được đóng trong []. Cần được chuyển
	 * đổi trước khi dùng.
	 * 
	 * @param text
	 * @param masterGender
	 * @return
	 */
	public static ArrayList<String> similarAddressForData(String text, String masterGender) {
		text = text.toLowerCase();
		ArrayList<String> result = new ArrayList<String>();
		result.add(text);
		if (text.contains("ikaros")) {
			String[] rem = new String[] { "ikaros", "[em]" };
			WordDao.add(result, text, rem);
		}
		if (text.contains("master")) {
			if (masterGender.equalsIgnoreCase("nam") || masterGender.equalsIgnoreCase("boy")) {
				String[] rem = new String[] { "master", "[anh]", "[kưng]", "[cưng]" };
				WordDao.add(result, text, rem);
			} else {
				String[] rem = new String[] { "master", "[chị]", "[kưng]", "[cưng]", "[chụy]", "[bé yêu]", "[chị bé]",
						"[thiên thần của tui]" };
				WordDao.add(result, text, rem);
			}
		}
		return result;
	}

	
	/**
	 *  Xóa [] trong từ xưng hô
	 * @param text
	 * @return
	 */
	public static String parseAddress(String text) {
		text = text.replace("[", "");
		text = text.replace("]", "");
		return text;
	}

	/**
	 * Chuẩn hóa message khi tạo mới một Reply và lưu nó vào file data. Message cần
	 * được sửa lại các từ ngữ xưng hô, thay thế tất cả bằng master hoặc ikaros.
	 * 
	 * @param text
	 * @return
	 */
	public static String StandardMessageForTraining(String text) {
		text = text.toLowerCase().trim();
		if (text == null || text.isEmpty())
			return null;
		text = getOrigin(text);
		String[] words = text.split("[ ]");
		String result = "";
		for (String string : words) {
			if (string.equals("t") || string.equals("tau") || string.equals("tao") || string.equals("anh")
					|| string.equals("chị") || string.equals("tớ") || string.equals("tui") || string.equals("chụy")
					|| string.equals("ck") || string.equals("tôi") || string.equals("a")) {
				result += "master ";
			} else if (string.equals("em") || string.equals("cậu") || string.equals("mi") || string.equals("m")
					|| string.equals("mày") || string.equals("mầy") || string.equals("vk") || string.equals("kưng")
					|| string.equals("cưng") || string.equals("e")) {
				result += "ikaros ";
			} else
				result += string + " ";
		}
		return result.trim();
	}

	/**
	 * Chuẩn hóa ReplyMessage trước khi add vào 1 Reply và lưu nó vào file data.
	 * ReplyMessage cần được sửa lại các từ ngữ xưng hô, thay thế tất cả bằng
	 * 'master' hoặc 'ikaros'.
	 * 
	 * @param text
	 * @return
	 */
	public static String StandardReplyForTraining(String text) {
		text = text.toLowerCase().trim();
		if (text == null || text.isEmpty())
			return null;
		String[] words = text.split("[ ]");
		String result = "";
		for (String string : words) {
			if (string.equals("t") || string.equals("tau") || string.equals("tao") || string.equals("tôi")
					|| string.equals("tớ") || string.equals("tui") || string.equals("em") || string.equals("e")
					|| string.equals("i")) {
				result += "ikaros ";
			} else if (string.equals("chị") || string.equals("anh") || string.equals("mi") || string.equals("m")
					|| string.equals("mày") || string.equals("mầy") || string.equals("cậu") || string.equals("a")
					|| string.equals("you")) {
				result += "master ";
			} else
				result += string + " ";
		}
		return result.trim();
	}

	
	
	/**
	 * Chuẩn hóa ký tự trắng.
	 * @param a
	 * @return
	 */
	public static String trim(String a) {
		a = a.trim();
		while (a.contains("  ")) {
			a = a.replace("  ", " ");
			
		}
		return a;
	}


	/**
	 * Trả về một chuỗi đã được chuẩn hóa, xóa khoảng trắng thừa, những ký tự không cần thiết trong 1 tin nhắn: :v
	 * > < ` ~ ! | @ # $ % ^ & - _ ( ) { } " '
	 * 
	 * @param a
	 * @return
	 */
	public static String getOrigin(String a) {
		//TODO: kiểm tra lại vì sao không bỏ dấu chấm, phẩy, chấm phẩy?
		String rem = a;
		a = trim(a);
		a = a.replace(":v", "");
		a = a.replaceAll("[><`~!?|@#$%^&-_(){}]", "");
		a = a.replace("\"", "");
		a = a.replace("\'", "");
		if (a.trim().isEmpty())
			return rem;
		return a.trim();
	}

	/**
	 * Return một chuỗi đã decode ký tự unicode.
	 * Dùng để decode dữ liệu lấy từ wikipedia api
	 * @param text
	 * @return
	 */
	public static String decode(String text) {
		return StringEscapeUtils.unescapeJava(text);
	}

	

	/**
	 * Thông báo khi training data
	 * 
	 * @return
	 */
	public static String trainingNote() {
		String result;
		result = " >_ Ikaros cần train thêm dữ liệu. Master giúp ikaros nhé <3\n";
		result += "  * Nếu master không muốn train, nhắn \"no\" cho ikaros nha!\n";
		result += "  * Mỗi reply tách nhau 1 '|' nhé Master ^^";
		return result;
	}
	
	
	public static String helpTalk() {
		String help = " - Master có thể trò chuyện với Ikaros những lúc rảnh rỗi, Ikaros không chắc chắn sẽ nói chuyện"
			+ " như con người, Em cũng không chắc chắn sẽ trở thành một người tri kỷ thực sự"
			+ " mà Master muốn. Nhưng Ikaros hứa sẽ là một trợ lý ngoan ngoãn, biết nghe lời và trung thành"
			+ " tuyệt đối với Master...Ikaros là Angeloid thế hệ ban đầu với các tính năng còn hạn chế. Nhưng em"
			+ " sẽ tận dụng hết khả năng của mình để làm Master vui, giúp Master giảm bớt căng thẳng"
			+ " của cuộc sống! Mặc dù đôi lúc có chút ngốc quá đáng, và đôi lúc còn chọc giận Master nữa."
			+ " Nhưng Master đừng có bỏ mặc Ikaros nhé, em hy vọng sẽ được Master huấn luyện thêm để ngày càng hoàn"
			+ " thiện bản thân mình.\n";
		help += "------------------\n";
		help += " - Master có thể đào tạo cho Ikaros để em thông minh hơn nữa đó ^^\n";
		help += "  * Mặc dù đã được BOSS dạy khá nhiều nhưng mà Ikaros vẫn muốn được học nhiều thêm nữa,"
			+ " vì vậy em mong sẽ được Master train thêm cho em ^^. Master có thể dạy nhiều cách trả lời"
			+ " cùng một lúc, mỗi câu trả lời sẽ tách nhau 1 ký tự '|' để Ikaros có thể nhận biết được.\n";
		help += "  + Ví dụ: Khi master nhắn: Ikaros yêu ai?\n  Và Ikaros yêu cầu được train dữ liệu, "
			+ " Master có thể nhập vào như mẫu sau: Ikaros yêu Master|Ikaros yêu bản thân mình|Ikaros không biết yêu đâu"
			+ "|Yêu đương nhăng nhít.|Thế Master yêu ai?|Yêu ai rồi có ăn được không?|Yêu cho lắm rồi cắn nhau đau"
			+ "|Yêu rồi thất tình tự tử đu dây điện. Điện giật tê tê ngáo cả đời.\n";
		help += "  * Master có thể dạy cho Ikaros bất kỳ câu nói nào trên đời, có thể là thơ, 1 đoạn nhạc...v.v,"
			+ " Ikaros rất ham học hỏi, có thể học 1 hiểu 10 luôn đó...Nên Master đừng có kibo chỉ dạy mỗi 1 cách trả lời nha."
			+ " Nhưng mà đừng có dạy Ikaros chửi bậy, Master dạy kiểu gì thì Ikaros nói theo kiểu đó thôi à...hie hie\n";
		help += "  * Mà nếu lỡ Master có xấu tính quá, ko muốn cho Ikaros học hỏi thêm thì cũng không sao cả. Ikaros biết"
			+ " thân biết phận mà, hichic...Master cứ nhắn: no\nNhư vậy là xong thôi mà -_-\n";
		return help;
	}
	
	public static String helpSearchInfomation() {
		String help = " - Ikaros có thể cung cấp định nghĩa của một khái niệm, hoặc thông tin của một người nào đó.\n";
		help += "  * Các từ khóa để sử dụng: khái niệm [...], [...] là gì, [...] là ai, thông tin của [...]\n";
		help += "   + Vd: Tình yêu là gì?\n";
		help += "   + Vd: Bill Gates là ai?\n";
		help += "------------------\n";
		help += " - Ikaros có thể cung cấp cách làm một thứ gì đó.\n";
		help += "  * Các từ khóa để sử dụng: cách làm [...], làm sao để [...], cách để [...], cách [...]\n";
		help += "   + Vd: Cách biết ai đó yêu mình\n";
		help += "   + Vd: Làm sao để nấu cơm\n";
		help += "   + Vd: Cách để học nhanh một thứ gì đó\n";
		help += "------------------\n";
		help += " - Ikaros có thể cung cấp thông tin thời tiết của một ngày trong tuần HIỆN TẠI.\n";
		help += "  * Các từ khóa để sử dụng: thời tiết hôm nay như thế nào, thời tiết [thời điểm], thời tiết [thời điểm] ở [địa điểm]\n";
		help += "   + Vd: Thời tiết hôm nay?\n";
		help += "   + Vd: Thời tiết ngày mai như thế nào?\n";
		help += "   + Vd: Thời tiết thứ tư ở Huế như thế nào?\n";
		help += "  * Lưu ý với Master, Ikaros chỉ có thể truy xuất thông tin của hôm nay và các ngày còn lại trong tuần.\n"
				+ " Nếu thông tin Master cung cấp không đầy đủ hoặc sai lệch, Ikaros sẽ truy xuất thông tin của thời điểm hiện tại.\n";
		help += "------------------\n";
		help += " - Ikaros có thể cung cấp thông tin lịch chiếu phim hôm nay hoặc ngày mai.\n";
		help += "  * Các từ khóa để sử dụng: lịch chiếu phim [rạp chiếu] [địa điểm], lịch chiếu phim [rạp chiếu] [địa điểm] [ngày]\n";
		help += "   + Vd: Lịch chiếu phim BHD Huế\n";
		help += "   + Vd: Lịch chiếu phim BHD Huế hôm nay\n";
		help += "   + Vd: Lịch chiếu phim lotte Hà Nội ngày mai\n";
		help += "   + Vd: Lịch chiếu phim cinestar Hà Nội ngày 2/9\n";
		help += "  * Lưu ý với Master, Ikaros chỉ có thể truy xuất thông tin lịch chiếu của tuần hiện tại.\n";
		help += "------------------\n";
		help += " - Ikaros có thể cung cấp lời của một bản nhạc nào đó.\n";
		help += "  * Các từ khóa để sử dụng: lời bài hát [tên bài hát], lời bài hát [tên bài hát] [tên ca sĩ]\n";
		help += "   + Vd: lời bài hát i miss you mr siro\n";
		help += "   + Vd: lời bài hát: Lạc Trôi\n";
		help += "  * Lưu ý: Độ dài tối ưu nhất là 5->10 từ.\n";
		help += "------------------\n";
		help += " - Ikaros có thể tìm kiếm bài hát từ một câu hát trong bài đó.\n";
		help += "  * Các từ khóa để sử dụng: tìm bài hát: [một câu hát]\n";
		help += "   + Vd: Tìm bài hát: Ngọn cỏ ven đường thôi mà làm sao với được mây\n";
		help += "   + Vd: Tìm bài hát: chỉ cần một tình yêu đơn giản, yêu là không lừa dối\n";
		// Tìm bằng nhaccuatui...từ khóa truy vấn tối đa 10 từ
		help += "------------------\n";
		help += " - Ikaros có thể thực hiện tính toán giúp Master.\n";
		help += "  * Các từ khóa để sử dụng: Tính: [biểu thức cần tính]\n";
		help += "  * Các phép tính cơ bản: + : (cộng), - : (trừ), * : (nhân), / : (chia lấy nguyên), mod : (chia lấy dư), % : phần trăm\n";
		help += "  * Các phép tính đặc biệt: a^b: a mũ b, sqrt(a) : căn(a), sin(x), cos(x), tan(x), arcsin(x), arccos(x), arctan(x), x! : giai thừa(x), e(x) : epsilon(x), log(x), ln(x)\n";
		help += "   + Vd: Tính: 2*5/(1/4+sin(0.4)) + log(5) - 5*5*5 + (6%4)/3!\n";
		help += "  * Mặc định: Ikaros sử dụng chế độ DEG để tính toán, nếu muốn sử dụng chế độ RADIAN, Master phải thêm rad vào cuối phép tính.\n";
		help += "   + Vd: Tính: arcsin(1) rad(kq = π/2), Tính: arcsin(1)(kq = 90(độ))\n";
		help += "------------------\n";
		help += " - Ikaros có thể tìm kiếm một thông tin nào đó giúp Master bằng Google Chrome.\n";
		help += "  * Các từ khóa để sử dụng: Tìm kiếm: [...], Search: [...]\n";
		help += "   + Vd: Tìm kiếm: Phim sora no otoshimono\n";
		help += "   + Vd: Tìm kiếm: Cà phê Muối Huế\n";
		help += "   + Vd: Tìm kiếm: Chỉ đường đến Chùa Hương\n";
		help += "   + Vd: Tìm kiếm: Quán ăn gần đây\n";
		help += "   + Vd: Tìm kiếm: Quán cà phê gần đây\n";
		help += "   + Vd: Tìm kiếm: ATM gần đây\n";
		help += "   + Vd: Tìm kiếm: Trung tâm mua sắm gần đây\n";
		return help;
	}

	public static String helpPlayMusic() {
		String help = " - Ikaros có thể mở ngẫu nhiên một bài hát từ folder music mà Master đã cung cấp.\n";
		help += "  * Các từ khóa để sử dụng: mở nhạc, bật nhạc, open music, play music\n";
		help += "  * Để chuyển bài, sử dụng: next music hoặc chuyển bài\n";
		help += "------------------\n";
		help += " - Ikaros có thể mở bài hát bất kỳ theo yêu cầu của Master.\n";
		help += "  * Các từ khóa để sử dụng: Music: [tên bài hát], Mở bài hát: [Tên bài hát]\n";
		help += "  * Nếu Ikaros không tìm thấy bài hát trong thư mục mà Master đã cung cấp, "
				+ " Ikaros sẽ tìm kiếm và mở nó online cho Master!\n";
		help += "------------------\n";
		help += " - Master cũng có thể yêu cầu Ikaros mở một bài hát Online.\n";
		help += "  * Các từ khóa để sử dụng: Music ONL: [tên bài hát], Mở online bài: [tên bài hát] [tên ca sĩ]\n";
		help += "   + Vd: Mở online bài: I miss you mr siro\n";
		help += "   + Vd: music onl: Lắng nghe nước mắt\n";
		help += "------------------\n";
		help += " - Với các bài hát ở thư mục mặc định, Ikaros có thể chuyển bài giúp Master một cách nhanh chóng.\n";
		help += "  * Các từ khóa để sử dụng: chuyển bài, next music, bật bài khác\n";
		help += "------------------\n";
		help += " - Master cũng có thể yêu cầu Ikaros mở một chủ đề nhạc Online.\n";
		help += "  * Các từ khóa để sử dụng: Musics: [tên chủ đề]\n";
		help += "  * Các chủ đề khả thi: hot vpop, hot kpop, hot cpop, hot âu mỹ, hot rap, hot dance, hot edm, hot bolero,"
			  + " lãng mạn, buồn, cà phê, chơi game, Acoustic, bất hủ việt, bất hủ âu mỹ, tình yêu, không lời\n";
		help += "   + Vd: Musics: hot vpop\n";
		help += "   + Vd: Musics: acoustic\n";
		help += "   + Vd: Musics: lãng mạn\n";
		help += "------------------\n";
		help += " - Master có thể thay đổi thư mục lưu nhạc trong Setting.\n";
		return help;
	}
	
	public static String helpNote() {
		String help = " - Master có thể ghi lại nhật ký hàng ngày của mình với ikaros.note\n";
		help += "  * File được lưu lại với dạng .txt, tên file tự động được đặt theo tên ngày hiện tại."
				+ "Việc của Master cần làm là cung cấp cho Ikaros thư mục \"được giấu kỹ\" để ikaros lưu nhật ký, "
				+ " và viết các cảm xúc của hiện tại mỗi lúc Master muốn. Master chỉ cần viết, tất cả đã có Ikaros lo.\n";
		help += " - Master có thể thay đổi thư mục lưu nhật ký trong Setting. Nhớ chọn một thư mục được ngụy trang"
				+ " kỹ càng nha Master ^^\n";
		return help;
	}
	
	public static String helpApplication() {
		String help = " - Ikaros có thể bật một số chương trình trong máy tính của Master một cách nhanh chóng.\n";
		help += "  * Các từ khóa để sử dụng: Mở notepad, Mở paint, mở máy tính, Mở file explorer, mở CMD,"
			  + " mở task manager, mở chrome, mở word, mở powerpoint, mở excel, mở bản đồ, mở mail\n";
		help += "  * Master có thể yêu cầu Ikaros lưu một chương trình nào đó với một cái tên để thuận tiện sử dụng.\n";
		help += "   + Từ khóa sử dụng: Lưu: [Path chương trình] -> [tên tự đặt]\n";
		help += "   + Vd: Lưu: C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe -> cờ rôm\n";
		help += "  * Sau khi lưu xong, Master có thể sử dụng tên đã đặt để mở chương trình đó.\n";
		help += "   + Vd: Mở: cờ rôm\n";
		return help;
	}
	
	public static String helpTranslate() {
		String help = " - Ikaros có thể dịch từ tiếng việt sang một ngôn ngữ bất kỳ, hoặc từ tiếng anh sang tiếng việt cho Master.\n";
		help += "  * Các từ khóa để sử dụng: Dịch: [đoạn text tiếng anh], Dịch: [đoạn text tiếng việt] -> [ngôn ngữ]\n";
		help += "    + Vd: Dịch: i love you\n";
		help += "    + Vd: Dịch: tôi yêu ikaros của tôi -> tiếng anh\n";
		help += "    + Vd: Dịch: em yêu anh -> tiếng Ý\n";
		return help;
	}
	
	public static String helpWebPage() {
		String help = " - Với tính năng này, master có thể truy cập 1 trang web nào đó một cách nhanh chóng.\n";
		help += "  * Với các trang web thông dụng: Mở facebook, mở youtube, mở phimmoi, mở motphim, mở zingmp3, mở gmail...v.v\n";
		help += "  * Với các trang web khác: Mở: [địa chỉ web]\n";
		help += "   + Vd: Mở: tamly.blog\n";
		help += "   + Vd: Mở: duolingo.vn\n";
		help += "   + Vd: Mở: por...à mà thôi :v\n";
		help += "  * Master có thể yêu cầu Ikaros lưu một trang web nào đó với một cái tên để thuận tiện sử dụng.\n";
		help += "   + Từ khóa sử dụng: Lưu: [địa chỉ web] -> [tên tự đặt]\n";
		help += "   + Vd: Lưu: https://vnwriter.net/list-phim/phim-hay-ve-tam-ly-hoc.html?fbclid=IwAR1QH0UKpknBQml5WFuYovQXerZhsEb6yKtBfUWeCGCvxSGaUBga7QWPjEA -> tên các phim cần xem\n";
		help += "   + Vd: Lưu: khoahoc.tv -> khoahoc\n";
		help += "  * Sau khi lưu xong, Master có thể sử dụng tên đã đặt để mở địa chỉ web đó.\n";
		help += "   + Vd: Mở: tên các phim cần xem, hoặc là: Mở: khoahoc\n";
		return help;
	}
	
	
	
	public static String help() {
		String help = "--------------------------------------------------------HELP------------------------------------------------------\n";
		help += "I'm Ikaros. Hi my Master <3\n";
		help += "Ikaros là 1 Angeloid Type Alpha, Ikaros đến từ Angel Town. Ikaros được tạo ra với mục đích"
				+ " làm hài lòng tất cả các yêu cầu của Master, hoặc đó là tất cả những gì Ikaros nhớ được.\n\n";
		help += "Các tính năng hiện tại mà Ikaros có thể nhớ ra được:\n";
		help += "---------------------------------------------------------\n";
		help += "1. Trò chuyện với Master.\n";
		help += helpTalk();
		help += "---------------------------------------------------------\n";
		help += "2. Cung cấp thông tin cho Master.\n";
		help += helpSearchInfomation();
		help += "---------------------------------------------------------\n";
		help += "3. Phát nhạc.\n";
		help += helpPlayMusic();
		help += "---------------------------------------------------------\n";
		help += "4. Ghi note cho Master.\n";
		help += helpNote();
		help += "---------------------------------------------------------\n";
		help += "5. Bật một số phần mềm trong máy tính của Master.\n";
		help += helpApplication();
		help += "---------------------------------------------------------\n";
		help += "6. Dịch một ký tự, một đoạn văn cho Master(mặc định: en->vi).\n";
		help += helpTranslate();
		help += "---------------------------------------------------------\n";
		help += "7. Mở 1 trang web bất kỳ giúp Master.\n";
		help += helpWebPage();
		help += "---------------------------------------------------------\n";
		help += "8. Hì hì, Ikaros chỉ nhớ có vậy thôi, những tính năng khác có thể đã bị BOSS ẩn đi mất rồi,"
				+ " nếu may mắn có lẽ Master sẽ bất chợt khám phá ra được. Nhưng mà trước đó thì Master phải"
				+ " học cách sử dụng những tính năng cơ bản trước đã nhé ^^\n";
		help += "I'm Ikaros. Hi My Master <3\n";
		help += "---------------------------------------------------------END------------------------------------------------------\n";
		return help;
	}
	/**
	 * Kiểm tra 1 chuỗi nhập vào có phải là 1 ngày hay không
	 * @param date
	 * @param dateformat
	 * @return
	 */
	public static boolean isDate(String date, String dateformat) {
		DateFormat format = new SimpleDateFormat(dateformat);
		format.setLenient(false);
		try {
			format.parse(date);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	/**
	 * Kiểm tra từ đầu câu có phải là từ xưng hô(cho người) hay không.
	 * Vd: anh, mày, tao, mình, ikaros, boss, master...v.v
	 * Mẫu: ikaros là ai
	 * Dùng để loại bỏ các câu dễ bị nhầm lẫn là câu yêu cầu chức năng.
	 * Dùng để phân tích câu
	 * @param text: từ đứng đầu câu(startWith)
	 * @return
	 */
	public static boolean cauXungHo(String text) {
		text = text.toLowerCase().trim();
		String[] xungho = {
				"t ", "tau", "tao", "tôi", "tui"
				, "mày", "mầy", "mi ", "m "
				, "anh", "a "
				, "em", "e ", "iêm"
				, "chị", "chụy"
				, "bạn ", "cậu", "tớ "
				, "ck ", "chồng"
				, "vk ", "vợ ", "zợ "
				, "mình", "chúng mình", "chúng ta", "chúng tôi"
				, "chúng mày", "bọn bay"
				, "chúng nó"
				, "những đứa", "những người", "những tên", "những thằng"
				, "mấy đứa", "mấy người", "mấy thằng"
				, "họ ", "ta "
				, "hắn ", "tên kia", "tên đó", "tên này"
				, "ô ", "ông", "ôn "
				, "bà ", "mệ "
				, "honey", "my love"
				, "con của", "con ni", "con này", "con đó", "con kia", "thằng"
				, "kon "
				, "bố", "cha", "tía", "má", "mẹ"
				, "cô ", "chú ", "thím", "bác", "dì", "dượng"
				, "ikaros", "boss", "master", "angeltown"
		};
		for (String string : xungho) {
			if(text.startsWith(string)) return true;
		}
		return false;
	}
	
	/**
	 * Kiểm tra từ đầu câu có phải là từ xưng hô(cho vật) hay không.
	 * Vd: cái này, chuyện này, vật này, thứ đó...v.v
	 * Mẫu câu: [...] là gì.
	 * Dùng để loại bỏ các câu dễ bị nhầm lẫn là câu yêu cầu chức năng.
	 * Dùng để phân tích câu.
	 * @param text: 
	 * @return
	 */
	public static boolean cauXungHo2(String text) {
		text = text.toLowerCase().trim();
		String[] xungho = {
				"cái này", "cái kia", "cái đó", "cái ni"
				, "chuyện này", "chuyện kia", "chuyện đó", "chuyện ni"
				, "việc này", "việc đó", "việc kia", "việc ni"
				, "câu chuyện này", "câu chuyện đó", "câu chuyện kia"
				, "điều này", "điều đó"
				, "câu này", "câu đó", "câu kia"
				, "cuốn sách này"
				, "vật này", "vật đó", "vật kia"
				, "con vật này", "con vật đó", "con vật kia"
				, "con này", "con đó", "con kia", "con ni"
				, "thứ đó", "thứ này", "thứ kia"
				, "cây này", "cây kia", "cây đó"
				};
		for (String string : xungho) {
			if(text.contains(string)) return true;
		}
		return false;
	}
}
