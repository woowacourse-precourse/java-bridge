package bridge;

public class Application {

    public static void main(String[] args) {

        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println();
        InputView makeBridge = new InputView();
        int bridgeLength = makeBridge.readBridgeSize(); // 다리의 길이
        System.out.println(bridgeLength);

    }
}
