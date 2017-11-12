/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly;
import java.util.Arrays;
/**
 *
 * @author SADO
 */

public class MonopolyGame {
     public Piece[] pieceArr ;
	Board board;
	Player[] player;
        int[] queue;
	Die die1;
	Die die2;
	public int numberOfIteration;
	
	
		
	public MonopolyGame(int numberofplayer) {	
	board=new Board();
        queue= new int [numberofplayer];
        
	player =new Player[numberofplayer];
    	die1=new Die();
    	die2=new Die(); 
        pieceArr = new Piece[8];
		
		for (int i = 0; i < 8; i++) {
			pieceArr[i] = new Piece();
		}
		for (int i = 0; i < numberofplayer; i++) {
			player[i] = new Player();
		}
		
		pieceArr[0].setPieceName("timble");
                pieceArr[1].setPieceName("wheelbarrow");
                pieceArr[2].setPieceName("shoe");
                pieceArr[3].setPieceName("horse");
                pieceArr[4].setPieceName("howitzer");
                pieceArr[5].setPieceName("bag");
                pieceArr[6].setPieceName("iron");
                pieceArr[7].setPieceName("train");
		
	}


	public int getNumberOfIteration() {
		return numberOfIteration;
	}

	public void setNumberOfIteration(int numberOfIteration) {
		this.numberOfIteration = numberOfIteration;
	}
	
	public void listPiece(){
	       for(int i=0;i<8;i++){
	           if(pieceArr[i].isSelected == false){
	        	   System.out.println((i+1)+")" +pieceArr[i].getPieceName());
	           }  
	       }
	}
         
	
	
}
