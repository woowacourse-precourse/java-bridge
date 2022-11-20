package bridge;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        startGame();
    }

    private static void startGame() {
        BridgeGame bridgeGame = new BridgeGame();

        makeBridge(bridgeGame);

        while (inGame(bridgeGame)) {
            if (bridgeGame.gameSucces())
                break;
        }

        OutputView.printResult(bridgeGame.createResultMap(), bridgeGame.getTryNum(), bridgeGame.getCurrentState());
    }

    private static boolean inGame(BridgeGame bridgeGame) {
        String gameCommand = "";
        if (!move(bridgeGame)) {
            printMap(bridgeGame);
            gameCommand = gameEnd();
        }
        printMap(bridgeGame);

        return checkContinueGame(gameCommand, bridgeGame);
    }

    private static boolean checkContinueGame(String gameCommand, BridgeGame bridgeGame) {
        if (gameCommand.equals("Q"))
            return false;
        if (gameCommand.equals("R"))
            bridgeGame.retry();
        return true;
    }

    private static String gameEnd() {
        OutputView.printGameOver();
        return InputView.readGameCommand();
    }

    private static void printMap(BridgeGame bridgeGame) {
        String currentMap = bridgeGame.createResultMap();
        OutputView.printMap(currentMap);
    }

    private static boolean move(BridgeGame bridgeGame) {
        OutputView.printSelectMove();
        String playerMove = InputView.readMoving();

        return bridgeGame.move(playerMove);
    }

    private static void makeBridge(BridgeGame bridgeGame) {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

        OutputView.printStart();
        int bridgeSize = InputView.readBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        bridgeGame.setBridge(bridge);
    }
    
}
