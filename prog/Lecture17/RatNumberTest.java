import static org.junit.Assert.*;

import org.junit.Test;


public class RatNumberTest {

	@Test
	public void test() {
		RatNumber rn1 = new RatNumber(1, 3);
		assertEquals(rn1.getNumer(), 1);
	}

}
