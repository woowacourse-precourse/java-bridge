package bridge;

public class ReEnter {

    private static final InputView inputView = new InputView();

    public static int reGetBridgeLength() {
        try {
            return inputView.getBridgeLength();
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            return reGetBridgeLength();
        }
    }

    public static String reGetMoveString() {
        try {
            return inputView.getMoveString();
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            return reGetMoveString();
        }
    }

    public static String reGetExitOrRestart() {
        try {
            return inputView.getExitOrRestart();
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            return reGetExitOrRestart();
        }
    }
}

