package bridge;

public class InputTry {
    private static final InputView input = new InputView();

    public static int readBridgeSizeTry(){
        Integer bridgeSize = null;
        while ( bridgeSize == null ) {
            try {
                bridgeSize = input.readBridgeSize();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                bridgeSize = null;
            }
        }
        return bridgeSize;
    }
}
