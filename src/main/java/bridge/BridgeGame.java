package bridge;

import bridge.ui.InputView;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private List<String> bridge;
    private int position;
    private InputView inputView;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
        this.position = 0;
        this.inputView = new InputView();
    }

    public void start(){
        this.position = 0;

        while (!isSuccessGame()) {
            move();
        }
    }

    private boolean isSuccessGame(){
        if (position == bridge.size()) {
            return true;
        }
        return false;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {
        String moving = inputView.readMoving();
        if (!isPassBridge(moving)) {
            // 실패했을 때 로직
            return;
        }
        // 성공했을 때 로직
    }

    private boolean isPassBridge(String moving){
        if(bridge.get(position).equals(moving))
            return true;
        return false;
    }

    private void passBridge(){

    }

    private void notPassBridge(){

    }


    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
