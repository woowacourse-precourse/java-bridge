package bridge;

import bridge.controller.BridgeGame;
import bridge.controller.IOController;
import bridge.util.BridgeGameInfo;

import java.util.List;

public class Application {

    private IOController ioController;
    private BridgeGame bridgeGame;

    public Application() {
        ioController = new IOController();
    }

    private BridgeGame makeBridgeGame() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        int bridgeSize = ioController.inputBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        return new BridgeGame(bridge);
    }

    private void displayBridge() {
        String bridgeMap = bridgeGame.getBridgeMap();
        ioController.printMap(bridgeMap);
    }

    private void displayGameResult() {
        String gameResult = bridgeGame.toString();
        ioController.printResult(gameResult);
    }

    private boolean isGameActive(String gameCommand) {
        if (gameCommand.equals(BridgeGameInfo.GAME_RESTART_COMMAND)) {
            bridgeGame.retry();
            return true;
        }

        return false;
    }

    private boolean move() {
        String moving = ioController.inputNextMove();
        return bridgeGame.move(moving);
    }

    private boolean getGameActive(boolean isMoved) {
        if (!isMoved) {
            String gameCommand = ioController.inputGameCommand();
            return isGameActive(gameCommand);
        }

        return true;
    }

    private void playGame() {
        boolean isGameActive = true;

        while (bridgeGame.isNotFinish() && isGameActive) {
            boolean isMoved = move();
            displayBridge();
            isGameActive = getGameActive(isMoved);
        }
    }

    public void run() {
        ioController.printGameStartMessage();
        bridgeGame = makeBridgeGame();
        playGame();
        displayGameResult();
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        new Application().run();
    }
}
