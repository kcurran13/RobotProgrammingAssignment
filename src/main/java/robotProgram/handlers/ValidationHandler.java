package robotProgram.handlers;

import robotProgram.entities.Grid;
import robotProgram.entities.Robot;
import robotProgram.steering.CardinalDirection;
import java.util.Arrays;

public class ValidationHandler {

    /**
     * Convert the userInput to an array of ints - regex so that only 0-9 is allowed and is not longer than 9 digits.
     * Insure that both of the grid dimensions are larger than 0, else return a null grid.
     * @param userInput String array of user input
     * @return new or null grid
     */
    public static Grid validateGrid(String[] userInput) {
        int[] gridSize;
        Grid grid = null;

        gridSize = Arrays.stream(userInput).filter(s -> s.matches("[\\d+]{1,9}")).mapToInt(Integer::parseInt).toArray();
        if (gridSize.length != 2) {
            System.out.println("Please try again using only numbers!");
        } else if (gridSize[0] == 0 || gridSize[1] == 0){
            System.out.println("The grid dimensions must be larger than 0.");
        } else grid = new Grid(gridSize[0], gridSize[1]);
        return grid;
    }

    /**
     * Convert the userInput to an array of ints - regex so that only 0-9 is allowed and is not longer than 9 digits.
     * If two ints are placed in the array, insure that the x and y are both within the grid and larger than 0.
     * @param userInput String array of user input
     * @param direction direction which has already been validated
     * @param grid grid created from user input
     * @return new or null robot
     */
    public static Robot validateRobotPosition(String[] userInput, CardinalDirection direction, Grid grid) {
        Robot robot = null;
        int[] robotPosition = Arrays.stream(userInput).filter(s -> s.matches("[\\d+]{1,9}")).mapToInt(Integer::parseInt).toArray();

        if (robotPosition.length == 2
                && robotPosition[0] < grid.getWidth() && robotPosition[0] >= 0
                && robotPosition[1] < grid.getHeight() && robotPosition[1] >= 0) {
            robot = new Robot(robotPosition[0], robotPosition[1], direction);
        } else {
            System.out.println("Invalid position. Make sure the robot is positioned within the grid.");
        }
        return robot;
    }

    /**
     * Checks the selected new position to insure that both x and y are within the grid.
     * @param robotPos int array of the x and y coordinates
     * @param grid created grid
     * @return true if position is valid, false if position is invalid
     */
    public static boolean validateNewPosition(int[] robotPos, Grid grid) {
        if (robotPos[0] < grid.getWidth() && robotPos[0] >= 0 && robotPos[1] < grid.getHeight() && robotPos[1] >= 0) {
            return true;
        } else {
            System.out.println("Invalid position. The robot can't leave the grid.");
            return false;
        }
    }
}
