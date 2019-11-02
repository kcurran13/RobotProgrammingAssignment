package entities;

public class Grid {
    //grid object created after user specified dimensions, for example 3 3 is a 3x3 grid
    //validate dimensions elsewhere
    private int width;
    private int height;

    public Grid(int[] dimensions) {
        this.width = dimensions[0];
        this.height = dimensions[1];
        System.out.println("the dimensions are " + width + " " + height);
    }
}
