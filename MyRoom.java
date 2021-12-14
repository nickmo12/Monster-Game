package cmp326_project1_monster;

public class MyRoom implements Room {
	
	private int roomIndex;
	protected String description;
	private MyMonster monster;
	
	public MyRoom(int roomIndex, String description, MyMonster monster) {
		this.roomIndex = roomIndex;
		this.description = description;
		this.monster = monster;
	}

	@Override
	public boolean isComplete() {
		
		if (!monster.isAlive()) { 
			return true;
		}
		return false;
	}

	@Override
	public void enter(MyPlayer player) { //throws FileNotFoundException, IOException {
//		This method will display the message: 
//		"player name" "This Room is this.description, and has this.monster"
//		If the monster isAlive() allow the player to enter the room and start a battle 

		
		System.out.println(player.getName() + " enters room " + (this.roomIndex + 1));
		System.out.println("This room is " + this.description + ", and has the " + this.monster.getName() + " monster.");
		new MyBattle(player, monster).run();
	}
	
	@Override
	public String toString() {
		String s = String.format("Room index %2d, description %20s, monster name %20s", roomIndex, description, this.monster.getName());
		return s;
		
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public MyMonster getMonster() {
		return monster;
	}

	public void setMonster(MyMonster monster) {
		this.monster = monster;
	}
	
	public int getRoomIndex() {
		return roomIndex;
	}
	
	

}
