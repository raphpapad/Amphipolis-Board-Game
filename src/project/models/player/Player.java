package project.models.player;

import java.awt.*;
import java.io.BufferedInputStream;
import java.io.File;
import project.models.character.Digger;
import java.lang.Enum;
import java.lang.String;
import project.models.tile.Tile;
import java.io.BufferedWriter;
import java.util.ArrayList;
import java.io.CharArrayReader;
import project.models.tile.StatueTile;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import project.models.character.Assistant;
import java.io.Console;
import project.models.tile.MosaicTile;
import java.io.FileNotFoundException;
import project.models.character.Professor;
import java.awt.color.CMMException;
import project.models.character.CharacterCard;
import java.io.IOError;
import java.util.AbstractMap;
import java.io.ObjectStreamException;
import project.models.tile.AmphoreaTile;
import java.io.InputStream;
import java.awt.Color;
import java.io.OptionalDataException;
import java.util.AbstractList;
import java.io.IOException;
import java.lang.AbstractMethodError;
import project.models.tile.SkeletonTile;
import java.lang.annotation.AnnotationTypeMismatchException;
import project.models.character.Archeologist;

/**
 *  This is an abstract class that creates the
 *  players (his ADT).
 */
public class Player {
	private static int CARDS_NUMBER = 4;
	private Class Aclass;
	private static int CARD_ONE = 0;
    private String id;
    private static int CARD_TWO = 1;
    private String name;
    private static int CARD_THREE = 2;
    private ArrayList<Tile> tiles;
    private static int CARD_FOUR = 3;
    private String color;
    private Color colour;
    private Archeologist archae;
    ArrayList<MosaicTile> mosaicTilesCollected = new ArrayList<MosaicTile>();
    private Assistant assistant;
    ArrayList<AmphoreaTile> amphoreasTilesCollected = new ArrayList<AmphoreaTile>();
    private Professor professor;
    ArrayList<SkeletonTile> skeletonsTilesCollected = new ArrayList<SkeletonTile>();
    private Digger digger;
    ArrayList<StatueTile> statusTilesCollected = new ArrayList<StatueTile>();
	private int totalpoints;
    ArrayList<Tile> collectedCards = new ArrayList<Tile>();
    private Boolean play;
    public boolean usedCharacterThisTurn;
    private int points;
    private CharacterCard[] chars;
	
	/** 
	 * Creates a new instance of Player.
	 * <br>precondition: -
	 * <br>postcondition: A new instance of Player will be created. 
	 */
    public Player() {

        chars = new CharacterCard[4];
    }
    
	/**
	 * /**
	 * Creates a new instance of Player.
	 * <br>precondition: -
	 * <br>postcondition: A new instance of Player will be created.
	 * 
	 * @param name The initialization value of name.
	 * @param tiles The initialization value of tiles.
	 * @param play The initialization value of play.
	 * @param color The initialization value of color.
	 * @param points The initialization value of points.
	 * @param archae The initialization value of archae.
	 * @param assistant The initialization value of assistant.
	 * @param digger The initialization value of digger.
	 * @param professor The initialization value of professor.
	 */
	public Player(String name, ArrayList<Tile> tiles, Boolean play, Color colour, int points, Archeologist archae,
			Assistant assistant, Digger digger, Professor professor) {
		this.name = name;
		this.tiles = tiles;
		this.play = play;
		this.colour = colour;
		this.points = points;
		this.archae = archae;
		this.assistant = assistant;
		this.digger = digger;
		this.professor = professor;
	}

    public Player(String name, String color) {
        this.name = name;
        this.color = color;
        this.chars = new CharacterCard[CARDS_NUMBER];
        this.chars[CARD_ONE] = new Archeologist("images_2020/archaeologist.png", this);
        this.chars[CARD_TWO] = new Assistant("images_2020/assistant.png", this);
        this.chars[CARD_THREE] = new Digger("images_2020/digger.png", this);
        this.chars[CARD_FOUR] = new Professor("images_2020/professor.png", this);
        usedCharacterThisTurn = false;
    }
    
	/**
	 * <br>precondition: The tiles must be valid
	 * <br>postcondition: Returns the tiles that 
	 * he collected.
	 * @return The tiles 
	 */
    public ArrayList<Tile> getTiles() {
		return tiles;
	}

	/**
	 * <br>precondition: Returns the name
	 * <br>postcondition: Returns this specific name
	 * @return The name
	 */
    public String getName() {
        return name;
    }

    /**
	 * <br>precondition: The tiles must be valid
	 * <br>postcondition: Adds a new tile
	 * @param tile The new one
	 */
	public void setTiles(Tile tile) {
		this.tiles.add(tile) ;
	}
	
	 /**
	 * <br>precondition: You have to give a name
	 * <br>postcondition: Gives a new name
	 * @param name The new name
	 */
    public void setName(String name) {
        this.name = name;
        int i = Player.CARD_ONE;
        if (i == 1)
        	System.out.println(i);
    }
    
