package bridge.controller;

import bridge.util.MoveResult;
import bridge.domain.Bridge;
import bridge.view.BridgeView;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 * 요구 사항 분석 :
 * BridgeGame 클래스에서 InputView, OutputView 를 사용하지 않는다.
 * <p>
 * 제공된 BridgeGame 클래스를 활용해 구현해야 한다.
 * BridgeGame에 필드(인스턴스 변수)를 추가할 수 있다.
 * BridgeGame의 패키지는 변경할 수 있다.
 * BridgeGame의 메서드의 이름은 변경할 수 없고, 인자와 반환 타입은 필요에 따라 추가하거나 변경할 수 있다.
 * 게임 진행을 위해 필요한 메서드를 추가 하거나 변경할 수 있다.
 */
public class BridgeGame {
    BridgeView view;
    Bridge domain;

    public BridgeGame(BridgeView view, Bridge domain) {
        this.view = view;
        this.domain = domain;
    }

    public void startGame() {
        view.printStartMassage();
        makeBridge();
        move();
    }

    private void makeBridge() {
        try {
            view.printBridgeSizeMessage();
            int bridgeSize = view.readBridgeSize();
            domain.makeBridge(bridgeSize);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            makeBridge();
        }
    }


    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 메서드 이름은 변경할 수 없다.
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {
        try {
            view.printMoveCommandMessage();
            String movePath = view.readMoving();

            MoveResult moveResult = domain.move(movePath);
            if (moveResult == MoveResult.MOVE_FAIL) {
                printBridge();
                retryOrEnd();
                return;
            }
            if (moveResult == MoveResult.MOVE_SUCCESS) {
                printBridge();
                move();
                return;
            }
            if (moveResult == MoveResult.PASSED_BRIDGE) {
                printBridge();
                end();
                return;
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            move();
        }
    }
    public void retryOrEnd() {
    }

    public void end() {
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 메서드 이름은 변경할 수 없다.
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        domain.initBridge();
        move();
    }
    private void printBridge() {
        List<List<String>> map = domain.getMap();
        view.printMap(map);
    }
}
