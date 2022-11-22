package bridge;

public class ReInput {

    private static final InputView inputView = new InputView();

    public int reGetBridgeLength() {
        try {
            return inputView.readBridgeSize();
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            return reGetBridgeLength();
        }
    }

    public String reGetMoveString() {
        try {
            return inputView.readMoving();
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            return reGetMoveString();
        }
    }

    public static String reGetExitOrRestart() {
        try {
            return inputView.readGameCommand();
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            return reGetExitOrRestart();
        }
    }
}
