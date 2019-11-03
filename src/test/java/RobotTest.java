import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import robotProgram.entities.Robot;
import static robotProgram.steering.CardinalDirection.*;

public class RobotTest {
    private Robot robot;

    @BeforeEach
    void setUp() {
        robot = new Robot(1, 1, NORTH);
    }

    @Test
    void turnTest() {
    }

}
