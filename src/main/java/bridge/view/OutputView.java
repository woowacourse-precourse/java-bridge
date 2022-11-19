package bridge.view;

import bridge.domain.User;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String CORRECT = "O";
    private static final String FAIL = "X";
    private static final String SPACE = " ";
    private static final String BETWEEN_SPACE = " | ";
    private static final String UP = "U";
    private static final String DOWN = "D";
    private static final String START_MAP = "[ ";
    private static final String END_MAP = " ]";

    private StringBuilder upView = new StringBuilder();
    private StringBuilder downView = new StringBuilder();

    public void printError(String message) {
        System.out.println(message);
    }

    public void initMapView() {
        upView = new StringBuilder();
        downView = new StringBuilder();
    }

    public void printGameStart() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    public void printRequestBridgeSize() {
        System.out.println("\n다리의 길이를 입력해주세요.");
    }

    public void printRequestMove() {
        System.out.println("\n이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    public void printRequestRestart() {
        System.out.println("\n게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(int indexOfNow, String moveDirection, boolean isUserCorrect) {
        if (indexOfNow >= 1) {
            upView.append(BETWEEN_SPACE);
            downView.append(BETWEEN_SPACE);
        }
        appendDirection(moveDirection, isUserCorrect);
        printResultMap();
    }

    public void printResultMap() {
        System.out.println(START_MAP + upView + END_MAP);
        System.out.println(START_MAP + downView + END_MAP);
    }

    private void appendDirection(String moveDirection, boolean isUserCorrect) {
        if (moveDirection.equals(UP)) {
            appendUpView(isUserCorrect);
        }
        if (moveDirection.equals(DOWN)) {
            appendDownView(isUserCorrect);
        }
    }

    private void appendUpView(boolean isUserCorrect) {
        if (isUserCorrect) {
            upView.append(CORRECT);
        }
        if (!isUserCorrect) {
            upView.append(FAIL);
        }
        downView.append(SPACE);
    }

    private void appendDownView(boolean check) {
        if (check) {
            downView.append(CORRECT);
        }
        if (!check) {
            downView.append(FAIL);
        }
        upView.append(SPACE);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(User user) {
        System.out.println("최종 게임 결과");
        printResultMap();
        System.out.println("\n게임 성공 여부: " + getGameStatus(user.isGameWin()));
        System.out.println("총 시도한 횟수: " + user.getGameTryCount());
    }

    public String getGameStatus(boolean isSuccessGame) {
        if (isSuccessGame) {
            return "성공";
        }
        return "실패";
    }
}
