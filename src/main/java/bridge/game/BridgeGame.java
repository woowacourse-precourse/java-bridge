package bridge.game;

import bridge.bridge.Bridge;
import bridge.bridge.BridgeContainer;
import bridge.view.ViewContainer;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame implements BridgeContainer, ViewContainer, Game {

    private static final String RESTART_COMMAND = "R";

    private final Bridge bridge;
    private int trial;

    public BridgeGame() {
        outputView.printStart();
        int bridgeSize = inputView.readBridgeSize();
        bridge = generateBridge(bridgeSize);
        trial = 0;
    }

    private Bridge generateBridge(int bridgeSize) {
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        return Bridge.generate(bridge);
    }

    @Override
    public void play() {
        increaseTrial();

        while (!bridge.isEnd()) {
            move();
        }
        if (bridge.isAnyFail()) {
            retry();
        }
    }

    private void increaseTrial() {
        trial++;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     */
    @Override
    public void move() {
        moveBridge();
        showMap();
    }

    private void moveBridge() {
        String direction;

        direction = inputView.readMoving();
        bridge.move(direction);
    }

    private void showMap() {
        List<List<String>> bridgeMap;

        bridgeMap = getBridgeMap();
        outputView.printMap(bridgeMap);
    }

    private List<List<String>> getBridgeMap() {
        return bridge.makeMap();
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     */
    @Override
    public void retry() {
        String command;

        command = inputView.readGameCommand();
        if (isRetry(command)) {
            refresh();
            play();
        }
    }

    private boolean isRetry(String command) {
        return command.equals(RESTART_COMMAND);
    }

    private void refresh() {
        bridge.refresh();
    }

    @Override
    public void showResult() {
        List<List<String>> bridgeMap;

        bridgeMap = getBridgeMap();
        outputView.printResult(bridgeMap, getSuccessOrFailure(), getTrial());
    }

    private String getSuccessOrFailure() {
        return Result.convert(bridge.isAllSuccess());
    }

    private String getTrial() {
        return String.valueOf(trial);
    }
}
