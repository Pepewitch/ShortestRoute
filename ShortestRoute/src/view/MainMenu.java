package view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import window.SceneManager;

public class MainMenu extends GridPane{
	public MainMenu() {
		super();
		Button btn = new Button("RUN");
		btn.setOnMouseClicked((event) -> {
			SceneManager.startNormalGame();
		});
		this.setAlignment(Pos.CENTER);
		this.add(btn, 0, 0);
	}
}
