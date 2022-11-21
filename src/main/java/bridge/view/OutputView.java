package bridge.view;

import java.util.List;

public class OutputView {

    private static final String UP_LETTER = "U";
    private static final String DOWN_LETTER = "D";
    public String printMap(List<String> movedResult, List<String> bridge) {
        String result = "";
        StringBuilder up = UpperString(movedResult, bridge);
        StringBuilder down = LowerString(movedResult, bridge);
        result = up.toString() + "]" + System.lineSeparator() + down.toString() + "]";
        return result;
    }

    private StringBuilder UpperString (List<String> movedResult, List<String> bridge) {
        StringBuilder up = new StringBuilder("[");
        for(int idx=0; idx<movedResult.size(); idx++) {
            if (movedResult.get(idx).equals(UP_LETTER)) {
                if (movedResult.get(idx).equals(bridge.get(idx))) {
                    up.append(" O ");
                } else if (!movedResult.get(idx).equals(bridge.get(idx))) {
                    up.append(" X ");
                }
            } else if (movedResult.get(idx).equals(DOWN_LETTER)) {
                up.append("   ");
            }
            if (!(idx==(movedResult.size())-1)) {
                up.append("|");
            }
        }
        return up;
    }

    private StringBuilder LowerString (List<String> movedResult, List<String> bridge) {
        StringBuilder down = new StringBuilder("[");
        for(int idx=0; idx<movedResult.size(); idx++) {
            if (movedResult.get(idx).equals(UP_LETTER)) {
                down.append("   ");
            } else if (movedResult.get(idx).equals(DOWN_LETTER)) {
                if (movedResult.get(idx).equals(bridge.get(idx))) {
                    down.append(" O ");
                } else if (!movedResult.get(idx).equals(bridge.get(idx))) {
                    down.append(" X ");
                }
            }
            if (!(idx == (movedResult.size()) - 1)) {
                down.append("|");
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

    private void out(String text) {
        System.out.println(text);
    }
}
