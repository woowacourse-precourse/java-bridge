package bridge;

public class Application {

    public static void main(String[] args) {
        BridgeUtils bridgeUtils = new BridgeUtils();

        System.out.println("다리 건너기 게임을 시작합니다.\n");
        System.out.println("다리의 길이를 입력해주세요.");

        Bridge bridge = bridgeUtils.startBridgeGame();
        bridgeUtils.play(bridge);
    }
}
