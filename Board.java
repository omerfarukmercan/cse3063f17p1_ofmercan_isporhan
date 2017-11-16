/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author SADO
 */

public class Board {
        Square[] squares;
        int size=40;
        
        public Board() {
		squares = new Square[size] ;
                for(int i=0;i<40;i++){
                    if(i==0){
                        squares[i] = new GoSquare(i,"Go Square");
                        
                    }
                    else if(i==2 || i==17 || i==33){
                        squares[i] = new CommunityChestSquare(i,"Community Chest Square");
                        
                    }
                    else if(i==4){
                        squares[i] = new IncomeTaxSquare(i,"Income Tax Square");
                        
                    }
                    else if(i==7||i==22||i==36){
                        squares[i] = new ChanceSquare(i,"ChanceSquare");
                        
                    }
                    else if(i==10){
                        squares[i] = new JailSquare(i,"Jail Square");
                        
                    }
                    else if(i==20){
                        squares[i] = new NormalSquare(i,"Free Parking");
                        
                    }
                    else if(i==30){
                        squares[i] = new GotoJailSquare(i,"Go to Jail Square");
                       
                    }
                    else if(i==38){
                        squares[i] = new LuxuryTaxSquare(i,"Luxury Tax Square");
                        
                    }
                    else{
                        squares[i] = new PropertySquare(i,"Property Square");
                       
                    }
                    
        }
	}

	
	

	public Square[] getSquares() {
		return squares;
	}

	public void setSquares(Square[] squares) {
		this.squares = squares;
	}
        
	
	
	
}
