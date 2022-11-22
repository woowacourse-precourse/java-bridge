package bridge.ui.output;

import bridge.domain.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String UP = "U";
    private static final String DOWN = "D";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(Player player) {
        String upperLine = completeOutput(String.join(Components.SEPERATOR.getValue(), printSingleLine(player, UP )));
        String lowerLine = completeOutput(String.join(Components.SEPERATOR.getValue(), printSingleLine(player,DOWN)));
        System.out.println(upperLine);
        System.out.println(lowerLine);
        System.out.println();
    }

    private String completeOutput(String inner) {
        return Components.FRONT_WRAPPER + inner + Components.LAST_WRAPPER;
    }

    private List<String> printSingleLine(Player player, String line) {
        List<String> result = new ArrayList<>();
        for (String moving : player.getGameHistory()) {
            result.add(compareHistory(moving, line));
        }

        result.set(result.size()-1, addLastMoving(player.getResult(), player.getLastChoice(), line));

        return result;
    }

    private String compareHistory(String history, String line) {
        if (history.equals(line)) {
            return Components.CORRECT_CHOICE.getValue();
        }

        return Components.NON_CHOICED.getValue();
    }

    private String addLastMoving(boolean correction, String history, String line) {
        if (!history.equals(line)) {
            return Components.NON_CHOICED.getValue();
        }

        return distinguishLastAnswer(correction);
    }

    private String distinguishLastAnswer(boolean correction) {
        if (correction) {
            return Components.CORRECT_CHOICE.getValue();
        }

        return Components.WRONG_CHOICE.getValue();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(Player player, long gameCount) {
        System.out.println(Components.GAME_NOTIFICATION);
        printMap(player);
        System.out.println(Components.SUCCESS_NOTIFICATION + successOrFail(player.getResult()));
        System.out.println(Components.COUNT_NOTIFICATION.getValue() + gameCount);
    }

    private String successOrFail(boolean gameResult) {
        if (gameResult) {
            return Components.SUCCESS.getValue();
        }

        return Components.FAIL.getValue();
    }
}
