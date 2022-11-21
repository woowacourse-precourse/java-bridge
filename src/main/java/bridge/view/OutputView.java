package bridge.view;

import java.util.List;

public class OutputView {

    private static final String UP_LETTER = "U";
    private static final String DOWN_LETTER = "D";
    public String printMap(List<String> movedResult, List<String> bridge) {
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
        return up.toString() + "]" + System.lineSeparator() + down.toString() + "]";
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
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }

}
