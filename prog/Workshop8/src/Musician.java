
public class Musician implements Flow {
	
	private String name;
	private byte age;
	private String birthCity;
	private String musicVerb;
	
	public Musician(String name, byte age, String birthCity, String musicVerb) {
		this.name = name;
		this.age = age;
		this.birthCity = birthCity;
		this.musicVerb = musicVerb;
	}
	
	public void achieveFlowState() {
		System.out.println(this.name + " " + this.musicVerb);
	}
}
