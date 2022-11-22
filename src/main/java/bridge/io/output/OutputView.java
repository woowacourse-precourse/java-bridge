package bridge.io.output;

import bridge.domain.bridgegame.GameStatus;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    public void printStartMessage() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println();
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(GameStatus gameStatus) {
        System.out.println("[ " + gameStatus.getUpBridge() + " ]");
        System.out.println("[ " + gameStatus.getDownBridge() + " ]");
        System.out.println();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(GameStatus gameStatus) {
        System.out.println("최종 게임 결과");
        System.out.println("[ " + gameStatus.getUpBridge() + " ]");
        System.out.println("[ " + gameStatus.getDownBridge() + " ]");
        System.out.println();
        System.out.printf("게임 성공 여부: %s", gameStatus.getWinOrLose());
        System.out.printf("\n총 시도한 횟수: %d", gameStatus.getGameTrialCount());
    }

    public static void printIllegalArgumentException(String message) {
        System.out.println(message);
        System.out.println();
    }
}
