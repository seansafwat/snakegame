package snake.graphics;

import org.w3c.dom.css.Rect;
import snake.scene.Snake;
import snake.util.Constants;
import snake.util.GameUtils;

import java.awt.*;

public class Food extends Retangulo {
    private int eatenTimes;

    public Food(Snake snake, Rectangle  drawingArea) {
        setRamdonLocation(snake, drawingArea);
        setDimesion(new Dimension(Constants.FOOD_SIZE, Constants.FOOD_SIZE));
        setColor(Constants.FOOD_COLOR);
    }

    private void setRamdonLocation(Snake snake, Rectangle drawingArea){
        int offset = 3;

        do{
            int x = GameUtils.random((int) drawingArea.getMinX() + offset, (int) drawingArea.getMaxX() - Constants.FOOD_SIZE - offset);
            int y = GameUtils.random((int) drawingArea.getMinY() + offset, (int) drawingArea.getMaxY() - Constants.FOOD_SIZE - offset);

            setLocation(new Point(x, y));
        }while (snake.intersects(this));
    }

    public void checkIfEaten(Snake snake, Rectangle  drawingArea) {
        if (snake.intersects(this)) {
            eatenTimes++;
            setRamdonLocation(snake, drawingArea);
            snake.elongate();
        }
    }

    public int getEatenTimes() {
        return eatenTimes;
    }

}
