
public class Planet {

	String name;
	float orbitRadius; // in AU
	int pipCount;
	
	public Planet(String name, float orbitRadius) {
		this.name = name;
		this.orbitRadius = orbitRadius;
		this.pipCount = (int) this.orbitRadius;
	}
	
	public String getPip() {
		if (this.pipCount > 0) {
			pipCount -= 1;
			return this.name.substring(0,1);
		}
		return " ";
	}
	
}
