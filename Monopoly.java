/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.lang.Character;
import java.util.Scanner;

public class Monopoly {	
		
		
		static Boolean[] Player;
		public static void main(String[] args) throws FileNotFoundException {
		File delete=new File("src/output.txt");
		delete.delete();
		Scanner scan = new Scanner(System.in);
		int doubleDice,loser=0;
		int numberOfPlayers =0;
        int iteration=0;
        int startmoney=0;
        char input='0';
        String inputString="";
		int choice;
		String var ;
		int q;
		int x1,x2,y1,y2;	
		writeToFile("---Welcome to Monopoly Game----");
		System.out.println("---Welcome to Monopoly Game----");		
        while(true){
        	writeToFile("Please tell us how many player to play between 2 and 8 ?");
            System.out.println("Please tell us how many player to play between 2 and 8 ?");  
            input = scan.next().charAt(0);
            writeToFile(""+input);
            if(input>=50 && input <=56){
                numberOfPlayers=input-48;
                
                break;
            }
        }         
		MonopolyGame mg = new MonopolyGame(numberOfPlayers);
		Player =new Boolean[numberOfPlayers];
		for(int i=0;i<numberOfPlayers;i++) {
			Player[i]=true;
		}
		Scanner scanner = new Scanner(new File("Monopoly-Lots.csv"));
		scanner.useDelimiter(";");
		scanner.nextLine();		
		String line ;
		int position,price,rent;
		while(scanner.hasNext()){        	
			line=scanner.nextLine();
			position=Integer.parseInt(line.substring(0,line.indexOf(';')));
			line=line.substring(line.indexOf(';')+1,line.length());			
        	price = Integer.parseInt(line.substring(0,line.indexOf(';')));
        	line=line.substring(line.indexOf(';')+1,line.length());        	
        	rent=Integer.parseInt(line);       	
        	mg.board.squares[position-1].price.setValue(price);
			mg.board.squares[position-1].rent.setValue(rent);
        }
        scanner.close();				
		int draw[] = new int[numberOfPlayers];
		writeToFile("Please give us player names :");
		System.out.println("Please give us player names :");
		for (int i = 1; i <= numberOfPlayers; i++) {
			writeToFile("Give " + i +". player name : ");
			System.out.println("Give " + i +". player name : ");
			var = scan.next();
			writeToFile(""+var);
			mg.player[i-1].name = var;
                        draw[i-1] = i;
		}
		while(true){
			writeToFile("Please write money value that will be start value of money for all players : ");
            System.out.println("Please write money value that will be start value of money for all players : ");
            inputString=scan.next();
            writeToFile(""+inputString);
            try{
            	startmoney=Integer.parseInt(inputString); 
            }
            catch(NumberFormatException e){
            	writeToFile("Please Enter a integer value!!");
                System.out.println("Please Enter a integer value!!");       
            }
            if(startmoney>0){
                 for(int i=0;i<numberOfPlayers;i++) {
                	 mg.player[i].money.setValue(startmoney);
                 }
                 break;
            }
        } 
		/*while(true){
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
                }             */       
		writeToFile("Players must select a piece in order :");
		System.out.println("Players must select a piece in order :");
		for (int i = 0; i < numberOfPlayers; i++) {			
			choice = (int)((Math.random()*8)+1);
			if(!mg.pieceArr[choice-1].isSelected) {
				mg.listPiece();
				mg.player[i].setPiece(mg.pieceArr[(choice-1)]);
				mg.player[i].getPiece().setLocation(mg.board.squares[0]);
				mg.pieceArr[choice-1].isSelected = true;
				writeToFile("Piece " + mg.player[i].getPiece().getPieceName() + " is selected by simulation for the Player named :" + mg.player[i].getName());
				System.out.println("Piece " + mg.player[i].getPiece().getPieceName() + " is selected by simulation for the Player named :" + mg.player[i].getName());
			}
			else {
				i--;
			}
		}		
		writeToFile("Player Queue is creating ...");
		System.out.println("Player Queue is creating ...");
		for(int i=0;i<numberOfPlayers;i++){
            q=(int) (Math.random() * numberOfPlayers) ; 
            if(draw[q] == 0) {
                i--;
            }
            else{
            mg.queue[i]=q;
            draw[q] = 0;
            writeToFile(mg.player[q].getName()+" player is :" + (i+1));       
            System.out.println(mg.player[q].getName()+" player is :" + (i+1));            
            }
        }
			while(numberOfPlayers-loser>1) {			
			for (int j = 0; j < numberOfPlayers; j++){ 
                            if(mg.player[mg.queue[j]].bankruptcy==true){
                                continue;
                            }
                            if(mg.player[mg.queue[j]].punishment==0){
                                doubleDice=0;
                                writeToFile(mg.player[mg.queue[j]].getName() + " your turn :");
                                System.out.println(mg.player[mg.queue[j]].getName() + " your turn :");
                                mg.die1.roll();
                                mg.die2.roll();
                                x1 = mg.die1.faceValue;
                                x2 = mg.die2.faceValue;
                                mg.player[mg.queue[j]].showInfo();
                                writeToFile("Dice are : " +mg.die1.faceValue + " " + mg.die2.faceValue + " and Total dice value :"+(mg.die1.faceValue+mg.die2.faceValue));
                                System.out.println("Dice are : " +mg.die1.faceValue + " " + mg.die2.faceValue + " and Total dice value :"+(mg.die1.faceValue+mg.die2.faceValue));                        
                                mg.player[mg.queue[j]].piece.goSquare(mg.board,mg.die1,mg.die2);
                                actions(mg.player[mg.queue[j]],mg.board.squares[10],mg.die1,mg.die2);
                                if(mg.player[mg.queue[j]].money.value<0) {
                               	 Player[j]=false;
                               	 break;
                                }
                                mg.die1.faceValue = x1;
                                mg.die2.faceValue = x2;
                                mg.player[mg.queue[j]].showInfo();
                                while(mg.die1.faceValue==mg.die2.faceValue && mg.player[mg.queue[j]].punishment==0){
                                    if(mg.player[mg.queue[j]].bankruptcy==true){                                   	
                                    	continue;
                                    }
                                    doubleDice++;    
                                    writeToFile("Double Dice!! Rolling Again ...");
                                    System.out.println("Double Dice!! Rolling Again ...");
                                    mg.die1.roll();
                                    mg.die2.roll();
                                    y1 = mg.die1.faceValue;
                                    y2 = mg.die2.faceValue;
                                    mg.player[mg.queue[j]].showInfo();
                                    writeToFile("Dice are : " +mg.die1.faceValue + " " + mg.die2.faceValue + " and Total dice value :"+(mg.die1.faceValue+mg.die2.faceValue));
                                    System.out.println("Dice are : " +mg.die1.faceValue + " " + mg.die2.faceValue + " and Total dice value :"+(mg.die1.faceValue+mg.die2.faceValue));
                                    if(doubleDice==2 && mg.die1.faceValue==mg.die2.faceValue ){
                                        mg.player[mg.queue[j]].punishment=3;
                                        mg.player[mg.queue[j]].piece.setLocation(mg.board.squares[10]);
                                        writeToFile("Three times double Dice!! Go to Jail ...");
                                        System.out.println("Three times double Dice!! Go to Jail ...");
                                        break;
                                    }
                                    mg.player[mg.queue[j]].piece.goSquare(mg.board,mg.die1,mg.die2);
                                    actions(mg.player[mg.queue[j]],mg.board.squares[10],mg.die1,mg.die2);
                                    if(mg.player[mg.queue[j]].money.value<0) {
                                      	 Player[j]=false;
                                      	 break;
                                       }
                                    mg.die1.faceValue = y1;
                                    mg.die2.faceValue = y2;
                                    mg.player[mg.queue[j]].showInfo();                                   
                                }
                                }
                                else{
                                    mg.player[mg.queue[j]].showInfo();
                                    writeToFile("You have penalty which one do you prefer :\n1.Roll Dice\n2.Pay 50$\n");
                                    System.out.println("You have penalty which one do you prefer :\n1.Roll Dice\n2.Pay 50$\n");
                                    choice = (int)(Math.random()*2);
                                    if(choice==0){
                                    	writeToFile("I want to roll dice");
                                        System.out.println("I want to roll dice");
                                        mg.die1.roll();
                                        mg.die2.roll();
                                        mg.player[mg.queue[j]].showInfo();
                                        writeToFile("Dice are : " +mg.die1.faceValue + " " + mg.die2.faceValue + " and Total dice value :"+(mg.die1.faceValue+mg.die2.faceValue));
                                        System.out.println("Dice are : " +mg.die1.faceValue + " " + mg.die2.faceValue + " and Total dice value :"+(mg.die1.faceValue+mg.die2.faceValue));
                                        if(mg.die1.faceValue==mg.die2.faceValue){
                                            mg.player[mg.queue[j]].punishment=0;
                                            writeToFile("Moving with these dice");  
                                            System.out.println("Moving with these dice");                                          
                                            mg.player[mg.queue[j]].piece.goSquare(mg.board,mg.die1,mg.die2);
                                            actions(mg.player[mg.queue[j]],mg.board.squares[10],mg.die1,mg.die1);
                                            if(mg.player[mg.queue[j]].money.value<0) {
                                              	 Player[j]=false;
                                              	 break;
                                               }
                                            mg.player[mg.queue[j]].showInfo();
                                        }
                                        else{
                                            mg.player[mg.queue[j]].punishment--;
                                            if(mg.player[mg.queue[j]].punishment==0){
                                            	writeToFile("Punishment is end.Next round you will continoue to game");
                                                System.out.println("Punishment is end.Next round you will continoue to game");
                                            }
                                            else{
                                            	writeToFile	("Staying on Jail");
                                            	System.out.println("Staying on Jail");
                                            }
                                        }           
                                    }
                                    else if(choice == 1){
                                    	writeToFile("I want to pay 50M for rescure");
                                        System.out.println("I want to pay 50M for rescure");
                                        mg.player[mg.queue[j]].decreaseMoney(50);
                                        mg.player[mg.queue[j]].punishment = 0;
                                        if(mg.player[mg.queue[j]].money.value<0) {
                                        	Player[j]=false;
                                        	break;
                                        }
                	}
                                }				
			}	
			loser=0;
			for(int i=0;i<numberOfPlayers;i++) {
				if(Player[i]==false) {
					loser++;
				}
			}
			//mg.setNumberOfIteration(mg.getNumberOfIteration() - 1) ;
		}		
	}
	
      public static void actions(Player p, Square s, Die d1, Die d2) {
       p.piece.location.action(p,s,d1,d2);
            
	}
      public static void writeToFile(String output){
    	  	
    		 String fileNameOutput="src/output.txt";
  
    		 BufferedWriter writer;
    		try {
    			writer = new BufferedWriter(new FileWriter(fileNameOutput,true));
    			writer.append('\n');
    			writer.append(output);
    			writer.newLine();
    			writer.close();
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    		
    	}
}