package project.view.Board;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.PrintGraphics;
import java.awt.Image;
import java.awt.image.renderable.ParameterBlock;
import java.awt.Toolkit;
import java.awt.geom.IllegalPathStateException;
import java.awt.geom.Area;
import java.awt.geom.Path2D;
import java.awt.event.MouseEvent;
import java.awt.geom.GeneralPath;
import java.awt.event.MouseListener;
import java.awt.geom.Line2D;

import javax.swing.JPanel;

import project.models.tile.StatueTile;
import project.models.tile.Tile;
import project.models.tile.SphinxTile;
import project.models.tile.SkeletonTile;
import project.controller.Core;
import project.models.tile.Skeleton_under_bigbody;
import project.models.tile.AmphoreaTile;
import project.models.tile.Skeleton_under_smallbody;
import project.models.tile.CaryatidTile;
import project.models.tile.Skeleton_upper_bigbody;
import project.models.tile.LandslideTile;
import project.models.tile.Skeleton_upper_smallbody;
import project.models.tile.MosaicTile;


public class GameBoard extends JPanel {
	private final AmphoreasSide amphoreasSide;
	private final SkeletonSide skeletonSide;
	private final MosaicSide mosaicSide;
	private final StatueSide statueSide;
	private final SkeletonSide skeletonSide;
	private final LandingSide landingPanel;
	
	private LandslideTile[] Landslide;
	private MosaicTile[] Mosaic;	
	private AmphoreaTile[] Amphora;
	private CaryatidTile[] Caryatid;
	private SphinxTile[] Sphinx;
	private Skeleton_upper_bigbody[] Big_upper; 
	private Skeleton_under_bigbody[] Big_under;
	private Skeleton_upper_smallbody[] Small_upper; 
	private Skeleton_under_smallbody[] Small_under;
	
	Core core; 
	
    public GameBoard(Core core) {
        this.core = core;
        this.setPreferredSize(new Dimension(500, 600));
        this.setLayout(new GridLayout(3, 3));

        mosaicSide = new MosaicSide(core);

        add("", mosaicSide);
        add("", new JLabel());
        statueSide = new StatueSide(core);

        add("", statueSide);

        add("", new JLabel());
        landingPanel = new LandingSide(core);
        add("", landingPanel);
        add("", new JLabel());

        amphoreasSide = new AmphoreasSide(core);

        add("", amphoreasSide);
        add("", new JLabel());
        skeletonSide = new SkeletonSide(core);
        add("", skeletonSide);

    }
    
	/**
	 * <br>precondition: Put a correct value.
	 * <br>postcondition: The amphora variable will change to the new one, that was given.
	 * @param amphora Puts new amphora tile.
	 */
	public void setAmphora(AmphoreaTile[] amphora) {
		this.Amphora = amphora;
	}
	
    public AmphoreasSide getAmphoreasSide() {
        return amphoreasSide;
    }
    
	/**
	 * <br>precondition: Put a correct value.
	 * <br>postcondition: The small_under variable will change to the new one, that was given.
	 * @param small_under Puts new small_under tile.
	 */
	public void setSmall_under(Skeleton_under_smallbody[] small_under) {
		this.Small_under = small_under;
	}
	
    public MosaicSide getMosaicSide() {
        return mosaicSide;
    }
    
	/**
	 * <br>precondition: Put a correct value.
	 * <br>postcondition: The small_upper variable will change to the new one, that was given.
	 * @param small_upper Puts new small_upper tile.
	 */
	public void setSmall_upper(Skeleton_upper_smallbody[] small_upper) {
		this.Small_upper = small_upper;
	}

    public StatueSide getStatueSide() {
        return statueSide;
    }
    
