package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private Positions positions = new Positions();
    public static String game_status = "playing";

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String inputPosition, List<String> bridge, int count) {
        if (inputPosition.equals("U")) {
            if (inputPosition.equals(bridge.get(count))) {
                positions.set_UpPositions("O");
                positions.set_downPositions(" ");
            }
            if (!inputPosition.equals(bridge.get(count))) {
                positions.set_UpPositions("X");
                positions.set_downPositions(" ");
                game_status = "END";
            }
        }
        if (inputPosition.equals("D")) {
            if (inputPosition.equals(bridge.get(count))) {
                positions.set_downPositions("O");
                positions.set_UpPositions(" ");
            }
            if (!inputPosition.equals(bridge.get(count))) {
                positions.set_downPositions("X");
                positions.set_UpPositions(" ");
                game_status = "END";
            }
        }


      /*
        for (int i = 0; i < bridge.size(); i++) {
            if (!bridge.get(i).equals(position)) retry(position);
        }
*/

    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(String command) {
        if (command.equals("R")) positions = get_instance();
        if (command.equals("Q")) game_status = "End";
    }

    public Positions getPositions() {
        return positions;
    }

    public Positions get_instance() {
        return new Positions();
    }
}
