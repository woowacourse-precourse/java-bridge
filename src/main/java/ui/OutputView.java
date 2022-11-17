package ui;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private final String GAME_START_MESSAGE = "다리 건너기 게임을 시작합니다.";
    private final String PROMPT_BRIDGE_LENGTH = "다리의 길이를 입력해주세요.";
    private final String PROMPT_USER_MOVE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private final String GAME_RESTART_OR_END = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private final String GAME_SUCCESS_RESULT = "게임 성공 여부: ";
    // 게임 성공, 실패는 ENUM으로 관리하도록 고려할 것.
    private final Map<Boolean, String> GAME_RESULT = Map.of(true, "성공",
            false, "실패");
    private final String GAME_TRY = "총 시도한 횟수: ";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<List<Integer>> map) {
        for (int firstBlock : map.get(0)) {
            printBlock(firstBlock);
        }
        System.out.println();
        for (int secondBlock : map.get(1)) {
            printBlock(secondBlock);
        }
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(final boolean result) {
        System.out.println(GAME_RESULT.get(result));
    }

    private void printBlock(final int index) {
        System.out.print(Block.getMessage(index));
    }

    public void printGameStartMessage() {
        System.out.println(GAME_START_MESSAGE);
    }

    public void printPromptBridgeLength() {
        System.out.println(PROMPT_BRIDGE_LENGTH);
    }

    public void printPromptMoving() {
        System.out.println(PROMPT_USER_MOVE);
    }

    public void printGameRestartOrEndMessage() {
        System.out.println(GAME_RESTART_OR_END);
    }

    public void printGameSuccessResultMessage() {
        System.out.println(GAME_SUCCESS_RESULT);
    }

    public void printGameTryResultMessage() {
        System.out.println(GAME_TRY);
    }
}
