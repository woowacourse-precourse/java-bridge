package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    public static String game_status = "playing";
    private boolean status;

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public String move(String inputPosition, List<String> bridge, int count) {
        status = inputPosition.equals(bridge.get(count));
        if (inputPosition.equals("U")) {
            if(inputPosition.equals(bridge.get(count))) {
                Positions.set_positions("O", " ");
                return "pass";
            }
            if (!inputPosition.equals(bridge.get(count))) {
                Positions.set_positions("X", " ");
                game_status = "END";
                return "call";
            }
        }
        if (inputPosition.equals("D")) {
            if (inputPosition.equals(bridge.get(count))) {
                Positions.set_positions(" ", "O");
                return "pass";
            }
            if (!inputPosition.equals(bridge.get(count))) {
                Positions.set_positions(" ", "X");
                game_status = "END";
                return "call";
            }
        }
        return "pass";
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public String retry(String command) {
        if (command.equals("R")) {
            Positions.reset();
            game_status = "playing";
            return "playing";
        }
        if (command.equals("Q")) {
            game_status = "End";
            return "End";
        }
        return "playing";
    }

    private void setPositions(String position, boolean status) {
        if (status && position.equals("U")) {
            Positions.set_positions("O", " ");
        }
        if (!status && position.equals("U")) {
            Positions.set_positions("X", " ");
        }
        if (status && position.equals("D")) {
            Positions.set_positions(" ", "O");
        }
        if (!status && position.equals("D")) {
            Positions.set_positions(" ", "X");
        }
    }
}





