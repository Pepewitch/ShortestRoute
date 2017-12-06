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
		Game game = new Game(new Map(6,6) , new Player(100 , 0 , 0 ));
		game.getMap().setNode(4, 4, new StartNode(4,4));
		game.getMap().setNode(2, 2, new EndNode(2,2));
		game.setStart();
		MapView map = new MapView(game);
		map.update();
		StatusView status = new StatusView(game.getPlayer());
		BorderPane frame = new BorderPane(map);
		
		HeaderBar topBar = new HeaderBar(primaryStage.getWidth(), primaryStage.getHeight(), status);
		this.getChildren().add(topBar);
		
//		Rectangle clip = new Rectangle(primaryStage.getWidth(),primaryStage.getHeight()-status.getHeight());
//		frame.setClip(topBar);
		
		primaryStage.widthProperty().addListener((obs, oldVal, newVal) -> {
		     // Do whatever you want
			this.getChildren().clear();
			HeaderBar newTopBar = new HeaderBar((double)newVal, primaryStage.getHeight(), status);
			this.getChildren().add(newTopBar);
			this.getChildren().addAll(status , frame);


		});
		primaryStage.heightProperty().addListener((obs, oldVal, newVal) -> {
		     // Do whatever you want
			this.getChildren().clear();
			HeaderBar newTopBar = new HeaderBar(primaryStage.getWidth(), (double)newVal, status);
			this.getChildren().add(newTopBar);
			this.getChildren().addAll(status , frame);
			
		});
		this.getChildren().addAll(status , frame);
	}
}
