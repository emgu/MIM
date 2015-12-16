package mim;

import java.sql.*;
import java.util.*;

import data.*;
import players.*;

public class Main {

	static final Scanner scan = new Scanner(System.in);
	static int PNUM = 0;
	
	
	static void db(){
		DBHandler.createDB();
		for(int index = 1; index < 25; index++){
	//		DBHandler.printField(index);
	//		System.out.println("");;
		}
		
	}
	
// IO controll functions:	
	private static void write(int toWrite) {
		System.out.print(toWrite);
	}
	private static void write(String toWrite) {
		System.out.print("\n" + toWrite);
	}
	private static int readInt() {
		try{
			return Integer.parseInt(scan.nextLine());
		}catch(NumberFormatException e){
			e.printStackTrace(System.out);
			return Integer.MIN_VALUE;
		}
	}
	private static String readString() {
		return scan.nextLine();
		
	}
	
// Main function:	
	public static void main(String[] args) {

		PlayerList.create();
	//	DBHandler.create();
		db();
		start();
		
		
		int turn = 10;
		while(turn>0){
			for(Player p : PlayerList.getList()){
				p.move();
				p.printPlayer();
			}
			
			turn--;
		}
		
	}


	private static void start() {
		while (PNUM < 1 || PNUM > 4){
			write("Write players number (1-4):");
			PNUM = readInt();
		}
		
		write("Player number is: " + PNUM);
		write("");
		
		
		
		for(int h = 1; h <= PNUM; h++){
			write("Player number " + h);
			write("Write player number " + h + " name: ");
			PlayerList.addPlayer(readString());
		}
		
		for(Player p : PlayerList.getList()){
			p.printPlayer();
		}
	}

}
