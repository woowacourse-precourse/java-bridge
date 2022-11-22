package bridge;

public class BridgeGameView {

    private final InputView inputView = new InputView();

    public int readBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
        
        try {
            return inputView.readBridgeSize();
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 3부터 20사이의 정수를 입력해주세요.");
            return readBridgeSize();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 3부터 20사이의 정수를 입력해주세요.");
            return readBridgeSize();
        }
    }

}
