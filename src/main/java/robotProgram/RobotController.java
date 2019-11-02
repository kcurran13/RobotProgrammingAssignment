package robotProgram;

import robotProgram.entities.Grid;
import robotProgram.entities.Robot;

public class RobotController {

    private Robot robot;
    private Grid grid;
    private boolean gridExists = false;
    private boolean robotExists = false;

    public RobotController() {

    }

    private void getUserInput() {
        /*get input
        while(!gridExists) {
            createGrid(inputSize);
        }
        //get input
        while(!robotExists) {
            createRobot(inputRobotStuff);
        }*/

        //get input
        moveRobot();
    }

    private boolean createGrid(int[] gridSize) {
        //check if valid
        new Grid(gridSize);
        gridExists = true;
        return gridExists;
    }

    private boolean createRobot(int x, int y, char dir) {
        //check if valid
        new Robot(x, y, dir);
        robotExists = true;
        return robotExists;
    }

    private void moveRobot() {
        if(gridExists && robotExists) {
            //move it move it
        }
    }

}
