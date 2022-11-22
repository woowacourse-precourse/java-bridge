package bridge;

import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class Application {
    private static final InputView input = new InputView();
    private static final OutputView output = new OutputView();
    private static final BridgeMaker maker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private static final BridgeGame game = new BridgeGame();

    private static GameState state = GameState.START;
    private static List<String> bridge;
    private static Route route = new Route();
    private static int tryCount = 1;
    private static String result = "실패";

    public static void main(String[] args) {
        try {
            start();
            gameInProgress();
            output.printResult(result, tryCount);
        } catch (IllegalArgumentException e) {
            System.out.printf("[ERROR] %s", e.getMessage());
        }
    }

    private static void gameInProgress() {
        while (state != GameState.QUIT) {
            tryCount = restart(tryCount);
            boolean success = goToNextSpace(route);
            chooseGameContinue(success);
            result = isGameWin(result);
            quit();
        }
    }

    private static void start() {
        output.printStartMessage();
        createBridge();
    }

    private static void quit() {
        if (state == GameState.QUIT) {
            output.printFinalResult(route);
        }
    }

    private static String isGameWin(String result) {
        if (route.gameSuccess(bridge.size())) {
            state = GameState.QUIT;
            result = "성공";
        }
        return result;
    }

    private static Integer restart(Integer tryCount) {
        if (state == GameState.RESTART) {
            route = new Route();
            tryCount++;
            state = GameState.START;
        }
        return tryCount;
    }

    private static boolean goToNextSpace(Route route) {
        String moveNext = chooseNextSpace();

        Route nextRoute = game.move(route, moveNext, bridge);
        boolean success = nextRoute.moveSuccess();
        output.printMap(route);
        return success;
    }

    private static String chooseNextSpace() {
        String moveNext = null;
        while (moveNext == null) {
            output.printMoveSpaceInputRequestMessage();
            moveNext = input.readMoving();
        }
        return moveNext;
    }

    private static void createBridge() {
        Integer bridgeSize = null;
        while (bridgeSize == null) {
            output.printBridgeLengthInputRequestMessage();
            bridgeSize = input.readBridgeSize();
        }
        bridge = maker.makeBridge(bridgeSize);
    }

    private static void chooseGameContinue(boolean success) {
        if (!success) {
            String gameCommand = null;
            while (gameCommand == null) {
                output.printChoseRetryInputRequestMessage();
                gameCommand = input.readGameCommand();
            }
            state = game.retry(gameCommand);
        }
    }
}
