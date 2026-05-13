package project.models.character;

import project.models.player.Player;

/**
 *  This class is a subclass of the class Character and
 *  creates the operations of the archaeologist card.
 */
public class Archeologist extends CharacterCard {
	private static int NO = 4;
	private int count; 

    public Archeologist() {}
    
	/**
	 * <br>precondition: The variables must be valid
	 * <br>postcondition: Creates the characteristics
	 */
	public void archaeologist_characteristics() {
		this.count = 0;
	}
	
    public Archeologist(String s, Player p) {
    	int count = 0;
    	this.setImage(s);
    	count++;
    	this.count = count;
    	this.setPlayer(p);
    }

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
		if (NO == count)
			count = 0;
	}
}