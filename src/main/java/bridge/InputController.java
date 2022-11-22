package bridge;

public class InputController {
    public static int checkSize(InputView inputView) {
        int size;
        try {
            size = inputView.readBridgeSize();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return (checkSize(inputView));
        }
        return size;
    }
    
}