	/**
	 * <br>precondition: At first is false
	 * <br>postcondition: Returns if he plays
	 * @return The play from getPlay
	 */
	public Boolean getPlay() {
		return play;
	}

    public String getColor() {
        return color;
    }

	 /**
	 * <br>precondition: At first is false
	 * <br>postcondition: Gives a new play
	 * @param play The new play
	 */
	public void setPlay(Boolean play) {
		this.play = play;
	}
	
	
    public void setColor(String color) {
       this.color = color;
    }

	/**
	 * <br>precondition: The color must be valid 
	 * (it must be one of the colors that we have)
	 * <br>postcondition: Returns the color of the
	 * player
	 * @return The color from getColor
	 */
	public Color getColour() {
		return colour;
	}
	
    public CharacterCard[] getChars() {
        return chars;
    }
    

	 /**
	 * <br>precondition: The color must be valid 
	 * (it must be one of the colors that we have)
	 * <br>postcondition: Gives a new color
	 * @param color The new color
	 */
	public void setColor(Color colour) {
		this.colour = colour;
	}
	
	/**
	 * <br>precondition: The card must be
	 * valid (correct color,...)
	 * <br>postcondition: Puts the new card
	 * of another player
	 * @param assistant The assistant
	 */
	public void setAssistant(Assistant assistant) {
		this.assistant = assistant;
	}
	
    public void setChars(CharacterCard[] chars) {
        this.chars = chars;
    }
    
	/**
	 * <br>precondition: Returns the card
	 * assistant
	 * <br>postcondition: Returns this card
	 * assistant
	 * @return The assistant
	 */
	public Assistant getAssistant() {
		return assistant;
	}

    public ArrayList<MosaicTile> getMosaicTilesCollected() {
        return mosaicTilesCollected;
    }
    
	/**
	 * <br>precondition: Returns the card
	 * digger
	 * <br>postcondition: Returns this card
	 * digger
	 * @return The digger
	 */
	public Digger getDigger() {
		return digger;
	}

    public ArrayList<AmphoreaTile> getAmphoreasTilesCollected() {
        return amphoreasTilesCollected;
    }
    
	
	/**
	 * <br>precondition: The card must be
	 * valid (correct color,...)
	 * <br>postcondition: Puts the new card
	 * of another player
	 * @param digger The digger
	 */
	public void setDigger(Digger digger) {
		this.digger = digger;
	}
	

    public ArrayList<SkeletonTile> getSkeletonsTilesCollected() {
        return skeletonsTilesCollected;
    }
    
	/**
	 * <br>precondition: Returns the card
	 * professor
	 * <br>postcondition: Returns this card
	 * professor
	 * @return The professor
	 */
	public Professor getProfessor() {
		return professor;
	}
	

    public ArrayList<StatueTile> getStatusTilesCollected() {
        return statusTilesCollected;
    }

	/**
	 * <br>precondition: The card must be
	 * valid (correct color,...)
	 * <br>postcondition: Puts the new card
	 * of another player
	 * @param professor The professor
	 */
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	
	/**
	 * <br>precondition: Give ADT of the players 
	 * <br>postcondition: Initialize all the players
	 */
	public void init() {
		
	}
	
    public ArrayList<Tile> getCollectedCards() {
        return collectedCards;
    }
    
	/**
	 * <br>precondition: At first you dont have
	 * points
	 * <br>postcondition: Calculates the points
	 * @return points
	 */
	public int playerPoints() {
    	return 0;
    }

    public void setCollectedCards(ArrayList<Tile> collectedCards) {
        this.collectedCards = collectedCards;
    }

    public boolean isUsedCharacterThisTurn() {
    	return usedCharacterThisTurn;
    }

    public void setUsedCharacterThisTurn(boolean usedCharacterThisTurn) {
        this.usedCharacterThisTurn = usedCharacterThisTurn;
    }

    public Class getAclass() {
        return Aclass;
    }
    
	/**
	 * <br>precondition: The card must be
	 * valid (correct color,...)
	 * <br>postcondition: Puts the new card
	 * of another player
	 * @param archae The archae
	 */
	public void setArchae(Archeologist archae) {
		this.archae = archae;
	}
	
    public void setAclass(Class Aclass) {
        this.Aclass = Aclass;
    }

	/**
	 * <br>precondition: Returns the points
	 * <br>postcondition: Returns this points
	 * @return The points from getPoints
	 */
    public int getPoints() {
        return points;
    }

	 /**
	 * <br>precondition: The points must be valid 
	 * <br>postcondition: Changes to the new points
	 * of the player 
	 * @param points The new points
	 */
    public void setPoints(int points) {
        this.points = points;
    }
    
	
	/**
	 * <br>precondition: Returns the card
	 * archae
	 * <br>postcondition: Returns this card
	 * archae
	 * @return The archae
	 */
	public Archeologist getArchae() {
		return archae;
	}

	public int getTotalpoints() {
		return totalpoints;
	}

	public void setTotalpoints(int totalpoints) {
		this.totalpoints = totalpoints;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}