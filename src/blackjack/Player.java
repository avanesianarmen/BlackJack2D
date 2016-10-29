/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

/**
 *
 * @author Armen Avanesian
 */
public class Player {

    public List<JLabel> PlayersCardList = new ArrayList<>();
    public int playersNextCardLocationX = 450;
    public int playersNextCardLocationY = 420;
    JButton hit = new JButton("HIT");
    JButton start = new JButton("START");
    JButton stand = new JButton("STAND");
    GameZone gameZone;
    Staff staff;
    int score = 0;

    public Player(Panels pnl) {
        staff = pnl.staff;
        setHit();
        setStart();
        setStand();

        staff.add(hit);
        staff.add(start);
        staff.add(stand);

    }
    
    
    void setHit(){
        hit.setIcon(new ImageIcon(new ImageIcon("table/btn.png").getImage().getScaledInstance(100, 46, Image.SCALE_SMOOTH)));
        hit.setPressedIcon(new ImageIcon(new ImageIcon("table/btnclick.png").getImage().getScaledInstance(100, 46, Image.SCALE_SMOOTH)));
        hit.setContentAreaFilled(false);
        hit.setFocusPainted(false);
        hit.setBorderPainted(false);hit.setForeground(Color.black);
        hit.setFont(new Font("Plantagenet Cherokee", Font.PLAIN, 30));
        hit.setBounds(448, 350, 100, 46);
        hit.setHorizontalTextPosition(JButton.CENTER);
        //hit.setVerticalTextPosition(JButton.CENTER);
        
    }
    
    void setStart(){
        start.setForeground(Color.BLUE);
        start.setBounds(568, 350, 150, 46);
        start.setIcon(new ImageIcon(new ImageIcon("table/btn.png").getImage().getScaledInstance(150, 46, Image.SCALE_SMOOTH)));
        start.setPressedIcon(new ImageIcon(new ImageIcon("table/btnclick.png").getImage().getScaledInstance(150, 46, Image.SCALE_SMOOTH)));
        start.setContentAreaFilled(false);
        start.setFocusPainted(false);
        start.setBorderPainted(false);
        start.setForeground(Color.black);
        start.setFont(new Font("Plantagenet Cherokee", Font.PLAIN, 30));
        start.setHorizontalTextPosition(JButton.CENTER);
        //start.setVerticalTextPosition(JButton.CENTER);
        
    }
    
    void setStand(){
        stand.setForeground(Color.BLUE);
        stand.setBounds(278, 350, 150, 46);
        stand.setIcon(new ImageIcon(new ImageIcon("table/btn.png").getImage().getScaledInstance(150, 46, Image.SCALE_SMOOTH)));
        stand.setPressedIcon(new ImageIcon(new ImageIcon("table/btnclick.png").getImage().getScaledInstance(150, 46, Image.SCALE_SMOOTH)));
        stand.setContentAreaFilled(false);
        stand.setFocusPainted(false);
        stand.setBorderPainted(false);
        stand.setForeground(Color.black);
        stand.setFont(new Font("Plantagenet Cherokee", Font.PLAIN, 30));
        stand.setHorizontalTextPosition(JButton.CENTER);
        //stand.setVerticalTextPosition(JButton.CENTER);
        
    }

}
