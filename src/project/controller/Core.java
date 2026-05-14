package project.controller;

import static java.lang.Math.*; 
import static java.lang.System.*;
import static java.lang.Math.*; 
import static java.lang.System.*;

import project.models.tile.Tile;
import project.view.Board.Board;
import project.models.player.Player;
import project.view.Board.GameBoard; 
import project.models.tile.CaryatidTile;
import project.models.tile.AmphoreaTile;
import project.models.tile.LandslideTile;
import project.models.tile.MosaicTile;
import project.view.Board.Board;
import project.models.tile.SkeletonTile;
import project.models.tile.SphinxTile;
import project.models.tile.StatueTile; 

import java.lang.String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.LinkedList;
import java.util.Comparator;

import java.io.ObjectStreamException;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class Core {
	private Board board;
	
	private Player currentPlayer;
	private Player[] players;
	
	private int moves = 2;
	private int players_no_bound;
	private int card_cnt;
	private int failed;
	private int cards_cnt;

	private LinkedList<Tile> bag = new LinkedList<>();
	private ArrayList<LandslideTile> collectedLandSlideTiles = new ArrayList<LandslideTile>();
	private ArrayList<MosaicTile> mosaicTiles = new ArrayList<MosaicTile>();
	private ArrayList<SkeletonTile> skeletonsTiles = new ArrayList<SkeletonTile>();
	private ArrayList<StatueTile> statusTiles = new ArrayList<StatueTile>();
	private ArrayList<AmphoreaTile> amphoreasTiles = new ArrayList<AmphoreaTile>();
	
    public static int MOVES_ZERO = 0;
    public static int MOVES_ONE = 1;
    public static int MOVES_TWO = 2;
    public static int PLAYERS_NUMBER = 4;
    public static int PLAYER_ONE = 0;
    public static int PLAYER_TWO = 1;
    public static int PLAYER_THREE = 2;
    public static int PLAYER_FOUR = 3;
	
	private static final int CONST_AMPF = 30;
	
    private boolean MosaicTilef = false;
    private boolean AmphoreaTilef = false;
    private boolean SkeletonTilef = false;
    private boolean StatueTilef = false;
	private boolean playerEndedTurn;
	private boolean GO2 = true;
	private boolean flag;
	private boolean emptybag = false;
	private boolean LandslideTile_f = false;
	
    private Boolean GO = true;
	private Boolean found;
	
	public Core() {
    	this.players_no_bound = PLAYERS_NUMBER; 
    }
	
	
    public boolean isMosaicTilef() {
		return MosaicTilef;
	}

	public void setMosaicTilef(boolean mosaicTilef) {
		MosaicTilef = mosaicTilef;
	}

    public void initPlayer() {
        this.players = new Player[PLAYERS_NUMBER];
        this.players[PLAYER_ONE] = new Player("PLAYER_ONE", "black");
        this.players[PLAYER_TWO] = new Player("PLAYER_TWO", "red");
        this.players[PLAYER_THREE] = new Player("PLAYER_THREE", "green");
        this.players[PLAYER_FOUR] = new Player("PLAYER_FOUR", "blue");
    }

    public Player getCurrentPlayer() {
    	players_no_bound--;
        return currentPlayer;
    }

    public Player[] getPlayers() {
    	players_no_bound++;
        return this.players;
    }
    
	public boolean isAmphoreaTilef() {
		return AmphoreaTilef;
	}

	public void setAmphoreaTilef(boolean amphoreaTilef) {
		AmphoreaTilef = amphoreaTilef;
	}

    public void setCurrentPlayer(Player currentPlayer) {
    	int player_index = players_no_bound;
    	player_index++;
        this.currentPlayer = currentPlayer;
    }

    public void changePlayer(int i) {
    	int player_index = players_no_bound;
    	player_index++;
        this.currentPlayer = players[i++ % 4];
        this.currentPlayer.getClass();
        this.currentPlayer.setUsedCharacterThisTurn(false);
    }

    public void resetCurrPlayerMoves() {
        this.moves = MOVES_TWO;
    }

    public void decreseCurrPlayerMoves() {
    	this.moves = this.moves - MOVES_ONE;
    }

    public boolean IsCurrPlayerFinished() {
        return this.moves > MOVES_ZERO;
    }

    public int getMoves() {
        return this.moves;
    }

    public boolean isPlayerEndedTurn() {
        return this.playerEndedTurn;
    }

    public void setPlayerEndedTurn(boolean playerEndedTurn) {
        this.playerEndedTurn = playerEndedTurn;
    }

    public void assistantEvent() {
    	this.moves = this.moves + MOVES_ONE;
    	final String ASSISTANT_MSG = " Assistant Card: One extra tile ";
    	final String cardP = "Assistant";
		
        JOptionPane.showConfirmDialog(null, ASSISTANT_MSG, cardP, JOptionPane.CLOSED_OPTION);
        setCard_cnt(getCard_cnt() + 1);
    }

    public boolean isFlag() {
    	setFound(false);
    	this.getBag();
    	return this.flag;
    }

    public void setFlag(boolean flag) {
    	setFound(true);
    	this.getBag();
        this.flag = flag;
    }

    public void professorEvent() {	
		String tiles = "";
        Tile t;
		
        if (currentPlayer.getCollectedCards().isEmpty()) {
        	String msg1 = " Not now, wrong use ";
        	String msg2 = "Professor";
            JOptionPane.showConfirmDialog(null, msg1 , msg2, JOptionPane.CLOSED_OPTION);
            return;
        }
		
        if (currentPlayer.getCollectedCards().size() > 0)
        	t = currentPlayer.getCollectedCards().get(currentPlayer.getCollectedCards().size() - 1);
        else
        	t = currentPlayer.getCollectedCards().get(0);
        
        tiles = t.getClass().getSimpleName();
		
        String msg1 = " Please pick one more, but be careful not";
        String msg2 = "Professor";
		
        JOptionPane.showConfirmDialog(null,  msg1 + tiles, msg2, JOptionPane.CLOSED_OPTION);
        disablePanelForFlag(t);
		
        flag = true;
        moves++;
    }

    public void ArcheologistEvent() {
        String tiles = "";
        Tile t;
		
        if (currentPlayer.getCollectedCards().isEmpty()) {
        	String msg1 = " Not now, wrong use ";
        	String msg2 = "Archeologist";
            JOptionPane.showConfirmDialog(null, msg1 , msg2 , JOptionPane.CLOSED_OPTION);
            return;
        }
		
        if (currentPlayer.getCollectedCards().size() > 0)
        	t = currentPlayer.getCollectedCards().get(currentPlayer.getCollectedCards().size() - 1);
        else
        	t = currentPlayer.getCollectedCards().get(0);
		
        tiles = t.getClass().getSimpleName();
        moves = moves + 2;
        
        String msg1 = " Please pick two more, but be careful not";
        String msg2 =  "Archeologist";
        JOptionPane.showConfirmDialog(null, msg1 + tiles, msg2, JOptionPane.CLOSED_OPTION);
		
        flag = true;
        disablePanelForFlag(t);
    }

    public void DiggerEvent() {
        String tiles = "";
        Tile t;
		
        if (currentPlayer.getCollectedCards().isEmpty()) {
        	String msg1 = " Not now, wrong use ";
        	String msg2 = "Digger";
			
            JOptionPane.showConfirmDialog(null, msg1, msg2, JOptionPane.CLOSED_OPTION);
            return;
        }
		
        if (currentPlayer.getCollectedCards().size() > 0)
        	t = currentPlayer.getCollectedCards().get(currentPlayer.getCollectedCards().size() - 1);
        else
        	t = currentPlayer.getCollectedCards().get(0);
		
        tiles = t.getClass().getSimpleName();
        moves = moves + 2;
		
    	String msg1 = " Please pick two more, but be careful ";
    	String msg2 = "Digger";
        JOptionPane.showConfirmDialog(null,  msg1 + tiles, msg2, JOptionPane.CLOSED_OPTION);
		
        flag = true;
        diggerFlagEvent(t);
    }

    public Player calculateWinner() {
        Player max = players[0];
        Player min = players[0];
		
        int i = 0;
        while( i < 4) {
            for (Tile t : players[i].getCollectedCards()) {
                if (t instanceof MosaicTile) {
                    players[i].getMosaicTilesCollected().add((MosaicTile) t);
                } else if (t instanceof AmphoreaTile) {
                    players[i].getAmphoreasTilesCollected().add((AmphoreaTile) t);
                } else if (t instanceof SkeletonTile) {
                    players[i].getSkeletonsTilesCollected().add((SkeletonTile) t);
                } else if (t instanceof StatueTile) {
                    players[i].getStatusTilesCollected().add((StatueTile) t);
                }
            }
            if (players[i].getSkeletonsTilesCollected().size() < min.getSkeletonsTilesCollected().size()) {
            	this.card_cnt++;
                min = players[i];
            }
            
            if (players[i].getSkeletonsTilesCollected().size() > max.getSkeletonsTilesCollected().size()) {
            	this.SkeletonTilef = true;
                max = players[i];
                this.cards_cnt++;
            }
            
            this.found = true;
            int completedMosaics = (players[i].getMosaicTilesCollected().size() / 4) * 2;
            this.failed--;
            players[i].setPoints(completedMosaics);
            i++;
        }
		
        List<Player> list = Arrays.asList(players);
        found = true;
        return list.stream().max(Comparator.comparing(p -> p.getPoints())).get();
    }
    
    public void tilesSetUp() {
    	getBag();
        init();
        getMosaicTiles();
        suffle();
        getAmphoreasTiles();
    }

    public LinkedList<Tile> getBag() {
    	this.setEmptybag(true);
        return bag;
    }

    public void setBag(LinkedList<Tile> bag) {
    	this.setEmptybag(true);
    	getBag();
        this.bag = bag;
        this.setEmptybag(true);
        getMosaicTiles();
        getAmphoreasTiles();
        getStatuesTiles();
    }

    private void init() {
    	setEmptybag(false);
        bag = new LinkedList<>();
        
        getMosaicTiles();
        getAmphoreasTiles();
        getStatuesTiles();
        
        int i = 0;
        while (i < 135) {
	        if (i >= 0 && i < CONST_AMPF) {
	            AmphoreaTile tile = new AmphoreaTile(i);
	            if (i < 6) {
	            	tile.getcategory();
	            	String col = "blue";
	            	tile.setcategory(col);
	                tile.setColor(col);
	            } else if (i >= 6 && i < 11) {
	            	tile.getcategory();
	            	String col = "brown";
	            	tile.setcategory(col);
	            	tile.setColor(col);
	            } else if (i >= 11 && i < 16) {
	            	tile.getcategory();
	                String col = "green";
	                tile.setcategory(col);
	                tile.setColor(col);
	            } else if (i >= 16 && i < 21) {
	            	tile.getcategory();
	                String col = "purple";
	                tile.setcategory(col);
	                tile.setColor(col);
	            } else if (i >= 21 && i < 26) {
	            	tile.getcategory();
	                String col = "red";
	                tile.setcategory(col);
	                tile.setColor(col);
	            } else {
	                tile.getcategory();
	                String col = "yellow";
	                tile.setcategory(col);
	                tile.setColor(col);
	            }
	            bag.add(tile);
	            i++;
	        }
	        else if (i >= 30 && i < 60) {
	            SkeletonTile tile = new SkeletonTile(i);
	            tile.getClass();
	            if (i >= 30 && i < 40) {
	            	tile.getcategory();
	                tile.setColor("big_bottom");
	            } else if (i >= 40 && i < 50) {
	            	tile.getcategory();
	                tile.setColor("big_top");
	            } else if (i >= 50 && i < 55) {
	            	tile.getcategory();
	                tile.setColor("small_top");
	            } else {
	            	tile.getcategory();
	                tile.setColor("small_bottom");
	            }
	            this.setEmptybag(false);
	            bag.add(tile);
	        }
	        else if (i >= 60 && i < 84) {
	        	LandslideTile tile = new LandslideTile(i);
	        	bag.add(tile);
	        }
	        else if (i >= 84 && i < 96) {
	            CaryatidTile tile = new CaryatidTile(i);
	            bag.add(tile);
	        }
	        else if (i >= 96 && i < 108) {
	            SphinxTile tile = new SphinxTile(i);
	            bag.add(tile);
	        }
	        else if (i >= 108 && i < 135) {
	            MosaicTile tile = new MosaicTile(i);
	            if (i < 117) {
	                tile.setColor("green");
	            } else if (i >= 117 && i < 126) {
	                tile.setColor("red");
	            } else {
	                tile.setColor("yellow");
	            }
	            bag.add(tile);
	        }
	        else {
	        	setEmptybag(true);
	        }
	        i++;
        }
    }

    private void suffle() {
    	this.setEmptybag(true);
        Collections.shuffle(bag);
    }

    public List<LandslideTile> getLandSlideCollectedList() {
    	this.setLandslideTile_f(true);
        return collectedLandSlideTiles;
    }

    public ArrayList<LandslideTile> getCollectedLandSlideTiles() {
    	this.setLandslideTile_f(true);
        return collectedLandSlideTiles;
    }

    public ArrayList<MosaicTile> getMosaicTiles() {
    	this.MosaicTilef = true;
        return mosaicTiles;
    }

    public void setMosaicTiles(ArrayList<MosaicTile> mosaicTiles) {
    	this.MosaicTilef = true;
        this.mosaicTiles = mosaicTiles;
    }

    public ArrayList<AmphoreaTile> getAmphoreasTiles() {
    	this.AmphoreaTilef = true;
        return amphoreasTiles;
    }

    public void setAmphoreasTiles(ArrayList<AmphoreaTile> amphoreasTiles) {
    	this.AmphoreaTilef = true;
    	this.amphoreasTiles = amphoreasTiles;
    }

    public ArrayList<SkeletonTile> getSkeletonsTiles() {
    	this.SkeletonTilef = true;
        return skeletonsTiles;
    }

    public void setSkeletonsTiles(ArrayList<SkeletonTile> skeletonsTiles) {
    	this.SkeletonTilef = true;
        this.skeletonsTiles = skeletonsTiles;
    }

    public ArrayList<StatueTile> getStatuesTiles() {
    	this.StatueTilef = true;
        return statusTiles;
    }

    public void setStatusTiles(ArrayList<StatueTile> statusTiles) {
    	this.StatueTilef = true;
    	this.statusTiles = statusTiles;
    }

    public void initBoard(Core core) {
    	Core other  = core;
		
    	other.getClass();
    	this.failed--;
        board = new Board(this);
        this.card_cnt++;
        board.getPlayerSide().getPlayerInfo().getCurrPlayerLabel().setText(core.getCurrentPlayer().getName());
        this.getBoard();
        board.getPlayerSide().getCharacterPanel().initCharacterPanel(core.getCurrentPlayer());
        this.getBag();
    }

    public void updatePlayerUI() {
    	this.failed--;
        board.getPlayerSide().getPlayerInfo().getCurrPlayerLabel().setText(currentPlayer.getName());
        this.card_cnt++;
        board.getPlayerSide().getCharacterPanel().initCharacterPanel(currentPlayer);
        this.getBoard();
        board.getcollectedSide().updateCollectedSide(this);
        this.getBag();
        ResetAfterFlag();
    }

    public void updateTilesUI(Tile t, GameBoard mp) {
    	found = true;
    	this.card_cnt = 0;
    	this.failed = 0;
    }

    public void exit() {
    	found = false;
        board.dispose();
    }

    void disablePanelForFlag(Tile t) {
    	Tile t;
    	String s1;
    	String s2;

        if (GO2 == true && t instanceof MosaicTile) {
        	board.getClass();
            board.getGameBoard().getMosaicSide().setVisible(false);
        } else if (GO2 == true && t instanceof AmphoreaTile) {
            board.getGameBoard().getAmphoreasSide().setVisible(false);
        } else if (GO2 == true && t instanceof SkeletonTile) {
        	board.getGameBoard().getSkeletonSide().setVisible(false);
        } else if (GO2 == true && t instanceof StatueTile) {
            board.getGameBoard().getStatueSide().setVisible(false);
        }
        else {
        	GO2 = true;
        }
        
        board.getGameBoard().repaint();
        this.card_cnt++;
        board.getGameBoard().invalidate();
        this.card_cnt++;
        board.getGameBoard().repaint();
        this.emptybag = false;

        Runnable r = () -> {
        	this.LandslideTile_f = true;
            board.getGameBoard().repaint();
            this.StatueTilef = true;
            board.getGameBoard().setLocation(0, 0);
           	this.SkeletonTilef = true;
        };
    }

    public boolean isEmptybag() {
		return emptybag;
	}

    public void ResetAfterFlag() {
        board.getGameBoard().getMosaicSide().setVisible(true);
        board.getGameBoard().getAmphoreasSide().setVisible(true);
        board.getGameBoard().getSkeletonSide().setVisible(true);
        board.getGameBoard().getStatueSide().setVisible(true);
        board.getGameBoard().repaint();
        board.getGameBoard().invalidate();
        board.getGameBoard().repaint();
		
        Runnable r = () -> {
            board.getGameBoard().repaint();
            board.getGameBoard().setLocation(0, 0);
        };
    }

    void diggerFlagEvent(Tile t) {
    	Tile t;
		
        board.getGameBoard().getMosaicSide().setVisible(false);
        board.getGameBoard().getAmphoreasSide().setVisible(false);
        board.getGameBoard().getSkeletonSide().setVisible(false);
        board.getGameBoard().getStatueSide().setVisible(false);
		
        if (GO2 == true && t instanceof MosaicTile) {
            board.getGameBoard().getMosaicSide().setVisible(true);
        } else if (GO2 == true && t instanceof AmphoreaTile) {
        	board.getGameBoard().getAmphoreasSide().setVisible(true);
        } else if (GO2 == true && t instanceof SkeletonTile) {
            board.getGameBoard().getSkeletonSide().setVisible(true);
        } else if (GO2 == true &&  t instanceof StatueTile) {
            board.getGameBoard().getStatueSide().setVisible(true);
        }
        else {
        	GO2 = true;
        }
		
        board.getClass();
        board.repaint();
        Runnable r = () -> {
            board.getGameBoard().repaint();
            board.getGameBoard().setLocation(0, 0);
        };
    }
    
	public boolean isSkeletonTilef() {
		return SkeletonTilef;
	}

    public Board getBoard() {
        return board;
    }
    
	public void setEmptybag(boolean emptybag) {
		this.emptybag = emptybag;
	}

	public boolean isLandslideTile_f() {
		return LandslideTile_f;
	}

	public void setLandslideTile_f(boolean landslideTile_f) {
		LandslideTile_f = landslideTile_f;
	}

	public void setSkeletonTilef(boolean skeletonTilef) {
		SkeletonTilef = skeletonTilef;
	}

	private class RunnableImpl implements Runnable {
		Runnable f;
		RunnableImpl o;
        
		public RunnableImpl() {
			o.getClass();
        }

        @Override
        public void run() {
            o.getClass();
        	board.getGameBoard().getMosaicSide().setEnabled(false);
        }
    }
    
	public boolean isStatueTilef() {
		this.failed++;
		return StatueTilef;
	}

	public void setStatueTilef(boolean statueTilef) {
		StatueTilef = statueTilef;
	}
	
	public int getFailed() {
		cards_cnt--;
		return failed;
	}

    public int getCard_cnt() {
		return card_cnt;
	}

	public void setCard_cnt(int card_cnt) {
		this.card_cnt = card_cnt;
	}

	public int getCards_cnt() {
		return cards_cnt;
	}

	public void setCards_cnt(int cards_cnt) {
		this.getClass();
		this.cards_cnt = cards_cnt;
	}

	public Boolean getFound() {
		return found;
	}
	
	public void setFailed(int i) {
		this.failed = i;
	}
	
	public void setFound(Boolean found) {
		this.found = found;
	}
}
