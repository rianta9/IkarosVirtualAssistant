package com.rianta9.ikaros.bo;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.stream.Collectors;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import org.apache.commons.lang.StringEscapeUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.rianta9.ikaros.bean.BalanCalculate;
import com.rianta9.ikaros.bean.BookMark;
import com.rianta9.ikaros.dao.CssSelectorDao;
import com.rianta9.ikaros.dao.SettingDao;

/**
 * @author rianta9
 * Datecreate: 05/02/2020 08:41:15
 */
public class Function {
	
	
	
	/**
	 * Random một số từ 1 đến size
	 * 
	 * @param size
	 * @return
	 */
	public static int random(int size) {
		Random i = new Random();
		return i.nextInt(size) + 1;
	}

	/**
	 * Random một số từ 0 đến size-1
	 * 
	 * @param size
	 * @return
	 */
	public static int rand(int size) {
		Random i = new Random();
		return i.nextInt(size);
	}
	
	
	public static String welcomeQuote(String sex) {
		//TODO: welcome
		return null;
	}
	
	public static String chucNguNgon(String sex) {
		//TODO: chucNguNgon
		return null;
	}
	
	public static String holidayQuote(String sex) {
		//TODO: holidayQuote
		return null;
	}
	
	/**
	 * Trả về 1 chuỗi là thời gian hiện tại
	 * @return định dạng hh:mm
	 */
	public static String time() {
		try {
			Date thoigian = new Date();
			SimpleDateFormat dinhdang = new SimpleDateFormat("HH:mm");
			String result = dinhdang.format(thoigian);
			return result;
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * Trả về 1 chuỗi là ngày hiện tại
	 * @return định dạng dd-mm-yyyy
	 */
	public static String date() {
		try {
			Date thoigian = new Date();
			SimpleDateFormat dinhdang = new SimpleDateFormat("dd-MM-yyyy");
			String result = dinhdang.format(thoigian);
			return result;
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * Trả về một chuỗi là ngày và thời gian hiện tại
	 * @return định dạng hh:mm dd-mm-yyyy
	 */
	public static String datetime() {
		try {
			Date thoigian = new Date();
			SimpleDateFormat dinhdang = new SimpleDateFormat("HH:mm dd-MM-yyyy");
			String result = dinhdang.format(thoigian);
			return result;
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * Trả về thông tin thời tiết của một truy vấn. Nếu không có, tìm kiếm truy vấn online
	 * @param quere: là 1 truy vấn thời tiết đã được kiểm tra trước đós
	 * @return vị trí, thời điểm, nhiệt độ, dự báo thời tiết, khả năng có mưa, độ ẩm
	 */
	public static String weather(String query) {
		String url = "https://www.google.com/search?q=" + query;
		try {
			
			Document google = Jsoup.connect(url).get();
			
			String position = google.select("#wob_loc").text();
			String[] vt = position.split("[,]");
			String location;
			if(vt.length <= 2) location = "Vị trí: " + position;
			else location = "Vị trí: " + vt[1]+", "+vt[2];
			String dateOfWeek = "Thời điểm: " + google.select("#wob_dts").text();
			String temperature = "Nhiệt độ: " + google.select("#wob_tm").text();
			String status = "Dự báo: " + google.select("#wob_dc").text();
			String precipitation = "Khả năng có mưa: " + google.select("#wob_pp").text();
			String humidity = "Độ ẩm: " + google.select("#wob_hm").text();
			
			String result = "Thông tin thời tiết:\n"+location+"\n"+dateOfWeek+"\n"+temperature+"\n"+status+"\n"+precipitation+"\n"+humidity;
			return result;
		} catch (Exception e) {
			String result = "Ikaros không thể truy xuất nhanh thông tin thời tiết vào hiện tại. Ikaros sẽ mở trình duyệt giúp Master!\n";
			return result + searchGoogle(query); // Mở trình duyệt để tìm kiếm kết quả
		} 
	}
	
	public static String specialPerson() {
		//TODO: specialPerson
		return null;
	}
	
	/**
	 * Trả về 1 quote ngẫu nhiên
	 * @param type: loại quote
	 * @return
	 */
	public static String quote(int type) {
		//TODO: quote
		return null;
	}
	
	public static String toTinh(boolean sex) {
		//TODO: quote
		return null;
	}
	
	/**
	 * Trả về kết quả tìm kiếm thông tin từ wikipedia. Nếu không tìm thấy kết quả trả về null.
	 * @param question: là truy vấn đã được kiểm tra
	 * @return
	 */
	public static String wikipedia(String question) {
		String searchText = question + " wikipedia"; // vd: Sơn tùng là ai
		System.out.println("Truy vấn:" + searchText);
		String url = "https://www.google.com/search?q=" + searchText;
		try {
			Document doc = Jsoup.connect(url).get();
			Elements links = doc.select("cite");
			
			String getLinkTitle = links.get(0).text();
			String[] listTitle = getLinkTitle.split("[ > ]");
			String resultIDWikipedia = listTitle[listTitle.length-1];
			// kiểm tra độ giống nhau giữa kết quả và truy vấn
			String[] words = searchText.split("[ ]");
			String[] titleWords = resultIDWikipedia.split("[_]");
			if(!words[0].equalsIgnoreCase(titleWords[0])) // khác từ đầu tiên
				return getResultGG(question);
			System.out.println("ID wikipedia: " + resultIDWikipedia);
			String wikipediaApiJSON = "https://vi.wikipedia.org/w/api.php?format=json&action=query&prop=extracts&exintro=&explaintext=&titles="
					+ resultIDWikipedia;
			
			HttpURLConnection httpcon = (HttpURLConnection) new URL(wikipediaApiJSON).openConnection();
			httpcon.addRequestProperty("User-Agen", "Mozilla/5.0");
			BufferedReader in = new BufferedReader(new InputStreamReader(httpcon.getInputStream()));
			//Read line by line
			String responseSB = in.lines().collect(Collectors.joining());
			in.close();
			//Get extract data
			String extractData = responseSB.split("extract\":\"")[1];
			//Decode unicode
			String result = TextTools.std2(StringEscapeUtils.unescapeJava(extractData));
			System.out.println("Wiki Result: " + result);
			return TextTools.std3(result.replace("\"}}}}", ""));
		} catch (Exception e) {
			return getResultGG(question);
		} 
	}
	
	/**
	 * Cách làm, cách thực hiện một thứ gì đó. Tìm kiếm thông tin từ wikihow. Nếu không tìm thấy kết quả trả về null.
	 * @param question: 1 truy vấn đã được kiểm tra
	 * @return
	 */
	public static String howTo(String question) {
		System.out.println("Truy vấn: " + question);
		String searchText = question;
		String url = "https://www.wikihow.vn/wikiHowTo?search=" + searchText;
		try {
			Document wikiHow = Jsoup.connect(url).get();
			// List link result
			Elements links = wikiHow.select("a.result_link");
			// Choose First link
			String firstLink = links.first().attr("abs:href");
			System.out.println("Choose link: " + firstLink);
			// Load page
			Document doc = Jsoup.connect(URLDecoder.decode(firstLink, "UTF-8")).userAgent("Mozilla/5.0").timeout(6000).get();
			
			String result = doc.select("title").text()+"\n";
			
			// lấy các section
			Elements sections = doc.select("div.section.steps.sticky");

			for (Element section : sections) {
				Elements method = section.select("h3 > div.altblock");
				Element methodTitle = section.select("span.mw-headline").first();
				result += method.text() + "\n";
				result += methodTitle.text() + "\n";
				result += "Các bước:" + "\n";
				Elements stepsMethod = section.select("ol > li");
				for (Element step : stepsMethod) {
					String stepNum = step.select("div.step_num").first().text();
					String stepContent = step.select("div.step").text();
					result += " * Bước " + stepNum + ":" + "\n";
					result += stepContent + "\n";
					
				}
				result += "\n";
			}
			return TextTools.std3(result);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Result: null");
			return getResultGG(question);
		} 
	}
	
	/**
	 * Trả về kết quả của một phép tính.
	 * @param operation: phép tính
	 * @return
	 */
	public static String calculate(String operation, boolean degmode) {
		operation = operation.trim();
		try {
			BalanCalculate calculator = new BalanCalculate();
			calculator.setError(false);
			calculator.setDegOrRad(degmode); // set chế độ deg hoặc rad
			Double result = calculator.valueMath(operation);
			
			if(!calculator.isError()) {
				return calculator.numberToString(result, 10, 10);
			}
			return "Phép toán lỗi!";
		} catch (Exception e) {
			return "Lỗi tính toán!";
		} 
	}
	
	
	public static String openNotepad() {
		Runtime runtime = Runtime.getRuntime();     //getting Runtime object
        try{
            runtime.exec("notepad.exe");        //opens new notepad instance
            return "success!";
        }catch (Exception e) {
			return "fail!";
		}
	}
	
	public static String openExplorer() {
		Runtime runtime = Runtime.getRuntime();     //getting Runtime object
        try{
            runtime.exec("explorer.exe");        //opens new notepad instance
            return "success!";
        }catch (Exception e) {
			return "fail!";
		}
	}
	
	public static String openPaint() {
		Runtime runtime = Runtime.getRuntime();     //getting Runtime object
        try{
            runtime.exec("mspaint.exe");        //opens new notepad instance
            return "success!";
        }catch (Exception e) {
			return "fail!";
		}
	}
	
	public static String openCalculator() {
		Runtime runtime = Runtime.getRuntime();     //getting Runtime object
        try{
            runtime.exec("calc.exe");        //opens new notepad instance
            return "success!";
        }catch (Exception e) {
			return "fail!";
		}
	}
	
	public static String openCMD() {
		Runtime runtime = Runtime.getRuntime();     //getting Runtime object
        try{
            runtime.exec("cmd.exe");        //opens new notepad instance
            return "success!";
        }catch (Exception e) {
			return "fail!";
		}
	}
	
	public static String openTaskManager() {
		Runtime runtime = Runtime.getRuntime();     //getting Runtime object
        try{
            runtime.exec("taskmgr.exe");        //opens new notepad instance
            return "Success!";
        }catch (Exception e) {
			return "fail!";
		}
	}
	
	
	public static String openChrome() {
    	String google = "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe";
        try {
    		Runtime runtime = Runtime.getRuntime();     //getting Runtime object
			runtime.exec(google);
			return "Success!";
		} catch (IOException e) {
			return "fail";
		}
	}
	
	/**
	 * Mở một loại file bất kỳ nằng phần mềm mặc định trên desktop
	 * @param pathname
	 * @return
	 */
	public static String openFileType(String pathname) {
		File file = new File(pathname);
        try {
    		Desktop.getDesktop().open(file);
			return "Success!";
		} catch (IOException e) {
			return "fail";
		}
	}
	
	
	/**
	 * Mở google bằng trình duyệt với một truy vấn.
	 * @param quere: truy vấn đầu vào
	 * @return
	 */
	public static String searchGoogle(String query) {
        try{
        	String url = "https://www.google.com/search?q=" + query;
    		Runtime runtime = Runtime.getRuntime();     //getting Runtime object
        	String google = "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe";
        	String[] s ={google, url};
            runtime.exec(s);        //open
//        	Desktop.getDesktop().browse(new URI(URLDecoder.decode(url, "UTF-8"))); không sử dụng được vì có ký tự tiếng việt
        	return "Ikaros đã tìm kiếm thông tin giúp Master!";
        }catch (Exception e) {
        	e.printStackTrace();
			return "Mở trình duyệt thất bại. Master phải đảm bảo máy tính có Chrome nha!";
		}
	}
	
	/**
	 * Đọc tất cả các thẻ p trong 1 link
	 * @param link
	 * @return
	 */
	public static String linkContent(String link) {
		try {
			Document page = Jsoup.connect(link).userAgent("Mozilla/5.0").get();
			Elements contents = page.select("div > p");
			if(contents == null) return null;
			String result = page.select("title").text()+"\n";
			String rem = result; // để kiểm tra
			for (Element element : contents) {
				result += element.text();
				result += "\n\n";
			}
			if(rem.equals(result)) return null; // Không có nội dung chỉ có tiêu đề
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static String getResultGG(String query) {
		System.out.println("Truy vấn: " + query);
		String url = "https://www.google.com/search?q=" + query;
		try {
			Document ggSearch = Jsoup.connect(url).get();
			String link = "";
			Elements list = ggSearch.select("div.g > div.rc > div > a");
			for (Element element : list) {
				link = element.attr("abs:href"); // lấy url trong a[href]
				if(link.contains("wikipedia") || link.contains("yahoo") || link.contains("voz.vn")) {
					System.out.println("Loại bỏ: "+TextTools.decode(link));
					continue;
				}
				if(!link.contains("%") && !link.contains(".pdf") && !link.contains(".aspx")) { // loại link có chứa ký tự unicode hoặc .pdf -> không mở được
					System.out.println("Lấy thông tin từ: " +  link);
					String rem = linkContent(link);
					if(rem != null && !rem.isEmpty()) {
						if(link != null) System.out.println("Thành công!");
						return TextTools.std3(rem);
					}
					else System.out.println("Thất bại!");
				}
				else System.out.println("Loại bỏ: "+TextTools.decode(link));
			}
		} catch (Exception e) {
			// do nothing
		}
		String result = "Ikaros không thể truy xuất nhanh thông tin này. Ikaros sẽ mở trình duyệt giúp Master!\n";
		return result + searchGoogle(query); // Mở trình duyệt để tìm kiếm kết quả
	}
	
	/**
	 * Lấy thông tin nhanh từ google search
	 * @param question
	 * @return
	 */
	public static String quickInformation(String question) {
		String url = "https://www.google.com/search?q=" + question.trim();
		try {
			Document google = Jsoup.connect(url).get();
			String selector = CssSelectorDao.get("quick_information.txt", 1); // css selector
			if(selector == null || selector.isEmpty()) 
				return "Chức năng quick information ngừng hoạt động! Master cần liên hệ boss để được hỗ trợ!";
			Element result = google.select(selector).first();
			if(result != null) return result.text();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	/**
	 * Lấy danh sách các bài hát trong một thư mục.
	 * 
	 * @param result
	 * @param folder
	 */
	public static void listMusicInFolder(ArrayList<BookMark> result, File folder) {
		for (File fileEntry : folder.listFiles()) {
			if (fileEntry.isDirectory()) {
				listMusicInFolder(result, fileEntry);
			} else {
				if (fileEntry.getName().contains(".mp3") || fileEntry.getName().contains(".flac"))
					result.add(new BookMark(fileEntry.getName(), fileEntry.getAbsolutePath()));
			}
		}
	}
	
	
	/**
	 * Mở một bài hát bằng phần mềm mặc định trên windows
	 * 
	 * @param musicName: tên bài hát
	 * @return
	 */
	public static String openMusic(String musicName) {	
		File folder = new File(SettingDao.LoadSettingInfo().getMusicFolder());
		ArrayList<BookMark> listMusic = new ArrayList<BookMark>();
		listMusicInFolder(listMusic, folder);
		if(listMusic.isEmpty()) return null;
		File music = null;
		// tìm kiếm bài hát
		for(BookMark i:listMusic) {
			if(i.like(musicName)) {
				music = new File(i.path);
				break;
			}
		}
		if(music != null) {
			try {
				Desktop.getDesktop().open(music);
				return "Mở bài hát " + music.getName();
			} catch (Exception e) {
				return "Fail!";
			}
		}
		else return openMusicOnline(musicName);
	}
	
	
	/**
	 * Mở một bài hát bất kỳ bằng trình duyệt.
	 * @param musicName: tên bài hát
	 * @return
	 */
	public static String openMusicOnline(String musicName) {	
		String url = "https://www.nhaccuatui.com/tim-kiem?q=" + musicName;
		try{
			Document doc = Jsoup.connect(url).userAgent("Mozilla/5.0").get();
			Elements resultsList = doc.select("li.sn_search_single_song");
			Element bestResult = resultsList.first();
        	String urlMusic = bestResult.select("a[href]").first().attr("abs:href");
        	String google = "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe";
			Runtime runtime = Runtime.getRuntime();     //getting Runtime object
        	String[] s ={google, urlMusic};
            runtime.exec(s);        //open
//          Desktop.getDesktop().browse(new URI(urlMusic));
            return "Mở bài hát " + musicName + " online";
        }catch (Exception e) {
			return "Fail!";
		}
	}
	
	/**
	 * Mở một bài hát bất kỳ trong thư mục lưu trữ nhạc.
	 * @return
	 */
	public static String openRandomMusic() {
		File folder = new File(SettingDao.LoadSettingInfo().getMusicFolder());
		ArrayList<BookMark> listMusic = new ArrayList<BookMark>();
		listMusicInFolder(listMusic, folder);
		if(listMusic.isEmpty()) return null;
		int rand = rand(listMusic.size());
		File music = new File(listMusic.get(rand).path);
		try {
			Desktop.getDesktop().open(music);
		} catch (Exception e) {
			return "Fail!";
		}
		return "Mở bài hát " + music.getName();
	}
	
	/**
	 * Trả về list chủ đề âm nhạc được cập nhật vào hiện tại
	 * Dữ liệu lấy từ nhaccuatui.com
	 * @return ArrayList<BookMark>
	 */
	public static ArrayList<BookMark> ListMusicTopic() {
		ArrayList<BookMark> result = new ArrayList<BookMark>();
		String url = "https://www.nhaccuatui.com/chu-de.html";
		try {
			Document doc = Jsoup.connect(url).userAgent("Mozilla/5.0").get();
			Elements topicList = doc.select("div.topic_more > div.fram_select > ul > li");
			for (Element element : topicList) {
				String title = element.select("div.box-info-detail > h3").first().text();
				String link = element.select("a.box_absolute").first().attr("href");
//				System.out.println(title);
//				System.out.println(link);
				result.add(new BookMark(title.replace("-", ""), link));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	/**
	 * Mở 1 playlist nhạc online theo 1 chủ đề được yêu cầu.
	 * Dữ liệu lấy từ nhaccuatui.com
	 * @param theme: tên chủ đề
	 * @return
	 */
	public static String MusicTheme(String theme) {
		try {
			ArrayList<BookMark> musicTopic = ListMusicTopic();
			for (BookMark music : musicTopic) {
				if(music.like(theme)) {
					Desktop.getDesktop().browse(new URI(music.path));
					return "Mở chủ đề " + music.name;
				}
				
			}
			// Nếu không tìm thấy chủ đề có sẵn. Tìm kiếm chủ đề theo tag
			String[] tags = {"lang-man", "mua", "cafe", "buon", "nho-nhung", "co-don", "fa", "vui-ve", "hung-phan", "thu-gian", "that-tinh", "ngot-ngao"};
			String[] tagsTitle = {"Lãng Mạn", "Mưa", "Cafe", "Buồn", "Nhớ Nhung", "Cô Đơn", "Fa", "Vui Vẻ", "Hưng Phấn", "Thư Giãn", "Thất Tình", "Ngọt Ngào"};
			int n = tagsTitle.length;
			for (int i=0; i<n; i++) {
				if(theme.equalsIgnoreCase(tagsTitle[i])) {
					musicTopic = ListMusicTag(tags[i]);
					String selectedTag = tagsTitle[i]; // Lấy tên chủ đề được chọn
					if(musicTopic != null && musicTopic.size() > 0) {
						int rand = rand(musicTopic.size()); // chọn playlist ngẫu nhiên
						Desktop.getDesktop().browse(new URI(musicTopic.get(rand).path));
						return "Mở playlist " + musicTopic.get(rand).name + " trong chủ đề " + selectedTag;
					}
					return "Chủ đề ngẫu nhiên này không tìm thấy danh sách playlist!";
				}
			}
			return "Chủ đề này hiện tại không có sẵn!";
		} catch (Exception e) {
			return "Gặp lỗi khi mở chủ đề này!";
		}
	}
	
	
	/**
	 * Trả về list playlist theo tag được cập nhật vào hiện tại.
	 * Dữ liệu lấy từ nhaccuatui.com
	 * Dùng để mở random một playlist ngẫu nhiên.
	 * @param tags
	 * @return
	 */
	public static ArrayList<BookMark> ListMusicTag(String tag){
		ArrayList<BookMark> result = new ArrayList<BookMark>();
		try {
			// Lấy dữ liệu của 5 trang đầu
			for(int i = 1; i<= 5; i++) {
				String url = "https://www.nhaccuatui.com/playlist/tags/" + tag + "?page=" + String.valueOf(i);
				Document doc = Jsoup.connect(url).userAgent("Mozilla/5.0").get();
				Elements playlists = doc.select("div.list_album.tag > ul > li"); // Elements danh sách các playlist
				for (Element element : playlists) {
					String title = element.select("div.info_album > h2 > a").first().text();
					String link = element.select("div.info_album > h2 > a").first().attr("href");
//					System.out.println(title);
//					System.out.println(link);
					result.add(new BookMark(title, link));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return result;
		}
		return result;
	}
	
	
	/**
	 * Mở online một chủ đề ngẫu nhiên.
	 * Dữ liệu lấy từ nhaccuatui.
	 * Từ 1 chủ đề, lấy ra 1 playlist để phát.
	 * @return
	 */
	public static String MusicThemeRandom() {
		try {
			String[] tags = {"lang-man", "mua", "cafe", "buon", "nho-nhung", "co-don", "fa", "vui-ve", "hung-phan", "thu-gian", "that-tinh", "ngot-ngao"};
			String[] tagsTitle = {"Lãng Mạn", "Mưa", "Cafe", "Buồn", "Nhớ Nhung", "Cô Đơn", "Fa", "Vui Vẻ", "Hưng Phấn", "Thư Giãn", "Thất Tình", "Ngọt Ngào"};

			int rand = rand(tags.length); // Chọn ngẫu nhiên một chủ đề
			String selectedTag = tagsTitle[rand]; // Lấy tên chủ đề được chọn
			ArrayList<BookMark> musicTopic = ListMusicTag(tags[rand]); // lấy danh sách playlist
			if(musicTopic != null && musicTopic.size() > 0) {
				rand =  rand(musicTopic.size()); // chọn playlist ngẫu nhiên
				Desktop.getDesktop().browse(new URI(musicTopic.get(rand).path));
				return "Mở playlist " + musicTopic.get(rand).name + " trong chủ đề " + selectedTag;
			}
			return "Chủ đề ngẫu nhiên này không tìm thấy danh sách playlist!";
		} catch (Exception e) {
			return "Hệ thống playlist random hiện tại đang gặp lỗi!";
		}
	}
	
	
	/**
	 * Mở một url bất kỳ bằng trình duyệt mặc định của máy tính.
	 * @param url
	 * @return
	 */
	public static String openLink(String url) {
		try{
//			Runtime runtime = Runtime.getRuntime();     //getting Runtime object
//        	String google = "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe";
//        	String[] s ={google, url};
//            runtime.exec(s);        //open
			url = TextTools.trim(url);
			url = url.replace(" ", "%20");
            Desktop.getDesktop().browse(new URI(url));
            return "Success!";
        }catch (Exception e) {
			return "Fail!";
		}
	}
	
	
	/**
	 * Gửi email bằng phần mềm mặc định của máy tính.
	 * @param mailto: mail người nhận
	 * @param subject: tiêu đề
	 * @param content: nội dung
	 * @return
	 */
	public static String sendMail(String mailto, String subject, String content) {  
		Desktop desktop = Desktop.getDesktop();  
		String url = "";  
		subject = subject.replace(" ", "%20");
		subject = subject.replace("\n", "%0A");
		content = content.replace(" ", "%20");
		content = content.replace("\n", "%0A");
		URI mailTo;  
		try {  
			url = "mailTo:"+ mailto + "?subject=" + subject 
                      + "&body=" + content;  
			mailTo = new URI(url);  
            desktop.mail(mailTo);  
            return "Success!";
		} catch (Exception e) {  
			return "fail!"; 
        } 
	}  
	
	/**
	 * Trả về thông tin lịch chiếu phim của một rạp chiếu ở một thời gian cụ thể
	 * @param query: truy vấn đã được kiểm tra
	 * @return
	 */
	public static String showtimes(String query) {
		String url = "https://www.google.com/search?q=" + query;
		//System.out.println(url);
		try {
			String data = CssSelectorDao.get("showtime.txt", 7);
			if(data == null || data.isEmpty())
				return "Chức năng showtime ngừng hoạt động! Master cần liên hệ boss để được hỗ trợ!";
			String[] rem = data.split("[|]");
			Document google = Jsoup.connect(url).get();
			Element title = google.select(rem[0]).first(); // tên rạp
			String result = title.text() + "\n";
			Element date = google.select(rem[1]).first(); // ngày chiếu
			result += "Ngày: " + date.text() + "\n";
			Element timeline = google.select(rem[2]).first(); // thời điểm chiếu
			result += "Thời điểm: " + timeline.text() + "\n";
			Element session = google.select(rem[3]).first(); // khung data showtime
			Elements showtimesList = session.select(rem[4]); // danh sách phim
			for (Element element : showtimesList) {
				String movie = element.select(rem[5]).first().text(); // tên phim
				//System.out.println(movie);
				String time = element.select(rem[6]).first().text(); // các suất chiếu
				//System.out.println(time);
				result += movie + "\n" + time + "\n";
//				String movie = element.select("div.lr_c_tmt").first().text();
//				String time = element.select("div.lr_c_fcc.lr_c_ffo").first().text();
//				result += movie + ": " + time + "\n";
			}
			return result;
		} catch (Exception e) {
			String result = "Ikaros không thể truy xuất nhanh thông tin của rạp chiếu này. Ikaros sẽ mở trình duyệt giúp Master!\n";
			return result + Function.searchGoogle(query);
		} 
	}
	
	
	/**
	 * Tìm kiếm lời bài hát từ tên một bài hát, hoặc một đoạn nhạc.
	 * Nếu không có, mở trình duyệt để hiển thị kết quả tìm kiếm.
	 * @param musicName
	 * @return
	 */
	public static String lyric(String musicName) {
		System.out.println(musicName);
		String url = "https://www.nhaccuatui.com/tim-kiem?q=" + musicName;
		try{
			// tìm kiếm bài hát trên nhaccuatui
			Document doc = Jsoup.connect(url).userAgent("Mozilla/5.0").get();
			String data = CssSelectorDao.get("lyric.txt", 4);
			if(data == null || data.isEmpty())
				return "Chức năng lyric ngừng hoạt động! Master cần liên hệ boss để được hỗ trợ!";
			String[] rem = data.split("[|]");
			Elements searchList = doc.select(rem[0]);
			Element bestResult = searchList.first();
        	String urlMusic = bestResult.select("a[href]").first().attr("abs:href");
        	// lấy lời bài hát từ bài hát tìm được
        	Document lyricDoc = Jsoup.connect(urlMusic).userAgent("Mozilla/5.0").get();
        	String songName = lyricDoc.select(rem[1]).first().text()+"\n";
        	String composer = lyricDoc.select(rem[2]).first().text()+"\n";
        	String result = "Thông tin:\n" + songName + composer;
        	Element lyricElement = lyricDoc.getElementById(rem[3]);
        	String lyric = lyricElement.html();
        	lyric = lyric.replace("<br>", "\n");
        	System.out.println(lyric);
            return result + lyric;
        }catch (Exception e) {
        	String result = "Ikaros không thể truy xuất nhanh lời bài hát này. Ikaros sẽ mở trình duyệt giúp Master!\n";
			return result + Function.searchGoogle("Lời bài hát " + musicName);
		}
	}
	
	public static String translate(String text, String sl, String tl) {
		// sl: ngôn ngữ dịch
		// tl: ngôn ngữ để dịch
		String url = "https://vi.glosbe.com/"+sl+"/"+tl+"/"+text;
		System.out.println(url);
		String data = CssSelectorDao.get("translate.txt", 2); // lấy css data
		if(data == null || data.isEmpty())
			return "Chức năng translate ngừng hoạt động! Master cần liên hệ boss để được hỗ trợ!";
		try {
			String[] selector = data.split("[|]");
			Document GlosbeTrans = Jsoup.connect(url).userAgent("Google").get();
			Elements resultElement = GlosbeTrans.select(selector[0]);
			if(resultElement == null) {
				resultElement = GlosbeTrans.select(selector[1]);
			}
			String result = resultElement.first().text();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		String ggTrans = "https://translate.google.com/#view=home&op=translate&sl="+sl+"&tl="+tl+"&text="+text;
		return openLink(ggTrans);
	}
	
	/**
	 * Âm bip mỗi lần master gõ phím.
	 * Cho nó ngầu lòi thôi...hihi
	 */
	public static void bip() {
		try {
			File file = new File("file\\music\\bip4.wav");
		    AudioInputStream stream = AudioSystem.getAudioInputStream(file);
		    Clip clip = AudioSystem.getClip();
		    clip.open(stream);
		    clip.start();				 
		    stream.close();
		}
		catch (Exception e) {
		    e.printStackTrace();
		}
	}
	
	/**
	 * text to speech
	 * @param text
	 * @param speed
	 */
	public static void speak(String text, String speed) {
		//TODO: speak
		String texttospeechAPI = "https://texttospeech.responsivevoice.org/v1/text:synthesize?text="+text+"&lang=vi&engine=g1&name=&pitch=0.5&rate="+speed+"&volume=1&key=PL3QYYuV&gender=female";
		String googleAPI = "https://translate.google.com/translate_tts?ie=UTF-8&total=1&idx=0&client=tw-ob&tl=vi&q="+text;
		
		//TODO: Tải file về và chạy nó
		//		 String song = "http://www.ntonyx.com/mp3files/Morning_Flower.mp3";
//	        Player mp3player = null;
//	        BufferedInputStream in = null;
//	        try {
//	          in = new BufferedInputStream(new URL(song).openStream());
//	          mp3player = new Player(in);
//	          mp3player.play();
//	        } catch (MalformedURLException ex) {
//	        } catch (IOException e) {
//	        } catch (JavaLayerException e) {
//	        } catch (NullPointerException ex) {
//	        }

	}
}
