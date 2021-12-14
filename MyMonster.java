package cmp326_project1_monster;

public class MyMonster extends MyCreature implements Monster {
	
	private int enrageThreshold;
	private boolean isEnraged;
	
	public MyMonster(String name, String description, int hitPoints, int damage, int enrageThreshold) {
		super(name, description, hitPoints, damage);
		this.enrageThreshold = enrageThreshold;
		this.isEnraged = false;
	}
	
	@Override
	public boolean canEnrage() {
		if (this.getHitPoints() < this.enrageThreshold) {
			return true;
		}
		return false;
	}


	@Override
	public void enrage() { //throws FileNotFoundException, IOException {
//		This method will double this.damage for this Monster if it hasn't already been enraged. 
//		In this case, this.isEnraged should be set to true. Otherwise, this method has no effect.
//		This method will also display the message: "this.name has been enraged"	
		
		if (canEnrage() && !isEnraged) {
			setDamage(getDamage() * 2);
			isEnraged = true;
			System.out.println(this.getName() + " has been enraged");
		}
		
		
		
	}

}
