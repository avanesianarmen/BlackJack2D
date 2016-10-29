/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Armen Avanesian
 */
public class Frame extends JFrame {

    public Frame(String title) {
        super(title);
        this.setSize(1000, 610);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);


        
        
        Panels panels = new Panels();
        Player player = new Player(panels);
        Dealer dealer = new Dealer(panels, player);
        
        


        this.add(panels);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }

}
