package bridge.domain;

import java.util.ArrayList;
import java.util.List;

import bridge.BridgeRandomNumberGenerator;
import bridge.util.BridgeNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;
import bridge.domain.BridgeMaker;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private List<String> upBridge = new ArrayList<>();
    private List<String> downBridge = new ArrayList<>();

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String correctBridge, String playerMove) {
        if(playerMove == "U") {
            upMove(correctBridge, playerMove);
        } if (playerMove == "D") {
            downMove(correctBridge, playerMove);
        }
    }

    public static List<String> makeCorrectBridge(int bridgeSize) {
        BridgeRandomNumberGenerator random = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(random);
        List<String> correctBridge = bridgeMaker.makeBridge(bridgeSize);
        return correctBridge;
    }

    private String compareCanMoveSquare(String correctBridgeSquare, String playerMove) {
        String result = "O";
        if(correctBridgeSquare != playerMove) {
            result = "X";
        }
        return result;
    }

    private void upMove(String correctBridge, String playerMove) {
        if (compareCanMoveSquare(correctBridge, playerMove) == "O") {
            upBridge.add(" O ");
            downBridge.add("   ");
        }
        if (compareCanMoveSquare(correctBridge, playerMove) == "X") {
            upBridge.add(" X ");
            downBridge.add("   ");
        }
    }

    private void downMove(String correctBridge, String playerMove){
        if (compareCanMoveSquare(correctBridge, playerMove) == "O") {
            upBridge.add("   ");
            downBridge.add(" O ");
        } if (compareCanMoveSquare(correctBridge, playerMove) == "X") {
            upBridge.add("   ");
            downBridge.add(" X ");
        }
    }

    public List<String> getUpBridge() {
        return upBridge;
    }

    public List<String> getDownBridge() {
        return downBridge;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
