package view;

import javafx.application.Platform;
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
		
		new Thread() {
			public void run() {
				Runnable update = new Runnable() {
					public void run() {
						life.setText("Life = " + player.life);
					}
				};
				while(player.life>=0) {
					Platform.runLater(update);
					try {
						Thread.sleep(30);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}.start();
	}
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	public String getLifeText(){
		return life.getText();
	}
}
