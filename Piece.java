/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SADO
 */

public class Piece {
	
	Square location;
	boolean isSelected;
	public String pieceName;
	
	public Piece() {
                
		isSelected = false;
	}
	
	public Square getLocation() {
		return location;
	}
	
	public void setLocation(Square location) {
		this.location = location;
	}
	
	public boolean isSelected() {
		return isSelected;
	}
	
	public void setSelected(boolean isSelected) {
		this.isSelected = isSelected;
	}
	
	public String getPieceName() {
		return pieceName;
	}
	
	public void setPieceName(String pieceName) {
		this.pieceName = pieceName;
	}
        public void goSquare(Board b,Die d1,Die d2) {
        location=b.squares[(location.number+d1.getFaceValue()+d2.getFaceValue())%40];
     
}
	
	
}
