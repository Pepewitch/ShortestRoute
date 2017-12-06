package view;

import javafx.application.Platform;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class HeaderBar extends Canvas {
	private StatusView status;
	private Image image;
	public HeaderBar(double width, double height, StatusView st) {
		super(width, height/12);
		this.status = st;
		GraphicsContext gc = this.getGraphicsContext2D();
		Font theFont = Font.font("Times New Roman", FontWeight.LIGHT, width*height/30000);
		gc.setFont(theFont);
		image = new Image("file:pic/"+"cube_trans.png");
		//////
		double scaleWidHead = this.getWidth()/5;
		double scaleHeiHead = this.getHeight();
		//-->Life Point
		gc.setFill(Color.LIGHTGOLDENRODYELLOW);
		gc.fillRect(0, 0, scaleWidHead, scaleHeiHead);
		gc.setFill(Color.RED);
		gc.fillText("❤ "+this.status.getLifeText(), 10, scaleHeiHead*4/5);
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
		
		new Thread() {
			public void run() {
				Runnable update = new Runnable() {
					public void run() {
						gc.setFill(Color.LIGHTGOLDENRODYELLOW);
						gc.fillRect(0, 0, scaleWidHead, scaleHeiHead);
						gc.setFill(Color.RED);
						gc.fillText("❤ "+status.getLifeText(), 10, scaleHeiHead*4/5);
					}
				};
				while(status.getPlayer().life>=0) {
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
}
