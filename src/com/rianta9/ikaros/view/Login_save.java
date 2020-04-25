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
import java.awt.EventQueue;

/**
 * @author rianta9
 * Datecreate: 08/02/2020 09:12:36
 */
public class Login_save extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nicknameField;
	private JPasswordField passwordField;
	private JButton btnSignIn;
	private JLabel quote2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_save frame = new Login_save();
//					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Already there
//				    //frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
//				    frame.setUndecorated(true);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login_save() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setBackground(new Color(0, 0, 0));
		setTitle("ikaros.login");
		setIconImage(Toolkit.getDefaultToolkit().getImage("file\\img\\icon\\icon.png"));
		setResizable(false);
		setBounds(200, 100, 866, 486);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel overlayPanel = new JPanel();
		overlayPanel.setBackground(new Color(0, 0, 0));
		overlayPanel.setBounds(0, 0, 860, 457);
		contentPane.add(overlayPanel);
		overlayPanel.setLayout(null);
		
		JLabel lblIkaros = new JLabel("<html>\r\n<body>\r\n<span style=\"color:white\">i k</span>\r\n<span style=\"color:#dc143c\">A</span>\r\n<span>r o s</span>\r\n</body>\r\n</html>");
		lblIkaros.setBounds(10, 289, 502, 95);
		lblIkaros.setHorizontalAlignment(SwingConstants.CENTER);
		lblIkaros.setForeground(new Color(255, 228, 225));
		lblIkaros.setFont(new Font("Forte", Font.BOLD, 42));
		overlayPanel.add(lblIkaros);
		
		JLabel lblRianta = new JLabel("rianta9");
		lblRianta.setHorizontalAlignment(SwingConstants.CENTER);
		lblRianta.setForeground(new Color(255, 255, 240));
		lblRianta.setFont(new Font("Forte", Font.BOLD, 10));
		lblRianta.setBounds(10, 11, 71, 24);
		overlayPanel.add(lblRianta);
		
		JLabel lblAngeloidTypeA = new JLabel("Angeloid: Type Alpha");
		lblAngeloidTypeA.setHorizontalAlignment(SwingConstants.CENTER);
		lblAngeloidTypeA.setForeground(new Color(72, 209, 204));
		lblAngeloidTypeA.setFont(new Font("Forte", Font.BOLD, 12));
		lblAngeloidTypeA.setBounds(10, 395, 502, 14);
		overlayPanel.add(lblAngeloidTypeA);
		
		JLabel lblSoraNoOtoshimono = new JLabel("Sora no Otoshimono");
		lblSoraNoOtoshimono.setHorizontalAlignment(SwingConstants.CENTER);
		lblSoraNoOtoshimono.setForeground(new Color(72, 209, 204));
		lblSoraNoOtoshimono.setFont(new Font("Forte", Font.BOLD, 12));
		lblSoraNoOtoshimono.setBounds(10, 419, 502, 14);
		overlayPanel.add(lblSoraNoOtoshimono);
		
		JLabel darkLabel = new JLabel("");
		darkLabel.setForeground(new Color(72, 209, 204));
		darkLabel.setOpaque(true);
		darkLabel.setBounds(0, 0, 521, 460);
		overlayPanel.add(darkLabel);
		darkLabel.setBackground(new Color(0, 0, 0, 100));
		
		JPanel loginPanel = new JPanel();
		loginPanel.setOpaque(true);
		loginPanel.setBackground(new Color(31, 31, 51));
		loginPanel.setBounds(522, 0, 338, 460);
		overlayPanel.add(loginPanel);
		loginPanel.setLayout(null);
		
		final JLabel lblUsername = new JLabel("Master");
		lblUsername.setBounds(38, 76, 107, 22);
		loginPanel.add(lblUsername);
		lblUsername.setFont(new Font("Forte", Font.PLAIN, 16));
		lblUsername.setForeground(new Color(30, 144, 255));
		
		final JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(38, 205, 107, 22);
		loginPanel.add(lblPassword);
		lblPassword.setForeground(new Color(30, 144, 255));
		lblPassword.setFont(new Font("Forte", Font.PLAIN, 16));
		
		btnSignIn = new JButton("Connect");
		btnSignIn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnSignIn.setBackground(new Color(16, 78, 139));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnSignIn.setBackground(new Color(51, 153, 204));
			}
		});
		
		btnSignIn.setBounds(38, 340, 264, 42);
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
					new MainUI().setVisible(true);
					setVisible(false);
				}
				else JOptionPane.showMessageDialog(null, "Kết nối thất bại, vui lòng kiểm tra lại thông tin!", "Thông báo!", JOptionPane.ERROR_MESSAGE);
			}
		});
		btnSignIn.setBackground(new Color(51, 153, 204));
		
		JLabel lblForgetPassword = new JLabel("Quên mật khẩu?");
		lblForgetPassword.setBounds(213, 300, 84, 14);
		loginPanel.add(lblForgetPassword);
		lblForgetPassword.setForeground(new Color(0, 153, 204));
		lblForgetPassword.setFont(new Font("SansSerif", Font.ITALIC, 11));
		
		final JButton showPasswordBtn = new JButton("👀");
		showPasswordBtn.setBounds(272, 251, 30, 30);
		loginPanel.add(showPasswordBtn);
		showPasswordBtn.setFont(new Font("SansSerif", Font.PLAIN, 14));
		showPasswordBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(passwordField.getEchoChar() == '*') {
					showPasswordBtn.setForeground(new Color(31, 128, 128));
					passwordField.setEchoChar((char)0);
				}
				else {
					passwordField.setEchoChar('*');
					showPasswordBtn.setForeground(new Color(128, 128, 128));
				}
			}
		});
		showPasswordBtn.setBackground(new Color(0, 0, 0));
		showPasswordBtn.setBorder(null);
		showPasswordBtn.setOpaque(false);
		showPasswordBtn.setForeground(new Color(128, 128, 128));
		
		nicknameField = new JTextField();
		nicknameField.setCaretColor(Color.WHITE);
		nicknameField.setBorder(null);
		nicknameField.setFont(new Font("Calibri", Font.PLAIN, 16));
		nicknameField.setForeground(new Color(211, 211, 211));
		nicknameField.setSelectionColor(new Color(199, 21, 133));
		nicknameField.setOpaque(false);
		nicknameField.setBounds(38, 124, 264, 30);
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
		passwordField.setCaretColor(Color.WHITE);
		passwordField.setBorder(null);
		passwordField.setEchoChar('*');
		passwordField.setFont(new Font("Calibri", Font.PLAIN, 16));
		passwordField.setForeground(new Color(211, 211, 211));
		passwordField.setSelectionColor(new Color(199, 21, 133));
		passwordField.setOpaque(false);
		passwordField.setBounds(38, 251, 234, 29);
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
		quote2.setBounds(0, 16, 337, 38);
		loginPanel.add(quote2);
		quote2.setHorizontalAlignment(SwingConstants.CENTER);
		quote2.setForeground(new Color(199, 21, 133));
		quote2.setFont(new Font("Forte", Font.BOLD, 30));
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(38, 280, 264, 1);
		loginPanel.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(38, 153, 264, 1);
		loginPanel.add(separator_2);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("F:\\SourcesJava\\Baitap\\Ikaros\\file\\img\\background\\ikaros_login02.jpg"));
		label.setBounds(-59, 0, 415, 622);
		loginPanel.add(label);
		
		JLabel wallpaperLabel = new JLabel("");
		wallpaperLabel.setOpaque(true);
		wallpaperLabel.setBounds(-35, 0, 556, 460);
		overlayPanel.add(wallpaperLabel);
		wallpaperLabel.setIcon(new ImageIcon("file\\img\\background\\ikaros_login.png"));
	}
}
