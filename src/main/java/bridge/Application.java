package bridge;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println("다리 길이를 입력해주세요.");
        InputView inputView = new InputView();
        int size = inputView.readBridgeSize();
    }
}
