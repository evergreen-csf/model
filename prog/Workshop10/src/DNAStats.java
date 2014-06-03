/*
 * Interface for computing statistics for a sequence of DNA
 */
public interface DNAStats {

	public float getGCFraction();
	
	public float getATFraction();
	
	public int getGCount();
	
	public int getCCount();
	
	public int getACount();
	
	public int getTCount();
	
	public int getLength();
	
}
