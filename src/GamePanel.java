import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;

/**
 * This class contains the GUI components of the card game along with main method which executes the program and simulates the card game.
 * @author Mahima Anand
 * @version 1.2
 */

public class GamePanel {
    int counter = 0;
    int cash = 100;
    int betMoney=0;

    String dealerCard = "";
    String playerCard = "";


    ArrayList<String> dealerCards = new ArrayList<String>();
    ArrayList<String> playerCards = new ArrayList<String>();

    Deck deck = new Deck();
    ArrayList<String> cardsDeck = deck.cardDeck;


    JLabel label_Image1 = new JLabel();
    JLabel label_Image2 = new JLabel();
    JLabel label_Image3 = new JLabel();
    JLabel label_Image4 = new JLabel();
    JLabel label_Image5 = new JLabel();
    JLabel label_Image6 = new JLabel();
    JButton btn_rpcard1 = new JButton("Replace Card 1");
    JButton btn_rpcard2 = new JButton("Replace Card 2");
    JButton btn_rpcard3 = new JButton("Replace Card 3");
    JButton btn_start = new JButton("Start");
    JButton btn_result = new JButton("Result");
    JLabel label_bet = new JLabel("Bet: $");
    JLabel label_info = new JLabel("Please place your bet! Amount of money you have: $");
    JLabel label_money = new JLabel("" + cash);
    JTextField txt_inputbet = new JTextField(10);

    ImageIcon Image1 = new ImageIcon("card_back.gif");
    ImageIcon Image2 = new ImageIcon("card_back.gif");
    ImageIcon Image3 = new ImageIcon("card_back.gif");
    ImageIcon Image4 = new ImageIcon("card_back.gif");
    ImageIcon Image5 = new ImageIcon("card_back.gif");
    ImageIcon Image6 = new ImageIcon("card_back.gif");

    JMenuBar menuBar = new JMenuBar();
    JMenu control = new JMenu("Control");
    JMenuItem exit = new JMenuItem("Exit");
    JMenu help = new JMenu("Help");
    JMenuItem instructions = new JMenuItem("Instructions");

    JPanel MainPanel = new JPanel();
    JPanel DealerPanel = new JPanel();
    JPanel PlayerPanel = new JPanel();
    JPanel RpCardBtnPanel = new JPanel();
    JPanel ButtonPanel = new JPanel();
    JPanel InfoPanel = new JPanel();

    /**
     * @param args
     * This method prepares the other components of the program by calling other methods to initialise the card deck and the player's and dealer's sets of cards before running the program
     */
    public static void main(String[] args) {
        GamePanel gui = new GamePanel();
        gui.shuffleDeck();
        gui.initialiseDealerCards();
        gui.initialisePlayerCards();
        gui.setDealerCards();
        gui.go();
    }
    /**
     * This method initialises the ArrayList meant to contain the dealer's cards
     * It does not take in any parameters or return anything
     */
    public void initialiseDealerCards(){
        dealerCards.add(dealerCard);
        dealerCards.add(dealerCard);
        dealerCards.add(dealerCard);
    }
    /**
     * This method initialises the ArrayList meant to contain the player's cards
     * It does not take in any parameters or return anything
     */
    public void initialisePlayerCards(){
        playerCards.add(playerCard);
        playerCards.add(playerCard);
        playerCards.add(playerCard);
    }

    /**
     * This method shuffles the card deck
     * It does not take in any parameters or return anything
     *
     */
    public void shuffleDeck(){
        Collections.shuffle(cardsDeck);
    }

    /**
     * This method draws 3 cards from the top of the deck and assigns them to the dealer
     * It does not take in any parameters or return anything
     *
     */
    public void setDealerCards(){
        dealerCards.set(0,cardsDeck.get(0));
        cardsDeck.remove(0);
        dealerCards.set(1,cardsDeck.get(0));
        cardsDeck.remove(0);
        dealerCards.set(2,cardsDeck.get(0));
        cardsDeck.remove(0);

    }

