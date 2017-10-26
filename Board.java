
public class Board {
	
	public final int size = 40;
	
	public Board() {
		
		squares = new Square[size] ;
		
		for (int i = 0; i < size; i++) {
			squares[i] = new Square(i);
			squares[i].setNumber(i);
		}
		
	}

	Square[] squares;

	public Square[] getSquares() {
		return squares;
	}

	public void setSquares(Square[] squares) {
		this.squares = squares;
	}
	
}
