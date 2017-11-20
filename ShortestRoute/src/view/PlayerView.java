package view;

import javafx.scene.paint.Color;
import javafx.scene.shape.Polyline;
import model.Player;

public class PlayerView extends Polyline{
	private NodeView currentNode;
	public Player player;
	private double transX = 0;
	private double transY = 0;
	private double startX;
	private double startY;
	public PlayerView(NodeView node,Player player) {
		super(node.getX_middle(),node.getY_middle(),node.getX_middle()+(MapView.size*Math.cos(75*Math.PI/180)),node.getY_middle()-(MapView.size*Math.sin(75*Math.PI/180)),node.getX_middle()-(MapView.size*Math.cos(75*Math.PI/180)),node.getY_middle()-(MapView.size*Math.sin(75*Math.PI/180)),node.getX_middle(),node.getY_middle());
		this.setFill(Color.RED);
		this.setStroke(Color.BLACK);
		this.setStrokeWidth(0.1*MapView.size);
		this.currentNode = node;
		this.player = player;
		this.startX = node.getX_middle();
		this.startY = node.getY_middle();
	}
	public double getStartX() {
		return startX;
	}
	public void setStartX(double startX) {
		this.startX = startX;
	}
	public double getStartY() {
		return startY;
	}
	public void setStartY(double startY) {
		this.startY = startY;
	}
	public NodeView getCurrentNode() {
		return currentNode;
	}
	public void setCurrentNode(NodeView currentNode) {
		this.currentNode = currentNode;
	}
	public void update() {
		this.setTranslateX(currentNode.getX_middle()-startX);
		this.setTranslateY(currentNode.getY_middle()-startY);
	}
}
