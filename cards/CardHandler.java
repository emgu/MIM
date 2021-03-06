package cards;

import java.sql.*;
import data.*;

public class CardHandler {
	
	static DataBase DB;
	
	public static void create(DataBase db) {
		DB = db;
	}
	
	static public void printCard(int cardId){
		try {
			ResultSet card = DB.getCard(cardId);
			System.out.println("----ADVENTURE----");
			card.first();
			System.out.println("   - " + card.getString("advCardType") + " - ");
			System.out.println("");
			System.out.println(card.getString("advCardName"));
			System.out.println("");
			System.out.println(card.getString("advCardDescription"));
			System.out.println("-----------------");

	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static int getAdvCardAmounh() {
		return DB.advCardAmount();
	}
	
}
