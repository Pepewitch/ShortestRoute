package view;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
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
	double orgSceneX, orgSceneY; //Current Screen Location, assign in every MousePress
    double orgTranslateX, orgTranslateY; //Translate Location Variable
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
		
		
		//Store the location variable every MousePress, Change Location when Drag Mouse on MapView
		setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
	        public void handle(MouseEvent t) {
	            orgSceneX = t.getSceneX();
	            orgSceneY = t.getSceneY();
	            orgTranslateX = ((MapView)(t.getSource())).getTranslateX();
	            orgTranslateY = ((MapView)(t.getSource())).getTranslateY();
	        }
		});
		
		setOnMouseDragged(new EventHandler<MouseEvent>() {
			@Override
	        public void handle(MouseEvent t) {
				double offsetX = t.getSceneX() - orgSceneX;
	            double offsetY = t.getSceneY() - orgSceneY;
	            double newTranslateX = orgTranslateX + offsetX;
	            double newTranslateY = orgTranslateY + offsetY;
	             
	            ((MapView)(t.getSource())).setTranslateX(newTranslateX);
	            ((MapView)(t.getSource())).setTranslateY(newTranslateY);
	        }
			
		});
	}
	
}

