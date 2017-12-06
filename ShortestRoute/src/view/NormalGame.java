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
		super(10);
		Game game = new Game(new Map(6,6) , new Player(10 , 0 , 0 ));
		game.getMap().setNode(4, 4, new StartNode(4,4));
		game.getMap().setNode(2, 2, new EndNode(2,2));
		game.setStart();
		MapView map = new MapView(game);
		map.update();
		StatusView status = new StatusView(game.getPlayer());
		BorderPane frame = new BorderPane(map);
		Rectangle clip = new Rectangle(primaryStage.getWidth(),primaryStage.getHeight()-status.getHeight());
		frame.setClip(clip);
		primaryStage.widthProperty().addListener((obs, oldVal, newVal) -> {
		     // Do whatever you want
			clip.setWidth((double)newVal);
			frame.setClip(clip);
		});
		primaryStage.heightProperty().addListener((obs, oldVal, newVal) -> {
		     // Do whatever you want
			clip.setHeight((double)newVal-status.getHeight());
			frame.setClip(clip);
		});
		this.getChildren().addAll(status , frame);
	}
}
