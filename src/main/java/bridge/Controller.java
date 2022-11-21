package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 게임을 컨트롤하는 클래스
 */
public class Controller {
    BridgeGame bridgeGame = new BridgeGame();
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    SystemMessage systemMessage = new SystemMessage();
    Validation validation = new Validation();

    private List<String> bridge = new ArrayList<>();
    private List<String> movingRoute = new ArrayList<>();
    private int gameCount = 0;

    public void start() {
        int bridgeSize = 0;
        systemMessage.start();
        bridgeSize = getBridgeSize(bridgeSize);
        createBridge(bridgeSize);
        run();
    }

    private int getBridgeSize(int bridgeSize) {
        while (true) {
            try {
                bridgeSize = inputView.readBridgeSize();
                validation.validateBridgeSize(bridgeSize);
                break;
            } catch (IllegalArgumentException e) {
                systemMessage.error("다리 길이는 3부터 20 사이의 숫자여야 합니다.");
            }
        }
        return bridgeSize;
    }

    private void createBridge(int bridgeSize) {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        bridge = bridgeMaker.makeBridge(bridgeSize);
    }

    private void run() {
        List<String> movement = new ArrayList<>();
        int inputCount = 0;
        gameCount++;
        while (inputCount < bridge.size()) {
            try {
                movement.add(getMove());
                createMovingRoute(bridge, movement);
                if (isContainX(movingRoute)) {
                    break;
                }
                inputCount++;
            } catch (IllegalArgumentException e) {
                systemMessage.error("이동경로는 U 또는 D여야 합니다.");
            }
        }
        result(inputCount);
    }

    private String getMove() throws IllegalArgumentException {
        String input = "";
        try {
            input = inputView.readMoving();
            validation.validateMove(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
        return input;
    }

    private List<String> createMovingRoute(List<String> bridge, List<String> movement) {
        movingRoute = bridgeGame.move(bridge, movement);
        outputView.printMap(movingRoute);
        return movingRoute;
    }

    private boolean isContainX(List<String> map) {
        for (String s : map) {
            if (s.contains("X")) {
                return true;
            }
        }
        return false;
    }

    public void result(int inputCount) {
        if (inputCount != bridge.size()) {
            String command = getCommand();
            if (bridgeGame.retry(command)) {
                run();
            }
        }
    }

    private String getCommand() {
        String inputCommand;
        while (true) {
            try {
                inputCommand = inputView.readGameCommand();
                validation.validateCommand(inputCommand);
                break;
            } catch (IllegalArgumentException e) {
                systemMessage.error("재시도 여부는 R 또는 Q여야 합니다.");
            }
        }
        return inputCommand;
    }
}