package project.models.tile;

/**
 * This is a subclass of the class StatueTile that finds
 * how many sphinxs the player has.
 */
public class SphinxTile extends StatueTile {
    
    private int pl2;

	public SphinxTile(int id) {
        super(id);
    }
    
	/**
	 * <br>precondition: Valid piece
	 * <br>postcondition: Finds of the sphinxs
	 * in his possession.
	 * @return number of sphinxs
	 */
	public int sphinxs() {
		setPl2(0);
		return 0;
	}
	
	/**
	 * <br>precondition: The variable must be valid.
	 * <br>postcondition: Materializes the sphinx
	 */
	public void sphinx_materialize() {
		int tmp = getPl2();
	}

	public int getPl2() {
		return pl2;
	}

	public void setPl2(int pl2) {
		this.pl2 = pl2;
	}
}