/**
 * 
 */
package com.rianta9.ikaros.app;

import com.rianta9.ikaros.dao.CheckSystemDao;
import com.rianta9.ikaros.view.MainUI;
import com.rianta9.ikaros.view.SignUpUI;

/**
 * @author rianta9
 * Datecreate: 1 thg 9, 2020 20:19:19
 */
public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Cmt này chỉ để chuyển sang UTF-8 thôi ^^
		try {
			boolean isTheFirst = CheckSystemDao.checkStatus();
			if(isTheFirst) new MainUI().setVisible(true); // Test
//					if(isTheFirst) new Login().setVisible(true);
			else new SignUpUI().setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
