package view;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import model.Player;

public class StatusView extends HBox{
	private Player player;
	private Label life;
	public StatusView(Player player) {
		super();
		this.player = player;
		this.life = new Label("Life = " + player.life);
		this.getChildren().add(life);
	}
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	
}
