public class Cube extends Shape3D
{
    protected double side;

    public Cube(double givenSide)
    {
        super();
        this.side = givenSide;
    }

    @Override
    public String getName()
    {
        return "cube";
    }

    @Override
    public double getArea()
    {
        return Math.pow(this.side, 2) * 6;
    }

    @Override
    public double getVolume()
    {
        return Math.pow(this.side, 3);
    }



}
