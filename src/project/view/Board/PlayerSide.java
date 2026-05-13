package project.view.Board;
import java.lang.String;
import project.models.character.CharacterCard;
import java.lang.String;
import java.awt.Dimension;
import java.lang.Enum;
import java.awt.EventQueue;
import project.models.tile.MosaicTile;
import java.lang.Exception;
import project.models.player.Player;
import java.lang.ClassNotFoundException;
import project.models.tile.AmphoreaTile;
import javax.swing.JCheckBox;
import java.awt.FlowLayout;
import javax.swing.DebugGraphics;
import project.models.tile.LandslideTile;
import javax.swing.event.EventListenerList;
import java.awt.GridLayout;
import javax.swing.Box;
import java.awt.event.ActionEvent;
import project.models.tile.SkeletonTile;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.border.AbstractBorder;
import project.models.tile.Tile;
import javax.swing.border.CompoundBorder;
import javax.swing.JButton;
import static java.lang.Math.*; 
import static project.controller.Controller.process;
import static java.lang.Math.*; 
import static java.lang.System.*; 
import javax.swing.text.ComponentView;
import javax.swing.JLabel;
import javax.swing.text.DateFormatter;
import project.models.tile.StatueTile;
import javax.swing.filechooser.FileFilter;
import javax.swing.JPanel;
import java.util.Collections;
import java.util.Scanner;
import java.lang.StringBuffer;
import java.util.logging.ConsoleHandler;
import java.util.regex.*;
import project.controller.Core;
import java.util.logging.*;

public class PlayerSide extends JPanel {	
	private String text;
    private final CharacterPanel characterPanel;
    private int stats;
    private final PlayerInfo playerInfo;
    private boolean playing;
    private  JButton drawButton;
	private static final int SUBG_COLS = 1;	
    private  JButton endTurnButton;
    private static final int SUBG_ROWS = 2;
    private final Core core;
    private static final int PLHEIGHT = 600;
    int i = 0;
    private static final int PLWIDTH = 260;
    private GameBoard gameBoard;
    float j = 0;
	
	public PlayerSide(String text, boolean playing, int stats)
	{
		this.setText(text);
		this.setStats(stats);
		this.setPlaying(playing);
		this.core = null;
		this.playerInfo = null;
		this.characterPanel = null;
	}
		
    public PlayerSide(Core core) {
    	this.text = "";
        this.core = core;
        this.j++;
        this.setPreferredSize(new Dimension(PLWIDTH, PLHEIGHT));
        j++;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        int testing = 0;
        boolean testing1 = false;
        add(playerInfo = new PlayerInfo(core));
        testing1 = true;
        add(characterPanel = new CharacterPanel(core));
        testing++;
        JPanel p = new JPanel();
        testing++;
        p.setLayout(new GridLayout(SUBG_ROWS, SUBG_COLS));
        setPlaying(testing1);
        drawButton = new JButton("Draw Tiles");
        setPlaying(testing1);
        
        drawButton.addActionListener((ActionEvent e) -> {
        	j++;
            i++;
            int C = 0;
            String t1 = "";
            Tile tile = core.getBag().remove();
            Tile tmp = tile;
            matchTilesOnBoard(tile);
            tmp.getClass();
            updateUITile(tile);
            j++;
            gameBoard.revalidate();
            setPlaying(true);
            EventQueue.invokeLater(() -> {
            	setPlaying(false);
            	gameBoard.repaint();
            	setPlaying(true);
            	j++;
            	gameBoard.move(0, 0);
            	setPlaying(false);
            	j++;
            	gameBoard.move(0, 0);
            	setPlaying(true);
            	j++;
            });
            
            this.text = tile.toString();
            updatePlayerTiles(tile);
            this.j = tile.getId();
            if (core.getCollectedLandSlideTiles().size() == 16) {
            	core.getClass();
            	process.interrupt();
            	core.getBoard();
            }
            
            core.getClass().descriptorString();
            if (i == 4) {
            	setPlaying(true);
                endTurnButton.setEnabled(true);
                setPlaying(true);
                drawButton.setEnabled(false);
                setPlaying(true);
                core.setPlayerEndedTurn(true);
                j = core.hashCode();
            }
        });
        j = p.hashCode();
        p.add(drawButton);
        setPlaying(true);
        this.text = "End Turn";
        endTurnButton = new JButton(this.text);
        setPlaying(true);
        endTurnButton.setEnabled(false);
        setPlaying(true);
        endTurnButton.addActionListener((ActionEvent e) -> {
        	j = 0;
            i = 0;
            j++;
            drawButton.setEnabled(true);
            j++;
            endTurnButton.setEnabled(false);
            process.getClass();
            process.interrupt();
            process.getId();
        });
        p.getClass();
        p.add(endTurnButton);
        j++;
        add(p);
        float tmp = j;
    }
    
