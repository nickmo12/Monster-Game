package cmp326_project1_monster;

public class MyPlayer extends MyCreature implements Player {
	
	private int healAmount;
	
	public MyPlayer(String name, String description, int hitPoints, int damage, int healAmount) {
		super(name, description, hitPoints, damage);
		this.healAmount = healAmount;
		
	}

	@Override
	public void heal() { //throws FileNotFoundException, IOException {
//		This method will increase the hitPoints for this Player by this.healAmount.
//		This method will also display the message: "this.name is healed by this.healAmount"
		
		this.setHitPoints(this.getHitPoints() + healAmount);
		System.out.println(this.getName() + " is healed by " + healAmount);
		
		
		
	}
	

}
