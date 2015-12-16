package characters;

public class Elf extends Character{

	static final String profession = "Elf";
	
	Elf(){
		super();
		this.startPosition = 20; // Forrest
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
