package characters;

public class Warrior extends Character{
	
	static final String profession = "Warrior";
	
	Warrior(){
		super();
		this.strength += 1;
		this.inteligence -= 1;
		this.startPosition = 0; // Tawern
	}
	@Override
	public void printCard() {
		System.out.println("<--- CHARACTER CARD --->");
		System.out.println("Character profession: " + profession);
		System.out.println("Character strength: " + this.strength);
		System.out.println("Character intelligence: " + this.inteligence);
		System.out.println("Character gold: " + this.gold);
		System.out.println("Character life: " + this.life);
		System.out.println("<--- ---- ---- --->");
	}

}
