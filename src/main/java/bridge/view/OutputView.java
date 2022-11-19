package bridge.view;

import java.util.ArrayList;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String BRIDGE_START = "[";
    private static final String BRIDGE_END = "]";
    private static final String BRIDGE_BOUNDARY = "|";
    private static final String BLANK = "   ";
    private static final String CORRECT = " O ";
    private static final String WRONG = " X ";
    private static final String UP = "U";
    private static final String DOWN = "D";
    private static final String WIN = "성공";
    private static final String FAIL = "실패";

    private StringBuilder upsideBridge;
    private StringBuilder downsideBridge;

    public OutputView() {
        upsideBridge = new StringBuilder(BRIDGE_START);
        downsideBridge = new StringBuilder(BRIDGE_START);
    }
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(String selection, boolean isCorrect) {
        if (selection.equals(UP)) {
            addMap(isCorrect, upsideBridge, downsideBridge);
        }
        if (selection.equals(DOWN)) {
            addMap(isCorrect, downsideBridge, upsideBridge);
        }
        System.out.println(upsideBridge + BRIDGE_END);
        System.out.println(downsideBridge + BRIDGE_END);
        upsideBridge.append(BRIDGE_BOUNDARY);
        downsideBridge.append(BRIDGE_BOUNDARY);
    }

    private void addMap(boolean isCorrect, StringBuilder sb, StringBuilder opposite) {
        if (isCorrect) {
            sb.append(CORRECT);
            opposite.append(BLANK);
        }
        if (!isCorrect) {
            sb.append(WRONG);
            opposite.append(BLANK);
        }
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(boolean isClear, long playTime) {
        String result = FAIL;
        if (isClear) {
            result = WIN;
        }
        System.out.println(ViewConstants.GAME_END);
        System.out.println(ViewConstants.WIN_OR_FAIL + result);
        System.out.println(upsideBridge);
        System.out.println(downsideBridge);
        System.out.println(ViewConstants.PLAY_TIME + playTime);
    }

    public void printGameStart() {
        System.out.println(ViewConstants.GAME_START);
        System.out.println();
    }
}
