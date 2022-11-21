package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final BridgeMaker bridgeMaker;
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();

    private List<String> bridge;
    private List<String> inputs;
    private GameStatus status;
    private Integer numOfTrying;

    public BridgeGame(BridgeNumberGenerator numberGenerator) {
        bridgeMaker = new BridgeMaker(numberGenerator);
        inputs = new ArrayList<>();
        status = GameStatus.PROCESSING;
        numOfTrying = 1;
    }

    /**
     * 게임을 시작하는 메서드
     */
    public void start() {
        outputView.printStartPhrases();
        makeBridge();
        loop();
        outputView.printResult(status.toString(), numOfTrying);
    }

    private void loop() {
        while (status.equals(GameStatus.PROCESSING)) {
            outputView.printAskMovingPhrases();
            String moving = inputView.readMoving();
            move(moving);
            if (status.equals(GameStatus.FAIL)) {
                retry();
            }
        }
    }

    /**
     * 게임의 사용될 다리를 생성하는 메서드
     */
    private void makeBridge() {
        outputView.printAskLengthPhrases();
        int size = inputView.readBridgeSize();
        bridge = bridgeMaker.makeBridge(size);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     *
     * @param moving 사용자가 선택한 위, 아래 입력 값
     */
    public void move(String moving) {
        inputs.add(moving);
        outputView.printMap(bridge, inputs);
        checkGameStatus();
    }

    /**
     * 사용자 입력에 따라 게임상태를 변화시킨다.
     */
    private void checkGameStatus() {
        int size = inputs.size();
        for (int i = 0; i < size; ++i) {
            if (!bridge.get(i).equals(inputs.get(i))) {
                status = GameStatus.FAIL;
                return ;
            }
        }
        if (size == bridge.size()) {
            status = GameStatus.SUCCESS;
        }
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
