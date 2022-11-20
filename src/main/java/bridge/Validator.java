package bridge;

public class Validator {

    public static void validate(String moving) {
        if (!moving.equals(Direction.Code.UP.getName()) && !moving.equals(Direction.Code.DOWN.getName())) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateCommand(String command) {
        if (!command.equals("R") && !command.equals("Q")) {
            throw new IllegalArgumentException();
        }
    }

}
