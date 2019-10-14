package sk.badand.asg.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ObjectMap;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.temporal.TemporalField;
import java.util.Random;
import java.util.UUID;

public class Utils {

    private static Random rand = new Random(LocalDateTime.now().getSecond());

    public static ObjectMap<Textures, Texture> textureMap = new ObjectMap<>();

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public static void initTextures(){
        for (Textures t : Textures.values()) {
            textureMap.put(t, t.getTexture());
        }
    }

    public static void dispose() {
        for (Texture texture : textureMap.values()) {
            texture.dispose();
        }
    }

    public enum Textures {
        ANT("ant.png"),
        WASP("wasp.png"),
        COCKROACH("cockroach.png"),
        CATERPILLAR("caterpillar.png"),
        GROUND("ground.png");

        private String fileName = null;

        Textures(String fileName) {
            this.fileName = fileName;
        }

        public Texture getTexture() {
            if (fileName != null) {
                return new Texture(Gdx.files.internal(fileName));
            } else {
                throw new IllegalArgumentException("No filename for this texture.");
            }
        }
    }
}
