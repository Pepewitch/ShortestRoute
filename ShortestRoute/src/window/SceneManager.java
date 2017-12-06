package window;

import javafx.scene.Scene;
import javafx.stage.Stage;
import view.MainMenu;
import view.NormalGame;

public final class SceneManager {

	private static Stage primaryStage;
	private static MainMenu mainMenu = new MainMenu();
	private static NormalGame normalGame;
	private static Scene mainMenuScene = new Scene(mainMenu);
	public static final int SCENE_WIDTH = 800;
	public static final int SCENE_HEIGHT = 600;

	public static void initialize(Stage stage) {
		primaryStage = stage;
		primaryStage.setWidth(SCENE_WIDTH);
		primaryStage.setHeight(SCENE_HEIGHT);
		primaryStage.show();
	}

	public static void gotoMainMenu() {
		primaryStage.setScene(mainMenuScene);
		primaryStage.show();
		mainMenu.requestFocus();
		
	}
	
	public static void startNormalGame() {
		normalGame = new NormalGame(primaryStage);
		primaryStage.setScene(new Scene(normalGame));
		primaryStage.show();
	}
}
