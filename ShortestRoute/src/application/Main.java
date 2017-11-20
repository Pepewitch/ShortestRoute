package application;
	
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import model.Game;
import model.Map;
import model.Player;
import view.MapView;
import view.StatusView;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Player player = new Player(10,0,0);
			Game game = new Game(new Map(20,20) , player);
			MapView map = new MapView(game);
			game.setStart();
			map.update();
			BorderPane root = new BorderPane(map);
			VBox sh = new VBox(10);
			StatusView status = new StatusView(player);
			sh.getChildren().addAll(status,root);
			Scene scene = new Scene(sh,600,600);
			Rectangle clip = new Rectangle(sh.getWidth(),sh.getHeight()-status.getHeight());
			root.setClip(clip);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.widthProperty().addListener((obs, oldVal, newVal) -> {
			     // Do whatever you want
				clip.setWidth((double)newVal);
				root.setClip(clip);
			});
			primaryStage.heightProperty().addListener((obs, oldVal, newVal) -> {
			     // Do whatever you want
				clip.setHeight((double)newVal);
				root.setClip(clip);
			});
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
