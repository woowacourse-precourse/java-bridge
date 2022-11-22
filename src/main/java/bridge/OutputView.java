package bridge;

import static bridge.Constant.*;

import bridge.BridgeGame.MoveResult;
import java.util.ArrayList;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(MoveResult moveResult) {
        System.out.println(constructBridgeShape(moveResult.flag, moveResult.nowBridge));
    }

    public String constructBridgeShape(int flag, List<String> bridge) {
        List<String> up = upBridge(bridge);
        List<String> down = downBridge(bridge);
        if (flag == MOVERESULT_FLAG_INVALID) {
            checkInvalidBlock(up, down);
        }
        return MESSAGE_LEFT_BRACKET + String.join(MESSAGE_SEPARATOR, up) + MESSAGE_RIGHT_BRACKET
                + "\n" +
                MESSAGE_LEFT_BRACKET + String.join(MESSAGE_SEPARATOR, down) + MESSAGE_RIGHT_BRACKET
                + "\n";
    }

    public void checkInvalidBlock(List<String> up, List<String> down) {
        if (up.get(up.size() - 1).equals(MESSAGE_VALID_BLOCK)) {
            up.set(up.size() - 1, MESSAGE_INVALID_BLOCK);
        }
        if (down.get(down.size() - 1).equals(MESSAGE_VALID_BLOCK)) {
            down.set(down.size() - 1, MESSAGE_INVALID_BLOCK);
        }
    }

    public List<String> upBridge (List<String> bridge) {
        List<String> upper = new ArrayList<>();
        for (String item : bridge) {
            if (item.equals(MOVE_UP)) {
                upper.add(MESSAGE_VALID_BLOCK);
                continue;
            }
            upper.add(MESSAGE_BLANK_BLOCK);
        }
        return upper;
    }

    public List<String> downBridge (List<String> bridge) {
        List<String> down = new ArrayList<>();
        for (String item : bridge) {
            if (item.equals(MOVE_DOWN)) {
                down.add(MESSAGE_VALID_BLOCK);
                continue;
            }
            down.add(MESSAGE_BLANK_BLOCK);
        }
        return down;
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(int count, MoveResult gameResult) {
    }
}
