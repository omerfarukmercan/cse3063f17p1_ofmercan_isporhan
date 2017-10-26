import java.util.Arrays;

public class MonopolyGame {
		
	public MonopolyGame(int numberofplayer) {	
		board =new Board();
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
        
        queue = new int[numberofplayer];
        Arrays.fill(queue,0);
    	
	}
	
	public Piece[] pieceArr ;
	Board board;
	Player[] player;
	Die die1;
	Die die2;
	public int numberOfIteration;
	int[] queue;
	

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
