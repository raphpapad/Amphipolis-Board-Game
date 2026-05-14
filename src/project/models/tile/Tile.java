package project.models.tile;

import java.awt.Color;

/**
 * This is the parent Tile class for all tiles, divided into Finding and Landslide Tiles
 * This is an abstract class that creates the
 *  tiles (his ADT).
 */
public abstract class Tile {
	private static int NUMBER = 59;
	
    private Color colour;
    private boolean check;
	
    private String category;
	private String pieces;

	private int points;
    private int id;
    private int text;
	
	public Tile() {}	
	/**
	 * Creates a new instance of Tile.
	 * <br>precondition: -
	 * <br>postcondition: A new instance of Tile will be created.
	 * 
	 * @param color	The initialization value of color.
	 * @param category The initialization value of category.
	 * @param pieces The initialization value of pieces.
	 */
	public Tile(Color color, String category, String pieces) {
		this.isCheck();
		this.colour = color;
		this.category = category;
		this.pieces = pieces;
		this.setCheck(true);
	}
	
	public Tile(int id) {
		this.isCheck();
        this.id = id;
        this.setCheck(true);
    }
	
	public boolean isCheck() {
		boolean tmp;
		tmp = check;
		return tmp;
	}

	public void setCheck(boolean check) {
		boolean tmp;
		this.check = check;
		tmp = this.check;
	}

	/**
	 * <br>precondition: The color must be valid 
	 * (it must be one of the colors that we have)
	 * <br>postcondition: Returns the color of the
	 * tiles
	 * @return The color from getColor
	 */
	public Color getColour() {
		Color tmp;
		tmp = colour;
		return tmp;
	}

    /**
     * @return the points
     */
    public int getPoints() {
        return points;
    }
    
	 /**
	 * <br>precondition: The color must be valid 
	 * (it must be one of the colors that we have)
	 * <br>postcondition: Gives a new color
	 * @param color The new color
	 */
	public void setColour(Color color) {
		this.colour = color;
	}
	
    /**
     * @param points the points to set
     */
    public void setPoints(int points) {
        this.points = points;
    }
    
	/**
	 * <br>precondition: Returns the category.
	 * <br>postcondition: Returns this category.
	 * @return The category from getcategory.
	 */
	public String getcategory() {
		return category;
	}

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }
    
	 /**
	 * <br>precondition: The Category must be valid
	 * (must be one of them that we have). 
	 * <br>postcondition: Gives a new category.
	 * @param category The new category.
	 */
	public void setcategory(String category) {
		this.category = category;
	}
	
    @Override
    public int hashCode() {
    	int hash;
        hash = (NUMBER * hash + this.points) + (NUMBER * hash + this.id);
        return hash;
    }

    @Override
    public boolean equals(Object o1) {
    	final Tile o2;
        if (this == o1) {
            return true;
        }
        if (o1 == null) {
            return false;
        }
        if (getClass() != o1.getClass()) {
            return false;
        }
        
        o2 = (Tile) o1;
        if (this.points != o2.points) {
        	return false;
        }
        if (this.id != o2.id) {
            return false;
        }
        return true;
    }
    
	/**
	 * <br>precondition: Returns the pieces.
	 * <br>postcondition: Returns this pieces.
	 * @return The pieces from getpieces.
	 */
	public String getpieces() {
		return pieces;
	}
	
    public int getText() {
        return text;
    }
    
	 /**
	 * <br>precondition: The Pieces must be valid
	 * (must be one of them that we have for statue
	 * and skeleton). 
	 * <br>postcondition: Gives a new pieces.
	 * @param pieces The new pieces.
	 */
	public void setpieces(String pieces) {
		this.pieces = pieces;
	}
	
    public void setText(int text) {
        this.text = text;
    }
    
	/**
	 * <br>precondition: All the points that have
	 * been collected must be according the tile's
	 * categories that we have.
	 * <br>postcondition: Returns the points.
	 * @return The points.
	 */
	public int finding_Points() {
		return 0;
	}

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
}
