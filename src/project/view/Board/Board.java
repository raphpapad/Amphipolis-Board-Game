package project.view.Board;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.DebugGraphics;
import javax.swing.JPanel;
import javax.swing.JCheckBox;
import javax.swing.WindowConstants;
import javax.swing.JButton;
import project.controller.Core;
import javax.swing.border.EmptyBorder;
import project.models.tile.AmphoreaTile;
import project.models.tile.CaryatidTile;
import project.models.tile.Skeleton_upper_smallbody;
import project.models.tile.SphinxTile;
import project.models.tile.LandslideTile;
import project.models.tile.Skeleton_upper_bigbody;
import project.models.tile.MosaicTile;
import project.models.tile.Skeleton_under_smallbody;
import project.models.tile.SkeletonTile;
import project.models.tile.Skeleton_under_bigbody;
import project.models.tile.StatueTile;
import project.models.tile.Tile;

/**
 *  ADT for the board (table, paluer, ...)
 */
public class Board extends JFrame {    
	private final CollectedSide collectedSide;
	private final GameBoard gameBoard;
	private boolean starting;
	
	/* FindingTiles */
	private MosaicTile[] Mosaic_board;
	private AmphoreaTile[] Amphora_board;
	private StatueTile[] Statue_board;

	private SkeletonTile[] Skeleton_board;
	private boolean finished;
	private final PlayerSide PlayerSide;
	private LandslideTile[][] Landslide_board;	
	private boolean check = false;
    Core core;

	/**
	 * Creates a new instance of Bag.
	 * <br>precondition: -
	 * <br>postcondition: A new instance of Bag will be created.
	 * 
	 * @param starting The initialization value of starting.
	 * @param finished The initialization value of finished.
	 * @param landslide_board The initialization value of landslide_board. 
	 * @param mosaic_board The initialization value of mosaic_board. 
	 * @param amphora_board The initialization value of amphora_board.
	 * @param statue_board The initialization value of statue_board.
	 * @param skeleton_board The initialization value of skeleton_board.
	 */
	public Board(boolean starting, boolean finished, LandslideTile[][] landslide_board, MosaicTile[] mosaic_board,
			AmphoreaTile[] amphora_board, StatueTile[] statue_board, SkeletonTile[] skeleton_board) {

		this.gameBoard = new GameBoard(  this.core);
	    this.PlayerSide = new PlayerSide(core);
	    this.PlayerSide.setGameBoard(gameBoard);
		this.starting = false;
		this.finished = false;
		this.Landslide_board = new LandslideTile[4][4];
		this.Mosaic_board = new MosaicTile[27];
		this.Amphora_board = new AmphoreaTile[30];
		this.Statue_board = new StatueTile[24];
		this.Skeleton_board = new SkeletonTile[30];
		this.collectedSide = new CollectedSide(core);
	}

    public Board(Core core) {
    	this.core= core;
    	this.check = true;
    	if (check)
    	{
	        this.starting = false;
			this.finished = false;
	        this.gameBoard = new GameBoard(  this.core);
			this.Landslide_board = new LandslideTile[4][4];
	        this.PlayerSide = new PlayerSide(core);
	        this.PlayerSide.setGameBoard(gameBoard);
	        FlowLayout layout = new FlowLayout(FlowLayout.LEFT);
	        layout.setVgap(0);
	        this.Mosaic_board = new MosaicTile[27];
	        layout.setHgap(0);
	        JPanel p = new JPanel(layout);
	        p.add("", gameBoard);
	        p.add("", PlayerSide);
	        this.collectedSide = new CollectedSide(core);
	        p.add(collectedSide);
	        add(p);
	        this.Amphora_board = new AmphoreaTile[30];
	        this.setVisible(true);
	        this.Statue_board = new StatueTile[24];
	        this.setSize(870, 736);
	        this.Skeleton_board = new SkeletonTile[30];
	        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	        this.setLocation(0, 0);
	        setResizable(false);
    	}
    	else
    	{
    		this.collectedSide = new CollectedSide(core);
	        this.gameBoard = new GameBoard(  this.core);
			this.Landslide_board = new LandslideTile[4][4];
	        this.PlayerSide = new PlayerSide(core);
	        this.Amphora_board = new AmphoreaTile[30];
	        this.PlayerSide.setGameBoard(gameBoard);
    	}
    }
 
