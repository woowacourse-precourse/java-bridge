package bridge.service;

import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;
import bridge.domain.BridgeMaker;
import bridge.domain.GameBoard;

import java.util.ArrayList;

import static bridge.constant.Constants.BridgeSign.*;


/**
 * 다리 건너기 게임을 관리하는 클래스
 * <p>
 * 제공된 BridgeGame 클래스를 활용해 구현해야 한다.
 * BridgeGame에 필드(인스턴스 변수)를 추가할 수 있다.
 * BridgeGame의 패키지는 변경할 수 있다.
 * BridgeGame의 메서드의 이름은 변경할 수 없고, 인자와 반환 타입은 필요에 따라 추가하거나 변경할 수 있다.
 * 게임 진행을 위해 필요한 메서드를 추가 하거나 변경할 수 있다.
 * <p>
 * ★ BridgeGame 클래스에서 InputView, OutputView 를 사용하지 않는다.
 */
public class BridgeGame {
    BridgeGameConsole console = new BridgeGameConsole();
    BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    GameBoard topGameBoard, bottomGameBoard;
    Bridge bridge = new Bridge(new ArrayList<>());
    boolean isGameLose = false;
    int tryCount = 1;


    public void start() {
        bridgeExistCheck();
        resetGame();
        startMove(bridge);

        if (isGameLose) {
            if (checkRetry()) {
                retry();
            }
        }
    }

    private void bridgeExistCheck() {
        if (bridge.isEmpty()) {
            bridge = generateBridge(bridgeMaker);
        }
    }

    public void end() {
        console.gameResult(topGameBoard, bottomGameBoard);
        console.gameStatistics(isGameLose, tryCount);
    }

    /**
     * [제공된 메서드]
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String nowBridge) {
        String movingDirection = inputMovingDirection();
        String movingResult = getMovingResult(nowBridge, movingDirection);

        checkDirection(movingDirection, movingResult);
        console.map(topGameBoard, bottomGameBoard);

        if (movingResult.equals(FAIL)) {
            isGameLose = true;
        }
    }

    private void startMove(Bridge bridge) {
        for (String nowBridge : bridge.getBridge()) {
            move(nowBridge);

            if (isGameLose) {
                break;
            }
        }
    }

    private String getMovingResult(String bridgeDirection, String direction) {
        if (direction.equals(bridgeDirection)) {
            return PASS;
        }
        return FAIL;
    }

    private void checkDirection(String movingDirection, String movingResult) {
        if (movingDirection.equals(UP)) {
            topGameBoard.addMovingResult(movingResult);
            bottomGameBoard.addMovingResult(EMPTY);
        } else if (movingDirection.equals(DOWN)) {
            bottomGameBoard.addMovingResult(movingResult);
            topGameBoard.addMovingResult(EMPTY);
        }
    }

    private boolean checkRetry() {
        boolean isRetry;

        try {
            isRetry = console.askRetry();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            isRetry = checkRetry();
        }
        return isRetry;
    }

    private String inputMovingDirection() {
        console.movementDirectionInputRequestMessage();
        String movingDirection;

        try {
            movingDirection = console.moveForward();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            movingDirection = inputMovingDirection();
        }
        return movingDirection;
    }

    private Bridge generateBridge(BridgeMaker bridgeMaker) {
        console.bridgeSizeInputRequestMessage();
        Bridge bridge;

        try {
            bridge = new Bridge(bridgeMaker.makeBridge(console.inputBridgeSize()));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            bridge = generateBridge(bridgeMaker);
        }
        return bridge;
    }

    /**
     * [제공된 메서드]
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    private void retry() {
        resetGame();
        tryCount++;
        start();
    }

    private void resetGame() {
        isGameLose = false;
        topGameBoard = new GameBoard(new ArrayList<>());
        bottomGameBoard = new GameBoard(new ArrayList<>());
    }
}
