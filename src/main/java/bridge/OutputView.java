package bridge;

import java.util.List;
import java.util.Objects;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    final String gameResult = "최종 게임 결과";
    final String success = "게임 성공 여부: 성공";
    final String fail = "게임 성공 여부: 실패";
    final String countingGame = "총 시도한 횟수: ";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(int movingIdx, List<String> bridgeList, String input) {
        String upString = upString(movingIdx, bridgeList, input);
        String downString = downString(movingIdx, bridgeList, input);
        System.out.println(upString);
        System.out.println(downString);
        System.out.println();
    }

    private boolean Same(String input, String compared) {
        return Objects.equals(input, compared);
    }

    private boolean SameWithU(String input) {
        return "U".equals(input);
    }

    private boolean SameWithD(String input) {
        return "D".equals(input);
    }

    private boolean Different(String input, String compared) {
        return !Objects.equals(input, compared);
    }

    private String upString(int movingIdx, List<String> bridgeList, String input) {
        return "[" +
                middleUpString(movingIdx, bridgeList) +
                endUpString(movingIdx, bridgeList, input);
    }

    private String middleUpString(int movingIdx, List<String> bridgeList) {
        StringBuilder upString = new StringBuilder();
        for (int i = 0; i < movingIdx; i++) {
            if (SameWithU(bridgeList.get(i))) upString.append(" O |");
            else if (SameWithD(bridgeList.get(i))) upString.append("   |");
        }
        return upString.toString();
    }

    private String endUpString(int movingIdx, List<String> bridgeList, String input) {
        if (SameWithU(input)) {
            if (Same(bridgeList.get(movingIdx), input)) return " O ]";
            else if (Different(bridgeList.get(movingIdx), input)) return " X ]";
        } else if (SameWithD(input)) return "   ]";
        return "";
    }

    private String downString(int movingIdx, List<String> bridgeList, String input) {
        return "[" +
                middleDownString(movingIdx, bridgeList) +
                endDownString(movingIdx, bridgeList, input);
    }

    private String middleDownString(int movingIdx, List<String> bridgeList) {
        StringBuilder downString = new StringBuilder();
        for (int i = 0; i < movingIdx; i++) {
            if (SameWithD(bridgeList.get(i))) downString.append(" O |");
            else if (SameWithU(bridgeList.get(i))) downString.append("   |");
        }
        return downString.toString();
    }

    private String endDownString(int movingIdx, List<String> bridgeList, String input) {
        if (SameWithD(input)) {
            if (Same(bridgeList.get(movingIdx), input)) return " O ]";
            else if (Different(bridgeList.get(movingIdx), input)) return " X ]";
        } else if (SameWithU(input)) return "   ]";
        return "";
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(int movingIdx, List<String> bridgeList, String input) {
        System.out.println(gameResult);
        printMap(movingIdx, bridgeList, input);
        if (Same(bridgeList.get(movingIdx), input)) System.out.println(success);
        else if (Different(bridgeList.get(movingIdx), input)) System.out.println(fail);
    }

    public void printResult(int count) {
        System.out.print(countingGame + count);
    }
}
