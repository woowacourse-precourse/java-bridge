package bridge;

public class ValidationService {
    public static void checkBridgeLength(String input) {
        integerParsing(input);
        bridgeLengthLimit(input);

    }


    public static void integerParsing(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] input cannot be parsed to integer");
            throw new IllegalArgumentException();
        }
    }

    public static void bridgeLengthLimit(String input) {
        int length = Integer.parseInt(input);
        if (length < 3 || length > 20) {
            System.out.println("[ERROR] bridge length should be either between 3 and 20");
            throw new IllegalArgumentException();
        }
    }

    public static void checkMoveCommand(String input) {
        if (!input.equals("U") && !input.equals("D")) {
            System.out.println("[ERROR] input should be either U or D. You typed "+input);
            throw new IllegalArgumentException();
        }
    }

    public static void checkGameCommand(String input) {
        if (!input.equals("Q") && !input.equals("R")) {
            System.out.println("[ERROR] input should be either R or Q. You typed "+input);
            throw new IllegalArgumentException();
        }
    }
}
