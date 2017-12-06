package model;

public class Game {
	private Map map;
	private Player player;
	private int turn;
	public boolean end;
	public Game(Map map , Player cha) {
		end = false;
		this.map = map;
		this.player = cha;
		this.turn = 1;
	}
	
	public void setStart() {
		player.moveTo(map.getStartNode().getX_index(), map.getStartNode().getY_index());
		return;
	}
	
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
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	public void end() {
		end = true;
	}
}
