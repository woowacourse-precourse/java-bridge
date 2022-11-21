package bridge;

public class OutputView {

    private static final String OUTPUT_GAME_RESULT_MESSAGE = "최종 게임 결과";
    private static final String OUTPUT_SUCCESS_STATUS_MESSAGE = "게임 성공 여부: ";
    private static final String TOTAL_ATTEMPT_COUNT_MESSAGE = "총 시도한 횟수: ";
    private static final String SUCCESS_MESSAGE = "성공";
    private static final String FAILURE_MESSAGE = "실패";
    private static final String HEAD_MESSAGE = "[";
    private static final String BODY_MESSAGE = "|";
    private static final String TAIL_MESSAGE = "]";
    private static final String BLANK_MESSAGE = " ";


    public void printMap(String[][] userBoard, int position) {
        for (int i = 0; i < 2; i++) {
            System.out.print(HEAD_MESSAGE);
            for (int j = 0; j < position; j++) {
                System.out.print(BLANK_MESSAGE + userBoard[i][j] + BLANK_MESSAGE);
                if (j != position - 1 && position != 1) {
                    System.out.print(BODY_MESSAGE);
                }
            }
            System.out.println(TAIL_MESSAGE);
        }
        System.out.println();
    }


    public void printResult(String[][] userBoard, int position, boolean success, int totalAttemptCount) {
        System.out.println(OUTPUT_GAME_RESULT_MESSAGE);
        printMap(userBoard, position);
        if (success) {
            System.out.println(OUTPUT_SUCCESS_STATUS_MESSAGE + SUCCESS_MESSAGE);
        }
        if (success == false) {
            System.out.println(OUTPUT_SUCCESS_STATUS_MESSAGE + FAILURE_MESSAGE);
        }
        System.out.println(TOTAL_ATTEMPT_COUNT_MESSAGE + totalAttemptCount);
    }
}
