/*
 * A class for counting stats for a sequence of DNA
 * @author You
 */
public class DNACounter implements DNAStats {
	
	String sequence;
	
	public DNACounter(String sequence) {
		this.sequence = sequence;
	}
	
	@Override
	public float getGCFraction() {
		int counter = 0;
		for (char c : sequence.toCharArray()) {
			if (c == 'G' || c == 'C' ) {
				counter++;
			}
		}
		return ((float)counter) / sequence.length();
	}

	@Override
	public float getATFraction() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getGCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getCCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getACount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getTCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getLength() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
