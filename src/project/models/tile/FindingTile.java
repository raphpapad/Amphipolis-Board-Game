package project.models.tile;
/**
 * This is a subclass of the class Tile that finds the category that
 * the tiles are belonnging.
 */
public abstract class FindingTile extends Tile {
    private static int TILES = 135;
    private int findings = 0;
    
    public FindingTile(int id) {
        super(id);
    }
    
    /**
	 * <br>precondition: The variable must be valid.
	 * <br>postcondition: Finds the category of the tiles and returns it.
	 * @return The category of the tiles
	 */
	public int Finding_tile_category() {
		return 0;
	}

	public int getFindings() {
		return findings;
	}

	public void setFindings(int findings) {
		this.findings = findings;
		if (findings == TILES)
			System.out.println("Well done all points have been collected");
	}
}