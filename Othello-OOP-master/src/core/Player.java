package core;

import java.awt.Color;
import java.util.Objects;

public class Player {
    
    private String name;
    private Color discColor;
    private int score;

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public Color getDiscColor() {
        return discColor;
    }

    public void setDiscColor(Color discColor) {
        this.discColor = discColor;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

//	@Override
//	public String toString() {
//		return "Player [name=" + name + ", discColor=" + discColor + ", score=" + score + ", getname()=" + getname()
//				+ ", getDiscColor()=" + getDiscColor() + ", getScore()=" + getScore() + ", getClass()=" + getClass()
//				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
//	}
//
//	@Override
//	public int hashCode() {
//		return Objects.hash(discColor, name, score);
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Player other = (Player) obj;
//		return Objects.equals(discColor, other.discColor) && Objects.equals(name, other.name) && score == other.score;
//	}


    
    
}
