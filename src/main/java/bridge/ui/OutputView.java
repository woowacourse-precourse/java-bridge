package bridge.ui;

import bridge.domain.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String CORRECT_CHOICE = "O";
    private static final String NON_CHOICED = " ";
    private static final String WRONG_CHOICE = "X";
    private static final String FRONT_WRAPPER = "[ ";
    private static final String LAST_WRAPPER = " ]";
    private static final String DEVIDER = " | ";
    private static final String UP = "U";
    private static final String DOWN = "D";
    private static final String GAME_NOTIFICATION = "최종 게임 결과";
    private static final String SUCCESS_NOTIFICATION = "게임 성공 여부: ";
    private static final String COUNT_NOTIFICATION = "총 시도한 횟수: ";
    private static final String SUCCESS = "성공";
    private static final String FAIL = "실패";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(Player player) {
        String upperLine = FRONT_WRAPPER + String.join(DEVIDER, printSingleLine(player,UP )) + LAST_WRAPPER;
        String lowerLine = FRONT_WRAPPER + String.join(DEVIDER, printSingleLine(player,DOWN)) + LAST_WRAPPER;
        System.out.println(upperLine);
        System.out.println(lowerLine);
        System.out.println();
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
            return CORRECT_CHOICE;
        }

        return NON_CHOICED;
    }

    private String addLastMoving(boolean correction, String history, String line) {
        if (history.equals(line)) {
            return NON_CHOICED;
        }

        return distinguishLastAnswer(correction);
    }

    private String distinguishLastAnswer(boolean correction) {
        if (correction) {
            return CORRECT_CHOICE;
        }

        return WRONG_CHOICE;
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(Player player, long gameCount) {
        System.out.println(GAME_NOTIFICATION);
        printMap(player);
        System.out.println(SUCCESS_NOTIFICATION + successOrFail(player.getResult()));
        System.out.println(COUNT_NOTIFICATION + gameCount);
    }

    private String successOrFail(boolean gameResult) {
        if (gameResult) {
            return SUCCESS;
        }

        return FAIL;
    }
}
