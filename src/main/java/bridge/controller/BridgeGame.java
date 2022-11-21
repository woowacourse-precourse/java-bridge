package bridge.controller;

import bridge.bridge.Bridge;
import bridge.bridge.BridgeContainer;
import bridge.view.ViewContainer;

import java.util.Arrays;
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
        List<List<String>> map;

        map = bridge.makeMap();
        outputView.printMap(map);
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
        outputView.printResult(calculateResult());
    }

    private List<String> calculateResult() {
        return Arrays.asList(
                GameResult.convert(bridge.isAllSuccess()),
                String.valueOf(trial));
    }
}
