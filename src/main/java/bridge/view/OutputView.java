package bridge.view;

import bridge.game.BridgeGame;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String gameStartMessage = "다리 건너기 게임을 시작합니다.";
    private static final String askBridgeSizeMessage = "다리의 길이를 입력해주세요.\n";
    private static final String askUserMoveDirectionMessage = "이동할 칸을 선택해주세요. (위: U, 아래: D)\n";

    private static final String BRIDGE_START = "[ ";
    private static final String BRIDGE_END = " ]";
    private static final String BRIDGE_DIVISION = " | ";
    private static final String BRIDGE_ABLE_TO_MOVE = "O";
    private static final String BRIDGE_DISABLE_TO_MOVE = "X";
    private static final String BRIDGE_NOT_CHOSEN_TO_MOVE = " ";

    // 게임 시작 문구 출력
    public static void printGameStartMessage() {
        System.out.println(gameStartMessage);
    }

    // 다리 길이 입력 문구 출력
    public static void askBridgeSize() {
        System.out.println(askBridgeSizeMessage);
    }

    // 이동할 칸 입력 문구 출력
    public static void askUserMoveDirection() {
        System.out.println(askUserMoveDirectionMessage);
    }

    /**
     * TODO: 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     *
     * @param bridge_answer   정답 다리
     * @param bridge_userMove 사용자가 현재까지 다리 상에서 이동한 위치
     */
    public static void printMap(List<String> bridge_answer, List<String> bridge_userMove) {
        String[] map = new String[]{BRIDGE_START, BRIDGE_START}; // [0]: map_down, [1]: map_up
        for (int i = 0; i < bridge_userMove.size(); i++) {
            String[] userFootprint = getUserFootprint(bridge_answer.get(i), bridge_userMove.get(i));
            map[BridgeGame.BridgeShape.DOWN.getIntegerValue()] += userFootprint[BridgeGame.BridgeShape.DOWN.getIntegerValue()];
            map[BridgeGame.BridgeShape.UP.getIntegerValue()] += userFootprint[BridgeGame.BridgeShape.UP.getIntegerValue()];
            checkIsLastBridge(map, (i == bridge_userMove.size() - 1));
        }
        System.out.println(map[BridgeGame.BridgeShape.UP.getIntegerValue()] + "\n" + map[BridgeGame.BridgeShape.DOWN.getIntegerValue()]);
    }

    /**
     * @param answerDirection   이동할 수 있는 칸의 위치
     * @param userMoveDirection 사용자가 이동한 칸의 위치
     *                          1. 사용자가 이동할 수 있는 칸을 선택했다면 footprint_userMovedToAble 호출
     *                          2. 사용자가 이동할 수 없는 칸을 선택했다면 footprint_userMovedToDisable 호출
     * @return 사용자의 다리 상에서의 발자취 - String[]{아래 칸, 위 칸}, 칸에 들어가는 값은 O 또는 X 또는 공백
     */
    private static String[] getUserFootprint(String answerDirection, String userMoveDirection) {
        if (answerDirection.compareTo(userMoveDirection) == 0) {
            return footprint_userMovedToAble(userMoveDirection);
        }
        return footprint_userMovedToDisable(userMoveDirection);
    }

    /**
     * 사용자가 이동할 수 있는 칸을 선택한 경우
     *
     * @param userMoveDirection 사용자가 이동한 칸의 위치
     * @return String[]{아래 칸, 위 칸}, 칸에 들어가는 값은 O 또는 공백
     */
    private static String[] footprint_userMovedToAble(String userMoveDirection) {
        if (userMoveDirection.compareTo(BridgeGame.BridgeShape.DOWN.getStringValue()) == 0) {
            return new String[]{BRIDGE_ABLE_TO_MOVE, BRIDGE_NOT_CHOSEN_TO_MOVE};
        }
        return new String[]{BRIDGE_NOT_CHOSEN_TO_MOVE, BRIDGE_ABLE_TO_MOVE};
    }

    /**
     * 사용자가 이동할 수 없는 칸을 선택한 경우
     *
     * @param userMoveDirection 사용자가 이동한 칸의 위치
     * @return String[]{아래 칸, 위 칸}, 칸에 들어가는 값은 X 또는 공백
     */
    private static String[] footprint_userMovedToDisable(String userMoveDirection) {

        if (userMoveDirection.compareTo(BridgeGame.BridgeShape.DOWN.getStringValue()) == 0) {
            return new String[]{BRIDGE_DISABLE_TO_MOVE, BRIDGE_NOT_CHOSEN_TO_MOVE};
        }
        return new String[]{BRIDGE_NOT_CHOSEN_TO_MOVE, BRIDGE_DISABLE_TO_MOVE};
    }

    /**
     * 마지막 칸일 경우 다리의 끝을 명시 / 마지막 칸이 아닐 경우 다리의 구분선을 명시
     *
     * @param map          출력할 다리
     * @param isLastBridge 마지막 칸이라면 true / 마지막 칸이 아니라면 false
     */
    private static void checkIsLastBridge(String[] map, boolean isLastBridge) {
        if (isLastBridge) {
            map[BridgeGame.BridgeShape.DOWN.getIntegerValue()] += BRIDGE_END;
            map[BridgeGame.BridgeShape.UP.getIntegerValue()] += BRIDGE_END;
            return;
        }
        map[BridgeGame.BridgeShape.DOWN.getIntegerValue()] += BRIDGE_DIVISION;
        map[BridgeGame.BridgeShape.UP.getIntegerValue()] += BRIDGE_DIVISION;
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult() {
    }

}
