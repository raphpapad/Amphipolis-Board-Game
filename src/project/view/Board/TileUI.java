package project.view.Board;
import java.awt.Image;
import java.io.File;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import java.lang.module.FindException;
import project.models.character.Digger;
import javax.imageio.ImageIO;
import java.util.ArrayList;
import java.util.logging.Logger;
import project.models.tile.StatueTile;
import java.util.logging.Level;
import project.models.character.Assistant;
import project.models.tile.Tile;
import java.io.IOException;
import project.models.tile.MosaicTile;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.border.CompoundBorder;
import java.lang.String;

public class TileUI extends JLabel {
	private static final int THEIGHT = 30;
	private static final int TWIDTH = 40;
	private int counter;
	private String path;
    private Tile tile;
    private boolean check;
	
	public TileUI() {}
	
	public TileUI(int counter) {
		this.counter = counter;
	}
			
    public TileUI(String path, Tile tile) {
    	this.setCheck(true);
        this.path = path;
        this.setCounter(0);
        this.tile = tile;

        try {
            BufferedImage img;
            check = true;
            img = ImageIO.read(new File(this.path));
            counter++;
            Image image = img.getScaledInstance(TWIDTH, THEIGHT, Image.SCALE_SMOOTH);
            setIcon(new ImageIcon(image));

        } catch (IOException ex) {
        	int ERROR3 = 3;
            Logger.getLogger(TileUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

	public void setCounter(int counter) {
		this.counter = counter;
	}
	
    public String getPath() {
        return path;
    }
    
	public int getCounter() {
		return counter;
	}

    public void setPath(String path) {
        this.path = path;
    }

	public void setCheck(boolean check) {
		this.check = check;
	}

    public Tile getTile() {
        return tile;
    }
    
	public boolean isCheck() {
		return check;
	}

    public void setTile(Tile tile) {
        this.tile = tile;
    }   
}