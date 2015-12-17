package data;

import java.sql.*;

public class DBHandler {
	static DataBase DB;

	static public void createDB(String DBConfigPath){
		DB = DataBase.createDB(DBConfigPath);
	}
	static public DataBase getDB(){
		return DB;
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
	
}
