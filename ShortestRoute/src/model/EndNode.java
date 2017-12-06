package model;

public class EndNode extends Node {
	public EndNode(int x , int y) {
		super(x,y);
	}
	public int event(Player cha) {
		return 0;
	}
}