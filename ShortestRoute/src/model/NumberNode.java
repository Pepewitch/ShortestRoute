package model;

public class NumberNode extends Node{
	private int number;
	public NumberNode(int x,int y,int number) {
		super(x,y);
		this.number = number;
	}
	public void event(Character ch) {
		ch.decreaseLife(number);
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
}
