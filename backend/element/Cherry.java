package game.backend.element;

import game.backend.cell.FruitType;

public class Cherry extends Fruit {
   
    public Cherry(FruitType type) {
        super(type);
    }

    @Override
    public String getKey() {
        return "CHERRY";
    }
}
