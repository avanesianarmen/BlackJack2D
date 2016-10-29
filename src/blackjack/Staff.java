/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Armen Avanesian
 */
class Staff extends JPanel {

    JLabel j;

    public Staff() {
        setLayout(null);
        setOpaque(false);
        setBounds(0, 0, 1000, 610);
        
        j = new JLabel(new ImageIcon(new ImageIcon("table/side.png").getImage().getScaledInstance(100, 145, Image.SCALE_SMOOTH)));
        j.setBounds(850, 200, 100, 145);

        add(j);
        setVisible(true);

    }
    
    

}
