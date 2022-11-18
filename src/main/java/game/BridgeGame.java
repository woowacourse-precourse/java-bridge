package game;


import bridge.BridgeDraw;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    public void isValueSame(String user, List<String> upAndDown) {
        move(user, upAndDown);
        upAndDown.set(0, upAndDown.get(0) + BridgeDraw.line.getDraw());
        upAndDown.set(1, upAndDown.get(1) + BridgeDraw.line.getDraw());
    }

    public void isValueDiff(String user, List<String> upAndDown) {
        retry(user, upAndDown);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String user, List<String> upAndDown) {
        if (user.equals("U")) {
            upAndDown.set(0, upAndDown.get(0)+ BridgeDraw.success.getDraw());
            upAndDown.set(1, upAndDown.get(1)+ BridgeDraw.none.getDraw());
        }
        if (user.equals("D")) {
            upAndDown.set(0, upAndDown.get(0)+BridgeDraw.none.getDraw());
            upAndDown.set(1, upAndDown.get(1)+BridgeDraw.success.getDraw());
        }
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(String user, List<String> upAndDown) {
        if (user.equals("U")) {
            upAndDown.set(0, upAndDown.get(0) + BridgeDraw.fail.getDraw());
            upAndDown.set(1, upAndDown.get(1) + BridgeDraw.none.getDraw());
        }
        if (user.equals("D")) {
            upAndDown.set(0, upAndDown.get(0) + BridgeDraw.none.getDraw());
            upAndDown.set(1, upAndDown.get(1) + BridgeDraw.fail.getDraw());
        }
    }

    public void reset(List<String> upAndDown) {
        upAndDown.clear();
    }
}
