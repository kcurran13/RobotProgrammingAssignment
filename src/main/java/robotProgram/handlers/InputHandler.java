package robotProgram.handlers;

import java.io.BufferedReader;
import java.io.IOException;

public class InputHandler {
    //handles and validates user input grid dimensions and robot direction

    /**
     * Take in user array, trim it, split on whitespace.
     * Validate the input and then add to an array.
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
