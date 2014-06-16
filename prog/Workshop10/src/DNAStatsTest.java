import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.BeforeClass;


public class DNAStatsTest {
	
	static DNAStats stats1;
	static DNAStats stats2;
	static DNAStats stats3;
	static String seq1 = "CTAG";
	static String seq2 = "GGGCCC";
	static String seq3 = "GTGGGGGTGATGTCCACGATTACGCCGACCGGCTGG";
	
	@BeforeClass
	public static void setUp() {
		stats1 = DNAStatsFactory.createDNAStats(seq1);
		stats2 = DNAStatsFactory.createDNAStats(seq2);
		stats3 = DNAStatsFactory.createDNAStats(seq3);
	}

	@Test
	public void testGetGCFraction() {
		assertEquals(0.5, stats1.getGCFraction(), 0.001);
	}

}
