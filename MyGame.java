package cmp326_project1_monster;

import java.io.*;
import java.util.Scanner;

public class MyGame implements Game {
	
	private MyPlayer player;
	private MyRoom [] dungeon;
	Scanner inStream = null;
	
	
	public MyGame() throws FileNotFoundException, IOException {
		
		File pInfo = new File("src/cmp326_project1_monster/PlayerInfo.txt");
		inStream = new Scanner(pInfo);
		
		player = new MyPlayer(inStream.nextLine(), inStream.nextLine(), inStream.nextInt(), inStream.nextInt(), inStream.nextInt());      //"Kratos", "a powerful warrior", 100, 15, 30); //inStream.nextLine(), inStream.nextLine(), inStream.nextInt(), inStream.nextInt(), inStream.nextInt());
		
		MyMonster m1 = new MyMonster("Orc", "Covered with green blood", 20, 5, 0);
		MyMonster m2 = new MyMonster("Skeleton", "Funny how it moves", 40, 10, 10);
		MyMonster m3 = new MyMonster("Fire Dragon", "Spout fire with each breath", 100, 20, 40);
		
		MyRoom r1 = new MyRoom(0, "a room with an unbearable smell", m1);
		MyRoom r2 = new MyRoom(1, "dark and cold", m2);
		MyRoom r3 = new MyTreasureRoom(2, "a giant hall with something shiny on the other end", m3, "a large pile of gold");
		
		dungeon = new MyRoom [] {r1, r2, r3};
		
		//inStream.close();
	}

	@Override
	public void play() throws FileNotFoundException, IOException {
		PrintWriter outStream = null;
		
		inStream = new Scanner(System.in);
		int i = 0;
		
		String cont = "";
		try {
			//outStream = new PrintWriter("GameLog.txt");
			outStream = new PrintWriter(new FileOutputStream("GameLog.txt", true));
			outStream.println(player.getName());
			outStream.flush();
			
			
			while (player.isAlive() && i < dungeon.length) {
				dungeon[i].enter(player);
				if (dungeon[i].isComplete()) {
					System.out.println(player.getName() + " defeats " + dungeon[i].getMonster().getName() + "!");
					outStream.println("Player completed room " + (dungeon[i].getRoomIndex() + 1));
					outStream.flush();

					i++;
					
					
				}
				else {
					System.out.println("Player " + player.getName() + " is killed by " + dungeon[i].getMonster().getName() + ".");	
					outStream.println("Player died in room " + (dungeon[i].getRoomIndex() + 1));
					outStream.flush();

				}	
			}
			
//			boolean valEntry = false;
//			while (!valEntry) {
//				System.out.println("Play again? (Y/N)");
//				cont = inStream.nextLine();
//				
//				if (cont.equalsIgnoreCase("yes") || cont.equalsIgnoreCase("y")) {
//					new MyGame().play();
//				}
//				else if (cont.equalsIgnoreCase("no") || cont.equalsIgnoreCase("n")){
//					
//					System.out.println("Thanks for playing!");
//					valEntry = true;
//					outStream.println("THE END");
//				}
//				else {
//					System.out.println("Invalid entry.");
//					
//				}
//			}
		} finally {
//			if (outStream != null) {
//				outStream.close();
//			}
//			if (inStream != null) {
//				inStream.close();
//			}
//			
		}
		//inStream.close();
	}
	
	public static void main(String[] args) { //throws FileNotFoundException, IOException {
		PrintWriter outStream = null;
		Scanner inStream = null;
		try {
			
			String cont = "";
			inStream = new Scanner(System.in);
			outStream = new PrintWriter(new FileOutputStream("GameLog.txt", true));
			boolean valEntry = false;
			
			//do {
				new MyGame().play();
					
				
				while(!valEntry) {
					System.out.println("Play again? (Y/N)");
					cont = inStream.nextLine();
					
					if (cont.equalsIgnoreCase("yes") || cont.equalsIgnoreCase("y")) {
						new MyGame().play();
					}
					else if (cont.equalsIgnoreCase("no") || cont.equalsIgnoreCase("n")){
						
						System.out.println("Thanks for playing!");
						valEntry = true;
						outStream.println("THE END");
						outStream.flush();

					}
					else {
						System.out.println("Invalid entry.");
						
					}
				}
				
			//} while (!valEntry);
			
		} catch (IOException e) {
			System.out.println("Unable to read file: " + e.getMessage());
		} finally {
			if (outStream != null) {
				outStream.close();
			}
			if (inStream != null) {
				inStream.close();
			}
			
		}
		
		
	}

	
}
