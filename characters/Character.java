package characters;

import java.util.Random;

import cards.*;

public class Character implements Creature{
	protected int strength;
	protected int inteligence;
	protected int gold;
	protected int life;
	public String profession;
	
	public static  Random randGen = new Random();
	private static final int charNum = 3;
	public int startPosition;
	
	Character(){
		this.strength = 3;
		this.inteligence = 3;
		this.gold = 2;
		this.life = 4;
		this.profession = "No profession";
		
		this.startPosition = 0;
	}
	
	static public Card draw() {
		Character newChar;
		Random generator = new Random();
		int ran = generator.nextInt(charNum)+1;
		System.out.println(ran);
		switch (ran){
			case 1 : newChar = new Warrior();
			break;
			case 2 : newChar = new Wizard();
			break;
			case 3 : newChar = new Elf();
			break;
			default : newChar = new Character();
			break;
		}
		return newChar;
	}

	@Override
	public void printCard() {
		System.out.println("<--- CHARACTER CARD --->");
		System.out.println("Character profession: " + this.profession);
		System.out.println("Character strength: " + this.strength);
		System.out.println("Character intelligence: " + this.inteligence);
		System.out.println("Character gold: " + this.gold);
		System.out.println("Character life: " + this.life);
		System.out.println("<---------------------->");
	}
	@Override
	public void die() {
		this.life = 0;
	//	System.out.println("Hero: " + this.profession + " dies...");
	}
	
	public int move(int from, boolean ifleft){
		if(ifleft){return from - rollOfDice();
		}else{return from + rollOfDice();
		}
	}
	
	public int rollOfDice(){
		return (randGen.nextInt(5)+1);
	}
	
}