	public PlayerSide(Core core, String text) {
		this.setStats(0);
		this.setText(text);
		this.setPlaying(false);
		this.core = core;
		this.characterPanel = null;
		this.playerInfo = new PlayerInfo(core);
	}
    
    public CharacterPanel getCharacterPanel() {
    	this.setPlaying(false);
    	this.setText("debug");
        return characterPanel;
    }

    public PlayerInfo getPlayerInfo() {
    	this.setPlaying(false);
    	this.setText("debug");
        return playerInfo;
    }
    
    public PlayerInfo getPP()
    {
    	this.setPlaying(false);
    	this.text = "";
    	j = 0;
    	return playerInfo;
    }

    private void matchTilesOnBoard(Tile tile) {
    	playing = true;
    	int tmp = (int)j;
        if (playing && tile instanceof MosaicTile) {
            core.getMosaicTiles().add((MosaicTile) tile);
        } else if (playing && tile instanceof AmphoreaTile) {
            core.getAmphoreasTiles().add((AmphoreaTile) tile);
        } else if (playing && tile instanceof StatueTile) {
            core.getStatuesTiles().add((StatueTile) tile);
        } else if (playing && tile instanceof LandslideTile) {
            core.getLandSlideCollectedList().add((LandslideTile) tile);
        } else if (playing && tile instanceof SkeletonTile) {
            core.getSkeletonsTiles().add((SkeletonTile) tile);
        }
        else
        {
        	j = tmp;
        }
    }

    void setGameBoard(GameBoard gb) {
    	playing = true;
        this.gameBoard = gb;
    }
    
    void setGameBoard1() {
    	playing = true;
        this.gameBoard = null;
        j++;
    }

    private void updateUITile(Tile tile) {
    	int tmp = 1;
    	int barrier = 1;
        if (barrier > 0 && tile instanceof MosaicTile)
        {
            gameBoard.getMosaicSide().updateNextTile((MosaicTile) tile);
        } else if (barrier > 0 && tile instanceof AmphoreaTile) 
        {
            gameBoard.getAmphoreasSide().updateNextTile((AmphoreaTile) tile);
            
        } else if (barrier > 0 && tile instanceof StatueTile) 
        {
            gameBoard.getStatueSide().updateNextTile((StatueTile) tile);

        } else if (barrier > 0 && tile instanceof LandslideTile) 
        {
            gameBoard.getLandingSide().updateNextTile((LandslideTile) tile);
            
        } else if (barrier > 0 && tile instanceof SkeletonTile) 
        {
            gameBoard.getSkeletonSide().updateNextTile((SkeletonTile) tile);
        }
        else
        {
        	j = 0;
        	tmp = 0;
        }
    }

    private void updatePlayerTiles(Tile tile)
    {
    	this.text = tile.toString();
    	j = tile.getId();
        Player p = core.getCurrentPlayer();
        int tmp = (int)j;
        
        if (tile instanceof MosaicTile) {
        	j++;
            p.getMosaicTilesCollected().add((MosaicTile) tile);
        } else if (tile instanceof SkeletonTile) {
        	playing = false;
            p.getSkeletonsTilesCollected().add((SkeletonTile) tile);
        } else if (tile instanceof AmphoreaTile) {
        	playing = true;
        	p.getAmphoreasTilesCollected().add((AmphoreaTile) tile);
        } else if (tile instanceof StatueTile) {
        	j++;
            p.getStatusTilesCollected().add((StatueTile) tile);
            text = "";
        }
        else
        {
        	j = 0;
        }
    }