    public void go() {

        btn_start.addActionListener(new StartListener());
        btn_rpcard1.addActionListener(new ReplaceFirstListener());
        btn_rpcard1.setEnabled(false);
        btn_rpcard2.addActionListener(new ReplaceSecondListener());
        btn_rpcard2.setEnabled(false);
        btn_rpcard3.addActionListener(new ReplaceThirdListener());
        btn_rpcard3.setEnabled(false);
        btn_result.addActionListener(new ResultListener());
        btn_result.setEnabled(false);
        exit.addActionListener(new ExitListener());
        instructions.addActionListener(new InstructionListener());

        label_Image1.setIcon(Image1);
        label_Image2.setIcon(Image2);
        label_Image3.setIcon(Image3);
        label_Image4.setIcon(Image4);
        label_Image5.setIcon(Image5);
        label_Image6.setIcon(Image6);

        control.add(exit);
        help.add(instructions);
        menuBar.add(control);
        menuBar.add(help);

        DealerPanel.add(label_Image1);
        DealerPanel.add(label_Image2);
        DealerPanel.add(label_Image3);
        PlayerPanel.add(label_Image4);
        PlayerPanel.add(label_Image5);
        PlayerPanel.add(label_Image6);
        RpCardBtnPanel.add(btn_rpcard1);
        RpCardBtnPanel.add(btn_rpcard2);
        RpCardBtnPanel.add(btn_rpcard3);
        ButtonPanel.add(label_bet);
        ButtonPanel.add(txt_inputbet);
        ButtonPanel.add(btn_start);
        ButtonPanel.add(btn_result);
        InfoPanel.add(label_info);
        InfoPanel.add(label_money);
        MainPanel.setLayout(new GridLayout(6, 1));
        MainPanel.add(menuBar);
        MainPanel.add(DealerPanel);
        MainPanel.add(PlayerPanel);
        MainPanel.add(RpCardBtnPanel);
        MainPanel.add(ButtonPanel);
        MainPanel.add(InfoPanel);
        DealerPanel.setBackground(Color.green);
        PlayerPanel.setBackground(Color.green);
        RpCardBtnPanel.setBackground(Color.green);
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(MainPanel);
        frame.setTitle("A Simple Card Game");
        frame.setSize(400, 700);
        frame.setVisible(true);


    }
    class StartListener implements ActionListener{
            public void actionPerformed(ActionEvent actionEvent) {
                btn_start.setEnabled(false);
                btn_rpcard1.setEnabled(true);
                btn_rpcard2.setEnabled(true);
                btn_rpcard3.setEnabled(true);
                btn_result.setEnabled(true);
                label_Image4.setIcon(new ImageIcon("card_"+cardsDeck.get(0)+".gif"));
                playerCards.set(0, cardsDeck.get(0));
                cardsDeck.remove(0);
                label_Image5.setIcon(new ImageIcon("card_"+cardsDeck.get(0)+".gif"));
                playerCards.set(1, cardsDeck.get(0));
                cardsDeck.remove(0);
                label_Image6.setIcon(new ImageIcon("card_"+cardsDeck.get(0)+".gif"));
                playerCards.set(2, cardsDeck.get(0));
                cardsDeck.remove(0);
                betMoney = Integer.parseInt(txt_inputbet.getText());
                try {
                    int amount = Integer.parseInt(txt_inputbet.getText());


                    if (amount<=0){
                        label_Image4.setIcon(new ImageIcon("card_back.gif"));
                        label_Image5.setIcon(new ImageIcon("card_back.gif"));
                        label_Image6.setIcon(new ImageIcon("card_back.gif"));
                        JOptionPane.showMessageDialog(null, "WARNING: The bet you place must be a positive integer!","Message", JOptionPane.INFORMATION_MESSAGE);
                    }

                    else if (amount>cash){
                        label_Image4.setIcon(new ImageIcon("card_back.gif"));
                        label_Image5.setIcon(new ImageIcon("card_back.gif"));
                        label_Image6.setIcon(new ImageIcon("card_back.gif"));
                        JOptionPane.showMessageDialog(null, "WARNING: You only have $"+cash,"Message", JOptionPane.INFORMATION_MESSAGE);
                        btn_start.setEnabled(true);
                        txt_inputbet.setText("");

                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "WARNING: The bet you place must be a positive integer!","Message", JOptionPane.INFORMATION_MESSAGE);

                }
                label_info.setText("Your current bet is: $" + txt_inputbet.getText() + " Amount of money you have: $");

            }
        }
        class ReplaceFirstListener implements ActionListener{
            public void actionPerformed(ActionEvent actionEvent) {
                counter++;
                btn_rpcard1.setEnabled(false);
                if (counter==2){
                    btn_rpcard1.setEnabled(false);
                    btn_rpcard2.setEnabled(false);
                    btn_rpcard3.setEnabled(false);
                }
                label_Image4.setIcon(new ImageIcon("card_"+cardsDeck.get(0)+".gif"));
                playerCards.set(0, cardsDeck.get(0));
                cardsDeck.remove(0);

            }
        }

