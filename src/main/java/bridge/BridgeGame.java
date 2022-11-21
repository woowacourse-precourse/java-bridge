package bridge;

import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private static final String NOT_VALID_BRIDGE_SIZE_INPUT = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    private static final String NOT_INPUT = "[ERROR] 아무런 값이 입력되지 않았습니다.";
    private static final String NOT_VALID_RETRY_INPUT = "[ERROR] 입력은 Q,R 이어야 합니다.";
    private static final String NOT_VALID_BRIDGE_INPUT = "[ERROR] 입력은 숫자 이어야 합니다.";
    private static final String NOT_VALID_MOVE_INPUT = "[ERROR] 입력은 U,D 이어야 합니다.";

    private int retryCount = 1;
    private int count = 0;
    private int bridgeSize;

    private boolean playGame = true;
    private boolean loss = false;

    private BridgeRandomNumberGenerator bridgeRandomNumberGenerator;
    private BridgeMaker bridgeMaker;
    private List<String> bridge;

    public void setUp() {
        bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        OutputView.reset();
    }

    public void start() {
        System.out.printf(OutputView.START_MESSAGE);
        setUp();
        bridge();
        while (playGame) {
            move();
            if (successGame()) {
                break;
            }
            retry();
        }
        System.out.println(OutputView.printResult(successGame(), retryCount));
    }

    public void bridge() {
        while (true) {
            String inputBridgeSize = InputView.readBridgeSize();
            try {
                validateBridgeSize(inputBridgeSize);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }
            createBridge(inputBridgeSize);
            break;
        }
    }

    public void createBridge(String inputBridgeSize) {
        bridgeSize = convertStringToInt(inputBridgeSize);
        bridge = bridgeMaker.makeBridge(bridgeSize);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {
        while (count != bridgeSize && loss == false) {
            String inputMove = InputView.readMoving();
            try {
                validateMoving(inputMove);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }
            printProcessBridge(inputMove);
            processMove(inputMove);
        }

    }

    private void printProcessBridge(String inputMove) {
        System.out.println(OutputView.printMap(bridge, inputMove, count));
    }

    public void processMove(String inputMove) {
        if (!bridge.get(count).equals(inputMove)) {
            loss = true;
            count--;
        }
        count++;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        while (true) {
            String inputRetry = InputView.readGameCommand();
            try {
                validateRetry(inputRetry);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }
            playGame = checkRetry(inputRetry);
            break;
        }

    }

    private boolean checkRetry(String inputRetry) {
        if (inputRetry.equals("Q")) {
            return false;
        }
        resetScore();
        return true;
    }

    private void resetScore() {
        count = 0;
        retryCount++;
        OutputView.reset();
        loss = false;
    }

    public boolean successGame() {
        if (count == bridgeSize) {
            return true;
        }
        return false;
    }

    private void validateRetry(String inputRetry) {
        if (inputRetry == ""){
            throw new IllegalArgumentException(NOT_INPUT);
        }
        if (inputRetry.charAt(0) != 'Q' && inputRetry.charAt(0) != 'R' ) {
            throw new IllegalArgumentException(NOT_VALID_RETRY_INPUT);
        }
    }

    private void validateBridgeSize(String inputBridgeSize) {
        if (inputBridgeSize == ""){
            throw new IllegalArgumentException(NOT_INPUT);
        }
        if (!inputBridgeSize.matches("^[0-9]*$")) {
            throw new IllegalArgumentException(NOT_VALID_BRIDGE_INPUT);
        }
        if (Integer.parseInt(inputBridgeSize) < 3 || Integer.parseInt(inputBridgeSize) > 20) {
            throw new IllegalArgumentException(NOT_VALID_BRIDGE_SIZE_INPUT);
        }
    }

    private void validateMoving(String inputMove) {
        if (inputMove == ""){
            throw new IllegalArgumentException(NOT_INPUT);
        }
        if (inputMove.charAt(0) != 'U' && inputMove.charAt(0) != 'D' ) {
            throw new IllegalArgumentException(NOT_VALID_MOVE_INPUT);
        }
    }

    private int convertStringToInt(String bridgeSize) {
        return Integer.parseInt(bridgeSize);
    }

}
