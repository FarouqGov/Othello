package userInterface;

import core.Constants;
import core.Game;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameUi extends JPanel {
    
    public GameUi(Game game) {
        this.game = game;
        initComponents();
    }
    
    private JLabel nameOne;
    private JLabel nameTwo;
    private JLabel scoreOne;
    private JLabel scoreTwo;
    private Game game;
    
    private void initComponents() {
        

        this.setPreferredSize(new Dimension(400, 50));
        this.setMinimumSize(new Dimension(400, 50));
        
        ImageIcon discOne = new ImageIcon(getClass().getResource("../images/colorDark.png"));
        nameOne = new JLabel();
        nameOne.setIcon(discOne);
        nameOne.setText(game.getPlayers().get(Constants.P1).getname());
        nameOne.setMinimumSize(new Dimension(100, 50));
        nameOne.setPreferredSize(new Dimension(100, 50));
        
        ImageIcon discTwo = new ImageIcon(getClass().getResource("../images/colorLight.png"));
        nameTwo = new JLabel();
        nameTwo.setIcon(discTwo);
        nameTwo.setText(game.getPlayers().get(Constants.P2).getname());
        nameTwo.setMinimumSize(new Dimension(100, 50));
        
        scoreOne = new JLabel();
        scoreOne.setText(String.valueOf(game.getPlayers().get(Constants.P1).getScore()));
        scoreOne.setMinimumSize(new Dimension(150, 50));
        scoreOne.setPreferredSize(new Dimension(150, 50));
        
        scoreTwo = new JLabel();
        scoreTwo.setText(String.valueOf(game.getPlayers().get(Constants.P2).getScore()));
        scoreTwo.setMinimumSize(new Dimension(150, 50));
        scoreTwo.setPreferredSize(new Dimension(150, 50));
        

        this.add(nameOne);
        this.add(scoreOne);
        this.add(nameTwo);
        this.add(scoreTwo);
       
    }

    public JLabel getname1() {
        return nameOne;
    }

    public void setfstname(JLabel nameOne) {
        this.nameOne = nameOne;
    }

    public JLabel getname2() {
        return nameTwo;
    }

    public void set2ndname(JLabel nameTwo) {
        this.nameTwo = nameTwo;
    }

    public JLabel getScoreOne() {
        return scoreOne;
    }

    public void setScoreOne(JLabel scoreOne) {
        this.scoreOne = scoreOne;
    }

    public JLabel getScoreTwo() {
        return scoreTwo;
    }

    public void setScoreTwo(JLabel scoreTwo) {
        this.scoreTwo = scoreTwo;
    }
}
