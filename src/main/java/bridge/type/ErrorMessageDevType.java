package bridge.type;

public enum ErrorMessageDevType {

    BAD_BRIDGE_SIZE_MESSAGE("다리 크기가 유효하지 않습니다.: %d"),
    BAD_MAP_COMPONENT_MESSAGE("존재하지 않는 맵 구성요소가 포함되어 있습니다: %s"),
    BAD_GAME_COMMAND_MESSAGE("실패한 상태로 이동 명령어가 입력되는 버그가 발생했습니다."),
    BAD_MID_RESULT_MESSAGE("이동 명령어의 중간 결과가 일치하지 않습니다."),
    BAD_FAIL_MENU_COMMAND_REQUEST_MESSAGE("게임이 끝나지 않은 상태로 종료/재시작 명령어가 입력되는 버그가 발생했습니다.");

    private final String message;

    ErrorMessageDevType(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
