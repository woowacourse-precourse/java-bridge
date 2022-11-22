package bridge;

public class Error {
    public static void validateNumber(String answer) throws IllegalArgumentException {
        try {
            Integer.parseInt(answer);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ErrorMessage.RIGHT_BRIDGE_SIZE.getError_letter());
        }
    }

    public static void validateNumberRange(int startNotInclude, int endNotInclude, int object) throws IllegalArgumentException {
        if (object < startNotInclude || object > endNotInclude) {
            throw new IllegalArgumentException(ErrorMessage.RIGHT_BRIDGE_SIZE.getError_letter());
        }
    }

    public static void validateBridgeAnswer(String answer) throws IllegalArgumentException {
        if (!(answer.equals("U") || answer.equals("D"))) {
            throw new IllegalArgumentException(ErrorMessage.RIGHT_BRIDGE_CHOICE.getError_letter());
        }
    }

    public static void validateCommend(String answer) throws IllegalArgumentException {
        if (!(answer.equals("R") || answer.equals("Q"))) {
            throw new IllegalArgumentException(ErrorMessage.RIGHT_COMMEND.getError_letter());
        }
    }

}

