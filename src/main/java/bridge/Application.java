package bridge;

import bridge.domain.*;

import static bridge.view.InputView.readBridgeSize;
import static bridge.view.InputView.readMoving;
import static bridge.view.InputView.readGameCommand;
import static bridge.view.OutputView.*;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final int INIT_RETRY_COUNT = 1;

    public static void main(String[] args) {
        printStartGameMessage();
        List<String> randomBridge = generateRandomBridge(getBridgeLength());
        MovingStatusSaver statusSaver = new MovingStatusSaver(new ArrayList<>(), randomBridge);
        BridgeGame bridgeGame = new BridgeGame(statusSaver, INIT_RETRY_COUNT);

        run(bridgeGame);
        // 결과 출력
    }

    private static List<String> generateRandomBridge(BridgeLength length) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        return bridgeMaker.makeBridge(length.getLength());
    }

    private static void run(BridgeGame bridgeGame) {
        while (!bridgeGame.isStopCondition()) {
            bridgeGame.move(getMoving().toString());
            printMap(bridgeGame.getSavedStatus());
        }
        // 재시작 여부 확인
    }


    private static BridgeLength getBridgeLength() {
        try {
            return BridgeLength.createBridgeLength(readBridgeSize());
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return getBridgeLength();
        }
    }

    private static Moving getMoving() {
        try {
            return Moving.createMoving(readMoving());
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return getMoving();
        }
    }
}