package userInterface;

import core.Constants;
import core.Disc;
import core.Game;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class BoardUi extends JPanel {
    
    private JButton[][] brd;
    private BoardListener listener;
    private Game g;
    private GameUi gUi;
    
    public BoardUi(Game g, GameUi gUi) {
        this.g = g;
        this.gUi = gUi;
        initComponents();
        listener.updateUi();
    }
    
    private void initComponents() {
        int i, j;
        
        this.setPreferredSize(new Dimension(400, 400));
        this.setMinimumSize(new Dimension(400, 400));
        

        this.setLayout(new GridLayout(Constants.rr, Constants.cl));
        
        brd = new JButton[Constants.rr][Constants.cl];
        listener = new BoardListener();
        
        for(i = 0; i<Constants.rr; i++) {
            for(j = 0; j<Constants.cl; j++) {
                brd[i][j] = new JButton();
   
                brd[i][j].putClientProperty("row", i);
                brd[i][j].putClientProperty("col", j);
                brd[i][j].putClientProperty("color", Constants.emp);
                
                brd[i][j].setBackground(Color.WHITE);
                

                brd[i][j].addActionListener(listener);
                
                this.add(brd[i][j]);
                
            }
        }
        
    }
    
    private class BoardListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() instanceof JButton) {
                

                JButton button = (JButton)e.getSource();
                int row = (int)button.getClientProperty("row");
                int col = (int)button.getClientProperty("col");
                Color color = (Color)button.getClientProperty("color");
                

                if(isvalidmove(row, col, g.getCurrentPlayer().getDiscColor())) {
                    updateUi();
                    chngp();
                }
                else
                    JOptionPane.showMessageDialog(
                            button,
                            "Move is not valid, select another space."
                    );
            }
        }
        
        public void updateUi() {
            Disc[][] discs = g.getbrd().getBoard();
            ImageIcon disc = null;
            
            for(int row = 0; row<Constants.rr; row++) {
                for(int col = 0; col<Constants.cl; col++) {
                    if(discs[row][col].getdisccolor() == Constants.DARK) {
                        disc = new ImageIcon(getClass().getResource("../images/colorDark.png"));
                        brd[row][col].setIcon(disc);
                        brd[row][col].putClientProperty("color", Constants.DARK);
                    }
                    else if(discs[row][col].getdisccolor() == Constants.LIGHT) {
                        disc = new ImageIcon(getClass().getResource("../images/colorLight.png"));
                        brd[row][col].setIcon(disc);
                        brd[row][col].putClientProperty("color", Constants.LIGHT);
                    }
                }
            }
            
            gUi.getScoreOne().setText(String.valueOf(g.getPlayers().get(Constants.P1).getScore()));
            gUi.getScoreTwo().setText(String.valueOf(g.getPlayers().get(Constants.P2).getScore()));
        }
        
        public boolean isvalidmove(int row, int col, Color color) {
            
            boolean isvld = false;
            
            if(brd[row][col].getClientProperty("color") != Constants.emp) {
                isvld = false;
            }
            else if(g.getbrd().isvalidmove(row, col, color, false)) {
                isvld = true;
            }
            
            return isvld;
        }
        
        public void chngp() {
            if(g.getCurrentPlayer() == g.getPlayers().get(Constants.P1))
                g.setCurrentPlayer(g.getPlayers().get(Constants.P2));
            else
                g.setCurrentPlayer(g.getPlayers().get(Constants.P1)); 
        }
        
    }
}
