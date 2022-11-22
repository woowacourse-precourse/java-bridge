package bridge;

import static bridge.constant.Commands.RETRY_COMMAND;

import bridge.domain.Retry;
import bridge.repository.BridgeMoveRepository;
import bridge.service.BridgeMoveService;
import java.util.List;
import view.InputView;
import view.OutputView;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    public static final String GAME_SUCCESS = "성공";
    public static final String GAME_FAILURE = "실패";
    public static final String CANNOT_CROSS_BRIDGE = "X";

    private final List<String> bridge;
    private final BridgeMoveController bridgeMoveController;
    private int count = 0;

    public BridgeGame() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        int bridgeSize = getBridgeSize(bridgeMaker);
        this.bridge = bridgeMaker.makeBridge(bridgeSize);
        this.bridgeMoveController = new BridgeMoveController(bridgeSize, new BridgeMoveService(new BridgeMoveRepository(), bridge));
    }

    private int getBridgeSize(BridgeMaker bridgeMaker) {
        int bridgeSize = 0;
        try {
            bridgeSize = bridgeMaker.readBridgeSize();
        } catch (IllegalArgumentException e) {
            new OutputView().printException(e.getMessage());
        }
        return bridgeSize;
    }

    public void run() {
        try {
            move();
        } catch (IllegalArgumentException e) {
            new OutputView().printException(e.getMessage());
        }
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {
        String successful = GAME_SUCCESS;
        bridgeMoveController.clear();
        List<String>[] moveBridge = bridgeMoveController.run();
        count++;
        successful = checkSuccessful(successful, moveBridge);
        if (successful != null) {
            new OutputView().printResult(moveBridge, successful, count);
        }
    }

    private String checkSuccessful(String successful, List<String>[] moveBridge) {
        if (moveBridge[0].contains(CANNOT_CROSS_BRIDGE) || moveBridge[1].contains(CANNOT_CROSS_BRIDGE)) {
            successful = GAME_FAILURE;
            if (checkRetry()) {
                return null;
            }
        }
        return successful;
    }

    private boolean checkRetry() {
        Retry retry = new Retry(new InputView().readGameCommand());
        String retryCommand = retry.getRetry();
        if (retryCommand.equals(RETRY_COMMAND)) {
            retry();
            return true;
        }
        return false;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        move();
    }
}
