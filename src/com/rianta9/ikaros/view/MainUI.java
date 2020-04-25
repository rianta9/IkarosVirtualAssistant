package com.rianta9.ikaros.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JButton;

import com.rianta9.ikaros.bean.BackgroundJPanel;
import com.rianta9.ikaros.bean.Master;
import com.rianta9.ikaros.bean.Bot;
import com.rianta9.ikaros.bean.RoundedBorder;
import com.rianta9.ikaros.bean.Settings;
import com.rianta9.ikaros.bean.TypeWriter;
import com.rianta9.ikaros.bo.IkarosSystem;
import com.rianta9.ikaros.bo.TextTools;
import com.rianta9.ikaros.dao.InfoDao;
import com.rianta9.ikaros.dao.SettingDao;

import javax.swing.JScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JLabel;
import javax.swing.border.BevelBorder;

/**
 * @author rianta9
 * Datecreate: 12/01/2020 22:21:29
 */
public class MainUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		
	private JPanel contentPane;
	private JButton clearButton;
	private JTextArea Story;
	private JTextField userMessage;
	private JLabel systemName;
	public JLabel repContent;	
	private JLabel darkScreen;
	private JLabel darkLine;
	private JButton btnHelp;
	
	private static IkarosSystem ikaros;
	private Master Master;
	private Bot hethong;
	private Settings setting;
	private boolean isMess;
	private static ConfirmPasswordForSettingUI confirmPasswordST;
	private static NoteUI noteUI;
	private TypeWriter typeWriter;
	

/**
 * ╔♫�?╗╔╗ �?�
 * ╚╗╔�?║║♫�?╦╦╦╔╗
 * ╔�?╚╗♫╚╣║║║║╔╣
 * ╚�?♫�?╚�?╩�?╩♫╩�?�?
   * ஜ۩۞۩ஜ YOU ஜ۩۞۩ஜ
 * 
 * @author rianta9
 * Date created: 13/06/2019
 * Note: Hoàn thành sớm rồi gửi cho bé <3
 * Code with all my heart <3
 * 
 * �? tưởng:
 * 
 * Tính điểm từng tin nhắn
 * Phân vai trong từng câu(m là ai| bạn là ai| em là ai| anh là ai...dùng 'm' => bạn, em, anh...replace)
 * Xem th�?i gian, kịch bản rep theo th�?i gian
 * Chúc ngủ ngon
 * Bớt nói xàm, nhất là với những tin nhắn buồn
 * Chia file rep theo các cấp độ cảm xúc
 * Bảo mật cho file, có biện pháp nếu bị mất dữ liệu
 * @throws InterruptedException 
*/
	
