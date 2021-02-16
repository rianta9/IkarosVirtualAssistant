/**
 * 
 */
package com.rianta9.ikaros.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.rianta9.ikaros.bean.LogicReply;

/**
 * @author rianta9
 * Datecreate: 3 thg 9, 2020 17:20:14
 * Lấy dữ liệu logic từ database
 */
public class LogicData {
	public ArrayList<LogicReply> baseLogic;
	public ArrayList<LogicReply> functionLogic;
	ThietLap database;

	public LogicData() {
		database = new ThietLap();
		database.connect();
		getBaseLogicData();
	}
	
	/**
	 * Lấy dữ liệu từ database
	 */
	public void getBaseLogicData() {
		baseLogic = new ArrayList<LogicReply>();
		ResultSet data = ThietLap.getTable("DefaultLogic");
		
		try {
			while(data.next()) {
				String keywords = data.getNString("Keywords");
				String replies = data.getNString("Replies");
				baseLogic.add(new LogicReply(keywords, replies));
			}
			data.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
