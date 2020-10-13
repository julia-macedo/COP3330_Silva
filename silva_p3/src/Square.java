public class Square extends Shape2D
{
    protected double side;

    public Square(double givenSide)
    {
        super();
        this.side = givenSide;
    }

    @Override
    public String getName()
    {
        return "square";
    }

    @Override
    public double getArea()
    {
        return this.side * this.side;
    }


}
