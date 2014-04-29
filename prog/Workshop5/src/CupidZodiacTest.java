import static org.junit.Assert.*;

import org.junit.Test;


public class CupidZodiacTest {
	
	CupidZodiac mySign = CupidZodiac.MONKEY;

	@Test
	public void testFirstMatch() {
		CupidZodiac firstMatch = mySign.findFirstMatch();
		assertEquals(firstMatch, CupidZodiac.RAT);
	}

	@Test
	public void testSecondMatch() {
		CupidZodiac firstMatch = mySign.findSecondMatch();
		assertEquals(firstMatch, CupidZodiac.DRAGON);
	}

	@Test
	public void testOpposite() {
		CupidZodiac opposite = mySign.findOpposite();
		assertEquals(opposite, CupidZodiac.TIGER);
	}
	
	@Test
	public void testPrint() {
		System.out.println(CupidZodiac.TIGER);
	}

}
