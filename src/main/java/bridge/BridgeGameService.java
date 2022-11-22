package bridge;

public class BridgeGameService {
    private static final InputView inputView = new InputView();

    public Integer askBridgeSize() {
        while (true) {
            try {
                return inputView.readBridgeSize();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
