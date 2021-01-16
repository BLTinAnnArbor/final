package final_exam;

//********************************************************
//*******   Starter Code  ********************************
//********************************************************
abstract class Container {
	
 private double height;
 
 Container(double height)
 {
     this.height = height;
 }
 
 abstract double getTopArea();
 
 abstract double getTopPerimeter();
 
 double getVolume()
 {
     return height * getTopArea();
 }
 
 double getSurfaceArea()
 {
     return 2*getTopArea() + height * getTopPerimeter();
 }
}
//********************************

class CircularContainer extends Container
{
     // add appropriate data definitions
	
	double radius;
	
 CircularContainer(double height, double radius)
 {
     // Fill in details
	 super(height);
	 this.radius = radius;
 }
 // implement required abstract methods
 double getTopArea() {
	 return Math.PI * radius*radius;			 
 }
 
 double getTopPerimeter() {
	 return 2 * Math.PI * radius;
 }
}
//******************************************
class RectangularContainer extends Container
{
 // add appropriate data definitions
	double width;
	double length;
	
 RectangularContainer(double height, double width, double length)
 {
     // Fill in details
	 super(height);
	 this.width = width;
	 this.length = length;
 }
 // implement required abstract methods
 double getTopArea() {
	 return width * length;
 }
 
 double getTopPerimeter() {
	 return 2*(width + length);
 }
}
//**********************************************
class TriangularContainer extends Container
{
 // add appropriate data definitions
	double side_a;
	double side_b; 
	double side_c;
	
 TriangularContainer(double height, double side_a, double side_b, double side_c)
 {
     // Fill in details
	 super(height);
	 this.side_a = side_a;
	 this.side_b = side_b;
	 this.side_c = side_c;
	 
 }
 // implement required abstract methods
 double getTopArea() {
	 double s = (side_a + side_b + side_c)/2.0;
	 return Math.sqrt(s*(s-side_a)*(s-side_b)*(s-side_c)); 
 }
 
 double getTopPerimeter() {
	 return side_a + side_b + side_c; 
 }
}


class RegularPolygonContainer extends Container
{
 // add appropriate data definitions
	double side;
	int numSides;
	
 RegularPolygonContainer(double height, double side, int numSides)
 {
     // Fill in details
	 super(height);
	 this.side = side;
	 this.numSides = numSides;
 }
 // implement required abstract methods
 
 double getTopArea() {
	 return numSides * side * side / ( 4*Math.tan(Math.PI/numSides)); 
 }
 
 double getTopPerimeter() {
	 return numSides * side; 
 }
 
}
//**********************************************************
class ContainerCollection
{
 Container[] collection;
 int numContainers;
 int containerCount=0;
 
 ContainerCollection(int numContainers)
 {
     // Fill in details
	 this.numContainers = numContainers;
	 collection = new Container[numContainers];
 }
 
 void addContainer( Container c)
 {
     // Fill in details
     // Don't forget to check to see if there is enough room
     // in collection before adding.  Complain if you can't add Container.
	 
	 if(containerCount == 0) {
			collection[0] = c;
			containerCount ++;
		}else if(containerCount < numContainers){
			collection[containerCount] = c;
			containerCount ++;
		}else{
			System.out.println("numContainers is full. Can't add.");
		}
 }
 
 double getTotalVolume()
 {
     // Fill in details to return the total volume of 
     // all Containers in collection
	 
	 double total_volume = 0.0;
	 
	 for(int i=0; i<containerCount; i++)
		 total_volume += collection[i].getVolume();
	 
	 return total_volume;	 	 
 }
 
