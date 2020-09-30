package snake.core;

import snake.graphics.Renderer;
import snake.scene.Snake;
import snake.util.Constants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameWindow extends JFrame implements KeyListener {
    private Renderer renderer;
    private Snake snake;
    private Image buffer;
    private Graphics gImage;
    private Rectangle drawingdArea;
    private long    lastKeyBordEventTime;

    public GameWindow(Snake snake){
        setSize(Constants.WINDOWN_WIDTH, Constants.WINDOWN_HEIGHT);
        setResizable(false);
        setTitle(Constants.WINDOWN_TITlE);
        setVisible(true);
        addKeyListener(this);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        this.snake = snake;

        buffer = createImage(Constants.WINDOWN_WIDTH, Constants.WINDOWN_HEIGHT);
        gImage = buffer.getGraphics();
        renderer = new Renderer(gImage);

        defineDrawingArea();
    }

    public Renderer getRenderer() {
        return renderer;
    }

    @Override
    public void paint(Graphics gScreen) {
        if (gImage == null || renderer == null){
            return;
        }
        renderer.render();
        gScreen.drawImage(buffer, 0, 0, null);
    }

    private void defineDrawingArea() {
        int upperY = (int) (Constants.WINDOWN_HEIGHT - getContentPane().getSize().getHeight());
        drawingdArea = new Rectangle(0, upperY, Constants.WINDOWN_WIDTH, Constants.WINDOWN_HEIGHT - upperY);
    }

    public Rectangle getDrawingArea() {
        return drawingdArea;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        long now = System.currentTimeMillis();

        if(now - lastKeyBordEventTime < 40){
            return;
        }

        if (e.getKeyCode() == KeyEvent.VK_UP){
            snake.up();
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN){
            snake.down();
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT){
            snake.right();
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT){
            snake.left();
        } else  if (e.getKeyCode() == KeyEvent.VK_ESCAPE){
            System.exit(0);
        }

        lastKeyBordEventTime = now;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
