import org.junit.jupiter.api.Test;
import robotProgram.steering.Command;

import static org.junit.jupiter.api.Assertions.assertSame;

public class CommandTest {

    @Test
    public void getCommandFromCharTest() {
        assertSame(Command.RIGHT, Command.getCommandFromChar('R'));
        assertSame(Command.LEFT, Command.getCommandFromChar('L'));
        assertSame(Command.FORWARD, Command.getCommandFromChar('F'));
    }
}
