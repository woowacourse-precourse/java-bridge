package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    final String ERROR = "[ERROR]";

    /**
     * 게임 시작 메시지를 출력한다.
     */
    public void printStartGame() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    /**
     * 다리 길이를 입력받는 메시지를 출력한다.
     */
    public void printInputBridgeSize() {
        System.out.println("\n다리의 길이를 입력해주세요.");
    }

    /**
     * 이동할 칸을 입력받는 메시지를 출력한다.
     */
    public void printInputMove() {
        System.out.println("\n이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    /**
     * 게임을 다시 시도할지 여부 메시지를 출력한다.
     */
    public void printInputRetry() {
        System.out.println("\n게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }


    /**
     * 에러 메시지를 출력한다.
     *
     * @param message 출력할 메시지
     */
    public void printErrorMessage(String message) {
        System.out.printf("%s %s\n", ERROR, message);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<List<String>> playerBridge) {
        for (int i = playerBridge.size() - 1; i >= 0; i--) {
            System.out.print("[ ");
            System.out.print(String.join(" | ", playerBridge.get(i)));
            System.out.println(" ]");
        }
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<List<String>> playerBridge, int tryCount, boolean gameWin) {
        System.out.println("\n최종 게임 결과");
        printMap(playerBridge);
        printWinOrDefeat(gameWin);
        System.out.printf("총 시도한 횟수: %d\n", tryCount);
    }

    /**
     * 게임의 성공 여부를 출력한다.
     *
     * @param gameOverResult <p>true : 성공 <p>false : 실패
     */
    public void printWinOrDefeat(boolean gameOverResult) {
        if (gameOverResult) {
            System.out.println("\n게임 성공 여부: 성공");
            return;
        }
        System.out.println("\n게임 성공 여부: 실패");
    }
}
