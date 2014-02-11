
public class Animal {

	Animal prey;
	String name;
	String catchphrase;
	
	/* Constructor, to initialize all the data members
	 * @param name the name of the animal
	 * @param catchphrase the special second line of the song for the animal
	 * @param prey the animal object that this animal eats
	 */
	Animal(String name, String catchphrase, Animal prey) {
		// TODO: Fill in your code here
	}
	
	/* Constructs the first two lines of the song, when a new animal is first introduces.
	 * @return a String with newlines representing the first two lines of a song for an animal.
	 */
	String debut() {
		String result = "I know an old woman who swallowed a " + this.name + "\n";
		// TODO What should be added to result here?
		return result;
	}
	
	/* Constructs the whole verse for an animal, after the debut, including all other animals it has recursively swallowed. 
	 * @return a String with newlines representing the song verse for an animal *after* the debut
	 */
	String singVerse() {
		if (this.prey == null) {
			// TODO What should go here?
		}

		String result = "She swallowed the " + this.name + " to catch the " + this.prey.name + "\n";
		// TODO: What should go here? Hint: Use recursion!
		return result;
	}
	
	String getString() {
		String result = "";
		
		if (this.prey != null) {
			result += this.prey.getString();
		} else {
			//result += this.debut();
		}

		result += "\n";
		result += this.debut() + this.singVerse() + "\n";
		
		return result;
	}
	
	public static void main(String[] args) {
		Animal fly = new Animal("fly", "I don't know why she swallowed the fly, perhaps she'll die.", null);
		Animal spider = new Animal("spider", "Which iggled and jiggles and wriggled inside her.", fly);
		Animal bird = new Animal("bird", "How absurd to swallow a bird.", spider);
		Animal cat = new Animal("cat", "Imagine that to swallow a cat.", bird);
		Animal dog = new Animal("dog", "What a hog, to swallow a dog", cat);
		System.out.println(dog.getString());
	}

}
