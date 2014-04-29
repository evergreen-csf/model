
public class CupidMatcher {
	
	static String[] names;
	static CupidPet[] pets;
	static CupidZodiac[] signs;
	
	/*
	 * Return name of the better match to name1, either name2 or name3, based
	 * on number of properties that are compatible.
	 * If there is a tie, return name2.
	 */
	public static String getNameOfBetterMatch(
			String name1, CupidPet pet1, CupidZodiac sign1,
			String name2, CupidPet pet2, CupidZodiac sign2,
			String name3, CupidPet pet3, CupidZodiac sign3
			) {
		int matches2 = 0;
		int matches3 = 0;
		
		if (pet1.equals(pet2)) {
			matches2++;
		}
		if (pet1.equals(pet3)) {
			matches3++;
		}

		CupidZodiac firstMatch = sign1.findFirstMatch();
		CupidZodiac secondMatch = sign1.findSecondMatch();
		CupidZodiac opposite = sign1.findOpposite();

		if (firstMatch.equals(sign2) || secondMatch.equals(sign2)) {
			matches2++;			
		}
		if (opposite.equals(sign2)) {
			matches2--;
		}
		
		if (firstMatch.equals(sign3) || secondMatch.equals(sign3)) {
			matches3++;			
		}
		if (opposite.equals(sign3)) {
			matches3--;
		}


		
		if (matches2 >= matches3) {
			return name2;
		} else {
			return name3;
		}
	}
	
	public static void main(String[] args) {
		names = new String[]      {"Ada Lovelace",     "Elon Musk",     "Lao-Tzu"};
		pets  = new CupidPet[]    {CupidPet.CATS,      CupidPet.DOGS,   CupidPet.CATS};
		signs = new CupidZodiac[] {CupidZodiac.MONKEY, CupidZodiac.RAT, CupidZodiac.OX};
		
		// Find the better match for Ada Lovelace
		String betterMatchName = getNameOfBetterMatch(
				names[0], pets[0], signs[0],
				names[1], pets[1], signs[1],
				names[2], pets[2], signs[2]
				);
		System.out.println(betterMatchName);
	}
	
}
