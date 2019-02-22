import org.junit.Assert;
import org.junit.Test;

/**
 * Lab 6
 *
 * Test class for shapes and their comparators.
 *
 * @author Stephen
 * @version 2019-02-18
 */
public class ShapeTest
{
	//==================================================================================================================
	// Basic Shape Testing:
	//==================================================================================================================
    /**
     * Tests for the square class.
     */
	@Test
	public void SquareTest()
	{
		Shape sqr = new Square("Square1", 3.0);
		Assert.assertEquals("Square area incorrect.", 9.0, sqr.getArea(), 0.0001);
		Assert.assertEquals("Square perimeter incorrect.", 12.0, sqr.getPerimeter(), 0.0001);
		Assert.assertEquals("Square type incorrect.", "Square", sqr.getShapeType());
		Assert.assertEquals("Shape ID incorrect.", "Square1", sqr.getId());
	}

	/**
     * Tests for the rectangle class.
     */
	@Test
	public void RectangleTest()
	{
		Shape rect = new Rectangle("rect1", 3.0, 4.0);
		Assert.assertEquals("Rectangle area incorrect.", 12.0, rect.getArea(), 0.0001);
		Assert.assertEquals("Rectangle perimeter incorrect.", 14.0, rect.getPerimeter(), 0.0001);
		Assert.assertEquals("Rectangle type incorrect.", "Rectangle", rect.getShapeType());
		Assert.assertEquals("Rectangle ID incorrect.", "rect1", rect.getId());
	}

	/**
     * Tests for the EquilateralTriangle class.
     */
	@Test
	public void TriangleTest()
	{
		Shape tri = new EquilateralTriangle("tri1", 3.0);
		Assert.assertEquals("EquilateralTriangle area incorrect.", (3.0 * 3.0 * (Math.sqrt(3) / 4)), tri.getArea(), 0.0001);
		Assert.assertEquals("EquilateralTriangle perimeter incorrect.", 9.0, tri.getPerimeter(), 0.0001);
		Assert.assertEquals("EquilateralTriangle type incorrect.", "EquilateralTriangle", tri.getShapeType());
		Assert.assertEquals("EquilateralTriangle ID incorrect.", "tri1", tri.getId());
	}

	/**
     * Tests for the trapezoid class. Also test that IDs are done correctly.
     */
	@Test
	public void TrapezoidTest()
	{
		Shape tri = new Trapezoid("trap1", 2.0, 3.0, 4.0, 2.0);
		Assert.assertEquals("Trapezoid area incorrect.", 5.9529, tri.getArea(), 0.0001);
		Assert.assertEquals("Trapezoid perimeter incorrect.", 11.0, tri.getPerimeter(), 0.0001);
		Assert.assertEquals("Trapezoid type incorrect.", "Trapezoid", tri.getShapeType());
		Assert.assertEquals("Trapezoid ID incorrect.", "trap1", tri.getId());
	}

	/**
     * Tests for the ellipse class. Also test that IDs are done correctly.
     */
	@Test
	public void EllipseTest()
	{
		Shape circ = new Ellipse("Ellipse1", 3.0, 3.0);
		Assert.assertEquals("Ellipse area incorrect.", Math.PI*3.0*3.0, circ.getArea(),0.0001);
		Assert.assertEquals("Ellipse perimeter incorrect.",
				2 * Math.PI * Math.sqrt((Math.pow(3, 2) + Math.pow(3, 2)) / 2),
				circ.getPerimeter(),0.0001);
		Assert.assertEquals("Ellipse type incorrect.", "Ellipse",circ.getShapeType());
		Assert.assertEquals("Shape ID incorrect.", "Ellipse1", circ.getId());

		Shape circs = new Ellipse("Ellipse2", 5.0, 3.0);
		Assert.assertEquals("Ellipse area incorrect.", Math.PI*3*5, circs.getArea(),0.0001);
		Assert.assertEquals("Ellipse perimeter incorrect.",
				2 * Math.PI * Math.sqrt((Math.pow(5.0, 2) + Math.pow(3.0, 2)) / 2),
				circs.getPerimeter(),0.0001);
		Assert.assertEquals("Ellipse type incorrect.", "Ellipse",circs.getShapeType());
		Assert.assertEquals("Shape ID incorrect.", "Ellipse2", circs.getId());
	}

	/**
     * Tests for the circle class. Also test that IDs are done correctly.
     */
	@Test
	public void CircleTest()
	{
		Shape circl = new Circle("circ1", 3.0);
		Assert.assertEquals("Circle area incorrect.", Math.PI * Math.pow(3.0, 2), circl.getArea(), 0.0001);
		Assert.assertEquals("Circle perimeter incorrect.", 2*Math.PI*3.0, circl.getPerimeter(), 0.0001);
		Assert.assertEquals("Circle type incorrect.", "Circle", circl.getShapeType());
		Assert.assertEquals("Circle ID incorrect.", "circ1", circl.getId());
	}

