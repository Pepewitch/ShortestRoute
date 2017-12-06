package view;

import java.util.ArrayList;

import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import model.EndNode;
import model.Game;
import model.Map;
import model.Node;
import model.NumberNode;
import model.StartNode;

public class MapView extends BorderPane{
	public static int size = 30;
	private double orgSceneX, orgSceneY; //Current Screen Location, assign in every MousePress
    private double orgTranslateX, orgTranslateY; //Translate Location Variable
    private Game game;
    private Map map;
    public NodeView startNode;
    public ArrayList<ArrayList<NodeView>> nodeViewArray = new ArrayList<>();
    public PlayerView playerView; 
	public MapView(Game game) {
		super();
		this.game = game;
		this.map = game.getMap();
		this.setMinHeight((double)size*2 + 2*map.index.size()*size);
		this.setMinWidth((double)size*2 + 2*map.index.get(0).size()*size);
		this.setMaxHeight((double)size*2 + 2*map.index.size()*size);
		this.setMaxWidth((double)size*2 + 2*map.index.get(0).size()*size);
		for(int i = 0 ; i < map.index.size() ; i++) {
			nodeViewArray.add(new ArrayList<NodeView>());
			for(int j = 0 ; j < map.index.get(i).size() ; j++) {
				NodeView hex = new NodeView(
					(i%2 == 0?size:size+(Math.sqrt(3)/2)*size)+j*(Math.sqrt(3))*size , size + 3*i*size/2 ,
					(i%2 == 0?size:size+(Math.sqrt(3)/2)*size)+j*(Math.sqrt(3))*size + (Math.sqrt(3))*size/2 , size/2 + 3*i*size/2 ,
					(i%2 == 0?size:size+(Math.sqrt(3)/2)*size)+j*(Math.sqrt(3))*size + (Math.sqrt(3))*size , size + 3*i*size/2 ,
					(i%2 == 0?size:size+(Math.sqrt(3)/2)*size)+j*(Math.sqrt(3))*size + (Math.sqrt(3))*size , 2*size + 3*i*size/2 ,
					(i%2 == 0?size:size+(Math.sqrt(3)/2)*size)+j*(Math.sqrt(3))*size + (Math.sqrt(3))*size/2 , 5*size/2 + 3*i*size/2 ,
					(i%2 == 0?size:size+(Math.sqrt(3)/2)*size)+j*(Math.sqrt(3))*size , 2*size + 3*i*size/2 ,
					(i%2 == 0?size:size+(Math.sqrt(3)/2)*size)+j*(Math.sqrt(3))*size , size + 3*i*size/2 , 
					map.getNode(i, j) , 
					game ,
					this
				);
				nodeViewArray.get(i).add(hex);
				if(map.getNode(i, j) instanceof StartNode) {
					startNode = hex;
				}
				hex.setRow(i);
				hex.setCol(j);
				if(map.index.get(i).get(j) instanceof NumberNode) {
					Text txt = new Text(""+((NumberNode)map.index.get(i).get(j)).getNumber());
					txt.setX((i%2 == 0?size:size+(Math.sqrt(3)/2)*size)+j*(Math.sqrt(3))*size + (Math.sqrt(3))*size/2 - txt.getLayoutBounds().getWidth()/2);
					txt.setY( size/2 + 3*i*size/2 + size + txt.getLayoutBounds().getHeight()/4);
					txt.setFont(Font.font ("Verdana", 20));
					this.getChildren().add(txt);
				}
				this.getChildren().add(hex);
			}
		}
		playerView = new PlayerView(startNode,game.getPlayer());
		this.getChildren().add(playerView);
		System.out.println("player x = "+game.getPlayer().x_index+"  y = "+game.getPlayer().y_index);
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
				if(t.getButton() == MouseButton.PRIMARY) {
					double offsetX = t.getSceneX() - orgSceneX;
		            double offsetY = t.getSceneY() - orgSceneY;
		            double newTranslateX = orgTranslateX + offsetX;
		            double newTranslateY = orgTranslateY + offsetY;
		             
		            ((MapView)(t.getSource())).setTranslateX(newTranslateX);
		            ((MapView)(t.getSource())).setTranslateY(newTranslateY);
				}
	        }
		});
		update();
//		new Thread(this::update, "Game Loop Thread").start();
	}
	public void update() {
			try {
				for(ArrayList<Node> x : map.index) {
					for(Node i : x) {
						if(game.getPlayer().isInRange(i)) {
							i.setState(1);
						}
						else {
							i.setState(0);
						}
						if(i  instanceof StartNode) i.setState(1);
						if(i  instanceof EndNode) i.setState(1);
						nodeViewArray.get(i.getX_index()).get(i.getY_index()).addEvent();
					}
				}
				playerView.setCurrentNode(nodeViewArray.get(game.getPlayer().x_index).get(game.getPlayer().y_index));
				playerView.update();
//				Thread.sleep(20);
				
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
	}
}

