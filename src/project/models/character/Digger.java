package project.models.character;

import project.models.player.Player;

/**
 *  This class is a subclass of the class Character and
 *  creates the operations of the digger card.
 */
public class Digger extends CharacterCard {
	private static int NO = 4;
	private int count;
	
    public Digger() {}
    
	/**
	 * <br>precondition: The variables must be valid
	 * <br>postcondition: Creates the characteristics
	 */
	public void digger_characteristics() {
		this.count = 0;
	}

	/**
	 * 
	 * @param s
	 * @param p
	 */
    public Digger(String s,Player p) {
       this.setImage(s);
      this.setPlayer(p);
    }

    /**
     * 
     * @return
     */
	public int getCount() {
		return count;
	}

	/**
	 * 
	 * @param count
	 */
	public void setCount(int count) {
		this.count = count;
		if (NO == count)
			count = 0;
	}
}