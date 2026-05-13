package project.models.character;

import project.models.player.Player;

/**
 *  This class is a subclass of the class Character and
 *  creates the operations of the professor card.
 */
public class Professor extends CharacterCard {
	private static int NO = 4;
	private int count;

    public Professor() {}
	
    /**
	 * <br>precondition: The variables must be valid
	 * <br>postcondition: Creates the characteristics
	 */
	public void professor_characteristics() {
		this.count = 0;
	}
    public Professor(String s,Player p) {
       this.setImage(s);
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