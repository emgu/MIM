package maps;

import java.sql.ResultSet;
import java.sql.SQLException;

import data.*;

public class MapHandler {
	static DataBase DB;
	
	public static void create(DataBase db) {
		DB = db;
	}
	
	public static int getMapSize() {
		return DB.mapSize(1); // 1 means main map
	}
	public static String fieldName(int i) {
		try {
			ResultSet res = DB.getField(i);
			res.first();
			return res.getString("name");
				
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	public static void getDesription(int mapNum, int fieldNum){
		
		try {
			ResultSet res = DB.getField(fieldNum);
			if(res.next())
				System.out.println(res.getString("description"));
		} catch (SQLException e) {
				// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
