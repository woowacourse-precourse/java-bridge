package bridge.view;

public class OutputView {

    private static final String SUCCESS = "성공";
    private static final String LOSE = "실패";

    public void printMap(String bridgeDesign) {
        print(bridgeDesign);
    }

    public void printResult(String bridgeDesign) {
        print(AnnounceMessage.GAME_RESULT.getMessage());
        printMap(bridgeDesign);
    }

    public void printSuccess(int tries) {
        print(String.format(AnnounceMessage.WIN_OR_LOSE.getMessage(), SUCCESS));
        printTries(tries);
    }

    public void printLose(int tries) {
        print(String.format(AnnounceMessage.WIN_OR_LOSE.getMessage(), LOSE));
        printTries(tries);
    }

    public void printTries(int tries) {
        print(String.format(AnnounceMessage.TRIES.getMessage(), tries));
    }

    public void printStartMessage() {
        print(AnnounceMessage.START_GAME.getMessage());
    }


    public void printSizeInputException() {
        print(ExceptionMessage.WRONG_SIZE_INPUT.getMessage());
    }

    public void printUDInputException() {
        print(ExceptionMessage.WRONG_UD_INPUT.getMessage());
    }

    public void printRQInputException() {
        print(ExceptionMessage.WRONG_RQ_INPUT.getMessage());
    }

    public void print(String message) {
        System.out.println(message);
    }

}