//	public void viet(String ans) {
//		String rem = "";
//		int length = ans.length();
//		for(int i=0; i<length; i++) {
//			rem += ans.charAt(i);
//			
//			try {
//				Thread.sleep(50);
//				lblNewLabel_1.setText(rem);
//			} catch(InterruptedException ex){
//			    Thread.currentThread().interrupt();
//			}
//		}	
//	}
	
	
	
	/**
	 * Tìm câu trả lời từ ikaros system, hiển thị câu trả lời.
	 * Với đầu vào mess, kiểm tra mess có null hoặc rỗng hay không.
	 * Nếu ko bị lỗi, kiểm tra đây có phải là một tin nhắn hay không.
	 * Nếu là tin nhắn thì phản hồi tin nhắn.
	 * Nếu ko thì đó là 1 training, training data cho reply.
	 * @param mess
	 */
	
	public static ConfirmPasswordForSettingUI getSettingInstance() {
		if(confirmPasswordST == null) return new ConfirmPasswordForSettingUI();
		return confirmPasswordST;
	}
	public static NoteUI getNoteInstance() {
		if(noteUI == null) return new NoteUI();
		return noteUI;
	}
	
	public void traLoi(String mess) {
		if(mess == null || mess.trim().isEmpty()) return;
		mess = mess.trim();
		if(isMess) { // Nếu đây là 1 tin nhắn
			Story.append(Master.getNickname() + ": " + mess + "\n"); // Thêm mess vào story
			String replyMessage = ikaros.answerMessage(mess); // Lấy câu trả lời
			if(replyMessage == null) {
				Story.append(TextTools.trainingNote() + "\n");
				repContent.setText("Gợi ý cho ikaros 1 câu trả lời đi ạ ^^");
				isMess = false; // Lượt tin nhắn tiếp theo mặc định là tin nhắn training
			}
			else {
				if(ikaros.useFunction) {
					repContent.setText("Đã truy xuất thông tin!");
					ikaros.useFunction = false;
				}
				else repContent.setText(replyMessage);
				Story.append(hethong.getNickname() + ": ");
				int repLen = replyMessage.length();
				if(repLen > 100)
					Story.append(replyMessage+"\n\n");
				else {
					typeWriter = new TypeWriter(Story, replyMessage);
					typeWriter.start();
				}
				
			}
		}
		else { // Nếu không thì đó là 1 đoạn text training
			if(!mess.equalsIgnoreCase("no")) {
				if(ikaros.remember != null) {
					ikaros.remember.addAnswer(mess); // Training cho ikaros
					ikaros.saveData(); // Tạo lại file data
				}
				else {
					ikaros.newApplyData.addAnswer(mess); // Training cho newApplyData
					ikaros.addData(ikaros.newApplyData); // Thêm dữ liệu mới vào list data và cập nhật file.
				}
				repContent.setText("ikaros đã train xong rồi ạ ^^");
				Story.append("  ikaros đã train xong rồi ạ ^^\n\n");
			}
			else{
				repContent.setText("Đã hủy bỏ training!");
				Story.append(" >_Đã hủy bỏ training!\n\n");
			}
			isMess = true; // reset isMess
			ikaros.remember = null; // reset remember
			ikaros.newApplyData = null; // reset newApplyData
		}
		// Luôn đặt view story ở cuối Story
		Story.setCaretPosition(Story.getText().length());
	}
	
	
	public void loadSetting() {
		Master = InfoDao.loadMasterInfo();
		setting = SettingDao.LoadSettingInfo();
		((BackgroundJPanel) contentPane).setBg(setting.getBackgroundUrl());
		Story.setFont(new Font("Calibri", Font.PLAIN, setting.getTextSize()));
		Story.setForeground(setting.getTextStoryColor());
		userMessage.setFont(new Font("Calibri", Font.PLAIN, setting.getTextSize()));
		userMessage.setForeground(setting.getTextStoryColor());
	}
	
//	public static void main(String[] args) {
//		frame = new Main();
//		frame.setVisible(true);
//	}

	
	
	
	/**
	 * Create the frame.
	 */
	
	public MainUI() {
		setResizable(false);
		/*Add bot system*/
		ikaros = new IkarosSystem();
		Master = InfoDao.loadMasterInfo();
		hethong = new Bot();
		isMess = true;
		setFont(new Font("Calibri", Font.PLAIN, 16));
		setIconImage(Toolkit.getDefaultToolkit().getImage("file\\img\\icon\\icon5.jpg"));
		setTitle("ikaros");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 50, 698, 580);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		/*-----------------------------------------------------------*/
		contentPane = new BackgroundJPanel(SettingDao.LoadSettingInfo().getBackgroundUrl());
		contentPane.setForeground(new Color(139, 0, 139));
		contentPane.setBackground(Color.DARK_GRAY);
		setContentPane(contentPane);
		
		
		Story = new JTextArea();
		Story.setCaretColor(Color.WHITE);
		Story.setTabSize(4);
		Story.setEditable(false);
		Story.setWrapStyleWord(true);
		Story.setOpaque(false);
		
//		textArea.addKeyListener(new KeyAdapter() {
//			@Override
//			public void keyPressed(KeyEvent arg0) {
//				if(arg0.getKeyCode() == 10) {
//					save.doClick();
//				}
//			}
//		});
		Story.setFont(new Font("Calibri", Font.PLAIN, 16));
		Story.setForeground(new Color(0, 255, 255));
		Story.setLineWrap(true);
		
		//colorGroup = new ButtonGroup();
		
		//backgroundGroup = new ButtonGroup();
		
		
