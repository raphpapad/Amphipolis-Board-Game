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
import project.models.tile.SkeletonTile;
import java.awt.geom.Area;
import project.models.tile.SphinxTile;
import java.awt.event.MouseEvent;
import java.awt.geom.GeneralPath;
import project.models.tile.Tile;
import java.awt.event.MouseListener;
import java.awt.geom.Line2D;
import project.models.tile.StatueTile;
import java.awt.geom.Path2D;
import javax.swing.JPanel;
import java.awt.geom.IllegalPathStateException;
import project.controller.Core;
import project.models.tile.Skeleton_under_bigbody;
import project.models.tile.AmphoreaTile;
import project.models.tile.Skeleton_under_smallbody;
import project.models.tile.CaryatidTile;
import javax.swing.JLabel;
import project.models.tile.Skeleton_upper_bigbody;
import project.models.tile.LandslideTile;
import project.models.tile.Skeleton_upper_smallbody;
import project.models.tile.MosaicTile;


public class GameBoard extends JPanel {
	private final AmphoreasSide amphoreasSide;
	private LandslideTile[] Landslide;
	private MosaicTile[] Mosaic;
	private final MosaicSide mosaicSide;
	private AmphoreaTile[] Amphora;
	private CaryatidTile[] Caryatid;
	private SphinxTile[] Sphinx;
	private Skeleton_upper_bigbody[] Big_upper; 
	private final StatueSide statueSide;
	private Skeleton_under_bigbody[] Big_under;
	private Skeleton_upper_smallbody[] Small_upper; 
	private final SkeletonSide skeletonSide;
	private Skeleton_under_smallbody[] Small_under;
	private final LandingSide landingPanel;
	Core core; 
	
