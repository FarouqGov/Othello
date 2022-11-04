package core;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Game {
    

    public Game() {
        initObjects(); 
    }
    

    private ArrayList<Player> pls;
    private Board brd;
    private Player cp;

    public Board getbrd() {
        return brd;
    }

    public void setbrd(Board brd) {
        this.brd = brd;
    }

    public ArrayList<Player> getPlayers() {
        return pls;
    }
    
    public void setPlayers(ArrayList<Player> pls) {
        this.pls = pls;
    }
    
    private void initObjects() {
        brd = new Board();
        createPlayers();
        brd.setplayers(pls);
        //printPlayers();
        pls.get(Constants.P1).setScore(Constants.t2);
        pls.get(Constants.P2).setScore(Constants.t2);
        cp = pls.get(Constants.P1);
    }
    
    public void createPlayers() {
        

        pls = new ArrayList<>();
        

        for(int i=0; i<Constants.pmax; i++) {
            String askname = JOptionPane.showInputDialog(null, "Enter player's name");
            Player player = new Player();
            player.setname(askname);
            
            if(i == 0)
                player.setDiscColor(Constants.DARK);
            else
                player.setDiscColor(Constants.LIGHT);
            
            pls.add(player);
        }
    }
    
    public void printPlayers() {
        System.out.println("The game has the following pls:");

        pls.forEach((player) -> {
            System.out.println(
                    "Player "
                    + player.getname()
                    + " is playing disc color "
                    + player.getDiscColor()
            );
        });
    }
     
    public Player getCurrentPlayer() {
        return cp;
    }

    public void setCurrentPlayer(Player cp) {
        this.cp = cp;
    }
    
    public void calculateScore() {
       // brd.calculateScore();
        
        //Update the score for each player.
        //pls.get(Constants.P1).setScore(brd.getDarkCount());
        //pls.get(Constants.P2).setScore(brd.getLightCount());
    }
}
