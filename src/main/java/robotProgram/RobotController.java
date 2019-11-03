package robotProgram;

import robotProgram.entities.Grid;
import robotProgram.entities.Robot;
import robotProgram.handlers.InputHandler;
import robotProgram.steering.CardinalDirection;
import robotProgram.steering.Command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RobotController {

    private Robot robot;
    private Grid grid;
    private BufferedReader reader;
    private boolean gridExists = false;
    private boolean robotExists = false;
    private boolean robotMoving = true;
    private boolean unsuccessfulMove = false;

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
        int[] gridSize = null;

        System.out.println("\nSubmit room width and depth. Enter two numbers, separated by a space.");
        while (!gridExists) {
            String[] userInput = InputHandler.handleGridInput(this.reader);

            if (userInput.length == 2) {
                gridSize = Arrays.stream(userInput).filter(s -> s.matches("[\\d+]{1,9}")).mapToInt(Integer::parseInt).toArray();
                if (gridSize.length != userInput.length) {
                    System.out.println("Please try again using only numbers!");
                } else {
                    grid = new Grid(gridSize[0], gridSize[1]);
                    gridExists = true;
                }
            } else {
                System.out.println("Invalid input. Please enter two numbers, separated by a space.");
            }
        }
    }

    private void createRobot() {
        int[] robotPosition = null;
        Character direction = null;

        System.out.println("\nSubmit the robot's starting position, followed by the cardinal direction it should face - N, S, E, W. " +
                "\nEnter two numbers and then the direction, for example 1 2 N, separated by a space.");

        while (!robotExists) {
            String[] userInput = InputHandler.handleRobotInput(this.reader);

            if (userInput.length == 3) {
                direction = Character.toUpperCase(userInput[2].charAt(0));
                robotPosition = Arrays.stream(userInput).filter(s -> s.matches("[\\d+]{1,9}")).mapToInt(Integer::parseInt).toArray();

                //check for valid direction
                if (direction != null && CardinalDirection.getCardinalDirectionFromChar(direction) != null) {
                    validateRobotStartPos(robotPosition, CardinalDirection.getCardinalDirectionFromChar(direction));
                } else {
                    System.out.println("Invalid input. Please select N, S, E, or W.");
                }
            } else {
                System.out.println("Invalid input. Please enter two numbers and a cardinal direction, separated by a space.");
            }
        }
    }

    private void validateRobotStartPos(int[] robotPosition, CardinalDirection direction) {
        if (robotPosition[0] < grid.getWidth() && robotPosition[0] >= 0 && robotPosition[1] < grid.getHeight() && robotPosition[1] >= 0) {
            robot = new Robot(robotPosition[0], robotPosition[1], direction);
            robotExists = true;
        } else {
            System.out.println("Invalid position. Make sure the robot is positioned within the grid.");
        }
    }

    private boolean checkValidNewPosition(int[] robotPos) {
        //check if new position is valid
        return true;
    }

    private void moveRobot() {
        while (robotMoving) {
            System.out.println("\nTime to move the robot! Enter R to turn right, L to turn left, or F to move forward.");

            // Add each character of user input as a value in an array
            char[] movementCommands = new char[0];
            try {
                String input = this.reader.readLine().trim();
                movementCommands = input.toCharArray();
            } catch (IOException e) {
                e.printStackTrace();
            }

            for (char input : movementCommands) {
                unsuccessfulMove = false;
                //validation of input
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
                            if (checkValidNewPosition(newPosition)) {
                                robot.moveToPosition(newPosition[0], newPosition[1]);
                            } else {
                                System.out.println("The robot had an accident!");
                                robotMoving = false;
                            }
                            break;
                        default:
                            System.out.println("default, what to do?");
                    }
                } else {
                    System.out.printf("\n%s is not a valid movement command!", input);
                    unsuccessfulMove = true;
                }
            }
            if(!unsuccessfulMove) {
                System.out.println("in here now");
                System.out.println(robot.whereAmI());
                robotMoving = false;
            }
        }

    }
}
