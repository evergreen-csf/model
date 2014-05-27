
public abstract class Boarder extends Athlete {
	
	protected enum PositionEnum {
		FIRST, SECOND, THIRD
	}
	
	protected enum DirectionEnum {
		FORWARD, BACKWARD
	}
	
	private PositionEnum position;
	private DirectionEnum direction;
	
	public Boarder(String name, String sportsVerb) {
		super(name, sportsVerb);
		this.position = PositionEnum.FIRST;
		this.direction = DirectionEnum.FORWARD;
	}
}