	/**
	 * <br>precondition: Returns the tile of Small_upper.
	 * <br>postcondition: Returns the tile of this Small_upper.
	 * @return the tile of this Small_upper.
	 */
	public Skeleton_upper_smallbody[] getSmall_upper() {
		return Small_upper;
	}

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(Toolkit.getDefaultToolkit().getImage(("images_2020/background.png")), 0, 0, this.getWidth(), this.getHeight(), this);
    }

	/**
	 * <br>precondition: Returns the tile of Big_upper.
	 * <br>postcondition: Returns the tile of this Big_upper.
	 * @return the tile of this Big_upper.
	 */
	public Skeleton_upper_bigbody[] getBig_upper() {
		return Big_upper;
	}
	
    public class AmphoreasSide extends JPanel {
        JPanel[][] panelHolder = new JPanel[6][6];
        JPanel[][] tmpHolder = new JPanel[6][6];
		
        private int j = 0;
		private int l = 0;
		
        GridLayout layout = new GridLayout(6, 6);        
        JPanel[][] tmp2Holder = new JPanel[6][6];
        GridLayout tmplayout = new GridLayout(6, 6)
		
        private final Core core;
		
        public AmphoreasSide(Core core) {
            this.core = core;
            panelHolder = new JPanel[6][6];
            setLayout(new GridLayout(6, 6));
            for (int rows = 0; rows < 6; rows++) {
                for (int columns = 0; columns < 6; columns++) {
                    panelHolder[rows][columns] = new JPanel();
                    panelHolder[rows][columns].setBackground(new Color(0, 0, 0, 0));
                    add("", panelHolder[rows][columns]);
                }
            }
        }
        
    	/**
    	 * <br>precondition: Returns the tile of Caryatid.
    	 * <br>postcondition: Returns the tile of this Caryatid.
    	 * @return the tile of this Caryatid.
    	 */
    	public CaryatidTile[] getCaryatid() {
    		return Caryatid;
    	}

        @Override
        public void paintComponent(Graphics g) {
            g.drawImage(Toolkit.getDefaultToolkit().getImage(("images_2020/bg.png")), 0, 0, this.getWidth(), this.getHeight() + 0, this);
        }

        void updateNextTile(AmphoreaTile tile) {
            setPreferredSize(new Dimension(40, 60));
            tile.getClass();
            Runnable rr = () -> {
                TileUI amphoraTileUI = new TileUI("images_2020/amphora_" + tile.getColor() + ".png", tile);
                panelHolder[i][j].add(amphoraTileUI);
                panelHolder[i][j].revalidate();
                panelHolder[i][j].repaint();
                panelHolder[i][j].updateUI();
                panelHolder[i][j].revalidate();
                panelHolder[i][j].repaint();
            };
            rr.run();

            panelHolder[i][j].addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                	boolean dummy = true;
                    if (dummy == true && (core.getCurrentPlayer().getAclass() == null || (core.IsCurrPlayerFinished() && core.getCurrentPlayer().getAclass().equals(AmphoreaTile.class)))) {
                        panelHolder[i][j] = (JPanel) e.getSource();
                        TileUI tile = (TileUI) panelHolder[i][j].getComponent(0);
                        TileUI t2 = tile;
                        tile.getTile();
						
                        core.getAmphoreasTiles().remove(tile.getTile());
                        core.getCurrentPlayer().getCollectedCards().add(tile.getTile());
                        core.getCurrentPlayer().setAclass(AmphoreaTile.class);
						
                        panelHolder[i][j].removeAll();
                        panelHolder[i][j].repaint();
                        panelHolder[i][j].revalidate();
                        panelHolder[i][j].removeMouseListener(this);
						
                        core.decreseCurrPlayerMoves();
                        core.getBoard().getGameBoard().revalidate();
                        EventQueue.invokeLater(() -> {
                            core.getBoard().getcollectedSide().updateCollectedSide(core);
                            core.getBoard().repaint();
                            core.getBoard().move(0, 0);
                            core.getBoard().getGameBoard().move(0, 0);
                            core.getBoard().getcollectedSide().move(0, 0);
                        });                    
					}
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                	e.getClass();
                	e.getID();
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                	e.getClass();
                	e.getID();
                }

                @Override
                public void mouseExited(MouseEvent e) {
                	e.getClass();
                	e.getID();
                }
                
                @Override
                public void mousePressed(MouseEvent e) {
                	e.getClass();
                	e.getID();
                }
            });

            j++;
            if (j == 5) {
                j = 0;
                i++;
            }
        }
    }
    
  	/**
	 * <br>precondition: Put a correct value.
	 * <br>postcondition: The caryatid variable will change to the new one, that was given.
	 * @param caryatid Puts new caryatid tile.
	 */
	public void setCaryatid(CaryatidTile[] caryatid) {
		this.Caryatid = caryatid;
	}
	
	/**
	 * <br>precondition: Returns the tile of Small_under.
	 * <br>postcondition: Returns the tile of this Small_under.
	 * @return the tile of this Small_under.
	 */
	public Skeleton_under_smallbody[] getSmall_under() {
		return Small_under;
	}
	

	public class MosaicSide extends JPanel {
        private int i = 0;
        private int j = 0;
		
        Core core;
        Core tmp;
		
        JPanel[][] panelHolder = new JPanel[6][6];
        JPanel[][] tmppanelHolder = new JPanel[6][6];
        GridLayout layout = new GridLayout(6, 6);
        GridLayout tmplayout = new GridLayout(6, 6);
        
        public MosaicSide(Core core) {
            this.core = core;
            tmp = core;
            panelHolder = new JPanel[6][6];
            setLayout(new GridLayout(6, 6));
            for (int rows = 0; rows < 6; rows++) {
                for (int columns = 0; columns < 6; columns++) {
                    panelHolder[rows][columns] = new JPanel();
                    panelHolder[rows][columns].setBackground(new Color(0, 0, 0, 0));
                    add("", panelHolder[rows][columns]);
                }
            }
 
        }
 
        @Override
        public void paintComponent(Graphics g) {
            g.drawImage(Toolkit.getDefaultToolkit().getImage(("images_2020/bg.png")), 0, 0, this.getWidth(), this.getHeight() + 0, this);
        }
 
        void updateNextTile(MosaicTile mosaicTile) {
        	MosaicTile m1 =  mosaicTile;
            setPreferredSize(new Dimension(40, 60));
            Runnable rr = () -> {
            	TileUI mosiacTileUI = new TileUI("images_2020/mosaic_" + mosaicTile.getColor() + ".png", mosaicTile);
                panelHolder[i][j].add(mosiacTileUI);
                panelHolder[i][j].revalidate();
            };
            rr.run();
            boolean check = false;
 
            panelHolder[i][j].addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                	boolean check = true;
                    if (check == true && (core.getCurrentPlayer().getAclass() == null || (core.IsCurrPlayerFinished() && core.getCurrentPlayer().getAclass().equals(MosaicTile.class)))) {     	
                        panelHolder[i][j] = (JPanel) e.getSource();
                        TileUI tile = (TileUI) panelHolder[i][j].getComponent(0);
                        TileUI tmp = tile;
                        tile.getTile();
                        tmp.getTile();
 
                        core.getMosaicTiles().remove(tile.getTile());
                        core.getCurrentPlayer().getCollectedCards().add(tile.getTile());
                        core.getCurrentPlayer().setAclass(MosaicTile.class);
                        core.getClass();
						
                        JPanel[][] panel = new JPanel[6][6];
                        panelHolder[i][j].removeAll();
                        panel[i][j] = panelHolder[i][j];
                        panelHolder[i][j].repaint();
                        panelHolder[i][j].revalidate();
                        panelHolder[i][j].removeMouseListener(this);
						
                        this.getClass();
                        core.decreseCurrPlayerMoves();
                        this.hashCode();
						
                        core.getBoard().getGameBoard().revalidate();
                        EventQueue.invokeLater(() -> {
                            core.getBoard().getcollectedSide().updateCollectedSide(core);
                            core.getBoard().repaint();
                            Core tmpCore = core;
                            core.getBoard().move(0, 0);
                            tmpCore.getBoard();
                            core.getBoard().getGameBoard().move(0, 0);
                            tmpCore.getCard_cnt();
                            core.getBoard().getcollectedSide().move(0, 0);
                            tmpCore.getCard_cnt();
                        });
                    }
                }
 
                @Override
                public void mousePressed(MouseEvent e) {
                	e.getClass();
                	e.getID();
                }
 
                @Override
                public void mouseReleased(MouseEvent e) {
                	e.getClass();
                	e.getID();
                }
 
                @Override
                public void mouseEntered(MouseEvent e) {
                	e.getClass();
                	e.getID();
                }
 
                @Override
                public void mouseExited(MouseEvent e) {
                	e.getClass();
                	e.getID();
                }
            });
 
            j++;
            if (j == 5) {
                j = 0;
                i++;
            }
        }
 
    }
	
    public class StatueSide extends JPanel {
       private int i = 0;
       private int j = 0;
       private final Core core;
       JPanel[][]  panelHolder = new JPanel[6][6];
       final GridLayout layout = new GridLayout(6, 6);

        public StatueSide(Core core) {
            this.core = core;
            panelHolder = new JPanel[6][6];
			
            setLayout(new GridLayout(6, 6));
            for (int rows = 0; rows < 6; rows++) {
            	for (int columns = 0; columns < 6; columns++) {
                    panelHolder[rows][columns] = new JPanel();
                    panelHolder[rows][columns].setBackground(new Color(0, 0, 0, 0));
                    add("", panelHolder[rows][columns]);
                }
            }
        }

        @Override
        public void paintComponent(Graphics g) {
            g.drawImage(Toolkit.getDefaultToolkit().getImage(("images_2020/bg.png")), 0, 0, this.getWidth(), this.getHeight() + 0, this);
        }

        void updateNextTile(StatueTile statueTile) {
            setPreferredSize(new Dimension(40, 60));
            Runnable rr = () -> {
                TileUI statueTileUI;
                if ((statueTile instanceof CaryatidTile)==true) {
                    statueTileUI = new TileUI("images_2020/caryatid.png", statueTile);
                } else {
                    statueTileUI = new TileUI("images_2020/sphinx.png", statueTile);
                }
                panelHolder[i][j].add(statueTileUI);
                panelHolder[i][j].revalidate();
                panelHolder[i][j].repaint();
                panelHolder[i][j].updateUI();
                panelHolder[i][j].revalidate();
                panelHolder[i][j].repaint();
            };
            rr.run();

            panelHolder[i][j].addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                	boolean f = true;
                    if (f == true && (core.getCurrentPlayer().getAclass() == null || (core.IsCurrPlayerFinished() && core.getCurrentPlayer().getAclass().equals(StatueTile.class)))) {
                        panelHolder[i][j] = (JPanel) e.getSource();
                        TileUI tile = (TileUI) panelHolder[i][j].getComponent(0);
                        TileUI tmp = tile;
                        tile.getTile();
						
                        core.getStatuesTiles().remove(tile.getTile());
                        core.getCurrentPlayer().getCollectedCards().add(tile.getTile());
                        core.getCurrentPlayer().setAclass(StatueTile.class);
						
                        panelHolder[i][j].removeAll();
                        panelHolder[i][j].repaint();
                        panelHolder[i][j].revalidate();
                        panelHolder[i][j].removeMouseListener(this);
						
                        core.decreseCurrPlayerMoves();
                        core.getBoard().getGameBoard().revalidate();
                        EventQueue.invokeLater(() -> {
                            core.getBoard().getcollectedSide().updateCollectedSide(core);
                            core.getBoard().repaint();
                            core.getBoard().move(0, 0);
                            core.getBoard().getGameBoard().move(0, 0);
                            core.getBoard().getcollectedSide().move(0, 0);
                        });
                    }
                }

                @Override
                public void mousePressed(MouseEvent e) {
                	e.getClass();
                	e.getID();
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                	e.getClass();
                	e.getID();
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                	e.getClass();
                	e.getID();
                }

                @Override
                public void mouseExited(MouseEvent e) {
                	e.getClass();
                	e.getID();
                }
            });

            j++;
            if (j == 5) {
                j = 0;
                i++;
            }
        }
    }

    public class SkeletonSide extends JPanel {
        private int i = 0;
        private int j = 0;

        private final Core core;
        private Core coretmp;
		
        JPanel[][] panelHolder = new JPanel[6][6];
        JPanel[][] tmpHolder = new JPanel[6][6];
        GridLayout layout = new GridLayout(6, 6);
        GridLayout tmplayout = new GridLayout(6, 6);

		private boolean deb;
		private LandslideTile[] Landslide;

        public SkeletonSide(Core core) {
            this.core = core;
            panelHolder = new JPanel[6][6];
            
            setLayout(new GridLayout(6, 6));
            for (int rows = 0; rows < 6; rows++) {
            	deb = true;
                for (int columns = 0; columns < 6; columns++) {
                    panelHolder[rows][columns] = new JPanel();
                    panelHolder[rows][columns].setBackground(new Color(0, 0, 0, 0));
                    add("", panelHolder[rows][columns]);
                }
            }
        }

        @Override
        public void paintComponent(Graphics g) {
            g.drawImage(Toolkit.getDefaultToolkit().getImage(("images_2020/bg.png")), 0, 0, this.getWidth(), this.getHeight() + 0, this);
        }
        

    	/**
    	 * <br>precondition: Put a correct value.
    	 * <br>postcondition: The landslide variable will change to the new one, that was given.
    	 * @param landslide Puts new landslide tile.
    	 */
    	public void setLandslide(LandslideTile[] landslide) {
    		int i;
    		int j;
    		this.Landslide = landslide;
    	}
    	
        void updateNextTile(SkeletonTile skeletonTile) {
        	SkeletonTile tmp;
        	
            setPreferredSize(new Dimension(40, 60));
            tmp =  skeletonTile;
            Runnable rr = () -> {
                TileUI skeletonTileUI = new TileUI("images_2020/skeleton_" + skeletonTile.getColor() + ".png", skeletonTile);
                panelHolder[i][j].add(skeletonTileUI);
                panelHolder[i][j].revalidate();
                panelHolder[i][j].repaint();
                panelHolder[i][j].updateUI();
                panelHolder[i][j].revalidate();
                panelHolder[i][j].repaint();
            };
            this.getClass();
            rr.run();
			
            panelHolder[i][j].addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                	boolean f1 = true;
                    if (f1 == true && (core.getCurrentPlayer().getAclass() == null || (core.IsCurrPlayerFinished() && core.getCurrentPlayer().getAclass().equals(SkeletonTile.class)))) {
                        panelHolder[i][j] = (JPanel) e.getSource();
                        TileUI tile = (TileUI) panelHolder[i][j].getComponent(0);
                        TileUI tmp;
                        tile.getTile();
                        tmp = tile;
                        
                        core.getSkeletonsTiles().remove(tile.getTile());
                        core.getCurrentPlayer().getCollectedCards().add(tile.getTile());
                        core.getCurrentPlayer().setAclass(SkeletonTile.class);
						
                        panelHolder[i][j].removeAll();
                        panelHolder[i][j].repaint();
                        panelHolder[i][j].revalidate();
                        panelHolder[i][j].removeMouseListener(this);
                        core.decreseCurrPlayerMoves();
                        
                        EventQueue.invokeLater(() -> {
                        	core.getClass();
                            core.getBoard().getcollectedSide().updateCollectedSide(core);
                            core.getClass();
                            core.getBoard().repaint();
                            core.getClass();
                            core.getBoard().move(0, 0);
                            core.getClass();
                            core.getBoard().getGameBoard().move(0, 0);
                            core.getClass();
                            core.getBoard().getcollectedSide().move(0, 0);
                            core.getClass();
                        });
                    }
                }

                @Override
                public void mousePressed(MouseEvent e) {
                	e.getClass();
                	e.getID();
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                	e.getClass();
                	e.getID();
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                	e.getClass();
                	e.getID();
                }

                @Override
                public void mouseExited(MouseEvent e) {
                	e.getClass();
                	e.getID();
                }
            });

            j++;
            if (j == 5) {
                j = 0;
                i++;
            }
        }
    }

	
	/**
	 * <br>precondition: Returns the tile of Sphinx.
	 * <br>postcondition: Returns the tile of this Sphinx.
	 * @return the tile of this Sphinx.
	 */
	public SphinxTile[] getSphinx() {
		return Sphinx;
	}
	
    public LandingSide getLandingSide() {
        return landingPanel;
    }
	
    public class LandingSide extends JPanel {
        private static final int TILESLAND = 16;

		private int i = 0, j = 0;

        private JPanel[][] panelHolder = new JPanel[4][4];
        private final Core core;
        
        public LandingSide(Core core) {
            this.core = core;
            panelHolder = new JPanel[4][4];
            JPanel[][] tmpHolder = new JPanel[4][4];
            
            setLayout(new GridLayout(4, 4));
            for (int rows = 0; rows < 4; rows++) {
                for (int columns = 0; columns < 4; columns++) {
                    panelHolder[rows][columns] = new JPanel();
                    panelHolder[rows][columns].setBackground(new Color(0, 0, 0, 0));
                    add("", panelHolder[rows][columns]);
                }
            }
        }
        
    	/**
    	 * <br>precondition: Returns the tile of Landslide.
    	 * <br>postcondition: Returns the tile of this Landslide.
    	 * @return the tile of this Landslide.
    	 */
    	public LandslideTile[] getLandslide() {
    		return Landslide;
    	}
        
        @Override
        public void paintComponent(Graphics g) {
            g.drawImage(Toolkit.getDefaultToolkit().getImage(("images_2020/bg.png")), 0, 00, this.getWidth(), this.getHeight(), this);
        }

        void updateNextTile(Tile landslideTile) {
            setPreferredSize(new Dimension(40, 60));
            Tile t;
            Runnable rr = () -> {
                TileUI landslideTileUI = new TileUI("images_2020/landslide.png", landslideTile);
                panelHolder[i][j].add(landslideTileUI);
                panelHolder[i][j].revalidate();
                panelHolder[i][j].repaint();
                panelHolder[i][j].updateUI();
                panelHolder[i][j].revalidate();
                panelHolder[i][j].repaint();
                if (core.getLandSlideCollectedList().size() == TILESLAND) {
                    return;
                }
            };
            rr.run();
            
            j++;
            if (j == 4) {
            	j = 0;
                i++;
            }
        }
    }
	
	/**
	 * <br>precondition: Put a correct value.
	 * <br>postcondition: The mosaic variable will change to the new one, that was given.
	 * @param mosaic Puts new mosaic tile.
	 */
	public void setMosaic(MosaicTile[] mosaic) {
		this.Mosaic = mosaic;
	}
	
	/**
	 * <br>precondition: Returns the tile of Amphora.
	 * <br>postcondition: Returns the tile of this Amphora.
	 * @return the tile of this Amphora.
	 */
	public AmphoreaTile[] getAmphora() {
		return Amphora;
	}
	
	/**
	 * <br>precondition: Put a correct value.
	 * <br>postcondition: The sphinx variable will change to the new one, that was given.
	 * @param sphinx Puts new sphinx tile.
	 */
	public void setSphinx(SphinxTile[] sphinx) {
		this.Sphinx = sphinx;
	}

	/**
	 * <br>precondition: Put a correct value.
	 * <br>postcondition: The big_upper variable will change to the new one, that was given.
	 * @param big_upper Puts new big_upper tile.
	 */
	public void setBig_upper(Skeleton_upper_bigbody[] big_upper) {
		this.Big_upper = big_upper;
	}
	
	public SkeletonSide getSkeletonSide() {
        return skeletonSide;
    }

	/**
	 * <br>precondition: Returns the tile of Big_under.
	 * <br>postcondition: Returns the tile of this Big_under.
	 * @return the tile of this Big_under.
	 */
	public Skeleton_under_bigbody[] getBig_under() {
		return Big_under;
	}
	
	/**
	 * <br>precondition: Put a correct value.
	 * <br>postcondition: The big_under variable will change to the new one, that was given.
	 * @param big_under Puts new big_under tile.
	 */
	public void setBig_under(Skeleton_under_bigbody[] big_under) {
		this.Big_under = big_under;
	}
}
