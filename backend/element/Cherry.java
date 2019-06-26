package game.backend.element;

public class Cherry extends Fruit {
   
    public Cherry(FruitType type) {
        super(type);
    }

    @Override
    public String getKey() {
        return "CHERRY";
    }
}
