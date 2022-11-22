package bridge.ui;

import static bridge.domain.BridgeConstants.DOWN;
import static bridge.domain.BridgeConstants.UP;
import static bridge.ui.MessageUtil.BRIDGE_SIZE_INPUT_INTRO;
import static bridge.ui.MessageUtil.CONTINUE_OR_QUIT;
import static bridge.ui.MessageUtil.FINAL_RESULT_INTRO;
import static bridge.ui.MessageUtil.POSITION_CHOICE_INPUT;
import static bridge.ui.MessageUtil.START_GAME_INTRO;

import bridge.game.GameContext;
import java.util.List;
import java.util.Map;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String MATCH = "O";
    private static final String MISS = "X";

    private static final String START_BRACKET = "[";
    private static final String END_BRACKET = "]";
    private static final String WALL = "|";

    private static final String SUCCESS_MSG = "성공";
    private static final String FAIL_MSG = "실패";

    private static final String GAME_SUCCESS = "게임 성공 여부";
    private static final String TOTAL_TRY = "총 시도한 횟수";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printTotalMap(List<Boolean> moveResult, List<String> playersMove) {
        printMap(moveResult, playersMove, UP);
        printMap(moveResult, playersMove, DOWN);
        System.out.println();
    }

    private void printMap(List<Boolean> moveResult, List<String> playersMove, String move) {
        System.out.print(START_BRACKET);
        for (int idx = 0; idx < playersMove.size(); idx++){
            printSingleResult(moveResult.get(idx), playersMove.get(idx), move);
            printWallIfNotEnd(playersMove, idx);
        }
        System.out.println(END_BRACKET);
    }

    private void printSingleResult(Boolean match, String player, String move) {
        if (player.equals(move)){
            System.out.printf(" %s ", resultMapper(match));
            return;
        }
        printEmptySpaces();
    }

    private void printEmptySpaces(){
        System.out.print("   ");
    }

    private void printWallIfNotEnd(List<String> playersMove, int idx) {
        int end = playersMove.size() - 1;
        if (idx < end) {
            System.out.print(WALL);
        }
    }

    private String resultMapper(boolean result) {
        if (result) {
            return MATCH;
        }
        return MISS;
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(GameContext context) {
        System.out.printf("%s: %s\n", GAME_SUCCESS, successMapper(context.isPlaying()));
        System.out.printf("%s: %d", TOTAL_TRY, context.getRetryCnt());
    }

    private String successMapper(boolean success){
        return Map.of(true, SUCCESS_MSG, false, FAIL_MSG).get(success);
    }

    public void printOpening() {
        System.out.println(START_GAME_INTRO.message + "\n");
    }

    public void printBrideSizeOpening() {
        System.out.println(BRIDGE_SIZE_INPUT_INTRO.message);
    }

    public void printUserChoiceOpening() {
        System.out.println(POSITION_CHOICE_INPUT.message);
    }

    public void printErrorMessage(String errorMsg) {
        System.out.println("[ERROR] " + errorMsg + "\n");
    }

    public void printGameContinueOpening() {
        System.out.println(CONTINUE_OR_QUIT.message);
    }

    public void printEmptyLine() {
        System.out.println();
    }

    public void printResultOpening() {
        System.out.println(FINAL_RESULT_INTRO.message);
    }
}
