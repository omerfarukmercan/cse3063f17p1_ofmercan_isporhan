import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class RailRoad extends PropertySquare{
	
	Player owner;
	
	public RailRoad(int number, String name, Money price, Money rent) {
		super(number, name, price, rent);
		price.setValue(200);
	}
	
	public void action(Player p, Square s,Die d1,Die d2){
		int total;
		
		if(owner != null) {
			if(owner != p) {
				if(owner.bankruptcy!=true) {
					total= d1.faceValue + d2.faceValue;
					rent.setValue((total * 5) + 25);
					p.decreaseMoney(rent.getValue());
					owner.increaseMoney(rent.getValue());
				}
				
			}
			else {
				
			}
			
		}
		else {
			d1.roll();
			d2.roll();
			writeToFile("----------------------------");
			System.out.println("----------------------------");
			writeToFile(""+d1.faceValue+"");
			System.out.println(d1.faceValue);
			writeToFile(""+d2.faceValue+"");
			System.out.println(d2.faceValue);
			writeToFile("----------------------------");
			System.out.println("----------------------------");
			if((d1.faceValue + d2.faceValue) > 4 && p.money.getValue() >= price.getValue()) {
				owner = p;
				p.decreaseMoney(price.getValue());
			}
			else {
				
			}
		}
	}
	 public static void writeToFile(String output){
		 String fileNameOutput="src/output.txt";
		 BufferedWriter writer;
		try {
			writer = new BufferedWriter(new FileWriter(fileNameOutput, true));
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
