package bridge;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("다리 건너기 게임을 시작합니다.");
        InputView inputView = new InputView();
        int ladderLen = inputView.readBridgeSize();
        System.out.println("ladderLen = " + ladderLen);
    }
}
