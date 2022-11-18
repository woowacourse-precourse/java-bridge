package bridge.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    //TODO: 지금 사용자의 값중 뭐가 U 라인이고, D 라인인지 모른다.
    //TODO: 최종 list<String> 형태로 넘어간다 [ O, O, X, O ] -> 뭐가 뭐인지 모르는 사오
    public String move(String readMoving, String randomNumber) {
        String printBridge = "";

        if (readMoving.equals("U")) {
            if (readMoving.equals(randomNumber)) {
                printBridge = "O";
            }

            if (!(readMoving.equals(randomNumber))) {
                printBridge = "X";
            }
        }

        if (readMoving.equals("D")) {
            if (readMoving.equals(randomNumber)) {
                printBridge = "O";
            }

            if (!(readMoving.equals(randomNumber))) {
                printBridge = "X";
            }
        }

        return printBridge;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type),
     * 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {


    }
}
