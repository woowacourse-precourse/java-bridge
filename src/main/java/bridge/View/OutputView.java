package bridge.View;

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
    private String printMapBeforePosition(List<String> bridge, int position, String upDown) {
        StringBuilder output = new StringBuilder();
        output.append("[");
        for (int i = 0; i < position - 1; i++) {
            String answer = bridge.get(i);
            if (answer.equals(upDown)) {
                output.append(" O ");
            } else {
                output.append("   ");
            }
            output.append("|");
        }
        return output.toString();
    }

    private String printMapNowPosition(boolean printingLine, boolean correct) {
        StringBuilder output = new StringBuilder();
        if (printingLine) {
            if (correct) {
                output.append(" O ");
            } else {
                output.append(" X ");
            }
        } else {
            output.append("   ");
        }
        output.append("]\n");
        return output.toString();
    }

    private String printResultLast(boolean printLine, boolean success) {
        StringBuilder output = new StringBuilder();
        if (printLine) {
            if (success) {
                output.append(" O ");
            } else {
                output.append(" X ");
            }
        } else {
            output.append("   ");
        }
        output.append("]\n");
        return output.toString();
    }

    public String printMapBuild(List<String> bridge, int position, boolean correct, String inputMoving) {
        StringBuilder output = new StringBuilder();
        for (String upDown : new String[]{"U", "D"}) {
            output.append(printMapBeforePosition(bridge, position, upDown));
            boolean printingLine = inputMoving.equals(upDown);
            output.append(printMapNowPosition(printingLine, correct));
        }
        return output.toString();
    }

    public String printResultBuild(List<String> bridge, int position, boolean success) {
        StringBuilder output = new StringBuilder();
        for (String upDown : new String[]{"U", "D"}) {
            output.append(printMapBeforePosition(bridge, position, upDown));
            boolean printingLine = bridge.get(position - 1).equals(upDown);
            if (!success) {
                printingLine = !printingLine;
            }
            output.append(printResultLast(printingLine, success));
        }
        return output.toString();
    }

    public void printMap(List<String> bridge, int position, boolean correct, String inputMoving) {
        System.out.println(printMapBuild(bridge, position, correct, inputMoving));
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<String> bridge, int position, boolean success, int trial) {
        System.out.println("최종 게임 결과");
        System.out.println(printResultBuild(bridge, position, success));
        if (!success) {
            System.out.println("게임 성공 여부: 실패");
        } else {
            System.out.println("게임 성공 여부: 성공");
            System.out.printf("총 시도한 횟수: %d", trial);
        }
    }
}
