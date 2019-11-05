package robotProgram;

import robotProgram.entities.Grid;
import robotProgram.entities.Robot;
import robotProgram.handlers.InputHandler;
import robotProgram.handlers.ValidationHandler;
import robotProgram.steering.CardinalDirection;
import robotProgram.steering.Command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RobotController {

    private Robot robot;
    private Grid grid;
    private BufferedReader reader;
    private boolean gridExists = false;
    private boolean robotExists = false;
    private boolean hasRobotMoved = false;
    private boolean isUnsuccessfulMove = false;

    public RobotController() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
        setUp();
    }

    private void setUp() {
        while (!gridExists) {
            createGrid();
        }

        while (!robotExists) {
            createRobot();
        }

        if (gridExists && robotExists) {
            moveRobot();
            robot.whereAmI();
        }
    }

    private void createGrid() {
        System.out.println("\nSubmit room width and depth. Enter two numbers, separated by a space.");
        while (!gridExists) {
            String[] userInput = InputHandler.handleInput(this.reader);

            if (userInput.length == 2) {
                grid = ValidationHandler.validateGrid(userInput);
                if (grid != null) {
                    gridExists = true;
                }
            } else {
                System.out.println("Invalid input. Please enter two numbers, separated by a space.");
            }
        }
    }

    /**
     * Get user input for robot and validate it - validation of direction si done here and coordinates are done in validationHandler
     * Direction - take item 3 in the array and check that it is a valid direction, else prompt the user for new input.
     */
    private void createRobot() {
        Character direction;

        System.out.println("\nSubmit the robot's starting position, followed by the cardinal direction it should face - N, S, E, W. " +
                "\nEnter two numbers and then the direction, for example 1 2 N, separated by a space.");

        while (!robotExists) {
            String[] userInput = InputHandler.handleInput(this.reader);

            if (userInput.length == 3) {
                direction = Character.toUpperCase(userInput[2].charAt(0));

                if (direction != null && CardinalDirection.getCardinalDirectionFromChar(direction) != null) {
                    robot = ValidationHandler.validateRobotPosition(userInput, CardinalDirection.getCardinalDirectionFromChar(direction), this.grid);
                    if (robot != null) {
                        robotExists = true;
                    }
                } else {
                    System.out.println("Invalid input. Please select N, S, E, or W.");
                }
            } else {
                System.out.println("Invalid input. Please enter two numbers and a cardinal direction, separated by a space.");
            }
        }
    }

    /**
     *
     */
    private void moveRobot() {
        while (!hasRobotMoved) {
            System.out.println("\nTime to move the robot! Enter R to turn right, L to turn left, or F to move forward.");

            char[] movementCommands = new char[0];
            try {
                String input = this.reader.readLine().trim().toUpperCase();
                movementCommands = input.toCharArray();
            } catch (IOException e) {
                e.printStackTrace();
            }

            for (char input : movementCommands) {
                isUnsuccessfulMove = false;
                if (Command.getCommandFromChar(input) != null) {
                    switch (Command.getCommandFromChar(input)) {
                        case RIGHT:
                            robot.turn(Command.RIGHT);
                            break;
                        case LEFT:
                            robot.turn(Command.LEFT);
                            break;
                        case FORWARD:
                            int[] newPosition = robot.tryNewPosition();
                            if (ValidationHandler.validateNewPosition(newPosition, this.grid)) {
                                robot.moveToPosition(newPosition[0], newPosition[1]);
                            } else {
                                System.out.printf("Oh no! The robot had an accident facing %s at %d %d!\n", robot.getDirection(), robot.getX(), robot.getY());
                                isUnsuccessfulMove = true;
                            }
                            break;
                        default:
                            throw new IllegalArgumentException("Exception in robot move loop.");
                    }
                } else {
                    System.out.printf("\n%s is not a valid movement command!", input);
                    isUnsuccessfulMove = true;
                }
            }
            if (!isUnsuccessfulMove) {
                System.out.println(robot.whereAmI());
                 hasRobotMoved = true;
            }
        }
    }
}
