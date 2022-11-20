package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.InputView;
import bridge.view.Print;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    static int bridgeSize;

    public void setting() { //입력값받기
        Print.gameStartMessage();
        int startNumber = 1;
        while (startNumber != 0) {
            Print.requestBridgeLengthMessage();
            try {
                InputView inputView = new InputView();
                bridgeSize = inputView.readBridgeSize();
                startNumber = 0;
            } catch (IllegalArgumentException e) {
                Print.exceptionMessage(e);
                startNumber = 1;
            }
        }

    }

    public void make(){ //입력값만큼 다리 만들고 랜덤값 넣기
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

        bridgeMaker.makeBridge(bridgeSize);
        //System.out.println("bridgeSize "+ bridgeSize);

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
