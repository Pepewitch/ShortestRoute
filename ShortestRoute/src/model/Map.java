package model;

import java.util.ArrayList;

public class Map{
	public ArrayList<ArrayList<Node>> index;
	public Map(int row , int col) {
		index = new ArrayList<ArrayList<Node>>() ;
		for(int i = 0 ; i < row ; i++) {
			index.add(new ArrayList<Node>());
			for(int j = 0 ; j < col ; j++) {
				index.get(i).add(new NumberNode(i,j,10));
			}
		}
	}
	public Map(ArrayList<ArrayList<Node>> index) {
		this.index = index;
	}
	public void setNode(int x , int y , Node node) {
		index.get(x).set(y, node);
	}
	public Node getNode(int x , int y) {
		return index.get(x).get(y);
	}
	public Node getStartNode() {
		for(ArrayList<Node> i : index) {
			for(Node j : i) {
				if(j instanceof StartNode) return j;
			}
		}
		return null;
	}
}
