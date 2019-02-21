import org.junit.Assert;
import org.junit.Test;

/**
 * Lab 6
 *
 * Test class for ShapeSorter.
 * Implicitly tests that the comparators are implemented correctly.
 *
 * @author Stephen
 * @version 2019-02-18
 */
public class ShapeSorterTest
{
	/**
	 * Test that shapes are added correctly.
	 */
	@Test
	public void AddShapeTest()
	{
		ShapeSorter sorter = new ShapeSorter();

		Shape a = new Rectangle("test", 3, 3);
		Shape b = new EquilateralTriangle("test2", 4);
		Shape c = new Square("test3", 3);
		Shape d = new Circle("test4", 1.5);

		sorter.addShape(a);
		sorter.addShape(b);
		sorter.addShape(c);
		sorter.addShape(d);

		Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(0), a);
		Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(1), b);
		Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(2), c);
		Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(3), d);
	}

	/**
	 * Tests sorting via the default ordering.
	 */
	@Test
	public void SortShapesDefaultTest()
	{
		ShapeSorter sorter = new ShapeSorter();

		Shape a = new Rectangle("test", 3, 5);			// A =15
		Shape b = new EquilateralTriangle("test2", 4);	// A = 6.928
		Shape c = new Square("test3", 3);				// A = 9
		Shape d = new Circle("test4", 1.5);				// A = 7.069

		sorter.addShape(a);
		sorter.addShape(b);
		sorter.addShape(c);
		sorter.addShape(d);
		
		sorter.sortShapes();

		Assert.assertEquals("Shapes sorted incorrectly...", sorter.shapes.get(0), b); // Triangle is smallest
		Assert.assertEquals("Shapes sorted incorrectly...", sorter.shapes.get(1), d); // Circle is the  next smallest
		Assert.assertEquals("Shapes sorted incorrectly...", sorter.shapes.get(2), c); // Square is the 2nd largest
		Assert.assertEquals("Shapes sorted incorrectly...", sorter.shapes.get(3), a); // Rectangle is the largest
	}

	/**
	 * Tests sorting by area ordering.
	 */
	@Test
	public void SortShapesAreaTest()
	{
		ShapeSorter sorter = new ShapeSorter();

		Shape a = new Rectangle("test", 3, 5);			// A =15
		Shape b = new EquilateralTriangle("test2", 4);	// A = 6.928
		Shape c = new Square("test3", 3);				// A = 9
		Shape d = new Circle("test4", 1.5);				// A = 7.069

		sorter.addShape(a);
		sorter.addShape(b);
		sorter.addShape(c);
		sorter.addShape(d);

		sorter.sortShapes(new ShapeAreaComparator());

		Assert.assertEquals("Shapes sorted incorrectly...", sorter.shapes.get(0), b); // Triangle is smallest
		Assert.assertEquals("Shapes sorted incorrectly...", sorter.shapes.get(1), d); // Circle is the  next smallest
		Assert.assertEquals("Shapes sorted incorrectly...", sorter.shapes.get(2), c); // Square is the 2nd largest
		Assert.assertEquals("Shapes sorted incorrectly...", sorter.shapes.get(3), a); // Rectangle is the largest
		
	}

	/**
	 * Tests sorting by perimeter ordering.
	 */
	@Test
	public void SortShapesPerimeterTest()
	{
		ShapeSorter sorter = new ShapeSorter();
		
		Shape a = new Rectangle("test", 3, 5);			// P = 16
		Shape b = new EquilateralTriangle("test2", 4);	// P = 12.0
		Shape c = new Square("test3", 1);				// P = 4.0
		Shape d = new Circle("test4", 1.5);				// P = 9.425

		sorter.addShape(a);
		sorter.addShape(b);
		sorter.addShape(c);
		sorter.addShape(d);

		sorter.sortShapes(new ShapePerimeterComparator());

		Assert.assertEquals("Shapes sorted incorrectly...", sorter.shapes.get(0), c); // Square is smallest
		Assert.assertEquals("Shapes sorted incorrectly...", sorter.shapes.get(1), d); // Circle is the  next smallest
		Assert.assertEquals("Shapes sorted incorrectly...", sorter.shapes.get(2), b); // Triangle is the 2nd largest
		Assert.assertEquals("Shapes sorted incorrectly...", sorter.shapes.get(3), a); // Rectangle is the largest
		
		/*ShapeSorter sorter2 = new ShapeSorter();
		
		Shape a2 = new Rectangle("test", 4, 4);			// P = 16
		Shape b2 = new EquilateralTriangle("test2", 4);	// P = 12.0
		Shape c2 = new Square("test3", 4);				// P = 4.0
		Shape d2 = new Circle("test4", 1.5);				// P = 9.425

		sorter2.addShape(a2);
		sorter2.addShape(b2);
		sorter2.addShape(c2);
		sorter2.addShape(d2);
		System.out.println(sorter2.toString());
		sorter2.sortShapes(new ShapePerimeterComparator());

		Assert.assertEquals("Shapes sorted incorrectly...", sorter2.shapes.get(0), d2); // Square is smallest
		Assert.assertEquals("Shapes sorted incorrectly...", sorter2.shapes.get(1), b2); // Circle is the  next smallest
		Assert.assertEquals("Shapes sorted incorrectly...", sorter2.shapes.get(2), a2); // Triangle is the 2nd largest
		Assert.assertEquals("Shapes sorted incorrectly...", sorter2.shapes.get(3), c2); // Rectangle is the largest*/
	}

	/**
	 * Tests the toString.
	 */
	@Test
	public void ToStringTest()
	{
		ShapeSorter sorter = new ShapeSorter();
		
		Shape a = new Rectangle("test", 3, 5);			// P = 16
		Shape b = new EquilateralTriangle("test2", 4);	// P = 12.0
		Shape c = new Square("test3", 1);				// P = 4.0
		Shape d = new Circle("test4", 1.5);				// P = 9.425

		sorter.addShape(a);
		sorter.addShape(b);
		sorter.addShape(c);
		sorter.addShape(d);
		
		Assert.assertEquals("ToString is incorrect", sorter.toString(), a.toString() + b.toString() + c.toString() + d.toString());
	}
}
