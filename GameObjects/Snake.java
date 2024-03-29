package GameObjects;
import java.util.ArrayList;

public class Snake
{

    protected ArrayList<Position> snake;
    protected int head;
    protected Position applePos;

    public Snake()
    {
        snake = new ArrayList<Position>();
        snake.add(new Position(100, 100));
        head = 0;
        addLength();
        addLength();
    }

    protected void setApplePos(Position pos)
    {
        applePos = pos;
    }

    public Position getApplePos()
    {
        return applePos;
    }

    public ArrayList<Position> getSnake()
    {
        return snake;
    }

    public void move(int xVel, int yVel)
    {
        snake.add(0, new Position(snake.get(head).getX() + xVel * 100, snake.get(head).getY() + yVel * 100));
        snake.remove(snake.get(snake.size()-1));
        try { Thread.sleep(50); }
        catch (InterruptedException e) {}
    }

    public boolean checkForHit()
    {
        for (int i = 1; i < snake.size(); i++)
        {
            if (snake.get(head).getX() + 100 >= snake.get(i).getX() && snake.get(head).getY() + 100 >= snake.get(i).getY() && i != head) 
            {
                return true;
            }
        }

        return false;
        
    }

    public void addLength()
    {
        snake.add(new Position(snake.get(snake.size()-1).getX(), snake.get(snake.size()-1).getY() + 50));
    }

    //public boolean equals(Position o)
    //{
        //return snake.get(head).getX() == o.getX() && snake.get(head).getY() == o.getY(); 
    //}


}
