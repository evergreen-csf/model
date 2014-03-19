
//	Player.java
//	Konane Game System
//	MIT IEEE IAP Programming Competition 2001
//	Paul Pham, ppham@mit.edu
//
//	Kevin Douglas, doukev12@evergreen.edu
//

package doukev12;

import konaneCommon.*;
import java.util.Vector;

public class Player extends konaneCommon.Player {
	
	public static final int MAX_RECURSION_RANGE = 2; // inclusive -- max depth of look ahead game branches
	public static final int MIN_TIME_THRESHOLD = 20; // greater than -- remaining time percent (%)
	
	public static final int OPPO_LOST_GAME_WEIGHT = 18; // adder for opponent lost game / depth
	public static final int DIFF_IN_MOVES_WEIGHT = 2; // multiplier for difference in moves / depth
	
	public static int gameRound = 0;
	public static long startTime = 0;
	public static long timePercent = 0;
	
	public Move makeMove(BoardGrid board, long timer) {
		
		Vector moves = getMoves(board, side);
		int moveCount = moves.size();
		
		if (moveCount == 0) {
			return new Move(-1, -1, -1, -1, side, "**FORFEIT**");
		}
		
		// track passing of game in rounds and remaining time percent
		if (gameRound == 0) {
			startTime = timer;
		}
		timePercent = (long)(((double)timer / (double)startTime) * 100);
		gameRound ++;
		
		if (timePercent > MIN_TIME_THRESHOLD) {
			
			// opponent -- "Curse you Red Baron!"
			byte oppo = (side == Konane.WHITE) ? Konane.BLACK : Konane.WHITE;
			
			// select index of highest weighted game-tree branch
			int weight = 0;
			int select = 0;
			int index = 0;
			for (int i = 0; i < moveCount; i ++) {
				BoardGrid temp = board.copy();
				temp.makeMove((Move)moves.elementAt(i));
				weight = selectMove(temp, side, oppo, 1);
				if (weight > select) {
					select = weight;
					index = i;
				}
			}
			return (Move)moves.elementAt(index);
		} else {
//			System.out.println("OVER TIME >>> " + gameRound);
			return randomMove(board, side);
		}
	}
	
	// recursive game board move-tree, plays game forward to given depth
	// returns cumulative weight derived from secret heuristic formulae
	protected int selectMove(BoardGrid board, byte side, byte oppo, int depth) {
		
		int weight = 0;

		// reached maximum depth, inclusive
		if (depth > MAX_RECURSION_RANGE) {
			return weight;
		}
		
		// here we do NOT test all possible opponent moves
		// make random opponent move if available
		if (getMoves(board, oppo).size() > 0) {
			board.makeMove(randomMove(board, oppo));
		} else {
			if (depth == 1) {
				// opponent loses main game, return immediately
				return 1000;
			} else {
				// opponent loses this game branch, give this path a bonus
				weight += (int)(OPPO_LOST_GAME_WEIGHT / depth);
			}
			
		}
		
		Vector moves = getMoves(board, side);
		int moveCount = moves.size();
		if (moveCount == 0) {
			// we lose this game branch, avoid this path
			return 0;
		}
		
		// *** secret heuristic formulae ***
		weight += ((moveCount - getMoves(board, oppo).size()) * DIFF_IN_MOVES_WEIGHT) / depth;
		
		// push new games upstream for next branch
		// accumulate weights on return path
		for (int i = 0; i < moveCount; i ++) {
			BoardGrid temp = board.copy();
			temp.makeMove((Move)moves.elementAt(i));
			weight += selectMove(temp, side, oppo, depth + 1); 
		}
		return weight;
	}
	
	// assumes size > 0, does NOT test for FORFEIT condition
	protected Move randomMove(BoardGrid board, byte side) {
		Vector moves = getMoves(board, side);
		int index = (int)(moves.size() * Math.random());
		return (Move)moves.elementAt(index);
	}
	
	protected Vector getMoves(BoardGrid board, byte side) {
		Vector moves = new Vector();
		for (int row = 0; row < board.tokens.length; row ++) {
		    for (int col = 0; col < board.tokens[row].length; col ++) {
				if (board.tokens[row][col] == side) {
				    Vector temp = board.getMoves(row, col, side);
				    for (int i = 0; i < temp.size(); i ++) {
				    	moves.addElement(temp.elementAt(i));
				    }
				}
		    }
		}
		return moves;
	}
}


