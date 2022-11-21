package bridge;

import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class Application {
    private static final InputView input = new InputView();
    private static final OutputView output = new OutputView();
    private static final BridgeMaker maker = new BridgeMaker();
    private static final BridgeGame game = new BridgeGame();

    private static GameState state = GameState.START;
    private static List<String> bridge;


    public static void main(String[] args) {
        try {
            // 게임 시작
            output.printStartMessage();
            createBridge();

            Route route = new Route();
            while (state != GameState.QUIT) {
                goToNextSpace(route);
                state = GameState.QUIT;
            }


            // 게임
            /*
            int tryCount = 1;
            String result = "실패";
            while(state != GameState.QUIT) {
                if(state == GameState.RESTART) {
                    tryCount++;
                }

                goToNextSpace();

                if(state == GameState.INCORRECT) {
                    chooseGameContinue();
                }

                if(spaceNum == bridgeSize && state == GameState.CORRECT) {
                    state = GameState.QUIT;
                    result = "성공";
                }
            }

             */

//            output.printResult(result, tryCount);
        } catch (IllegalArgumentException e) {
            System.out.printf("[ERROR] %s", e.getMessage());
        }

    }

    private static void goToNextSpace(Route route) {
        output.printMoveSpaceInputRequestMessage();
        String moveNext = input.readMoving();

        game.move(route, moveNext, bridge);
        output.printMap(route);
    }

    private static void createBridge() {
        output.printBridgeLengthInputRequestMessage();

        int bridgeSize = input.readBridgeSize();
        bridge = maker.makeBridge(bridgeSize);

        System.out.println(bridge.toString()); // 삭제해야 함
    }

    private static void chooseGameContinue() {
        output.printChoseRetryInputRequestMessage();
        String gameCommand = input.readGameCommand();
        boolean restart = game.retry(gameCommand);
        if (restart) {
            state = GameState.RESTART;
//            spaceNum = 0;
            return;
        }
        state = GameState.QUIT;
    }
}
