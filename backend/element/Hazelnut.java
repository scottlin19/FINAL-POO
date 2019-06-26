package game.backend.element;

public class Hazelnut extends Fruit {
  public Hazelnut(FruitType type) {
        super(type);
    }

    @Override
    public String getKey() {
        return "HAZELNUT";
    }


}
