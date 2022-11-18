package bridge;// @ author ninaaano

public class Exception {

    private static final int MIN_LENGTH = 3;
    private static final int MAX_LENGTH = 20;

    private static final String UP = "U";
    private static final String DOWN = "D";

    private static final String RESTART = "R";
    private static final String QUIT = "Q";

    public enum ErrorMessage{
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

}
