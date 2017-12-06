package view;

import javafx.application.Platform;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import model.Game;
import model.Player;

public class HeaderBar extends Canvas {
	private Game game;
	private Player player;
	private Image image;
	private GraphicsContext gc;
	private double scaleWidHead;
	private double scaleHeiHead;
	public HeaderBar(double width, double height, Game game) {
		super(width, height/12);
		this.game = game;
		this.player = game.getPlayer();
		gc = this.getGraphicsContext2D();
		Font theFont = Font.font("Times New Roman", FontWeight.LIGHT, width*height/30000);
		gc.setFont(theFont);
		image = new Image("file:pic/"+"cube_trans.png");
		//////
		scaleWidHead = this.getWidth()/5;
		scaleHeiHead = this.getHeight();
		//-->Life Point
		gc.setFill(Color.LIGHTGOLDENRODYELLOW);
		gc.fillRect(0, 0, scaleWidHead, scaleHeiHead);
		gc.setFill(Color.RED);
		gc.fillText("❤  Life : "+this.player.life, 10, scaleHeiHead*4/5);
		//-->Point
		gc.setFill(Color.PALEGOLDENROD);
		gc.fillRect(scaleWidHead, 0, scaleWidHead*2, scaleHeiHead);
		gc.setFill(Color.BLACK);
		gc.fillText("★ Point", scaleWidHead+10, scaleHeiHead*4/5);
		//-->Empty
		gc.setFill(Color.GOLD);
		gc.fillRect(scaleWidHead*2, 0, scaleWidHead*3, scaleHeiHead);
		//-->Stage
		gc.setFill(Color.GOLDENROD);
		gc.fillRect(scaleWidHead*3, 0, scaleWidHead*4, scaleHeiHead);
		gc.setFill(Color.BLACK);
		gc.fillText("Stage", scaleWidHead*3+10, scaleHeiHead*4/5);
		//-->Menu
		gc.setFill(Color.DARKGOLDENROD);
		gc.fillRect(scaleWidHead*4, 0, scaleWidHead, scaleHeiHead);
		gc.setFill(Color.BLACK);
		gc.fillText("Menu", scaleWidHead*4+10, scaleHeiHead*4/5);
		
		gc.drawImage(image,0, 0, getWidth(), getHeight());
		
		Thread updateLife = new Thread() {
			public void run() {
				Runnable update = new Runnable() {
					public void run() {
						gc.setFill(Color.LIGHTGOLDENRODYELLOW);
						gc.fillRect(0, 0, scaleWidHead, scaleHeiHead);
						gc.setFill(Color.RED);
						gc.fillText("❤  Life : "+player.life, 10, scaleHeiHead*4/5);
					}
				};
				while(player.life>=0 && !game.end) {
					Platform.runLater(update);
					try {
						Thread.sleep(30);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		updateLife.setDaemon(true);
		updateLife.start();
	}
	
	public void update() {
		scaleWidHead = this.getWidth()/5;
		scaleHeiHead = this.getHeight();
		//-->Life Point
		gc.setFill(Color.LIGHTGOLDENRODYELLOW);
		gc.fillRect(0, 0, scaleWidHead, scaleHeiHead);
		gc.setFill(Color.RED);
		gc.fillText("❤  Life : "+this.player.life, 10, scaleHeiHead*4/5);
		//-->Point
		gc.setFill(Color.PALEGOLDENROD);
		gc.fillRect(scaleWidHead, 0, scaleWidHead*2, scaleHeiHead);
		gc.setFill(Color.BLACK);
		gc.fillText("★ Point", scaleWidHead+10, scaleHeiHead*4/5);
		//-->Empty
		gc.setFill(Color.GOLD);
		gc.fillRect(scaleWidHead*2, 0, scaleWidHead*3, scaleHeiHead);
		//-->Stage
		gc.setFill(Color.GOLDENROD);
		gc.fillRect(scaleWidHead*3, 0, scaleWidHead*4, scaleHeiHead);
		gc.setFill(Color.BLACK);
		gc.fillText("Stage", scaleWidHead*3+10, scaleHeiHead*4/5);
		//-->Menu
		gc.setFill(Color.DARKGOLDENROD);
		gc.fillRect(scaleWidHead*4, 0, scaleWidHead, scaleHeiHead);
		gc.setFill(Color.BLACK);
		gc.fillText("Menu", scaleWidHead*4+10, scaleHeiHead*4/5);
		
		gc.drawImage(image,0, 0, getWidth(), getHeight());
	}
}
