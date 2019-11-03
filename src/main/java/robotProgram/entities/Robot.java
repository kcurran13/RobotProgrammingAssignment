package robotProgram.entities;

import org.w3c.dom.ls.LSOutput;
import robotProgram.steering.CardinalDirection;
import robotProgram.steering.Command;

import static robotProgram.steering.CardinalDirection.*;

public class Robot {
    //robot object - faces direction that user inputs
    //he needs to move F and also rotate L and R
    //robot tells user where it ends up on the grid and what direction it faces (cardinal directions)

    private CardinalDirection direction;
    private int x;
    private int y;

    public Robot() {
        this.x = 0;
        this.y = 0;
        this.direction = NORTH;
    }

    public Robot(int inputX, int inputY, CardinalDirection inputDir) {
        this.x = inputX;
        this.y = inputY;
        this.direction = inputDir;
        System.out.println("robot created!" + x + " " + y + " " + direction);
    }

    public void turn(Command turn) {
    }

    public int[] tryNewPosition() {
        int newX = getX();
        int newY = getY();

        switch (getDirection()) {
            case NORTH:
                newY--;
                break;
            case EAST:
                newX++;
                break;
            case SOUTH:
                newY++;
                break;
            case WEST:
                newX--;
                break;
            default:
                System.out.println("Problem in movetonewposition switch");
        }
        return new int[]{newX, newY};
    }

    public void moveToPosition(int x, int y) {
        setX(x);
        setY(y);
    }

    public String whereAmI() {
        String robotStats = String.format("The robot ended up at %d %d and is facing %s.", getX(), getY(), getDirection());
        return robotStats;
    }

    public CardinalDirection getDirection() {
        return direction;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setDirection(CardinalDirection direction) {
        this.direction = direction;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }


    //receive string of commands
    //break string into array of chars
    //match char to a command with enum
    //method to turn when L or R are input - match to direction with enum
    //if x or y becomes <0, return an error to user - bot escaped the grid!
    //where am I now? return position and direction to user when sequence complete
}
