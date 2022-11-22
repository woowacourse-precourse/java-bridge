package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(BridgeGame bridgeGame) {
        System.out.print(printPrefix());
        getUpPrint(bridgeGame.getBridge(), bridgeGame.getUsersMove());
        System.out.println(printPostfix());

        System.out.print(printPrefix());
        getDownPrint(bridgeGame.getBridge(), bridgeGame.getUsersMove());
        System.out.println(printPostfix());
        System.out.println();
    }

    private void getDownPrint(List<String> bridge, List<String> usersMove) {
        for (int idx = 0; idx < usersMove.size(); idx++) {
            if (printBlank(usersMove, idx, "D")) continue;
            if (printO(bridge, usersMove, idx)) continue;
            printX(idx);
        }
    }

    private void getUpPrint(List<String> bridge, List<String> usersMove) {
        for (int idx = 0; idx < usersMove.size(); idx++) {
            if (printBlank(usersMove, idx, "U")) continue;
            if (printO(bridge, usersMove, idx)) continue;
            printX(idx);
        }
    }

    private boolean printBlank(List<String> usersMove, int idx, String inputString) {
        if (!(usersMove.get(idx).equals(inputString))) {
            if (idx != 0) {
                System.out.print(printBar());
            }
            System.out.print(printAllBlank());
            return true;
        }
        return false;
    }

    private void printX(int idx) {
        if (idx != 0) {
            System.out.print(printBar());
        }
        System.out.print(printNotCorrect());
    }

    private boolean printO(List<String> bridge, List<String> usersMove, int idx) {
        if (bridge.get(idx).equals(usersMove.get(idx))) {
            if (idx != 0) {
                System.out.print(printBar());
            }
            System.out.print(printCorrect());
            return true;
        }
        return false;
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(BridgeGame bridgeGame) {
        System.out.println(Message.IS_GAME_SUCCESSFUL + isSuccess(bridgeGame.isSuccessOrFailure()));
        System.out.println(Message.TOTAL_NUMBER_OF_ATTEMPTS + bridgeGame.getCnt());
    }

    public String isSuccess(boolean flag) {
        if (flag) return printSuccess();
        return printFailure();
    }

    private String printFailure() {
        return "실패";
    }

    private String printSuccess() {
        return "성공";
    }

    private String printPostfix() {
        return "]";
    }

    private String printPrefix() {
        return "[";
    }

    private String printBar() {
        return "|";
    }

    private String printAllBlank() {
        return "   ";
    }

    private String printNotCorrect() {
        return " X ";
    }

    private String printCorrect() {
        return " O ";
    }
}