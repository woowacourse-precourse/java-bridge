package bridge.ui;

import bridge.Player;
import bridge.Result;

import java.util.List;

import static bridge.Constants.*;
import static bridge.message.ExceptionMessage.PREFIX;
import static bridge.message.Message.*;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final List<String> DIRECTIONS = List.of(UP, DOWN);

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(Player player) {
        DIRECTIONS.forEach(direction -> printView(player, direction));
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(Player player) {
        System.out.println(GAME_RESULT);

        DIRECTIONS.forEach(direction -> printView(player, direction));

        System.out.println(GAME_SUCCESS + player.getGameResult());
        System.out.println(GAME_COUNT + player.getPlayCount());
    }

    private void printView(Player player, String direction) {
        String view = getView(player, direction);
        System.out.println(view);
    }

    public void printExceptionMessage(IllegalArgumentException e) {
        System.out.println(PREFIX + e.getMessage());
    }

    private String getView(Player player, String direction) {
        List<Result> information = player.createMapInformation(direction);

        return getResultView(information);
    }

    private static String getResultView(List<Result> information) {
        StringBuilder builder = new StringBuilder();

        builder.append("[");
        information.stream()
                .map(Result::getView)
                .forEach(builder::append);
        builder.append("]");

        return String.valueOf(builder);
    }
}
