package bridge;

import bridge.view.InputView;
import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private static final String NOT_VALID_BRIDGE_SIZE_INPUT = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    private static final String NOT_VALID_BRIDGE_INPUT = "[ERROR] 입력은 숫자 이어야 합니다.";

    private int bridgeSize;

    private BridgeRandomNumberGenerator bridgeRandomNumberGenerator;
    private BridgeMaker bridgeMaker;
    private List<String> bridge = new ArrayList<>();

    public void setUp() {
        bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
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

    }


    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {

    }

    private void validateBridgeSize(String inputBridgeSize) {
        if (!inputBridgeSize.matches("^[0-9]*$")) {
            throw new IllegalArgumentException(NOT_VALID_BRIDGE_INPUT);
        }
        if (Integer.parseInt(inputBridgeSize) < 3 || Integer.parseInt(inputBridgeSize) > 20) {
            throw new IllegalArgumentException(NOT_VALID_BRIDGE_SIZE_INPUT);
        }
    }

    private int convertStringToInt(String bridgeSize) {
        return Integer.parseInt(bridgeSize);
    }

}
