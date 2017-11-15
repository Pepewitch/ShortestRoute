package application;
	
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import model.Map;
import view.MapView;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			MapView map = new MapView(new Map(10,10));
			BorderPane root = new BorderPane(map);
			root.setMaxHeight(400);
			root.setMaxWidth(400);
			root.setClip(new Rectangle(400,400));
			Scene scene = new Scene(root,600,600);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
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
