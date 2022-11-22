package bridge.Exception;

public class Validation {
    public static String validateMove(String input) {
        if(input.equals("U") || input.equals("D")) return input;
        throw new MoveException();
    }

    public static String validateCommand(String input) {
        if(input.equals("R") || input.equals("Q")) return input;
        throw new CommandException();
    }
}