    public GameBoard(Core core) {
        this.core = core;
        //System.out.println(core + "mp");
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
	
	
    public class AmphoreasSide extends JPanel 
    {
		private int i = 0;
        JPanel[][] panelHolder = new JPanel[6][6];
        private int k = 0;
        JPanel[][] tmpHolder = new JPanel[6][6];
        private int j = 0;
        GridLayout layout = new GridLayout(6, 6);
        private final int DEB1 = 1;
        private int l = 0;
        private final int DEB2 = 2;
        JPanel[][] tmp2Holder = new JPanel[6][6];
        private final int DEB3 = 3;
        GridLayout tmplayout = new GridLayout(6, 6);
        private final Core core;
		
        public AmphoreasSide(Core core) {
            this.core = core;
            int Q = 0;
            int L = 0;
            panelHolder = new JPanel[6][6];
            Q++;
            setLayout(new GridLayout(6, 6));
            L++;
            for (int rows = 0; rows < 6; rows++) {
            	Q = 0;
                for (int columns = 0; columns < 6; columns++) {
                	L++;
                    panelHolder[rows][columns] = new JPanel();
                    L++;
                    panelHolder[rows][columns].setBackground(new Color(0, 0, 0, 0));
                    L++;
                    add("", panelHolder[rows][columns]);
                    L++;
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
        	int k1 = 0;
        	int l1 = 0;
            setPreferredSize(new Dimension(40, 60));
            tile.getClass();
            Runnable rr = () -> {
            	int k = 0;
            	int l = 0;
            	k++;
                TileUI amphoraTileUI = new TileUI("images_2020/amphora_" + tile.getColor() + ".png", tile);
                l++;
                panelHolder[i][j].add(amphoraTileUI);
                l++;
                panelHolder[i][j].revalidate();
                l++;
                panelHolder[i][j].repaint();
                l++;
                panelHolder[i][j].updateUI();
                l++;
                panelHolder[i][j].revalidate();
                l++;
                panelHolder[i][j].repaint();
                k++;
            };
            int tmp1;
            rr.run();
            int tmp2;

            panelHolder[i][j].addMouseListener(new MouseListener() {
            	int tmp3;
            	int tmp4;

                @Override
                public void mouseClicked(MouseEvent e) {
                	tmp3 = 0;
                	tmp4 = 0;
                	boolean dummy = true;
                    if (dummy == true && (core.getCurrentPlayer().getAclass() == null || (core.IsCurrPlayerFinished() && core.getCurrentPlayer().getAclass().equals(AmphoreaTile.class)))) {
                    	tmp3++;
                        panelHolder[i][j] = (JPanel) e.getSource();
                        tmp3++;
                        TileUI tile = (TileUI) panelHolder[i][j].getComponent(0);
                        TileUI t2 = tile;
                        tile.getTile();
                        tmp4++;
                        core.getAmphoreasTiles().remove(tile.getTile());
                        tmp4++;
                        core.getCurrentPlayer().getCollectedCards().add(tile.getTile());
                        tmp4++;
                        core.getCurrentPlayer().setAclass(AmphoreaTile.class);
                        tmp4++;
                        panelHolder[i][j].removeAll();
                        tmp4++;
                        panelHolder[i][j].repaint();
                        tmp4++;
                        panelHolder[i][j].revalidate();
                        tmp4++;	
                        panelHolder[i][j].removeMouseListener(this);
                        tmp4++;	
                        core.decreseCurrPlayerMoves();
                        tmp4++;	
                        core.getBoard().getGameBoard().revalidate();
                        tmp4++;	
                        EventQueue.invokeLater(() -> {
                        	tmp4++;
                            core.getBoard().getcollectedSide().updateCollectedSide(core);
                            tmp4++;
                            core.getBoard().repaint();
                            tmp4++;
                            core.getBoard().move(0, 0);
                            tmp4++;
                            core.getBoard().getGameBoard().move(0, 0);
                            tmp4++;
                            core.getBoard().getcollectedSide().move(0, 0);
                            tmp4++;
                        });                    }

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
        private final int deb1 = 1;
        JPanel[][] tmppanelHolder = new JPanel[6][6];
        private final int deb2 = 2;
        GridLayout layout = new GridLayout(6, 6);
        private final int deb3 = 3;
        GridLayout tmplayout = new GridLayout(6, 6);
        
        public MosaicSide(Core core) {
        	
            this.core = core;
            tmp = core;
            panelHolder = new JPanel[6][6];
            setLayout(new GridLayout(6, 6));
            int Q;
            int M;
            for (int rows = 0; rows < 6; rows++) {
            	Q = 0;
                for (int columns = 0; columns < 6; columns++) {
                	Q++;
                    panelHolder[rows][columns] = new JPanel();
                    Q++;
                    panelHolder[rows][columns].setBackground(new Color(0, 0, 0, 0));
                    Q++;
                    add("", panelHolder[rows][columns]);
                    Q++;
                }
                M = Q;
            }
 
        }
 
        @Override
        public void paintComponent(Graphics g) {
            g.drawImage(Toolkit.getDefaultToolkit().getImage(("images_2020/bg.png")), 0, 0, this.getWidth(), this.getHeight() + 0, this);
        }
 
        void updateNextTile(MosaicTile mosaicTile) {
        	MosaicTile m1 =  mosaicTile;
            setPreferredSize(new Dimension(40, 60));
            int k;
            int l;
            Runnable rr = () -> {
            	int k1;
            	int l1;
                k1 = 0;
            	TileUI mosiacTileUI = new TileUI("images_2020/mosaic_" + mosaicTile.getColor() + ".png", mosaicTile);
            	l1 = 0;
                panelHolder[i][j].add(mosiacTileUI);
                k1++;
                panelHolder[i][j].revalidate();
                l1++;
            };
            rr.run();
            boolean check = false;
 
            panelHolder[i][j].addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                	boolean check = true;
 
                    if (check == true && (core.getCurrentPlayer().getAclass() == null || (core.IsCurrPlayerFinished() && core.getCurrentPlayer().getAclass().equals(MosaicTile.class)))) {
                    	int k =i;
                    	int m = j;
                    	
                        panelHolder[i][j] = (JPanel) e.getSource();
                    	k++;
                        TileUI tile = (TileUI) panelHolder[i][j].getComponent(0);
                        TileUI tmp = tile;
                        tile.getTile();
                        tmp.getTile();
 
                        core.getMosaicTiles().remove(tile.getTile());
                        k++;
                        core.getCurrentPlayer().getCollectedCards().add(tile.getTile());
                        m++;
                        core.getCurrentPlayer().setAclass(MosaicTile.class);
                        
                        core.getClass();
                        JPanel[][] panel = new JPanel[6][6];
                        panelHolder[i][j].removeAll();
                        panel[i][j] = panelHolder[i][j];
                        panelHolder[i][j].repaint();
                        k++;
                        panelHolder[i][j].revalidate();
                        m++;
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
            int M;
            panelHolder = new JPanel[6][6];
            int N;
            setLayout(new GridLayout(6, 6));
            M = 0;
            for (int rows = 0; rows < 6; rows++) {
                int sum = 0;
            	for (int columns = 0; columns < 6; columns++) {
            		N = 0;
                    panelHolder[rows][columns] = new JPanel();
                    sum = M + N;
                    panelHolder[rows][columns].setBackground(new Color(0, 0, 0, 0));
                    M++;
                    add("", panelHolder[rows][columns]);
                    M = 0;
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
                int debug = 0;
                if ((statueTile instanceof CaryatidTile)==true) {
                    statueTileUI = new TileUI("images_2020/caryatid.png", statueTile);
                } else {
                	debug++;
                    statueTileUI = new TileUI("images_2020/sphinx.png", statueTile);
                    debug++;
                }
                debug++;
                panelHolder[i][j].add(statueTileUI);
                debug++;
                panelHolder[i][j].revalidate();
                debug++;
                panelHolder[i][j].repaint();
                debug++;
                panelHolder[i][j].updateUI();
                debug++;
                panelHolder[i][j].revalidate();
                debug++;
                panelHolder[i][j].repaint();
                debug++;
            };
            rr.run();

            panelHolder[i][j].addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                	boolean f = true;
                	int test1 = 0;
                    if (f == true && (core.getCurrentPlayer().getAclass() == null || (core.IsCurrPlayerFinished() && core.getCurrentPlayer().getAclass().equals(StatueTile.class)))) {
                    	test1++;
                        panelHolder[i][j] = (JPanel) e.getSource();
                        test1++;
                        TileUI tile = (TileUI) panelHolder[i][j].getComponent(0);
                        TileUI tmp = tile;
                        tile.getTile();
                        test1++;
                        core.getStatuesTiles().remove(tile.getTile());
                        test1++;
                        core.getCurrentPlayer().getCollectedCards().add(tile.getTile());
                        test1++;
                        core.getCurrentPlayer().setAclass(StatueTile.class);
                        test1++;
                        panelHolder[i][j].removeAll();
                        test1++;
                        panelHolder[i][j].repaint();
                        test1++;
                        panelHolder[i][j].revalidate();
                        test1++;
                        panelHolder[i][j].removeMouseListener(this);
                        test1++;
                        core.decreseCurrPlayerMoves();
                        core.getBoard().getGameBoard().revalidate();
                        EventQueue.invokeLater(() -> {
                        	int test2 = 0;
                        	test2++;
                            core.getBoard().getcollectedSide().updateCollectedSide(core);
                            test2++;
                            core.getBoard().repaint();
                            test2++;
                            core.getBoard().move(0, 0);
                            test2++;
                            core.getBoard().getGameBoard().move(0, 0);
                            test2++;
                            core.getBoard().getcollectedSide().move(0, 0);
                            test2++;
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
        private int U;
        JPanel[][] tmpHolder = new JPanel[6][6];
        private int M;
        GridLayout layout = new GridLayout(6, 6);
        private boolean deb;
        GridLayout tmplayout = new GridLayout(6, 6);
		private LandslideTile[] Landslide;

        public SkeletonSide(Core core) {
            this.core = core;

            panelHolder = new JPanel[6][6];
            
            int k = 0;
            int m = 0;
            setLayout(new GridLayout(6, 6));
            U++;
            for (int rows = 0; rows < 6; rows++) {
            	deb = true;
                for (int columns = 0; columns < 6; columns++) {
                	k++;
                    panelHolder[rows][columns] = new JPanel();
                    m++;
                    panelHolder[rows][columns].setBackground(new Color(0, 0, 0, 0));
                    k++;
                    add("", panelHolder[rows][columns]);
                    m++;
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
            	int Q = 0;
            	int M = 0;
                TileUI skeletonTileUI = new TileUI("images_2020/skeleton_" + skeletonTile.getColor() + ".png", skeletonTile);
                Q++;
                panelHolder[i][j].add(skeletonTileUI);
                M++;
                panelHolder[i][j].revalidate();
                Q++;
                panelHolder[i][j].repaint();
                Q++;
                panelHolder[i][j].updateUI();
                Q++;
                panelHolder[i][j].revalidate();
                M++;
                panelHolder[i][j].repaint();
                M++;
            };
            this.getClass();
            rr.run();
            
            int test1;
            int test2;

            panelHolder[i][j].addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                	boolean f1 = true;
                	int test3 = 0;
                	int test4 = 0;
                    if (f1 == true && (core.getCurrentPlayer().getAclass() == null || (core.IsCurrPlayerFinished() && core.getCurrentPlayer().getAclass().equals(SkeletonTile.class)))) {
                    	test3++;
                        panelHolder[i][j] = (JPanel) e.getSource();
                        test4++;
                        TileUI tile = (TileUI) panelHolder[i][j].getComponent(0);
                        TileUI tmp;
                        tile.getTile();
                        tmp = tile;
                        
                        test3++;
                        core.getSkeletonsTiles().remove(tile.getTile());
                        test3++;
                        core.getCurrentPlayer().getCollectedCards().add(tile.getTile());
                        test3++;
                        core.getCurrentPlayer().setAclass(SkeletonTile.class);
                        test3++;
                        panelHolder[i][j].removeAll();
                        test3++;
                        panelHolder[i][j].repaint();
                        test3--;
                        panelHolder[i][j].revalidate();
                        test4++;
                        panelHolder[i][j].removeMouseListener(this);
                        core.decreseCurrPlayerMoves();
                        test4++;
                        
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
            int m;
            int b;
            
            setLayout(new GridLayout(4, 4));
            for (int rows = 0; rows < 4; rows++) {
            	m = 0;
                for (int columns = 0; columns < 4; columns++) {
                	b = m;
                    panelHolder[rows][columns] = new JPanel();
                    b++;
                    panelHolder[rows][columns].setBackground(new Color(0, 0, 0, 0));
                    m++;
                    add("", panelHolder[rows][columns]);
                    m = b;
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
        	int k;
        	int q;
            setPreferredSize(new Dimension(40, 60));
            Tile t;
            Runnable rr = () -> {
            	int k1 = 0;
            	int q1 = 0;
            	k1++;
                TileUI landslideTileUI = new TileUI("images_2020/landslide.png", landslideTile);
                q1++;
                panelHolder[i][j].add(landslideTileUI);
                q1++;
                panelHolder[i][j].revalidate();
                q1++;
                panelHolder[i][j].repaint();
                q1++;
                panelHolder[i][j].updateUI();
                q1++;
                panelHolder[i][j].revalidate();
                q1++;
                panelHolder[i][j].repaint();
                q1++;
                if (core.getLandSlideCollectedList().size() == TILESLAND) {
                    return;
                }
            };
            rr.run();
            
            int tmp =0;
            j++;
            tmp++;
            int tmp2;
            if (j == 4) {
                tmp++;
            	j = 0;
                i++;
                tmp2 = 0;
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