package com.rianta9.ikaros.view;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JScrollPane;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Dimension;

import com.rianta9.ikaros.bean.BackgroundJPanel;
import com.rianta9.ikaros.bean.RoundedBorder;
import com.rianta9.ikaros.dao.SettingDao;

import javax.swing.JLabel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
/**
 * @author rianta9
 * Datecreate: 25/08/2019 22:16:39
 */
public class NoteUI extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton saveButton;
	private JTextArea textArea;
	private JButton backButton;
	private JLabel darkScreen;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Note frame = new Note();
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
	public NoteUI() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				if(textArea.getText() != null && !textArea.getText().isEmpty()) {
					int check = JOptionPane.showConfirmDialog(NoteUI.this, "Còn note chưa được lưu. Master có muốn lưu trước khi thoát không?", "Thông báo", JOptionPane.YES_NO_OPTION);
					if(check == JOptionPane.YES_OPTION) saveButton.doClick();
				}
			}
		});
		setResizable(false);
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setFont(new Font("Calibri", Font.PLAIN, 16));
		setIconImage(Toolkit.getDefaultToolkit().getImage("file\\img\\icon\\icon5.jpg"));
		setTitle("ikaros.note");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(300, 100, 591, 408);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		contentPane = new BackgroundJPanel();
		contentPane.setForeground(new Color(139, 0, 139));
		contentPane.setBackground(Color.DARK_GRAY);
		setContentPane(contentPane);
		
		textArea = new JTextArea();
		textArea.setCaretColor(Color.WHITE);
		textArea.setSelectionColor(new Color(0, 128, 128));
		textArea.setWrapStyleWord(true);
		textArea.setOpaque(false);
		textArea.setForeground(new Color(0, 128, 128));
//		textArea.addKeyListener(new KeyAdapter() {
//			@Override
//			public void keyPressed(KeyEvent arg0) {
//				if(arg0.getKeyCode() == 10) {
//					save.doClick();
//				}
//			}
//		});
		textArea.setFont(new Font("Consolas", Font.PLAIN, 16));
		textArea.setLineWrap(true);
//		textArea.setBackground(new Color(1,1,1, (float) 0.01));
		
		JScrollPane scroll = new JScrollPane(textArea);
		scroll.setBounds(0, 0, 504, 379);
		scroll.getViewport().setOpaque(false);
		scroll.setOpaque(false);
		
		saveButton = new JButton("Save");
		saveButton.setBounds(516, 62, 59, 35);
		saveButton.setOpaque(false);
		saveButton.setBorder(new RoundedBorder(10));
		saveButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		saveButton.setForeground(new Color(255, 255, 240));
		saveButton.setBackground(new Color(255, 20, 147));
		saveButton.addActionListener(this);
		
		
		backButton = new JButton("back");
		backButton.setBounds(514, 11, 61, 35);
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textArea.getText() != null && !textArea.getText().isEmpty()) {
					int check = JOptionPane.showConfirmDialog(NoteUI.this, "Còn note chưa được lưu. Master có muốn lưu trước khi thoát không?", "Thông báo", JOptionPane.YES_NO_OPTION);
					if(check == JOptionPane.YES_OPTION) saveButton.doClick();
				}
				dispose();
			}
		});
		backButton.setOpaque(false);
		backButton.setForeground(new Color(255, 255, 255));
		backButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		backButton.setBorder(new RoundedBorder(10));
		backButton.setBackground(new Color(255, 20, 147));
		contentPane.setLayout(null);
		contentPane.add(scroll);
		
		darkScreen = new JLabel("");
		darkScreen.setOpaque(true);
		darkScreen.setBackground(new Color(0, 0, 0, 128));
		darkScreen.setBounds(0, 0, 504, 379);
		contentPane.add(darkScreen);
		contentPane.add(saveButton);
		contentPane.add(backButton);
	}
		
		
		

	@Override
	public void actionPerformed(ActionEvent e) {
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd"); 
		String name = SettingDao.LoadSettingInfo().getUrlSaveNote()+"\\";
		name += format.format(date)+".txt";
		//-----------------------
		
		File file = new File(name);
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(NoteUI.this, "Có lỗi lúc tạo file rồi Master.\nXin kiểm tra lại thư mục lưu trữ có tồn tại hay không!", "Thông báo", JOptionPane.NO_OPTION);
				return;
			}
		}
		try {
			OutputStreamWriter writer =
	             new OutputStreamWriter(new FileOutputStream(file, true), StandardCharsets.UTF_8);
			Date thoigian = new Date();
			SimpleDateFormat dinhdang = new SimpleDateFormat("HH:mm dd-MM-yyyy");
			String content = textArea.getText();
			writer.write(dinhdang.format(thoigian)+"\n"+content+"\n\n");
			textArea.setText("");
			writer.close();
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(NoteUI.this, "Có lỗi lúc lưu file rồi Master!", "Thông báo", JOptionPane.NO_OPTION);
		}
	}
}
