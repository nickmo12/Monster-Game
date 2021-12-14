package cmp326_project1_monster;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface Player extends Creature {
	
	/**
	 * 
	 * A class that implements this interface should have the following attributes:
	 * <ul>
	 * <li>healAmount: int</li>
	 * </ul>
	 * 
	 * The implementing class should only have the following constructor:
	 * 
	 * public Player(String name, String description, int hitPoints, int damage, int healAmount)
	 * 
	 */
	
	/**
	 * 
	 * This method will increase the <code>hitPoints</code> for <code>this Player</code> by <code>this.healAmount</code>.
	 * <br>
	 * <br>
	 * This method will also display the message:
	 * <br>
	 * <br>
	 * "<code>this.name</code> is healed by <code>this.healAmount</code>"
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * 
	 */
	public void heal() throws FileNotFoundException, IOException;

}
