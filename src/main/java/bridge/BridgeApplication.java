package bridge;

import java.util.List;

public class BridgeApplication {
    void run() {
        // 다리 건너기 게임 시작
        System.out.println("다리 건너기 게임을 시작합니다.");

        // 다리의 길이를 입력
        System.out.println("다리의 길이를 입력해주세요.");
        InputView inputView = new InputView();
        int size = inputView.readBridgeSize();

        // 다리를 만듦
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(size);
        System.out.println(bridge.toString());

        OutputView outputView = new OutputView();
        BridgeGame bridgeGame = new BridgeGame(bridge, 1);

        // 다리건너기 시작
        for (int idx = 0; idx < size; idx++) {
            System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
            String moving = inputView.readMoving();
            bridgeGame.move(moving, idx);
            if (bridgeGame.isMove()) {
                outputView.printMap(bridgeGame);
                continue;
            }
            outputView.printMap(bridgeGame);
            if (!(bridgeGame.retry(inputView))) {
                break;
            }
            idx = -1;
            bridgeGame.plusCnt();
        }

        System.out.println("최종 게임 결과");
        outputView.printMap(bridgeGame);

        outputView.printResult(bridgeGame);
    }
}
