import org.junit.jupiter.api.Test;
import robotProgram.steering.CardinalDirection;

import static org.junit.jupiter.api.Assertions.assertSame;

public class CommandTest {

    @Test
    public void getCardinalDirectionFromShortCode() {
        assertSame(CardinalDirection.NORTH, CardinalDirection.getCardinalDirectionFromChar('N'));
        assertSame(CardinalDirection.EAST, CardinalDirection.getCardinalDirectionFromChar('E'));
        assertSame(CardinalDirection.SOUTH, CardinalDirection.getCardinalDirectionFromChar('S'));
        assertSame(CardinalDirection.WEST, CardinalDirection.getCardinalDirectionFromChar('W'));
    }
}
