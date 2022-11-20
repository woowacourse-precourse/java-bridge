package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.bridge.*;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class MainController {
    public static void run() {
        OutputView.printWelcome();
        BridgeSize bridgeSize = getBridgeSize();
        BridgeGame bridgeGame = makeBridgeGame(bridgeSize.get());
        boolean isSuccess = processBridgeGame(bridgeGame);
        OutputView.printResult(
                bridgeGame.getBridgeMap().get(), isSuccess, bridgeGame.getTries());
    }

    private static BridgeSize getBridgeSize() {
        while (true) {
            try {
                BridgeSize bridgeSize = new BridgeSize(InputView.readBridgeSize());
                return bridgeSize;
            } catch (IllegalArgumentException E) {
                System.out.printf(E.getMessage());
            }
        }
    }

    private static BridgeGame makeBridgeGame(int size) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(size);
        return new BridgeGame(bridge);
    }

    /**
     * 브릿지 게임을 진행하는 메소드
     * output: 승패 여부 (boolean)
     */
    private static boolean processBridgeGame(BridgeGame bridgeGame) {
        do {
            if (!processTurn(bridgeGame)) {
                return false;
            }
        } while (!bridgeGame.checkEnd());
        return true;
    }

    /**
     * 브릿지 게임의 한 턴을 진행하는 메소드
     * output: 답을 맞췄는지 여부 (boolean)
     */
    private static boolean processTurn(BridgeGame bridgeGame) {
        if (!moveBridge(bridgeGame)) {
            if(!askRetry().getIsRetry()) {
                return false;
            }
            bridgeGame.retry();
        }
        return true;
    }

    /**
     * 이동 방향을 입력받아 다리를 한 칸 전진하는 메소드
     * output: 답을 맞췄는지 여부 (boolean)
     */
    private static boolean moveBridge(BridgeGame bridgeGame) {
        String direction = getMove().getDirection();
        boolean isCorrect = bridgeGame.move(direction);
        OutputView.printMap(bridgeGame.getBridgeMap().get());
        return isCorrect;
    }

    /**
     * 실패 시 다시 시도할지 명령어를 얻는 메소드
     * output: BridgeCommand Object
     */
    private static BridgeCommand askRetry() {
        while (true) {
            try {
                BridgeCommand bridgeCommand = new BridgeCommand(InputView.readGameCommand());
                return bridgeCommand;
            } catch (IllegalArgumentException E) {
                System.out.printf(E.getMessage());
            }
        }
    }

    /**
     * 이동을 위한 이동 방향을 묻는 메소드
     * output: BridgeMove Object
     */
    private static BridgeMove getMove() {
        while (true) {
            try {
                return new BridgeMove(InputView.readMoving());
            } catch (IllegalArgumentException E) {
                System.out.printf(E.getMessage());
            }
        }
    }

}
