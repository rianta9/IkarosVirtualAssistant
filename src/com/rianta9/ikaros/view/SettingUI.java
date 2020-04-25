package com.rianta9.ikaros.view;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.rianta9.ikaros.bean.BackgroundJPanel;
import com.rianta9.ikaros.bean.Master;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;

import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FileDialog;

import javax.swing.SwingConstants;

import com.rianta9.ikaros.bean.RoundedBorder;
import com.rianta9.ikaros.bean.Settings;
import com.rianta9.ikaros.dao.InfoDao;
import com.rianta9.ikaros.dao.SettingDao;

import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;


/**
 * @author rianta9
 * Datecreate: 10/02/2020 15:08:22
 */
public class SettingUI extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private Master master;
	private Settings setting;
	private JPanel panel;
	private JLabel lblUrlSaveNote;
	private JLabel lblUrlWallpaper;
	private JLabel lblMusicFolder;
	private JLabel lblTextExample;
	private JTextPane story;
	private static ChangePasswordUI changePasswordIU;
	
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Setting frame = new Setting();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	
	
	public static ChangePasswordUI getInstance() {
		if(changePasswordIU == null) return new ChangePasswordUI();
		else return changePasswordIU;
	}
	
	
	/**
	 * Create the frame.
	 */
	
	
	
	
	public SettingUI() {
		setResizable(false);
		setTitle("ikaros.setting");
		master = InfoDao.loadMasterInfo();
		setting = SettingDao.LoadSettingInfo();
		setIconImage(Toolkit.getDefaultToolkit().getImage("file\\img\\icon\\icon5.jpg"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(300, 50, 698, 660);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		contentPane = new JPanel();
		contentPane.setForeground(Color.LIGHT_GRAY);
		contentPane.setBackground(new Color(31, 31, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitle1 = new JLabel("Thông tin");
		lblTitle1.setBounds(34, 23, 213, 24);
		lblTitle1.setForeground(new Color(255, 255, 255));
		lblTitle1.setFont(new Font("Calibri", Font.BOLD, 18));
		contentPane.add(lblTitle1);
		
		JLabel lblTitle2 = new JLabel("Giao diện");
		lblTitle2.setBounds(34, 220, 213, 24);
		lblTitle2.setForeground(Color.WHITE);
		lblTitle2.setFont(new Font("Calibri", Font.BOLD, 18));
		contentPane.add(lblTitle2);
		
		JLabel lblUserName = new JLabel(master.getNickname());
		lblUserName.setHorizontalAlignment(SwingConstants.LEFT);
		lblUserName.setBounds(55, 75, 177, 14);
		lblUserName.setForeground(Color.LIGHT_GRAY);
		lblUserName.setFont(new Font("Calibri", Font.PLAIN, 16));
		contentPane.add(lblUserName);
		
		JLabel lblFullName = new JLabel(master.getFullName());
		lblFullName.setHorizontalAlignment(SwingConstants.LEFT);
		lblFullName.setBounds(55, 106, 177, 14);
		lblFullName.setForeground(Color.LIGHT_GRAY);
		lblFullName.setFont(new Font("Calibri", Font.PLAIN, 16));
		contentPane.add(lblFullName);
		
		lblUrlSaveNote = new JLabel(setting.getUrlSaveNote());
		lblUrlSaveNote.setHorizontalAlignment(SwingConstants.LEFT);
		lblUrlSaveNote.setBounds(55, 140, 394, 14);
		lblUrlSaveNote.setForeground(new Color(139, 0, 139));
		lblUrlSaveNote.setFont(new Font("Calibri", Font.PLAIN, 16));
		contentPane.add(lblUrlSaveNote);
		
		JLabel lblSex = new JLabel(master.getSex());
		lblSex.setHorizontalAlignment(SwingConstants.LEFT);
		lblSex.setBounds(261, 75, 167, 14);
		lblSex.setForeground(Color.LIGHT_GRAY);
		lblSex.setFont(new Font("Calibri", Font.PLAIN, 16));
		contentPane.add(lblSex);
		
		JLabel lblBirthday_Zodiac = new JLabel(master.getBirthDay()+" - "+master.getZodiac());
		lblBirthday_Zodiac.setHorizontalAlignment(SwingConstants.LEFT);
		lblBirthday_Zodiac.setBounds(261, 106, 167, 14);
		lblBirthday_Zodiac.setForeground(Color.LIGHT_GRAY);
		lblBirthday_Zodiac.setFont(new Font("Calibri", Font.PLAIN, 16));
		contentPane.add(lblBirthday_Zodiac);
		
		lblUrlWallpaper = new JLabel(setting.getBackgroundUrl());
		lblUrlWallpaper.setHorizontalAlignment(SwingConstants.LEFT);
		lblUrlWallpaper.setBounds(55, 346, 394, 14);
		lblUrlWallpaper.setForeground(new Color(139, 0, 139));
		lblUrlWallpaper.setFont(new Font("Calibri", Font.PLAIN, 16));
		contentPane.add(lblUrlWallpaper);
		
		lblTextExample = new JLabel("Text example for Story");
		lblTextExample.setHorizontalAlignment(SwingConstants.CENTER);
		lblTextExample.setBounds(34, 276, 369, 40);
		lblTextExample.setForeground(setting.getTextStoryColor());
		lblTextExample.setFont(new Font("Calibri", Font.PLAIN, setting.getTextSize()));
		contentPane.add(lblTextExample);
		
		lblMusicFolder = new JLabel(setting.getMusicFolder());
		lblMusicFolder.setHorizontalAlignment(SwingConstants.LEFT);
		lblMusicFolder.setForeground(new Color(139, 0, 139));
		lblMusicFolder.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblMusicFolder.setBounds(55, 176, 394, 14);
		contentPane.add(lblMusicFolder);
		
		panel = new BackgroundJPanel(setting.getBackgroundUrl());
		panel.setFont(new Font("Calibri", Font.PLAIN, 8));
		panel.setBounds(34, 390, 369, 230);
		panel.setBackground(Color.DARK_GRAY);
		contentPane.add(panel);
		panel.setLayout(null);
		
		story = new JTextPane();
		story.setFont(new Font("Calibri", Font.PLAIN, 10));
		story.setBounds(0, 0, 313, 190);
		story.setEditable(false);
		story.setBackground(new Color(0, 0, 0));
		story.setForeground(setting.getTextStoryColor());
		story.setText("Master: Làm thơ\r\n\r\nIkaros:\r\nBuồn mối tình vương một khúc thơ\r\nLòng còn lưu luyến biết bao giờ\r\nDuyên này đã lỡ người không thấu\r\nThử hỏi yêu chi để dại khờ?\r\n");
		story.setCaretColor(Color.WHITE);
		story.setOpaque(false);
		panel.add(story);
		
		JLabel darkScreen = new JLabel("");
		darkScreen.setBounds(0, 0, 313, 206);
		panel.add(darkScreen);
		darkScreen.setOpaque(true);
		darkScreen.setBackground(new Color(0, 0, 0, 128));
		
		JButton btnClear = new JButton("Clear");
		btnClear.setOpaque(false);
		btnClear.setForeground(new Color(255, 255, 240));
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 8));
		btnClear.setBorder(new RoundedBorder(10));
		btnClear.setBackground(new Color(255, 20, 147));
		btnClear.setBounds(315, 11, 51, 25);
		panel.add(btnClear);
		
		JButton btnNote = new JButton("Note");
		btnNote.setOpaque(false);
		btnNote.setForeground(new Color(255, 255, 240));
		btnNote.setFont(new Font("Tahoma", Font.BOLD, 8));
		btnNote.setBorder(new RoundedBorder(10));
		btnNote.setBackground(new Color(255, 20, 147));
		btnNote.setBounds(315, 41, 51, 25);
		panel.add(btnNote);
		
		JButton btnSetting = new JButton("Setting");
		btnSetting.setOpaque(false);
		btnSetting.setForeground(new Color(255, 255, 240));
		btnSetting.setFont(new Font("Tahoma", Font.BOLD, 8));
		btnSetting.setBorder(new RoundedBorder(10));
		btnSetting.setBackground(new Color(255, 20, 147));
		btnSetting.setBounds(315, 71, 51, 25);
		panel.add(btnSetting);
		
		textField = new JTextField();
		textField.setBorder(null);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 8));
		textField.setBounds(10, 208, 293, 14);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblIkaros = new JLabel("Ikaros:");
		lblIkaros.setForeground(new Color(127, 255, 0));
		lblIkaros.setFont(new Font("Tahoma", Font.PLAIN, 8));
		lblIkaros.setBounds(10, 192, 36, 14);
		panel.add(lblIkaros);
		
		JLabel lblHiMaster = new JLabel("Hi master ^^");
		lblHiMaster.setForeground(new Color(255, 127, 80));
		lblHiMaster.setFont(new Font("Tahoma", Font.PLAIN, 8));
		lblHiMaster.setBounds(40, 192, 255, 14);
		panel.add(lblHiMaster);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 188, 313, 2);
		panel.add(separator);
		
		JButton btnHelp = new JButton("Help");
		btnHelp.setOpaque(false);
		btnHelp.setForeground(new Color(255, 255, 240));
		btnHelp.setFont(new Font("Tahoma", Font.BOLD, 8));
		btnHelp.setBorder(new RoundedBorder(10));
		btnHelp.setBackground(new Color(255, 20, 147));
		btnHelp.setBounds(315, 103, 51, 25);
		panel.add(btnHelp);
		
		
		
		
		
		
		JButton btnApply = new JButton("Apply");
		btnApply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InfoDao.saveMasterInfo(master);
				SettingDao.SaveSettingInfo(setting);
				JOptionPane.showMessageDialog(SettingUI.this, "Các thay đổi sẽ được cập nhập trong lần đăng nhập tiếp theo!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnApply.setBounds(470, 580, 86, 40);
		btnApply.setOpaque(false);
		btnApply.setForeground(new Color(255, 255, 240));
		btnApply.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnApply.setBorder(new RoundedBorder(10));
		btnApply.setBackground(new Color(255, 20, 147));
		contentPane.add(btnApply);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnClose.setBounds(570, 580, 86, 40);
		btnClose.setOpaque(false);
		btnClose.setForeground(new Color(255, 255, 240));
		btnClose.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnClose.setBorder(new RoundedBorder(10));
		btnClose.setBackground(new Color(255, 20, 147));
		contentPane.add(btnClose);
		
		JButton btnChangePassword = new JButton("Đổi mật khẩu");
		btnChangePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changePasswordIU = getInstance();
				changePasswordIU.setVisible(true);
			}
		});
		btnChangePassword.setBounds(470, 99, 186, 24);
		btnChangePassword.setOpaque(false);
		btnChangePassword.setForeground(new Color(255, 255, 240));
		btnChangePassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnChangePassword.setBorder(new RoundedBorder(10));
		btnChangePassword.setBackground(new Color(255, 20, 147));
		contentPane.add(btnChangePassword);
		
		JButton btnChangeAdressSaveNote = new JButton("Đổi folder lưu note");
		btnChangeAdressSaveNote.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser chooser = new JFileChooser();
			    chooser.setCurrentDirectory(new File(setting.getUrlSaveNote()));
			    chooser.setDialogTitle("Chọn thư mục lưu note");
			    chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			    chooser.setAcceptAllFileFilterUsed(false);
			    int check = chooser.showOpenDialog(SettingUI.this);
			    if (check == JFileChooser.APPROVE_OPTION) {
			    	String folder = chooser.getSelectedFile().getAbsolutePath();
			    	JOptionPane.showMessageDialog(SettingUI.this, "Master đã lựa chọn thư mục: " + folder + "\nNhấn Apply để lưu thay đổi!");
			    	lblUrlSaveNote.setText(folder);
			    	setting.setUrlSaveNote(folder);
			    }
			}
		});
		btnChangeAdressSaveNote.setBounds(470, 135, 186, 24);
		btnChangeAdressSaveNote.setOpaque(false);
		btnChangeAdressSaveNote.setForeground(new Color(255, 255, 240));
		btnChangeAdressSaveNote.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnChangeAdressSaveNote.setBorder(new RoundedBorder(10));
		btnChangeAdressSaveNote.setBackground(new Color(255, 20, 147));
		contentPane.add(btnChangeAdressSaveNote);
		
		JButton btnChangeTextSize = new JButton("Đổi cỡ chữ");
		btnChangeTextSize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int fontsize = Integer.parseInt(JOptionPane.showInputDialog(SettingUI.this, "Nhập cỡ chữ"));
					if(fontsize >= 10 && fontsize <= 25) {
						lblTextExample.setFont(new Font("Tahoma", Font.BOLD, fontsize));
						setting.setTextSize(fontsize);
						SettingDao.SaveSettingInfo(setting);
					}
					else JOptionPane.showMessageDialog(SettingUI.this, "Cỡ chữ nên nằm trong khoảng từ 10 đến 25.");
				}catch (Exception e1) {
					return;
				} 
			}
		});
		btnChangeTextSize.setBounds(470, 269, 186, 24);
		btnChangeTextSize.setOpaque(false);
		btnChangeTextSize.setForeground(new Color(255, 255, 240));
		btnChangeTextSize.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnChangeTextSize.setBorder(new RoundedBorder(10));
		btnChangeTextSize.setBackground(new Color(255, 20, 147));
		contentPane.add(btnChangeTextSize);
		
		JButton btnChangeTextColor = new JButton("Đổi màu chữ");
		btnChangeTextColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color color = JColorChooser.showDialog(SettingUI.this, 
	                    "Chọn màu chữ", Color.cyan); 
				if(color != null) {
					lblTextExample.setForeground(color);
					story.setForeground(color);
					setting.setTextStoryColor(color);
					SettingDao.SaveSettingInfo(setting);
				}
			}
		});
		btnChangeTextColor.setBounds(470, 305, 186, 24);
		btnChangeTextColor.setOpaque(false);
		btnChangeTextColor.setForeground(new Color(255, 255, 240));
		btnChangeTextColor.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnChangeTextColor.setBorder(new RoundedBorder(10));
		btnChangeTextColor.setBackground(new Color(255, 20, 147));
		contentPane.add(btnChangeTextColor);
		
		JButton btnChangeBackground = new JButton("Đổi hình nền");
		btnChangeBackground.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileDialog fileDialog = new FileDialog(SettingUI.this, "Chọn hình nền", FileDialog.LOAD);
				fileDialog.setVisible(true);
				
				if(fileDialog.getFile() != null) {
					String background = fileDialog.getDirectory()+fileDialog.getFile();
					//JOptionPane.showMessageDialog(null, background);
		            setting.setBackgroundUrl(background);
		            lblUrlWallpaper.setText(background);
		            ((BackgroundJPanel) panel).setBg(background);
				}
			}
		});
		btnChangeBackground.setBounds(470, 341, 186, 24);
		btnChangeBackground.setOpaque(false);
		btnChangeBackground.setForeground(new Color(255, 255, 240));
		btnChangeBackground.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnChangeBackground.setBorder(new RoundedBorder(10));
		btnChangeBackground.setBackground(new Color(255, 20, 147));
		contentPane.add(btnChangeBackground);
		
		JButton btniThMc = new JButton("Đổi thư mục nhạc");
		btniThMc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				try {
//					UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
//				} catch (Exception e1) {
//					System.out.println("Lỗi không thể hiển thị icon windows ở đổi thư mục nhạc!");
//				}
				JFileChooser chooser = new JFileChooser();
			    chooser.setCurrentDirectory(new java.io.File(setting.getMusicFolder()));
			    chooser.setDialogTitle("Chọn thư mục nhạc");
			    chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			    chooser.setAcceptAllFileFilterUsed(false);
			    int check = chooser.showOpenDialog(SettingUI.this);
			    if (check == JFileChooser.APPROVE_OPTION) {
			    	String folder = chooser.getSelectedFile().getAbsolutePath();
			    	JOptionPane.showMessageDialog(null, "Master đã lựa chọn thư mục: " + folder + "\nNhấn Apply để lưu thay đổi!");
			    	lblMusicFolder.setText(folder);
			    	setting.setMusicFolder(folder);
			    }
			}
		});
		btniThMc.setOpaque(false);
		btniThMc.setForeground(new Color(255, 255, 240));
		btniThMc.setFont(new Font("Tahoma", Font.BOLD, 12));
		btniThMc.setBorder(new RoundedBorder(10));
		btniThMc.setBackground(new Color(255, 20, 147));
		btniThMc.setBounds(470, 171, 186, 24);
		contentPane.add(btniThMc);
		
		JLabel lblAuthor = new JLabel("Author: rianta9");
		lblAuthor.setForeground(new Color(255, 255, 204));
		lblAuthor.setFont(new Font("Consolas", Font.PLAIN, 12));
		lblAuthor.setHorizontalAlignment(SwingConstants.CENTER);
		lblAuthor.setBounds(470, 451, 186, 14);
		contentPane.add(lblAuthor);
		
		JLabel lblAuthorName = new JLabel("(Hoàng Quốc Khánh)");
		lblAuthorName.setForeground(new Color(255, 255, 204));
		lblAuthorName.setHorizontalAlignment(SwingConstants.CENTER);
		lblAuthorName.setFont(new Font("Consolas", Font.ITALIC, 12));
		lblAuthorName.setBounds(470, 476, 186, 24);
		contentPane.add(lblAuthorName);
		
	}
}
