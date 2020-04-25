package com.rianta9.ikaros.bean;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class BackgroundJPanel extends JPanel{   
	
	private static final long serialVersionUID = 1L;
	// The Image to store the background image in.
    Image img;
    public BackgroundJPanel(){
        // Loads the background image and stores in img object.
        img = Toolkit.getDefaultToolkit().createImage("file\\img\\background\\ikaros.png");
    }
    
    public BackgroundJPanel(String filename) {
    	img = Toolkit.getDefaultToolkit().createImage(filename);
    }
    
    public void setBg(String filename) {
    	img = Toolkit.getDefaultToolkit().createImage(filename);
    }
    
    public void paintComponent(Graphics g){
        // Draws the img to the BackgroundPanel.
    	g.drawImage(img,0,0,getWidth(),getHeight(),this);
    }
    
}