import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import robotProgram.entities.Grid;
import robotProgram.handlers.ValidationHandler;
import robotProgram.steering.CardinalDirection;

import static org.junit.jupiter.api.Assertions.*;


public class ValidationHandlerTest {
    private String[] userInputTest;
    private Grid grid;
    private CardinalDirection dir;
    private ValidationHandler vh;

    @BeforeEach
    void setUp() {
        vh = new ValidationHandler();
        grid = new Grid(5, 5);
        dir = CardinalDirection.NORTH;
    }

    @Test
    void validateGridTest() {
        userInputTest = new String[] {"3", "3"};
        assertNotNull(vh.validateGrid(userInputTest));

        userInputTest = new String[] {"3", "e"};
        assertNull(vh.validateGrid(userInputTest));

        userInputTest = new String[] {"eeeee", "4444"};
        assertNull(vh.validateGrid(userInputTest));

        userInputTest = new String[] {"something", "else"};
        assertNull(vh.validateGrid(userInputTest));
    }

    @Test
    void validateRobotPositionTest() {
        userInputTest = new String[] {"3", "3", "N"};
        assertNotNull(vh.validateRobotPosition(userInputTest, dir, grid));

        userInputTest = new String[] {"-3", "3", "N"};
        assertNull(vh.validateRobotPosition(userInputTest, dir, grid));

        userInputTest = new String[] {"6", "3000", "N"};
        assertNull(vh.validateRobotPosition(userInputTest, dir, grid));

        userInputTest = new String[] {"wrong", "input", "here"};
        assertNull(vh.validateRobotPosition(userInputTest, dir, grid));
    }

    @Test
    void validateNewPositionTest() {
        int[] robotPos = {1, 2};
        assertTrue(vh.validateNewPosition(robotPos, grid));

        robotPos = new int[] {6, 2};
        assertFalse(vh.validateNewPosition(robotPos, grid));

        robotPos = new int[] {-6, 2};
        assertFalse(vh.validateNewPosition(robotPos, grid));
    }
}
