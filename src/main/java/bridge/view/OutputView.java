package bridge.view;

import bridge.domain.GameCommand;
import bridge.domain.Moving;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap() {
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }

    public void printGameStartNotice() {
        System.out.println("다리 건너기 게임을 시작합니다.\n");
    }

    public void printBridgeSizeInputNotice() {
        System.out.println("다리의 길이를 입력해주세요.");
    }

    public void printMovingInputNotice() {
        String up = Moving.UP.getCommand();
        String Down = Moving.DOWN.getCommand();
        System.out.println("이동할 칸을 선택해주세요. (위: " + up + ", 아래: " + Down + ")");
    }

    public void printGameCommandInputNotice() {
        String restart = GameCommand.RESTART.getCommand();
        String quit = GameCommand.QUIT.getCommand();
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: " + restart + ", 종료: " + quit + ")");
    }
}
