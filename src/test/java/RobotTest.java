import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import robotProgram.entities.Robot;
import robotProgram.steering.Command;
import static robotProgram.steering.CardinalDirection.*;


public class RobotTest {
    private Robot robot;

    @BeforeEach
    void setUp() {
        robot = new Robot(1, 1, NORTH);
    }

    @Test
    void turnTest() {
        robot.turn(Command.RIGHT);
        assertSame(robot.getDirection(), EAST);

        robot.turn(Command.LEFT);
        robot.turn(Command.LEFT);
        robot.turn(Command.LEFT);
        assertSame(robot.getDirection(), SOUTH);
    }

    @Test
    void tryNewPositionTest() {
        int startingX = robot.getX();
        int startingY = robot.getY();
        int[] newPos = robot.tryNewPosition();

        assertEquals(startingY - 1, newPos[1]);

        //check that trying a new position shouldn't actually SET a new position
        robot.turn(Command.RIGHT);
        robot.tryNewPosition();
        robot.tryNewPosition();
        newPos = robot.tryNewPosition();
        assertEquals(startingX + 1, newPos[0]);
    }
}
