package bridge.controller;

import bridge.constant.GameProgressKeyword;
import bridge.domain.Bridge;
import bridge.domain.User;

/**
 * 다리 건너기 게임을 관리하는 클래스
 * BridgeGame에 필드(인스턴스 변수)를 추가할 수 있다.
 * BridgeGame의 패키지는 변경할 수 있다.
 * BridgeGame의 메서드의 이름은 변경할 수 없고, 인자와 반환 타입은 필요에 따라 추가하거나 변경할 수 있다.
 * 게임 진행을 위해 필요한 메서드를 추가 하거나 변경할 수 있다.
 */
public class BridgeGame {
    private Bridge bridge;
    private User user;

    public BridgeGame(int size) {
        this.bridge = new Bridge(size);
        this.user = new User();
    }

    public Bridge getBridge() {
        return bridge;
    }

    public User getUser() {
        return user;
    }

    public boolean isSuccess() {
        return user.getIsSuccess();
    }

    public void setSuccess() {
        user.setIsSuccess(true);
    }

    public int getSize() {
        return bridge.getSize();
    }

    public String getIndexResult(int index) {
        return bridge.getIndexResult(index);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String input) {
        user.addSelect(input);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        user.resetSelect();
        user.tryAgain();
    }
}
