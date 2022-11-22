package bridge;

public class OutputView {


    public void printMap(String[][] userBoard, int position) {
        for (int i = 0; i < 2; i++) {
            System.out.print(Constants.HEAD_FORM);
            for (int j = 0; j < position; j++) {
                System.out.print(Constants.BLANK + userBoard[i][j] + Constants.BLANK);
                if (j != position - 1 && position != 1) {
                    System.out.print(Constants.BODY_FORM);
                }
            }
            System.out.println(Constants.TAIL_FORM);
        }
        System.out.println();
    }

    public void printResult(String[][] userBoard, int position, boolean success, int totalAttemptCount) {
        System.out.println(Constants.GAME_RESULT);
        printMap(userBoard, position);
        if (success) {
            System.out.println(Constants.SUCCESS_OR_NOT + Constants.SUCCESS);
        }
        if (success == false) {
            System.out.println(Constants.SUCCESS_OR_NOT + Constants.FAILURE);
        }
        System.out.println(Constants.TOTAL_ATTEMPT_COUNT + totalAttemptCount);
    }
}
