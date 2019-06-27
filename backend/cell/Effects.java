package game.backend.cell;

import javafx.scene.effect.Effect;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.paint.Color;

public enum Effects {

    GOLDEN{
        @Override
        public Effect getEffect() {
            Light.Distant spotLight = new Light.Distant();
            spotLight.setColor(Color.YELLOW);
            spotLight.setElevation(100);
            return new Lighting(spotLight);
        }
    };

    public abstract Effect getEffect();

}
