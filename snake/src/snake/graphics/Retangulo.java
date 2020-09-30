package snake.graphics;

import java.awt.*;

public class Retangulo extends Drawable {
    private Rectangle rect;

    public Retangulo(){
        super(Color.BLACK);
        rect  = new Rectangle(0, 0, 0, 0);
    }

    public Retangulo(Point location, Dimension dimension) {
        rect = new Rectangle(location, dimension);
    }

    public Retangulo(int x, int y, int width, int height) {
        rect = new Rectangle(x, y, width, height);
    }

    public Point getLocation() {
        return rect.getLocation();
    }

    public void setLocation(Point point) {
        rect.setLocation(point);
    }

    public Dimension GetDimesion(){
        return rect.getSize();
    }

    public void setDimesion(Dimension dimension){
        rect.setSize(dimension);
    }

    public boolean intersects(Retangulo other) {
        return rect.intersects(other.rect);
    }

    public void draw(Graphics g) {
        g.fillRect(
                (int) rect.getLocation().getX(),
                (int) rect.getLocation().getY(),
                (int) rect.getSize().getWidth(),
                (int) rect.getSize().getHeight());
    }
}