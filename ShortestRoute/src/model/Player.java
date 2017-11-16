package model;

public class Player {
	public int life;
	public int range;
	public int x_index;
	public int y_index;
	public Player(int life,int x ,int y) {
		this.life = life;
		this.range = 2;
		this.x_index = x;
		this.y_index = y;
	}
	public int decreaseLife(int amount) {
		life -= amount;
		return life;
	}
	public int increaseLife(int amount) {
		life += amount;
		return life;
	}
	public void moveTo(int x, int y) {
		x_index = x;
		y_index = y;
	}
}
