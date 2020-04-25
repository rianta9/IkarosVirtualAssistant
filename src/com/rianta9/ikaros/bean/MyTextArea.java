package com.rianta9.ikaros.bean;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JTextArea;

public class MyTextArea extends JTextArea {
	private static final long serialVersionUID = 1L;
	private Image img;

    public MyTextArea() {
        try{
            img = ImageIO.read(new File("file\\img\\background\\ikaros.png"));
        } catch(IOException e) {
            System.out.println(e.toString());
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
//    	g.drawImage(img, 0, 0, this);
//      g.drawImage(new ImageIcon(img).getImage(),0,0,getWidth(),getHeight(),this);
        g.drawImage(img,0,0,getWidth(),getHeight(),this);
        super.paintComponent(g);
    }
}