package players;

import data.*;
import maps.*;

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
		System.out.println("present location: " + this.position + " - " + MapHandler.fieldName(this.position));
		this.charact.printCard();
	}
	public String getName(){
		return this.name;
	}
	public String getProfession(){
		return this.charact.profession;
	}
	public int move(){
		System.out.print("Move from " + MapHandler.fieldName(this.position) + " to ");
		this.position = charact.move(this.position, false) % MapHandler.getMapSize();
		System.out.print(MapHandler.fieldName(this.position));
		System.out.println("");
		
		return this.position;
	}
	public void explore() {
		// TODO Auto-generated method stub
		
	};
	
}
