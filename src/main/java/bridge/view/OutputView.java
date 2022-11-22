package bridge.view;

import bridge.domain.GameStatus;
import bridge.domain.MapPrinter;
import bridge.domain.RepeatCount;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String GAME_START_MSG = "다리 건너기 게임을 시작합니다.";
    private static final String GAME_RESULT_MSG = "최종 게임 결과";

    public void printGameStart() {
        System.out.println(GAME_START_MSG);
        System.out.println();
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(MapPrinter mapPrinter) {
        System.out.println(mapPrinter.printMap());
        System.out.println();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(MapPrinter mapPrinter, GameStatus gameStatus, RepeatCount repeatCount) {
        System.out.println(GAME_RESULT_MSG);
        System.out.println(mapPrinter.printMap());
        System.out.println();
        System.out.println(gameStatus.getResult());
        System.out.println(repeatCount.getResult());
    }
}
