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
        String upString = printUpString(movingIdx, bridgeList, input);
        String downString = printDownString(movingIdx, bridgeList, input);
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

    private String printUpString(int movingIdx, List<String> bridgeList, String input) {
        StringBuilder upString = new StringBuilder();
        upString.append("[");
        for (int i = 0; i < movingIdx; i++) {
            if (SameWithU(bridgeList.get(i))) upString.append(" O |");
            else if (SameWithD(bridgeList.get(i))) upString.append("   |");
        }
        upString.append(printEndedUpString(movingIdx, bridgeList, input));
        return upString.toString();
    }

    private String printEndedUpString(int movingIdx, List<String> bridgeList, String input) {
        if (Same(bridgeList.get(movingIdx), input) && SameWithU(input)) return " O ]";
        else if (!Same(bridgeList.get(movingIdx), input) && SameWithU(input)) return " X ]";
        else if (SameWithD(input)) return "   ]";
        return "";
    }

    private String printDownString(int movingIdx, List<String> bridgeList, String input) {
        StringBuilder downString = new StringBuilder();
        downString.append("[");
        for (int i = 0; i < movingIdx; i++) {
            if (SameWithD(bridgeList.get(i))) downString.append(" O |");
            else if (SameWithU(bridgeList.get(i))) downString.append("   |");
        }
        downString.append(printEndedDownString(movingIdx, bridgeList, input));
        return downString.toString();
    }

    private String printEndedDownString(int movingIdx, List<String> bridgeList, String input) {
        if (Same(bridgeList.get(movingIdx), input) && SameWithD(input)) return " O ]";
        else if (!Same(bridgeList.get(movingIdx), input) && SameWithD(input)) return " X ]";
        else if (SameWithU(input)) return "   ]";
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
        if (!Same(bridgeList.get(movingIdx), input)) System.out.println(fail);
    }

    public void printResult(int count) {
        System.out.print(countingGame + count);
    }
}
