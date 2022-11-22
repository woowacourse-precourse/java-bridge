package bridge.view;

import bridge.domain.Game;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String RIGHT = "O";
    private static final String WRONG = "X";
    private static final String SPACE = " ";
    private static final String DIVIDING_LINE = " | ";
    private static final String UP = "U";
    private static final String DOWN = "D";
    private static final String START = "[ ";
    private static final String END = " ]";

    private StringBuilder upView = new StringBuilder();
    private StringBuilder downView = new StringBuilder();

    public void initView() {
        upView = new StringBuilder();
        downView = new StringBuilder();
    }

    public void printBridgeGameStartMessage() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    public void printInputBridgeLengthMessage() {
        System.out.println("\n다리의 길이를 입력해주세요.");
    }

    public void printInputUserMoveMessage() {
        System.out.println("\n이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    public void printInputGameRestartOptionMessage() {
        System.out.println("\n게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printNowMap(int nowIndex, String moveDirection, boolean isSameValueComputerAndUser) {
        if (nowIndex >= 1) {
            upView.append(DIVIDING_LINE);
            downView.append(DIVIDING_LINE);
        }
        appendDirection(moveDirection, isSameValueComputerAndUser);
        printResultMap();
    }

    public void printResultMap() {
        System.out.println(START + upView + END);
        System.out.println(START + downView + END);
    }

    private void appendDirection(String moveDirection, boolean isSameValueComputerAndUser) {
        if (moveDirection.equals(UP)) {
            appendUpView(isSameValueComputerAndUser);
        }
        if (moveDirection.equals(DOWN)) {
            appendDownView(isSameValueComputerAndUser);
        }
    }

    private void appendUpView(boolean isSameValueComputerAndUser) {
        if (checkUpAnswer(isSameValueComputerAndUser)) {
            upView.append(RIGHT);
            downView.append(SPACE);
            return;
        }
        upView.append(WRONG);
        downView.append(SPACE);
    }

    private void appendDownView(boolean isSameValueComputerAndUser) {
        if(checkDownAnswer(isSameValueComputerAndUser)) {
            downView.append(RIGHT);
            upView.append(SPACE);
            return;
        }
        downView.append(WRONG);
        upView.append(SPACE);

    }

    private boolean checkDownAnswer(boolean isSameValueComputerAndUser) {
        if(isSameValueComputerAndUser) return true;
        return false;
    }

    private boolean checkUpAnswer(boolean isSameValueComputerAndUser) {
        if(isSameValueComputerAndUser) return true;
        return false;
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */

    public void printFinalResult(Game game) {
        System.out.println("최종 게임 결과");
        printResultMap();
        System.out.println("\n게임 성공 여부: " + getGameStatus(game.isWinGame()));
        System.out.println("총 시도한 횟수: " + game.getGameCount());
    }

    public String getGameStatus(boolean isSuccessGame) {
        if (isSuccessGame) {
            return "성공";
        }
        return "실패";
    }


}
