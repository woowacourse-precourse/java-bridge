package bridge;

import java.util.ArrayList;
import java.util.List;

public class Application {

    private static final BridgeGame bridgeGame = new BridgeGame();
    private static final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    public static void main(String[] args) {
        Bridge bridge = setBridge();
        System.out.println(bridge.getFootholds().toString());
        crossUntilEnd(bridge);
        outputView.printResult(bridge, bridgeGame.isClear(bridge));
    }

    private static Bridge setBridge() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        int bridgeSize = inputView.readBridgeSizeUntilConstant();
        Bridge bridge = new Bridge(bridgeMaker.makeBridge(bridgeSize), new ArrayList<>());
        return bridge;
    }

    private static void cross(Bridge bridge) {
        String input = inputView.readMovingUntilConstant();
        bridgeGame.move(bridge, input);
        outputView.printMap(bridge);
        if (!bridgeGame.isCorrect(bridge)) {
            String gameCommand = inputView.readGameCommandUntilConstant();
            if (gameCommand.equals("R")) {
                bridgeGame.retry(bridge);
            }
        }
    }


    private static void crossUntilEnd(Bridge bridge) {
        while (!bridgeGame.isAllCrossed(bridge)) {
            cross(bridge);
            if (!bridgeGame.isCorrect(bridge)) {
                break;
            }
        }
    }
}
