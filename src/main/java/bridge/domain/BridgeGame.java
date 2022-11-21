package bridge.domain;

import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private Bridge bridge;
    private User user;

    public BridgeGame() {
        user = new User();
    }

    public void setBridge(List<String> makeBridge){
        bridge = new Bridge(makeBridge);
    }

    public void setUser(){
        user = new User();
    }

    public User getUser() {
        return user;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String userMove) {
        user.addUserMoving(userMove);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(String restartInput) {
        if(restartInput.equals("R")){
            user.clearUserMoving();
        }
    }
}
