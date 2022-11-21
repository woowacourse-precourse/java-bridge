package bridge;


public enum BridgeMapGenerator {

    RIGHT_ANSWER_INPUT_UP("O", " "),
    RIGHT_ANSWER_INPUT_DOWN(" ", "O"),
    WRONG_ANSWER_INPUT_UP("X", " "),
    WRONG_ANSWER_INPUT_DOWN(" ", "X"),;

    private final String resultOfUp;
    private final String resultOfDown;

    BridgeMapGenerator(String resultOfUp, String resultOfDown) {
        this.resultOfUp = resultOfUp;
        this.resultOfDown = resultOfDown;
    }
}
