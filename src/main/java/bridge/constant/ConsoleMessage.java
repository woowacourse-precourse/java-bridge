package bridge.constant;

import static bridge.constant.GameCommand.*;

public enum ConsoleMessage {
    START_GAME("다리 건너기 게임을 시작합니다."),
    ASK_FOR_BRIDGE_SIZE("다리 길이를 입력해주세요."),

    ASK_FOR_USER_STEP(
            String.format("이동할 칸을 선택해주세요. (위: %s, 아래: %s)",
                    USER_STEP_FOR_UPPER_LAYER.getCommand(),
                    USER_STEP_FOR_LOWER_LAYER.getCommand())
    ),

    ASK_FOR_RETRY(
            String.format("게임을 다시 시도할지 여부를 입력해주세요. (재시도: %s, 종료: %s)",
                    COMMAND_FOR_RETRY.getCommand(),
                    COMMAND_FOR_QUIT.getCommand())
    ),

    FINAL_RESULT("최종 게임 결과"),
    GAME_SUCCESS("게임 성공 여부: 성공"),
    GAME_FAIL("게임 성공 여부: 실패"),
    TOTAL_TRIALS("총 시도한 횟수: %d");

    private final String message;

    ConsoleMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
