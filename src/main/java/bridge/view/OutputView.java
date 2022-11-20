package bridge.view;

import bridge.controller.GameController;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    public static StringBuilder first = new StringBuilder();
    public static StringBuilder second = new StringBuilder();

    public void gameStart() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println();
        System.out.println("다리의 길이를 입력해주세요.");
    }

    public void moveSpace() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    public void restart() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(int moveIndex, String moveInput, List<String> bridgeResult) {
        checkFirst(moveIndex);
        checkUp(moveIndex, moveInput, bridgeResult);
        first.append(" ]");
        second.append(" ]");
        System.out.println(first);
        System.out.println(second);
    }

    public void checkFirst(int moveIndex) {
        if (moveIndex == 0) {
            first.append("[ ");
            second.append("[ ");
            return;
        }
        first.replace(first.length() - 2, first.length(), " | ");
        second.replace(second.length() - 2, second.length(), " | ");
    }

    public void checkUp(int moveIndex, String moveInput, List<String> bridgeResult) {
        if (moveInput.equals("U")) {
            if (bridgeResult.get(moveIndex).equals("U")) {
                first.append("O");
                second.append(" ");
                return;
            }
            first.append("X");
            second.append(" ");
        }
        checkDown(moveIndex, moveInput, bridgeResult);
    }

    public void checkDown(int moveIndex, String moveInput, List<String> bridgeResult) {
        if (moveInput.equals("D")) {
            if (bridgeResult.get(moveIndex).equals("D")) {
                first.append(" ");
                second.append("O");
                return;
            }
            first.append(" ");
            second.append("X");
        }
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
        System.out.println();
        System.out.println("최종 게임 결과");
        System.out.println(first);
        System.out.println(second);
        System.out.println();
        System.out.println("게임 성공 여부: " + convertBoolean());
        System.out.println("총 시도한 횟수: " + GameController.gameCount);
    }

    public static String convertBoolean() {
        if(GameController.failOrSuccess) {
           return "성공";
        }
        return "실패";
    }

    public enum ErrorMessage {
        ERROR_NUMBER("숫자만 입력하세요."),
        ERROR_RANGE("다리 길이는 3부터 20 사이의 숫자여야 합니다."),
        ERROR_UP_DOWN("U, D 만 입력하세요."),
        ERROR_RESTART_QUIT("R, Q 만 입력하세요.");

        private final String message;

        ErrorMessage(String message) {
            this.message = message;
        }

        public String printMessage() {
            return "[ERROR] " + message;
        }
    }
}
