package bridge.view;

import java.util.List;

public class OutputView {
    static final String START_GAME = "다리 건너기 게임을 시작합니다.";
    static final String INPUT_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    static final String INPUT_MOVING = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    static final String INPUT_COMMAND = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    public void printStart() {
        System.out.println(START_GAME);
        System.out.println();
    }

    public void printInputBridgeSize() {
        System.out.println(INPUT_BRIDGE_SIZE);
    }

    public void printInputMoving() {
        System.out.println(INPUT_MOVING);
    }

    public void printInputCommand() {
        System.out.println(INPUT_COMMAND);
    }

    public void printMap(List<List<String>> bridgePattern) {
        for (List<String> row: bridgePattern) {
            System.out.println(rowFormat(row));
        }
    }

    private String rowFormat(List<String> row) {
        String joinedRow = String.join(" | ", row);
        return "[ " + joinedRow + " ]";
    }

    public void printResult() {
    }
}
