/**Sierpinski.java
  * Ella Polo
  * pennkey: ellapolo
  * recitatioin: 209
  * 
  * 10/11/2012
  * 
  * Sierpinski.java
  * Prints out a pattern of triangles (Sierpinski pattern) using recursion. 
  * Command line argument N controls depth of recursion.
  * 
  * usage% java Sierpinski 7
  * prints Sierpinski triangle with 7 levels of recursion
  * 
  */


import java.awt.Color;

public class Sierpinski {
    
    public static void solidtriangle(double x, double y, double size)
    {
        
        double x0 = x;
        double y0 = y;
        double x1 = x + size/2;                // upper right x
        double y1 = y + (Math.sqrt(3)/2)*size; // upper right y
        double x2 = x - size/2;                // upper left  x
        double y2 = y + (Math.sqrt(3)/2)*size; // upper left  y
        
        double[] xvalues = {x0, x1, x2};
        double[] yvalues = {y0, y1, y2};
        
        // sets random values for R, G, and B
        int R = (int) (Math.random()*255);      
        int G = (int) (Math.random()*255);
        int B = (int) (Math.random()*255);
        
        // creates and new color with these random values and changes pen color
        Color random = new Color(R, G, B);
        StdDraw.setPenColor(random);
        
        StdDraw.filledPolygon(xvalues, yvalues);
    }
    
    public static void sierpinski(int n, double x, double y, double size)
    {
        if (n == 0) return;
        
        solidtriangle(x, y, size);
        
        double x0 = x + size/2;
        double y0 = y;
        double x1 = x - size/2;
        double y1 = y;
        double x2 = x;
        double y2 = y + (Math.sqrt(3)/2)*size;
        double newsize = size/2;
        
        sierpinski(n-1, x0, y0, newsize);
        sierpinski(n-1, x1, y1, newsize);
        sierpinski(n-1, x2, y2, newsize);
        
    }
         
    public static void main(String[] args)
    {
        int N = Integer.parseInt(args[0]);
        double x     = .5;
        double y     =  0;
        double size  = .5;
        sierpinski(N, x, y, size);
    }
}
