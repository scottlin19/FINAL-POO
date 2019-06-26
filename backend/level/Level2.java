package game.backend.level;
import game.backend.GameState;
import game.backend.Grid;
import game.backend.cell.CandyGeneratorCell;
import game.backend.cell.Cell;
import game.backend.element.Wall;
import javafx.scene.effect.Effect;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class Level2 extends Level {

    private static int MAX_MOVES = 20;
    private static int MAX_GOLDEN_CELLS = SIZE * SIZE;

    private int goldenCells;
    private Effect effect;

    public Level2() {
        Light.Distant spotLight = new Light.Distant();
        spotLight.setColor(Color.YELLOW);
        spotLight.setElevation(100);
        effect = new Lighting(spotLight);


    }

    @Override
    protected GameState newState() {
        return new Level2.Level2State(MAX_MOVES);
    }

    private class Level2State extends GameState {
        private long maxMoves;

        public Level2State(int maxMoves) {
            this.maxMoves = maxMoves;
        }

        public boolean gameOver() {
            return playerWon() || getMoves() >= maxMoves;
        }


        public boolean playerWon() {
            return goldenCells == MAX_GOLDEN_CELLS;
        }


        @Override
        public String printScore() {
            return "Golden Cells Left: " + getGoldenCellsScore() + "   |  " + getScore();
        }

        private int getGoldenCellsScore() {
            return MAX_GOLDEN_CELLS - goldenCells;
        }
    }

    @Override
    public boolean tryMove(int i1, int j1, int i2, int j2) {
        boolean ret;
        if (ret = super.tryMove(i1, j1, i2, j2)) {
            state().addMove();
            if (i1 == i2) {
                setRowToGolden(i1);
            } else {
                setColToGolden(j1);
            }
        }
        return ret;
    }


    public void setColToGolden(int col) {
        Cell cell;
        for (int i = 0; i < SIZE; i++) {
            if ((cell = g()[i][col]).getEffect() == null) {
                System.out.println("le metio effect");
                cell.setEffect(effect);
                goldenCells++;
            }
        }
    }

    public void setRowToGolden(int row) {
        Cell cell;
        for (int i = 0; i < SIZE; i++) {
            if ((cell = g()[row][i]).getEffect() == null) {
                System.out.println("le metio effect");
                cell.setEffect(effect);
                goldenCells++;
            }
        }
    }
}