 double getTotalSurfaceArea()
 {
     // Fill in details to return the total surface area of 
     // all Containers in collection
	 
	 double total_surface_area = 0.0;
	 
	 for(int i=0; i<containerCount; i++)
		 total_surface_area += collection[i].getSurfaceArea();
	 
	 return total_surface_area;
 }
 
//DO NOT CHANGE ANYTHING IN MAIN!!!! ... this will be used to test your code
 public static void main(String[] args)
 {
   // Container of Various Prism Shapes
     ContainerCollection cc = new ContainerCollection(10);
     
     cc.addContainer(new CircularContainer(10., 2.0)); // height, radius
     cc.addContainer(new RectangularContainer(10., 2.0, 3.0)); // height, width, length
     cc.addContainer(new TriangularContainer(10., 4.0, 3.0, 5.0)); // height, side_a, side_b, side_c
     cc.addContainer(new RegularPolygonContainer(10., 1.0, 4)); // height, side, num_sides
     

     cc.addContainer(new CircularContainer(5., 2.0)); // height, radius
     cc.addContainer(new RectangularContainer(5., 2.0, 3.0)); // height, width, length
     cc.addContainer(new TriangularContainer(5., 4.0, 3.0, 5.0)); // height, side_a, side_b, side_c
     cc.addContainer(new RegularPolygonContainer(5., 1.0, 4)); // height, side, num_sides
     

     cc.addContainer(new CircularContainer(2., 2.0)); // height, radius
     cc.addContainer(new RectangularContainer(2., 2.0, 3.0)); // height, width, length
     cc.addContainer(new TriangularContainer(2., 4.0, 3.0, 5.0)); // height, side_a, side_b, side_c
     cc.addContainer(new RegularPolygonContainer(2., 1.0, 4)); // height, side, num_sides
     
     System.out.println("Total Volume of all containers = " + cc.getTotalVolume());
     System.out.println("Total Surface Area of all containers = " + cc.getTotalSurfaceArea());

   // Container of Rectangular Prisms
     ContainerCollection ccRect = new ContainerCollection(4);
     ccRect.addContainer(new RectangularContainer(5.123456, 2.0, 3.0)); // height, width, length
     ccRect.addContainer(new RectangularContainer(9., 2.0, 3.0)); // height, width, length
     ccRect.addContainer(new RectangularContainer(8., 2.0, 3.0)); // height, width, length
     System.out.println("Total Volume of all containers for ccRect = " + ccRect.getTotalVolume());
     System.out.println("Total Surface Area for ccRect = " + ccRect.getTotalSurfaceArea());

   // Container of Circular  Prisms
     ContainerCollection ccCirc = new ContainerCollection(4);
     ccCirc.addContainer(new CircularContainer(1., 1.0)); // height, width, length
     ccCirc.addContainer(new CircularContainer(10., 10.0)); // height, width, length
     System.out.println("Total Volume of all containers for ccCirc = " + ccCirc.getTotalVolume());
     System.out.println("Total Surface Area for ccCirc = " + ccCirc.getTotalSurfaceArea());

   // Container of Triangular Prisms
     ContainerCollection ccTri = new ContainerCollection(4);
     ccTri.addContainer(new TriangularContainer(1., 2.0, 2.0, 3.0)); // height, width, length
     ccTri.addContainer(new TriangularContainer(2., 1.0, 1.0, 1.0)); // height, width, length
     System.out.println("Total Volume of all containers for ccTri = " + ccTri.getTotalVolume());
     System.out.println("Total Surface Area for ccTri = " + ccTri.getTotalSurfaceArea());

   // Container of Regular Polygon Prisms        
     ContainerCollection ccPoly = new ContainerCollection(4);
     ccPoly.addContainer(new RegularPolygonContainer(2., 1.0, 4)); // height, width, length
     ccPoly.addContainer(new RegularPolygonContainer(2., 2.0, 3)); // height, width, length
     ccPoly.addContainer(new RegularPolygonContainer(2., 3.0, 5)); // height, width, length
     System.out.println("Total Volume of all containers for ccPoly = " + ccPoly.getTotalVolume());
     System.out.println("Total Surface Area for ccPoly = " + ccPoly.getTotalSurfaceArea());
 }
}