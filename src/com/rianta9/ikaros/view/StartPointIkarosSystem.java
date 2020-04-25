/**
 * 
 */
package com.rianta9.ikaros.view;

import com.rianta9.ikaros.dao.CheckSystemDao;

/**
 * @author rianta9
 * Datecreate: 13 thg 2, 2020 02:19:18
 */
public class StartPointIkarosSystem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Cmt này chỉ để chuyển sang UTF-8 thôi ^^
		try {
			boolean isTheFirst = CheckSystemDao.checkStatus();
			if(isTheFirst) new MainUI().setVisible(true); // Test
//			if(isTheFirst) new Login().setVisible(true);
			else new SignUpUI().setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
