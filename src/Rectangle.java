public class Rectangle extends Polygon{
	
	private double width;
	private double height;
	
	public Rectangle(String id, double height, double width) {
		super(id);
		this.width = width;
		this.height = height;
		
		sideLengths.add(width);
		sideLengths.add(width);
		sideLengths.add(height);
		sideLengths.add(height);
	}

	public double getArea() {
		double A = 0;
		A = height * width;
		return A;
	}
	
	public String getShapeType() {
		return "Rectangle";
	}
}
