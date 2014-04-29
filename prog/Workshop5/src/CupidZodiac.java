
public enum CupidZodiac {
	
	RAT, OX, TIGER, RABBIT, DRAGON, SNAKE, HORSE, GOAT, MONKEY, ROOSTER, DOG, PIG;
	
	public CupidZodiac findFirstMatch() {
		int index = this.ordinal();
		int length = this.values().length;
		int matchIndex = (index + 4) % length;
		CupidZodiac match = this.values()[matchIndex];
		return match;
	}
	
	public CupidZodiac findSecondMatch() {
		int index = this.ordinal();
		int length = this.values().length;
		int matchIndex = (index - 4) % length;
		CupidZodiac match = this.values()[matchIndex];
		return match;
	}

	public CupidZodiac findOpposite() {
		int index = this.ordinal();
		int length = this.values().length;
		int matchIndex = (index + 6) % length;
		CupidZodiac match = this.values()[matchIndex];
		return match;
	}

}
