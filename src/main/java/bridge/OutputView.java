package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private String finalResult;
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> bridge, List<String> userPosition) {
        int size = userPosition.size() - 1;
        StringBuilder sb = new StringBuilder();
        makeUpperMap(sb, bridge, userPosition);
        sb.append("\n");
        makeLowerMap(sb, bridge, userPosition);
        finalResult = sb.toString();
        System.out.println(sb.toString());
    }

    public void makeUpperMap(StringBuilder sb, List<String> bridge, List<String> userPosition) {
        int size = userPosition.size() - 1;
        sb.append("[ ");
        for (int i = 0; i < size; i++) {
            addIsEqual(sb, bridge.get(i), "U");
            sb.append(" | ");
        }
        addUpperLast(sb, bridge.get(size), userPosition.get(size));
        sb.append(" ]");
    }

    public void addUpperLast(StringBuilder sb, String bridgeLast, String userLast) {
        if (bridgeLast.equals(userLast)) { // 정답
            if (userLast.equals("U")) sb.append("O");
            if (userLast.equals("D")) sb.append(" ");
        }
        if (!bridgeLast.equals(userLast)) { // 오답
            if (userLast.equals("U")) sb.append("X");
            if (userLast.equals("D")) sb.append(" ");
        }
    }

    public void makeLowerMap(StringBuilder sb, List<String> bridge, List<String> userPosition) {
        int size = userPosition.size() - 1;
        sb.append("[ ");
        for (int i = 0; i < size; i++) {
            addIsEqual(sb, bridge.get(i), "D");
            sb.append(" | ");
        }
        addLowerLast(sb, bridge.get(size), userPosition.get(size));
        sb.append(" ]");
    }

    public void addLowerLast(StringBuilder sb, String bridgeLast, String userLast) {
        if (bridgeLast.equals(userLast)) { // 정답
            if (userLast.equals("U")) sb.append(" ");
            if (userLast.equals("D")) sb.append("O");
        }
        if (!bridgeLast.equals(userLast)) { // 오답
            if (userLast.equals("U")) sb.append(" ");
            if (userLast.equals("D")) sb.append("X");
        }
    }

    public void addIsEqual(StringBuilder sb, String is, String equalTo) {
        if (is.equals(equalTo)) {
            sb.append("O");
            return;
        }
        sb.append(" ");
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(boolean isSuccess, int count) {
        StringBuilder stringBuilder = new StringBuilder();
        printFinalResult(stringBuilder);
        printStatistics(stringBuilder, isSuccess, count);
        System.out.println(stringBuilder);
    }

    public void printFinalResult(StringBuilder stringBuilder){
        stringBuilder.append("최종 게임 결과\n");
        stringBuilder.append(finalResult).append("\n");
    }
    public void printStatistics(StringBuilder stringBuilder ,boolean isSuccess, int count) {
        stringBuilder.append("게임 성공 여부: ");
        if (isSuccess)
            stringBuilder.append("성공");
        if (!isSuccess)
            stringBuilder.append("실패");
        stringBuilder.append("\n총 시도한 횟수: ").append(count);
    }
}
