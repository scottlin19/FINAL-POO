package game.frontend;

import game.backend.cell.Cell;
import javafx.scene.effect.Effect;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;


public class BoardPanel extends TilePane {

	private ImageView[][] cells;

	public BoardPanel(final int rows, final int columns, final int cellSize) {
		setPrefRows(rows);
		setPrefColumns(columns);
		setPrefTileHeight(cellSize);
		setPrefTileWidth(cellSize);
		this.cells = new ImageView[rows][columns];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				cells[i][j] = new ImageView();
				getChildren().add(cells[i][j]);
			}
		}
	}
	
	public void setImage(int row, int column, Image image, Cell cell) {
		Effect effect = cell.getEffect();
		if(effect != null) {
			cells[row][column].setEffect(effect);
		}

		cells[row][column].setImage(image);
	}

}
