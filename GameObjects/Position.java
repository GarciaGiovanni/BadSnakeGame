package GameObjects;

public class Position
{
    protected int _x;
    protected int _y;
    public Position(int x, int y)
    {
        _x = x;
        _y = y;
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
