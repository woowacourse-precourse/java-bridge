package constants;

public enum Output {

    START_MSG("다리 건너기 게임을 시작합니다.\n"),
    BRIDGE_SIZE_MSG("다리의 길이를 입력해주세요."),
    MOVING_MSG("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    GAME_COMMAND_MSG("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");

    private final String msg;

    Output(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
