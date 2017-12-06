package model;

public class StartNode extends Node {
	public StartNode(int x , int y) {
		super(x,y);
	}
	public int event(Player cha) {
		return 1;
	}
}
