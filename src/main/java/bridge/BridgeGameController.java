package bridge;

import java.util.List;

public class BridgeGameController {
    public static void run() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println();
        int bridgeSize = inputBridgeSize();
        BridgeGame bridgeGame = new BridgeGame(createBridge(bridgeSize));
        boolean successGame = playGame(bridgeSize, bridgeGame);
        OutputView.printResult(bridgeGame,successGame);
    }

    private static boolean playGame(int bridgeSize, BridgeGame bridgeGame) {
        boolean retry = true;
        while(retry) {
            boolean continueGame = isSuccessGame(bridgeGame, bridgeSize);
            if(continueGame){
                break;
            }
            GameCommand gameCommand = inputGameCommand();
            retry = bridgeGame.retry(gameCommand);
        }
        return retry;
    }

    private static boolean isSuccessGame(BridgeGame bridgeGame, int bridgeSize) {
        boolean crossBridge = true;
        while (crossBridge && bridgeGame.getCurrentBridgeIndex() < bridgeSize) {
            MoveCommand moveCommand = inputMoveCommand();
            crossBridge = bridgeGame.move(moveCommand);
            OutputView.printMap(bridgeGame, crossBridge);
        }
        return crossBridge;
    }

    private static int inputBridgeSize() {
        try {
            return InputView.readBridgeSize();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputBridgeSize();
        }
    }

    private static MoveCommand inputMoveCommand() {
        try {
            return InputView.readMoving();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputMoveCommand();
        }
    }

    private static GameCommand inputGameCommand() {
        try {
            return InputView.readGameCommand();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputGameCommand();
        }
    }

    private static List<String> createBridge(int bridgeSize) {
        BridgeNumberGenerator randomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(randomNumberGenerator);
        return bridgeMaker.makeBridge(bridgeSize);
    }
}
