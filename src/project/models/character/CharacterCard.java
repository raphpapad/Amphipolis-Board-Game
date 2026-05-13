package project.models.character;

import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Arrays;
import project.models.player.Player;
import java.lang.String;
/**
 *  <br>precondition: -
 *  <br>postcondition: A new instance of Character will be created. 
 *  This class creates the images that the
 *  Cards are going to need it. He creates all
 *  the images of the game.
 */
public abstract class CharacterCard {
	/**
	 * Creates an instance of Character.
	 * <br>precondition: -
	 * <br>postcondition: A new instance of Character will be created. 
	 */
    public CharacterCard() {}

	/**
	 * Creates an instance of Character.
	 * <br>precondition: -
	 * <br>postcondition: A new instance of Character will be created. 
	 * @param isUsed The initialization value of isUsed.
	 * @param belongs The initialization value of belongs.
	 * @param job The initialization value of job.
	 * @param color The initialization value of color.
	 */
    public CharacterCard(String path, Player player) {
		this.isUsed = isUsed;
		this.image = path;
		this.played = false;
		this.belongs = belongs;
		this.player = player;
		this.job = job;
		this.color = color;
    }

	/**
	 * Creates an instance of Character.
	 * <br>precondition: -
	 * <br>postcondition: A new instance of Character will be created. 
	 * @param isUsed 
	 * @param isUsed The initialization value of isUsed.
	 * @param color 
	 * @param belongs The initialization value of belongs.
	 * @param job The initialization value of job.
	 * @param color The initialization value of color.
	 * @param belongs 
	 * @param job 
	 */
    public CharacterCard(String path, Player player, Boolean isUsed, String color, String belongs, String job) {
		this.isUsed = isUsed;
		this.image = path;
		this.played = false;
		this.belongs = belongs;
		this.player = player;
		this.job = job;
		this.color = color;
    }
    
    public boolean isPlayed() {
        return played;
    }
    
	/**
	 * <br>precondition: You must give an image
	 * <br>postcondition: Returns the image.
	 * @return The iamge from the getImage
	 */
    public String getImage() {
        return image;
    }

    public void setPlayed(boolean played) {
        this.played = played;
    }


	/**
	 * <br>precondition: You must give an image
	 * <br>postcondition: You give the new image of a 
	 * this specific card.
	 * @param image The new image
	 */
    public void setImage(String image) {
        this.image = image;
    }

    public String getText() {
        return text;
    }  
    
	/**
	 * <br>precondition:The value must be valid.
	 * <br>postcondition: Returns the value of a
	 * spesific image. 
	 * @return The value of the image.
	 */
    public int getValue() {
        return value;
    }
    
    public void setPlayer(Player player) {
        this.player = player;
    }
    
    /**
	 * <br>precondition: The value must be valid.
	 * <br>postcondition: The value must be according 
	 * to a specific image.
	 * @param value The new value
	 */
    public void setValue(int value) {
        this.value = value;
    }
    
    public Player getPlayer() {
        return player;
    }


	public int getCounter() {
		return counter;
	}

	/**
	 * <br>precondition: The value must be valid.
	 * <br>postcondition: Returns the color of the cards.
	 * @return color of the cards.
	 */
    public String getColor() {
        return color;
    }


	public void setCounter(int counter) {
		this.counter = counter;
	}
	
	/**
	 * <br>precondition: The color must be valid.
	 * <br>postcondition:The color variable will change to the new one, that was given.
	 * @param color Sets the new color for the cards.
	 */
    public void setColor(String color) {
        this.color = color;
    }

    public void setText(String text) {
    	this.value = 0;
        this.text = text;
        this.value++;
    }

	public ArrayList<CharacterCard> getCards() {
		this.value = 0;
		this.setValue(value + 1);
		return Cards;
    }
	
	/**
	 * <br>precondition: The Cards from the ArrayList must be valid.
	 * <br>postcondition: Puts the new Cards in ArrayList.
	 * @param Cards The new one from the setCards.
	 */
    public void setCards(ArrayList<CharacterCard> Cards)
    {
    	this.Cards = Cards;
    }
    
    /**
     * <br>precondition: The instance must be valid.
	 * <br>postcondition: The value of getIsUsed will be returned.
     * @return The value the instance of a isUsed holds.
     */
    public Boolean getIsUsed() {
		return isUsed;
	}
    
    /**
	 * <br>precondition: Puts a valid value.
	 * <br>postcondition:The isUsed variable will change to the new one, that was given.
	 * @param isUsed Puts the new owner from the setIsUsed.
	 */
	public void setIsUsed(Boolean isUsed) {
		this.isUsed = isUsed;
	}
	
	/**
	 * <br>precondition: The value must be valid.
	 * <br>postcondition: Returns the player that belongs.
	 * @return The belongs from getBelongs.
	 */
	public String getBelongs() {
		return belongs;
	}
	
	/**
	 * <br>precondition: Puts a valid value.
	 * <br>postcondition:The belongs variable will change to the new one, that was given.
	 * @param belongs Puts the new owner from the setBelongs.
	 */
	public void setBelongs(String belongs) {
		this.belongs = belongs;
	}
	
    /**
	 * <br>precondition: The string must be valid.
	 * <br>postcondition: Returns the jobs of the characters.
	 * @return The job.
	 */
    public String Job() {
    	return "lala";
    }
    
	/**
	 * <br>precondition: The value must be valid.
	 * <br>postcondition: Returns the characters operation.
	 * @return The job from getJob.
	 */
	public String getJob() {
		return job;
	}
	
	/**
	 * <br>precondition: Puts a valid value.
	 * <br>postcondition:The job variable will change to the new one, that was given.
	 * @param job Puts the new operation from the setJob.
	 */
	public void setJob(String job) {
		this.job = job;
	}
	
	
	/**
	 * <br>precondition:  All the cards in Arraylist must be valid.
	 * <br>postcondition: The Cards must be valid.
	 */
	public void initCards() {

    }
    
	/**
	 * <br>precondition: The boolean value must be valid.
	 * <br>postcondition: Returns the boolean value
	 * @return The boolean value
	 */
    public boolean IsUsed() {
    	if (NO == value)
    		return false;
    	return true;
    }
    
    /**
	 * <br>precondition: The string must be valid.
	 * <br>postcondition: Returns the player that the cards belongs
	 * @return The player.
	 */
    public String Belongs() {
    	return "lala";
    }
    
	private static int NO = 4;
	private int counter;
	private Boolean isUsed;
	private boolean played;
	private String belongs;
	private String color;
	private ArrayList<CharacterCard> Cards;
	private String image;
    private String job;
    private String text;
    int value;
    private Player player;
}