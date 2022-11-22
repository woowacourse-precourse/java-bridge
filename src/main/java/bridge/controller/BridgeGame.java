package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.CheckCrossBridge;
import bridge.view.InputView;
import bridge.view.View;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    static int bridgeSize;
    static String userInput;
    static List<String> bridge;
    static int round;
    InputView inputView = new InputView();

    public void setGame() {
        View.gameStartMessage();
        int retryCheckNumber = 1;

        while (retryCheckNumber != 0) {
            View.requestBridgeLengthMessage();
            try {
                InputView inputView = new InputView();
                bridgeSize = inputView.readBridgeSize();
                retryCheckNumber = 0;
            } catch (IllegalArgumentException e) {
                View.exceptionMessage(e);
                retryCheckNumber = 1;
            }
        }
    }

    /* 입력값만큼 다리를 만들고 랜덤값 넣기 */
    public void make() {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

        bridge = bridgeMaker.makeBridge(bridgeSize);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {

        int retryCheckNumber = 1;
        round = 0;

        while (retryCheckNumber != 0) {
            View.requestPickAPartOfBridgeMessage();
            try {
                userInput = inputView.readMoving();
                retryCheckNumber = 0;
                round++;
                System.out.println(round);
            } catch (IllegalArgumentException e) {
                View.exceptionMessage(e);
                retryCheckNumber = 1;
            }
        }
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }

    /* 사용자가 선택한 칸이 건널 수 있는 칸인지 확인하는 메서드 */
    public void check() {
        CheckCrossBridge checkCrossBridge = new CheckCrossBridge();
        boolean crossPossible = checkCrossBridge.check(userInput, bridge, round);
        if (!crossPossible) {
            System.out.println("못건너");
        }
        if (crossPossible) {
            System.out.println("건널 수 있어");
        }
    }
}
