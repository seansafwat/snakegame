package snake.core;

public enum Direction {
    NONE(0, 0),
    LEFT(-1, 0),
    RIGHT(1, 0),
    UP(0, -1),
    DOWN(0, 1);

    int sngX;
    int sngY;

    Direction(int x, int y){
        this.sngX = x;
        this.sngY = y;
    }

    public int getSngX() {
        return sngX;
    }

    public int getSngY() {
        return sngY;
    }

    public boolean canChangeTo(Direction other){
        return  !(sngX +other.sngX == 0 && sngY + other.sngY == 0);
    }
}
