package General;

public class BitsShifter {
	int val;
	
	public BitsShifter(int val) {
		this.val = val;
	}
	
	public String toString() {
		int mask = 1;
		String result="";
		
		for (int i=0 ; i<32 ; i++) {
			int r = val & mask;
			
			if (r==0) {
				result = "0" + result;
			}
			else {
				result = "1" + result;
			}
			mask = mask << 1;
		}
		return result;
	}
	
	public int toInt() {
		return val;
	}
	
	public BitsShifter ShiftLeft() {
		val = val << 1;
		return this;
	}
	public BitsShifter ShiftLeft(int steps) {
		val = val << steps;
		return this;
	}
	
	public BitsShifter ShiftRight() {
		val = val >> 1;
		return this;
	}
	public BitsShifter ShiftRight(int steps) {
		val = val >> steps;
		return this;
	}
	
	public BitsShifter ShiftRightUS() {	//US=unsigned
		val = val >>> 1;
		return this;
	}
	public BitsShifter ShiftRightUS(int steps) {	//US=unsigned
		val = val >>> steps;
		return this;
	}
	
	//set the value (1/0) of a specific bit.
	//location is from the right s.t. location=0 is the LSB
	public BitsShifter setBitVal(int location, int bitVal) {
		if (bitVal==0) 
			clearBit(location);
		else
			setBit(location);
		
		return this;
	}
	
	//make the bit zero
	private void clearBit(int location) {
		int mask = ~1;		//read: "not one" => this is a stream of all "1" except for the LSB which is "0"
		
		mask = mask << (location);
		val = val & mask;		
	}
	//make the bit one
	private void setBit(int location) {
		int mask = 1;
		
		mask = mask << (location);
		val = val | mask;
	}

}
