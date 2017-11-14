package model;

public abstract class Node {
	private int x_index;
	private int y_index;
	private int state;
	//state 0 is in fog
	//state 1 is seen
	//state 2 is user location
	public Node(int x,int y) {
		this.x_index = x;
		this.y_index = y;
		this.state = 0;
	}
	public abstract void event(Character ch);
	public int getX_index() {
		return x_index;
	}
	public void setX_index(int x_index) {
		this.x_index = x_index;
	}
	public int getY_index() {
		return y_index;
	}
	public void setY_index(int y_index) {
		this.y_index = y_index;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	
}
