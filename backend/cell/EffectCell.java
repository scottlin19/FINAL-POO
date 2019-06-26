package game.backend.cell;

import game.backend.Grid;
import javafx.scene.effect.Effect;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class EffectCell extends Cell {

    protected Effect effect;

    public EffectCell(Grid grid,Effect effect) {
        super(grid);
        this.effect  = effect;
    }

    @Override
    public ImageView getImage(Image image){
        ImageView imageView = super.getImage(image);
        imageView.setEffect(effect);
        return imageView;
    }

    public Effect getEffect(){
        return effect;
    }

    public void setEffect(Effect effect){
        this.effect = effect;
    }
}
