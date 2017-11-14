package view;

import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Polyline;

public class NodeView extends BorderPane{
	private double sz;
	public NodeView(float sz) {
		super();
		this.sz = sz;
		Polyline hex = new Polyline(
				0 , sz/2 ,
				Math.sqrt(3)*sz/2 , 0 ,
				Math.sqrt(3)*sz , sz/2 ,
				Math.sqrt(3)*sz , 3*sz/2 ,
				Math.sqrt(3)*sz/2 , 2*sz ,
				0 , 3*sz/2 ,
				0 , sz/2
		);
		this.getChildren().add(hex);
		this.setWidth(Math.sqrt(3)*sz);
		this.setHeight(2*sz);
	}
}