    public GameBoard getGameBoard() {
        return this.gameBoard;
    }
    public PlayerSide getPlayerSide() {
        return this.PlayerSide;
    }
    
    /**
   	 * <br>precondition: Valid ADT
   	 * <br>postcondition: initialization
   	 */
	public void init() {
		
	}
	
	/**
	 * <br>precondition: Returns the tile of starting.
	 * <br>postcondition: Returns the tile of this starting.
	 * @return Ôhe starting.
	 */
	public boolean getStarting() {
        return starting;
    }
	
	/**
	 * <br>precondition: Put a correct value.
	 * <br>postcondition: The starting variable will change to the new one, that was given.
	 * @param starting.
	 */
    public void setStarting(boolean starting) {
        this.starting = starting;
    } 
	 
    /**
	 * <br>precondition: Returns the tile of finished.
	 * <br>postcondition: Returns the tile of this finished.
	 * @return the finished.
	 */
	public boolean getFinished() {
        return finished;
    }
	
	/**
	 * <br>precondition: Put a correct value.
	 * <br>postcondition: The finished variable will change to the new one, that was given.
	 * @param finished.
	 */
    public void setFinished(boolean finished) {
        this.finished = finished;
    }
    
    /**
   	 * <br>precondition: Valid tiles
   	 * <br>postcondition: Materializes Landslies
   	 */
	public void region_Landslise() {
		
	}
	
	/**
   	 * <br>precondition: Valid tiles
   	 * <br>postcondition: Materializes tile's regions
   	 */
	public void region_Tiles() {
		
	}
    
	/**
   	 * <br>precondition: Valid player
   	 * <br>postcondition: Materializes the turn.
   	 */
    public void next_turn_player() {
    	
    }
    
    /**
   	 * <br>precondition: Valid tiles and correct
   	 * matirialization of landslides
   	 * <br>postcondition: Materializes the end of game
   	 */
    public void end_game() {
    	this.setStarting(false);
    	this.setFinished(true);
    }
    
    public CollectedSide getcollectedSide() {
    	this.setStarting(true);
    	this.setFinished(false);
        return collectedSide;
    }
    
    public class CollectedSide extends JPanel {
		private int collect;
        private static final int CO_HEIGHT = 80;
		private static final int CO_WIDTH = 1165;

		public CollectedSide(Core core) {
        	setStarting(true);
            setPreferredSize(new Dimension(CO_WIDTH, CO_HEIGHT));          
            setLayout(new FlowLayout(FlowLayout.LEADING));
        }
        
        public void setCollect(int collect) {
        	this.collect = collect;
        }
        
        public void updateCollectedSide(Core core) {
            this.removeAll();
            this.setCollect(0);
            this.invalidate();
            this.repaint();

            Runnable r = () -> {
                this.repaint();
                this.move(0, 0);
                this.move(0, 0);
            };
            this.revalidate();
            for (Tile t : core.getCurrentPlayer().getCollectedCards()) {
                if (t instanceof AmphoreaTile) {
                    String color = "amphora_" + ((AmphoreaTile) t).getColor();
                    add(new TileUI("images_2020/" + color + ".png", null));
                } else if (t instanceof SphinxTile) {
                    add(new TileUI("images_2020/" + "sphinx" + ".png", null));
                } else if (t instanceof CaryatidTile) {

                    add(new TileUI("images_2020/" + "caryatid" + ".png", null));
                } else if (t instanceof MosaicTile) {
                    String color = "mosaic_" + ((MosaicTile) t).getColor();
                    add(new TileUI("images_2020/" + color + ".png", null));
                } else {
                    String color = "skeleton_" + ((SkeletonTile) t).getColor();
                    add(new TileUI("images_2020/" + color + ".png", null));
                }

            }
            Runnable rr = () -> {
                this.repaint();
                this.move(0, 0);
                this.move(0, 0);
            };

        }
       
        public int getCollect()
        {
        	return this.collect;
        }
    }
}