package bridge;

public class Application {

    private int size;

    private String move;

    private String retry;

    private static Error error;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        prepareExceptionBeforeBridgeGame();
    }

    public static void prepareExceptionBeforeBridgeGame() {
        try {
            startBridgeGame();
        } catch (IllegalStateException e) {
            System.out.println(error.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println(error.getMessage());
        }
    }

    public static void startBridgeGame() {
        playBridgeGame();
    }

    public static void playBridgeGame() {

    }

    public static void setError(Error errorMessage) {
        error = errorMessage;
    }
}
