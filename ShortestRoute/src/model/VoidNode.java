package model;

public class VoidNode extends Node{
	public VoidNode(int x , int y) {
		super(x,y);
	}
	public int event(Player player) {
		return 3;
	}
}
