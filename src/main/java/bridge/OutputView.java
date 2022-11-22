package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public static final String MESSAGE_GAME_RESULT = "최종 게임 결과";
    public static final String MESSAGE_PREFIX_GAME_RESULT = "게임 성공 여부: ";
    public static final String MESSAGE_PREFIX_ROUND_COUNT = "총 시도한 횟수: ";
    public static final String UP = "U";
    public static final String DOWN = "D";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> bridge, List<String> movingUser) {
        printMovingUserResult(bridge, movingUser, UP);
        printMovingUserResult(bridge, movingUser, DOWN);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(BridgeGame game, String result, int round) {
        System.out.println(MESSAGE_GAME_RESULT);
        printMap(game.getBridge(), game.getMovingUser());
        System.out.println(MESSAGE_PREFIX_GAME_RESULT + result);
        System.out.println(MESSAGE_PREFIX_ROUND_COUNT + round);
    }

    /**
     * 현재까지 이동한 윗다리 또는 아랫다리 상태현 정해진 형식에 맞춰 출력한다
     */
    private void printMovingUserResult(List<String> bridge, List<String> movingUser, String space) {
        System.out.print("[ ");
        for (int i = 0; i < movingUser.size(); i++) {
            if (i != 0) {
                System.out.print(" | ");
            }
            System.out.print(printMoveUserResult(bridge.get(i), movingUser.get(i), space));
        }
        System.out.println(" ]");
    }

    /**
     * 사용자가 이동한 칸에 대한 결과 출력
     */
    private String printMoveUserResult(String bridge, String moveUser, String space) {
        if (space.equals((bridge)) && space.equals(moveUser)) {
            return "O";
        }
        if (!space.equals(bridge) && space.equals(moveUser)) {
            return "X";
        }
        return " ";
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

}
