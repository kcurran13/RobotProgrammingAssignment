import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertSame;
import robotProgram.steering.CardinalDirection;

public class CardinalDirectionTest {

    @Test
    public void getCardinalDirectionFromCharTest() {
        assertSame(CardinalDirection.NORTH, CardinalDirection.getCardinalDirectionFromChar('N'));
        assertSame(CardinalDirection.EAST, CardinalDirection.getCardinalDirectionFromChar('E'));
        assertSame(CardinalDirection.SOUTH, CardinalDirection.getCardinalDirectionFromChar('S'));
        assertSame(CardinalDirection.WEST, CardinalDirection.getCardinalDirectionFromChar('W'));
    }
}
