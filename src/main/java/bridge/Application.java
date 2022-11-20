package bridge;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();

        startGame(outputView, inputView);
    }

    private static void startGame(OutputView outputView, InputView inputView) {
        BridgeGame bridgeGame = new BridgeGame();

        makeBridge(outputView, inputView, bridgeGame);

        while (inGame(outputView, inputView, bridgeGame)) {
            if (bridgeGame.gameSucces())
                break;
        }

        outputView.printResult(bridgeGame.createResultMap(), bridgeGame.getTryNum(), bridgeGame.getCurrentState());
    }

    private static boolean inGame(OutputView outputView, InputView inputView, BridgeGame bridgeGame) {
        String gameCommand = "";
        if (!move(outputView, inputView, bridgeGame)) {
            printMap(outputView, bridgeGame);
            gameCommand = gameEnd(outputView, inputView);
        }
        printMap(outputView, bridgeGame);

        return checkContinueGame(gameCommand, bridgeGame);
    }

    private static boolean checkContinueGame(String gameCommand, BridgeGame bridgeGame) {
        if (gameCommand.equals("Q"))
            return false;
        if (gameCommand.equals("R"))
            bridgeGame.retry();
        return true;
    }

    private static String gameEnd(OutputView outputView, InputView inputView) {
        outputView.printGameOver();
        return inputView.readGameCommand();
    }

    private static void printMap(OutputView outputView, BridgeGame bridgeGame) {
        String currentMap = bridgeGame.createResultMap();
        outputView.printMap(currentMap);
    }

    private static boolean move(OutputView outputView, InputView inputView, BridgeGame bridgeGame) {
        outputView.printSelectMove();
        String playerMove = inputView.readMoving();

        return bridgeGame.move(playerMove);
    }

    private static void makeBridge(OutputView outputView, InputView inputView, BridgeGame bridgeGame) {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

        outputView.printStart();
        int bridgeSize = inputView.readBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        bridgeGame.setBridge(bridge);
    }
    
}
