package cmp326_project1_monster;

import java.util.Scanner;

public class MyBattle implements Battle {
	
	private MyPlayer player;
	private MyMonster monster;
	
	public MyBattle(MyPlayer player, MyMonster monster) {
		this.player = player;
		this.monster = monster;
	}

	@Override
	public void run() {//throws FileNotFoundException, IOException {
		Scanner inStream = new Scanner(System.in);
		boolean playerTurn = true;
		String attackHeal;
		boolean valCommand = false;
		
		while (player.isAlive() && monster.isAlive()) {
			if(playerTurn) {
				System.out.println("Player hit points: " + player.getHitPoints());
				System.out.println("Monster hit points: " + monster.getHitPoints());
				
				while (!valCommand) {
					
						
							System.out.println(player.getName() + ": Attack or Heal?");
							attackHeal = inStream.nextLine();
							
							if(attackHeal.equalsIgnoreCase("attack")) {
								player.attack(monster);
								valCommand = true;
							}
							else if(attackHeal.equalsIgnoreCase("heal")) {
								player.heal();
								valCommand = true;
							}
							else {
								System.out.println("Invalid command.");
								valCommand = false;
							}

				}
				playerTurn = false;
			}
			else {
				monster.enrage();
				monster.attack(player);
				playerTurn = true;
				valCommand = false;
			}
			
		}
		
	}

}
