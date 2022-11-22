package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.*;
import bridge.exception.BridgeSizeException;
import bridge.exception.CommandException;
import bridge.ui.InputView;
import bridge.ui.OutputView;

import java.util.List;

public class BridgeGameController {
    public static void run() {
        System.out.println("다리 건너기 게임을 시작합니다.\n");
        List<String> bridge = createBridge(inputBridgeSize());

        BridgeGame bridgeGame = new BridgeGame(bridge);
        boolean isGameSuccess = playBridgeGame(bridgeGame);

        OutputView.printResult(bridgeGame,isGameSuccess);
    }

    private static boolean playBridgeGame(BridgeGame bridgeGame) {
        boolean isRetry = true;

        while(isRetry) {
            boolean isCrossBridgeSuccess = crossBridge(bridgeGame);
            if(isCrossBridgeSuccess) {
                return true;
            }
            isRetry = bridgeGame.retry(inputGameCommand());
        }
        return false;
    }

    private static boolean crossBridge(BridgeGame bridgeGame) {
        boolean isCrossBridge = true;
        int bridgeSize = bridgeGame.getBridge().size();

        while (isCrossBridge && bridgeGame.getCurrentBridgeIndex() < bridgeSize) {
            isCrossBridge = bridgeGame.move(inputMoveCommand());
            OutputView.printMap(bridgeGame, isCrossBridge);
        }
        return isCrossBridge;
    }

    private static int inputBridgeSize() {
        try {
            return InputView.readBridgeSize();
        } catch (BridgeSizeException e) {
            e.printErrorMessage();
            return inputBridgeSize();
        }
    }

    private static MoveCommand inputMoveCommand() {
        try {
            return InputView.readMoving();
        } catch (CommandException e) {
            e.printErrorMessage();
            return inputMoveCommand();
        }
    }

    private static GameCommand inputGameCommand() {
        try {
            return InputView.readGameCommand();
        } catch (CommandException e) {
            e.printErrorMessage();
            return inputGameCommand();
        }
    }

    private static List<String> createBridge(int bridgeSize) {
        BridgeNumberGenerator randomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(randomNumberGenerator);

        return bridgeMaker.makeBridge(bridgeSize);
    }
}
