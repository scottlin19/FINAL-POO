package game.backend.level;

import game.backend.GameState;
import game.backend.cell.CandyAndFruitGeneratorCell;
import game.backend.cell.CandyGeneratorCell;
import game.backend.cell.Cell;
import game.backend.element.Wall;

public class Level4 extends Level {

    private static int MAX_MOVES = 30;
    private static int REQUIRED_FRUIT_SCORE = 5;

    private int fruitScore;

    private Cell wallCell;
    private Cell candyAndFruitGenCell;

    @Override
    protected GameState newState() {
        return new Level4.Level4State(MAX_MOVES,REQUIRED_FRUIT_SCORE);
    }

    @Override
    protected void fillCells() {

        wallCell = new Cell(this);
        wallCell.setContent(new Wall());
        candyAndFruitGenCell = new CandyAndFruitGeneratorCell(this);
        CandyGeneratorCell candyGenCell = new CandyGeneratorCell(this);

        //corners
        g()[0][0].setAround(candyAndFruitGenCell, g()[1][0], wallCell, g()[0][1]);
        g()[0][SIZE-1].setAround(candyAndFruitGenCell, g()[1][SIZE-1], g()[0][SIZE-2], wallCell);
        g()[SIZE-1][0].setAround(g()[SIZE-2][0], wallCell, wallCell, g()[SIZE-1][1]);
        g()[SIZE-1][SIZE-1].setAround(g()[SIZE-2][SIZE-1], wallCell, g()[SIZE-1][SIZE-2], wallCell);


        //upper line cells
        for (int j = 1; j < SIZE-1; j++) {
            g()[0][j].setAround(candyAndFruitGenCell,g()[1][j],g()[0][j-1],g()[0][j+1]);
        }

        //upper line cells
        for (int j = 1; j < SIZE-1; j++) {
            g()[0][j].setAround(candyAndFruitGenCell,g()[1][j],g()[0][j-1],g()[0][j+1]);
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
        //Hago que la ultima fila sea de candys para que no haya frutas
        for(int i = 0; i < SIZE-1;i++) {

            getCell(SIZE - 1, i).setContent(candyGenCell.getContent());
            if (tryRemove(getCell(SIZE - 1, i)) != null) {
                i = 0;
            }
        }

    }

    @Override
    public boolean tryMove(int i1, int j1, int i2, int j2) {
        boolean ret;
        if (ret = super.tryMove(i1, j1, i2, j2)) {
            state().addMove();
        }
        checkForFruits(SIZE-1);

        return ret;
    }

    private void checkForFruits(int row){
        for(int i = 0; i < SIZE ; i++) {
            Cell cell = getCell(row,i);
            if (cell.getContent().isFruit()) {
                cell.clearContent();
                addFruitScore();
                fallElements();
                System.out.println("Fruit en ["+row+"]["+i+"]");
                i = 0;


            }
        }
    }

    private void addFruitScore(){
        if (fruitScore < REQUIRED_FRUIT_SCORE) {
            fruitScore++;
        }
    }



     @Override
     public void clearContent(int i, int j) {
         if(get(i,j).canExplode()) {
             getCell(i,j).clearContent();
         }
     }


    private class Level4State extends GameState {
        private long requiredFruitScore;
        private long maxMoves;

        public Level4State(int maxMoves,int requiredFruitScore) {
            this.maxMoves = maxMoves;
            this.requiredFruitScore = requiredFruitScore;
        }

        public boolean gameOver() {
            return playerWon() || getMoves() >= maxMoves;
        }

        public boolean playerWon() {
            return getFruitScore()  >= requiredFruitScore;
        }

        @Override
        public String printScore() {
            return "FRUITS: "+ (requiredFruitScore - getFruitScore()) +" | MOVES: "+(maxMoves - getMoves()) + " | SCORE: "+ getScore();
        }


    }

    public int getFruitScore(){
        return fruitScore;
    }


}
