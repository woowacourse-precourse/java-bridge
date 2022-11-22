package bridge;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static BridgeGame bridgeGame;
    private static InputView inputView;
    private static OutputView outputView;
    private static BridgeMaker bridgeMaker;

    public static void main(String[] args) {
        init();
        while (bridgeGame.isRun()) {
            Boolean success = move();
            if (!success) {
                command();
            }
            isClear();
        }
        outputView.printResult(bridgeGame.getMoveRecord(),
                bridgeGame.getTotalTry(), bridgeGame.isClear());
    }

    private static void init() {
        inputView = new InputView();
        outputView = new OutputView();
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = makeBridge();
        bridgeGame = new BridgeGame(bridge);
        bridgeGame.init();
    }

    private static List<String> makeBridge() {
        outputView.printStart();
        try {
            outputView.printBridgeSizeInput();
            List<String> bridge = bridgeMaker.makeBridge(inputView.readBridgeSize());
            return bridge;
        } catch (IllegalArgumentException illegalArgumentException) {
            outputView.printError("다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
        return new ArrayList<>();
    }

    private static Boolean move() {
        try {
            outputView.printMoveInput();
            Boolean success = bridgeGame.move(inputView.readMoving());
            outputView.printMap(bridgeGame.getMoveRecord());
            return success;
        } catch (IllegalArgumentException illegalArgumentException) {
            outputView.printError("움직임은 U, D만 입력할 수 있습니다.");
        }
        return false;
    }

    private static void command() {
        try {
            outputView.printCommandInput();
            String command = inputView.readGameCommand();
            bridgeGame.command(command);
        } catch (IllegalArgumentException illegalArgumentException) {
            outputView.printError("커맨드는 R, Q만 입력할 수 있습니다.");
        }
    }

    private static void isClear() {
        if (bridgeGame.isClear()) {
            bridgeGame.exit();
        }
    }
}
