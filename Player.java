/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SADO
 */

public class Player {
	int punishment;
        public String name;
	Piece piece;
        Money money;
        boolean bankruptcy;
        
	public Player() {
		punishment=0;
                money = new Money();
                money.setValue(200);
                bankruptcy=false;
	}

	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Piece getPiece() {
		return piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}
        public void increaseMoney(int value){
            money.setValue(money.getValue()+value); 
        }
         public void decreaseMoney(int value){
            money.setValue(money.getValue()-value);
           if(money.value<=0){
                    bankruptcy=true;
                    System.out.println(name+" is bankruptcy.");
                        }
        }
         public void showInfo(){
             System.out.println("Player "+ name + " have " + money.getValue() +"M and he landed on "+piece.location.name +" ("+piece.location.number +" )");
    
}
	
	
}

