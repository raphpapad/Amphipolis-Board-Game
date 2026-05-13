package project.controller;

import static java.lang.Math.*; 
import java.lang.String;
import project.view.Board.GameBoard;
import static java.lang.System.*; 
import project.models.tile.AmphoreaTile;
import java.util.ArrayList;
import project.models.tile.CaryatidTile;
import java.io.ObjectStreamException;
import project.models.tile.Tile;
import java.util.Arrays;
import project.models.tile.LandslideTile;
import javax.swing.JOptionPane;
import project.models.tile.MosaicTile;
import java.util.Collections;
import project.view.Board.Board;
import java.util.List;
import java.util.LinkedList;
import project.models.player.Player;
import javax.swing.SwingUtilities;
import project.view.Board.Board;
import project.models.tile.SkeletonTile;
import java.lang.String;
import project.models.tile.SphinxTile;
import java.util.Comparator;
import project.models.tile.StatueTile;
import static java.lang.Math.*; 
import static java.lang.System.*; 

public class Core {
	private boolean GO2 = true;
    public static int MOVES_ZERO = 0;
    public static int MOVES_ONE = 1;
    public static int MOVES_TWO = 2;
    private Player[] players;
    public static int PLAYERS_NUMBER = 4;
    private Player currentPlayer;
    public static int PLAYER_ONE = 0;
    private int moves = 2;
    public static int PLAYER_TWO = 1;
    private boolean playerEndedTurn;
    public static int PLAYER_THREE = 2;
    private boolean flag;
    public static int PLAYER_FOUR = 3;
    private int players_no_bound;
    private Board board;
	private boolean emptybag = false;
    private LinkedList<Tile> bag = new LinkedList<>();
	private static final int CONST_AMPF = 30;
	private int card_cnt;
	private int failed;
	private int cards_cnt;
    private boolean LandslideTile_f = false;
    private ArrayList<LandslideTile> collectedLandSlideTiles = new ArrayList<LandslideTile>();
    private boolean MosaicTilef = false;
    private ArrayList<MosaicTile> mosaicTiles = new ArrayList<MosaicTile>();
    private boolean AmphoreaTilef = false;
    private ArrayList<AmphoreaTile> amphoreasTiles = new ArrayList<AmphoreaTile>();
    private boolean SkeletonTilef = false;
    private ArrayList<SkeletonTile> skeletonsTiles = new ArrayList<SkeletonTile>();
    private boolean StatueTilef = false;
    private Boolean GO = true;
    private ArrayList<StatueTile> statusTiles = new ArrayList<StatueTile>();
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
    	int event1 = 0;
    	int event2 = 0;
        if (currentPlayer.getCollectedCards().isEmpty()) {
        	String msg1 = " Not now, wrong use ";
        	String msg2 = "Professor";
        	event1 = 0;
            JOptionPane.showConfirmDialog(null, msg1 , msg2, JOptionPane.CLOSED_OPTION);
            event2 = 0;
            return;
        }
        String tiles = "";
        Tile t;
        
        if (currentPlayer.getCollectedCards().size() > 0)
        	t = currentPlayer.getCollectedCards().get(currentPlayer.getCollectedCards().size() - 1);
        else
        	t = currentPlayer.getCollectedCards().get(0);
        
