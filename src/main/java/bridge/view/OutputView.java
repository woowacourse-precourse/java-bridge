package bridge.view;

import bridge.dto.MapDto;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String START_MESSAGE = "다리 건너기 게임을 시작합니다.";
    private static final String TRUE = " O ";
    private static final String FALSE = " X ";
    private static final String UP = "U";
    private static final String DOWN = "D";
    private static final String BLANK = "   ";
    private static final String DIVIDER = "|";

    public void printStart() {
        System.out.println(START_MESSAGE);
        System.out.println();
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(MapDto mapDto) {
        StringBuilder up = new StringBuilder();
        StringBuilder down = new StringBuilder();
        List<String> bridge = mapDto.getBridge();
        List<Boolean> result = mapDto.getResult();
        for (int i = 0; i < result.size(); i++) {
            up.append(makeUpMap(result.get(i), bridge.get(i)));
            down.append(makeDownMap(result.get(i), bridge.get(i)));
        }
        makeBothEnds(up, down);
        System.out.println(up);
        System.out.println(down);
        System.out.println();
    }

    private void makeBothEnds(StringBuilder up, StringBuilder down) {
        up.insert(0, "[");
        down.insert(0, "[");
        up.deleteCharAt(up.length() - 1);
        down.deleteCharAt(down.length() - 1);
        up.append("]");
        down.append("]");
    }

    private String makeUpMap(boolean result, String moving) {
        if (moving.equals(UP) && result || !moving.equals(UP) && !result) {
            return getResultMessage(result) + DIVIDER;
        }
        return BLANK + DIVIDER;
    }

    private String makeDownMap(boolean result, String moving) {
        if (moving.equals(DOWN) && result || !moving.equals(DOWN) && !result) {
            return getResultMessage(result) + DIVIDER;
        }
        return BLANK + DIVIDER;
    }

    private String getResultMessage(boolean result) {
        if (result) {
            return TRUE;
        }
        return FALSE;
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
