package snake.graphics;

import snake.core.Direction;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Shape extends Drawable {

    private List<Retangulo> rects;

    public Shape(Color color) {
        setColor(color);
        rects = new ArrayList<>();
    }

    public List<Retangulo> getRects() {
        return rects;
    }

    public Retangulo getFirstRect() {
        return rects.get(0);
    }

    public Retangulo getLastRect() {
        return rects.get(rects.size() - 1);
    }

    public void AddRect(Retangulo rect) {
        rect.setColor(getColor());
        rects.add(rect);
    }

    public Retangulo duplicateRect(Retangulo baserect, Direction direction) {
        int baseX = (int) baserect.getLocation().getX();
        int baseY = (int) baserect.getLocation().getY();
        int baseWidth = (int) baserect.GetDimesion().getWidth();
        int baseHeight = (int) baserect.GetDimesion().getHeight();

        Point location = new Point(
                baseX + direction.getSngX() * baseWidth,
                baseY + direction.getSngY() * baseHeight);
        Dimension dimension = new Dimension(baseWidth, baseWidth);
        Retangulo retangulo = new Retangulo(location, dimension);
        return retangulo;
    }

    @Override
    public void draw(Graphics g) {
        for (Retangulo r : rects) {
            r.draw(g);
        }
    }

    public boolean intersects(Retangulo rect) {
        for (Retangulo r : rects) {
            if (r.intersects(rect)){
                return true;
            }
        }

        return  false;
    }


}
