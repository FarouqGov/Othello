package userInterface;

import core.Game;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;

public class OthelloUi extends JFrame {
    
    private Game g;
    private GameUi gUi;
    private BoardUi boardUi;
    
    public OthelloUi(Game g) {
        this.g = g;

        initComponents();
    }
    
    private void initComponents() {
        this.setPreferredSize(new Dimension(600, 600));
        this.setMinimumSize(new Dimension(600, 600));
        

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        gUi = new GameUi(g);
        boardUi = new BoardUi(g, gUi);
        

        this.add(gUi, BorderLayout.NORTH);
        this.add(boardUi, BorderLayout.CENTER);
        this.setVisible(true);
    }
    
}
