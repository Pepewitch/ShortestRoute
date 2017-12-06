package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import window.SceneManager;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
//			Player player = new Player(10,0,0);
//			Game game = new Game(new Map(20,20) , player);
//			MapView map = new MapView(game);
//			game.setStart();
//			map.update();
//			BorderPane root = new BorderPane(map);
//			VBox sh = new VBox(10);
//			StatusView status = new StatusView(player);
//			sh.getChildren().addAll(status,root);
//			Rectangle clip = new Rectangle(sh.getWidth(),sh.getHeight()-status.getHeight());
//			root.setClip(clip);
//			primaryStage.widthProperty().addListener((obs, oldVal, newVal) -> {
//			     // Do whatever you want
//				clip.setWidth((double)newVal);
//				root.setClip(clip);
//			});
//			primaryStage.heightProperty().addListener((obs, oldVal, newVal) -> {
//			     // Do whatever you want
//				clip.setHeight((double)newVal);
//				root.setClip(clip);
//			});
			SceneManager.initialize(primaryStage);
			SceneManager.gotoMainMenu();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
