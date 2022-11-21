package bridge.view;

import java.util.List;
import java.util.StringJoiner;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String ERROR_MESSAGE_HEADER = "[ERROR]";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> movingStatus, boolean isSuccess) {
        StringJoiner[] bridgeInfo = new StringJoiner[2];
        bridgeInfo[0] = new StringJoiner(" | ", "[ ", " ]");
        bridgeInfo[1] = new StringJoiner(" | ", "[ ", " ]");
        for (int i = 0; i < movingStatus.size() - 1; i++) {
            bridgeInfo[getIndex(movingStatus.get(i))].add("O");
            bridgeInfo[getReverseNumber(getIndex(movingStatus.get(i)))].add(" ");
        }
        addLastStatus(bridgeInfo, movingStatus.get(movingStatus.size() - 1), isSuccess);
        System.out.println(bridgeInfo[0].toString());
        System.out.println(bridgeInfo[1].toString());
    }

    private void addLastStatus(StringJoiner[] bridgeInfo, String lastMoving, boolean isSuccess) {
        if (isSuccess) { // 마지막 이동이 성공함
            bridgeInfo[getIndex(lastMoving)].add("O");
            bridgeInfo[getReverseNumber(getIndex(lastMoving))].add(" ");
            return;
        }
        // 마지막 이동이 실패함
        bridgeInfo[getIndex(lastMoving)].add("X");
        bridgeInfo[getReverseNumber(getIndex(lastMoving))].add(" ");
    }

    private int getReverseNumber(int number) {
        if (number == 1) {
            return 0;
        }
        return 1;
    }

    private int getIndex(String command) {
        if (command.equals("U")) {
            return 0;
        }
        return 1;
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<String> movingStatus, boolean isSuccess, int attemptsCount) {
        System.out.println("최종 게임 결과");
        printMap(movingStatus, isSuccess);
        System.out.println();
        printSuccessInfo(isSuccess);
        System.out.println("총 시도한 횟수: " + attemptsCount);
    }

    private String buildBridgeStatusInfo(List<String> bridge, String location) {
        StringJoiner bridgeStatus = new StringJoiner(" | ", "[ ", " ]");
        for (String status : bridge) {
            if (status.equals(location)) {
                bridgeStatus.add("O");
                continue;
            }
            bridgeStatus.add(" ");
        }
        return bridgeStatus.toString();
    }

    private void printSuccessInfo(boolean isSuccess) {
        if (isSuccess) {
            System.out.println("게임 성공 여부: 성공");
            return;
        }
        System.out.println("게임 성공 여부: 실패");
    }

    /*
     * message로 시작하고, end로 끝나는 문자열을 출력함
     * 즉, message + end의 형태가 출력되는 것
     */
    public void printMessage(String message, String end) {
        System.out.print(message + end);
    }

    public void printErrorMessage(String message) {
        System.out.println(ERROR_MESSAGE_HEADER + " " + message);
    }
}
