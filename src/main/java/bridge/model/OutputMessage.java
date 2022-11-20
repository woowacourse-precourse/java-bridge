package bridge.model;

public enum OutputMessage {
    GAME_START_MSG("다리 건너기 게임을 시작합니다."),
    INPUT_BRIDGE_SIZE_MSG("다리의 길이를 입력해주세요."),
    INPUT_MOVE_CELL_MSG(String.format("이동할 칸을 선택해주세요. (위: %s, 아래: %s)", UserKeySet.UP, UserKeySet.DOWN)),
    RESTART_MSG(String.format("게임을 다시 시도할지 여부를 입력해주세요. (재시도: %s, 종료: %s)", UserKeySet.RETRY, UserKeySet.QUIT)),
    GAME_RESULT_MSG("최종 게임 결과"),
    GAME_TRY_RESULT_MSG("게임 성공 여부: %s\n총 시도한 횟수: %d\n");
    private final String msg;
    OutputMessage(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return msg;
    }
}
