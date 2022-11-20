package bridge;

public class ValidationService {
    public static void checkInput(String input) {
        integerParsing(input);
        bridgeLengthLimit(input);
    }


    private static void integerParsing(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] input cannot be parsed to integer");
            throw new IllegalArgumentException();
        }
    }

    private static void bridgeLengthLimit(String input) {
        int length = Integer.parseInt(input);
        if (length < 3 && length > 20) {
            throw new IllegalArgumentException("[ERROR] bridge length should be either between 3 and 20");
        }
    }

    public static void moveCommand(String input) {
        if (input != "U" && input != "D") {
            System.out.println("[ERROR] input should be either U or D. You typed "+input);
            throw new IllegalArgumentException();
        }
    }

    public static void gameCommand(String input) {
        if (input != "R" && input != "Q") {
            System.out.println("[ERROR] input should be either R or Q. You typed "+input);
            throw new IllegalArgumentException();
        }

    }
}
