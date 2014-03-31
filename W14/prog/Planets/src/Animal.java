
public class Animal {

	Animal prey;
	String name;
	String catchphrase;
	
	Animal(String name, String catchphrase, Animal prey) {
		this.prey = prey;
		this.name = name;
		this.catchphrase = catchphrase;
	}
	
	String debut() {
		String result = "I know an old woman who swallowed a " + this.name + "\n";
		result += catchphrase + "\n";
		return result;
	}
	
	String singVerse() {
		if (this.prey == null) {
			return catchphrase;
		}

		String result = "She swallowed the " + this.name + " to catch the " + this.prey.name + "\n";
		result += prey.singVerse();
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
