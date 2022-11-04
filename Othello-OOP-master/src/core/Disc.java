package core;

import java.awt.Color;
import java.util.Objects;

public class Disc {
    
    private Color discclr;
    

    public Color getdisccolor() {
        return discclr;
    }

    public void setdisccolor(Color discColor) {
        this.discclr = discColor;
    }

//	@Override
//	public int hashCode() {
//		return Objects.hash(discclr);
//	}

//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj) {
//			return true;
//		}
//		if (!(obj instanceof Disc)) {
//			return false;
//		}
//		Disc other = (Disc) obj;
//		return Objects.equals(discclr, other.discclr);
//	}

//	@Override
//	public String toString() {
//		return "Disc [discclr=" + discclr + ", getdisccolor()=" + getdisccolor() + ", getClass()=" + getClass()
//				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
//	}
    
    
}
