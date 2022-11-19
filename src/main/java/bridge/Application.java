package bridge;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        BridgeGame bridgeGame = new BridgeGame();
        BridgeGameView bridgeGameView = new BridgeGameView();

        Boolean isMoving;

        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println("\n다리의 길이를 입력해주세요.");

        int bridgeSize = inputView.readBridgeSize();

        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        System.out.println(bridge);

        System.out.println("\n이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String moving1 = inputView.readMoving();
        isMoving = bridgeGame.move(bridge, moving1, 0);
        bridgeGameView.printBridgeResult(isMoving);

        System.out.println("\n이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String moving2 = inputView.readMoving();
        isMoving = bridgeGame.move(bridge, moving2, 1);
        bridgeGameView.printBridgeResult(isMoving);


    }
}
