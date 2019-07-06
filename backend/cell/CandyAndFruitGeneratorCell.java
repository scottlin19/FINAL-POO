package game.backend.cell;

import game.backend.Grid;
import game.backend.element.*;

public class CandyAndFruitGeneratorCell extends CandyGeneratorCell {

    public CandyAndFruitGeneratorCell(Grid grid) {
        super(grid);
    }

    @Override
    public Element getContent() {
        int candyLength = CandyColor.values().length;

        int fruitLength = FruitType.values().length;
        if (Math.random() <= 0.05){
            return new Fruit(FruitType.values()[(int) (Math.random() * fruitLength)]);

        }
        return new Candy(CandyColor.values()[(int) (Math.random() * candyLength)]);
    }
}
