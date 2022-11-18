package bridge.service;

import bridge.BridgeRandomNumberGenerator;
import bridge.domain.BridgeMaker;

import java.util.ArrayList;
import java.util.List;

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
    List<String> topGameBoard, bottomGameBoard;
    List<String> bridge = generateBridge(bridgeMaker);
    boolean isGameWin = true;
    int tryCount = 1;

    /**
     * 다리 게임 시작
     */
    public void start() {
        resetGame();
        startMove(bridge);

        if (isGameWin == false) {
            if (checkRetry()) {
                retry();
            }
        }
    }

    public void end(){
        console.gameResult(topGameBoard, bottomGameBoard);
        console.gameStatistics(isGameWin, tryCount);
    }

    /**
     * [제공된 메서드]
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public String move(String bridgeDirection, String direction) {
        if (direction.equals(bridgeDirection)) {
            return PASS;
        }
        return FAIL;
    }


    /**
     * 다리 길이만큼 이동 시작
     *
     * @param bridge 다리
     */
    private void startMove(List<String> bridge) {
        for (String nowBridge : bridge) {
            moveOneStep(nowBridge);
            if (isGameWin == false) {
                break;
            }
        }
    }

    /**
     * 한 걸음 이동
     *
     * @param nowBridge 이번 차례에 건널 다리 위치
     */
    private void moveOneStep(String nowBridge) {
        String movingDirection = inputMovingDirection();
        String movingResult = move(nowBridge, movingDirection);

        checkDirection(movingDirection, movingResult);
        console.map(topGameBoard, bottomGameBoard);

        if (movingResult.equals(FAIL)) {
            isGameWin = false;
        }
    }

    /**
     * GameBoard에 이동결과 추가
     *
     * @param movingDirection 입력받은 이동 방향
     * @param movingResult    이동 결과
     */
    private void checkDirection(String movingDirection, String movingResult) {
        if (movingDirection.equals(UP)) {
            topGameBoard.add(movingResult);
            bottomGameBoard.add(EMPTY);
        } else if (movingDirection.equals(DOWN)) {
            bottomGameBoard.add(movingResult);
            topGameBoard.add(EMPTY);
        }
    }

    /**
     * 재시작 체크
     */
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

    /**
     * 이동 방향 입력
     *
     * @return 입력받은 이동 방향
     */
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

    /**
     * 다리 생성
     *
     * @param bridgeMaker 다리 생성 클래스
     * @return 생성된 다리
     */
    private List<String> generateBridge(BridgeMaker bridgeMaker) {
        console.bridgeSizeInputRequestMessage();
        List<String> bridge;

        try {
            bridge = bridgeMaker.makeBridge(console.inputBridgeSize());
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

    /**
     * 게임 관련 데이터 리셋
     */
    private void resetGame() {
        isGameWin = true;
        topGameBoard = new ArrayList<>();
        bottomGameBoard = new ArrayList<>();
    }
}
