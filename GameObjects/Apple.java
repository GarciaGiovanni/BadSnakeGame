package GameObjects;
import java.util.Random;

public class Apple
{

    protected int _x;
    protected int _y;

    public Apple()
    {
        setApplePos();
    }

    public void setApplePos()
    {
        Random random = new Random();
        int randomX = random.nextInt(30);
        int randomY = random.nextInt(20);
        _x = randomX * 100;
        _y = randomY * 100;
    }
    public int getX()
    {
        return _x;
    }
    public int getY()
    {
        return _y;
    }
}
