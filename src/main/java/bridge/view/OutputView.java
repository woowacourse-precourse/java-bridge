package bridge.view;

import java.util.List;

import static bridge.Constants.*;

public class OutputView {
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
