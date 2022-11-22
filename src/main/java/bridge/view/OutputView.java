package bridge.view;

import bridge.domain.Draw;
import bridge.domain.Player;
import bridge.type.DrawType;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private Draw draw = new Draw();

    public static void printInputBridgeSizeMessage() {
        System.out.println("다리의 길이를 입력해주세요.");
    }

    public static void printInputMoveMessage() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    public static void printInputGameCommandMessage() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }

    public void printStart() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(Player player, boolean isPass, int start) {
        DrawType.PASS.draw(player.currentPosition(start), isPass, draw);
        DrawType.MISS.draw(player.currentPosition(start), isPass, draw);

        System.out.printf("[ %s ]\n", String.join(" | ", draw.getUpBridges()));
        System.out.printf("[ %s ]\n\n", String.join(" | ", draw.getDownBridges()));
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(String gameStatus, int gameCount) {
        System.out.println("최종 게임 결과");
        System.out.printf("[ %s ]\n", String.join(" | ", draw.getUpBridges()));
        System.out.printf("[ %s ]\n\n", String.join(" | ", draw.getDownBridges()));
        System.out.printf("게임 성공 여부: %s\n", gameStatus);
        System.out.printf("총 시도한 횟수: %d\n", gameCount);
    }

    public void reset() {
        draw.removeAll();
    }

    public int countPassSymbol() {
        return draw.countPassSymbol();
    }
}
