package bridge;

import java.util.ArrayList;
import java.util.List;

import static bridge.InputView.Ending_Enter;
import static bridge.InputView.Retry_Enter;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    public static List<String> Bridge = new ArrayList<>();
    public static int Ending_Number = 0;

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String Command, int Location) {
        if (Bridge.get(Location).equals(Command)) {
            return false;
        }
        return true;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public int retry(String Retry_Command, int Location) {
        if (Retry_Command.equals(Retry_Enter)) {
            Location--;
            return Location;
        }
        if (Retry_Command.equals(Ending_Enter)) {
            Ending_Number = 1;
        }
        return Location;
    }

    public boolean Ending() {
        if (Ending_Number == 1) {
            return false;
        }
        return true;
    }
}
