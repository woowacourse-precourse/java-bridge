package view;

import java.util.HashMap;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String SUCCESS = "SUCCESS";
    private static final String FAIL = "FAIL";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     *
     * @param endTurn : 마지막 턴에는 "|"를 출력하지 않도록 구분하기위해 사용
     */
    public void printMap(int endTurn, List<HashMap> bridge) {
        for (HashMap bridgeSelect : bridge) {
            printBridge(endTurn, bridgeSelect);
        }
    }

    private void printBridge(int endTurn, HashMap<Integer, Boolean> bridge) {
        System.out.print(OutputStatic.START.getOutputPrint());
        for (int key : bridge.keySet()) {
            System.out.print(String.format(" %s ", convertBooleanToString(bridge.get(key))));
            if (key + 1 == endTurn) {
                continue;
            }
            System.out.print(OutputStatic.MIDDLE.getOutputPrint());
        }
        System.out.println(OutputStatic.END.getOutputPrint());
    }

    private String convertBooleanToString(Boolean convertTarget) {
        try {
            if (convertTarget) {
                return OutputStatic.TRUE_PRINT.getOutputPrint();
            }
            return OutputStatic.FALSE_PRINT.getOutputPrint();
        } catch (NullPointerException NPE) {
            return OutputStatic.SPACE_PRINT.getOutputPrint();
        }
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(int endTurn, List<HashMap> bridge, int tryCount) {
        for (HashMap bridgeSelect : bridge) {
            printOutput(endTurn, bridgeSelect, tryCount);
        }
    }

    private void printOutput(int endTurn, HashMap<Integer, Boolean> bridge, int tryCount) {
        try {
            System.out.print(OutputStatic.END_GAME.getOutputPrint());
            if (bridge.get(endTurn - 1)) {
                printGameOver(SUCCESS, tryCount);
                return;
            }
        } catch (NullPointerException NPE) {
            return;
        }
        printGameOver(FAIL, tryCount);
        return;
    }

    private void printGameOver(String check, int tryCount) {
        String test = OutputStatic.valueOf(check).getOutputPrint();
        System.out.println(test);
        System.out.println(String.format(OutputStatic.TRY_COUNT.getOutputPrint(), tryCount));
    }
}
