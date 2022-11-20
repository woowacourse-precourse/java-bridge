package bridge.Service;

import bridge.Model.GameResult;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    //TODO: BridgeGame 클래스에서 InputView, OutputView 를 사용하지 않는다.
    //TODO: 필드 추가 가능, 인자와 반환타입 변경 가능, 그러나 메서드 이름 변경 금지
    private static final String SUCCESS = GameResult.SUCCESS.getResult();
    private static final String FAIL = GameResult.FAIL.getResult();

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public int move(int progress) {
        progress += 1;

        return progress;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }

    public void isCleared() {
        //게임을 모두 클리어했는지 판별한다.
    }

    public boolean isCrossable(String currentResult) {
        if (currentResult.equals(SUCCESS)) {
            return true;
        }
        return false;
    }
}
