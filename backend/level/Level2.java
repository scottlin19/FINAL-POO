package game.backend.level;
import game.backend.GameState;
import game.backend.cell.Effects;




public class Level2 extends Level {

    private static int MAX_MOVES = 20;
    private static int MAX_GOLDEN_CELLS = SIZE* SIZE;

    private int goldenCells;

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
            return "Golden Cells Left: " + getGoldenCellsScore() + " | Moves: " + (maxMoves - getMoves()) + " | Score: "+ getScore();
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
                    goldenCells++;
                }

        }
    }

    public void setRowToGolden(int row){

        for(int i = 0; i < SIZE; i++){

            if(getCell(row,i).getEffect() == null){
                getCell(row,i).setEffect(Effects.GOLDEN.getEffect());
                goldenCells++;
            }

        }
    }



}
