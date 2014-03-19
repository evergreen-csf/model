/* Simulator.java
 * Konane Game System
 * MIT IEEE IAP Programming Competition 2001
 * Paul Pham, ppham@mit.edu
 */

package simulator;

import konaneCommon.*;

/** Simulator **/
final class Simulator {

	private byte      won;
	private BoardGrid boardGrid;

	private String    whiteName;
	private Player    whitePlayer;
	private long      whiteTime;

	private String    blackName;
	private Player    blackPlayer;
	private long      blackTime;

	private boolean   moveFinished;
	private long      timeBegan;
	private long      transitTime;
	private Move      playerMove;
	private long      originalTime; // arjunrn

	public Simulator(int boardWidth, int boardHeight, long playerTime, String whiteName, String blackName) {
		won = Konane.NONE;
		boardGrid = new BoardGrid(boardWidth, boardHeight);
		this.originalTime = playerTime; //arjunrn
		this.whiteTime = playerTime;
		this.blackTime = playerTime;
		this.whiteName = whiteName;
		this.blackName = blackName;
		whitePlayer = loadPlayer(whiteName, Konane.WHITE);
		blackPlayer = loadPlayer(blackName, Konane.BLACK);
	}

	private Player loadPlayer(String playerName, byte playerSide) {
		ClassLoader classLoader = new PlayerClassLoader();
		Player player = null;
		try {
			player = (Player)classLoader.loadClass(playerName + ".Player").newInstance();
		}
		catch (Exception e) {
			System.out.println(e.toString());
			System.exit(1);
		}
		player.setSide(playerSide);
		return player;
	}

	public synchronized Result playGame() {
		boolean terminate = false;
		int moveCount = 0;
		while (true) {
			moveFinished = false;
			PlayerThread whiteThread = new PlayerThread(whitePlayer, whiteTime, this);
			whiteThread.start();
			try {
				wait(blackTime);
			}
			catch(InterruptedException e) {
				System.err.println(e.toString());
			}

			if (!moveFinished) {
				terminate = true;
				System.out.println("WHITE exceeded time limit.");
			} else {
				whiteTime -= transitTime;
				if (whiteTime < 0) {
					terminate = true;
					System.out.println("WHITE exceeded time limit.");
				} else if (!boardGrid.makeMove(playerMove)) {
					System.out.println("WHITE returned an invalid move.");
					terminate = true;
				}
			}

			if (terminate) {
				whiteThread = null;
				System.gc();
				won = Konane.BLACK;
				break;
			}
			if (boardGrid.getAllMoves(Konane.BLACK).size() == 0) {
				won = Konane.WHITE;
				break;
			}
			moveFinished = false;
			PlayerThread blackThread = new PlayerThread(blackPlayer, blackTime, this);
			blackThread.start();
			try {
				wait(blackTime);
			} catch(InterruptedException e) {
				System.err.println(e.toString());
			}

			if (!moveFinished) {
				terminate = true;
				System.out.println("BLACK exceeded time limit.");
			} else {
				blackTime -= transitTime;
				if (blackTime < 0) {
					terminate = true;
					System.out.println("BLACK exceeded time limit.");
				} else if (!boardGrid.makeMove(playerMove)) {
					System.out.println("BLACK returned an invalid move.");
					terminate = true;
				}
			}
			if (terminate) {
				blackThread = null;
				System.gc();
				won = Konane.WHITE;
				break;
			}
			if (boardGrid.getAllMoves(Konane.WHITE).size() == 0) {
				won = Konane.BLACK;
				break;
			}
			moveCount++;
		}
		return new  Result(this.originalTime, this.boardGrid.getWidth(), 
				this.boardGrid.getHeight(), this.whiteName, this.whiteTime, 
				this.blackName, this.blackTime, this.won, moveCount) ;
	}

	public synchronized void wakeUp() {
		notifyAll();
	}

	public static void main(String[] args) {
		
		int gameCount = 1000; // number of games to play
		
		String playerOne = "doukev12";  // will go first
		String playerTwo = "reference"; // will go second
		String watchPlayer = playerOne; // print score for
		
		// set board width and height, and time limit
		int rows = 10;
		int cols = 10;
		long time = 10000;
		
		// randomize above board width and height,  
		// time limit, and which player goes first
		boolean random = false;
		
		// do not edit beyond this point
		// except for print out statements
		int count = 0;
		int first = 0;
		int second = 1;
		String[] players = {playerOne, playerTwo};
		for (int i = 1; i <= gameCount; i ++) {
			if (random) {
				rows = 10 + (int)(Math.random() * 6);
				cols = 10 + (int)(Math.random() * 6);
				if (rows % 2 == 1 && cols % 2 == 1) {
					cols -= 1;
				}
				time = 20000 + (int)(Math.random() * 70000) + (rows * cols * 1000);
				first = (int)(Math.random() * 1);
				second = (first == 0) ? 1 : 0;
			}
			
			Simulator simulator = new Simulator(rows, cols, time, players[first], players[second]);
			Result result = simulator.playGame();
			if (result.packageWon() == watchPlayer) {
				count ++;
			}
			
			// per-game output
//			System.out.println(result.toString());
			
//			float percent = ((float)count / (float)i) * 100;
//			System.out.println(watchPlayer + " won " + count + " out of " + i + 
//					" games (" + Math.round(percent) + "%)");
		}
		float percent = ((float)count / (float)gameCount) * 100;
		System.out.println("\nFINAL >>> " + watchPlayer + " won " + count + " out of " + gameCount + 
				" games (" + Math.round(percent) + "%)");
	}

	private final class PlayerThread extends Thread {
		private Player player;
		private long playerTime;
		private Simulator parent;

		public PlayerThread(Player player, long playerTime, Simulator parent) {
			this.player = player;
			this.playerTime = playerTime;
			this.parent = parent;
		}

		public synchronized void run() {
			try {
				timeBegan = System.currentTimeMillis();
				playerMove = player.makeMove(boardGrid.copy(), playerTime);
				transitTime = System.currentTimeMillis() - timeBegan;
			}
			catch (Exception e) {
				System.err.println(e.toString());
				playerMove = null;
			}
			moveFinished = true;
			parent.wakeUp();
		}
	}
}







