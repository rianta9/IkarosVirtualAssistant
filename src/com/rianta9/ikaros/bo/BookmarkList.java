/**
 * 
 */
package com.rianta9.ikaros.bo;

import java.util.ArrayList;

import com.rianta9.ikaros.bean.BookMark;
import com.rianta9.ikaros.dao.BookmarkDao;

/**
 * @author rianta9
 * Datecreate: 1 thg 3, 2020 16:09:33
 * Quản lý bookmark của hệ thống.
 */
public class BookmarkList {
	
	/**
	 * Lấy danh sách bookmark
	 * @return
	 */
	public static ArrayList<BookMark> load(){
		return BookmarkDao.loadBookmark();
	}
	
	/**
	 * Thêm 1 bookmark vào list bookmark và lưu data.
	 * Nếu tên bookmark đó tồn tại trong list, return false.
	 * Nếu địa chỉ bookmark đó tồn tại trong list, cập nhật tên của địa chỉ đó.
	 * Nếu không, thêm bookmark vào list.
	 * @param a
	 */
	public static boolean add(BookMark a) {
		ArrayList<BookMark> list = load();
		if(list == null) list = new ArrayList<BookMark>();
		for (BookMark bookMark : list) {
			if(a.name.equalsIgnoreCase(bookMark.name)) {
				System.out.println("Tên bookmark này đã được sử dụng!");
				return false;
			}
			if(a.path.equalsIgnoreCase(bookMark.path)) {
				bookMark.name = a.name;
				save(list);
				return true;
			}
		}
		list.add(a);
		save(list);
		System.out.println("Đã add " + a.name + "|" + a.path);
		return true;
	}
	
	/**
	 * Lưu thông tin bookmark
	 */
	public static void save(ArrayList<BookMark> list) {
		BookmarkDao.saveBookmark(list);
	}
}
