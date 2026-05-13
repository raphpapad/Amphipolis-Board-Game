package project.view.Board;

import project.models.character.CharacterCard;
import java.awt.PrintGraphics;
import java.awt.event.ActionEvent;
import project.models.character.Assistant;
import java.awt.event.AdjustmentListener;
import project.models.character.Professor;
import java.awt.image.BufferedImage;
import project.models.character.Archeologist;
import java.awt.event.FocusListener;
import project.controller.Core;
import java.io.File;
import project.models.player.Player;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import project.models.character.Digger;
import java.lang.String;
import javax.swing.AbstractButton;
import static java.lang.Math.*; 
import java.awt.Image;
import java.lang.String;
import static java.lang.System.*;

public class PlayerCards extends JButton {
	private static int CARDSTOTAL = 16;
    private static final int CHEIGHT = 190;
    private static final int CWIDTH = 125;
    private Image img;
    private String path;
    private JButton switched; 
    private CharacterCard characterCard;
	
	public PlayerCards(String path, CharacterCard c, Core core) {
    	this.img = null;
        this.path = path;
        this.characterCard = c;
        this.switched = null;
		
        Image image;
        try {
            BufferedImage img;
            this.switched = new JButton();
            img = ImageIO.read(new File(this.path));
            image = img.getScaledInstance(CWIDTH, CHEIGHT, Image.SCALE_SMOOTH);
            setIcon(new ImageIcon(image));
        } catch (IOException ex) {

        }
        
        if (this.img != null)
        	check = true;
        this.setEnabled(!this.characterCard.isPlayed());
        this.getBorder();
        this.addActionListener((ActionEvent e) -> {
        	int i = 0;
        	int j = 0;
        	
            Player p = this.characterCard.getPlayer();
            Player tmp = this.characterCard.getPlayer();
            if (check && !p.isUsedCharacterThisTurn()) {
            	this.characterCard.setPlayed(true);
                
                p.setUsedCharacterThisTurn(true);
                PlayerCards.this.setEnabled(false);
                
                if (check && this.characterCard instanceof Assistant) {
                    core.assistantEvent();
                } 
                else if (check && this.characterCard instanceof Professor) {
                    core.professorEvent();
                }
                else if (check && this.characterCard instanceof Archeologist) {
                    core.ArcheologistEvent();
                }
                else if (check &&this.characterCard instanceof Digger) {
                    core.DiggerEvent();
                } 
                else
                {
                	int ERROR2 = 999;
                	System.out.println(ERROR2);
                }               
            }
        });
    }

    public Image getImg() {
		return img;
	}

    public String getPath() {
        return path;
    }
    
	public void setImg(Image img) {
		this.img = img;
	}

    public void setPath(String path) {
        this.path = path;
    }

	public void setSwitched(JButton switched) {
		this.switched = switched;
	}

    public CharacterCard getC() {
        return characterCard;
    }
	public JButton getSwitched() {
		return switched;
	}

    public void setC(CharacterCard c) {
        this.characterCard = c;
    }
}