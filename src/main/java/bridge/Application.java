package bridge;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        printStart();
        InputView inputView = new InputView();

        int bridgeSize = inputView.readBridgeSize();

    }

    public static void printStart() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }
}
