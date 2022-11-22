package bridge;

import java.util.ArrayList;
import java.util.Arrays;
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
    public void printMap(List<List<String>> result) {
        List<String> lines = new ArrayList<>(Arrays.asList("[", "["));
        for (int i = 0; i < result.size(); i++) {
            lines = constructBothLines(result.get(i), lines);
        }
        lines.set(0, lines.get(0) + "]");
        lines.set(1, lines.get(1) + "]");
        printLines(lines);
    }

    // 현재까지 이동한 다리의 상태(윗 줄, 아랫 줄) 정보 합치기
    private List<String> constructBothLines(List<String> item, List<String> lines) {
        String topLine = constructTopLine(item);
        String downLine = constructDownLine(item);

        lines.set(0, connectTop(lines, topLine));
        lines.set(1, connectDown(lines, downLine));

        return lines;
    }

    private String connectTop(List<String> lines, String topLine) {
        if (lines.get(0).equals("[")) {
            return lines.get(0) + topLine;
        }
        return lines.get(0) + "|" + topLine;
    }

    private String connectDown(List<String> lines, String downLine) {
        if (lines.get(1).equals("[")) {
            return lines.get(1) + downLine;
        }
        return lines.get(1) + "|" + downLine;
    }

    private String constructTopLine(List<String> item) {
        String topLine = "";
        if (item.get(1).equals("U")) {
            topLine += addLine(item);
            return topLine;
        }
        topLine += addBlank();
        return topLine;
    }

    private String constructDownLine(List<String> item) {
        String downLine = "";
        if (item.get(1).equals("U")) {
            downLine += addBlank();
            return downLine;
        }
        downLine += addLine(item);
        return downLine;
    }

    // 위 또는 아래줄에 빈칸 추가
    private String addBlank() {
        return "   ";
    }

    // 위 또는 아래줄에 출력 내용을 추가
    private String addLine(List<String> item) {
        return " " + item.get(0) + " ";
    }

    private void printLines(List<String> lines) {
        System.out.println(lines.get(0));
        System.out.println(lines.get(1));
        System.out.println();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<List<String>> result, String succeedMsg, int trial) {
        System.out.println("최종 게임 결과");
        printMap(result);
        System.out.println("게임 성공 여부: " + succeedMsg);
        System.out.println("총 시도한 횟수: " + trial);
    }
}
