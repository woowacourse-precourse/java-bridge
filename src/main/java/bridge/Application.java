package bridge;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        OutputView.printStart();
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
            gameCommand = getGameEndInput();
            return checkContinueGame(gameCommand, bridgeGame);
        }
        
        printMap(bridgeGame);
        return true;
    }

    private static boolean checkContinueGame(String gameCommand, BridgeGame bridgeGame) {
        if (gameCommand.equals("Q"))
            return false;
        if (gameCommand.equals("R"))
            bridgeGame.retry();
        return true;
    }

    private static String getGameEndInput() throws IllegalArgumentException {
        OutputView.printGameOver();
        String gameEndInput = "";
        try {
            gameEndInput = InputView.readGameCommand();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getGameEndInput();
        }
        return gameEndInput;
    }

    private static void printMap(BridgeGame bridgeGame) {
        String currentMap = bridgeGame.createResultMap();
        OutputView.printMap(currentMap);
    }

    private static boolean move(BridgeGame bridgeGame) {
        String playerMove = getPlayerMove();

        return bridgeGame.move(playerMove);
    }

    private static String getPlayerMove() throws IllegalArgumentException {
        OutputView.printSelectMove();
        String playerMove = "";
        try {
            playerMove = InputView.readMoving();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getPlayerMove();
        }
        return playerMove;
    }

    private static void makeBridge(BridgeGame bridgeGame) {
        int bridgeSize = getBridgeSize();
        
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        bridgeGame.setBridge(bridge);
    }

    private static int getBridgeSize() throws IllegalArgumentException {
        OutputView.printAskBridgeSize();
        int bridgeSize = 0;
        try {
            bridgeSize = InputView.readBridgeSize();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getBridgeSize();
        }
        return bridgeSize;
    }
    
}
