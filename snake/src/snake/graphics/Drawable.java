package snake.graphics;

import snake.util.Constants;

import java.awt.*;

public abstract class Drawable {
    private Color color;

    public Drawable(Color color) {
        this.color = color;
    }

    public Drawable() {
        this.color = Color.black;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public abstract void draw(Graphics g);
}
