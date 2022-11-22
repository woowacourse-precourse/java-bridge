package bridge.Domain;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.util.Lists.newArrayList;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private static List<String> brige;
    private static final String Right = "O";
    private static final String Wrong = "X";
    private static final String Re = "R";
    private static final String Retry = "Retry";
    private static final String SuccessQuit = "S_Quit";
    private static final String FailuresQuit = "F_Quit";
    private static final String Move = "Move";
    private static int position = 0;

    public BridgeGame(int readBridgeSize) {
        brige = new_BridgeMaker(readBridgeSize);
    }

    private List<String> new_BridgeMaker(int readBridgeSize) {
        return new BridgeMaker().makeBridge(readBridgeSize);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public String move(String moving) {
        if (brige.get(position).matches(moving)) {
            position++;
            return Right;
        }
        return Wrong;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public String retry(String re) {
        if (re.equals(Re)) {
            position = 0;
            return Retry;
        }
        return FailuresQuit;
    }

    public String check_over() {
        if (position == brige.size())
            return SuccessQuit;
        return Move;
    }
}
