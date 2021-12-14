package cmp326_project1_monster;

public class MyTreasureRoom extends MyRoom implements TreasureRoom {
	
	private String treasure;
	
	public MyTreasureRoom(int roomIndex, String description, MyMonster monster, String treasure) {
		super(roomIndex, description, monster);
		this.treasure = treasure;
		
	}

	@Override
	public void enter(MyPlayer player) {//throws FileNotFoundException, IOException {
		System.out.println(player.getName() + " enters room " + (getRoomIndex() + 1));
		System.out.println(player.getName() + ": This room is " + super.description + ", and has " + super.getMonster().getName());
		if (!isComplete()) {
			new MyBattle(player, getMonster()).run();
		}
		if (isComplete()) {
			System.out.println(player.getName() + " has found " + treasure);
		}
	}

}
