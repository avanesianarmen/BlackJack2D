/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Armen Avanesian
 */
public class Panels extends JPanel {

    Image bg = new ImageIcon("table/pokerBG.jpg").getImage();
    GameZone gameZone;
    Staff staff;

    public Panels() {
        gameZone = new GameZone();
        staff = new Staff();
        this.setLayout(null);
        this.setBounds(0, 0, 1000, 610);
        this.setOpaque(false);
        this.add(gameZone);
        this.add(staff);

    }


    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.

        g.drawImage(bg, 0, 0, null);

    }

}
