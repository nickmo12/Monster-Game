package cmp326_project1_monster;

public class MyCreature implements Creature {
	
	private String name;
	private String description;
	private int hitPoints; //remaining health of the creature
	private int damage; //amount of damage the creature deals (attack damage)
	private MyRoom room;
	
	public MyCreature() {
		this.name = "";
		this.description = "";
		this.hitPoints = 0;
		this.damage = 0;
	}
	
	public MyCreature(String name, String description, int hitPoints, int damage) {
		this.name = name;
		this.description = description;
		this.hitPoints = hitPoints;
		this.damage = damage;
		this.room = null;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public int getHitPoints() {
		return hitPoints;
	}
	
	public void setHitPoints(int hitPoints) {
		this.hitPoints = hitPoints;
	}
	
	public int getDamage() {
		return damage;
	}
	
	public void setDamage(int damage) {
		this.damage = damage;
	}
	
	public MyRoom getRoom() {
		return room;
	}
	
	public void setRoom(MyRoom room) {
		this.room = room;
	}


	@Override
	public void attack(MyCreature creature) { //throws FileNotFoundException, IOException {
		//This method displays a message containing the following:
			//"this.name attacks target creature's name, dealing damage damage"	
		creature.takeDamage(damage);
		System.out.println(this.name + " attacks target " + creature.getName() + ", dealing " + damage + " damage" );
		
	}

	@Override
	public void takeDamage(int damage) {
		// This method subtracts the specified amount of damage from hitPoints. 
		// Please note that hitPoints cannot go below zero.
		
		if ((hitPoints - damage) >= 0) {
			hitPoints -= damage;
		}
		else {
			hitPoints = 0;
		}
	}

	@Override
	public boolean isAlive() {
		if (hitPoints > 0) {
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		String s = String.format("name %15s, description %20s, hitPoints %03d, damage %02d", name, description, hitPoints, damage);
		return s;
	}

	
}
