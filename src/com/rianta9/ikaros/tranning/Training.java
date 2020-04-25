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
import java.util.Scanner;

import com.rianta9.ikaros.bean.Reply;

/**
 * @author rianta9
 * Datecreate: 6 thg 3, 2020 19:48:10
 */
public class Training {
	public static int train(String text, String mark1, String mark2) {
		int result = 0;
		String[] pairs = text.split("["+mark1+"]");
		for (String string : pairs) {
			System.out.println("--------------");
			System.out.println(string);
		}
		return pairs.length;
	}
	
	public static void saveMess(ArrayList<Reply> list) {
		if(list == null) return;
		File file = new File("file\\training\\training.txt");
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e1) {
				System.out.println("Có lỗi khi mở file training.txt!");
				return;
			}
		}
		try {
			OutputStreamWriter writer =
	             new OutputStreamWriter(new FileOutputStream(file, false), StandardCharsets.UTF_8);
			int n = list.size();
			for(int i=0; i<n; i++) {
				writer.write(list.get(i).toString() + "\n");
			}
			writer.close();
		} catch (IOException e1) {
			System.out.println("Co loi khi luu file training.txt!");
			return;
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String text;
		Scanner nhap = new Scanner(System.in);
		ArrayList<String> list = new ArrayList<String>();
		ArrayList<Reply> listTrainning = new ArrayList<Reply>();
		System.out.print("Dữ liệu:");
		while(true) {
			text = nhap.nextLine();
			if(text.equals("end")) break;
			if(!text.trim().isEmpty()) list.add(text);
		}
		boolean fl = true; // lượt của baseMessage
		String baseMessage = null, replyMessages = null;
		for (String string : list) {
			if(fl) { // lượt của basemessage
				baseMessage = string;
				baseMessage = baseMessage.replace("•", "");
				// Lọc dữ liệu có vấn đề
				if(baseMessage.contains("-") || replyMessages != null) {
					replyMessages = null;
					continue;
				}
				// chuyển lượt
				fl = false;
			}
			else { // lượt của replymessage
				replyMessages = string;
				replyMessages = replyMessages.replace("-", "");
				replyMessages = replyMessages.replace("–", "");
				// Lọc dữ liệu có vấn đề
				if(replyMessages.contains("•") || baseMessage == null) {
					replyMessages = null;
					fl = true; // đặt lại lượt mới
					continue;
				}
				// Dữ liệu đã pass kiểm tra
				listTrainning.add(new Reply(baseMessage.trim(), replyMessages.trim()));
				fl = true; // lượt mới
				baseMessage = null; // repair
				replyMessages = null; // repair
			}
		}
		for (Reply reply : listTrainning) {
			System.out.println("---------------");
			System.out.println(reply.toString());
		}
		saveMess(listTrainning);
//		text = text.replace("\r\n", "");
//		System.out.println("Dữ liệu:" + text);
//		System.out.println("Kết quả phân tích:");
//		train(text, "•", "-");
	}

}
