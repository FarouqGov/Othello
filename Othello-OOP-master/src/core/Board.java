package core;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;

public class Board {
    
    private Disc[][] brd;
    private int countingDarkarea;
    private int countinglightingarea;
    private ArrayList<Player> pls;
    
    public Board() {
        initObjects();
    }

    public Disc[][] getBoard() {
        return brd;
    }
    
    public void setboard(Disc[][] brd) {
        this.brd = brd;
    }
    
    public ArrayList<Player> getplayers() {
        return pls;
    }

    public void setplayers(ArrayList<Player> pls) {
        this.pls = pls;
    }
    
    private void initObjects() {
        int i, j;
        
        brd = new Disc[8][8];
        
  
        for(i=0; i<8; i++) {
            for(j=0; j<8; j++) {
                brd[i][j] = new Disc();
            }
        }
  
        brd[3][3].setdisccolor(Constants.LIGHT);
        brd[3][4].setdisccolor(Constants.DARK);
        brd[4][3].setdisccolor(Constants.DARK);
        brd[4][4].setdisccolor(Constants.LIGHT);
    }
    
    public int getdarkcount() {
        return countingDarkarea;
    }
    
    public void setdarkcount(int countingDarkarea) {
        this.countingDarkarea = countingDarkarea;
    }

    public int getlightcount() {
        return countinglightingarea;
    }

    public void setlightcount(int countinglightingarea) {
        this.countinglightingarea = countinglightingarea;
    }
    
    public void calculatescore() {
        int i, j;
        countingDarkarea = 0;
        countinglightingarea = 0;
        
        for(i=0; i<Constants.rr; i++ ) {
            for(j=0; j<Constants.cl; j++) {
                if(brd[i][j].getdisccolor() == Constants.DARK) {
                    countingDarkarea++;
                }
                else if(brd[i][j].getdisccolor() == Constants.LIGHT) {
                    countinglightingarea++;
                }
            }
        }
        

        pls.get(Constants.P1).setScore(countingDarkarea);
        pls.get(Constants.P2).setScore(countinglightingarea);
    }
    
    public boolean checkup(int row, int col, Color color, boolean flip) {
        
        int flpsquare = 0;
        int checkRow = row-1;
        boolean smec = false;
        boolean isvalid = false;
        
        while(checkRow >= 0 && !smec) {
            
    
            if(brd[checkRow][col].getdisccolor() == Constants.emp)
                return isvalid;
            

            else if(brd[checkRow][col].getdisccolor() != color)
                flpsquare++;

            else {
                smec = true;
            }
            
            checkRow--;
        }
        
        if(smec && flpsquare > 0) {
            brd[row][col].setdisccolor(color);
            do {
                row--;
                flpsquare--;
                brd[row][col].setdisccolor(color);
            }while(flpsquare > 0);
            
            isvalid = true;
            calculatescore();
        }
        else
            isvalid = false;
        
        return isvalid;
    }
    
    public boolean checkupleft(int row, int col, Color color, boolean flip) {
        
        int flpsquare = 0;
        int checkRow = row-1;
        int checkCol = col-1;
        boolean smec = false;
        boolean isvalid = false;
        
        while(checkRow >= 0 && checkCol >= 0 && !smec) {
            

            if(brd[checkRow][checkCol].getdisccolor() == Constants.emp)
                return isvalid;
            

            else if(brd[checkRow][checkCol].getdisccolor() != color)
                flpsquare++;
            
 
            else {
                smec = true;
            }
            
            checkRow--;
            checkCol--;
        }
        
        if(smec && flpsquare > 0) {
            brd[row][col].setdisccolor(color);
            do {
                row--;
                col--;
                flpsquare--;
                brd[row][col].setdisccolor(color);
            }while(flpsquare > 0);
            
            isvalid = true;
            calculatescore();
        }
        else
            isvalid = false;
        
        
        
        return isvalid;
    }
        
    public boolean checkleft(int row, int col, Color color, boolean flip) {
        
        int flpsquare = 0;
        int checkCol = col - 1;
        boolean smec = false;
        boolean isvalid = false;
        
        while(checkCol >= 0 && !smec) {
            
    
            if(brd[row][checkCol].getdisccolor() == Constants.emp)
                return isvalid;
            

            else if(brd[row][checkCol].getdisccolor() != color)
                flpsquare++;
            

            else {
                smec = true;
            }
            
            checkCol--;
        }
        
        if(smec && flpsquare > 0) {
            brd[row][col].setdisccolor(color);
            do {
                col--;
                flpsquare--;
                brd[row][col].setdisccolor(color);
            }while(flpsquare > 0);
            
            isvalid = true;
            calculatescore();
        }
        else
            isvalid = false;
        
        return isvalid;
    }
    
    public boolean checkdownleft(int row, int col, Color color, boolean flip) {
        
        int flpsquare = 0;
        int checkRow = row + 1;
        int checkCol = col - 1;
        boolean smec = false;
        boolean isvalid = false;
        
        while((checkRow < Constants.rr && checkCol >= 0) && !smec) {

            if(brd[checkRow][checkCol].getdisccolor() == Constants.emp)
                return isvalid;
            

            else if(brd[checkRow][checkCol].getdisccolor() != color)
                flpsquare++;
            

            else {
                smec = true;
            }
            
            checkRow++;
            checkCol--;
        }
        
        if(smec && flpsquare > 0) {
            brd[row][col].setdisccolor(color);
            do {
                row++;
                col--;
                flpsquare--;
                brd[row][col].setdisccolor(color);
            }while(flpsquare > 0);
            
            isvalid = true;
            calculatescore();
        }
        else
            isvalid = false;
        
        return isvalid;
    }
    
