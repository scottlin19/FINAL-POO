package game.backend.level;
import game.backend.GameState;
import game.backend.Grid;
import game.backend.cell.CandyGeneratorCell;
import game.backend.cell.Cell;
import game.backend.cell.Effects;
import game.backend.element.Wall;
import javafx.scene.effect.Effect;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.paint.Color;




public class Level2 extends Grid {

    private static int REQUIRED_SCORE = 5000;
    private static int MAX_MOVES = 20;
    private static int MAX_GOLDEN_CELLS = SIZE* SIZE;

    private int goldenCells;

    private Cell wallCell;
    private Cell candyGenCell;

    private Effect effect;

    public Level2(){
        Light.Distant spotLight = new Light.Distant();
        spotLight.setColor(Color.YELLOW);
        spotLight.setElevation(100);
        effect = new Lighting(spotLight);
    }


    @Override
    protected GameState newState() {
        return new Level2.Level2State(REQUIRED_SCORE, MAX_MOVES);
    }

    @Override
    protected void fillCells() {

        wallCell = new Cell(this);
        wallCell.setContent(new Wall());
        candyGenCell = new CandyGeneratorCell(this);

        //corners
        g()[0][0].setAround(candyGenCell, g()[1][0], wallCell, g()[0][1]);
        g()[0][SIZE-1].setAround(candyGenCell, g()[1][SIZE-1], g()[0][SIZE-2], wallCell);
        g()[SIZE-1][0].setAround(g()[SIZE-2][0], wallCell, wallCell, g()[SIZE-1][1]);
        g()[SIZE-1][SIZE-1].setAround(g()[SIZE-2][SIZE-1], wallCell, g()[SIZE-1][SIZE-2], wallCell);

        //upper line cells
        for (int j = 1; j < SIZE-1; j++) {
            g()[0][j].setAround(candyGenCell,g()[1][j],g()[0][j-1],g()[0][j+1]);
        }
        //bottom line cells
        for (int j = 1; j < SIZE-1; j++) {
            g()[SIZE-1][j].setAround(g()[SIZE-2][j], wallCell, g()[SIZE-1][j-1],g()[SIZE-1][j+1]);
        }
        //left line cells
        for (int i = 1; i < SIZE-1; i++) {
            g()[i][0].setAround(g()[i-1][0],g()[i+1][0], wallCell ,g()[i][1]);
        }
        //right line cells
        for (int i = 1; i < SIZE-1; i++) {
            g()[i][SIZE-1].setAround(g()[i-1][SIZE-1],g()[i+1][SIZE-1], g()[i][SIZE-2], wallCell);
        }
        //central cells
        for (int i = 1; i < SIZE-1; i++) {
            for (int j = 1; j < SIZE-1; j++) {
                g()[i][j].setAround(g()[i-1][j],g()[i+1][j],g()[i][j-1],g()[i][j+1]);
            }
        }
    }

    private class Level2State extends GameState {
        private long requiredScore;
        private long maxMoves;

        public Level2State(long requiredScore, int maxMoves) {
            this.requiredScore = requiredScore;
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
            return "Golden Cells Left: " + getGoldenCellsScore() + "   |  "+ getScore();
        }

        private int getGoldenCellsScore(){
            return MAX_GOLDEN_CELLS- goldenCells;
        }
    }

    @Override
    public boolean tryMove(int i1, int j1, int i2, int j2) {
        boolean ret;
        if (ret = super.tryMove(i1, j1, i2, j2)) {
            state().addMove();
            if(i1 == i2){
                setRowToGolden(i1);
            }else{
                setColToGolden(j1);
            }
        }
        return ret;
    }



    public void setColToGolden(int col){

        for(int i = 0; i < SIZE; i++){
                if(getCell(i,col).getEffect() == null){
                    getCell(i,col).setEffect(Effects.GOLDEN.getEffect());
                }
                goldenCells++;
        }
    }

    public void setRowToGolden(int row){

        for(int i = 0; i < SIZE; i++){

            if(getCell(row,i).getEffect() == null){
                getCell(row,i).setEffect(Effects.GOLDEN.getEffect());
            }
            goldenCells++;
        }
    }



}