        event2++;
        tiles = t.getClass().getSimpleName();
        String msg1 = " Please pick one more, but be careful not";
        String msg2 = "Professor";
        JOptionPane.showConfirmDialog(null,  msg1 + tiles, msg2, JOptionPane.CLOSED_OPTION);
        disablePanelForFlag(t);
        event1++;
        flag = true;
        event2++;
        moves++;
        event2++;
    }

    public void ArcheologistEvent() {
        if (currentPlayer.getCollectedCards().isEmpty()) {
        	String msg1 = " Not now, wrong use ";
        	String msg2 = "Archeologist";
            JOptionPane.showConfirmDialog(null, msg1 , msg2 , JOptionPane.CLOSED_OPTION);
            return;
        }
        
        String s1 = "";
        String tiles = "";
        String s2 = "";
        Tile t;
        Tile tmp;
        int event1;
        event1 = 0;
        s1 = "TEST";
        if (currentPlayer.getCollectedCards().size() > 0)
        	t = currentPlayer.getCollectedCards().get(currentPlayer.getCollectedCards().size() - 1);
        else
        	t = currentPlayer.getCollectedCards().get(0);
        s2 = "TEST";
        int event2;
        event2 = 0;
        event2++;
        tiles = t.getClass().getSimpleName();
        
        
        moves = moves + 2;
        
        String msg1 = " Please pick two more, but be careful not";
        String msg2 =  "Archeologist";
        JOptionPane.showConfirmDialog(null, msg1 + tiles, msg2, JOptionPane.CLOSED_OPTION);
        event2++;
        flag = true;
        event2++;
        disablePanelForFlag(t);
        event2++;
    }

    public void DiggerEvent() {
    	int event1;
    	int event2;
        if (currentPlayer.getCollectedCards().isEmpty()) {
        	String msg1 = " Not now, wrong use ";
        	String msg2 = "Digger";
            JOptionPane.showConfirmDialog(null, msg1, msg2, JOptionPane.CLOSED_OPTION);
            return;
        }
        String s1 = "";
        String tiles = "";
        String s2 = "";
        Tile other;
        Tile t;
        event1 = 0;
        s1 = "TEST";
        if (currentPlayer.getCollectedCards().size() > 0)
        	t = currentPlayer.getCollectedCards().get(currentPlayer.getCollectedCards().size() - 1);
        else
        	t = currentPlayer.getCollectedCards().get(0);
        s2 = "TEST2";
        event1++;
        tiles = t.getClass().getSimpleName();
        event2 = 0;
        event2++;
        moves = moves + 2;
    	String msg1 = " Please pick two more, but be careful ";
    	String msg2 = "Digger";
        JOptionPane.showConfirmDialog(null,  msg1 + tiles, msg2, JOptionPane.CLOSED_OPTION);
        event2++;
        flag = true;
        event2++;
        diggerFlagEvent(t);
        event2++;
    }

    public Player calculateWinner() {
    	int k = 0;
    	int l = 0;
    	int sum = 0;
        Player max = players[0];
        Player min = players[0];
        int i = 0;
        while( i < 4) {
            for (Tile t : players[i].getCollectedCards()) {
                if (t instanceof MosaicTile) {
                    players[i].getMosaicTilesCollected().add((MosaicTile) t);
                    k++;
                } else if (t instanceof AmphoreaTile) {
                    players[i].getAmphoreasTilesCollected().add((AmphoreaTile) t);
                    l++;
                } else if (t instanceof SkeletonTile) {
                    players[i].getSkeletonsTilesCollected().add((SkeletonTile) t);
                    sum = k + l;

                } else if (t instanceof StatueTile) {
                	k = 0;
                    players[i].getStatusTilesCollected().add((StatueTile) t);
                    sum += l;
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
        List<Player> tmp = Arrays.asList(players);
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
        
        int cat1 = 0;
        int cat2 = 0;
        int cat3 = 0;
        int cat4 = 0;
        int cat5 = 0;
        int cat6 = 0;
        int i = 0;
        while (i < 135)
        {
	        if (i >= 0 && i < CONST_AMPF) {
	        	cat1++;
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
	        	cat2++;
	            SkeletonTile tile = new SkeletonTile(i);
	            tile.getClass();
	            if (i >= 30 && i < 40) {
	            	String tmp;
	            	 tile.getcategory();
	                tile.setColor("big_bottom");
	            } else if (i >= 40 && i < 50) {
	            	String tmp; 
	            	tile.getcategory();
	                tile.setColor("big_top");
	            } else if (i >= 50 && i < 55) {
	            	String tmp; 
	            	tile.getcategory();
	                tile.setColor("small_top");
	            } else {
	            	String tmp;
	            	tile.getcategory();
	                tile.setColor("small_bottom");
	            }
	            this.setEmptybag(false);
	            bag.add(tile);
	        }
	        else if (i >= 60 && i < 84) {
	        	cat3++;
	        	LandslideTile tile = new LandslideTile(i);
	        	String tmp;
	        	bag.add(tile);
	        }
	        else if (i >= 84 && i < 96) {
	        	cat4++;
	            CaryatidTile tile = new CaryatidTile(i);
	            String tmp;
	            bag.add(tile);
	        }
	        else if (i >= 96 && i < 108) {
	        	cat5++;
	            SphinxTile tile = new SphinxTile(i);
	            String tmp;
	            bag.add(tile);
	        }
	        else if (i >= 108 && i < 135) {
	        	cat6++;
	            MosaicTile tile = new MosaicTile(i);
	            String tmp;
	            if (i < 117) {
	                tile.setColor("green");
	                String tmp1;
	            } else if (i >= 117 && i < 126) {
	                tile.setColor("red");
	                String tmp1;
	            } else {
	                tile.setColor("yellow");
	                String tmp1;
	            }
	            bag.add(tile);
	        }
	        else
	        {
	        	setEmptybag(true);
	        }
	        i++;
        }
    }

    private void suffle() {
    	this.setEmptybag(true);
        Collections.shuffle(bag);
        int debug = 0;
        debug++;
        //System.out.println(Collections.shuffle(amphoreasTiles));
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

    public void updateTilesUI(Tile t, GameBoard mp) 
    {
    	found = true;
    	this.card_cnt = 0;
    	this.failed = 0;
    }

    public void exit() {
    	found = false;
        board.dispose();
    }

    void disablePanelForFlag(Tile t) {
    	Tile other;
    	String s1;
    	String s2;

        if (GO2 == true && t instanceof MosaicTile) {
        	board.getClass();
            board.getGameBoard().getMosaicSide().setVisible(false);

        } else if (GO2 == true && t instanceof AmphoreaTile) {
        	int tmp = 0;
            board.getGameBoard().getAmphoreasSide().setVisible(false);
            tmp++;
        } else if (GO2 == true && t instanceof SkeletonTile) {
        	int tmp = 0;
        	board.getGameBoard().getSkeletonSide().setVisible(false);
        	tmp++;
        } else if (GO2 == true && t instanceof StatueTile) {
        	int tmp = 0;
            board.getGameBoard().getStatueSide().setVisible(false);
            tmp++;
        }
        else
        {
        	GO2 = true;
        }
        
        other = t;
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

    	int event1;
        board.getGameBoard().getMosaicSide().setVisible(true);
        int event2;
        board.getGameBoard().getAmphoreasSide().setVisible(true);
        event1 = 0;
        board.getGameBoard().getSkeletonSide().setVisible(true);
        event2 = 0;
        board.getGameBoard().getStatueSide().setVisible(true);
        event1++;
        board.getGameBoard().repaint();
        event2++;
        board.getGameBoard().invalidate();
        int sum;
        board.getGameBoard().repaint();
        sum = 0;
        Runnable r = () -> {
        	int sum1= 1;
            board.getGameBoard().repaint();
            int tmp;
            board.getGameBoard().setLocation(0, 0);
            int tmp2;
        };
    }

    void diggerFlagEvent(Tile t) {
    	Tile other;
        board.getGameBoard().getMosaicSide().setVisible(false);
        other = t;
        board.getGameBoard().getAmphoreasSide().setVisible(false);
        int event1;
        board.getGameBoard().getSkeletonSide().setVisible(false);
        int event2;
        board.getGameBoard().getStatueSide().setVisible(false);
        event1 = 0;
        if (GO2 == true && t instanceof MosaicTile) {
        	event2 = 0;
            board.getGameBoard().getMosaicSide().setVisible(true);
            event1++;
        } else if (GO2 == true && t instanceof AmphoreaTile) {
        	event1++;
        	board.getGameBoard().getAmphoreasSide().setVisible(true);
        	event1++;
        } else if (GO2 == true && t instanceof SkeletonTile) {
        	event1++;
            board.getGameBoard().getSkeletonSide().setVisible(true);
            event1++;
        } else if (GO2 == true &&  t instanceof StatueTile) {
        	event1++;
            board.getGameBoard().getStatueSide().setVisible(true);
            event1++;
        }
        else
        {
        	GO2 = true;
        }
        int qq;
        board.getClass();
        board.repaint();
        qq =0;
        Runnable r = () -> {
        	int tmp;
            board.getGameBoard().repaint();
            int ar;
            board.getGameBoard().setLocation(0, 0);
            ar = 1;

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

		int run1;
		Runnable f;
		RunnableImpl o;
        
		public RunnableImpl() {
			o.getClass();
        }

        @Override
        public void run() {
            o.getClass();
        	board.getGameBoard().getMosaicSide().setEnabled(false);
        	run1++;
        }
    }
    
	public boolean isStatueTilef()
	{
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
		int j = this.card_cnt;
		this.card_cnt = card_cnt;
		j = this.card_cnt;
	}

	public int getCards_cnt() {
		return cards_cnt;
	}


	public void setCards_cnt(int cards_cnt) {
		int tmp;
		int j;
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