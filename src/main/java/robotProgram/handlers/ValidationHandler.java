package robotProgram.handlers;

import robotProgram.entities.Grid;
import robotProgram.entities.Robot;
import robotProgram.steering.CardinalDirection;
import java.util.Arrays;

public class ValidationHandler {

    public static Grid validateGrid(String[] userInput) {
        int[] gridSize;
        Grid grid = null;

        gridSize = Arrays.stream(userInput).filter(s -> s.matches("[\\d+]{1,9}")).mapToInt(Integer::parseInt).toArray();
        if (gridSize.length != 2) {
            System.out.println("Please try again using only numbers!");
        } else {
            grid = new Grid(gridSize[0], gridSize[1]);
        }
        return grid;
    }

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

    public static boolean validateNewPosition(int[] robotPos, Grid grid) {
        if (robotPos[0] < grid.getWidth() && robotPos[0] >= 0 && robotPos[1] < grid.getHeight() && robotPos[1] >= 0) {
            return true;
        } else {
            System.out.println("Invalid position. The robot can't leave the grid.");
            return false;
        }
    }
}
