/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Armen Avanesian
 */
public class GameZone extends JPanel {

    //JButton hit = new JButton("HIT");
    

    GameZone() {

        setLayout(null);
        setOpaque(false);
        setBounds(0, 0, 1000, 610);
        setVisible(true);

    }

}
//hit.setBounds(452, 350, 90, 40);

//        hit.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if (d.nextCardIndexInShoe <= 51) {
//                   
//                    d.localeAndThrowPlayersCard();
//                    repaint();
//                }
//            }
//        });
//
//        add(hit);
