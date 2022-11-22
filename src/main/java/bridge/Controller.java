package bridge;

import bridge.domain.BridgeGame;
import bridge.util.Validation;
import bridge.util.InputView;
import bridge.util.OutputView;
import bridge.util.SystemMessage;

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
        systemMessage.start();
        int bridgeSize = getBridgeSize();
        createBridge(bridgeSize);
        run();
    }

    private int getBridgeSize() {
        int bridgeSize;
        while (true) {
            try {
                bridgeSize = inputView.readBridgeSize();
                validation.validateBridgeSize(bridgeSize);
                return bridgeSize;
            } catch (IllegalArgumentException e) {
                systemMessage.error("다리 길이는 3부터 20 사이의 숫자여야 합니다.");
            }
        }
    }

    private void createBridge(int bridgeSize) {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        bridge = bridgeMaker.makeBridge(bridgeSize);
    }

    private void run() {
        List<String> moveRecord = new ArrayList<>();
        gameCount++;
        while (moveRecord.size() < bridge.size()) {
            moveRecord.add(getMove());
            setMovingRoute(bridge, moveRecord);
            if (isContainX(movingRoute)) {
                break;
            }
        }
        result(moveRecord);
    }

    private String getMove() {
        String move = "";
        while (true) {
            try {
                move = inputView.readMoving();
                validation.validateMove(move);
                return move;
            } catch (IllegalArgumentException e) {
                systemMessage.error("이동경로는 U 또는 D여야 합니다.");
            }
        }
    }

    private void setMovingRoute(List<String> bridge, List<String> moveRecord) {
        movingRoute = bridgeGame.move(bridge, moveRecord);
        outputView.printMap(movingRoute);
    }

    private boolean isContainX(List<String> map) {
        for (String s : map) {
            if (s.contains("X")) {
                return true;
            }
        }
        return false;
    }

    public void result(List<String> moveRecord) {
        OutputView outputView = new OutputView();
        if (isContainX(movingRoute)) {
            fail();
        }
        if (bridge.size() == moveRecord.size()) {
            outputView.printResult(movingRoute, "성공", gameCount);
        }
    }

    private void fail() {
        String command = getCommand();
        if (bridgeGame.retry(command)) {
            run();
        }
        if (!bridgeGame.retry(command)) {
            outputView.printResult(movingRoute, "실패", gameCount);
        }
    }

    private String getCommand() {
        String command;
        while (true) {
            try {
                command = inputView.readGameCommand();
                validation.validateCommand(command);
                return command;
            } catch (IllegalArgumentException e) {
                systemMessage.error("재시도 여부는 R 또는 Q여야 합니다.");
            }
        }
    }
}