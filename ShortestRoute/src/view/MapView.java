package view;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polyline;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import model.Map;
import model.NumberNode;

public class MapView extends BorderPane{
	public static int size = 30;
	private double x_view;
	private double y_view;
	public MapView(Map map) {
		super();
		this.setMinHeight((double)size*2 + 2*map.index.size()*size);
		this.setMinWidth((double)size*2 + 2*map.index.get(0).size()*size);
		this.setMaxHeight((double)size*2 + 2*map.index.size()*size);
		this.setMaxWidth((double)size*2 + 2*map.index.get(0).size()*size);
		for(int i = 0 ; i < map.index.size() ; i++) {
			for(int j = 0 ; j < map.index.get(i).size() ; j++) {
				System.out.println("i = " + i + "  " + "j = " + j);
				Polyline hex = new Polyline(
					(i%2 == 0?size:size+(Math.sqrt(3)/2)*size)+j*(Math.sqrt(3))*size , size + 3*i*size/2 ,
					(i%2 == 0?size:size+(Math.sqrt(3)/2)*size)+j*(Math.sqrt(3))*size + (Math.sqrt(3))*size/2 , size/2 + 3*i*size/2 ,
					(i%2 == 0?size:size+(Math.sqrt(3)/2)*size)+j*(Math.sqrt(3))*size + (Math.sqrt(3))*size , size + 3*i*size/2 ,
					(i%2 == 0?size:size+(Math.sqrt(3)/2)*size)+j*(Math.sqrt(3))*size + (Math.sqrt(3))*size , 2*size + 3*i*size/2 ,
					(i%2 == 0?size:size+(Math.sqrt(3)/2)*size)+j*(Math.sqrt(3))*size + (Math.sqrt(3))*size/2 , 5*size/2 + 3*i*size/2 ,
					(i%2 == 0?size:size+(Math.sqrt(3)/2)*size)+j*(Math.sqrt(3))*size , 2*size + 3*i*size/2 ,
					(i%2 == 0?size:size+(Math.sqrt(3)/2)*size)+j*(Math.sqrt(3))*size , size + 3*i*size/2
				);
				hex.setFill(Color.WHEAT);
				hex.setStroke(Color.BLACK);
				hex.setStrokeWidth(0.1*size);
				hex.setOnMouseEntered(new EventHandler<Event>() {
					public void handle(Event e) {
						hex.setFill(Color.SKYBLUE);
					}
				});
				hex.setOnMouseExited(new EventHandler<Event>() {
					public void handle(Event e) {
						hex.setFill(Color.WHEAT);
					}
				});
				this.getChildren().add(hex);
				if(map.index.get(i).get(j) instanceof NumberNode) {
					Text txt = new Text(""+((NumberNode)map.index.get(i).get(j)).getNumber());
					txt.setX((i%2 == 0?size:size+(Math.sqrt(3)/2)*size)+j*(Math.sqrt(3))*size + (Math.sqrt(3))*size/2 - txt.getLayoutBounds().getWidth()/2);
					txt.setY( size/2 + 3*i*size/2 + size + txt.getLayoutBounds().getHeight()/4);
					txt.setFont(Font.font ("Verdana", 20));
					this.getChildren().add(txt);
				}
			}
		}
		
		
		setOnMouseDragged(event -> {
		    setManaged(false);
		    this.setTranslateX(event.getX() + this.getTranslateX());
		    this.setTranslateY(event.getY() + this.getTranslateY());
		    event.consume();
		});
	}
	
}

