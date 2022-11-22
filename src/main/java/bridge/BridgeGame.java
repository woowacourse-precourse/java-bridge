package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final List<String> bridge;
    private final OutputView outputView;
    private final InputView inputView;
    private int nowBridgeIndex = 0;
    private int retryCount = 0;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
        outputView = new OutputView(bridge);
        inputView = new InputView();
    }

    public void progress() {
        while (nowBridgeIndex < bridge.size()) {
            if (!move(nowBridgeIndex, inputView.getMoving()) && !retry(inputView.getGameCommand())) {
                break;
            }
        }
        end();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * @param locationIndex 이동할 다리의 인덱스 값
     * @param selectedMoving 이동할 칸 ("U" or "D")
     * @return 이동 성공 여부
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(int locationIndex, String selectedMoving) {
        nowBridgeIndex++;
        boolean result = bridge.get(locationIndex).equals(selectedMoving);
        outputView.printMap(locationIndex + 1, result, selectedMoving);

        return result;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * @param retryCommand 재시도 / 종료 입력값 ("R" or "Q")
     * @return 재시도 여부
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String retryCommand) {
        retryCount++;
        if (retryCommand.equals("R")) {
            nowBridgeIndex = 0;
            return true;
        }
        return false;
    }

    public void end() {
        outputView.printResult(isSucceed(nowBridgeIndex), retryCount);
    }

    private boolean isSucceed(int nowBridgeIndex) {
        return nowBridgeIndex == bridge.size();
    }
}
