/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Arrays;
import java.lang.Character;
import java.util.Scanner;

public class Monopoly {	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int doubleDice;
		int numberOfPlayers =0;
                int iteration=0;
                char input='0';
                String inputString="";
		int choice;
		String var ;
		int q;
	
		System.out.println("---Welcome to Monopoly Game----");
		
                while(true){
                    System.out.println("Please tell us how many player to play between 2 and 8 ?");  
                    input = scan.next().charAt(0);
                    if(input>=50 && input <=56){
                        numberOfPlayers=input-48;
                        break;
                    }
                }
		MonopolyGame mg = new MonopolyGame(numberOfPlayers);
		
		int draw[] = new int[numberOfPlayers];
	
		
		System.out.println("Please give us player names :");
		for (int i = 1; i <= numberOfPlayers; i++) {
			System.out.println("Give " + i +". player name : ");
			var = scan.next();
			mg.player[i-1].name = var;
                        draw[i-1] = i;
		}
		while(true){
                    System.out.println("Please give a number that how many times iteration proceed : ");
                    inputString=scan.next();
                    try{
                        iteration=Integer.parseInt(inputString);
                   
                    }
                    catch(NumberFormatException e){
                        System.out.println("Please Enter a integer value!!");       
                    }
                    if(iteration>0){
                         mg.setNumberOfIteration(iteration);
                         break;
                    }
                } 
                      
                    
                
		
		
		System.out.println("Players must select a piece in order :");
		for (int i = 0; i < numberOfPlayers; i++) {
			
			choice = (int)((Math.random()*8)+1);
			if(!mg.pieceArr[choice-1].isSelected) {
				mg.listPiece();
				mg.player[i].setPiece(mg.pieceArr[(choice-1)]);
				mg.player[i].getPiece().setLocation(mg.board.squares[0]);
				mg.pieceArr[choice-1].isSelected = true;
				System.out.println("Piece " + mg.player[i].getPiece().getPieceName() + " is selected by simulation for the Player named :" + mg.player[i].getName());
			}
			else {
				i--;
			}
			mg.player[i].setPiece(mg.pieceArr[(choice-1)]);
			
			mg.pieceArr[choice-1].isSelected = true;
			mg.player[i].getPiece().setLocation(mg.board.squares[0]);
		}
		
		System.out.println("Player Queue is creating ...");
		for(int i=0;i<numberOfPlayers;i++){
            q=(int) (Math.random() * numberOfPlayers) ; 
            if(draw[q] == 0) {
                i--;
            }
            else{
            mg.queue[i]=q;
            draw[q] = 0;
            System.out.println(mg.player[q].getName()+" player is :" + (i+1));
            
            }
        }
			while(0 < mg.getNumberOfIteration()) {			
			for (int j = 0; j < numberOfPlayers; j++){ 
                            if(mg.player[mg.queue[j]].bankruptcy==true){
                                continue;
                            }
				if(mg.player[mg.queue[j]].punishment==0){
                                doubleDice=0;
				System.out.println(mg.player[mg.queue[j]].getName() + " your turn :");
				mg.die1.roll();
                                mg.die2.roll();
                                 mg.player[mg.queue[j]].showInfo();
                                System.out.println("Dice are : " +mg.die1.faceValue + " " + mg.die2.faceValue + " and Total dice value :"+(mg.die1.faceValue+mg.die2.faceValue));                        
                                mg.player[mg.queue[j]].piece.goSquare(mg.board,mg.die1,mg.die2);
                                actions(mg.player[mg.queue[j]],mg.board.squares[10]);
                                mg.player[mg.queue[j]].showInfo();
                                while(mg.die1.faceValue==mg.die2.faceValue && mg.player[mg.queue[j]].punishment==0){
                                    if(mg.player[mg.queue[j]].bankruptcy==true){
                                    continue;
                                    }
                                    doubleDice++;              
                                    System.out.println("Double Dice!! Rolling Again ...");
                                    mg.die1.roll();
                                    mg.die2.roll();
                                    mg.player[mg.queue[j]].showInfo();
                                    System.out.println("Dice are : " +mg.die1.faceValue + " " + mg.die2.faceValue + " and Total dice value :"+(mg.die1.faceValue+mg.die2.faceValue));
                                    if(doubleDice==2 && mg.die1.faceValue==mg.die2.faceValue ){
                                        mg.player[mg.queue[j]].punishment=3;
                                        mg.player[mg.queue[j]].piece.setLocation(mg.board.squares[10]);
                                        System.out.println("Three times double Dice!! Go to Jail ...");
                                        break;
                                    }
                                    mg.player[mg.queue[j]].piece.goSquare(mg.board,mg.die1,mg.die2);
                                    actions(mg.player[mg.queue[j]],mg.board.squares[10]);
                                    mg.player[mg.queue[j]].showInfo();                                   
                                }
                                }
                                else{
                                    mg.player[mg.queue[j]].showInfo();
                                    System.out.println("You have penalty which one do you prefer :\n1.Roll Dice\n2.Pay 50$\n");
                                    choice = (int)(Math.random()*2);
                                    if(choice==0){
                                        System.out.println("I want to roll dice");
                                        mg.die1.roll();
                                        mg.die2.roll();
                                        mg.player[mg.queue[j]].showInfo();
                                        System.out.println("Dice are : " +mg.die1.faceValue + " " + mg.die2.faceValue + " and Total dice value :"+(mg.die1.faceValue+mg.die2.faceValue));
                                        if(mg.die1.faceValue==mg.die2.faceValue){
                                            mg.player[mg.queue[j]].punishment=0;
                                            System.out.println("Moving with these dice");                                          
                                            mg.player[mg.queue[j]].piece.goSquare(mg.board,mg.die1,mg.die2);
                                            actions(mg.player[mg.queue[j]],mg.board.squares[10]);
                                            mg.player[mg.queue[j]].showInfo();
                                        }
                                        else{
                                            mg.player[mg.queue[j]].punishment--;
                                            if(mg.player[mg.queue[j]].punishment==0){
                                                System.out.println("Punishment is end.Next round you will continoue to game");
                                            }
                                            else{
                                            System.out.println("Staying on Jail");
                                            }
                                        }           
                                    }
                                    else if(choice == 1){
                                        System.out.println("I want to pay 50M for rescure");
                                        mg.player[mg.queue[j]].decreaseMoney(50);
                                        mg.player[mg.queue[j]].punishment = 0;
                	}
                                }				
			}			
			mg.setNumberOfIteration(mg.getNumberOfIteration() - 1) ;
		}		
	}
      public static void actions(Player p, Square s) {
 
       p.piece.location.action(p,s);
                
	}
}