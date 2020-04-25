package com.rianta9.ikaros.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;

import com.rianta9.ikaros.bean.Master;
import com.rianta9.ikaros.bean.RoundedBorder;
import com.rianta9.ikaros.dao.InfoDao;

import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


/**
 * @author rianta9
 * Datecreate: 12/02/2020 22:12:02
 */
public class ChangePasswordUI extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField oldPassword;
	private JPasswordField newPassword;
	private JPasswordField repeatNewPassword;
	private JButton btnSave;
	private JButton showOldPassword;
	private JButton showNewPassword;
	private JButton showRepeatNewPassword;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ChangePassword frame = new ChangePassword();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	
	
	public ChangePasswordUI() {
		setTitle("Đổi mật khẩu");
		setIconImage(Toolkit.getDefaultToolkit().getImage("file\\img\\icon\\icon.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 380, 380);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(31, 31, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNhpMtKhu = new JLabel("Nhập mật khẩu cũ");
		lblNhpMtKhu.setForeground(new Color(0, 204, 204));
		lblNhpMtKhu.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblNhpMtKhu.setBounds(50, 36, 264, 20);
		contentPane.add(lblNhpMtKhu);
		
		JLabel lblNhpMtKhu_1 = new JLabel("Nhập mật khẩu mới");
		lblNhpMtKhu_1.setForeground(new Color(0, 204, 204));
		lblNhpMtKhu_1.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblNhpMtKhu_1.setBounds(50, 109, 264, 20);
		contentPane.add(lblNhpMtKhu_1);
		
		JLabel lblXcNhnMt = new JLabel("Xác nhận mật khẩu mới");
		lblXcNhnMt.setForeground(new Color(0, 204, 204));
		lblXcNhnMt.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblXcNhnMt.setBounds(50, 190, 264, 20);
		contentPane.add(lblXcNhnMt);
		
		btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Master master = InfoDao.loadMasterInfo();
				String oldpass = String.valueOf(oldPassword.getPassword());
				String newpass = String.valueOf(newPassword.getPassword());
				String repnewpass = String.valueOf(repeatNewPassword.getPassword());
								
				if(oldpass == null || oldpass.isEmpty() || newpass == null || newpass.isEmpty() || repnewpass == null || repnewpass.isEmpty() ) {
					JOptionPane.showMessageDialog(ChangePasswordUI.this, "Mật khẩu không được để trống!", "Thông báo!", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				
				if(newpass.length() < 8 || newpass.length() > 22) {
					JOptionPane.showMessageDialog(ChangePasswordUI.this, "Độ dài mật khẩu phải từ 8 đến 22 ký tự", "Thông báo!", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				
				if(!newpass.equals(repnewpass)) {
					JOptionPane.showMessageDialog(ChangePasswordUI.this, "Mật khẩu xác nhận không khớp với mật khẩu mới!", "Thông báo!", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				
				if(newpass.equals(oldpass)) {
					JOptionPane.showMessageDialog(ChangePasswordUI.this, "Mật khẩu mới không được trùng với mật khẩu cũ!", "Thông báo!", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				
				String passwordData = master.getPassword();
				if(oldpass.equals(passwordData)) {
					master.setPassword(newpass);
					InfoDao.saveMasterInfo(master);
					oldPassword.setText("");
					newPassword.setText("");
					repeatNewPassword.setText("");
					JOptionPane.showMessageDialog(ChangePasswordUI.this, "Đổi mật khẩu thành công!");
				}
				else JOptionPane.showMessageDialog(ChangePasswordUI.this, "Mật khẩu cũ không chính xác!", "Thông báo!", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnSave.setOpaque(false);
		btnSave.setForeground(new Color(255, 255, 240));
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSave.setBorder(new RoundedBorder(10));
		btnSave.setBackground(new Color(255, 20, 147));
		btnSave.setBounds(157, 278, 86, 40);
		contentPane.add(btnSave);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnClose.setOpaque(false);
		btnClose.setForeground(new Color(255, 255, 240));
		btnClose.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnClose.setBorder(new RoundedBorder(10));
		btnClose.setBackground(new Color(255, 20, 147));
		btnClose.setBounds(253, 278, 86, 40);
		contentPane.add(btnClose);
		
		showOldPassword = new JButton("👀");
		showOldPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(oldPassword.getEchoChar() == '*') {
					showOldPassword.setForeground(new Color(31, 128, 128));
					oldPassword.setEchoChar((char)0);
				}
				else {
					oldPassword.setEchoChar('*');
					showOldPassword.setForeground(new Color(128, 128, 128));
				}
			}
		});
		
		showOldPassword.setOpaque(false);
		showOldPassword.setForeground(Color.GRAY);
		showOldPassword.setFont(new Font("SansSerif", Font.PLAIN, 14));
		showOldPassword.setBorder(null);
		showOldPassword.setBackground(Color.BLACK);
		showOldPassword.setBounds(284, 67, 30, 30);
		contentPane.add(showOldPassword);
		
		oldPassword = new JPasswordField();
		oldPassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode() == 10) {
					newPassword.requestFocus();
				}
			}
		});
		oldPassword.setSelectionColor(new Color(199, 21, 133));
		oldPassword.setOpaque(false);
		oldPassword.setForeground(new Color(211, 211, 211));
		oldPassword.setFont(new Font("Calibri", Font.PLAIN, 16));
		oldPassword.setEchoChar('*');
		oldPassword.setCaretColor(Color.WHITE);
		oldPassword.setBorder(null);
		oldPassword.setBounds(50, 67, 234, 29);
		contentPane.add(oldPassword);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(50, 96, 264, 1);
		contentPane.add(separator);
		
		showNewPassword = new JButton("👀");
		showNewPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(newPassword.getEchoChar() == '*') {
					showNewPassword.setForeground(new Color(31, 128, 128));
					newPassword.setEchoChar((char)0);
				}
				else {
					newPassword.setEchoChar('*');
					showNewPassword.setForeground(new Color(128, 128, 128));
				}
			}
		});
		showNewPassword.setOpaque(false);
		showNewPassword.setForeground(Color.GRAY);
		showNewPassword.setFont(new Font("SansSerif", Font.PLAIN, 14));
		showNewPassword.setBorder(null);
		showNewPassword.setBackground(Color.BLACK);
		showNewPassword.setBounds(284, 140, 30, 30);
		contentPane.add(showNewPassword);
		
		newPassword = new JPasswordField();
		newPassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == 10) {
					repeatNewPassword.requestFocus();
				}
			}
		});
		newPassword.setSelectionColor(new Color(199, 21, 133));
		newPassword.setOpaque(false);
		newPassword.setForeground(new Color(211, 211, 211));
		newPassword.setFont(new Font("Calibri", Font.PLAIN, 16));
		newPassword.setEchoChar('*');
		newPassword.setCaretColor(Color.WHITE);
		newPassword.setBorder(null);
		newPassword.setBounds(50, 140, 234, 29);
		contentPane.add(newPassword);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(50, 169, 264, 1);
		contentPane.add(separator_1);
		
		showRepeatNewPassword = new JButton("👀");
		
		showRepeatNewPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(repeatNewPassword.getEchoChar() == '*') {
					showRepeatNewPassword.setForeground(new Color(31, 128, 128));
					repeatNewPassword.setEchoChar((char)0);
				}
				else {
					repeatNewPassword.setEchoChar('*');
					showRepeatNewPassword.setForeground(new Color(128, 128, 128));
				}
			}
		});
		showRepeatNewPassword.setOpaque(false);
		showRepeatNewPassword.setForeground(Color.GRAY);
		showRepeatNewPassword.setFont(new Font("SansSerif", Font.PLAIN, 14));
		showRepeatNewPassword.setBorder(null);
		showRepeatNewPassword.setBackground(Color.BLACK);
		showRepeatNewPassword.setBounds(284, 221, 30, 30);
		contentPane.add(showRepeatNewPassword);
		
		repeatNewPassword = new JPasswordField();
		repeatNewPassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == 10) {
					btnSave.doClick();
				}
			}
		});
		repeatNewPassword.setSelectionColor(new Color(199, 21, 133));
		repeatNewPassword.setOpaque(false);
		repeatNewPassword.setForeground(new Color(211, 211, 211));
		repeatNewPassword.setFont(new Font("Calibri", Font.PLAIN, 16));
		repeatNewPassword.setEchoChar('*');
		repeatNewPassword.setCaretColor(Color.WHITE);
		repeatNewPassword.setBorder(null);
		repeatNewPassword.setBounds(50, 221, 234, 29);
		contentPane.add(repeatNewPassword);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(50, 250, 264, 1);
		contentPane.add(separator_2);
	}

}
