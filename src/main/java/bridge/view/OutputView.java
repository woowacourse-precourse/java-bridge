package bridge.view;

import bridge.model.GameResultDto;

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

    public void printMap(String map) {
        System.out.println(map);
    }

    public void printSelectRetryOrNotInput() {
        System.out.println(Constants.SELECT_RETRY_OR_NOT_INPUT);
    }

    public void printResult(GameResultDto gameResultDto) {
        printFinalGameResult();
        printMap(gameResultDto.getMap());
        printSuccessResult(gameResultDto.isSuccess());
        printNumberOfTry(gameResultDto.getNumberOfTry());
    }

    private void printFinalGameResult() {
        System.out.println(Constants.FINAL_GAME_RESULT_OUTPUT);
    }

    private void printSuccessResult(boolean isSuccess) {
        if (isSuccess) {
            System.out.println(Constants.GAME_SUCCESS_OUTPUT);
            return;
        }
        System.out.println(Constants.GAME_FAILURE_OUTPUT);
    }

    private void printNumberOfTry(int numberOfTry) {
        System.out.printf(Constants.TOTAL_NUMBER_OF_TRY_OUTPUT, numberOfTry);
    }

    public void printExceptionMessage(Exception exception) {
        System.out.println(exception.getMessage());
    }

    public void printNewLine() {
        System.out.println();
    }
}