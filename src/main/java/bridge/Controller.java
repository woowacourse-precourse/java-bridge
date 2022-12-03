package bridge;

import java.util.List;

public class Controller {
    private BridgeGame bridgeGame;
    private OutputView outputView;
    private static int tryNumber = 1;
    public static List<String> answerBridge;

    public void run() {
        boolean isSuccess;
        System.out.println(MessageView.START_GAME_MESSAGE);
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        answerBridge = bridgeMaker.makeBridge(getBridgeSize());
        isSuccess = moveBridgeController();
        printBridgeResult(isSuccess, tryNumber);
    }

    private int getBridgeSize() {
        InputView inputView = new InputView();
        int result;
        result = getBridgeSizeInput(inputView);
        return result;
    }

    private int getBridgeSizeInput( InputView inputView) {
        while (true) {
            System.out.println(MessageView.PRINT_BRIDGE_INPUT_MESSAGE);
            try {
                return inputView.readBridgeSize();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public boolean moveBridgeController() {
        InputView inputView = new InputView();
        boolean isSuccess;
        while (isSuccess = !moveBridge()) {
            if (!moveBridgeInput(inputView))
                break;
            tryNumber++;
        }
        return isSuccess;
    }

    private boolean moveBridgeInput(InputView inputView) {
        while (true) {
            System.out.println(MessageView.PRINT_GAME_RESTART_MESSAGE);
            try {
                return bridgeGame.retry(inputView.readGameCommand());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private boolean moveBridge() {
        InputView inputView = new InputView();
        bridgeGame = new BridgeGame();
        outputView = new OutputView();
        int addNumber = 0;
        while (addNumber++ != answerBridge.size()) {
            if (!moveBridgePrint(inputView))
                return false;
        }
        return true;
    }

    private boolean moveBridgePrint(InputView inputView) {
        while (true) {
            try {
                return moveBridgePrintInput(inputView);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    private boolean moveBridgePrintInput(InputView inputView){
        System.out.println(MessageView.PRINT_BRIDGE_MOVE_MESSAGE);
        if (bridgeGame.move(inputView.readMoving())) {
            outputView.printMap(bridgeGame.upBridge, bridgeGame.downBridge);
            return true;
        }
        outputView.printMap(bridgeGame.upBridge, bridgeGame.downBridge);
        return false;
    }

    private void printBridgeResult(boolean isSuccess, int tryNumber) {
        System.out.println(MessageView.PRINT_GAME_RESULT);
        outputView.printMap(bridgeGame.upBridge, bridgeGame.downBridge);
        outputView.printResult(isSuccess, tryNumber);
    }
}
