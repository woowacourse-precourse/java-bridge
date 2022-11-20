package bridge;

import java.util.List;
import java.util.Map;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private StringBuilder sb;

    public void printStart() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<Map<String, Boolean>> getMove) {
        sb = new StringBuilder();
        upOutput(getMove);
        downOutput(getMove);
        if (getMove.size() > 1) {
            replaceAll(sb, "][", "|");
        }
        System.out.println(sb);
    }

    public void upOutput(List<Map<String, Boolean>> getMove) {
        for (int i = 0; i < getMove.size(); i++) {
            String s = crossCheck("U", getMove, i);
            sb.append("[ ").append(s).append(" ]");
        }
        sb.append("\n");
    }

    public void downOutput(List<Map<String, Boolean>> getMove) {
        for (int i = 0; i < getMove.size(); i++) {
            String s = crossCheck("D", getMove, i);
            sb.append("[ ").append(s).append(" ]");
        }
        sb.append("\n");
    }

    private String crossCheck(String input, List<Map<String, Boolean>> getMove, int i) {
        if (!getMove.get(i).containsKey(input)) {
            return " ";
        }
        return crossOX(getMove.get(i).get(input));
    }

    private String crossOX(Boolean in) {
        if (in) {
            return "O";
        }
        return "X";
    }

    public void replaceAll(StringBuilder builder, String from, String to) {
        int index = builder.indexOf(from);
        while (index != -1) {
            builder.replace(index, index + from.length(), to);
            index += to.length();
            index = builder.indexOf(from, index);
        }
    }


    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(int count, boolean successOrNot) {
        System.out.println("최종 게임 결과");
        System.out.println(sb);
        System.out.printf("게임 성공 여부: %s\n", successOrNotCheck(successOrNot));
        System.out.printf("총 시도한 횟수: %d\n", count);
    }

    public String successOrNotCheck(boolean successOrNot) {
        if (successOrNot) {
            return "성공";
        }
        return "실패";
    }
}
