package model;

public class Game {
	private Map map;
	private Player player;
	private int turn;
	public Map getMap() {
		return map;
	}
	public void setMap(Map map) {
		this.map = map;
	}
	
	public int getTurn() {
		return turn;
	}
	public void setTurn(int turn) {
		this.turn = turn;
	}
	public Game(Map map , Player cha) {
		this.map = map;
		this.player = cha;
		this.turn = 1;
	}
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	
	
}
