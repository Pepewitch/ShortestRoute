package input;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class State {
	private static int gameState;
	private static Queue<Integer> interact = new ConcurrentLinkedQueue<>();
	public static int MENU = 0;
	public static int IN_GAME = 1;
	public static int getGameState() {
		return gameState;
	}
	public static void setGameState(int gameState) {
		State.gameState = gameState;
	}
	public static void addInteract(int e) {
		interact.add(e);
	}
}
