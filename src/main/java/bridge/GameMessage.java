package bridge;

public class GameMessage {

    private static final String IS_ERROR = "[ERROR] ";
    public static final String LINE_BREAK = "\n";

    public static String getResultTitle() {
        return Result
                .FINAL_GAME_RESULT
                .getContents();
    }

    public static String getTotalTry(int tyrCounts) {
        String totalTryContents = Result
                .TOTAL_TRY
                .getContents();

        return String.format(totalTryContents, tyrCounts);
    }

    public static String getSuccessOrNot(boolean isArrival) {
        String message = Result.SUCCESS_OR_NOT.getContents();

        if (isArrival) {
            message += Result.SUCCESS.getContents();
            return message;
        }

        message += Result.FAIL.getContents();
        return message;
    }

    public static String getError(String errorContents) {
        return IS_ERROR + errorContents;
    }

    public enum Guide {
        START("다리 건너기 게임을 시작합니다."),
        ENTER_LENGTH("다리의 길이를 입력해주세요."),
        CHOOSE_MOVE("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
        ASK_RE_GAME("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");

        private final String contents;

        Guide(String contents) {
            this.contents = contents;
        }

        public String getContents() {
            return contents;
        }
    }

    public enum Result {
        FINAL_GAME_RESULT("최종 게임 결과"),
        SUCCESS_OR_NOT("게임 성공 여부: "),
        SUCCESS("성공"),
        FAIL("실패"),
        TOTAL_TRY("총 시도한 횟수: %d");

        private final String contents;

        Result(String contents) {
            this.contents = contents;
        }

        public String getContents() {
            return contents;
        }
    }

    public enum Exception {
        IS_NUMBER("다리 길이는 숫자여야 합니다."),
        OUT_OF_RANGE_BRIDGE("다리 길이가 3부터 20 사이의 숫자에서 벗어났습니다."),
        DISALLOWED_INPUT_MOVE("이동할 칸을 선택하는 값은 U, D 만을 허용합니다."),
        DISALLOWED_INPUT_RE_GAME("게임을 다시 시도하는 여부의 값은 R, Q 만을 허용합니다.");

        private final String contents;

        Exception(String contents) {
            this.contents = contents;
        }

        public String getContents() {
            return contents;
        }
    }
}
