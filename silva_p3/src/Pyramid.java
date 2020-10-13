public class Pyramid extends Shape3D
{
    protected double length;
    protected double width;
    protected double height;

    public Pyramid(double givenLength, double giveWidth , double givenHeight)
    {
        super();
        this.length = givenLength;
        this.width = giveWidth;
        this.height = givenHeight;
    }

    @Override
    public String getName()
    {
        return "pyramid";
    }

    @Override
    public double getArea()
    {
        // l * w + l * sqrt[((w/2)^2) + h^2] + w * sqrt[((l/2)^2) + h^2]
        double squareHeight =  Math.pow(this.height, 2);
        double squareHalfLength = Math.pow(this.length, 2) / 4;
        double squareHalfWidth = Math.pow(this.width, 2) / 4;

        return this.length * this.width + this.length * Math.sqrt(squareHalfWidth +squareHeight) +
                    this.width * Math.sqrt(squareHalfLength + squareHeight);
    }

    @Override
    public double getVolume()
    {
        return (this.height * this.length * this.width )/ 3;
    }
}
