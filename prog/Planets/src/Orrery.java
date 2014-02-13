
public class Orrery {

	public static void main(String[] args) {
		Planet p1 = new Planet("Mercury", 0.467f);
		Planet p2 = new Planet("Venus", 0.7f);
		Planet p3 = new Planet("Earth", 1.0f);
		Planet p4 = new Planet("Mars", 1.5f);
		Planet p5 = new Planet("Jupiter", 5.2f);
		Planet p6 = new Planet("Saturn", 9f);
		Planet p7 = new Planet("Uranus", 19.2f);
		Planet p8 = new Planet("Neptune", 29.77f);
		Planet p9 = new Planet("Pluto", 39f);
		Planet p10 = new Planet("Quaoar", 43f);
		
		boolean running = true;
		
		while (true) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
			}
			String pip1 = p1.getPip();
			String pip2 = p2.getPip();
			String pip3 = p3.getPip();
			String pip4 = p4.getPip();
			String pip5 = p5.getPip();
			String pip6 = p6.getPip();
			String pip7 = p7.getPip();
			String pip8 = p8.getPip();
			String pip9 = p9.getPip();
			String pip10 = p10.getPip();
			String pips = pip1 + pip2 + pip3 + pip4 + pip5 + pip6 + pip7 + pip8 + pip9 + pip10;
			System.out.println(pips);
			if (pips.equals("          ")) {
				break;
			}
		}
	}
	
}
