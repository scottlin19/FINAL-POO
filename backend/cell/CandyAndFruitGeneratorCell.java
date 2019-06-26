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
        System.out.println("cl = "+candyLenght +  " | fl = "+fruitLenght);
        int i = (int)(Math.random() * (candyLenght + fruitLenght));
        System.out.println("i = " + i);
        if(i < candyLenght){
            return new Candy(CandyColor.values()[i]);
        }
        System.out.println("Fruit i: " + (i-candyLenght));
        return new Fruit(FruitType.values()[i-candyLenght]);

    }
}
