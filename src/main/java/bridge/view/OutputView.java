package bridge.view;

import bridge.constants.Life;
import bridge.constants.Moving;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String START = "다리 건너기 게임을 시작합니다.";
    private static final String WRONG = "X";
    private static final String CORRECT = "O";
    private static final String SEPARATOR = " | ";
    private static final String FINAL_RESULT = "최종 게임 결과";
    private static final String SUCCESS_OR_NOT = "게임 성공 여부: ";
    private static final String SUCCESS = "성공";
    private static final String NOT = "실패";
    private static final String PLAY_COUNT = "총 시도한 횟수: ";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<Moving> movings, Life life) {
        String result = getResult(movings, life);
        StringBuilder upBridge = buildByResult(movings, result, Moving.U);
        StringBuilder downBridge = buildByResult(movings, result, Moving.D);
        setBracket(upBridge);
        setBracket(downBridge);
        System.out.println(upBridge);
        System.out.println(downBridge);
        printNewLine();
    }

    private void setBracket(StringBuilder sb) {
        sb.insert(0, "[ ");
        sb.replace(sb.length() - 2, sb.length() - 1, "]");
    }

    private StringBuilder buildByResult(List<Moving> movings, String result, Moving bridgePosition) {
        String[] splitedResult = result.split("");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < splitedResult.length; i++) {
            stringBuilder.append(strByPosition(bridgePosition, movings.get(i), splitedResult[i]));
        }
        return stringBuilder;
    }

    private String strByPosition(Moving bridgePosition, Moving moved, String result) {
        if (bridgePosition == moved) {
            return result + SEPARATOR;
        }
        return " " + SEPARATOR;
    }

    private String getResult(List<Moving> movings, Life life) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < movings.size(); i++) {
            String append = CORRECT;
            if (i == movings.size() - 1 && life == Life.DEAD) {
                append = WRONG;
            }
            sb.append(append);
        }
        return sb.toString();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<Moving> movings, Life life, int playCount) {
        System.out.println(FINAL_RESULT);
        printMap(movings, life);
        if (life == Life.SAFE) {
            System.out.println(SUCCESS_OR_NOT + SUCCESS);
        }
        if (life == Life.DEAD) {
            System.out.println(SUCCESS_OR_NOT + NOT);
        }
        System.out.println(PLAY_COUNT + playCount);
    }

    public void printStart() {
        System.out.println(START);
        printNewLine();
    }

    public void printNewLine() {
        System.out.println();
    }
}
