package bridge.view;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    public void printStartGame() {
        System.out.println(Constants.START_GAME_OUTPUT);
    }

    public void printRequestBridgeSizeInput() {
        System.out.println(Constants.REQUEST_BRIDGE_SIZE_INPUT);
    }

    public void printSelectUpOrDownInput() {
        System.out.println(Constants.SELECT_UP_OR_DOWN_INPUT);
    }

    public void printSelectRetryOrNotInput() {
        System.out.println(Constants.SELECT_RETRY_OR_NOT_INPUT);
    }

    public void printFinalGameResult() {
        System.out.println(Constants.FINAL_GAME_RESULT_OUTPUT);
    }

    public void printMap(String map) {
        System.out.println(map);
    }

    public void printResult(String map, boolean isSuccess, int numberOfTry) {
        printMap(map);
        printSuccess(isSuccess);
        printNumberOfTry(numberOfTry);
    }

    private void printSuccess(boolean isSuccess) {
        if (isSuccess) {
            System.out.println(Constants.GAME_SUCCESS_OUTPUT);
            return;
        }
        System.out.println(Constants.GAME_FAILURE_OUTPUT);
    }

    private void printNumberOfTry(int numberOfTry) {
        System.out.println(Constants.TOTAL_NUMBER_OF_TRY_OUTPUT);
    }
}
