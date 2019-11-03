package robotProgram.steering;

import java.util.HashMap;
import java.util.Map;

public enum CardinalDirection {
    NORTH('N'),
    SOUTH('S'),
    EAST('E'),
    WEST('W');

    private static final Map<Character, CardinalDirection> CODE = new HashMap<>();
    private final char shortCode;

    CardinalDirection(char shortCode) {
        this.shortCode = shortCode;
    }

    static {
        for (CardinalDirection cd : values()) {
            CODE.put(cd.shortCode, cd);
        }
    }

    public static CardinalDirection getCardinalDirectionFromChar(char code) {
        return CODE.get(code);
    }
}