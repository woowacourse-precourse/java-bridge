package bridge;

import java.util.List;

public class BridgeApplication {
    void run(){
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
        BridgeGame bridgeGame = new BridgeGame();

        while (true) {
            for (int idx = 0; idx < size; idx++) {
                System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
                String moving = inputView.readMoving();

                if (bridgeGame.move(bridge, moving, idx)) {
                    outputView.printMap();
                    System.out.println("성공 " + idx);
                } else {
                    outputView.printMap();
                    System.out.println("실패");
                    if (bridgeGame.retry(inputView)) {
                        return;
                    } else {
                        break;
                    }
                }
            }
        }
    }
}
