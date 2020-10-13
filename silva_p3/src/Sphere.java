public class Sphere extends Shape3D
{
    protected double radius;
    protected final double pi = 3.14159265;

    public Sphere(double givenRadius)
    {
        super();
        this.radius = givenRadius;
    }

    @Override
    public String getName()
    {
        return "sphere";
    }

    @Override
    public double getArea()
    {
        return Math.pow(this.radius, 2) * pi * 4;
    }

    @Override
    public double getVolume()
    {
        return Math.pow(this.radius, 3) * pi * (4.0 / 3.0);
    }
}
