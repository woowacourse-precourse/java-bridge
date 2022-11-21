package bridge.controller;

import bridge.domain.UserMovement;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     *
     * @param userMovement 유저 이동 정보
     * @param direction    유저 이동 방향
     */
    public void move(UserMovement userMovement, String direction) {
        userMovement.addMovement(direction);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     *
     * @param userMovement 유저 이동 정보
     * @param tryCnt       시도 횟수
     */
    public int retry(UserMovement userMovement, int tryCnt) {
        userMovement.undoMove();
        return tryCnt + 1;
    }
}
