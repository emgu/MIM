package players;

import data.*;
import characters.Character;

public class Player {
	String name;
	Character charact;
	public int position;
	public Player(String n){
		this.name = n;
		this.charact = (Character)Character.draw();
		this.position = charact.startPosition;
	}
	public void printPlayer(){
		System.out.println("\nPlayer: " + this.name);
		System.out.println("present location: " + this.position + " - " + DBHandler.fieldName(this.position));
		this.charact.printCard();
	}
	public int move(){
		this.position = charact.move(this.position, false) % DBHandler.mainMapSize();
		return this.position;
	}
	public void explore() {
		// TODO Auto-generated method stub
		
	};
	
}
