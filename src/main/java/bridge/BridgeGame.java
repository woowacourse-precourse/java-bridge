package bridge;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static bridge.utils.constant.Constant.*;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    public final List<List<String>> bridges;
    public final List<String> bridgeUp;
    public final List<String> bridgeDown;

    public BridgeGame() {
        this.bridges = new ArrayList<>();
        this.bridgeUp = new ArrayList<>();
        this.bridgeDown = new ArrayList<>();
        bridges.add(bridgeUp);
        bridges.add(bridgeDown);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String direction, String answer) {
        String result = addOorX(direction, answer);
        if(direction.equals(UP.getValue())) {
            bridgeUp.add(result);
            bridgeDown.add(BLANK.getValue());
            return;
        }
        bridgeUp.add(BLANK.getValue());
        bridgeDown.add(result);
    }

    public String addOorX(String direction, String answer) {
        if(direction.equals(answer)) {
            return O.getValue();
        }
        return X.getValue();
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public int retry(int attempt, String quit) {
        if(Objects.equals(quit, RESTART.getValue())) {
            attempt++;
            return attempt;
        }
        if(quit.equals(QUIT.getValue())) {
            return attempt;
        }
        throw new IllegalArgumentException("Q나 R을 입력해라");
    }

    public List<List<String>> getBridges() {
        return bridges;
    }
}
