/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import java.util.List;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.Action;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Armen Avanesian
 */
public class Dealer {

    File[] arrayOfCards;
    static List<JLabel> DealersCardList = new ArrayList<JLabel>();
    public ArrayList<CardAndValues> CardList = new ArrayList<>();
    int dealersNextCardLocationX = 450;
    int dealersNextCardLocationY = 5;
    static int nextCardIndexInShoe = 0;
    int score = 0;

    JLabel playerBack = new JLabel(new ImageIcon(new ImageIcon("table/side.png").getImage().getScaledInstance(100, 145, Image.SCALE_SMOOTH)));
    JLabel dealerBack = new JLabel(new ImageIcon(new ImageIcon("table/side.png").getImage().getScaledInstance(100, 145, Image.SCALE_SMOOTH)));
    JLabel draw = new JLabel("DRAW");

    Boolean playersCheck = false;
    Boolean playerHadA = false;
    Boolean dealerHadA = false;
    JLabel dealersSecondCard = new JLabel(new ImageIcon(new ImageIcon("table/side.png").getImage().getScaledInstance(100, 145, Image.SCALE_SMOOTH)));

    GameZone gameZone;
    Staff staff;
    Player player;
    JLabel scoreJLabel;
    Timer t;
    Timer t2;

    ActionListener hitListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (nextCardIndexInShoe < 51) {

                localeAndThrowPlayersCard();
                //player.hit.removeActionListener(this);

            } else if (nextCardIndexInShoe == 51) {
                localeAndThrowPlayersCard();
                //player.hit.removeActionListener(this);
                staff.remove(staff.j);
                staff.repaint();

            }
        }
    };

    ActionListener startListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            gameZone.removeAll();
            dealersNextCardLocationX = 450;
            player.playersNextCardLocationX = 450;
            player.PlayersCardList.clear();
            DealersCardList.clear();
            player.score = 0;
            score = 0;
            playersCheck = false;
            playerHadA = false;
            dealerHadA = false;
            player.hit.removeActionListener(hitListener);
            player.stand.removeActionListener(standListener);
            throwFirstFourCards();

        }
    };

    ActionListener standListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            player.hit.removeActionListener(hitListener);
            dealerHits();
            player.stand.removeActionListener(standListener);

        }
    };

    ActionListener playerListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (playerBack.getLocation().y + 50 <= 350) {
                playerBack.setBounds(playerBack.getLocation().x - 5, playerBack.getLocation().y + 5, 100, 145);
            } else {
                t.stop();
                t.removeActionListener(playerListener);

                gameZone.remove(playerBack);
                gameZone.revalidate();
                gameZone.repaint();

            }

        }
    };

    ActionListener dealerLiestener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (dealerBack.getLocation().y >= 150) {
                dealerBack.setBounds(dealerBack.getLocation().x - 5, dealerBack.getLocation().y - 5, 100, 145);
            } else {
                t2.stop();
                t2.removeActionListener(dealerLiestener);

                gameZone.remove(dealerBack);
                gameZone.revalidate();
                gameZone.repaint();

            }

        }
    };

    public Dealer(Panels pnl, Player plr) {
        arrayOfCards = new File("cards").listFiles(); // Хранит все файлы из "cards" 
        gameZone = pnl.gameZone;
        staff = pnl.staff;
        player = plr;

        player.start.addActionListener(startListener);

        fillCardList();
        shuffle();
        
        scoreJLabel = new JLabel("YOUR SCORE: " + String.valueOf(player.score));
        scoreJLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
        scoreJLabel.setBounds(40, 170, 600, 200);
        scoreJLabel.setForeground(Color.WHITE);
        gameZone.add(scoreJLabel);
    }

    void shuffle() {

        Random random = new Random();
        for (int i = 0; i < 1000; i++) {

            int firstIndex = random.nextInt(CardList.size()); // = 52
            int secondIndex = random.nextInt(CardList.size());
            swap(firstIndex, secondIndex);

        }

    }

    void fillCardList() {
        int index = 0;
        for (int j = 1; j < 10; j++) {
            for (int i = 0; i < 4; i++) {
                CardList.add(new CardAndValues(new ImageIcon(arrayOfCards[index].getPath()), j));
                index++;
            }

        }

        for (int i = 0; i < 16; i++) {
            CardList.add(new CardAndValues(new ImageIcon(arrayOfCards[index].getPath()), 10));
            index++;
        }

    }

    void swap(int firstIndex, int secondIndex) {
        CardAndValues tmp = CardList.get(firstIndex);
        CardList.set(firstIndex, CardList.get(secondIndex));
        CardList.set(secondIndex, tmp);
    }

    void throwFirstFourCards() {

        localeAndThrowDealersCard();
        localeAndThrowDealersCard();
        localeAndThrowPlayersCard();
        localeAndThrowPlayersCard();

        gameZone.add(scoreJLabel);
//
//        if (player.score < 15) {
//            gameZone.removeAll();
//            dealersNextCardLocationX = 450;
//
//            player.playersNextCardLocationX = 450;
//            player.PlayersCardList.clear();
//            DealersCardList.clear();
//            player.score = 0;
//            score=0;
//
//            //throwFirstFourCards();
//        }

        if (player.score == 21 && score == 21) {
            JLabel draw = new JLabel("DRAW");

            draw.setFont(new Font("Plantagenet Cherokee", Font.PLAIN, 30));
            draw.setForeground(Color.WHITE);
            draw.setBounds(450, 250, 100, 50);
            gameZone.add(draw);

            gameZone.repaint();

        } else if (player.score == 21) {
            JLabel win = new JLabel(new ImageIcon(new ImageIcon("table/win.png").getImage().getScaledInstance(205, 205, Image.SCALE_SMOOTH)));
            win.setBounds(400, 150, 205, 205);

            gameZone.add(win);

        } else if (score == 21) {
            JLabel lose = new JLabel(new ImageIcon(new ImageIcon("table/lose.png").getImage().getScaledInstance(205, 205, Image.SCALE_SMOOTH)));
            lose.setBounds(400, 150, 205, 205);

            gameZone.add(lose);

        } else {
            player.hit.addActionListener(hitListener);
            player.stand.addActionListener(standListener);

        }

        playersCheck = true;
    }

    void dealerHits() {
        while (score < 17) {
            localeAndThrowDealersCard();
        }

        if (score > 21) {
            JLabel j = new JLabel(new ImageIcon(new ImageIcon("table/win.png").getImage().getScaledInstance(205, 205, Image.SCALE_SMOOTH)));
            j.setBounds(400, 150, 205, 205);

            gameZone.add(j);
            gameZone.repaint();

        } else if (score == 21) {
            JLabel j = new JLabel(new ImageIcon(new ImageIcon("table/lose.png").getImage().getScaledInstance(205, 205, Image.SCALE_SMOOTH)));

            j.setBounds(400, 150, 205, 205);

            gameZone.add(j);
            gameZone.repaint();

        } else if (player.score > score) {
            JLabel j = new JLabel(new ImageIcon(new ImageIcon("table/win.png").getImage().getScaledInstance(205, 205, Image.SCALE_SMOOTH)));

            j.setBounds(400, 150, 205, 205);

            gameZone.add(j);
            gameZone.repaint();

        } else if (score > player.score) {
            JLabel j = new JLabel(new ImageIcon(new ImageIcon("table/lose.png").getImage().getScaledInstance(205, 205, Image.SCALE_SMOOTH)));

            j.setBounds(400, 150, 205, 205);

            gameZone.add(j);
            gameZone.repaint();

        } else {
            JLabel draw = new JLabel("DRAW");

            draw.setFont(new Font("Plantagenet Cherokee", Font.PLAIN, 30));
            draw.setForeground(Color.WHITE);
            draw.setBounds(450, 250, 100, 50);

            gameZone.add(draw);
            gameZone.repaint();

        }

    }

    void moveCards(List<JLabel> list) {
        for (JLabel tmp : list) {

            int newX = tmp.getLocation().x;
            int newY = tmp.getLocation().y;
            tmp.setBounds(newX - 56, newY, 100, 145);

        }
    }

    void addNewCard(List<JLabel> list, int x, int y) {
        JLabel card = new JLabel(new ImageIcon(CardList.get(nextCardIndexInShoe).img.getImage().getScaledInstance(100, 145, Image.SCALE_SMOOTH)));
        card.setBounds(x, y, 100, 145);
        gameZone.add(card);
        list.add(card);
    }

    void checkPlayersScoreWithNewCard() {
        if (playersCheck == true) {
            if (player.score > 21) {
                player.hit.removeActionListener(hitListener);
                player.stand.removeActionListener(standListener);
                JLabel lose = new JLabel(new ImageIcon(new ImageIcon("table/lose.png").getImage().getScaledInstance(205, 205, Image.SCALE_SMOOTH)));
                lose.setBounds(400, 150, 205, 205);

                gameZone.add(lose);

            }

            if (player.score == 21) {
                player.hit.removeActionListener(hitListener);
                player.stand.removeActionListener(standListener);
                JLabel win = new JLabel(new ImageIcon(new ImageIcon("table/win.png").getImage().getScaledInstance(205, 205, Image.SCALE_SMOOTH)));
                win.setBounds(400, 150, 205, 205);

                gameZone.add(win);

            }
        }

    }

    void localeAndThrowPlayersCard() {
        playerBack.setBounds(850, 200, 100, 145);
        gameZone.add(playerBack);

        moveCards(player.PlayersCardList);

        if (!player.PlayersCardList.isEmpty()) {
            player.playersNextCardLocationX = player.PlayersCardList.get(player.PlayersCardList.size() - 1).getLocation().x + 110;

        }

        t = new Timer(4, playerListener);

        t.start();

        addNewCard(player.PlayersCardList, player.playersNextCardLocationX, player.playersNextCardLocationY);

        if (CardList.get(nextCardIndexInShoe).value == 1 && player.score + 11 <= 21) {
            player.score += 11;
            playerHadA = true;
        } else {
            player.score += CardList.get(nextCardIndexInShoe).value;
        }

        if (player.score > 21 && playerHadA == true) {
            player.score -= 10;
            playerHadA = false;
        }

        scoreJLabel.setText("YOUR SCORE: " + String.valueOf(player.score));

        nextCardIndexInShoe++;

        checkPlayersScoreWithNewCard();
    }

    void localeAndThrowDealersCard() {

        dealerBack.setBounds(850, 200, 100, 145);
        gameZone.add(dealerBack);

        moveCards(DealersCardList);

        if (!DealersCardList.isEmpty()) {
            dealersNextCardLocationX = DealersCardList.get(DealersCardList.size() - 1).getLocation().x + 110;
        }

        t2 = new Timer(4, dealerLiestener);
        t2.start();

        addNewCard(DealersCardList, dealersNextCardLocationX, dealersNextCardLocationY);

        if (CardList.get(nextCardIndexInShoe).value == 1 && score + 11 <= 21) {
            score += 11;
            dealerHadA = true;
        } else {
            score += CardList.get(nextCardIndexInShoe).value;
        }

        if (score > 21 && dealerHadA == true) {
            score -= 10;
            dealerHadA = false;
        }

        nextCardIndexInShoe++;
    }

    private class CardAndValues implements Comparable<CardAndValues> {

        ImageIcon img;
        Integer value;

        public CardAndValues(ImageIcon imgObject, Integer intObject) {
            img = imgObject;
            value = intObject;

        }

        @Override
        public int compareTo(CardAndValues o) {
            return value < o.value ? -1 : value > o.value ? 1 : 0;
        }

    }

}
