package snake.scene;

import snake.graphics.Retangulo;
import snake.util.Constants;

public class BackGround extends Retangulo {

    public BackGround()
    {
        super(0, 0, Constants.WINDOWN_WIDTH, Constants.WINDOWN_HEIGHT);
        setColor(Constants.BACKGROUND_COLOR);
    }
}
