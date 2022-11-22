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


    public static void main(String[] args) {
        try {
            // 게임 시작
            output.printStartMessage();
            createBridge();

            Route route = new Route();
            int tryCount = 1;
            String result = "실패";
            while (state != GameState.QUIT) {

                if(state == GameState.RESTART) {
                    route = new Route();
                    tryCount++;
                    state = GameState.START;
                }

                boolean success = goToNextSpace(route);

                if(!success) {
                    chooseGameContinue();
                }

                if(route.gameSuccess(bridge.size())) {
                    result = "성공";
                    state = GameState.QUIT;
                }

                if(state == GameState.QUIT) {
                    output.printFinalResult(route);
                }
            }

            output.printResult(result, tryCount);
        } catch (IllegalArgumentException e) {
            System.out.printf("[ERROR] %s", e.getMessage());
        }

    }

    private static boolean goToNextSpace(Route route) {
        output.printMoveSpaceInputRequestMessage();
        String moveNext = input.readMoving();

        Route nextRoute = game.move(route, moveNext, bridge);
        boolean success = nextRoute.moveSuccess();
        output.printMap(route);
        return success;
    }

    private static void createBridge() {
        output.printBridgeLengthInputRequestMessage();

        int bridgeSize = input.readBridgeSize();
        bridge = maker.makeBridge(bridgeSize);
    }

    private static void chooseGameContinue() {
        output.printChoseRetryInputRequestMessage();
        String gameCommand = input.readGameCommand();

        state = game.retry(gameCommand);
    }
}
