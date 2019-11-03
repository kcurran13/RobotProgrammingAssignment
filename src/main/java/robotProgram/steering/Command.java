package robotProgram.steering;

import java.util.HashMap;
import java.util.Map;

public enum Command {
    FORWARD('F'),
    LEFT('L'),
    RIGHT('R');

    private static final Map<Character, Command> CODE = new HashMap<>();
    private final char shortCode;

    Command(char shortCode) {
        this.shortCode = shortCode;
    }

    static {
        for (Command c: values()) {
            CODE.put(c.shortCode, c);
        }
    }

    public static Command getCommandFromChar(char code) {
        return CODE.get(code);
    }
}