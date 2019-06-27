package game.backend.element;

import game.backend.cell.FruitType;

public class Hazelnut extends Fruit {

  public Hazelnut(FruitType type) {
        super(type);
    }

    @Override
    public String getKey() {
        return "HAZELNUT";
    }
}
