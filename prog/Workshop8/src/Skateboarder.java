
public class Skateboarder extends Boarder {
	
	public Skateboarder(String name) {
		super(name, "skateboards");
	}
	
	public static void main(String[] args) {
		Skateboarder sb = new Skateboarder("Tony Hawk");
		sb.achieveFlowState();
	}
}
