package view;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import model.EndNode;
import model.Game;
import model.Map;
import model.Player;
import model.StartNode;

public class NormalGame extends VBox{
	public NormalGame(Stage primaryStage) {
		super(0);
		Game game = new Game(new Map(6,6) , new Player(100 , 0 , 0 ));
		game.getMap().setNode(4, 4, new StartNode(4,4));
		game.getMap().setNode(2, 2, new EndNode(2,2));
		game.setStart();
		MapView map = new MapView(game);
		map.update();
		BorderPane frame = new BorderPane(map);
		HeaderBar topBar = new HeaderBar(primaryStage.getWidth(), primaryStage.getHeight(), game.getPlayer());
		Rectangle clip = new Rectangle(primaryStage.getWidth(),primaryStage.getHeight()-topBar.getHeight());
		frame.setClip(clip);
		
		primaryStage.widthProperty().addListener((obs, oldVal, newVal) -> {
		     // Do whatever you want
			topBar.setWidth((double)newVal);
			topBar.update();
			clip.setWidth((double)newVal);
			frame.setClip(clip);
		});
		primaryStage.heightProperty().addListener((obs, oldVal, newVal) -> {
		     // Do whatever you want
			topBar.setHeight((double)newVal/12);
			topBar.update();
			clip.setHeight((double)newVal - topBar.getHeight());
			frame.setClip(clip);
			
		});
		this.getChildren().addAll(topBar , frame);
	}
}
