package project.models.tile;

/**
 * This is a subclass of the class StatueTile that finds
 * how many caryatids the player has.
 */
public class CaryatidTile  extends StatueTile{
	public CaryatidTile(int id) {
        super(id);
    }
    
	/**
	 * <br>precondition: Valid piece
	 * <br>postcondition: Finds of the caryatids
	 * in his possession.
	 * @return number of caryatids
	 */
	public int caryatids() {
		setPl1(0);
		return 0;
	}
	
	/**
	 * <br>precondition: The variable must be valid.
	 * <br>postcondition: Materializes the caryatid
	 */
	public void caryatid_materialize() {
		setPl1(0);
	}
	
	public int getPl1() {
		return pl1;
	}

	public void setPl1(int pl1) {
		this.pl1 = pl1;
	}

	private int pl1;
}