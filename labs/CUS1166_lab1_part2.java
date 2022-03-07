import java.util.*;

public class CUS1166_lab1_part2 {
    public static void main(String[] args){
        // surface area of cuboid
        int length = 10;
        int width = 10;
        int height = 10;
        int cubearea = (2*length*width) + (2*length*height) + (2*height*width);
        System.out.println("Dimensions of cuboid:");
        System.out.println("Length: " + length);
        System.out.println("Width: " + width);
        System.out.println("Height: " + height);
        System.out.println("Surface Area of cuboid: " + cubearea);

        // surface area of sphere
        double pi = 3.14;
        double r = 10;
        double spherearea = (4*pi*Math.pow(r,2));
        System.out.println("");
        System.out.println("Radius of sphere: " + r);
        System.out.println("Surface Area of sphere: " + spherearea);
    }
}
