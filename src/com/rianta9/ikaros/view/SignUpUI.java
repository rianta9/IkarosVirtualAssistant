/**
 * 
 */
package com.rianta9.ikaros.view;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.rianta9.ikaros.bean.BackgroundJPanel;
import com.rianta9.ikaros.bean.Master;
import com.rianta9.ikaros.bo.TextTools;
import com.rianta9.ikaros.dao.CheckSystemDao;
import com.rianta9.ikaros.dao.InfoDao;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.border.CompoundBorder;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;


/**
 * @author rianta9
 * Datecreate: 13/02/2020 01:08:35
 */
public class SignUpUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField usernameField;
	private JPasswordField repeatPasswordField;
	private JTextField fullnameField;
	private JTextField birthdayField;
	private JTextField sexField;
	private JPasswordField passwordField;
	private JButton btnContinue;
	private JButton showRepeatPassword;
	private JButton showPassword;
	private static LoginUI loginUI;
	private static JLabel lblHello;
	private static JLabel lblAngeloid;
	private static JLabel lblInfo;
	/**
	 * Launch the application.
	 */
	
	
//	public static void viet(String text, JLabel label) {
//		try {
//			Thread.sleep(1000);
//			String rem = "";
//			int length = text.length();
//			for(int i=0; i<length; i++) {
//				rem += text.charAt(i);
//				Thread.sleep(150);
//				label.setText(rem);
//			}	
//		} catch(InterruptedException ex){
//		    Thread.currentThread().interrupt();
//		}
//	}
	
	public static LoginUI getLoginInstance() {
		if(loginUI == null) return new LoginUI();
		return loginUI;
	}
	
	public static void main(String[] args) {
		SignUpUI frame = new SignUpUI();
		frame.setVisible(true);
//		viet("Hi...I'm Ikaros", lblHello);
//		viet("Angeloid Type Alpha", lblAngeloid);
//		viet("Nice To Meet You", lblInfo);
	}

	/**
	 * Create the frame.
	 */
	public SignUpUI() {
		setResizable(false);
		setTitle("ikaros.signup");
		setIconImage(Toolkit.getDefaultToolkit().getImage("file\\img\\icon\\icon.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 50, 866, 588);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		contentPane = new BackgroundJPanel("file\\img\\background\\ikaros14.jpg");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 338, 561);
		panel.setLayout(null);
		panel.setOpaque(false);
		panel.setBackground(new Color(31, 31, 51));
		contentPane.add(panel);
		
		JLabel lblNickname = new JLabel("Nickname");
		lblNickname.setForeground(new Color(204, 0, 102));
		lblNickname.setFont(new Font("Forte", Font.PLAIN, 16));
		lblNickname.setBounds(38, 26, 264, 22);
		panel.add(lblNickname);
		
		JLabel lblPassword = new JLabel("Repeat Password");
		lblPassword.setForeground(new Color(204, 0, 102));
		lblPassword.setFont(new Font("Forte", Font.PLAIN, 16));
		lblPassword.setBounds(38, 396, 264, 22);
		panel.add(lblPassword);
		
		btnContinue = new JButton("Xác Lập Liên Kết");
		btnContinue.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnContinue.setBackground(new Color(16, 78, 139));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnContinue.setBackground(new Color(51, 153, 204));
			}
		});
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = usernameField.getText();
				String fullname = fullnameField.getText();
				String birthday = birthdayField.getText();
				String sex = sexField.getText();
				String password = String.valueOf(passwordField.getPassword());
				String repeatPassword = String.valueOf(repeatPasswordField.getPassword());
				if(username == null || username.isEmpty() || birthday == null || birthday.isEmpty()
				|| fullname == null || fullname.isEmpty() || sex == null || sex.isEmpty()
				|| password == null || password.isEmpty() || repeatPassword == null || repeatPassword.isEmpty()) {
					JOptionPane.showMessageDialog(SignUpUI.this, "Thông tin không được để trống!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				if(username.length() < 6) {
					JOptionPane.showMessageDialog(SignUpUI.this, "Nickname phải có độ dài tối thiểu 6 ký tự!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
					usernameField.requestFocus();
					return;
				}
				if(!TextTools.isDate(birthday, "dd/MM/yyyy") && !TextTools.isDate(birthday, "dd-MM-yyyy")) {
					JOptionPane.showMessageDialog(SignUpUI.this, "Ngày sinh không hợp lệ!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
					birthdayField.requestFocus();
					return;
				}
				if(!sex.equalsIgnoreCase("nam") && !sex.equalsIgnoreCase("nữ")
				&& !sex.equalsIgnoreCase("boy") && !sex.equalsIgnoreCase("girl")
				&& !sex.equalsIgnoreCase("khác")) {
					JOptionPane.showMessageDialog(SignUpUI.this, "Giới tính không hợp lệ!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
					sexField.requestFocus();
					return;
				}
				if(password.length() < 8 || password.length() > 22) {
					JOptionPane.showMessageDialog(SignUpUI.this, "Mật khẩu phải có độ dài từ 8 đến 22 ký tự!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
					passwordField.requestFocus();
					return;
				}
				if(!password.equals(repeatPassword)) {
					JOptionPane.showMessageDialog(SignUpUI.this, "Mật khẩu xác nhận không khớp!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
					repeatPasswordField.requestFocus();
					return;
				}
				int check = JOptionPane.showConfirmDialog(SignUpUI.this, "Thông tin cá nhân của bạn không thể thay đổi trong tương lai.\nBạn xác nhận không kiểm tra lại thông tin?", "Xác nhận", JOptionPane.YES_NO_OPTION);
				if (check == JOptionPane.YES_OPTION) {
					try {
						if(CheckSystemDao.checkStatus()) {
							JOptionPane.showMessageDialog(SignUpUI.this, "Xin lỗi...Ikaros đã có chủ nhân!\nKhông thể xác lập kết nối khác!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
							return;
						}
						Master master = new Master(username, password, fullname, sex, birthday);
						InfoDao.saveMasterInfo(master);
						CheckSystemDao.updateStatus(1);
						JOptionPane.showMessageDialog(SignUpUI.this, "Xác lập liên kết thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
						// Tránh lặp lại instance
						loginUI = getLoginInstance();
						loginUI.setVisible(true);
						dispose();
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(SignUpUI.this, "Xác lập liên kết thất bại!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
					}					
				}
			}
		});
		btnContinue.setForeground(Color.WHITE);
		btnContinue.setFont(new Font("Calibri", Font.BOLD, 18));
		btnContinue.setBorder(new CompoundBorder());
		btnContinue.setBackground(new Color(51, 153, 204));
		btnContinue.setBounds(38, 480, 264, 42);
		panel.add(btnContinue);
		
		showRepeatPassword = new JButton("👀");
		showRepeatPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(repeatPasswordField.getEchoChar() == '*') {
					showRepeatPassword.setForeground(new Color(204, 0, 102));
					repeatPasswordField.setEchoChar((char)0);
				}
				else {
					repeatPasswordField.setEchoChar('*');
					showRepeatPassword.setForeground(new Color(128, 128, 128));
				}
			}
		});
		showRepeatPassword.setOpaque(false);
		showRepeatPassword.setForeground(Color.GRAY);
		showRepeatPassword.setFont(new Font("SansSerif", Font.PLAIN, 14));
		showRepeatPassword.setBorder(null);
		showRepeatPassword.setBackground(Color.BLACK);
		showRepeatPassword.setBounds(272, 429, 30, 30);
		panel.add(showRepeatPassword);
		
		usernameField = new JTextField();
		usernameField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				usernameField.setText("");
			}
		});
		usernameField.setText("Nhập nickname của bạn");
		usernameField.setSelectionColor(new Color(199, 21, 133));
		usernameField.setOpaque(false);
		usernameField.setForeground(new Color(255, 0, 153));
		usernameField.setFont(new Font("Calibri", Font.PLAIN, 16));
		usernameField.setColumns(10);
		usernameField.setCaretColor(new Color(255, 0, 102));
		usernameField.setBorder(null);
		usernameField.setBounds(38, 59, 264, 30);
		panel.add(usernameField);
		
		repeatPasswordField = new JPasswordField();
		repeatPasswordField.setSelectionColor(new Color(199, 21, 133));
		repeatPasswordField.setOpaque(false);
		repeatPasswordField.setForeground(new Color(255, 0, 153));
		repeatPasswordField.setFont(new Font("Calibri", Font.PLAIN, 16));
		repeatPasswordField.setEchoChar('*');
		repeatPasswordField.setCaretColor(new Color(255, 0, 102));
		repeatPasswordField.setBorder(null);
		repeatPasswordField.setBounds(38, 429, 234, 29);
		panel.add(repeatPasswordField);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(38, 458, 264, 1);
		panel.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(38, 88, 264, 1);
		panel.add(separator_1);
		
		JLabel lblFullname = new JLabel("Fullname");
		lblFullname.setForeground(new Color(204, 0, 102));
		lblFullname.setFont(new Font("Forte", Font.PLAIN, 16));
		lblFullname.setBounds(38, 100, 264, 22);
		panel.add(lblFullname);
		
		fullnameField = new JTextField();
		fullnameField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				fullnameField.setText("");
			}
		});
		fullnameField.setText("Nhập họ tên đầy đủ của bạn");
		fullnameField.setSelectionColor(new Color(199, 21, 133));
		fullnameField.setOpaque(false);
		fullnameField.setForeground(new Color(255, 0, 153));
		fullnameField.setFont(new Font("Calibri", Font.PLAIN, 16));
		fullnameField.setColumns(10);
		fullnameField.setCaretColor(new Color(255, 0, 102));
		fullnameField.setBorder(null);
		fullnameField.setBounds(38, 133, 264, 30);
		panel.add(fullnameField);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(38, 162, 264, 1);
		panel.add(separator_2);
		
		JLabel lblBirthday = new JLabel("Birthday");
		lblBirthday.setForeground(new Color(204, 0, 102));
		lblBirthday.setFont(new Font("Forte", Font.PLAIN, 16));
		lblBirthday.setBounds(38, 174, 264, 22);
		panel.add(lblBirthday);
		
		birthdayField = new JTextField();
		birthdayField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				birthdayField.setText("");
			}
		});
		birthdayField.setText("Ex: 31/12/1999");
		birthdayField.setSelectionColor(new Color(199, 21, 133));
		birthdayField.setOpaque(false);
		birthdayField.setForeground(new Color(255, 0, 153));
		birthdayField.setFont(new Font("Calibri", Font.PLAIN, 16));
		birthdayField.setColumns(10);
		birthdayField.setCaretColor(new Color(255, 0, 102));
		birthdayField.setBorder(null);
		birthdayField.setBounds(38, 207, 264, 30);
		panel.add(birthdayField);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(38, 236, 264, 1);
		panel.add(separator_3);
		
		JLabel lblSex = new JLabel("Sex");
		lblSex.setForeground(new Color(204, 0, 102));
		lblSex.setFont(new Font("Forte", Font.PLAIN, 16));
		lblSex.setBounds(38, 248, 264, 22);
		panel.add(lblSex);
		
		sexField = new JTextField();
		sexField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				sexField.setText("");
			}
		});
		sexField.setText("Ex: girl");
		sexField.setSelectionColor(new Color(199, 21, 133));
		sexField.setOpaque(false);
		sexField.setForeground(new Color(255, 0, 153));
		sexField.setFont(new Font("Calibri", Font.PLAIN, 16));
		sexField.setColumns(10);
		sexField.setCaretColor(new Color(255, 0, 102));
		sexField.setBorder(null);
		sexField.setBounds(38, 281, 264, 30);
		panel.add(sexField);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(38, 310, 264, 1);
		panel.add(separator_4);
		
		showPassword = new JButton("👀");
		showPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(passwordField.getEchoChar() == '*') {
					showPassword.setForeground(new Color(204, 0, 102));
					passwordField.setEchoChar((char)0);
				}
				else {
					passwordField.setEchoChar('*');
					showPassword.setForeground(new Color(128, 128, 128));
				}
			}
		});
		showPassword.setOpaque(false);
		showPassword.setForeground(Color.GRAY);
		showPassword.setFont(new Font("SansSerif", Font.PLAIN, 14));
		showPassword.setBorder(null);
		showPassword.setBackground(Color.BLACK);
		showPassword.setBounds(272, 355, 30, 30);
		panel.add(showPassword);
		
		passwordField = new JPasswordField();
		passwordField.setToolTipText("");
		passwordField.setSelectionColor(new Color(199, 21, 133));
		passwordField.setOpaque(false);
		passwordField.setForeground(new Color(255, 0, 153));
		passwordField.setFont(new Font("Calibri", Font.PLAIN, 16));
		passwordField.setEchoChar('*');
		passwordField.setCaretColor(new Color(255, 0, 102));
		passwordField.setBorder(null);
		passwordField.setBounds(38, 355, 234, 29);
		panel.add(passwordField);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(38, 384, 264, 1);
		panel.add(separator_5);
		
		JLabel label = new JLabel("Password");
		label.setForeground(new Color(204, 0, 102));
		label.setFont(new Font("Forte", Font.PLAIN, 16));
		label.setBounds(38, 322, 264, 22);
		panel.add(label);
		
		lblHello = new JLabel("Hi...I'm Ikaros");
		lblHello.setForeground(new Color(204, 0, 102));
		lblHello.setFont(new Font("Forte", Font.BOLD, 42));
		lblHello.setHorizontalAlignment(SwingConstants.CENTER);
		lblHello.setBounds(348, 294, 502, 56);
		contentPane.add(lblHello);
		
		lblAngeloid = new JLabel("Angeloid Type Alpha");
		lblAngeloid.setHorizontalAlignment(SwingConstants.CENTER);
		lblAngeloid.setForeground(new Color(51, 153, 204));
		lblAngeloid.setFont(new Font("Forte", Font.BOLD, 22));
		lblAngeloid.setBounds(348, 361, 502, 28);
		contentPane.add(lblAngeloid);
		
		lblInfo = new JLabel("Nice To Meet You ^^");
		lblInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfo.setForeground(new Color(153, 0, 153));
		lblInfo.setFont(new Font("Forte", Font.BOLD, 26));
		lblInfo.setBounds(348, 400, 502, 28);
		contentPane.add(lblInfo);
	}
}
