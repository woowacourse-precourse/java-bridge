package bridge;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();

        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println("\n다리의 길이를 입력해주세요.");

        int bridgeSize = inputView.readBridgeSize();
        System.out.println(bridgeSize);
    }
}
