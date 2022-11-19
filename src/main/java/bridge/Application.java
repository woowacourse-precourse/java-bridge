package bridge;

import java.util.List;

public class Application {

    private static final String GAME_START = "다리 건너기 게임을 시작합니다.";

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        OutputView.printMessage(GAME_START);
        InputView inputView = new InputView();
        int bridgeSize = inputView.getBridgeSize();

        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        System.out.println("bridge = " + bridge);

        BridgeGame bridgeGame = new BridgeGame(bridge);
        int nowBridgeIndex = 0;
        while (nowBridgeIndex < bridgeSize) {
            boolean isMoved = bridgeGame.move(nowBridgeIndex, inputView.getMoving());
            if (isMoved) {
                nowBridgeIndex++;
            } else {
                System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
                break;
            }
        }
    }

}
