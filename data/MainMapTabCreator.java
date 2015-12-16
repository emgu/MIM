package data;

import java.io.*;
import java.sql.*;

class MainMapTabCreator implements TabCreator {

	private String filePath;
	
	MainMapTabCreator(String path){
		this.filePath = path;
	};
	
	@Override
	public void createTab(Statement statement) {
		try {
			BufferedReader mapfields = new BufferedReader(new FileReader(this.filePath));

			String tabName = mapfields.readLine();
			String primKey = mapfields.readLine();
			
			statement.execute("DROP TABLE IF EXISTS " + tabName);
			
			statement.execute("CREATE TABLE " + tabName + " ("
					+ primKey + " BIGINT NOT NULL, "
					+ mapfields.readLine() + " BIGINT NOT NULL, "
					+ "PRIMARY KEY (" + primKey + "))"
					);
			while(mapfields.ready()){
					statement.execute("INSERT INTO " + tabName + " VALUES ('" 
					+ mapfields.readLine() + "','"
					+ mapfields.readLine() + "')");
			}
			mapfields.close();
			System.out.println("Table " + tabName +" created");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
				e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