	/**
	 * Tests for Shape's toString().
	 */
	@Test
	public void ShapeToStringTest()
	{
		Shape circl = new Circle("circ", 2.0);
		double a = Math.PI * Math.pow(2.0, 2.0);
		double p = 2 * Math.PI * 2.0;
		Assert.assertEquals("ShapeToString is incorrect", String.format("Circle\t ID = circ\t area = %.3f\t perimeter = %.3f", a, p), circl.toString());
	}

	//==================================================================================================================
	// Comparisons:
	//==================================================================================================================
	/**
     * Tests for the Shape Area Comparator class.
     */
	@Test
	public void CompareAreaTest()
	{
	    // Test equals:
		Shape rect = new Rectangle("R1", 3.0,3.0);
		Shape sqr = new Square("S1", 3.0);
		ShapeAreaComparator sc = new ShapeAreaComparator();
		Assert.assertEquals("ShapeAreaComparator should find shapes equal.", 0, sc.compare(rect, sqr));
		Assert.assertTrue("ShapeAreaComparator should find shapes equal.", sc.equals(rect, sqr));

		// Test equal perimeter, different area:
        Shape rect2 = new Rectangle("R2", 1.0, 9.0);
        Shape sqr2 = new Square("S2", 5.0);
        Assert.assertEquals("ShapeAreaComparator gave incorrect ordering.", -1, sc.compare(rect2, sqr2));
        Assert.assertEquals("ShapeAreaComparator gave incorrect ordering.", 1, sc.compare(sqr2, rect2));
        Assert.assertFalse("ShapeAreaComparator incorrectly finds shapes equal.", sc.equals(rect2, sqr2));

        // Test unequal perimeter and area:
        Assert.assertEquals("ShapeAreaComparator gave incorrect ordering.", 1, sc.compare(sqr2, rect));
        Assert.assertEquals("ShapeAreaComparator gave incorrect ordering.", -1, sc.compare(rect, sqr2));
        Assert.assertFalse("ShapeAreaComparator incorrectly finds shapes equal.", sc.equals(sqr2, rect));
	}

	/**
     * Tests for the Shape Perimter Comparator class.
     */
	@Test
	public void ComparePerimeterTest()
	{
		//Test Equals:
		Shape rect = new Rectangle("R1", 5, 5);
		Shape sq = new Square("C1", 5);
		
		ShapePerimeterComparator sorter = new ShapePerimeterComparator();
		Assert.assertEquals("ShapePerimeterComparator should find shapes equal", 0, sorter.compare(rect, sq));
		Assert.assertTrue("ShapePerimeterComparator should find shapes equal", sorter.equals(rect, sq));
		
		Shape rect2 = new Rectangle("R2", 1.0, 9.0);
        Shape circ2 = new Circle("circ", 5.0);
        Assert.assertEquals("ShapePerimeterComparator gave incorrect ordering.", -1, sorter.compare(rect2, circ2));
        Assert.assertEquals("ShapePerimeterComparator gave incorrect ordering.", 1, sorter.compare(circ2, rect2));
        Assert.assertFalse("ShapePerimeterComparator incorrectly finds shapes equal.", sorter.equals(rect2, circ2));

        // Test unequal perimeter and area:
        Assert.assertEquals("ShapeAreaComparator gave incorrect ordering.", 1, sorter.compare(circ2, rect));
        Assert.assertEquals("ShapeAreaComparator gave incorrect ordering.", -1, sorter.compare(rect, circ2));
        Assert.assertFalse("ShapeAreaComparator incorrectly finds shapes equal.", sorter.equals(circ2, rect));

	}

	/**
	 * Tests the natural ordering of shapes (compareTo in shape)
	 */
	@Test
    public void NaturalCompareTest()
    {
		Shape rect = new Rectangle("R1", 2.0, 4.0);
		Shape sq = new Square("S1" , 2.0);

		Assert.assertEquals("ShapePerimeterComparator gave incorrect ordering.", -1, sq.compareTo(rect));
	    Assert.assertEquals("ShapePerimeterComparator gave incorrect ordering.", 1, rect.compareTo(sq));
	        
	    Shape rect2 = new Rectangle("R2", 5, 5);
	    Shape sq2 = new Square("S2", 5);
	    Assert.assertFalse("ShapePerimeterComparator incorrectly finds shapes equal.", sq2.equals(rect2));

		
    }
}
