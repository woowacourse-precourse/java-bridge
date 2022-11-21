package bridge.View;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private String OorNothing(boolean print) {
        if (print) {
            return " O ";
        }
        return "   ";
    }

    private String OorX(boolean print) {
        if (print) {
            return " O ";
        }
        return " X ";
    }

    private String buildMapBeforePosition(List<String> bridge, int position, String printingLine) {
        StringBuilder output = new StringBuilder("[");
        for (int i = 0; i < position - 1; i++) {
            boolean print = bridge.get(i).equals(printingLine);
            output.append(OorNothing(print));
            output.append("|");
        }
        return output.toString();
    }

    private String buildMapLastPart(boolean printingTurn, boolean correct) {
        StringBuilder output = new StringBuilder();
        if (printingTurn) {
            output.append(OorX(correct));
            output.append("]\n");
            return output.toString();
        }
        output.append("   ]\n");
        return output.toString();
    }

    private boolean changeTurnIfWrong(boolean correct, boolean turn) {
        if (!correct) {
            turn = !turn;
        }
        return turn;
    }

    public String buildMap(List<String> bridge, int position, boolean correct) {
        StringBuilder output = new StringBuilder();
        for (String printingLine : new String[]{"U", "D"}) {
            output.append(buildMapBeforePosition(bridge, position, printingLine));
            boolean printingTurn = bridge.get(position - 1).equals(printingLine);
            printingTurn = changeTurnIfWrong(correct, printingTurn);
            output.append(buildMapLastPart(printingTurn, correct));
        }
        return output.toString();
    }

    public void printMap(List<String> bridge, int position, boolean correct) {
        System.out.println(buildMap(bridge, position, correct));
    }

    private String buildResult(List<String> bridge, int position, boolean success) {
        return "최종 게임 결과\n" +
                buildMap(bridge, position, success);
    }

    public void printResult(List<String> bridge, int position, boolean success) {
        System.out.println(buildResult(bridge, position, success));
    }

    private String buildSuccessOrFail(boolean success, int trial) {
        StringBuilder output = new StringBuilder();
        if (!success) {
            output.append("게임 성공 여부: 성공\n");
            output.append("총 시도한 횟수: ").append(trial);
        }
        output.append("게임 성공 여부: 실패\n");
        return output.toString();
    }

    public void printSuccessOrFail(boolean success, int trial) {
        System.out.println(buildSuccessOrFail(success, trial));
    }
}
