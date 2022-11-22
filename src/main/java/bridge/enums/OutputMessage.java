package bridge.enums;

import java.util.List;

public enum OutputMessage {
    OUTPUT_START_BRIDGE_GAME("다리 건너기 게임을 시작합니다."),
    OUTPUT_ENTER_BRIDGE_SIZE("다리의 길이를 입력해주세요."),
    OUTPUT_CHOOSE_BRIDGE_MOVE_POSITION("이동할 칸을 선택해주세요. (%s: %s, %s: %s)"),
    OUTPUT_CHOOSE_RESTART_OR_QUIT("게임을 다시 시도할지 여부를 입력해주세요. (%s: %s, %s: %s)"),
    OUTPUT_FINAL_BRIDGE_GAME_RESULT("최종 게임 결과"),
    OUTPUT_GAME_SUCCESS_RESULT("게임 성공 여부: %s"),
    OUTPUT_TOTAL_TRY_TIMES("총 시도한 횟수: %d"),
    OPEN_BRACKET("[ "),
    CLOSE_BRACKET(" ]"),
    MIDDLE_LINE(" | "),
    BLANK(" ");


    final private String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public static String askMovePosition() {
        return String.format(OUTPUT_CHOOSE_BRIDGE_MOVE_POSITION.getMessage(),
                Answer.Up.getDescription(), Answer.Up.getAnswer(),
                Answer.Down.getDescription(), Answer.Down.getAnswer());
    }

    public static String chooseRestartOrQuit() {
        return String.format(OUTPUT_CHOOSE_RESTART_OR_QUIT.getMessage(),
                Answer.Retry.getDescription(), Answer.Retry.getAnswer(),
                Answer.Quit.getDescription(), Answer.Quit.getAnswer());
    }

    public static String bridgeResultTable(List<String> bridge, List<Boolean> userMove, String upDown) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(OPEN_BRACKET.getMessage());
        stringBuilder.append(makeRow(bridge, userMove, upDown));
        stringBuilder.append(CLOSE_BRACKET.getMessage());
        return stringBuilder.toString();
    }

    private static String makeRow(List<String> bridge, List<Boolean> userMove, String upDown) {
        StringBuilder row = new StringBuilder();
        for (int i = 0; i < userMove.size(); i++) {
            if (row.length() != 0) {
                row.append(MIDDLE_LINE.getMessage());
            }
            row.append(getUserAnswerResult(bridge.get(i), userMove.get(i), upDown));
        }
        return row.toString();
    }

    private static String getUserAnswerResult(String bridgeAnswer, Boolean userAnswer, String upDown) {
        if (userAnswer) {
            if (bridgeAnswer.equals(upDown)) {
                return SuccessOrFail.Success.getShow();
            }
            return BLANK.getMessage();
        }
        if (!bridgeAnswer.equals(upDown)) {
            return SuccessOrFail.Fail.getShow();
        }
        return BLANK.getMessage();
    }

    public static String gameResult(boolean result) {
        return String.format(OUTPUT_GAME_SUCCESS_RESULT.getMessage(), SuccessOrFail.convertDescription(result));
    }

    public static String totalTryTimes(int tryTimes) {
        return String.format(OUTPUT_TOTAL_TRY_TIMES.getMessage(), tryTimes);
    }
}
