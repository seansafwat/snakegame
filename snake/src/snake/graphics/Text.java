package snake.graphics;

import java.awt.*;

public class Text extends Drawable{
    private String text;
    private Point location;

    public Text(Color color, String text, Point location) {
        super(color);
        this.text = text;
        this.location = location;
    }

    @Override
    public void draw(Graphics g) {
        g.drawString(text, (int) location.getX(), (int)location.getY());
    }
}
