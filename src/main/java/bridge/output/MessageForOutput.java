package bridge.output;

import bridge.gameplay.GameState;

public enum MessageForOutput {
    MAP_STARTING("["),
    MAP_ENDING("]"),
    MAP_FAIL_MARK("X"),
    MAP_SEPARATOR("|"),
    MAP_SUCCESS_MARK("O"),
    MAP_BLANK(" "),
    GAME_ENDING_HEAD("최종 게임 결과"),
    GAME_SUCCESS_STATUS("게임 성공 여부: "),
    GAME_SUCCESS("성공"),
    GAME_FAIL("실패"),
    GAME_TRY_COUNT("총 시도한 횟수: "),
    GAME_START("다리 건너기 게임을 시작합니다."),
    REQUIRE_SIZE("다리의 길이를 입력해주세요."),
    REQUIRE_WHERE_TO_MOVE("이동할 칸을 선택해주세요. "
            + "(위: " + BridgeState.UP.getBridgeMark()
            + ", 아래: " + BridgeState.DOWN.getBridgeMark() + ")"
    ),
    REQUIRE_WANT_TO_RETRY("게임을 다시 시도할지 여부를 입력해주세요. "
            + "(재시도: " + GameState.RETRY_COMMAND
            + ", 종료: " + GameState.QUIT_COMMAND + ")"
    );

    final String message;

    MessageForOutput(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
