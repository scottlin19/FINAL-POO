package game.frontend;

import game.backend.cell.Cell;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;


public class BoardPanel extends TilePane {

	private StackPane[][] cells;

	public BoardPanel(final int rows, final int columns, final int cellSize) {
		setPrefRows(rows);
		setPrefColumns(columns);
		setPrefTileHeight(cellSize);
		setPrefTileWidth(cellSize);
		this.cells = new StackPane[rows][columns];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				cells[i][j] = new StackPane();
				getChildren().add(cells[i][j]);
			}
		}
	}
	
	public void setImage(int row, int column, Image image, Cell cell) {
		cells[row][column].getChildren().add(cell.getImage(image));

	}

}
