
package game.frontend;

import game.backend.CandyGame;
import game.backend.level.Level1;
import game.backend.level.Level2;
import game.backend.level.Level4;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class GameApp extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {

		Label label = new Label("Select level:");
		label.setFont(new Font("Arial", 48));
		label.setTextFill(Color.BLACK);
		Button buttonLv1 = new Button("Level 1");
		Button buttonLv2 = new Button(("Level 2"));
		Button buttonLv3 = new Button("Level 3");
		VBox vBox = new VBox(5);  // layout
		HBox hBox = new HBox(5);
		Scene scene1 = new Scene(vBox,585,585);
		hBox.getChildren().addAll(buttonLv1,buttonLv2,buttonLv3);
		hBox.setAlignment(Pos.CENTER);
		vBox.getChildren().addAll(label,hBox);
		vBox.setBackground(new Background(new BackgroundImage(new Image("images/fondo.png"),
				BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER,BackgroundSize.DEFAULT)));
		primaryStage.setScene(scene1);
		vBox.setAlignment(Pos.CENTER);

		buttonLv1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				CandyGame game = new CandyGame(Level1.class);
				CandyFrame frame = new CandyFrame(game);
				Scene scene = new Scene(frame);
				primaryStage.setScene(scene);
			}
		});

		buttonLv2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {

				CandyGame game = new CandyGame(Level2.class);
				CandyFrame frame = new CandyFrame(game);
				Scene scene = new Scene(frame);
				primaryStage.setScene(scene);
			}
		});

		buttonLv3.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				CandyGame game = new CandyGame(Level4.class);
				CandyFrame frame = new CandyFrame(game);
				Scene scene = new Scene(frame);
				primaryStage.setScene(scene);
			}
		});

		primaryStage.setResizable(false);
		primaryStage.show();
	}

}
