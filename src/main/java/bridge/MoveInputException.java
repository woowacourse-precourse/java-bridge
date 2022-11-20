package bridge;

public class MoveInputException {

    public static void validateMoveInput(String upAndDown) {
        checkInputUpAndDownCapital(upAndDown);
        checkInputUpAndDownRight(upAndDown);
    }

    private static void checkInputUpAndDownCapital(String upAndDown) {
        if (upAndDown.equals("u") || upAndDown.equals("d")) {
            throw new IllegalArgumentException(MoveInputExceptionMessage.SMALL_LETTER_EXCEPTION_MESSAGE.getMoveInputExceptionMessage());
        }
    }

    private static void checkInputUpAndDownRight(String upAndDown) {
        if ((!upAndDown.equals("U") && !upAndDown.equals("D"))) {
            throw new IllegalArgumentException(MoveInputExceptionMessage.NOT_SUITABLE_ALPHABET_EXCEPTION_MESSAGE.getMoveInputExceptionMessage());
        }
    }
}
