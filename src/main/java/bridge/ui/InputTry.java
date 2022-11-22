package bridge.ui;

public class InputTry {
    private static final InputView input = new InputView();

    public static int readBridgeSizeTry(){
        try {
            return input.readBridgeSize();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readBridgeSizeTry();
        }
    }
    public static String readMovingTry(){
        try {
            return input.readMoving();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readMovingTry();
        }
    }
    public static String readGameCommandTry(){
        try {
            return input.readGameCommand();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readGameCommandTry();
        }
    }
}