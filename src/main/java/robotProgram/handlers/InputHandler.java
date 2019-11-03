package robotProgram.handlers;

import java.io.BufferedReader;
import java.io.IOException;

public class InputHandler {
    /**
     * Take in user array, trim it, split on whitespace.
     *
     * @param reader buffered reader to receive input
     * @return array with grid dimensions
     */
    public static String[] handleGridInput(BufferedReader reader) {
        String[] userInput = null;
        try {
            userInput = reader.readLine().trim().split("\\s+");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return userInput;
    }

    public static String[] handleRobotInput(BufferedReader reader) {
        String[] userInput = null;
        try {
            userInput = reader.readLine().trim().split("\\s+");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return userInput;
    }
}
