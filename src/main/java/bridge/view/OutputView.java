package bridge.view;

public class OutputView {
    private static final OutputView instance = new OutputView();

    private OutputView() {
    }

    public void printGameStart() {
        System.out.println(OutputMessage.GAME_START.message());
    }

    public void printMap(String map) {
        System.out.println(map);
    }

    public void printResult(String map, boolean isFail, int attempts) {
        System.out.println(OutputMessage.GAME_RESULT.message());
        printMap(map);
        printSuccessOrFail(isFail);
        System.out.printf(OutputMessage.ATTEMPT.message(), attempts);
    }

    private void printSuccessOrFail(boolean isFail) {
        String result = OutputMessage.SUCCESS.message();
        if (isFail) {
            result = OutputMessage.FAIL.message();
        }
        System.out.printf(OutputMessage.SUCCESS_OR_FAIL.message(), result);
    }

    public static OutputView getInstance() {
        return instance;
    }
}
