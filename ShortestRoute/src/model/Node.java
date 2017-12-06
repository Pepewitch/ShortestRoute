package model;

public abstract class Node {
	private int x_index;
	private int y_index;
	private int state;
	// 0 is fog , 1 is not
	
	// event return 0 = end , 1 = start , 2 = number , 3 = void
	public Node(int x,int y) {
		this.x_index = x;
		this.y_index = y;
		this.state = 0;
	}
	public abstract int event(Player ch);
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
