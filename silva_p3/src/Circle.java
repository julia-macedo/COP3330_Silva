public class Circle extends Shape2D
{
    protected double radius;
    protected final double pi = 3.14159265;

    public Circle(double givenRadius)
    {
        super();
        this.radius = givenRadius;
    }

    @Override
    public String getName()
    {
        return "circle";
    }

    @Override
    public double getArea()
    {
        return this.radius * this.radius * pi;
    }
}
