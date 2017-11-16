package model;

public class Game {
	private Map map;
	private Player cha;
	private int turn;
	public Map getMap() {
		return map;
	}
	public void setMap(Map map) {
		this.map = map;
	}
	public Player getCha() {
		return cha;
	}
	public void setCha(Player cha) {
		this.cha = cha;
	}
	public int getTurn() {
		return turn;
	}
	public void setTurn(int turn) {
		this.turn = turn;
	}
	public Game(Map map , Player cha) {
		this.map = map;
		this.cha = cha;
		this.turn = 1;
	}
	
	
	
}
