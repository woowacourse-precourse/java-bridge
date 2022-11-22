package bridge.View;

import java.util.List;

import static bridge.Instances.Setting.*;

public class OutputView {
    static final String START_GAME = "다리 건너기 게임을 시작합니다.";
    static final String START_MAP = "[";
    static final String END_MAP = "]";
    static final String IN_MAP_O = " O ";
    static final String IN_MAP_X = " X ";
    static final String IN_MAP_NOTHING = "   ";
    static final String IN_MAP_DISTINCTION = "|";
    static final String FINAL_RESULT = "최종 게임 결과\n";
    static final String RESULT_SUCCESS = "게임 성공 여부: 성공\n";
    static final String RESULT_FAIL = "게임 성공 여부: 실패\n";
    static final String RESULT_TRIAL = "총 시도한 횟수: ";

    public void startGame() {
        System.out.println(START_GAME);
    }

    private String OorNothing(boolean print) {
        if (print) {
            return IN_MAP_O;
        }
        return IN_MAP_NOTHING;
    }

    private String OorX(boolean print) {
        if (print) {
            return IN_MAP_O;
        }
        return IN_MAP_X;
    }

    private String buildMapBeforePosition(List<String> bridge, int position, String printingLine) {
        StringBuilder output = new StringBuilder(START_MAP);
        for (int i = 0; i < position - 1; i++) {
            boolean print = bridge.get(i).equals(printingLine);
            output.append(OorNothing(print));
            output.append(IN_MAP_DISTINCTION);
        }
        return output.toString();
    }

    private String buildMapLastPart(boolean printingTurn, boolean correct) {
        StringBuilder output = new StringBuilder();
        if (printingTurn) {
            output.append(OorX(correct));
            output.append(END_MAP + "\n");
            return output.toString();
        }
        output.append(IN_MAP_NOTHING + END_MAP + "\n");
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
        for (String printingLine : new String[]{MOVING_UP, MOVING_DOWN}) {
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

    public String buildResult(List<String> bridge, int position, boolean success) {
        return FINAL_RESULT +
                buildMap(bridge, position, success);
    }

    public void printResult(List<String> bridge, int position, boolean success) {
        System.out.println(buildResult(bridge, position, success));
    }

    public String buildSuccessOrFail(boolean success, int trial) {
        StringBuilder output = new StringBuilder();
        if (success) {
            output.append(RESULT_SUCCESS);
            output.append(RESULT_TRIAL).append(trial);
            return output.toString();
        }
        output.append(RESULT_FAIL);
        return output.toString();
    }

    public void printSuccessOrFail(boolean success, int trial) {
        System.out.println(buildSuccessOrFail(success, trial));
    }
}
