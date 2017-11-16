package view;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polyline;
import model.Node;
import model.NumberNode;

public class NodeView extends Polyline{
	private int row;
	private int col;
	private Node node;
	public NodeView(double x1 , double y1 , double x2 , double y2 , double x3 , double y3 , double x4 , double y4 , double x5 , double y5 , double x6 , double y6 , double x7 , double y7) {
		super(x1,y1,x2,y2,x3,y3,x4,y4,x5,y5,x6,y6,x7,y7);
		addEvent();
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getCol() {
		return col;
	}
	public void setCol(int col) {
		this.col = col;
	}
	public Node getNode() {
		return node;
	}
	public void setNode(Node node) {
		this.node = node;
	}
	private void addEvent() {
		if(node instanceof NumberNode) {
			this.setFill(Color.WHEAT);
			this.setStroke(Color.BLACK);
			this.setStrokeWidth(0.1*MapView.size);
			this.setOnMouseEntered(new EventHandler<Event>() {
				public void handle(Event e) {
					setFill(Color.SKYBLUE);
				}
			});

		}
			this.setOnMouseExited(new EventHandler<Event>() {
			public void handle(Event e) {
				setFill(Color.WHEAT);
			}
		});
		this.setOnMouseClicked(new EventHandler<Event>() {
			public void handle(Event e) {
				System.out.println("row = "+row+" , col = "+col);
			}
		});
	}
}
