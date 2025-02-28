
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
import javafx.scene.text.Text;
import javafx.scene.text.FontWeight;

public class GameApp extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {

		Text text  = new Text("Select level:");
		text.setFont(Font.font("Courier New", FontWeight.BOLD,48));
		text.setFill(new Color(1,0.14,0.83,1));
		Label label = new Label(text.getText());
		label.setFont(text.getFont());

		Button buttonLv1 = new Button("Level 1");
		Button buttonLv2 = new Button(("Level 2"));
		Button buttonLv3 = new Button("Level 3");
		VBox vBox = new VBox(5);  // layout
		HBox hBox = new HBox(5);
		Scene menuScene = new Scene(vBox,585,585);
		hBox.getChildren().addAll(buttonLv1,buttonLv2,buttonLv3);
		hBox.setAlignment(Pos.CENTER);
		vBox.getChildren().addAll(label,hBox);
		vBox.setBackground(new Background(new BackgroundImage(new Image("images/fondo.png"),
				BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER,BackgroundSize.DEFAULT)));
		primaryStage.setScene(menuScene);
		vBox.setAlignment(Pos.CENTER);

		buttonLv1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				SetLevel(Level1.class,primaryStage);
			}
		});

		buttonLv2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				SetLevel(Level2.class,primaryStage);
			}
		});

		buttonLv3.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				SetLevel(Level4.class,primaryStage);
			}
		});

		primaryStage.setResizable(false);
		primaryStage.show();
	}

	public void SetLevel(Class<?> levelClass,Stage primaryStage){
		CandyGame game = new CandyGame(levelClass);
		CandyFrame frame = new CandyFrame(game);
		Scene scene = new Scene(frame);
		primaryStage.setScene(scene);
	}

}
