
public abstract class Athlete implements Flow {
	
	private String name;
	private String sportsVerb;
	
	/*
	 * @param name athlete's name, like "Michael Phelps"
	 * @param sportsVerb a present tense verb indicating the sports done, like "swims"
	 */
	public Athlete(String name, String sportsVerb) {
		this.name = name;
		this.sportsVerb = sportsVerb;
	}
	
	public String toString() {
		return this.name + " " + this.sportsVerb;
	}

	public void achieveFlowState() {
		System.out.println(toString());
	}
}
