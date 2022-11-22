package bridge.exception;// @ author ninaaano

import bridge.utils.Validator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Exception {

    private static final int MIN_LENGTH = 3;
    private static final int MAX_LENGTH = 20;

    private static final String UP = "U";
    private static final String DOWN = "D";

    private static final String RESTART = "R";
    private static final String QUIT = "Q";

    public static final String IS_NUMBER = "[0-9]*";

    public enum ErrorMessage {
        //DEFAULT_ERROR("ERROR"),
        STRING_EXCEPTION("입력값에 문자열이 들어올 수 없습니다."),
        AMOUNT_BOUNDS("범위를 벗어난 입력값입니다."),
        WRONG_INPUT("잘못된 입력값입니다.");

        private String error;

        ErrorMessage(String error) {
            this.error = error;
        }

        public String getError() {
            return error;
        }
    }

    public static void checkString(String userInput) throws IllegalArgumentException {

        if (!userInput.matches(IS_NUMBER)) {
            throw new IllegalArgumentException("[ERROR]" + ErrorMessage.STRING_EXCEPTION.error);
        }
        int size = Integer.parseInt(userInput);
        if (size < MIN_LENGTH || size > MAX_LENGTH)
            //return userInput;
         throw new IllegalArgumentException("[ERROR]" + ErrorMessage.AMOUNT_BOUNDS.getError());
    }


    public static String checkMove(String userInput) throws IllegalArgumentException {
        if (userInput.equals(UP) || userInput.equals(DOWN))
            return userInput;
        throw new IllegalArgumentException("[ERROR]" + ErrorMessage.WRONG_INPUT.error);
    }

    public static String checkRestartOrQuit(String userInput) throws IllegalArgumentException {
        if (userInput.equals(RESTART) || userInput.equals(QUIT))
            return userInput;
        throw new IllegalArgumentException("[ERROR]" + ErrorMessage.WRONG_INPUT.error);
    }
}
