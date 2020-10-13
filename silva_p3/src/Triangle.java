public class Triangle extends Shape2D
{
    protected double base;
    protected double height;

    public Triangle(double givenBase, double givenHeight)
    {
        super();
        this.base = givenBase;
        this.height = givenHeight;
    }

    @Override
    public String getName()
    {
        return "triangle";
    }

    @Override
    public double getArea()
    {
        return 0.5 * this.base * this.height;
    }


}
