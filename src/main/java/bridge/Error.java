package bridge;

public class Error {
    public static void validateNumber(String answer) {
        try {
            Integer.parseInt(answer);
        } catch(IllegalArgumentException e) {
            System.out.println(ErrorMessage.RIGHT_BRIDGE_SIZE.getError_letter());
            throw new IllegalArgumentException();
        }
    }

    public static void validateNumberRange(int startNotInclude, int endNotInclude, int object) {
        if(object<startNotInclude || object>endNotInclude) {
            System.out.println(ErrorMessage.RIGHT_BRIDGE_SIZE.getError_letter());
            throw new IllegalArgumentException();
        }
    }

    public static void validateBridgeAnswer(String answer) {
        if(!(answer.equals("U")||answer.equals("D"))) {
            System.out.println(ErrorMessage.RIGHT_BRIDGE_CHOICE.getError_letter());
            throw new IllegalArgumentException();
        }
    }

    public static void validateCommend(String answer) {
        if(!(answer.equals("R")||answer.equals("Q"))) {
            System.out.println(ErrorMessage.RIGHT_COMMEND.getError_letter());
            throw new IllegalArgumentException();
        }
    }

}

