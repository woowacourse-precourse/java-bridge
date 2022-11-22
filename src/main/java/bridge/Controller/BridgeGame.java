package bridge.Controller;


import bridge.Model.Bridge;
import bridge.Model.Move;
import bridge.View.OutputView;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private static final String X = "X";
    private static final String O = "O";
    static final String RETRY = "R";
    static final String QUIT = "Q";

    private final int bridgeSize;
    private final List<String> bridge;
    private List<String> currentBridge = new ArrayList<>();
    private List<String> movement;

    private int gameCount;
    private int currentLocation;
    ViewController controller;

    public BridgeGame(int bridgeSize) {
        Bridge build = new Bridge(bridgeSize);
        this.bridge = build.getBridge();
        this.bridgeSize = bridgeSize;
        this.gameCount = 1;
        this.currentLocation = 0;
    }


    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {
        while (currentLocation < bridgeSize) {
            moveOnce();
            if (movement.contains(X)) {
                break;
            }
            currentLocation++;
        }
        isSuccess();
    }

    private void moveOnce() {
        Move move = new Move(bridge.get(currentLocation));
        movement = move.getMove();
        currentBridge.addAll(movement);
        controller.printMap(currentBridge);
    }

    private void isSuccess() {
        if (currentLocation == bridgeSize) {
            controller.getPrintResult(gameCount, currentBridge, true);
        }
        isFailed();
    }


    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        ViewController input = new ViewController();
        String command = input.getCommand();
        isRetry(command);
        isQuit(command);
    }

    private void isRetry(String command) {
        if (command.equals(RETRY)) {
            gameCount++;
            currentLocation = 0;
            currentBridge = new ArrayList<>();
            move();
        }
    }

    private void isQuit(String command) {
        if (command.equals(QUIT)) {
            controller.getPrintResult(gameCount, currentBridge, false);
        }
    }

    private void isFailed() {
        if (currentLocation != bridgeSize) {
            retry();
        }
    }


}
