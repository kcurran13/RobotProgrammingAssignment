package robotProgram.entities;

public class Grid {
    private int width;
    private int height;

    public Grid(int width, int height) {
        this.width = width;
        this.height = height;
        System.out.println("created grid: dimensions " + width + " " + height);
    }

    public int getWidth() { return width; }

    public int getHeight() { return height; }
}
