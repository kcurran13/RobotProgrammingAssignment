package robotProgram.entities;

public class Robot {
    //robot object - faces direction that user inputs
    //he needs to move F and also rotate L and R
    //robot tells user where it ends up on the grid and what direction it faces (cardinal directions)

    private char direction;
    private int x;
    private int y;

    public Robot() {
        this.x = 0;
        this.y = 0;
        this.direction = 'N';
    }

    public Robot(int inputX, int inputY, char inputDir) {
        this.x = inputX;
        this.y = inputY;
        this.direction = inputDir;
    }

    //receive string of commands
    //break string into array of chars
    //match char to a command with enum
    //method to turn when L or R are input - match to direction with enum
    //if x or y becomes <0, return an error to user - bot escaped the grid!
    //where am I now? return position and direction to user when sequence complete
}
