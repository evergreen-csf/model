import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import org.junit.Before;


public class CupidProfileTest {

	CupidProfile[] profiles;
	
	@Before
	public void setUp() {

		profiles = new CupidProfile[3];
		profiles[0] = new CupidProfile("Ada Lovelace", CupidPet.CATS, CupidZodiac.MONKEY);
		profiles[1] = new CupidProfile("Elon Musk", CupidPet.DOGS, CupidZodiac.RAT);
		profiles[2] = new CupidProfile("Lao-Tzu", CupidPet.CATS, CupidZodiac.DRAGON);
		
	}
	
	@Test
	public void testMatch() {
		List<CupidProfile> others = new LinkedList<CupidProfile>();
		others.add(profiles[1]);
		others.add(profiles[2]);
		CupidProfile betterMatch = profiles[0].getBestMatch(others);
		assertEquals(betterMatch, profiles[1]);
	}

}
