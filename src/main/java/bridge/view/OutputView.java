package bridge.view;

import bridge.domain.User;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private StringBuilder upView = new StringBuilder();
    private StringBuilder downView = new StringBuilder();

    public void initMapView() {
        upView = new StringBuilder();
        downView = new StringBuilder();
    }

    public void printGameStart() {
        System.out.println("다리 건너기 게임을 시작합니다.\n");
    }

    public void printRequestBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
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
            upView.append(" | ");
            downView.append(" | ");
        }
        appendDirection(moveDirection, isUserCorrect);
        printResultMap();
    }

    public void printResultMap() {
        System.out.println("[ " + upView + " ]");
        System.out.println("[ " + downView + " ]");
    }

    private void appendDirection(String moveDirection, boolean isUserCorrect) {
        if (moveDirection.equals("U")) {
            appendUpView(isUserCorrect);
        }
        if (moveDirection.equals("D")) {
            appendDownView(isUserCorrect);
        }
    }

    private void appendUpView(boolean isUserCorrect) {
        if (isUserCorrect) {
            upView.append("O");
        }
        if (!isUserCorrect) {
            upView.append("X");
        }
        downView.append(" ");
    }

    private void appendDownView(boolean check) {
        if (check) {
            downView.append("O");
        }
        if (!check) {
            downView.append("X");
        }
        upView.append(" ");
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(User user) {
        System.out.println("최종 게임 결과");
        printResultMap();
        System.out.println("\n게임 성공 여부: " + getGameStatus(user.isGameSuccess()));
        System.out.println("총 시도한 횟수: " + user.getGameTryCount());
    }

    public String getGameStatus(boolean isSuccessGame) {
        if (isSuccessGame) {
            return "성공";
        }
        return "실패";
    }
}
