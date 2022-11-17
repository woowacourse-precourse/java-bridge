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

    private String printUpString(int movingIdx, List<String> bridgeList, String input) {
        StringBuilder upString = new StringBuilder();
        upString.append("[");
        for (int i = 0; i < movingIdx; i++) {
            if (Objects.equals(bridgeList.get(i), "U")) upString.append(" O |");
            else if (Objects.equals(bridgeList.get(i), "D")) upString.append("   |");
        }
        if (Objects.equals(bridgeList.get(movingIdx), input) && Objects.equals(input, "U")) upString.append(" O ]");
        else if (!Objects.equals(bridgeList.get(movingIdx), input) && Objects.equals(input, "U")) upString.append(" X ]");
        else if (Objects.equals(input, "D")) upString.append("   ]");
        return upString.toString();
    }

    private String printDownString(int movingIdx, List<String> bridgeList, String input) {
        StringBuilder downString = new StringBuilder();
        downString.append("[");
        for (int i = 0; i < movingIdx; i++) {
            if (Objects.equals(bridgeList.get(i), "D")) downString.append(" O |");
            else if (Objects.equals(bridgeList.get(i), "U")) downString.append("   |");
        }
        if (Objects.equals(bridgeList.get(movingIdx), input) && Objects.equals(input, "D")) downString.append(" O ]");
        else if (!Objects.equals(bridgeList.get(movingIdx), input) && Objects.equals(input, "D")) downString.append(" X ]");
        else if (Objects.equals(input, "U")) downString.append("   ]");
        return downString.toString();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(int movingIdx, List<String> bridgeList, String input) {
        System.out.println(gameResult);
        printMap(movingIdx, bridgeList, input);
        if (Objects.equals(bridgeList.get(movingIdx), input)) System.out.println(success);
        if (!Objects.equals(bridgeList.get(movingIdx), input)) System.out.println(fail);
    }

    public void printResult(int count) {
        System.out.print(countingGame + count);
    }
}