//		textArea.setBackground(new Color(1,1,1, (float) 0.01));
		
		JScrollPane scroll = new JScrollPane(Story);
		scroll.setBackground(Color.DARK_GRAY);
		scroll.setBounds(0, 0, 601, 458);
		scroll.getViewport().setOpaque(false);
		scroll.setOpaque(false);
		
		clearButton = new JButton("Clear");
		clearButton.setBounds(611, 11, 71, 40);
		clearButton.setOpaque(false);
		clearButton.setBorder(new RoundedBorder(10));
		clearButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		clearButton.setForeground(new Color(255, 255, 240));
		clearButton.setBackground(new Color(255, 20, 147));
		clearButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Story.setText("");
				loadSetting();
			}
		});
		
		userMessage = new JTextField();
		userMessage.setCaretColor(new Color(255, 0, 102));
		userMessage.setFont(new Font("Consolas", Font.BOLD, 14));
		userMessage.setForeground(new Color(51, 204, 204));
		userMessage.setOpaque(false);
		userMessage.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		userMessage.setBounds(0, 508, 600, 32);
		userMessage.requestFocus();
		userMessage.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode() == 10) {
					String mess = userMessage.getText();
					userMessage.setText("");
					traLoi(mess);
				}
			}
		});
		
		
		systemName = new JLabel(hethong.getNickname()+ ": ");
		systemName.setBounds(10, 457, 71, 52);
		systemName.setFont(new Font("Tahoma", Font.BOLD, 13));
		systemName.setForeground(new Color(102, 204, 51));
		
		repContent = new JLabel("Hi Master <3");
		repContent.setBounds(85, 457, 504, 52);
		repContent.setForeground(new Color(204, 0, 102));
		
		JButton noteUIButton = new JButton("Note");
		noteUIButton.setBounds(611, 62, 71, 40);
		noteUIButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				noteUI = getNoteInstance();
				noteUI.setVisible(true);
			}
		});
		noteUIButton.setOpaque(false);
		noteUIButton.setForeground(new Color(255, 255, 240));
		noteUIButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		noteUIButton.setBorder(new RoundedBorder(10));
		noteUIButton.setBackground(new Color(255, 20, 147));
		contentPane.setLayout(null);
		contentPane.add(scroll);
		
		darkScreen = new JLabel("");
		darkScreen.setOpaque(true);
		darkScreen.setBackground(new Color(0, 0, 0, 128));
		darkScreen.setBounds(0, 0, 601, 458);
		contentPane.add(darkScreen);
		contentPane.add(clearButton);
		contentPane.add(noteUIButton);
		contentPane.add(systemName);
		contentPane.add(repContent);
		contentPane.add(userMessage);
		
		darkLine = new JLabel("");
		darkLine.setBackground(new Color(0, 0, 0, 128));
		darkLine.setOpaque(true);
		darkLine.setBounds(0, 457, 600, 52);
		contentPane.add(darkLine);
		
		JButton settingButton = new JButton("Setting");
		settingButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				confirmPasswordST = getSettingInstance();
				confirmPasswordST.setVisible(true);
			}
		});
		settingButton.setOpaque(false);
		settingButton.setForeground(new Color(255, 255, 240));
		settingButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		settingButton.setBorder(new RoundedBorder(10));
		settingButton.setBackground(new Color(255, 20, 147));
		settingButton.setBounds(611, 113, 71, 40);
		contentPane.add(settingButton);
		
		btnHelp = new JButton("Help");
		btnHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Story.setText(TextTools.help());
			}
		});
		btnHelp.setOpaque(false);
		btnHelp.setForeground(new Color(255, 255, 240));
		btnHelp.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnHelp.setBorder(new RoundedBorder(10));
		btnHelp.setBackground(new Color(255, 20, 147));
		btnHelp.setBounds(611, 164, 71, 40);
		contentPane.add(btnHelp);
		loadSetting(); // load setting
	}
}
