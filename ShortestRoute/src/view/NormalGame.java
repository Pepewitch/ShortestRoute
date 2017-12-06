package view;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import model.EndNode;
import model.Game;
import model.Map;
import model.Node;
import model.NumberNode;
import model.Player;
import model.StartNode;

public class NormalGame extends VBox{
	public static JSONArray allgame;
	public static int gameIndex;
	public NormalGame(Stage primaryStage) {
		super(0);
		try {
			readJSON();
			Game game = arrayToGame(0);
			game.setStart();
			MapView map = new MapView(game);
			map.update();
			BorderPane frame = new BorderPane(map);
			HeaderBar topBar = new HeaderBar(primaryStage.getWidth(), primaryStage.getHeight(), game.getPlayer());
			Rectangle clip = new Rectangle(primaryStage.getWidth(),primaryStage.getHeight()-topBar.getHeight());
			frame.setClip(clip);
			
			primaryStage.widthProperty().addListener((obs, oldVal, newVal) -> {
			     // Do whatever you want
				topBar.setWidth((double)newVal);
				topBar.update();
				clip.setWidth((double)newVal);
				frame.setClip(clip);
			});
			primaryStage.heightProperty().addListener((obs, oldVal, newVal) -> {
			     // Do whatever you want
				topBar.setHeight((double)newVal/12);
				topBar.update();
				clip.setHeight((double)newVal - topBar.getHeight());
				frame.setClip(clip);
				
			});
			this.getChildren().addAll(topBar , frame);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void readJSON() throws URISyntaxException {
		JSONParser parser = new JSONParser();
		try {
			Object obj = parser.parse(new FileReader(new File(ClassLoader.getSystemResource("normalgame.json").toURI())));
			allgame = (JSONArray) obj;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Game arrayToGame(int index) {
		JSONObject gameJson = (JSONObject) allgame.get(index);
		Player player = new Player(((Long)gameJson.get("life")).intValue() , 0 , 0 );
		ArrayList<ArrayList<Node>> allnode = new ArrayList<>();
		JSONArray nodeJson = (JSONArray) gameJson.get("node");
		for(int i = 0 ; i < nodeJson.size() ; i++) {
			ArrayList<Node> row = new ArrayList<>();
			JSONArray rowJson = (JSONArray) nodeJson.get(i);
			for(int j = 0 ; j < rowJson.size() ; j++) {
				JSONObject eachJson = (JSONObject) rowJson.get(j);
				if(eachJson.get("type").equals("number")) {
					row.add(new NumberNode(i,j,((Long)eachJson.get("number")).intValue()));
				}else if(eachJson.get("type").equals("start")) {
					row.add(new StartNode(i,j));
				}else if(eachJson.get("type").equals("end")) {
					row.add(new EndNode(i,j));
				}
			}
			allnode.add(row);
		}
		return new Game(new Map(allnode),player);
	}
}
