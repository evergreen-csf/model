
public class Planet {

	String name;
	float orbitRadius; // in AU
	float pipCount;
	
	public Planet(String name, float orbitRadius) {
		this.name = name;
		this.orbitRadius = orbitRadius;
		this.pipCount = this.orbitRadius;
	}
	
	public String getPip() {
		if (this.pipCount > 0) {
			pipCount -= 0.01;
			return this.name.substring(0,1);
		}
		return " ";
	}
	
}
