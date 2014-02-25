import static org.junit.Assert.*;

import org.junit.Test;

public class SongTest {
	
	String verse1 = "There was an old woman who swallowed a fly,\n"
			+ "I don't know why she swallowed that fly,\n"
			+ "Perhaps she'll die.\n";

	String verse2 = "There was an old woman who swallowed a spider,\n"
			+ "That wriggled and iggled and jiggled inside her.\n"
			+ "She swallowed the spider to catch the fly,\n"
			+ "I don't know why she swallowed that fly,\n"
			+ "Perhaps she'll die.\n";
	
	String verse3 = "There was an old woman who swallowed a bird,\n"
			+ "How absurd to swallow a bird.\n"
			+ "She swallowed the bird to catch the spider,\n"
			+ "She swallowed the spider to catch the fly,\n"
			+ "I don't know why she swallowed that fly,\n"
			+ "Perhaps she'll die.";
	
	String verse4 = "There was an old woman who swallowed a cat,\n"
			+ "Imagine that to swallow a cat.\n"
			+ "She swallowed the cat to catch the bird,\n"
			+ "She swallowed the bird to catch the spider,\n"
			+ "She swallowed the spider to catch the fly,\n"
			+ "I don't know why she swallowed that fly,\n"
			+ "Perhaps she'll die.";

	String verse5 = "There was an old woman who swallowed a dog,\n"
			+ "What a hog to swallow a dog.\n"
			+ "She swallowed the dog to catch the cat,\n"
			+ "She swallowed the cat to catch the bird,\n"
			+ "She swallowed the bird to catch the spider,\n"
			+ "She swallowed the spider to catch the fly,\n"
			+ "I don't know why she swallowed that fly,\n"
			+ "Perhaps she'll die.";
	
	String verse7 = "There was an old woman who swallowed a horse,\n"
			+ "She died of course.";

	public void assertStringEquals(String string1, String string2) {
		for (int i = 0; i < string1.length(); i++) {
			if (string1.charAt(i) != string2.charAt(i)) {
				System.out.println(string1.substring(i-5, i+6));
			}
			assertEquals("character " + i + " was diff", string1.charAt(i), string2.charAt(i));
		}
	}
	
	@Test
	public void testVerse1() {
		String result = Animal.verse1();
		//System.out.println(result);
		//System.out.println(verse1);
//		for (int i = 0; i < result.length(); i++) {
//			assertEquals("character " + i + " was diff", result.charAt(i), verse1.charAt(i));
//		}
		assertStringEquals(result, verse1);
	}

	@Test
	public void testVerse2() {
		String result = Animal.verse2();
		assertStringEquals(result, verse2);
	}

}
