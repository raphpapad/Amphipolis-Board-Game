package project.models.tile;

/**
 * This is a subclass of the class Tile that creates the
 *  the tiles of landslide and returns them.
 */
public class LandslideTile extends Tile {
    private static int LANDSLIDETILE = 16;
    private int findings;
    
    public LandslideTile(int id) {
        super(id);
        this.findings = 0;
    }
    
	/**
	 * <br>precondition: The variable must be valid.
	 * <br>postcondition: Returns the tiles that have
	 * been created.
	 * @return All the tiles of landslide that have beenn
	 * created.
	 */
	public int landslide_tiles() {
		return 0;
	}

	public int getFindings() {
		return findings;
	}

	public void setFindings(int findings) {
		this.findings = findings;
		if (this.findings == LANDSLIDETILE)
			System.out.println("Egine tis katolisthisis");
	}
}