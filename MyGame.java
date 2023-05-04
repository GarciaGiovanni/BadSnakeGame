
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import GameObjects.*;

public class MyGame extends Game  {
    public static final String TITLE = "Bad Snake Gamed";
    public static final int SCREEN_WIDTH = 1900;
    public static final int SCREEN_HEIGHT = 1050;

    public Snake snake;
    public ArrayList<Position> snakeArray;
    public Apple apple;
    public int currentX = 0;
    public int currentY = 0;

    public MyGame() {
        snake = new Snake();
        snakeArray = snake.getSnake();
    }
    
    public void update()
    {
        snake.checkForHit();
        if (apple == null)
        {
            apple = new Apple();
        }
        if (snakeArray.get(0).getX() == apple.getX() && snakeArray.get(0).getY() == apple.getY())
        {
            apple = null;
            snake.addLength();
        }
        snake.move(currentX, currentY);
    }
    
    public void draw(Graphics pen) {
        pen.setColor(Color.RED);   
        for (int i = 0; i < snakeArray.size(); i++)
        {
            pen.fillRect(snakeArray.get(i).getX() / 2 + 100, snakeArray.get(i).getY() / 2 + 100, 50, 50);
        }
        if (apple != null && !snakeArray.contains(new Position(apple.getX() / 2 + 100, apple.getY() / 2 + 100)) && apple.getX() / 2 + 100 < SCREEN_WIDTH && apple.getY() / 2 + 100 < SCREEN_HEIGHT){
            pen.setColor(Color.BLACK);
            pen.fillRect(apple.getX() / 2 + 100, apple.getY() / 2 + 100, 50, 50);
        }
        else{
            apple = null;
        }
    }

    public void draw(Graphics pen, int pos)
    {
        pen.fillRect(1, 1, 50, 50);
    }
        
    @Override
    public void keyTyped(KeyEvent ke) {}

    @Override
    public void keyPressed(KeyEvent ke) {
        if (ke.getKeyCode()==87) {currentY = -1; currentX = 0;}
        if (ke.getKeyCode()==68) {currentX = 1; currentY = 0;}
        if (ke.getKeyCode()==65) {currentX = -1; currentY = 0;}
        if (ke.getKeyCode()==83) {currentX = 0; currentY = 1;}

    }

    @Override
    public void keyReleased(KeyEvent ke) {}

    @Override
    public void mouseClicked(MouseEvent ke) {}

    @Override
    public void mousePressed(MouseEvent me) {}
    
    @Override
    public void mouseReleased(MouseEvent me) {}

    @Override
    public void mouseEntered(MouseEvent me) {}

    @Override
    public void mouseExited(MouseEvent me) {}
        
        
    //Launches the Game
    public static void main(String[] args) { new MyGame().start(TITLE, SCREEN_WIDTH,SCREEN_HEIGHT); }
}