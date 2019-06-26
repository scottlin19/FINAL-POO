package game.backend.cell;

import game.backend.Grid;
import game.backend.element.Candy;
import game.backend.element.CandyColor;
import game.backend.element.Element;
import game.backend.element.Fruit;

public class CandyAndFruitGeneratorCell extends CandyGeneratorCell {
    public CandyAndFruitGeneratorCell(Grid grid) {
        super(grid);
    }

    @Override
    public Element getContent() {
        int candyLenght = CandyColor.values().length;

        int fruitLenght = FruitType.values().length;
 
        int i = (int)(Math.random() * (candyLenght + fruitLenght));
     
        if(i < candyLenght){
            return new Candy(CandyColor.values()[i]);
        }
     
        return new Fruit(FruitType.values()[i-candyLenght]);

    }
}
