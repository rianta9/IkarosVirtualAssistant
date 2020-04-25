/**
 * 
 */
package com.rianta9.ikaros.view;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JButton;

import com.rianta9.ikaros.bean.RoundedBorder;
import com.rianta9.ikaros.dao.InfoDao;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @author rianta9
 * Datecreate: 16 thg 2, 2020 13:38:46
 */
public class ConfirmPasswordForSettingUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField passwordField;
	private JButton btnShowPassword;
	private static SettingUI settingUI;


	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ConfirmPasswordForSetting frame = new ConfirmPasswordForSetting();
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
	
	public static SettingUI getSettingInstance() {
		if(settingUI == null) return new SettingUI();
		return settingUI;
	}
	
	public ConfirmPasswordForSettingUI() {
		setTitle("Xác nhận mật khẩu");
		setIconImage(Toolkit.getDefaultToolkit().getImage("file\\img\\icon\\icon.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 380, 241);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(31, 31, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblconfirm = new JLabel("Nhập mật khẩu");
		lblconfirm.setForeground(new Color(0, 204, 204));
		lblconfirm.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblconfirm.setBounds(50, 38, 264, 20);
		contentPane.add(lblconfirm);
		
		passwordField = new JPasswordField();
		passwordField.setSelectionColor(new Color(199, 21, 133));
		passwordField.setOpaque(false);
		passwordField.setForeground(new Color(211, 211, 211));
		passwordField.setFont(new Font("Calibri", Font.PLAIN, 16));
		passwordField.setEchoChar('*');
		passwordField.setCaretColor(Color.WHITE);
		passwordField.setBorder(null);
		passwordField.setBounds(50, 69, 234, 29);
		contentPane.add(passwordField);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(50, 98, 264, 1);
		contentPane.add(separator);
		
		btnShowPassword = new JButton("👀");
		btnShowPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(passwordField.getEchoChar() == '*') {
					btnShowPassword.setForeground(new Color(31, 128, 128));
					passwordField.setEchoChar((char)0);
				}
				else {
					passwordField.setEchoChar('*');
					btnShowPassword.setForeground(new Color(128, 128, 128));
				}
			}
		});
		btnShowPassword.setOpaque(false);
		btnShowPassword.setForeground(Color.GRAY);
		btnShowPassword.setFont(new Font("SansSerif", Font.PLAIN, 14));
		btnShowPassword.setBorder(null);
		btnShowPassword.setBackground(Color.BLACK);
		btnShowPassword.setBounds(284, 69, 30, 30);
		contentPane.add(btnShowPassword);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String checkPassword = String.valueOf(passwordField.getPassword());
				if(checkPassword == null || checkPassword.trim().isEmpty()) {
					JOptionPane.showMessageDialog(ConfirmPasswordForSettingUI.this, "Mật khẩu không được để trống!");
					return;
				}
				String password = InfoDao.loadMasterInfo().getPassword();
				if (password.equals(checkPassword)) {
					passwordField.setText("");
					settingUI = getSettingInstance();
					settingUI.setVisible(true);
					dispose();
				}
				else JOptionPane.showMessageDialog(ConfirmPasswordForSettingUI.this, "Mật khẩu không đúng!");
			}
		});
		btnOk.setOpaque(false);
		btnOk.setForeground(new Color(255, 255, 240));
		btnOk.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnOk.setBorder(new RoundedBorder(10));
		btnOk.setBackground(new Color(255, 20, 147));
		btnOk.setBounds(159, 139, 86, 40);
		contentPane.add(btnOk);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnClose.setOpaque(false);
		btnClose.setForeground(new Color(255, 255, 240));
		btnClose.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnClose.setBorder(new RoundedBorder(10));
		btnClose.setBackground(new Color(255, 20, 147));
		btnClose.setBounds(255, 139, 86, 40);
		contentPane.add(btnClose);
	}
}
