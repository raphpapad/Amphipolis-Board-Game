package project.models.tile;

/**
 * This is a subclass of the class SkeletonTile that finds the upper body
 * parts of the small skeleton (the small skeloton belongs to a child).
 */
public class Skeleton_upper_smallbody extends SkeletonTile {
	
	public Skeleton_upper_smallbody(int id) {
		super(id);
	}

	/**
	 * <br>precondition: The variable must be valid.
	 * <br>postcondition: Finds the multitude (calculating how many of them are)
	 * of the upper body parts for the small skeleton.
	 * @return The number of them
	 */
	public int Upper_smallbody_pieces() {
		int body_pieces = 0;
		return 0;
	}
}
