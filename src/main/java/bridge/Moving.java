package bridge;

public class Moving {
    private static String moving;

    public static void validateInput(String userMoving) {
        Validator.validateLength(userMoving);
        Validator.validateMoving(userMoving);
        moving = userMoving;
    }

    public static String getMoving() {
        return moving;
    }

}
