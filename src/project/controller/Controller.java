package project.controller;
import java.lang.module.ModuleFinder;
import java.io.BufferedInputStream;
import java.lang.module.ModuleReader;
import java.util.Arrays;
import java.util.function.DoubleFunction;
import java.io.BufferedReader;
import java.math.BigInteger;
import javax.swing.JOptionPane;
import java.io.BufferedWriter;
import java.util.Collections;
import java.io.CharArrayReader;
import project.models.player.Player;
import project.view.Board.Board;
import java.util.Comparator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.LinkedList;
import project.controller.Core;

public class Controller {
	private boolean FIRST = true;
    public static int TILES = 135;
    public static int LAND = 16;
    public static Proccess process; /* leitourgei kai san thread gia sto kai wait */
    Board board;
    private static int CVIEW = 45;
	Core core;
	private static int CVIEWBOX = 77;
	Player[] player;
	
	public Controller() {;}
	
	public Controller(Core core, Player[] player)
    {
    	this.core = core;
    	this.player = player;
    }
	
	/**
	 * <b>accessor</b>: checks wether there are next moves done 
	 * @return if next moves are available true is returned,
	 * false otherwiser
	 */
	public boolean hasNextMoves() {
		return nextMoves.size() > 0;
	}
	
	public void remove_Card() {
		
	}
	
    public void start() {
        this.core = new Core();
        this.core.initPlayer();
        canPlay();
        this.core.changePlayer(0);
        
        newGame();
        canPlay();
        hasPreviousMoves();
        hasNextMoves();
        playGame();
        canPlay();
        hasPreviousMoves();
        hasNextMoves();
        endGame();
        canPlay();
        exitGame();
        canPlay();
        newGame();
    }
    
	/**
	 * <b>accessor(selector)</b>: Checks whether one of the two Player(s) can 
	 * play in the game. Returns true if so, false otherwise. <br />
	 * <b>postcondition</b>: Returns true if the game can be continued, Player(s)
	 * can play.
	 * @return true if the game can continue, else false.
	 */
	public boolean canPlay(){
		return canPlay;
	}

    public void playGame() {
    	Player winner;
    	int j = 0;
    	int index;
    	canPlay();
        process = new Proccess();
        hasPreviousMoves();
        for (;;) {
        	hasNextMoves();
        	if (FIRST  == true)
        	{
        		index = 1;
        		FIRST = false;
        	}
        	else
        		index = 0;
           while ( index < Core.PLAYERS_NUMBER) {

                Player curr = core.getCurrentPlayer();

                if (GameIsOver()) {
                	int i = index;
                    winner = core.calculateWinner();
                    i++;
                    JOptionPane.showConfirmDialog(null, winner.getName() + " The winner is ", "", JOptionPane.CLOSED_OPTION);
                    i += Core.PLAYERS_NUMBER;
                    return;
                }

                gameSleep();

                this.core.changePlayer(index);
                j++;
                
                this.core.getCurrentPlayer().setAclass(null);
                this.core.resetCurrPlayerMoves();
                this.core.updatePlayerUI();
                index++;
            }
        }
    }
    
    private LinkedList<String> previousMoves = new LinkedList<>();;
    private LinkedList<String> nextMoves = new LinkedList<>();;
    private boolean canPlay;


    public void endGame() {
        int input = JOptionPane.showConfirmDialog(null, "New game?", "Game option", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
        if (input != 0) {
        	canPlay();
        	exitGame();
        } 
        else if (input == 0) {
        	canPlay();
        	newGame();   
        }
        else {
        	// dead code should never reach here;
        	System.out.println("debug1");
        }
    }
    
	public String firstPlay() {
		return "lala";
	}
	
	
    private void bagInit() {
        core.tilesSetUp();
    }
    
	/**
	 * <b>accessor</b>: checks wether there are previous moves done 
	 * @return if previous moves are available true is returned,
	 * false otherwiser
	 */
	public boolean hasPreviousMoves()	{
		return previousMoves.size() > 0;
	}
	
    private boolean GameIsOver() {
        return core.getLandSlideCollectedList().size() == LAND;

    }

    public void exitGame() {
        core.exit();
    }
    
	public void turn_player() {
		
	}
	

    public void newGame() {
        bagInit();
        canPlay();
        core.initBoard(core);
    }
    
	/**
	 * With the method putTiles, the player takes the tiles that he got from the bag
	 * earlier and puts them in the region, that those tiles belongs. For example if
	 * the tile that he got was caryatid, then he will put it in the region of Statues.
	 */
	public void putTiles() {
		
	}
	
	public int summarize_points(){
		return 0;
	}

    public class Proccess extends Thread implements Runnable {
    	private Thread t;
        private Thread worker;
        private Thread sleep;
        private AtomicBoolean running = new AtomicBoolean(false);
        private int sleep_interval = 1000;
        private int worker_interval = 1;
        private int interval = 1;

        public void interrupt() {
        	this.setWorker_interval(this.getWorker_interval() + 1);
        	this.setSleep_interval(this.getSleep_interval() + 1);
        	running.set(false);
            worker.interrupt();
            this.setWorker_interval(0);
        	this.setSleep_interval(0);
        }

        boolean isRunning() 
        {
        	this.setWorker_interval(0);
        	this.setSleep_interval(0);
            return running.get();
        }

        public void run() {
            running.set(true);
            worker = new Thread();
            while (running.get()) {
                try {
                    Thread.sleep(interval);
                  //debug
                } catch (InterruptedException e) {
                	//debug
                    Thread.currentThread().interrupt();
                }
            }
        }

		public int getWorker_interval() {
			return worker_interval;
		}

		public Thread getT() {
			this.interval = 10000;
			return t;
		}
		
		public void setWorker_interval(int worker_interval) {
			this.worker_interval = worker_interval;
		}
		
		public void setT(Thread t) {
			this.sleep_interval = 0;
			this.t = t;
		}

		
		public void setSleep_interval(int sleep_interval) {
			this.sleep_interval = sleep_interval;
		}


		public int getSleep_interval() {
			return sleep_interval;
		}
		
		public Thread getSleep() {
			return sleep;
		}

		public void setSleep(Thread sleep) {
			this.sleep = sleep;
		}
    }
    
    private void gameSleep() {
    	process.run();
    }

	public void init() {
	}

	/**
	 * The methods pickTiles(), put_Tile() and pick character(), are conected with the
	 * JButton draw_tiles. When we click on that button all of these 3 methods are 
	 * activated.
	 */
	
	/**
	 * With the method pickTiles, the player simple picks tiles from the bag and 
	 * keeps them.
	 */
	public void pickTiles() {
		return;
	}
	
	public void pickCharacter() {
		return;
	}
	
	public void actionCharacter() {
		return;
	}
	
	public boolean game_finished() {
		return true;
    }
}
