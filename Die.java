
public class Die {

	public int faceValue;

	public int getFaceValue() {
		return faceValue;
	}

	public void setFaceValue(int faceValue) {
		this.faceValue = faceValue;
	}
	
	public void roll() {
		faceValue = (int) ((Math.random() * 6) + 1);
	}
	
}
