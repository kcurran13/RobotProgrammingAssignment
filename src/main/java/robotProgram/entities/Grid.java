package robotProgram.entities;

public class Grid {
    private int width;
    private int height;

    public Grid(int width, int height) {
        this.width = width;
        this.height = height;
        System.out.printf("Created a grid with dimensions %d x %d.\n", this.width, this.height);
    }

    public int getWidth() { return width; }

    public int getHeight() { return height; }
}
