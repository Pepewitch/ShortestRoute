package model;

public class NumberNode extends Node{
	private int number;
	public NumberNode(int x,int y,int number) {
		super(x,y);
		this.number = number;
	}
	public int event(Player ch) {
		ch.decreaseLife(number);
		return 2;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
}