        class ReplaceSecondListener implements ActionListener{
            public void actionPerformed(ActionEvent actionEvent) {
                counter++;
                btn_rpcard2.setEnabled(false);
                if (counter==2){
                    btn_rpcard1.setEnabled(false);
                    btn_rpcard2.setEnabled(false);
                    btn_rpcard3.setEnabled(false);
                }
                label_Image5.setIcon(new ImageIcon("card_"+cardsDeck.get(0)+".gif"));
                playerCards.set(1, cardsDeck.get(0));
                cardsDeck.remove(0);
            }
        }

        class ReplaceThirdListener implements ActionListener{
            public void actionPerformed(ActionEvent actionEvent) {
                counter++;
                btn_rpcard3.setEnabled(false);
                if (counter==2){
                    btn_rpcard1.setEnabled(false);
                    btn_rpcard2.setEnabled(false);
                    btn_rpcard3.setEnabled(false);
                }
                label_Image6.setIcon(new ImageIcon("card_"+cardsDeck.get(0)+".gif"));
                playerCards.set(2, cardsDeck.get(0));
                cardsDeck.remove(0);
            }
        }

        class ExitListener implements ActionListener{
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        }

        class ResultListener implements ActionListener{
            public void actionPerformed(ActionEvent actionEvent) {
                btn_result.setEnabled(false);
                btn_rpcard1.setEnabled(false);
                btn_rpcard2.setEnabled(false);
                btn_rpcard3.setEnabled(false);

                label_Image1.setIcon(new ImageIcon("card_"+dealerCards.get(0)+".gif"));
                label_Image2.setIcon(new ImageIcon("card_"+dealerCards.get(1)+".gif"));
                label_Image3.setIcon(new ImageIcon("card_"+dealerCards.get(2)+".gif"));

                Winner winner = new Winner();
                if (winner.specialCardCounter(dealerCards)>winner.specialCardCounter(playerCards)){
                    JOptionPane.showMessageDialog(null, "Sorry! Dealer wins this round.", "Message", JOptionPane.INFORMATION_MESSAGE);
                    cash-=betMoney;
                }
                else if(winner.specialCardCounter(dealerCards)<winner.specialCardCounter(playerCards)){
                    JOptionPane.showMessageDialog(null, "Congratulations! You win this round.", "Message", JOptionPane.INFORMATION_MESSAGE);
                    cash+=betMoney;
                }
                else{
                    if(winner.remainderCalculator(dealerCards)>winner.remainderCalculator(playerCards)){
                        JOptionPane.showMessageDialog(null, "Sorry! Dealer wins this round.", "Message", JOptionPane.INFORMATION_MESSAGE);
                        cash-=betMoney;
                    }
                    else if(winner.remainderCalculator(dealerCards)<winner.remainderCalculator(playerCards)){
                        JOptionPane.showMessageDialog(null, "Congratulations! You win this round.", "Message", JOptionPane.INFORMATION_MESSAGE);
                        cash+=betMoney;
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Sorry! Dealer wins this round.", "Message", JOptionPane.INFORMATION_MESSAGE);
                        cash-=betMoney;
                    }
                }
                label_Image1.setIcon(new ImageIcon("card_back.gif"));
                label_Image2.setIcon(new ImageIcon("card_back.gif"));
                label_Image3.setIcon(new ImageIcon("card_back.gif"));
                label_Image4.setIcon(new ImageIcon("card_back.gif"));
                label_Image5.setIcon(new ImageIcon("card_back.gif"));
                label_Image6.setIcon(new ImageIcon("card_back.gif"));
                btn_start.setEnabled(true);
                btn_result.setEnabled(true);
                cardsDeck=deck.cardDeck;
                Collections.shuffle(cardsDeck);
                label_info.setText("Please place your bet! Amount of money you have: $");
                label_money.setText("" + cash);
                txt_inputbet.setText("");
                if(cash==0){
                    JOptionPane.showMessageDialog(null, "Game over!\nYou have no more money!\nPlease start a new round!", "Message", JOptionPane.INFORMATION_MESSAGE);
                }



            }
        }
        class InstructionListener implements ActionListener{
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane.showMessageDialog(null, "Rules to determine who has better cards:\nJ, Q, K are regarded as special cards.\nRule 1: The one with more special cards wins.\nRule 2: If both have the same number of special cards, add the face value of the other card(s) and take the remainder after dividing the sum by 10. The one with the bigger remainder wins. (Note: Ace = 1).\nRule 3: The dealer wins if both rule 1 and rule 2 cannot distinguish the winner.","Message", JOptionPane.INFORMATION_MESSAGE);


        }
    }

}