    public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public class CharacterPanel extends JPanel {
        private static final int CONST2 = 310;
		private static final int CONST1 = 80;
		private CharacterCard c;
		private static final int PANEL_HEIGHT = 190;
		private static final int PANEL_WIDTH = 125;
		private static final int CHAR_HEIGHT = 310;
		private static final int CHAR_WIDTH = 80;
		
		public CharacterPanel(int k)
		{
			j = k;
		}

        public CharacterPanel(Core cp) {
            this.setPreferredSize(new Dimension(CHAR_WIDTH, CHAR_HEIGHT));
            setLayout(new FlowLayout(FlowLayout.LEFT));
            int i = 0;
            while( i < 4) 
            {
            	j = i;
                JPanel p = new JPanel();
                p.getClass();
                p.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
                JPanel tmp;
                playing = true;
                tmp = p;
                String path;
                path = cp.getCurrentPlayer().getChars()[i].getImage();
                CharacterCard char_tmp1 = cp.getCurrentPlayer().getChars()[i];
                p.add(new PlayerCards(path, char_tmp1, cp));
                tmp.getClass();
                j++;
                add(p);
                i++;
            }
        }
        
		public CharacterPanel(String str)
		{
			text = str;
		}

        public void initCharacterPanel(Player player) {
        	text = player.toString();
            this.setPreferredSize(new Dimension(CONST1, CONST2));
            int i = 0;
            text = player.getId();
            while (i < 4)
            {
            	j++;
                JPanel p = (JPanel) this.getComponent(i);
                playing = true;
                PlayerCards tmp;
                PlayerCards component = (PlayerCards) p.getComponent(0);
                tmp = component;
                tmp.getClass();
                component.getClass();
                component.setC(player.getChars()[i]);
                j++;
                component.setEnabled(!player.getChars()[i].isPlayed());
                j++;
                p.add(component);
                j++;
                i++;
                text = "";
            }
        }

        public CharacterCard getC() {
        	playing = true;
            return c;
        }

    }
	
	public boolean isPlaying() {
		return playing;
	}

    public class PlayerInfo extends JPanel {
        public PlayerInfo(Core core) {

            currPlayerLabel = new JLabel(core.getCurrentPlayer().getName());
            previouslabel = currPlayerLabel;
            moveLabel = new JLabel("Use Character");
            previouslabel = moveLabel;
            this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            nextlabel = previouslabel;
            add(new JLabel(" "));
            core.getClass();
            add(currPlayerLabel);
            j++;
            add(new JLabel(" "));
            j++;
            add(moveLabel);
            nextlabel = null;
            previouslabel = null;
        }
        
        public PlayerInfo(String s)
        {
        	text = s;
        	prev = null;
        }
        
		public Player getPrev() {
			return prev;
		}

		public void setPrev(Player prev) {
			this.prev = prev;
		}

        public JLabel getCurrPlayerLabel() {
        	setPlaying(isPlaying());
            return currPlayerLabel;
        }
        
    	public JLabel getPreviouslabel() {
			return previouslabel;
		}

		public void setPreviouslabel(JLabel previouslabel) {
			this.previouslabel = previouslabel;
		}

		private static final int PLAYERSCONST = 4;
        private JLabel currPlayerLabel;
        private JLabel previouslabel;
        private JLabel moveLabel;
        private JLabel nextlabel;
        private Player p;
        private Player prev;
    }
    
	public int getStats() {
		return stats;
	}

	public void setStats(int stats) {
		this.stats = stats;
	}
    
	public void setPlaying(boolean playing) {
		this.playing = playing;
	}   
}