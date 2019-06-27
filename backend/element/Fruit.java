package game.backend.element;

import game.backend.cell.FruitType;

import java.util.Objects;

public class Fruit extends Element {
    private FruitType type;

    public Fruit(FruitType type) {
        this.type = type;
    }

    public Fruit(){}


    public FruitType getType() {
        return type;
    }

    public void setType(FruitType type) {
        this.type = type;
    }

    @Override
    public boolean isFruit(){
        return true;
    }

    @Override
    public boolean isMovable() {
        return true;
    }

    @Override
    public String getFullKey(){
        return type.toString() + "-FRUIT";
    }

    @Override
    public String getKey() {
        return "FRUIT";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fruit fruit = (Fruit) o;
        return type == fruit.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type);
    }
}
