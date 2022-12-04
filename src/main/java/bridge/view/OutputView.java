package bridge.view;

import bridge.model.GameVariable;
import bridge.model.map.Maps;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private enum ConsoleMessage {
        START_GAME("다리 건너기 게임을 시작합니다."),
        FINAL_RESULT("최종 게임 결과"),
        PRINT_IS_SUCCESS("게임 성공 여부: %s"),
        PRINT_NUMBER_OF_ATTEMPTS("총 시도한 횟수: %d");

        private final String message;

        ConsoleMessage(String message) {
            this.message = message;
        }
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(Maps maps) {
        System.out.println(maps);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(GameVariable gameVariable) {
        System.out.println(ConsoleMessage.FINAL_RESULT.message);
        printMap(gameVariable.getMaps());
        System.out.println(String.format(ConsoleMessage.PRINT_IS_SUCCESS.message, gameVariable.getGameSuccess()));
        System.out.println(
                String.format(ConsoleMessage.PRINT_NUMBER_OF_ATTEMPTS.message, gameVariable.getNumberOfAttempts()));
    }

    public void printExceptionMessage(Exception exception) {
        System.out.println(exception.getMessage());
    }

    public void printStartGame() {
        System.out.println(ConsoleMessage.START_GAME.message);
    }
}
