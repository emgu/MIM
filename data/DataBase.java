package data;

import java.io.*;
import java.sql.*;

public class DataBase {
	static DataBase inst = null;
	String url;
	String user;
	String password;
	String dbName;
	Connection conection;
	protected Statement statement;	
	
	public ResultSet result;
	// constructor
	private DataBase(String DBConfigFile){
		
		try {
			tabCreator = null;
			System.out.println("constructor of DB");
			BufferedReader dbConfigFile = new BufferedReader(new FileReader(DBConfigFile));
			this.url = dbConfigFile.readLine();
			this.user = dbConfigFile.readLine();
			this.password = dbConfigFile.readLine();
			this.dbName = dbConfigFile.readLine();
			dbConfigFile.close();
			
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			this.conection = DriverManager.getConnection(url, user, password);
			this.statement = conection.createStatement();
			
			if(!statement.executeQuery("SHOW DATABASES LIKE '" + dbName + "'").next()){
				this.statement.execute("CREATE DATABASE " + this.dbName);
			}
			this.statement.execute("USE " + this.dbName);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//Singleton
	static DataBase createDB(String DBConfigFile){
		if(inst == null){
			System.out.println("create DB attempt");
			inst = new DataBase(DBConfigFile);
			return inst;
		}
		return inst;
	}
	
	// Strategy of tab creation
	TabCreator tabCreator;// strategy
	void createTab(){
		if (tabCreator == null){
			System.out.println("tabCreator strategy not exist!!!");
			return;
		}
		tabCreator.createTab(this.statement);
	};
	void setTabCreator(TabCreator currentStrategy){
		this.tabCreator = currentStrategy;
	}
	/////////////////////////////////////////
	public ResultSet getField(int index) {
		try {
			result = statement.executeQuery("SELECT mm.mainMapFieldId, f.name, f.description "
					+ "FROM mim_mainMap AS mm, mim_fields AS f "
					+ "WHERE mm.fieldID = f.fieldID AND "
					+ "mm.mainMapFieldId = " + index);
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public int mapSize(int i) {
		try {
			result = statement.executeQuery("SELECT COUNT(*) "
					+ "FROM mim_mainMap");
			result.first();
			return result.getInt("COUNT(*)");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

}
