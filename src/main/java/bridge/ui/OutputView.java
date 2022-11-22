package bridge.ui;

import bridge.domain.Result;
import bridge.service.BridgeGame;

public class OutputView {
    private static final String UP = "U";
    private static final String BLANK = " ";
    private static final String SEPARATOR = " | ";
    private static final String OPEN = "[ ";
    private static final String CLOSE = " ]";
    private static final String SUCCESS = "성공";
    private static final String FAIL = "실패";
    private static final String SUCCESS_UI = "O";
    private static final String FAIL_UI = "X";

    public void printMap(Result result) {
        StringBuilder first = new StringBuilder();
        StringBuilder second = new StringBuilder();
        StringBuilder union = unionMap(result, first, second);
        System.out.println(union);
        newLine();
    }

    public void printStart() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    public void printInputBridgeSize() {
        newLine();
        System.out.println("다리의 길이를 입력해 주세요.");
    }

    public void printMove() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    public void printRestart() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }

    public void printResult(BridgeGame bridgeGame) {
        System.out.println("최종 게임 결과");
        printMap(bridgeGame.recentResult());
        System.out.println("게임 성공 여부: " + changeSuccessOrFail(bridgeGame.movable()));
        System.out.println("총 시도한 횟수: " + bridgeGame.printPlayCount());
    }

    public void newLine() {
        System.out.println();
    }

    private StringBuilder unionMap(Result result, StringBuilder first, StringBuilder second) {
        openParenthesis(first, second);
        printMiddleMap(result, first, second);
        closeParenthesis(first, second);
        return new StringBuilder(first.append("\n").append(second));
    }

    private void printMiddleMap(Result result, StringBuilder first, StringBuilder second) {
        for (int i = 0; i < result.stateSize(); i++) {
            makeSeparator(first, second, i);
            if (checkUpDown(result.getInput(i))) {
                crossUpBridge(first, second, result.getState(i + 1));
                continue;
            }
            crossDownBridge(first, second, result.getState(i + 1));
        }
    }

    private void crossDownBridge(StringBuilder first, StringBuilder second, boolean state) {
        if (state) {
            first.append(BLANK);
            second.append(SUCCESS_UI);
            return;
        }
        first.append(BLANK);
        second.append(FAIL_UI);
    }

    private void crossUpBridge(StringBuilder first, StringBuilder second, boolean state) {
        if (state) {
            first.append(SUCCESS_UI);
            second.append(BLANK);
            return;
        }
        first.append(FAIL_UI);
        second.append(BLANK);
    }

    private static void makeSeparator(StringBuilder first, StringBuilder second, int index) {
        if (index != 0) {
            first.append(SEPARATOR);
            second.append(SEPARATOR);
        }
    }

    private boolean checkUpDown(String input) {
        return input.equals(UP);
    }

    private void closeParenthesis(StringBuilder first, StringBuilder second) {
        first.append(CLOSE);
        second.append(CLOSE);
    }

    private void openParenthesis(StringBuilder first, StringBuilder second) {
        first.append(OPEN);
        second.append(OPEN);
    }

    private String changeSuccessOrFail(boolean movable) {
        if (movable) {
            return SUCCESS;
        }
        return FAIL;
    }
}
