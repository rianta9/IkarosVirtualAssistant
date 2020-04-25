package com.rianta9.ikaros.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.rianta9.ikaros.bean.Master;
import com.rianta9.ikaros.dao.InfoDao;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.border.CompoundBorder;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Dimension;

/**
 * @author rianta9
 * Datecreate: 08/02/2020 09:12:36
 */
public class LoginUI extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nicknameField;
	private JPasswordField passwordField;
	private JButton btnSignIn;
	private JLabel quote2;
	private static MainUI mainUI;
	
	
	
	/**
	 * Launch the application.
	 */
	
	
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Login frame = new Login();
////					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Already there
////				    //frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
////				    frame.setUndecorated(true);
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	
	public static MainUI getMainInstance() {
		if(mainUI == null) return new MainUI();
		return mainUI;
	}
	

	/**
	 * Create the frame.
	 */
	public LoginUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setBackground(new Color(0, 0, 0));
		setTitle("ikaros.login");
		setIconImage(Toolkit.getDefaultToolkit().getImage("file\\img\\icon\\icon.png"));
		setResizable(false);
		setBounds(360, 100, 360, 486);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel loginPanel = new JPanel();
		loginPanel.setBounds(0, 0, 354, 460);
		contentPane.add(loginPanel);
		loginPanel.setBackground(new Color(31, 31, 51));
		loginPanel.setLayout(null);
		
		final JLabel lblUsername = new JLabel("Master");
		lblUsername.setBounds(38, 76, 107, 22);
		loginPanel.add(lblUsername);
		lblUsername.setFont(new Font("Forte", Font.PLAIN, 20));
		lblUsername.setForeground(new Color(51, 102, 204));
		
		final JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(38, 205, 107, 22);
		loginPanel.add(lblPassword);
		lblPassword.setForeground(new Color(51, 102, 204));
		lblPassword.setFont(new Font("Forte", Font.PLAIN, 20));
		
		btnSignIn = new JButton("Connect");
		btnSignIn.setBounds(38, 340, 278, 42);
		btnSignIn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnSignIn.setBackground(new Color(16, 78, 139));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnSignIn.setBackground(new Color(255, 0, 153));
			}
		});
		loginPanel.add(btnSignIn);
		btnSignIn.setBorder(new CompoundBorder());
		btnSignIn.setForeground(new Color(255, 255, 255));
		btnSignIn.setFont(new Font("Calibri", Font.BOLD, 18));
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Master master = InfoDao.loadMasterInfo();
				String username = nicknameField.getText();
				String password = String.valueOf(passwordField.getPassword());
				if(username == null || username.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Nickname không được để trống!", "Thông báo!", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				if(password == null || password.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Password không được để trống!", "Thông báo!", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				
				String usernameData = master.getNickname();
				String passwordData = master.getPassword();
				
				if(username.equals(usernameData) && password.equals(passwordData)) {
					mainUI = getMainInstance();
					mainUI.setVisible(true);
					dispose();
				}
				else JOptionPane.showMessageDialog(null, "Kết nối thất bại, vui lòng kiểm tra lại thông tin!", "Thông báo!", JOptionPane.ERROR_MESSAGE);
			}
		});
		btnSignIn.setBackground(new Color(255, 0, 153));
		
		JLabel lblForgetPassword = new JLabel("Quên mật khẩu?");
		lblForgetPassword.setBounds(213, 300, 84, 14);
		loginPanel.add(lblForgetPassword);
		lblForgetPassword.setForeground(new Color(255, 0, 153));
		lblForgetPassword.setFont(new Font("SansSerif", Font.ITALIC, 11));
		
		final JButton showPasswordBtn = new JButton("👀");
		showPasswordBtn.setBounds(286, 251, 29, 29);
		loginPanel.add(showPasswordBtn);
		showPasswordBtn.setFont(new Font("SansSerif", Font.BOLD, 14));
		showPasswordBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(passwordField.getEchoChar() == '*') {
					showPasswordBtn.setForeground(new Color(255, 0, 153));
					passwordField.setEchoChar((char)0);
				}
				else {
					passwordField.setEchoChar('*');
					showPasswordBtn.setForeground(new Color(51, 153, 204));
				}
			}
		});
		showPasswordBtn.setBackground(Color.WHITE);
		showPasswordBtn.setBorder(null);
		showPasswordBtn.setForeground(new Color(51, 153, 204));
		
		nicknameField = new JTextField();
		nicknameField.setBounds(38, 124, 278, 29);
		nicknameField.setBackground(Color.WHITE);
		nicknameField.setCaretColor(new Color(51, 204, 51));
		nicknameField.setBorder(null);
		nicknameField.setFont(new Font("Calibri", Font.BOLD, 16));
		nicknameField.setForeground(new Color(102, 0, 204));
		nicknameField.setSelectionColor(new Color(199, 21, 133));
		nicknameField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode() == 10) {
					passwordField.requestFocus();
				}
			}
		});
		loginPanel.add(nicknameField);
		nicknameField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(38, 251, 248, 29);
		passwordField.setBackground(Color.WHITE);
		passwordField.setCaretColor(new Color(51, 204, 51));
		passwordField.setBorder(null);
		passwordField.setEchoChar('*');
		passwordField.setFont(new Font("Calibri", Font.BOLD, 16));
		passwordField.setForeground(new Color(102, 0, 204));
		passwordField.setSelectionColor(new Color(199, 21, 133));
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode() == 10) {
					btnSignIn.doClick();
				}
			}
		});
		loginPanel.add(passwordField);
		
		quote2 = new JLabel("Hi Master ^_^");
		quote2.setBounds(0, 16, 354, 38);
		loginPanel.add(quote2);
		quote2.setHorizontalAlignment(SwingConstants.CENTER);
		quote2.setForeground(new Color(204, 0, 153));
		quote2.setFont(new Font("Forte", Font.BOLD, 32));
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(38, 280, 278, 1);
		separator_1.setForeground(Color.GRAY);
		loginPanel.add(separator_1);
		
		JLabel background = new JLabel("");
		background.setOpaque(true);
		background.setBounds(-26, 0, 380, 553);
		background.setIcon(new ImageIcon("F:\\SourcesJava\\Baitap\\Ikaros\\file\\img\\background\\ikaros_login02.jpg"));
		loginPanel.add(background);
		
		JLabel darkbackground = new JLabel("");
		darkbackground.setBounds(0, 0, 380, 484);
		loginPanel.add(darkbackground);
		darkbackground.setOpaque(true);
		darkbackground.setBackground(new Color(0, 0, 0, 128));
		
		JSeparator separator2 = new JSeparator();
		separator2.setOpaque(true);
		separator2.setForeground(Color.GRAY);
		separator2.setBounds(38, 153, 278, 1);
		loginPanel.add(separator2);
	}
}
