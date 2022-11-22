package bridge.service;

import java.util.ArrayList;
import java.util.List;

public class BridgeGame {
    private static final String UP_LETTER = "U";
    private static final String DOWN_LETTER = "D";
    private static final List<String> movedResult = new ArrayList<>();
    public static String gameResult = "";
    public List<String> move(String moving) {
        movedResult.add(moving);
        return movedResult;
    }
    public String resultOfPhrase(List<String> movedResult, List<String> bridge) {
        StringBuilder up = new StringBuilder("[");
        StringBuilder down = new StringBuilder("[");
        for(int idx=0; idx<movedResult.size(); idx++){
            up = UpperString(movedResult.get(idx), bridge.get(idx), up);
            down = LowerString(movedResult.get(idx), bridge.get(idx), down);
            if (!(idx==(movedResult.size())-1)) {
                up.append("|");
                down.append("|");
            }
        }
        gameResult = up.toString() + "]" + System.lineSeparator() + down.toString() + "]";
        return gameResult;
    }

    private StringBuilder UpperString (String moving, String bridgeSpace, StringBuilder up) {
        if (moving.equals(UP_LETTER)) {
            if (moving.equals(bridgeSpace)) {
                up.append(" O ");
            } else if (!moving.equals(bridgeSpace)) {
                up.append(" X ");
            }
        } else if (moving.equals(DOWN_LETTER)) {
            up.append("   ");
        }
        return up;
    }

    private StringBuilder LowerString (String moving, String bridgeSpace, StringBuilder down) {
        if (moving.equals(UP_LETTER)) {
            down.append("   ");
        } else if (moving.equals(DOWN_LETTER)) {
            if (moving.equals(bridgeSpace)) {
                down.append(" O ");
            } else if (!moving.equals(bridgeSpace)) {
                down.append(" X ");
            }
        }
        return down;
    }
    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
