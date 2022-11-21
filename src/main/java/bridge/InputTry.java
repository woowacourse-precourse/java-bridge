package bridge;

public class InputTry {
    private static final InputView input = new InputView();

    public static int readBridgeSizeTry(){
        try {
            return input.readBridgeSize();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return readBridgeSizeTry();
        }
    }
    public static String readMovingTry(){
        try {
            return input.readMoving();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return readMovingTry();
        }
    }
    public static String readGameCommandTry(){
        try {
            return input.readGameCommand();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return readGameCommandTry();
        }
    }
}