package data;

import java.sql.*;

public class DBHandler {
	static DataBase DB;

	static public void createDB(String DBConfigPath){
		DB = DataBase.createDB(DBConfigPath);
	}
	
	static public void createFields (String FieldsConfigPath){
		DB.setTabCreator(new FieldsTabCreator(FieldsConfigPath));
		DB.createTab();
	};
	
	static public void createMap (String MapConfigPath){
		DB.setTabCreator(new MainMapTabCreator(MapConfigPath));
		DB.createTab();
	};
	
	static public void printField(int index){
		
		try {
			ResultSet res = DB.getField(index);
			System.out.println("-----------------");
			res.first();
			System.out.println(res.getString("mainMapFieldId"));
			System.out.println(res.getString("name"));
			
			System.out.println(res.getString("description"));
			System.out.println("-----------------");
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void create() {
		// TODO Auto-generated method stub
		
	}
	public static int mainMapSize() {
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
}
