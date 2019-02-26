public class Rectangle extends Polygon
{

    private double width;
    private double height;

    /**
     * 
     * @param id Name of the Shape
     * @param height dimensions
     * @param width dimensions
     */
    public Rectangle(String id, double height, double width)
    {
        super(id);
        this.width = width;
        this.height = height;

        sideLengths.add(width);
        sideLengths.add(width);
        sideLengths.add(height);
        sideLengths.add(height);
    }

    /**
     * 
     * @return Double returns area of rectangle
     */
    public double getArea()
    {
        return (height * width);
    }
    
    /**
     * 
     * @return String returns type of shape
     */
    public String getShapeType()
    {
        return "Rectangle";
    }
}
