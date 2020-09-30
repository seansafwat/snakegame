package snake.scene;

import snake.core.Direction;
import snake.graphics.Retangulo;
import snake.graphics.Shape;
import snake.util.Constants;
import snake.util.GameUtils;

import java.awt.*;

public class Snake extends Shape {

    private Direction direction;

    public Snake() {
        super(Constants.SNAKE_COLOR);
        direction = Direction.NONE;

        Point point = new Point(Constants.SNAKE_START_X,Constants.SNAKE_START_Y);
        Dimension dimension = new Dimension(Constants.SNAKE_PIECE_SIZE,Constants.SNAKE_PIECE_SIZE);
        Retangulo rect = new Retangulo(point, dimension);
        AddRect(rect);

        for (int i = 1;i < Constants.SNAKE_INITIAL_SIZE;i++){
            rect = duplicateRect(rect, Direction.LEFT);
            AddRect(rect);
        }

    }

    public void move(){
        if (direction != Direction.NONE){
            Retangulo head = getFirstRect();
            GameUtils.moveRects(getRects());

            Retangulo newHead = duplicateRect(head, direction);
            getRects().set(0, newHead);
        }
    }

    public void elongate() {

    }

    public synchronized void left(){
        if (direction.canChangeTo(Direction.LEFT)) {
            direction = Direction.LEFT;
        }
    }

    public synchronized void right(){
        if (direction.canChangeTo(Direction.RIGHT)) {
            direction = Direction.RIGHT;
        }
    }

    public synchronized void up(){
        if (direction.canChangeTo(Direction.UP)) {
            direction = Direction.UP;
        }
    }

    public synchronized void down(){
        if (direction.canChangeTo(Direction.DOWN)) {
            direction = Direction.DOWN;
        }
    }

    public boolean collidesWithItself(){
        Retangulo head = getFirstRect();

        for (int i = 1; i < getRects().size(); i++){
            if (head.intersects(getRects().get(i))) {
                return true;
            }
        }

        return false;
    }
}