    public boolean checkdown(int row, int col, Color color, boolean flip) {
        
        int flpsquare = 0;
        int checkRow = row + 1;
        boolean smec = false;
        boolean isvalid = false;
        
        while(checkRow < Constants.rr && !smec) {
            

            if(brd[checkRow][col].getdisccolor() == Constants.emp)
                return isvalid;
            

            else if(brd[checkRow][col].getdisccolor() != color)
                flpsquare++;
            

            else {
                smec = true;
            }
            
            checkRow++;
        }
        
        if(smec && flpsquare > 0) {
            brd[row][col].setdisccolor(color);
            do {
                row++;
                flpsquare--;
                brd[row][col].setdisccolor(color);
            }while(flpsquare > 0);
            
            isvalid = true;
            calculatescore();
        }
        else
            isvalid = false;
        
        return isvalid;
    }
    
    public boolean checkdownright(int row, int col, Color color, boolean flip) {
        
        int flpsquare = 0;
        int checkRow = row + 1;
        int checkCol = col + 1;
        boolean smec = false;
        boolean isvalid = false;
        
        while((checkRow < Constants.rr && checkCol < Constants.cl) && !smec) {
            

            if(brd[checkRow][checkCol].getdisccolor() == Constants.emp)
                return isvalid;
            

            else if(brd[checkRow][checkCol].getdisccolor() != color)
                flpsquare++;
            

            else {
                smec = true;
            }
            
            checkRow++;
            checkCol++;
        }
        
        if(smec && flpsquare > 0) {
            brd[row][col].setdisccolor(color);
            do {
                row++;
                col++;
                flpsquare--;
                brd[row][col].setdisccolor(color);
            }while(flpsquare > 0);
            
            isvalid = true;
            calculatescore();
        }
        else
            isvalid = false;
        
        return isvalid;
    }
    
    public boolean checkright(int row, int col, Color color, boolean flip) {
        
        int flpsquare = 0;
        int checkCol = col + 1;
        boolean smec = false;
        boolean isvalid = false;
        
        while(checkCol < Constants.cl && !smec) {
            

            if(brd[row][checkCol].getdisccolor() == Constants.emp)
                return isvalid;
            

            else if(brd[row][checkCol].getdisccolor() != color)
                flpsquare++;

            else {
                smec = true;
            }
            
            checkCol++;
        }
        
        if(smec && flpsquare > 0) {
            brd[row][col].setdisccolor(color);
            do {
                col++;
                flpsquare--;
                brd[row][col].setdisccolor(color);
            }while(flpsquare > 0);
            
            isvalid = true;
            calculatescore();
        }
        else
            isvalid = false;
        
        return isvalid;
    }
    
    public boolean checkupright(int row, int col, Color color, boolean flip) {
        
        int flpsquare = 0;
        int checkRow = row - 1;
        int checkCol = col + 1;
        boolean smec = false;
        boolean isvalid = false;
        
        while(checkRow >= 0 && checkCol < Constants.cl && !smec) {
            

            if(brd[checkRow][checkCol].getdisccolor() == Constants.emp)
                return isvalid;
            

            else if(brd[checkRow][checkCol].getdisccolor() != color)
                flpsquare++;

            else {
                smec = true;
            }
            
            checkRow--;
            checkCol++;
        }
        
        if(smec && flpsquare > 0) {
            brd[row][col].setdisccolor(color);
            do {
                row--;
                col++;
                flpsquare--;
                brd[row][col].setdisccolor(color);
            }while(flpsquare > 0);
            
            isvalid = true;
            calculatescore();
        }
        else
            isvalid = false;

        return isvalid;
    }
    
    public boolean brdfull() {
        return pls.get(Constants.P1).getScore() 
       + pls.get(Constants.P2).getScore()
       == 64;
    }
    
    public boolean gameover(Color color) {
        
        int i, j;
        
        boolean gameover = false;
            
        if(brdfull()) {
            gameover = true;
            return gameover;
        }
        if(!hasmove(Constants.DARK) && !hasmove(Constants.LIGHT))
            gameover = true;
        
        return gameover;
    }
    
    public boolean hasmove(Color color) {
        
        boolean ismove = false;
        
        for(int row = 0; row<Constants.rr; row++) {
            for(int col = 0; col<Constants.cl; col++) {
                if(brd[row][col].getdisccolor() == null && ismove == true) {
                    ismove = isvalidmove(row, col, color, false);
                }
            }
        }
        
        return ismove;
    }
    
    public boolean isvalidmove(int row, int col, Color color, boolean flip) {
        
        boolean isvalid = false;
        

        if(checkup(row, col, color, false))
            isvalid = true;
        else if(checkupleft(row, col, color, false))
            isvalid = true;
        else if(checkleft(row, col, color, false))
            isvalid = true;
        else if(checkdownleft(row, col, color, false))
            isvalid = true;
        else if(checkdown(row, col, color, false))
            isvalid = true;
        else if(checkdownright(row, col, color, false))
            isvalid = true;
        else if(checkright(row, col, color, false))
            isvalid = true;
        else if(checkupright(row, col, color, false))
            isvalid = true;
        
        if(isvalid)
            brd[row][col].setdisccolor(color);
        

        gameover(color);
        
        return isvalid;
        
    }

//	@Override
//	public String toString() {
//		return "Board [brd=" + Arrays.toString(brd) + ", countingDarkarea=" + countingDarkarea
//				+ ", countinglightingarea=" + countinglightingarea + ", pls=" + pls + ", getBoard()="
//				+ Arrays.toString(getBoard()) + ", getplayers()=" + getplayers() + ", getdarkcount()=" + getdarkcount()
//				+ ", getlightcount()=" + getlightcount() + ", brdfull()=" + brdfull() + ", getClass()=" + getClass()
//				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
//	}
    
}
