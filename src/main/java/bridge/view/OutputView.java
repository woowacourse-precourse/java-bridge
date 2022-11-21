package bridge.view;

import bridge.game.BridgeGame;
import bridge.user.User;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String GAME_START_MESSAGE = "다리 건너기 게임을 시작합니다.\n";

    private static final String ASK_BRIDGE_SIZE_MESSAGE = "다리의 길이를 입력해주세요.";
    private static final String ASK_USER_MOVE_DIRECTION_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String ASK_GAME_COMMAND_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    private static final String ERROR_TITLE_MESSAGE = "[ERROR] ";
    private static final String ERROR_BRIDGE_SIZE_MESSAGE = "다리 길이는 3부터 20 사이의 숫자여야 합니다.\n";
    private static final String ERROR_USER_MOVE_DIRECTION_MESSAGE = "이동할 칸은 D(아래 칸) 또는 U(위 칸)여야 합니다.\n";
    private static final String ERROR_GAME_COMMAND_MESSAGE = "입력은 R(재시도) 또는 Q(종료)여야 합니다.\n";

    private static final String GAME_RESULT_TITLE_MESSAGE = "최종 게임 결과";
    private static final String GAME_RESULT_IS_GAME_SUCCEED_MESSAGE = "게임 성공 여부: ";
    private static final String GAME_RESULT_STATUS_SUCCEED_MESSAGE = "성공\n";
    private static final String GAME_RESULT_STATUS_FAILED_MESSAGE = "실패\n";
    private static final String GAME_RESULT_NUMBER_OF_GAME_TRIALS_MESSAGE = "총 시도한 횟수: ";

    private static final String BRIDGE_START = "[ ";
    private static final String BRIDGE_END = " ]";
    private static final String BRIDGE_DIVISION = " | ";
    private static final String BRIDGE_ABLE_TO_MOVE = "O";
    private static final String BRIDGE_DISABLE_TO_MOVE = "X";
    private static final String BRIDGE_NOT_CHOSEN_TO_MOVE = " ";


    public static void printGameStartMessage() {
        System.out.println(GAME_START_MESSAGE);
    }

    public static void askBridgeSize() {
        System.out.println(ASK_BRIDGE_SIZE_MESSAGE);
    }

    public static void askUserMoveDirection() {
        System.out.println(ASK_USER_MOVE_DIRECTION_MESSAGE);
    }

    public static void askGameCommand() {
        System.out.println(ASK_GAME_COMMAND_MESSAGE);
    }

    public static void printErrorMessage_bridgeSize() {
        System.out.println(ERROR_TITLE_MESSAGE + ERROR_BRIDGE_SIZE_MESSAGE);
    }

    public static void printErrorMessage_userMoveDirection() {
        System.out.println(ERROR_TITLE_MESSAGE + ERROR_USER_MOVE_DIRECTION_MESSAGE);
    }

    public static void printErrorMessage_gameCommand() {
        System.out.println(ERROR_TITLE_MESSAGE + ERROR_GAME_COMMAND_MESSAGE);
    }


    /**
     * TODO: 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     *
     * @param bridge_answer   정답 다리 List
     * @param bridge_userMove 사용자가 현재까지 다리 상에서 이동한 위치 List
     */
    public static void printMap(List<String> bridge_answer, List<String> bridge_userMove) {
        String[] map = new String[]{BRIDGE_START, BRIDGE_START}; // [0]: 아래 칸, [1]: 위 칸
        for (int i = 0; i < bridge_userMove.size(); i++) {
            String[] userFootprint = setUserFootprint(bridge_answer.get(i), bridge_userMove.get(i));
            map[BridgeGame.BridgeShape.DOWN.getIntegerValue()] += userFootprint[BridgeGame.BridgeShape.DOWN.getIntegerValue()];
            map[BridgeGame.BridgeShape.UP.getIntegerValue()] += userFootprint[BridgeGame.BridgeShape.UP.getIntegerValue()];
            setBridgeBoundary(map, (i == bridge_userMove.size() - 1));
        }
        System.out.println(map[BridgeGame.BridgeShape.UP.getIntegerValue()] + "\n" + map[BridgeGame.BridgeShape.DOWN.getIntegerValue()] + "\n");
    }

    /**
     * @param answerDirection   정답 칸의 위치
     * @param userMoveDirection 사용자가 이동한 칸의 위치
     *                          1. 사용자가 이동할 수 있는 칸을 선택했다면 footprint_userMovedToAble 호출
     *                          2. 사용자가 이동할 수 없는 칸을 선택했다면 footprint_userMovedToDisable 호출
     * @return 사용자의 다리 상에서의 발자취 - String[]{아래 칸, 위 칸}, 칸에 들어가는 값은 O 또는 X 또는 공백
     */
    private static String[] setUserFootprint(String answerDirection, String userMoveDirection) {
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
     * @param map            출력할 다리
     * @param isLastPosition 현재가 마지막 칸이라면 true / 마지막 칸이 아니라면 false
     */
    private static void setBridgeBoundary(String[] map, boolean isLastPosition) {
        if (isLastPosition) {
            map[BridgeGame.BridgeShape.DOWN.getIntegerValue()] += BRIDGE_END;
            map[BridgeGame.BridgeShape.UP.getIntegerValue()] += BRIDGE_END;
            return;
        }
        map[BridgeGame.BridgeShape.DOWN.getIntegerValue()] += BRIDGE_DIVISION;
        map[BridgeGame.BridgeShape.UP.getIntegerValue()] += BRIDGE_DIVISION;
    }


    /**
     * TODO: 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * @param player          사용자 상태값
     * @param bridge_answer   정답 다리 List
     * @param bridge_userMove 사용자가 현재까지 다리 상에서 이동한 위치 List
     */
    public static void printResult(User player, List<String> bridge_answer, List<String> bridge_userMove) {
        System.out.println(GAME_RESULT_TITLE_MESSAGE);
        printMap(bridge_answer, bridge_userMove);

        String gameResult = GAME_RESULT_IS_GAME_SUCCEED_MESSAGE;
        gameResult += setGameStatusMessage(player.getUserGameStatus());
        gameResult += GAME_RESULT_NUMBER_OF_GAME_TRIALS_MESSAGE + player.getNumberOfGameTrials();
        System.out.println(gameResult);
    }

    /**
     * @param userGameStatus 사용자의 현재 게임 상태 (1인 경우 성공 / 2인 경우 실패)
     * @return 게임 성공 또는 실패 여부에 따른 String 반환
     */
    private static String setGameStatusMessage(int userGameStatus) {
        if (userGameStatus == User.GameStatus.SUCCEED.getStatusNumber()) {
            return GAME_RESULT_STATUS_SUCCEED_MESSAGE;
        }
        return GAME_RESULT_STATUS_FAILED_MESSAGE;
    }

}
