package model;

public class Player {
	public int life;
	public int range;
	public int x_index;
	public int y_index;
	public Player(int life,int x ,int y) {
		this.life = life;
		this.range = 3;
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
	public boolean isInRange(Node node) {
		int difX = Math.abs(node.getX_index()-x_index);
		int difY = Math.abs(node.getY_index()-y_index);
		if(difX > range || difY > range) return false;
		if(this.x_index %2 == 0) {
			if(node.getX_index()%2 == 0) { //even node even player
				return range >= difY + difX/2;
			}
			else { //odd node even player
				if(node.getY_index() >= this.y_index) {
					return range >= difY + (difX+1)/2;
				}
				else {
					return range >= difY + difX/2;
				}
			}
		}
		else if(this.x_index %2 == 1) {
			if(node.getX_index()%2 == 0) { //even node odd player
				if(node.getY_index() < this.y_index) {
					return range >= (difX+1)/2 + difY;
				}
				else {
					return range >= difX/2 + difY;
				}
			}
			else { //odd node odd player
				return range >= difX/2 + difY	;
			}
		}
		return false;
	}
	public boolean isInRange(Node node,int range) {
		int difX = Math.abs(node.getX_index()-x_index);
		int difY = Math.abs(node.getY_index()-y_index);
		if(difX > range || difY > range) return false;
		if(this.x_index %2 == 0) {
			if(node.getX_index()%2 == 0) { //even node even player
				return range >= difY + difX/2;
			}
			else { //odd node even player
				if(node.getY_index() >= this.y_index) {
					return range >= difY + (difX+1)/2;
				}
				else {
					return range >= difY + difX/2;
				}
			}
		}
		else if(this.x_index %2 == 1) {
			if(node.getX_index()%2 == 0) { //even node odd player
				if(node.getY_index() < this.y_index) {
					return range >= (difX+1)/2 + difY;
				}
				else {
					return range >= difX/2 + difY;
				}
			}
			else { //odd node odd player
				return range >= difX/2 + difY	;
			}
		}
		return false;
	}
}
