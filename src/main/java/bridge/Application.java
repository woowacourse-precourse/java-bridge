package bridge;

import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final InputView input = new InputView();
    private static final OutputView output = new OutputView();
    private static final BridgeMaker maker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private static final BridgeGame game = new BridgeGame();
    
    private static List<String> bridge = new ArrayList<>();
    private static GameState state = GameState.START;
    private static int spaceNum;
    private static int bridgeSize;

    public static void main(String[] args) {
        try {
            // 게임 시작
            output.printStartMessage();
            createBridge();

            // 게임
            while(state == GameState.START || state == GameState.CORRECT || state == GameState.RESTART) {
                goToNextSpace();

                if(state == GameState.INCORRECT) {
                    chooseGameContinue();
                }

                if(spaceNum == bridgeSize && state == GameState.CORRECT) {
                    state = GameState.QUIT;
                    System.out.println("게임 성공 여부: 성공");
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.printf("[ERROR] %s", e.getMessage());
        }

        // TODO: 프로그램 구현
    }

    private static void goToNextSpace() {
        output.printMoveSpaceInputRequestMessage();
        String moveSpace = input.readMoving();
        boolean correct = game.move(moveSpace, spaceNum, bridge);
        spaceNum++;
        if(correct) {
            state = GameState.CORRECT;
            return;
        }
        state = GameState.INCORRECT;
    }

    private static void createBridge() {
        output.printBridgeLengthInputRequestMessage();

        bridgeSize = input.readBridgeSize();
        bridge = maker.makeBridge(bridgeSize);

        System.out.println(bridge.toString());
    }

    private static void chooseGameContinue() {
        output.printChoseRetryInputRequestMessage();
        String gameCommand = input.readGameCommand();
        boolean restart = game.retry(gameCommand);
        if(restart) {
            state = GameState.RESTART;
            spaceNum = 0;
            return;
        }
        state = GameState.QUIT;
    }
}
