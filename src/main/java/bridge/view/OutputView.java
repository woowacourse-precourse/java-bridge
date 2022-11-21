package bridge.view;

import bridge.domain.MoveResult;
import bridge.domain.Player;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String GAME_START = "다리 건너기 게임을 시작합니다.";
    private static final String GAME_END = "최종 게임 결과";
    private static final String GAME_RESULT = "게임 성공 여부: ";
    private static final String GAME_TRY_COUNTS = "총 시도한 횟수: ";
    private static final String GAME_ERROR = "[ERROR] ";


    private static final String COMMA_SPACE = ", ";
    private static final String VERTICAL_BAR = "|";

    private OutputView() {
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printMap(Player player) {
        player.getMoveResults().values()
                .stream()
                .map(OutputView::replaceJoining)
                .forEach(System.out::println);
        System.out.println();
    }

    private static String replaceJoining(List<MoveResult> results) {
        return results.toString().replace(COMMA_SPACE, VERTICAL_BAR);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult(Player player, String gameResult) {
        System.out.println(GAME_END);
        printMap(player);
        System.out.println(GAME_RESULT + gameResult);
        System.out.print(GAME_TRY_COUNTS + player.getLifeCount());
    }

    public static void printStart() {
        System.out.println(GAME_START);
        System.out.println();
    }

    public static void printError(String errorMessage) {
        System.out.println(GAME_ERROR + errorMessage);
    }
}
