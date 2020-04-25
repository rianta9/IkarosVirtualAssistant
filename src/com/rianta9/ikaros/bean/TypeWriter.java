/**
 * 
 */
package com.rianta9.ikaros.bean;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;
import javax.swing.Timer;

import com.rianta9.ikaros.bo.Function;

/**
 * @author rianta9
 * Datecreate: 23 thg 3, 2020 17:32:33
 */
public class TypeWriter {
    private Timer timer;
    private int characterIndex = 0;
    private String input;
    private JTextArea textArea;

    public TypeWriter(JTextArea area, String text) {
        this.textArea = area;
        this.input = text + "\n\n";
        timer = new Timer(Function.random(60)+50, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (characterIndex < input.length()) {
                    textArea.append(Character.toString(input.charAt(characterIndex)));
                    characterIndex++;
                } else {
                    stop();
                }
				
			}
        });
    }
    
    /**
     * Bắt đầu viết
     */
    public void start() {
        //textArea.setText(null);
        characterIndex = 0;
        timer.start();
    }

    public void stop() {
        timer.stop();
    }

}