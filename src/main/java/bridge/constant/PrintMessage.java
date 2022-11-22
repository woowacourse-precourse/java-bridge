package bridge.constant;

import java.util.stream.Stream;

public enum PrintMessage {

    START_MESSAGE("다리 건너기 게임을 시작합니다.\n"),
    INPUT_BRIDGE_SIZE("다리의 길이를 입력해주세요.\n"),
    INPUT_MOVING(String.format("이동할 칸을 선택해주세요. (위: %s, 아래: %s)\n",
            Stream.of(Moving.values()).map(Enum::toString).toArray())),
    INPUT_GAME_COMMAND(String.format("게임을 다시 시도할지 여부를 입력해주세요. (재시도: %s, 종료: %s)\n",
            Stream.of(GameCommand.values()).map(Enum::toString).toArray())),
    RESULT_MAP("최종 게임 결과"),
    RESULT_IS_SUCCESS("게임 성공 여부: %s\n"),
    RESULT_TRIALS("총 시도한 횟수: %d"),
    SUCCEED_IN_KOR("성공"),
    FAIL_IN_KOR("실패"),
    MAP_RIGHT("O"),
    MAP_WRONG("X"),
    MAP_BLANK(" "),
    MAP_FORMAT("[ %s ]\n"),
    MAP_SEPARATOR(" | ");


    private final String message;

    PrintMessage(String message) {
        this.message = message;
    }

    public String getString() {
        return message;
    }
}
