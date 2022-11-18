package bridge.controller;

import bridge.model.BridgeSize;
import bridge.view.Input;
import bridge.view.InputView;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    public void run() {

        // 사용자에게 다리길이를 입력 받는다
        Input input = new InputView();
        BridgeSize bridgeSize = null;
        do{
            try{
                bridgeSize = new BridgeSize(input.readBridgeSize());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (bridgeSize==null);




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
