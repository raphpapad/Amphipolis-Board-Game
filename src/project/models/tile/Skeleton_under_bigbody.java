package project.models.tile;

/**
 * This is a subclass of the class SkeletonTile that finds the under body
 * parts of the big skeleton (the big skeloton belongs to an adult).
 */
public class Skeleton_under_bigbody extends SkeletonTile {
	
	public Skeleton_under_bigbody(int id) {
		super(id);
	}

	/**
	 * <br>precondition: The variable must be valid.
	 * <br>postcondition: Finds the multitude (calculating how many of them are)
	 * of the under body parts for the big skeleton.
	 * @return The number of them
	 */
	public int Under_bigbody_pieces() {
		int body_pieces = 0;
		return 0;
	}
}
