/*
 * Factory class to create the right kind of DNAStats object for testing.
 */
public class DNAStatsFactory {

	public static DNAStats createDNAStats(String sequence) {
		return new DNACounter(sequence);
	}
	
}
