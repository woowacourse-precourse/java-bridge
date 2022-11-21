package bridge;

public class Application {
    private static InputView inputView = new InputView();
    public static void main(String[] args) {
        System.out.println("다리 건너기 게임을 시작합니다.");
        int len = inputView.readBridgeSize();
    }
}
