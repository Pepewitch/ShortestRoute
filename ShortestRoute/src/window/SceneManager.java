package window;

import java.io.File;

import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
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
	public static MediaPlayer mediaPlayer; 

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
		if(mediaPlayer!=null) {
			stopMusic();
			playMusic("res/bgm_error.wav");
		}
		playMusic("res/bgm_2_Midnight Stroll.mp3");
		
	}
	
	public static void startNormalGame() {
		normalGame = new NormalGame(primaryStage);
		primaryStage.setScene(new Scene(normalGame));
		primaryStage.show();
		stopMusic();
		playMusic("res/bgm_1_Golden.mp3");
	}
	
	public static void playMusic(String nameSong) {
		String bgm = nameSong;
	    Media sound = new Media(new File(bgm).toURI().toString());
	    mediaPlayer = new MediaPlayer(sound);
	    mediaPlayer.play();
	}
	public static void stopMusic() {
		mediaPlayer.stop();
	}
}
