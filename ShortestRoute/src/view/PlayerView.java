package view;

import javafx.scene.paint.Color;
import javafx.scene.shape.Polyline;
import model.Player;

public class PlayerView extends Polyline{
	private NodeView currentNode;
	private NodeView lastNode;
	public Player player;
	private double startX;
	private double startY;
	public boolean movable;
	public PlayerView(NodeView node,Player player) {
		super(node.getX_middle(),node.getY_middle(),node.getX_middle()+(MapView.size*Math.cos(75*Math.PI/180)),node.getY_middle()-(MapView.size*Math.sin(75*Math.PI/180)),node.getX_middle()-(MapView.size*Math.cos(75*Math.PI/180)),node.getY_middle()-(MapView.size*Math.sin(75*Math.PI/180)),node.getX_middle(),node.getY_middle());
		this.setFill(Color.GREENYELLOW);
		this.setStroke(Color.BLACK);
		this.setStrokeWidth(0.1*MapView.size);
		this.currentNode = node;
		this.lastNode = node;
		this.player = player;
		this.startX = node.getX_middle();
		this.startY = node.getY_middle();
		this.movable = true;
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
		new Thread() {
			public void run() {
				movable = false;
				int frame = 0;
				int period = 5;
				long time = System.currentTimeMillis();
				while(frame < 60) {
					if(System.currentTimeMillis() - time > period) {
						setTranslateX(lastNode.getX_middle()-startX + ((currentNode.getX_middle()-lastNode.getX_middle())*frame/60));
						setTranslateY(lastNode.getY_middle()-startY + ((currentNode.getY_middle()-lastNode.getY_middle())*frame/60));
						frame++;
						time = System.currentTimeMillis();
					}
					try {
						Thread.sleep(period);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				setTranslateX(currentNode.getX_middle()-startX);
				setTranslateY(currentNode.getY_middle()-startY);
				lastNode = currentNode;
				movable = true;
			}
		}.start();
		
	}
}
