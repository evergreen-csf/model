import java.util.List;


public class BabyName {

	static int DECADE_COUNT = 12;
	
	String name;
	String gender;
	List<Integer> rankByDecade;
	
	public BabyName(String name, String gender, List<Integer> rankByDecade) {
		this.name = name;
		this.gender = gender;
		this.rankByDecade = rankByDecade;
		assert(rankByDecade.size() == DECADE_COUNT);
	}
	
	
}
