package project.view.Board;

import java.awt.PrintGraphics;
import java.awt.event.ActionEvent;
import java.awt.event.FocusListener;
import java.awt.Image;
import java.awt.event.AdjustmentListener;
import java.awt.image.BufferedImage;

import project.models.character.CharacterCard;
import project.models.character.Assistant;
import project.models.character.Digger;
import project.models.player.Player;
import project.models.character.Professor;
import project.models.character.Archeologist;
import project.controller.Core;

import java.io.File;
import java.io.IOException;

import java.lang.String;
import java.lang.String;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.AbstractButton;

import static java.lang.Math.*; 
import static java.lang.System.*;

public class PlayerCards extends JButton {
	private static int CARDSTOTAL = 16;
    private static final int CHEIGHT = 190;
    private static final int CWIDTH = 125;
    private Image img;
    private boolean check = true;
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
            int sum = CWIDTH + CHEIGHT;
            //System.out.println(sum);
            image = img.getScaledInstance(CWIDTH, CHEIGHT, Image.SCALE_SMOOTH);
            int debug = sum - CHEIGHT;
            //System.out.println(debug);
            setIcon(new ImageIcon(image));
            //System.out.println(sum);
            debug++;
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
            int totalEventcnt = 0;
            int assisantEventcnt = 0;
            int professorEventcnt = 0;
            int archeologistEventcnt = 0;;
            int diggerEventcnt = 0;;
            if (check && !p.isUsedCharacterThisTurn()) 
            {
                
            	this.characterCard.setPlayed(true);
                
                p.setUsedCharacterThisTurn(true);
                
                PlayerCards.this.setEnabled(false);
                
                totalEventcnt = 0;
                if (check && this.characterCard instanceof Assistant) 
                {
                	assisantEventcnt = 0;
                    core.assistantEvent();
                	assisantEventcnt++;
                    totalEventcnt++;
                } 
                else if (check && this.characterCard instanceof Professor) 
                {
                	professorEventcnt = 0;
                    core.professorEvent();
                    professorEventcnt++;
                    totalEventcnt++;
                }
                else if (check && this.characterCard instanceof Archeologist) 
                {
                	archeologistEventcnt = 0;
                    core.ArcheologistEvent();
                    archeologistEventcnt++;
                    totalEventcnt++;
                }
                else if (check &&this.characterCard instanceof Digger) 
                {
                	diggerEventcnt = 0;
                    core.DiggerEvent();
                    diggerEventcnt++;
                    totalEventcnt++;
                } 
                else
                {
                	int ERROR2 = 999;
                	System.out.println(ERROR2);
                }
                
                if (totalEventcnt == (diggerEventcnt + archeologistEventcnt + professorEventcnt + assisantEventcnt))
                	;//System.out.println("PERFECT");
            }
        });
    }

    public Image getImg() {
		return img;
	}

    public String getPath() {
    	if (check == false)
    		;//System.out.println("wrong");
        return path;
    }
    
	public void setImg(Image img) {
		this.img = img;
	}

    public void setPath(String path) {
    	if (check == false)
    		;//System.out.println("wrong");
        this.path = path;
    }

	public void setSwitched(JButton switched) {
		this.switched = switched;
	}

    public CharacterCard getC() {
    	if (check == false)
    		;//System.out.println("wrong");
        return characterCard;
    }
	public JButton getSwitched() {
		return switched;
	}

    public void setC(CharacterCard c) {
    	if (check == false)
    		;//System.out.println("wrong");
        this.characterCard = c;
    }
}