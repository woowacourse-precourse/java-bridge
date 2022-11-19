package bridge.view;

import java.util.List;

public class OutputView {
    static final String START_GAME = "다리 건너기 게임을 시작합니다.";
    static final String INPUT_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    static final String INPUT_MOVING = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    static final String INPUT_COMMAND = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    static final String RESULT = "최종 게임 결과";
    static final String IS_SUCCESSFUL = "게임 성공 여부: ";
    static final String SUCCESS = "성공";
    static final String FAIL = "실패";
    static final String TOTAL_TRIES = "총 시도한 횟수: ";

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

    public void printMap(List<List<String>> bridgeMap) {
        for (List<String> row: bridgeMap) {
            System.out.println(rowFormat(row));
        }
    }

    public void printResult(List<List<String>> bridgeMap, boolean isSuccess, int tries) {
        System.out.println();
        System.out.println(RESULT);
        printMap(bridgeMap);

        System.out.println();
        printSuccess(isSuccess);
        printTries(tries);
    }

    private void printSuccess(boolean isSuccess) {
        System.out.print(IS_SUCCESSFUL);
        if (isSuccess) {
            System.out.println(SUCCESS);
            return;
        }
        System.out.println(FAIL);
    }

    private void printTries(int tries) {
        System.out.print(TOTAL_TRIES);
        System.out.println(tries);
    }

    private String rowFormat(List<String> row) {
        String joinedRow = String.join(" | ", row);
        return "[ " + joinedRow + " ]";
    }
}
