package bridge.domain;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private Status status;

    public BridgeGame() {
        status = Status.PROCEEDING;
    }

    public Status getStatus() {
        return status;
    }

    /**
    * 생성된 다리와 사용자의 입력을 비교해 게임의 상태를 변경한다.
    * */
    public void changeStatus(List<String> bridge, List<String> userMoving) {
        for (int index = 0; index < userMoving.size(); index++) {
            String bridgeValue = bridge.get(index);
            String userValue = userMoving.get(index);

            if (!bridgeValue.equals(userValue)) {
                status = Status.FAIL;
                return;
            }
        }

        if (bridge.size() == userMoving.size()) {
            status = Status.SUCCESS;
        }
    }

    public boolean isProceeding() {
        return status.isProceeding();
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
}
