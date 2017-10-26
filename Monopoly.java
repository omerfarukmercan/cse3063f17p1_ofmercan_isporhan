import java.util.Scanner;

public class Monopoly {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int numberOfPlayers = 0;
		int choice;
		String var ;
		int q;
	
		System.out.println("---Welcome to Monopoly Game----");
		System.out.println("Please tell us how many player to play ?");
		
		numberOfPlayers = scan.nextInt();
		MonopolyGame mg = new MonopolyGame(numberOfPlayers);
		
		int draw[] = new int[numberOfPlayers];
		
		System.out.println("Please give us player names :");
		for (int i = 1; i <= numberOfPlayers; i++) {
			System.out.println("Give " + i +". player name : ");
			var = scan.next();
			mg.player[i-1].name = var;
			draw[i-1] = i;
		}
		
		System.out.println("Please give a number that how many times iteration proceed : ");
		mg.setNumberOfIteration(scan.nextInt());
		
		
		System.out.println("Players must select a piece in order :");
		for (int i = 0; i < numberOfPlayers; i++) {
			mg.listPiece();
			System.out.println((i+1) + ". player select your piece as a number:");
			choice = scan.nextInt();
			mg.player[i].setPiece(mg.pieceArr[(choice-1)]);
			mg.player[i].getPiece().setLocation(mg.board.squares[0]);
			mg.pieceArr[choice-1].isSelected = true;
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
			
			for (int j = 0; j < numberOfPlayers; j++) {
				
				System.out.println(mg.player[mg.queue[j]].getName() + " your turn :");
				mg.die1.roll();
                mg.die2.roll();
                System.out.println(mg.player[mg.queue[j]].getName() + " current location is square "+ mg.player[mg.queue[j]].piece.getLocation().number);
                System.out.println("Dice are : " +mg.die1.faceValue + " " + mg.die2.faceValue);
                mg.player[mg.queue[j]].piece.goSquare(mg.board,mg.die1,mg.die2);
                System.out.println(mg.player[mg.queue[j]].getName() + " new location is square "+ mg.player[mg.queue[j]].piece.getLocation().number);
				
			}
			
			mg.setNumberOfIteration(mg.getNumberOfIteration() - 1) ;
		}
		
	}
}