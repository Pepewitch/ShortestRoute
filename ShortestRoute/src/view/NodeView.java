package view;

import javafx.event.EventHandler;
import javafx.scene.effect.BlendMode;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polyline;
import model.EndNode;
import model.Game;
import model.Node;
import model.NumberNode;
import model.StartNode;

public class NodeView extends Polyline{
	private int row;
	private int col;
	private Node node;
	private double x_middle;
	private double y_middle;
	private Game game;
	private MapView mapView;
	private EventHandler<MouseEvent> numberNode_Enter = new EventHandler<MouseEvent>() {
		public void handle(MouseEvent e) {
			setFill(Color.SKYBLUE);
		}
	};
	private EventHandler<MouseEvent> numberNode_Exit = new EventHandler<MouseEvent>() {
		public void handle(MouseEvent e) {
			setFill(Color.WHEAT);
		}
	};
	private EventHandler<MouseEvent> startNode_Exit = new EventHandler<MouseEvent>() {
		public void handle(MouseEvent e) {
			setFill(Color.AQUAMARINE);
		}
	};
	private EventHandler<MouseEvent> endNode_Exit = new EventHandler<MouseEvent>() {
		public void handle(MouseEvent e) {
			setFill(Color.RED);
		}
	};
	private EventHandler<MouseEvent> startNode_Enter = new EventHandler<MouseEvent>() {
		public void handle(MouseEvent e) {
			setFill(Color.SKYBLUE);
		}
	};
	public NodeView(double x1 , double y1 , double x2 , double y2 , double x3 , double y3 , double x4 , double y4 , double x5 , double y5 , double x6 , double y6 , double x7 , double y7 , Node node , Game game , MapView mapView) {
		super(x1,y1,x2,y2,x3,y3,x4,y4,x5,y5,x6,y6,x7,y7);
		this.x_middle = x2;
		this.y_middle = (y2+y5)/2;
		this.node = node;
		this.game = game;
		this.mapView = mapView;
		this.addEvent();
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public double getX_middle() {
		return x_middle;
	}
	public void setX_middle(double x_middle) {
		this.x_middle = x_middle;
	}
	public double getY_middle() {
		return y_middle;
	}
	public void setY_middle(double y_middle) {
		this.y_middle = y_middle;
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
	public void addEvent() {
		this.setStroke(Color.BLACK);
		this.setStrokeWidth(0.1*MapView.size);
		if(node.getState() == 1) {
			this.setBlendMode(BlendMode.MULTIPLY);
			if(node instanceof NumberNode) {
				this.setFill(Color.WHEAT);
				if(game.getPlayer().isInRange(this.node,1)) {
					this.setOnMouseEntered(numberNode_Enter);
					this.setOnMouseExited(numberNode_Exit);
				}
				else {
					this.setOnMouseEntered(null);
					this.setOnMouseExited(null);
				}
			}
			if(node instanceof StartNode || node instanceof EndNode) {
				if(node instanceof StartNode) this.setFill(Color.AQUAMARINE);
				if(node instanceof EndNode) this.setFill(Color.RED);
				if(game.getPlayer().isInRange(this.node,1)) {
					this.setOnMouseEntered(startNode_Enter);
					if(node instanceof StartNode)this.setOnMouseExited(startNode_Exit);
					if(node instanceof EndNode)this.setOnMouseExited(endNode_Exit);
				}
				else {
					this.setOnMouseEntered(null);
					this.setOnMouseExited(null);
				}
			}
		}
		if(node.getState() == 0) {
			this.setFill(Color.LIGHTGRAY);
			this.setOnMouseEntered(null);
			this.setOnMouseExited(null);
			this.setBlendMode(null);
		}
		
			
		this.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {
				if(e.getButton() == MouseButton.SECONDARY) {
					if(game.getPlayer().isInRange(node,1) && mapView.playerView.movable) {
						game.getPlayer().moveTo(row, col);
						mapView.playerView.setCurrentNode(mapView.nodeViewArray.get(row).get(col));
						mapView.update();
					}
				}
			}
		});
	}
}
