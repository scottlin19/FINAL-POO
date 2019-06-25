package game.frontend;

import game.backend.CandyGame;
import game.backend.level.Level1;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class GameApp extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {

		Label label = new Label("select level: ");
		Button button = new Button("Level 1");
		Button button1 = new Button(("Level 2"));
		Button button2 = new Button("Level 3");
		HBox hBox1 = new HBox(5);  // layout
		Scene scene1 = new Scene(hBox1,800,600);
		hBox1.getChildren().addAll(label,button,button1,button2);
		primaryStage.setScene(scene1);

		CandyGame game = new CandyGame(Level1.class);
		CandyFrame frame = new CandyFrame(game);
		Scene scene = new Scene(frame);
		primaryStage.setResizable(false);

		button.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				primaryStage.setScene(scene);
			}
		});

		button1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				primaryStage.setScene(scene);
			}
		});

		button2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				primaryStage.setScene(scene);
			}
		});
		primaryStage.show();
	}

}
